package com.azure.core.client.traits;

import com.azure.core.client.traits.ConfigurationTrait;
import com.azure.core.util.Configuration;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ConfigurationTrait<T extends ConfigurationTrait<T>> {
    T configuration(Configuration configuration);
}
