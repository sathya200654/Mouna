package com.azure.core.util.polling;

import com.azure.core.http.HttpResponse;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final /* synthetic */ class LocationPollingStrategy$$ExternalSyntheticLambda10 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((HttpResponse) obj).getBodyAsByteArray();
    }
}
