package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: SignPracticeRoute.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute;", "", "SignPracticeListScreen", "SignPracticeCreationScreen", "SignPracticeSessionScreen", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeCreationScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeListScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeSessionScreen;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SignPracticeRoute {

    /* JADX INFO: compiled from: SignPracticeRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeListScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SignPracticeListScreen implements SignPracticeRoute {
        public static final int $stable = 0;
        public static final SignPracticeListScreen INSTANCE = new SignPracticeListScreen();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeRoute$SignPracticeListScreen$$ExternalSyntheticLambda0
            public final Object invoke() {
                return SignPracticeRoute.SignPracticeListScreen._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignPracticeListScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1951056319;
        }

        public String toString() {
            return "SignPracticeListScreen";
        }

        private SignPracticeListScreen() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeRoute.SignPracticeListScreen", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SignPracticeListScreen> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: SignPracticeRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeCreationScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SignPracticeCreationScreen implements SignPracticeRoute {
        public static final int $stable = 0;
        public static final SignPracticeCreationScreen INSTANCE = new SignPracticeCreationScreen();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeRoute$SignPracticeCreationScreen$$ExternalSyntheticLambda0
            public final Object invoke() {
                return SignPracticeRoute.SignPracticeCreationScreen._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignPracticeCreationScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1594783936;
        }

        public String toString() {
            return "SignPracticeCreationScreen";
        }

        private SignPracticeCreationScreen() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeRoute.SignPracticeCreationScreen", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SignPracticeCreationScreen> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: SignPracticeRoute.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeSessionScreen;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute;", "signPracticeId", "", "<init>", "(J)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSignPracticeId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SignPracticeSessionScreen implements SignPracticeRoute {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long signPracticeId;

        public static /* synthetic */ SignPracticeSessionScreen copy$default(SignPracticeSessionScreen signPracticeSessionScreen, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = signPracticeSessionScreen.signPracticeId;
            }
            return signPracticeSessionScreen.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getSignPracticeId() {
            return this.signPracticeId;
        }

        public final SignPracticeSessionScreen copy(long signPracticeId) {
            return new SignPracticeSessionScreen(signPracticeId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SignPracticeSessionScreen) && this.signPracticeId == ((SignPracticeSessionScreen) other).signPracticeId;
        }

        public int hashCode() {
            return Long.hashCode(this.signPracticeId);
        }

        public String toString() {
            return "SignPracticeSessionScreen(signPracticeId=" + this.signPracticeId + ")";
        }

        /* JADX INFO: compiled from: SignPracticeRoute.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeSessionScreen$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeSessionScreen;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SignPracticeSessionScreen> serializer() {
                return SignPracticeRoute$SignPracticeSessionScreen$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SignPracticeSessionScreen(int i, long j, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, SignPracticeRoute$SignPracticeSessionScreen$$serializer.INSTANCE.getDescriptor());
            }
            this.signPracticeId = j;
        }

        public SignPracticeSessionScreen(long j) {
            this.signPracticeId = j;
        }

        public final long getSignPracticeId() {
            return this.signPracticeId;
        }
    }
}
