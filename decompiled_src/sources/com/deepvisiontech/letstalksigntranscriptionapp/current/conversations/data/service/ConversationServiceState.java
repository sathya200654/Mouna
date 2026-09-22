package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "", "<init>", "()V", "Idle", "Queued", "Initializing", "Starting", "Stopping", "Listening", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Idle;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Initializing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Listening;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Queued;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Starting;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Stopping;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ConversationServiceState {
    public static final int $stable = 0;

    public /* synthetic */ ConversationServiceState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Idle;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Idle extends ConversationServiceState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Idle)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1459627616;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
            super(null);
        }
    }

    private ConversationServiceState() {
    }

    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Queued;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Queued extends ConversationServiceState {
        public static final int $stable = 0;
        public static final Queued INSTANCE = new Queued();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Queued)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1507623681;
        }

        public String toString() {
            return "Queued";
        }

        private Queued() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Initializing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Initializing extends ConversationServiceState {
        public static final int $stable = 0;
        public static final Initializing INSTANCE = new Initializing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Initializing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 572317401;
        }

        public String toString() {
            return "Initializing";
        }

        private Initializing() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Starting;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Starting extends ConversationServiceState {
        public static final int $stable = 0;
        public static final Starting INSTANCE = new Starting();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Starting)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1058906316;
        }

        public String toString() {
            return "Starting";
        }

        private Starting() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Stopping;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Stopping extends ConversationServiceState {
        public static final int $stable = 0;
        public static final Stopping INSTANCE = new Stopping();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stopping)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1457748224;
        }

        public String toString() {
            return "Stopping";
        }

        private Stopping() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState$Listening;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "activeText", "", "<init>", "(Ljava/lang/String;)V", "getActiveText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Listening extends ConversationServiceState {
        public static final int $stable = 0;
        private final String activeText;

        /* JADX WARN: Illegal instructions before constructor call */
        public Listening() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ Listening copy$default(Listening listening, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = listening.activeText;
            }
            return listening.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getActiveText() {
            return this.activeText;
        }

        public final Listening copy(String activeText) {
            Intrinsics.checkNotNullParameter(activeText, "activeText");
            return new Listening(activeText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Listening) && Intrinsics.areEqual(this.activeText, ((Listening) other).activeText);
        }

        public int hashCode() {
            return this.activeText.hashCode();
        }

        public String toString() {
            return "Listening(activeText=" + this.activeText + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Listening(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "activeText");
            this.activeText = str;
        }

        public /* synthetic */ Listening(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        public final String getActiveText() {
            return this.activeText;
        }
    }
}
