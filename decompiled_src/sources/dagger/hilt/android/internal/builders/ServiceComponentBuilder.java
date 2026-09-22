package dagger.hilt.android.internal.builders;

import android.app.Service;
import dagger.BindsInstance;
import dagger.hilt.android.components.ServiceComponent;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ServiceComponentBuilder {
    ServiceComponent build();

    ServiceComponentBuilder service(@BindsInstance Service service);
}
