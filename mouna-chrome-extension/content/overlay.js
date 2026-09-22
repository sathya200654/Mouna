/**
 * Mouna - In-Page Draggable & Resizable Accessibility Overlay UI Component
 * Provides real-time 3D ISL avatar visualization directly inside webpages, meetings, and video streams.
 */

class MounaOverlay {
  constructor() {
    this.root = null;
    this.canvas = null;
    this.isDragging = false;
    this.isResizing = false;
    this.dragStartX = 0;
    this.dragStartY = 0;
    this.elementStartX = 0;
    this.elementStartY = 0;
    this.elementStartWidth = 0;
    this.elementStartHeight = 0;
    this.isMinimized = false;
    this.isActive = false;
    this.currentLanguage = 'en';
    this.currentSpeed = 1.0;

    // Callbacks
    this.onLanguageChange = null;
    this.onSpeedChange = null;
    this.onTogglePower = null;
    this.onSendText = null;
    this.onClose = null;

    this.speeds = [0.8, 1.0, 1.25, 1.5];
  }

  /**
   * Mounts the overlay DOM element into the page
   */
  mount() {
    if (document.getElementById('mouna-overlay-root')) {
      this.root = document.getElementById('mouna-overlay-root');
      this.canvas = this.root.querySelector('#mouna-avatar-canvas');
      return;
    }

    this.root = document.createElement('div');
    this.root.id = 'mouna-overlay-root';
    this.root.innerHTML = this._template();

    document.body.appendChild(this.root);
    this.canvas = this.root.querySelector('#mouna-avatar-canvas');

    this._bindEvents();
  }

  _template() {
    return `
      <!-- Header -->
      <div class="mouna-header-bar" id="mouna-header">
        <div class="mouna-header-left">
          <div class="mouna-brand-icon">M</div>
          <div class="mouna-header-title">
            <span class="mouna-app-name">MAUNA ISL</span>
            <div class="mouna-sub-status">
              <span class="mouna-status-dot" id="mouna-status-dot"></span>
              <span id="mouna-status-text">Standby</span>
            </div>
          </div>
        </div>
        <div class="mouna-header-controls">
          <button class="mouna-icon-btn" id="mouna-speed-btn" title="Sign Speed: 1.0x" aria-label="Sign Speed">1.0x</button>
          <button class="mouna-icon-btn" id="mouna-drawer-toggle" title="Toggle Manual Text Input" aria-label="Manual Input">⌨</button>
          <button class="mouna-icon-btn" id="mouna-minimize-btn" title="Minimize to Orb" aria-label="Minimize">_</button>
          <button class="mouna-icon-btn" id="mouna-close-btn" title="Hide Overlay" aria-label="Close">✕</button>
        </div>
      </div>

      <!-- 3D Avatar Viewport -->
      <div class="mouna-viewport-container">
        <canvas class="mouna-canvas" id="mouna-avatar-canvas"></canvas>
        <div class="mouna-loading-overlay" id="mouna-loading">
          <div class="mouna-loading-spinner"></div>
          <span id="mouna-loading-text">Loading Arya Avatar & ISL Rig...</span>
        </div>
      </div>

      <!-- Dedicated Current Sign Box Directly Below Animation Viewport -->
      <div class="mouna-current-sign-box-container">
        <span class="mouna-current-sign-box-label">CURRENT SIGN</span>
        <span class="mouna-current-sign-box-word" id="mouna-sign-box-word">—</span>
      </div>

      <!-- Transcript Banner -->
      <div class="mouna-transcript-container">
        <div class="mouna-transcript-text" id="mouna-transcript-text">
          <span class="mouna-transcript-placeholder">Spoken speech and subtitles will appear here...</span>
        </div>
      </div>

      <!-- Live Manual Text Drawer (toggleable) -->
      <div class="mouna-text-drawer" id="mouna-text-drawer" style="display:none;">
        <input type="text" class="mouna-text-input" id="mouna-text-input" placeholder="Type words/phrases to test signs..." />
        <button class="mouna-send-btn" id="mouna-send-btn">Sign</button>
      </div>

      <!-- Controls Tray -->
      <div class="mouna-controls-tray">
        <div class="mouna-select-wrapper">
          <select class="mouna-language-select" id="mouna-language-select">
            <option value="en">English</option>
            <option value="hi">हिन्दी (Hindi)</option>
            <option value="ta">தமிழ் (Tamil)</option>
            <option value="te">తెలుగు (Telugu)</option>
            <option value="kn">ಕನ್ನಡ (Kannada)</option>
            <option value="ml">മലയാളം (Malayalam)</option>
            <option value="gu">ગુજરાતી (Gujarati)</option>
            <option value="mr">मराठी (Marathi)</option>
            <option value="pa">ਪੰਜਾਬੀ (Punjabi)</option>
          </select>
          <span class="mouna-select-arrow">▼</span>
        </div>
        <button class="mouna-power-btn" id="mouna-power-btn">
          <span id="mouna-power-icon">●</span>
          <span id="mouna-power-label">START</span>
        </button>
      </div>

      <!-- Resizing Grip -->
      <div class="mouna-resize-handle" id="mouna-resize-handle"></div>
    `;
  }

