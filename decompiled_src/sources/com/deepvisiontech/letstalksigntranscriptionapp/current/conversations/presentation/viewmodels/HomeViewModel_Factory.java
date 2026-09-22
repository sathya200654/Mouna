package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public HomeViewModel m1666get() {
        return newInstance();
    }

    public static HomeViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HomeViewModel newInstance() {
        return new HomeViewModel();
    }

    private static final class InstanceHolder {
        static final HomeViewModel_Factory INSTANCE = new HomeViewModel_Factory();

        private InstanceHolder() {
        }
    }
}
