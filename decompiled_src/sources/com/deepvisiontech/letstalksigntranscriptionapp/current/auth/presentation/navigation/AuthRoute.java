package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* JADX INFO: compiled from: AuthRoute.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute;", "", "SplashScreen", "SignInScreen", "SetupScreen", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute$SetupScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute$SignInScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute$SplashScreen;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AuthRoute {

    /* JADX INFO: compiled from: AuthRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute$SplashScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SplashScreen implements AuthRoute {
        public static final int $stable = 0;
        public static final SplashScreen INSTANCE = new SplashScreen();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthRoute$SplashScreen$$ExternalSyntheticLambda0
            public final Object invoke() {
                return AuthRoute.SplashScreen._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SplashScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -752217424;
        }

        public String toString() {
            return "SplashScreen";
        }

        private SplashScreen() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthRoute.SplashScreen", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SplashScreen> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: AuthRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute$SignInScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SignInScreen implements AuthRoute {
        public static final int $stable = 0;
        public static final SignInScreen INSTANCE = new SignInScreen();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthRoute$SignInScreen$$ExternalSyntheticLambda0
            public final Object invoke() {
                return AuthRoute.SignInScreen._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignInScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1251499061;
        }

        public String toString() {
            return "SignInScreen";
        }

        private SignInScreen() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthRoute.SignInScreen", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SignInScreen> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: AuthRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute$SetupScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/navigation/AuthRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SetupScreen implements AuthRoute {
        public static final int $stable = 0;
        public static final SetupScreen INSTANCE = new SetupScreen();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthRoute$SetupScreen$$ExternalSyntheticLambda0
            public final Object invoke() {
                return AuthRoute.SetupScreen._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetupScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1828478124;
        }

        public String toString() {
            return "SetupScreen";
        }

        private SetupScreen() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthRoute.SetupScreen", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SetupScreen> serializer() {
            return get$cachedSerializer();
        }
    }
}
