package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HeartBeatConsumerComponent {
    private HeartBeatConsumerComponent() {
    }

    public static Component<?> create() {
        return Component.intoSet(new HeartBeatConsumer() { // from class: com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent.1
        }, HeartBeatConsumer.class);
    }
}
