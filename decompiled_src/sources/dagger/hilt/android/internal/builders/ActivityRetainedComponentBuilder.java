package dagger.hilt.android.internal.builders;

import dagger.BindsInstance;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ActivityRetainedComponentBuilder {
    ActivityRetainedComponent build();

    ActivityRetainedComponentBuilder savedStateHandleHolder(@BindsInstance SavedStateHandleHolder savedStateHandleHolder);
}
