package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Component(dependencies = {UniversalComponent.class}, modules = {HeadlessInAppMessagingModule.class, GlideModule.class})
public interface AppComponent {
    FiamImageLoader fiamImageLoader();

    FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI();
}
