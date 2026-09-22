/**
 * Test headless Chrome loading preview-test.html and capturing console logs
 */
const { spawn } = require('child_process');
const http = require('http');

const chromePath = 'C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe';

console.log('Launching headless Chrome on port 9222...');
const chromeProc = spawn(chromePath, [
  '--headless=new',
  '--remote-debugging-port=9222',
  '--user-data-dir=C:\\Users\\abcsa\\Downloads\\Mouna\\chrome-test-profile',
  '--no-first-run',
  '--no-default-browser-check',
  'http://localhost:3456/test/preview-test.html'
]);

setTimeout(async () => {
  try {
    const res = await fetch('http://localhost:9222/json');
    const tabs = await res.json();
    console.log('Open tabs in Chrome:', tabs.map(t => ({ url: t.url, id: t.id })));

    // Connect to WebSocket to read console events
    const tab = tabs.find(t => t.url.includes('preview-test.html'));
    if (!tab) {
      console.log('preview-test tab not found');
      chromeProc.kill();
      process.exit(1);
    }

    const WS = globalThis.WebSocket;
    const ws = new WS(tab.webSocketDebuggerUrl);

    ws.onopen = () => {
      console.log('Connected to Chrome DevTools WebSocket!');
      ws.send(JSON.stringify({ id: 1, method: 'Console.enable' }));
      ws.send(JSON.stringify({ id: 2, method: 'Runtime.enable' }));
      ws.send(JSON.stringify({ id: 3, method: 'Log.enable' }));
    };

    ws.onmessage = (event) => {
      const msg = JSON.parse(event.data);
      if (msg.method === 'Runtime.consoleAPICalled') {
        const text = msg.params.args.map(a => a.value || a.description || JSON.stringify(a)).join(' ');
        console.log(`[CHROME CONSOLE ${msg.params.type.toUpperCase()}]`, text);
      } else if (msg.method === 'Runtime.exceptionThrown') {
        console.error('[CHROME UNCAUGHT EXCEPTION]', JSON.stringify(msg.params.exceptionDetails));
      }
    };

    setTimeout(() => {
      console.log('Done testing Chrome.');
      ws.close();
      chromeProc.kill();
      process.exit(0);
    }, 12000);

  } catch (err) {
    console.error('Error connecting to Chrome:', err);
    chromeProc.kill();
    process.exit(1);
  }
}, 2000);
