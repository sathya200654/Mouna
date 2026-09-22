package androidx.test.platform.device;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface DeviceController {

    public enum ScreenOrientation {
        PORTRAIT,
        LANDSCAPE
    }

    void setDeviceMode(int deviceMode);

    void setScreenOrientation(int screenOrientation);
}
