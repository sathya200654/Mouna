package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* JADX INFO: compiled from: SignPracticeGraph.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\nJ\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeGraph;", "", "<init>", "()V", "equals", "", "other", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class SignPracticeGraph {
    public static final int $stable = 0;
    public static final SignPracticeGraph INSTANCE = new SignPracticeGraph();
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeGraph$$ExternalSyntheticLambda0
        public final Object invoke() {
            return SignPracticeGraph._init_$_anonymous_();
        }
    });

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignPracticeGraph)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 1841597142;
    }

    public String toString() {
        return "SignPracticeGraph";
    }

    private SignPracticeGraph() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeGraph", INSTANCE, new Annotation[0]);
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return (KSerializer) $cachedSerializer$delegate.getValue();
    }

    public final KSerializer<SignPracticeGraph> serializer() {
        return get$cachedSerializer();
    }
}
