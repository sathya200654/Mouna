package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class InflaterModule {
    private final Application application;
    private final InAppMessage inAppMessage;
    private final InAppMessageLayoutConfig inAppMessageLayoutConfig;

    public InflaterModule(InAppMessage inAppMessage, InAppMessageLayoutConfig inAppMessageLayoutConfig, Application application) {
        this.inAppMessage = inAppMessage;
        this.inAppMessageLayoutConfig = inAppMessageLayoutConfig;
        this.application = application;
    }

    @Provides
    public LayoutInflater providesInflaterservice() {
        return (LayoutInflater) this.application.getSystemService("layout_inflater");
    }

    @Provides
    InAppMessage providesBannerMessage() {
        return this.inAppMessage;
    }

    @Provides
    InAppMessageLayoutConfig inAppMessageLayoutConfig() {
        return this.inAppMessageLayoutConfig;
    }
}
