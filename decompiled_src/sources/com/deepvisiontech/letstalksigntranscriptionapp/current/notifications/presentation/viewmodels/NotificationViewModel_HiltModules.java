package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationViewModel_HiltModules {
    private NotificationViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(NotificationViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(NotificationViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(NotificationViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
