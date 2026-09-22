package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* JADX INFO: compiled from: NetworkUnavailableRoute.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/navigation/NetworkUnavailableRoute;", "", "NetworkUnavailableScreenRoute", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/navigation/NetworkUnavailableRoute$NetworkUnavailableScreenRoute;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NetworkUnavailableRoute {

    /* JADX INFO: compiled from: NetworkUnavailableRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/navigation/NetworkUnavailableRoute$NetworkUnavailableScreenRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/feature/network/presentation/navigation/NetworkUnavailableRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class NetworkUnavailableScreenRoute implements NetworkUnavailableRoute {
        public static final int $stable = 0;
        public static final NetworkUnavailableScreenRoute INSTANCE = new NetworkUnavailableScreenRoute();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation.NetworkUnavailableRoute$NetworkUnavailableScreenRoute$$ExternalSyntheticLambda0
            public final Object invoke() {
                return NetworkUnavailableRoute.NetworkUnavailableScreenRoute._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkUnavailableScreenRoute)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 641374266;
        }

        public String toString() {
            return "NetworkUnavailableScreenRoute";
        }

        private NetworkUnavailableScreenRoute() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation.NetworkUnavailableRoute.NetworkUnavailableScreenRoute", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NetworkUnavailableScreenRoute> serializer() {
            return get$cachedSerializer();
        }
    }
}
