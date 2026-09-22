package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.LazyClassKey;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NotificationListViewModel_HiltModules {
    private NotificationListViewModel_HiltModules() {
    }

    @Module
    public static abstract class BindsModule {
        @LazyClassKey(NotificationListViewModel.class)
        @Binds
        @IntoMap
        public abstract ViewModel binds(NotificationListViewModel vm);

        private BindsModule() {
        }
    }

    @Module
    public static final class KeyModule {
        @Provides
        @LazyClassKey(NotificationListViewModel.class)
        @IntoMap
        public static boolean provide() {
            return true;
        }

        private KeyModule() {
        }
    }
}
