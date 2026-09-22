package dagger.hilt.android.internal.builders;

import android.app.Activity;
import dagger.BindsInstance;
import dagger.hilt.android.components.ActivityComponent;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ActivityComponentBuilder {
    ActivityComponentBuilder activity(@BindsInstance Activity activity);

    ActivityComponent build();
}
