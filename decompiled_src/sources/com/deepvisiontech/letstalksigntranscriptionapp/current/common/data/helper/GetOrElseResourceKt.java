package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetOrElseResource.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"getOrElse", "T", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "onNotSuccess", "Lkotlin/Function1;", "", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GetOrElseResourceKt {
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final <T> T getOrElse(ResponseResource<? extends T> responseResource, Function1 function1) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        Intrinsics.checkNotNullParameter(responseResource, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onNotSuccess");
        if (responseResource instanceof ResponseResource.Success) {
            return (T) ((ResponseResource.Success) responseResource).getData();
        }
        if (responseResource instanceof ResponseResource.Error) {
            function1.invoke(responseResource);
            throw new KotlinNothingValueException();
        }
        if (!Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        function1.invoke(ResponseResource.Loading.INSTANCE);
        throw new KotlinNothingValueException();
    }
}
