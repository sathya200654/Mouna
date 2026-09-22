package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import io.reactivex.FlowableEmitter;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class FiamAnalyticsConnectorListener implements AnalyticsConnector.AnalyticsConnectorListener {
    private FlowableEmitter<String> emitter;

    FiamAnalyticsConnectorListener(FlowableEmitter<String> flowableEmitter) {
        this.emitter = flowableEmitter;
    }

    public void onMessageTriggered(int i, Bundle bundle) {
        if (i == 2) {
            this.emitter.onNext(bundle.getString("events"));
        }
    }
}
