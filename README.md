# Mouna — Real-Time Speech/Audio to Indian Sign Language (ISL)

> **Speech & Audio → Text → Indian Sign Language (ISL) 3D Avatar System**  
> Supports continuous speech recognition, YouTube/HTML5 video caption observation, 9 Indian languages, and real-time 3D signing.

---

## 📁 Repository Overview

| Directory / File | Description |
| :--- | :--- |
| [`mouna-chrome-extension/`](./mouna-chrome-extension/) | Complete, production-ready **Manifest V3 Google Chrome Extension**. |
| [`mouna-chrome-extension.zip`](./mouna-chrome-extension.zip) | Packaged zip distribution archive ready for installation. |
| [`decompiled_src/`](./decompiled_src/) | Decompiled Android mobile application source code (Java/Kotlin) for reference. |
| [`tools/`](./tools/) | String decoders, analysis scripts, and reverse-engineering utilities. |
| [`ARCHITECTURE_SUMMARY.md`](./ARCHITECTURE_SUMMARY.md) | Technical architecture overview of the mobile app and extension pipelines. |
| [`CHANGE_REPORT.md`](./CHANGE_REPORT.md) | Detailed report of assets and logic extracted from the mobile application. |

---

## 🌟 Key Features of the Chrome Extension

- **3D Avatar & Skeletal Rig ("Arya")**:
  - Reuses the extracted `arya-signs.glb` (39.06 MB) character model.
  - 85 skeletal animations: A–Z fingerspelling (`a-22` to `z-22`), numeric amounts (`0-23`, `20__` to `90__`, `100__`, `1000__`), and core dialogue signs.
  - Preserves the mobile application's subclip trimming and crossfade algorithm for natural transition between signs.
- **9 Supported Indian Languages**:
  - English (`en`), Hindi (`hi`), Tamil (`ta`), Telugu (`te`), Kannada (`kn`), Malayalam (`ml`), Gujarati (`gu`), Marathi (`mr`), Punjabi (`pa`).
  - Automatic letter-by-letter fingerspelling fallback for out-of-vocabulary words.
- **Continuous Speech & Video Audio Capture**:
  - Web Speech API continuous engine for ambient and microphone audio.
  - Automated YouTube caption observer (`.ytp-caption-segment`) and HTML5 video `textTracks` observer for zero-latency video transcription.
- **Dual Visual Interfaces**:
  - **Streamlined Popup**: Compact 3D avatar window with a single **[ TURN ON / TURN OFF ]** toggle.
  - **Floating In-Page Overlay**: Draggable, resizable, and minimizable overlay appearing directly inside video streams and meetings.

---

## 🚀 How to Install the Chrome Extension

1. Clone or download this repository.
2. Open **Google Chrome** and navigate to:
   ```
   chrome://extensions
   ```
3. Enable **Developer mode** via the top-right toggle.
4. Click **Load unpacked** and select the folder:
   ```
   mouna-chrome-extension/
   ```
   *(Alternatively, extract `mouna-chrome-extension.zip` and select the extracted folder).*
5. Pin **Mouna** to your Chrome toolbar.
6. Open any webpage or YouTube video, click **TURN ON**, and watch Arya perform Indian Sign Language in real-time.

---

## 🛠️ Verification & Test Suite

An automated test suite is provided inside `mouna-chrome-extension/test/`:

```bash
cd mouna-chrome-extension
node test/test-pipeline.js
```

All 33 pipeline assertions (text normalization, 9-language translation, synonym mapping, fingerspelling fallback, and queue positioning) pass with 0 errors.

---

## 📄 License & Attribution

Extracted and adapted from the original **Mouna (Let's Talk Sign)** accessibility application for web browser usage.
