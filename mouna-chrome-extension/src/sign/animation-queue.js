/**
 * Mouna - Animation Queue
 * Manages FIFO queue of sign animations, avoids restarting from scratch on progressive speech input,
 * and tracks position metadata (first, internal, last, single) for subclip slicing.
 */

class AnimationQueue {
  constructor() {
    this.queue = [];
    this.history = [];
    this.isPlaying = false;
    this.isPaused = false;
    this.currentSign = null;

    // Callbacks
    this.onSignChange = null;
    this.onQueueEmpty = null;
    this.onProgress = null;
  }

  /**
   * Enqueues an array of sign items.
   * @param {Array<{type: string, sign: string, displayName: string}>} signItems 
   */
  enqueueBatch(signItems) {
    if (!Array.isArray(signItems) || signItems.length === 0) return;

    for (const item of signItems) {
      this.queue.push({
        ...item,
        id: Math.random().toString(36).substring(2, 9),
        addedAt: Date.now()
      });
    }

    if (this.onProgress) {
      this.onProgress(this.getQueueStatus());
    }
  }

  /**
   * Retrieves the next sign item and marks its position metadata.
   * @returns {Object|null}
   */
  dequeue() {
    if (this.queue.length === 0) {
      this.currentSign = null;
      this.isPlaying = false;
      if (this.onQueueEmpty) {
        this.onQueueEmpty();
      }
      return null;
    }

    const item = this.queue.shift();
    this.currentSign = item;
    this.isPlaying = true;

    // Determine positionType for smooth subclip trimming
    if (this.history.length === 0 && this.queue.length === 0) {
      item.positionType = 'single';
    } else if (this.history.length === 0 && this.queue.length > 0) {
      item.positionType = 'first';
    } else if (this.queue.length === 0) {
      item.positionType = 'last';
    } else {
      item.positionType = 'internal';
    }
    item.position = item.positionType;

    this.history.push(item);
    if (this.history.length > 50) {
      this.history.shift();
    }

    if (this.onSignChange) {
      this.onSignChange(item);
    }

    return item;
  }

  /**
   * Returns number of items currently waiting in the queue
   * @returns {number}
   */
  size() {
    return this.queue.length;
  }

  /**
   * Returns true if queue is empty
   * @returns {boolean}
   */
  isEmpty() {
    return this.queue.length === 0;
  }

  /**
   * Returns the number of items currently waiting in the queue.
   * @returns {number}
   */
  get length() {
    return this.queue.length;
  }

  /**
   * Clears all pending queued animations and stops playback.
   */
  clear() {
    this.queue = [];
    this.currentSign = null;
    this.isPlaying = false;
    this.isPaused = false;
    if (this.onProgress) {
      this.onProgress(this.getQueueStatus());
    }
  }

  /**
   * Returns current queue state snapshot.
   */
  getQueueStatus() {
    return {
      pendingCount: this.queue.length,
      currentSign: this.currentSign,
      isPlaying: this.isPlaying,
      isPaused: this.isPaused
    };
  }
}

if (typeof window !== 'undefined') {
  window.AnimationQueue = AnimationQueue;
}

if (typeof module !== 'undefined' && module.exports) {
  module.exports = AnimationQueue;
}

