package com.google.firebase.inappmessaging.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ProgramaticContextualTriggers {
    private Listener listener;

    public interface Listener {
        void onEventTrigger(String str);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void removeListener(Listener listener) {
        this.listener = null;
    }

    public void triggerEvent(String str) {
        Logging.logd("Programmatically trigger: " + str);
        this.listener.onEventTrigger(str);
    }
}
