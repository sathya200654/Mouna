package dagger.hilt.android.internal.managers;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SavedStateHandleModule_ProvideSavedStateHandleFactory implements Factory<SavedStateHandle> {
    private final Provider<SavedStateHandleHolder> savedStateHandleHolderProvider;

    private SavedStateHandleModule_ProvideSavedStateHandleFactory(Provider<SavedStateHandleHolder> savedStateHandleHolderProvider) {
        this.savedStateHandleHolderProvider = savedStateHandleHolderProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SavedStateHandle m2265get() {
        return provideSavedStateHandle((SavedStateHandleHolder) this.savedStateHandleHolderProvider.get());
    }

    public static SavedStateHandleModule_ProvideSavedStateHandleFactory create(Provider<SavedStateHandleHolder> savedStateHandleHolderProvider) {
        return new SavedStateHandleModule_ProvideSavedStateHandleFactory(savedStateHandleHolderProvider);
    }

    public static SavedStateHandle provideSavedStateHandle(SavedStateHandleHolder savedStateHandleHolder) {
        return (SavedStateHandle) Preconditions.checkNotNullFromProvides(SavedStateHandleModule.provideSavedStateHandle(savedStateHandleHolder));
    }
}
