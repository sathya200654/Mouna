package com.google.firebase.inappmessaging.display;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class FirebaseInAppMessagingDisplayRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fiamd";

    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInAppMessagingDisplay.class).name(LIBRARY_NAME).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInAppMessaging.class)).factory(new ComponentFactory() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplayRegistrar$$ExternalSyntheticLambda0
            public final Object create(ComponentContainer componentContainer) {
                return this.f$0.buildFirebaseInAppMessagingUI(componentContainer);
            }
        }).eagerInDefaultApp().build(), LibraryVersionComponent.create(LIBRARY_NAME, "21.0.2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseInAppMessagingDisplay buildFirebaseInAppMessagingUI(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInAppMessaging firebaseInAppMessaging = (FirebaseInAppMessaging) componentContainer.get(FirebaseInAppMessaging.class);
        Application application = (Application) firebaseApp.getApplicationContext();
        FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplayProvidesFirebaseInAppMessagingUI = DaggerAppComponent.builder().universalComponent(DaggerUniversalComponent.builder().applicationModule(new ApplicationModule(application)).build()).headlessInAppMessagingModule(new HeadlessInAppMessagingModule(firebaseInAppMessaging)).build().providesFirebaseInAppMessagingUI();
        application.registerActivityLifecycleCallbacks(firebaseInAppMessagingDisplayProvidesFirebaseInAppMessagingUI);
        return firebaseInAppMessagingDisplayProvidesFirebaseInAppMessagingUI;
    }
}
