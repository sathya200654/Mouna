package com.google.firebase.inappmessaging.model;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class TriggeredInAppMessage {
    private InAppMessage inAppMessage;
    private String triggeringEvent;

    public TriggeredInAppMessage(InAppMessage inAppMessage, String str) {
        this.inAppMessage = inAppMessage;
        this.triggeringEvent = str;
    }

    public InAppMessage getInAppMessage() {
        return this.inAppMessage;
    }

    public String getTriggeringEvent() {
        return this.triggeringEvent;
    }
}
