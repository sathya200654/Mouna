package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* JADX INFO: compiled from: ConversationRoute.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute;", "", "ConversationListRoute", "ConversationRoute", "ConversationSettingsRoute", "DocumentScannerRoute", "SignUploadRoute", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$ConversationListRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$ConversationRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$ConversationSettingsRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$DocumentScannerRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$SignUploadRoute;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationNavigationRoute {

    /* JADX INFO: compiled from: ConversationRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$ConversationListRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ConversationListRoute implements ConversationNavigationRoute {
        public static final int $stable = 0;
        public static final ConversationListRoute INSTANCE = new ConversationListRoute();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute$ConversationListRoute$$ExternalSyntheticLambda0
            public final Object invoke() {
                return ConversationNavigationRoute.ConversationListRoute._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConversationListRoute)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1618017132;
        }

        public String toString() {
            return "ConversationListRoute";
        }

        private ConversationListRoute() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute.ConversationListRoute", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<ConversationListRoute> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: ConversationRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$ConversationRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ConversationRoute implements ConversationNavigationRoute {
        public static final int $stable = 0;
        public static final ConversationRoute INSTANCE = new ConversationRoute();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute$ConversationRoute$$ExternalSyntheticLambda0
            public final Object invoke() {
                return ConversationNavigationRoute.ConversationRoute._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConversationRoute)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -120741398;
        }

        public String toString() {
            return "ConversationRoute";
        }

        private ConversationRoute() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute.ConversationRoute", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<ConversationRoute> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: ConversationRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$ConversationSettingsRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ConversationSettingsRoute implements ConversationNavigationRoute {
        public static final int $stable = 0;
        public static final ConversationSettingsRoute INSTANCE = new ConversationSettingsRoute();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute$ConversationSettingsRoute$$ExternalSyntheticLambda0
            public final Object invoke() {
                return ConversationNavigationRoute.ConversationSettingsRoute._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConversationSettingsRoute)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2118247047;
        }

        public String toString() {
            return "ConversationSettingsRoute";
        }

        private ConversationSettingsRoute() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute.ConversationSettingsRoute", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<ConversationSettingsRoute> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: ConversationRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$DocumentScannerRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class DocumentScannerRoute implements ConversationNavigationRoute {
        public static final int $stable = 0;
        public static final DocumentScannerRoute INSTANCE = new DocumentScannerRoute();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute$DocumentScannerRoute$$ExternalSyntheticLambda0
            public final Object invoke() {
                return ConversationNavigationRoute.DocumentScannerRoute._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DocumentScannerRoute)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -627834174;
        }

        public String toString() {
            return "DocumentScannerRoute";
        }

        private DocumentScannerRoute() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute.DocumentScannerRoute", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<DocumentScannerRoute> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: ConversationRoute.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute$SignUploadRoute;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/navigation/ConversationNavigationRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SignUploadRoute implements ConversationNavigationRoute {
        public static final int $stable = 0;
        public static final SignUploadRoute INSTANCE = new SignUploadRoute();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute$SignUploadRoute$$ExternalSyntheticLambda0
            public final Object invoke() {
                return ConversationNavigationRoute.SignUploadRoute._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignUploadRoute)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2040314415;
        }

        public String toString() {
            return "SignUploadRoute";
        }

        private SignUploadRoute() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute.SignUploadRoute", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SignUploadRoute> serializer() {
            return get$cachedSerializer();
        }
    }
}
