package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseResource.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"getOrNull", "T", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ResponseResourceKt {
    public static final <T> T getOrNull(ResponseResource<? extends T> responseResource) {
        Intrinsics.checkNotNullParameter(responseResource, "<this>");
        if (responseResource instanceof ResponseResource.Success) {
            return (T) ((ResponseResource.Success) responseResource).getData();
        }
        return null;
    }
}
