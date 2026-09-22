package dagger.hilt.android.internal.builders;

import android.view.View;
import dagger.BindsInstance;
import dagger.hilt.android.components.ViewComponent;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ViewComponentBuilder {
    ViewComponent build();

    ViewComponentBuilder view(@BindsInstance View view);
}
