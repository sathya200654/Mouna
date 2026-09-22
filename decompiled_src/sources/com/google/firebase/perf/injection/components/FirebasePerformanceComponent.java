package com.google.firebase.perf.injection.components;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import dagger.Component;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Component(modules = {FirebasePerformanceModule.class})
@Singleton
public interface FirebasePerformanceComponent {
    FirebasePerformance getFirebasePerformance();
}