  _bindEvents() {
    const header = this.root.querySelector('#mouna-header');
    const resizeHandle = this.root.querySelector('#mouna-resize-handle');
    const powerBtn = this.root.querySelector('#mouna-power-btn');
    const langSelect = this.root.querySelector('#mouna-language-select');
    const speedBtn = this.root.querySelector('#mouna-speed-btn');
    const minimizeBtn = this.root.querySelector('#mouna-minimize-btn');
    const closeBtn = this.root.querySelector('#mouna-close-btn');
    const drawerToggle = this.root.querySelector('#mouna-drawer-toggle');
    const drawer = this.root.querySelector('#mouna-text-drawer');
    const textInput = this.root.querySelector('#mouna-text-input');
    const sendBtn = this.root.querySelector('#mouna-send-btn');

    // Dragging Logic
    header.addEventListener('mousedown', (e) => {
      if (e.target.closest('button') || e.target.closest('select')) return;
      if (this.isMinimized) {
        this.toggleMinimize();
        return;
      }
      this.isDragging = true;
      this.dragStartX = e.clientX;
      this.dragStartY = e.clientY;
      const rect = this.root.getBoundingClientRect();
      this.elementStartX = rect.left;
      this.elementStartY = rect.top;
      e.preventDefault();
    });

    // Resizing Logic
    resizeHandle.addEventListener('mousedown', (e) => {
      this.isResizing = true;
      this.dragStartX = e.clientX;
      this.dragStartY = e.clientY;
      const rect = this.root.getBoundingClientRect();
      this.elementStartWidth = rect.width;
      this.elementStartHeight = rect.height;
      e.preventDefault();
      e.stopPropagation();
    });

    window.addEventListener('mousemove', (e) => {
      if (this.isDragging) {
        const deltaX = e.clientX - this.dragStartX;
        const deltaY = e.clientY - this.dragStartY;
        let newLeft = this.elementStartX + deltaX;
        let newTop = this.elementStartY + deltaY;

        // Viewport boundaries
        newLeft = Math.max(10, Math.min(window.innerWidth - this.root.offsetWidth - 10, newLeft));
        newTop = Math.max(10, Math.min(window.innerHeight - this.root.offsetHeight - 10, newTop));

        this.root.style.left = `${newLeft}px`;
        this.root.style.top = `${newTop}px`;
        this.root.style.right = 'auto';
        this.root.style.bottom = 'auto';
      }

      if (this.isResizing) {
        const deltaX = e.clientX - this.dragStartX;
        const deltaY = e.clientY - this.dragStartY;
        const newWidth = Math.max(280, Math.min(600, this.elementStartWidth + deltaX));
        const newHeight = Math.max(400, Math.min(window.innerHeight - 50, this.elementStartHeight + deltaY));

        this.root.style.width = `${newWidth}px`;
        this.root.style.height = `${newHeight}px`;
      }
    });

    window.addEventListener('mouseup', () => {
      this.isDragging = false;
      this.isResizing = false;
    });

    // Power Button
    powerBtn.addEventListener('click', () => {
      this.isActive = !this.isActive;
      this.setPowerState(this.isActive);
      if (this.onTogglePower) this.onTogglePower(this.isActive);
    });

    // Language Dropdown
    langSelect.addEventListener('change', (e) => {
      this.currentLanguage = e.target.value;
      if (this.onLanguageChange) this.onLanguageChange(this.currentLanguage);
    });

    // Speed Cycle Button
    speedBtn.addEventListener('click', () => {
      const idx = this.speeds.indexOf(this.currentSpeed);
      const nextIdx = (idx + 1) % this.speeds.length;
      this.currentSpeed = this.speeds[nextIdx];
      this.setSpeed(this.currentSpeed);
      if (this.onSpeedChange) this.onSpeedChange(this.currentSpeed);
    });

    // Drawer Toggle
    drawerToggle.addEventListener('click', () => {
      const isVisible = drawer.style.display !== 'none';
      drawer.style.display = isVisible ? 'none' : 'flex';
      if (!isVisible) textInput.focus();
    });

    // Send Manual Text
    const submitText = () => {
      const val = textInput.value.trim();
      if (!val) return;
      if (this.onSendText) this.onSendText(val);
      textInput.value = '';
    };

    sendBtn.addEventListener('click', submitText);
    textInput.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') submitText();
    });

    // Minimize & Close
    minimizeBtn.addEventListener('click', () => this.toggleMinimize());
    closeBtn.addEventListener('click', () => {
      this.hide();
      if (this.onClose) this.onClose();
    });
  }

  toggleMinimize() {
    this.isMinimized = !this.isMinimized;
    if (this.isMinimized) {
      this.root.classList.add('mouna-minimized');
    } else {
      this.root.classList.remove('mouna-minimized');
    }
  }

  setPowerState(isActive) {
    this.isActive = isActive;
    const powerBtn = this.root.querySelector('#mouna-power-btn');
    const powerLabel = this.root.querySelector('#mouna-power-label');

    if (isActive) {
      powerBtn.classList.add('active');
      powerLabel.textContent = 'STOP';
      this.setStatus('listening', 'Listening');
    } else {
      powerBtn.classList.remove('active');
      powerLabel.textContent = 'START';
      this.setStatus('idle', 'Standby');
      this.setCurrentSign(null);
    }
  }

  setStatus(statusKey, message) {
    const dot = this.root.querySelector('#mouna-status-dot');
    const text = this.root.querySelector('#mouna-status-text');

    dot.className = 'mouna-status-dot';
    if (statusKey === 'listening') dot.classList.add('active');
    else if (statusKey === 'signing') dot.classList.add('signing');
    else if (statusKey === 'loading') dot.classList.add('loading');

    text.textContent = message;
  }

  setTranscript(text, isFinal = false) {
    const el = this.root.querySelector('#mouna-transcript-text');
    if (!text) {
      el.innerHTML = '<span class="mouna-transcript-placeholder">Spoken speech and subtitles will appear here...</span>';
    } else {
      el.textContent = text;
      el.style.opacity = isFinal ? '1' : '0.85';
    }
  }

  setCurrentSign(signName) {
    const boxWord = this.root.querySelector('#mouna-sign-box-word');
    if (signName) {
      if (boxWord) {
        boxWord.textContent = signName.toUpperCase();
        if (boxWord.parentElement) {
          boxWord.parentElement.classList.add('pulse');
          setTimeout(() => boxWord.parentElement.classList.remove('pulse'), 250);
        }
      }
    } else {
      if (boxWord) boxWord.textContent = '—';
    }
  }

  setLoading(isLoading, message = 'Loading 3D Arya Avatar & ISL Rig...') {
    const overlay = this.root.querySelector('#mouna-loading');
    const text = this.root.querySelector('#mouna-loading-text');
    text.textContent = message;
    overlay.style.opacity = isLoading ? '1' : '0';
    overlay.style.pointerEvents = isLoading ? 'auto' : 'none';
    if (!isLoading) {
      setTimeout(() => { overlay.style.display = 'none'; }, 300);
    } else {
      overlay.style.display = 'flex';
    }
  }

  setLanguage(langCode) {
    this.currentLanguage = langCode;
    const select = this.root.querySelector('#mouna-language-select');
    if (select) select.value = langCode;
  }

  setSpeed(speedVal) {
    this.currentSpeed = speedVal;
    const btn = this.root.querySelector('#mouna-speed-btn');
    if (btn) {
      btn.textContent = `${speedVal.toFixed(1)}x`;
      btn.title = `Sign Speed: ${speedVal.toFixed(1)}x`;
    }
  }

  getCanvas() {
    return this.canvas;
  }

  show() {
    this.root.classList.remove('mouna-hidden');
  }

  hide() {
    this.root.classList.add('mouna-hidden');
  }

  toggle() {
    this.root.classList.toggle('mouna-hidden');
  }
}

if (typeof window !== 'undefined') {
  window.MounaOverlay = MounaOverlay;
}
