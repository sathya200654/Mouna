/**
 * Mouna - Manifest V3 Background Service Worker
 * Manages central extension state, syncs settings across tabs,
 * handles extension badge indicators, and brokers messaging between popup and content scripts.
 */

const DEFAULT_STATE = {
  isActive: false,
  selectedLanguage: 'en',
  speed: 1.0,
  overlayVisible: true,
  audioSource: 'mic', // 'mic' | 'tab' | 'text'
  latestTranscript: '',
  signingStatus: 'idle' // 'idle' | 'listening' | 'signing' | 'error'
};

// Initialize default state in storage upon installation
chrome.runtime.onInstalled.addListener(async (details) => {
  console.log('[Mouna Service Worker] Extension installed/updated:', details.reason);
  const existing = await chrome.storage.local.get(Object.keys(DEFAULT_STATE));
  const merged = { ...DEFAULT_STATE, ...existing };
  await chrome.storage.local.set(merged);
  updateBadge(merged.isActive);
});

// Update Chrome extension icon badge based on active status
function updateBadge(isActive) {
  if (isActive) {
    chrome.action.setBadgeText({ text: 'ON' });
    chrome.action.setBadgeBackgroundColor({ color: '#00C853' }); // Bright accessibility green
  } else {
    chrome.action.setBadgeText({ text: '' });
  }
}

// Broadcast message to content scripts across all open tabs
async function broadcastToAllTabs(message) {
  try {
    const tabs = await chrome.tabs.query({});
    for (const tab of tabs) {
      if (tab.id) {
        chrome.tabs.sendMessage(tab.id, message).catch(() => {});
      }
    }
  } catch (err) {
    console.warn('[Mouna Service Worker] Error broadcasting to tabs:', err);
  }
}

// Handle runtime messages from Popup and Content Scripts
chrome.runtime.onMessage.addListener((request, sender, sendResponse) => {
  const { action, payload } = request;

  if (action === 'GET_STATE') {
    chrome.storage.local.get(null).then((data) => {
      sendResponse({ status: 'ok', state: { ...DEFAULT_STATE, ...data } });
    });
    return true; // asynchronous response
  }

  if (action === 'SET_STATE') {
    chrome.storage.local.set(payload).then(async () => {
      const allData = await chrome.storage.local.get(null);
      if (typeof payload.isActive !== 'undefined') {
        updateBadge(payload.isActive);
      }
      // Broadcast state update to tabs
      broadcastToAllTabs({ action: 'STATE_CHANGED', payload: allData });
      sendResponse({ status: 'ok', state: allData });
    });
    return true;
  }

  if (action === 'TOGGLE_ACTIVE') {
    chrome.storage.local.get(['isActive']).then(async (data) => {
      const nextActive = !data.isActive;
      await chrome.storage.local.set({ isActive: nextActive });
      updateBadge(nextActive);
      const allData = await chrome.storage.local.get(null);
      broadcastToAllTabs({ action: 'STATE_CHANGED', payload: allData });
      sendResponse({ status: 'ok', isActive: nextActive, state: allData });
    });
    return true;
  }

  if (action === 'SEND_TEXT_FOR_SIGNING') {
    // Forward manual or synthetic text to content script overlay
    broadcastToAllTabs({ action: 'SIGN_TEXT', payload });
    sendResponse({ status: 'ok' });
    return false;
  }

  if (action === 'TRANSCRIPT_BROADCAST') {
    // Content script detected speech, save latest snippet & notify popup if open
    chrome.storage.local.set({ latestTranscript: payload.transcript || '' });
    sendResponse({ status: 'ok' });
    return false;
  }

  if (action === 'STATUS_BROADCAST') {
    chrome.storage.local.set({ signingStatus: payload.status || 'idle' });
    sendResponse({ status: 'ok' });
    return false;
  }
});
