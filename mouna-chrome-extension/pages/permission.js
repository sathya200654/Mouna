/**
 * Mouna - One-Click Microphone Permission Handler
 * Regular tab context allows Chrome to display the native "Allow" microphone permission dialog.
 */

document.addEventListener('DOMContentLoaded', () => {
  const grantBtn = document.getElementById('grant-btn');
  const statusEl = document.getElementById('status');

  async function requestMic() {
    statusEl.textContent = 'Requesting Chrome microphone permission...';
    try {
      const stream = await navigator.mediaDevices.getUserMedia({ audio: true });
      // Release stream immediately
      stream.getTracks().forEach(t => t.stop());

      statusEl.textContent = 'Microphone access granted! Returning to Mouna...';
      statusEl.classList.add('success');

      // Notify service worker and popup
      try {
        await chrome.storage.local.set({ micPermissionGranted: true });
        chrome.runtime.sendMessage({ action: 'MIC_PERMISSION_GRANTED' });
      } catch (e) {}

      setTimeout(() => {
        window.close();
      }, 900);
    } catch (err) {
      console.warn('Microphone permission error:', err);
      statusEl.textContent = 'Permission denied or dismissed. Please click the button above to retry.';
      statusEl.style.color = '#EF4444';
    }
  }

  grantBtn.addEventListener('click', () => {
    requestMic();
  });

  // Attempt auto-request on load
  setTimeout(requestMic, 300);
});
