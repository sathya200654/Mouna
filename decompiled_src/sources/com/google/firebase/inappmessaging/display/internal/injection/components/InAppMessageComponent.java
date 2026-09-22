package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Component(modules = {InflaterModule.class})
public interface InAppMessageComponent {
    BannerBindingWrapper bannerBindingWrapper();

    CardBindingWrapper cardBindingWrapper();

    ImageBindingWrapper imageBindingWrapper();

    ModalBindingWrapper modalBindingWrapper();
}
