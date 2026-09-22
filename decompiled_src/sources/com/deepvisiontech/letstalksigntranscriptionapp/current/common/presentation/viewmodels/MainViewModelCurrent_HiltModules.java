package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class MainViewModelCurrent_HiltModules {
    private MainViewModelCurrent_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(MainViewModelCurrent.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(MainViewModelCurrent vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(MainViewModelCurrent.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
