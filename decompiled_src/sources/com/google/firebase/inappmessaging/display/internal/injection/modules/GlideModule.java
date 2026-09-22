package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class GlideModule {
    @Provides
    RequestManager providesGlideRequestManager(Application application) {
        return Glide.with(application);
    }
}
