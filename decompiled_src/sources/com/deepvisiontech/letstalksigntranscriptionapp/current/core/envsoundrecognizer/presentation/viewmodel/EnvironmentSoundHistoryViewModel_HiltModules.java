package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class EnvironmentSoundHistoryViewModel_HiltModules {
    private EnvironmentSoundHistoryViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(EnvironmentSoundHistoryViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(EnvironmentSoundHistoryViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(EnvironmentSoundHistoryViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
