package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.typeconverters;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPracticeTypeConverters.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/typeconverters/SignPracticeTypeConverters;", "", "<init>", "()V", "fromSignPracticeComplexity", "", "complexityObject", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "toSignPracticeComplexity", "complexityString", "fromSignPracticeType", "typeObject", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "toSignPracticeType", "typeString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeTypeConverters {
    public static final int $stable = 0;

    public final String fromSignPracticeComplexity(SignPracticeComplexity complexityObject) {
        Intrinsics.checkNotNullParameter(complexityObject, "complexityObject");
        return complexityObject.name();
    }

    public final SignPracticeComplexity toSignPracticeComplexity(String complexityString) {
        Intrinsics.checkNotNullParameter(complexityString, "complexityString");
        return SignPracticeComplexity.valueOf(complexityString);
    }

    public final String fromSignPracticeType(SignPracticeType typeObject) {
        Intrinsics.checkNotNullParameter(typeObject, "typeObject");
        return typeObject.name();
    }

    public final SignPracticeType toSignPracticeType(String typeString) {
        Intrinsics.checkNotNullParameter(typeString, "typeString");
        return SignPracticeType.valueOf(typeString);
    }
}
