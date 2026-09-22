package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* JADX INFO: compiled from: EnvironmentSoundGraph.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/presentation/navigation/EnvironmentSoundGraph;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class EnvironmentSoundGraph {
    public static final int $stable = 0;
    public static final EnvironmentSoundGraph INSTANCE = new EnvironmentSoundGraph();
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation.EnvironmentSoundGraph$$ExternalSyntheticLambda0
        public final Object invoke() {
            return EnvironmentSoundGraph._init_$_anonymous_();
        }
    });

    private EnvironmentSoundGraph() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation.EnvironmentSoundGraph", INSTANCE, new Annotation[0]);
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return (KSerializer) $cachedSerializer$delegate.getValue();
    }

    public final KSerializer<EnvironmentSoundGraph> serializer() {
        return get$cachedSerializer();
    }
}
