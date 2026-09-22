package dagger.hilt.android.internal.builders;

import androidx.lifecycle.SavedStateHandle;
import dagger.BindsInstance;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.components.ViewModelComponent;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ViewModelComponentBuilder {
    ViewModelComponent build();

    ViewModelComponentBuilder savedStateHandle(@BindsInstance SavedStateHandle handle);

    ViewModelComponentBuilder viewModelLifecycle(@BindsInstance ViewModelLifecycle viewModelLifecycle);
}
