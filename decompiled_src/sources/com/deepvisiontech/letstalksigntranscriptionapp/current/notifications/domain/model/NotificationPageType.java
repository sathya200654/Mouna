package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: NotificationPageType.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationPageType;", "", "<init>", "(Ljava/lang/String;I)V", "BASIC", "TEXT", "LIST", "IMAGE", "VIDEO", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public enum NotificationPageType {
    BASIC,
    TEXT,
    LIST,
    IMAGE,
    VIDEO;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationPageType$$ExternalSyntheticLambda0
        public final Object invoke() {
            return NotificationPageType._init_$_anonymous_();
        }
    });

    public static EnumEntries<NotificationPageType> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: NotificationPageType.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationPageType$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationPageType;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) NotificationPageType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NotificationPageType> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationPageType", values());
    }
}
