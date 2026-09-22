package androidx.test.runner.lifecycle;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ApplicationLifecycleMonitor {
    void addLifecycleCallback(ApplicationLifecycleCallback callback);

    void removeLifecycleCallback(ApplicationLifecycleCallback callback);
}
