package com.azure.core.models;

import com.azure.core.util.ExpandableStringEnum;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AzureCloud extends ExpandableStringEnum<AzureCloud> {
    public static final AzureCloud AZURE_PUBLIC_CLOUD = fromString("AZURE_PUBLIC_CLOUD");
    public static final AzureCloud AZURE_CHINA_CLOUD = fromString("AZURE_CHINA_CLOUD");
    public static final AzureCloud AZURE_US_GOVERNMENT_CLOUD = fromString("AZURE_US_GOVERNMENT");

    public static AzureCloud fromString(String str) {
        return (AzureCloud) fromString(str, AzureCloud.class);
    }

    @Deprecated
    public AzureCloud() {
    }
}
