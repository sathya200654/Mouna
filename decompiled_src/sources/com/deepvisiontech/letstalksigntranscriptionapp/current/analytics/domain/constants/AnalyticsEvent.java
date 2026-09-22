package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.helper.ParamConverter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: AnalyticsEvent.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:!\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001!+,-./0123456789:;<=>?@ABCDEFGHIJK¨\u0006L"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "getParams", "", "LoggedOut", "LoggedIn", "NewSessionCreated", "SessionDeleted", "SignPracticeDeleted", "SignPracticeGenerated", "SignPracticeInterpreted", "SignPracticePlayed", "SignVideoUploaded", "ReviewLinkClicked", "WhatsappLinkClicked", "ShareLinkClicked", "PersonaChangeClicked", "SuggestionGenerated", "AppOpened", "AppClosed", "SttStarted", "SttEnded", "SttInterpreted", "TextInterpreted", "TypedLinkSummaryGenerated", "ArticleSummaryGenerated", "ArticleSummaryInterpreted", "ImageScanButtonClicked", "InterpretedExtractedText", "InterpretationModeChange", "SpeakerLanguageChanged", "TtsUsed", "SuggestionSavedToPredef", "SessionSummaryGenerated", "GlobalLanguageChanged", "SpeakerDetection", "HighSpeedMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$AppClosed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$AppOpened;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ArticleSummaryGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ArticleSummaryInterpreted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$GlobalLanguageChanged;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$HighSpeedMode;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ImageScanButtonClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$InterpretationModeChange;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$InterpretedExtractedText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$LoggedIn;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$LoggedOut;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$NewSessionCreated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$PersonaChangeClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ReviewLinkClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SessionDeleted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SessionSummaryGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ShareLinkClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignPracticeDeleted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignPracticeGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignPracticeInterpreted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignPracticePlayed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignVideoUploaded;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SpeakerDetection;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SpeakerLanguageChanged;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttEnded;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttInterpreted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttStarted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SuggestionGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SuggestionSavedToPredef;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TextInterpreted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TtsUsed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TypedLinkSummaryGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$WhatsappLinkClicked;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AnalyticsEvent {
    public static final int $stable = 0;

    public /* synthetic */ AnalyticsEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getMode();

    private AnalyticsEvent() {
    }

    public Map<String, String> getParams() {
        return MapsKt.emptyMap();
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$LoggedOut;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LoggedOut extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final LoggedOut INSTANCE = new LoggedOut();
        private static final String mode = "logout";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoggedOut)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 603525527;
        }

        public String toString() {
            return "LoggedOut";
        }

        private LoggedOut() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$LoggedIn;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LoggedIn extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final LoggedIn INSTANCE = new LoggedIn();
        private static final String mode = "login";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoggedIn)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -673268292;
        }

        public String toString() {
            return "LoggedIn";
        }

        private LoggedIn() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$NewSessionCreated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NewSessionCreated extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final NewSessionCreated INSTANCE = new NewSessionCreated();
        private static final String mode = "session_created";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NewSessionCreated)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 852244829;
        }

        public String toString() {
            return "NewSessionCreated";
        }

        private NewSessionCreated() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SessionDeleted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SessionDeleted extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final SessionDeleted INSTANCE = new SessionDeleted();
        private static final String mode = "session_deleted";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionDeleted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 931544152;
        }

        public String toString() {
            return "SessionDeleted";
        }

        private SessionDeleted() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignPracticeDeleted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SignPracticeDeleted extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final SignPracticeDeleted INSTANCE = new SignPracticeDeleted();
        private static final String mode = "sign_practice_removed";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignPracticeDeleted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -324950964;
        }

        public String toString() {
            return "SignPracticeDeleted";
        }

        private SignPracticeDeleted() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignPracticeGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SignPracticeGenerated extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final SignPracticeGenerated INSTANCE = new SignPracticeGenerated();
        private static final String mode = "sign_practice_generated";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignPracticeGenerated)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1900399874;
        }

        public String toString() {
            return "SignPracticeGenerated";
        }

        private SignPracticeGenerated() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignPracticeInterpreted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SignPracticeInterpreted extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final SignPracticeInterpreted INSTANCE = new SignPracticeInterpreted();
        private static final String mode = "sign_practice_interpreted";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignPracticeInterpreted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1971562209;
        }

        public String toString() {
            return "SignPracticeInterpreted";
        }

        private SignPracticeInterpreted() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignPracticePlayed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SignPracticePlayed extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final SignPracticePlayed INSTANCE = new SignPracticePlayed();
        private static final String mode = "sign_practice_played";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignPracticePlayed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 754865216;
        }

        public String toString() {
            return "SignPracticePlayed";
        }

        private SignPracticePlayed() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SignVideoUploaded;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SignVideoUploaded extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final SignVideoUploaded INSTANCE = new SignVideoUploaded();
        private static final String mode = "sign_video_uploaded";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignVideoUploaded)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -843893399;
        }

        public String toString() {
            return "SignVideoUploaded";
        }

        private SignVideoUploaded() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ReviewLinkClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ReviewLinkClicked extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final ReviewLinkClicked INSTANCE = new ReviewLinkClicked();
        private static final String mode = "review_link_clicked";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReviewLinkClicked)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 514527360;
        }

        public String toString() {
            return "ReviewLinkClicked";
        }

        private ReviewLinkClicked() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$WhatsappLinkClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class WhatsappLinkClicked extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final WhatsappLinkClicked INSTANCE = new WhatsappLinkClicked();
        private static final String mode = "whatsapp_link_clicked";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WhatsappLinkClicked)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -864192698;
        }

        public String toString() {
            return "WhatsappLinkClicked";
        }

        private WhatsappLinkClicked() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ShareLinkClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ShareLinkClicked extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final ShareLinkClicked INSTANCE = new ShareLinkClicked();
        private static final String mode = "share_link_clicked";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShareLinkClicked)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1042463773;
        }

        public String toString() {
            return "ShareLinkClicked";
        }

        private ShareLinkClicked() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$PersonaChangeClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PersonaChangeClicked extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final PersonaChangeClicked INSTANCE = new PersonaChangeClicked();
        private static final String mode = "persona_change";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PersonaChangeClicked)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -632269312;
        }

        public String toString() {
            return "PersonaChangeClicked";
        }

        private PersonaChangeClicked() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SuggestionGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SuggestionGenerated extends AnalyticsEvent {
        public static final int $stable = 0;
        public static final SuggestionGenerated INSTANCE = new SuggestionGenerated();
        private static final String mode = "preconfigured_cloud_sentence_interpreted";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuggestionGenerated)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1859129686;
        }

        public String toString() {
            return "SuggestionGenerated";
        }

        private SuggestionGenerated() {
            super(null);
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return mode;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$AppOpened;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "appName", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAppName$annotations", "()V", "getAppName", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class AppOpened extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appName;
        private final String mode;

        public static /* synthetic */ AppOpened copy$default(AppOpened appOpened, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = appOpened.appName;
            }
            return appOpened.copy(str);
        }

        @SerialName("app_name")
        public static /* synthetic */ void getAppName$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        public final AppOpened copy(String appName) {
            Intrinsics.checkNotNullParameter(appName, "appName");
            return new AppOpened(appName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AppOpened) && Intrinsics.areEqual(this.appName, ((AppOpened) other).appName);
        }

        public int hashCode() {
            return this.appName.hashCode();
        }

        public String toString() {
            return "AppOpened(appName=" + this.appName + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$AppOpened$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$AppOpened;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AppOpened> serializer() {
                return AnalyticsEvent$AppOpened$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AppOpened(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$AppOpened$$serializer.INSTANCE.getDescriptor());
            }
            this.appName = str;
            if ((i & 2) == 0) {
                this.mode = "app_opened";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(AppOpened self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.appName);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "app_opened")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getAppName() {
            return this.appName;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppOpened(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "appName");
            this.appName = str;
            this.mode = "app_opened";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$AppClosed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "appName", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAppName$annotations", "()V", "getAppName", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class AppClosed extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appName;
        private final String mode;

        public static /* synthetic */ AppClosed copy$default(AppClosed appClosed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = appClosed.appName;
            }
            return appClosed.copy(str);
        }

        @SerialName("app_name")
        public static /* synthetic */ void getAppName$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        public final AppClosed copy(String appName) {
            Intrinsics.checkNotNullParameter(appName, "appName");
            return new AppClosed(appName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AppClosed) && Intrinsics.areEqual(this.appName, ((AppClosed) other).appName);
        }

        public int hashCode() {
            return this.appName.hashCode();
        }

        public String toString() {
            return "AppClosed(appName=" + this.appName + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$AppClosed$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$AppClosed;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<AppClosed> serializer() {
                return AnalyticsEvent$AppClosed$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AppClosed(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$AppClosed$$serializer.INSTANCE.getDescriptor());
            }
            this.appName = str;
            if ((i & 2) == 0) {
                this.mode = "app_closed";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(AppClosed self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.appName);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "app_closed")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getAppName() {
            return this.appName;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppClosed(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "appName");
            this.appName = str;
            this.mode = "app_closed";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006#"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttStarted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SttStarted extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;

        public static /* synthetic */ SttStarted copy$default(SttStarted sttStarted, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sttStarted.language;
            }
            return sttStarted.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        public final SttStarted copy(String language) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new SttStarted(language);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SttStarted) && Intrinsics.areEqual(this.language, ((SttStarted) other).language);
        }

        public int hashCode() {
            return this.language.hashCode();
        }

        public String toString() {
            return "SttStarted(language=" + this.language + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttStarted$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttStarted;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SttStarted> serializer() {
                return AnalyticsEvent$SttStarted$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SttStarted(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$SttStarted$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            if ((i & 2) == 0) {
                this.mode = "audio_started";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(SttStarted self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "audio_started")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SttStarted(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.mode = "audio_started";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006#"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttEnded;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SttEnded extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;

        public static /* synthetic */ SttEnded copy$default(SttEnded sttEnded, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sttEnded.language;
            }
            return sttEnded.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        public final SttEnded copy(String language) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new SttEnded(language);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SttEnded) && Intrinsics.areEqual(this.language, ((SttEnded) other).language);
        }

        public int hashCode() {
            return this.language.hashCode();
        }

        public String toString() {
            return "SttEnded(language=" + this.language + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttEnded$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttEnded;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SttEnded> serializer() {
                return AnalyticsEvent$SttEnded$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SttEnded(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$SttEnded$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            if ((i & 2) == 0) {
                this.mode = "audio_ended";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(SttEnded self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "audio_ended")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SttEnded(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.mode = "audio_ended";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B7\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttInterpreted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "audioTextSize", "", "<init>", "(Ljava/lang/String;I)V", "seen0", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getAudioTextSize", "()I", "getMode", "getParams", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SttInterpreted extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int audioTextSize;
        private final String language;
        private final String mode;

        public static /* synthetic */ SttInterpreted copy$default(SttInterpreted sttInterpreted, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sttInterpreted.language;
            }
            if ((i2 & 2) != 0) {
                i = sttInterpreted.audioTextSize;
            }
            return sttInterpreted.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getAudioTextSize() {
            return this.audioTextSize;
        }

        public final SttInterpreted copy(String language, int audioTextSize) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new SttInterpreted(language, audioTextSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SttInterpreted)) {
                return false;
            }
            SttInterpreted sttInterpreted = (SttInterpreted) other;
            return Intrinsics.areEqual(this.language, sttInterpreted.language) && this.audioTextSize == sttInterpreted.audioTextSize;
        }

        public int hashCode() {
            return (this.language.hashCode() * 31) + Integer.hashCode(this.audioTextSize);
        }

        public String toString() {
            return "SttInterpreted(language=" + this.language + ", audioTextSize=" + this.audioTextSize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttInterpreted$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SttInterpreted;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SttInterpreted> serializer() {
                return AnalyticsEvent$SttInterpreted$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SttInterpreted(int i, String str, int i2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, AnalyticsEvent$SttInterpreted$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            this.audioTextSize = i2;
            if ((i & 4) == 0) {
                this.mode = "audio_interpreted";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(SttInterpreted self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            output.encodeIntElement(serialDesc, 1, self.audioTextSize);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.getMode(), "audio_interpreted")) {
                return;
            }
            output.encodeStringElement(serialDesc, 2, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        public final int getAudioTextSize() {
            return this.audioTextSize;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SttInterpreted(String str, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.audioTextSize = i;
            this.mode = "audio_interpreted";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B7\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TextInterpreted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "textSize", "", "<init>", "(Ljava/lang/String;I)V", "seen0", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getTextSize", "()I", "getMode", "getParams", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TextInterpreted extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;
        private final int textSize;

        public static /* synthetic */ TextInterpreted copy$default(TextInterpreted textInterpreted, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = textInterpreted.language;
            }
            if ((i2 & 2) != 0) {
                i = textInterpreted.textSize;
            }
            return textInterpreted.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        public final TextInterpreted copy(String language, int textSize) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new TextInterpreted(language, textSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextInterpreted)) {
                return false;
            }
            TextInterpreted textInterpreted = (TextInterpreted) other;
            return Intrinsics.areEqual(this.language, textInterpreted.language) && this.textSize == textInterpreted.textSize;
        }

        public int hashCode() {
            return (this.language.hashCode() * 31) + Integer.hashCode(this.textSize);
        }

        public String toString() {
            return "TextInterpreted(language=" + this.language + ", textSize=" + this.textSize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TextInterpreted$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TextInterpreted;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<TextInterpreted> serializer() {
                return AnalyticsEvent$TextInterpreted$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TextInterpreted(int i, String str, int i2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, AnalyticsEvent$TextInterpreted$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            this.textSize = i2;
            if ((i & 4) == 0) {
                this.mode = "text_interpreted";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(TextInterpreted self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            output.encodeIntElement(serialDesc, 1, self.textSize);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.getMode(), "text_interpreted")) {
                return;
            }
            output.encodeStringElement(serialDesc, 2, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextInterpreted(String str, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.textSize = i;
            this.mode = "text_interpreted";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB?\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\n\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006,"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TypedLinkSummaryGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "websiteUrl", "", "websiteTextSize", "", "websiteSummaryTextSize", "<init>", "(Ljava/lang/String;II)V", "seen0", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWebsiteUrl$annotations", "()V", "getWebsiteUrl", "()Ljava/lang/String;", "getWebsiteTextSize", "()I", "getWebsiteSummaryTextSize", "getMode", "getParams", "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TypedLinkSummaryGenerated extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String mode;
        private final int websiteSummaryTextSize;
        private final int websiteTextSize;
        private final String websiteUrl;

        public static /* synthetic */ TypedLinkSummaryGenerated copy$default(TypedLinkSummaryGenerated typedLinkSummaryGenerated, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = typedLinkSummaryGenerated.websiteUrl;
            }
            if ((i3 & 2) != 0) {
                i = typedLinkSummaryGenerated.websiteTextSize;
            }
            if ((i3 & 4) != 0) {
                i2 = typedLinkSummaryGenerated.websiteSummaryTextSize;
            }
            return typedLinkSummaryGenerated.copy(str, i, i2);
        }

        @SerialName("website_url")
        public static /* synthetic */ void getWebsiteUrl$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getWebsiteUrl() {
            return this.websiteUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getWebsiteTextSize() {
            return this.websiteTextSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getWebsiteSummaryTextSize() {
            return this.websiteSummaryTextSize;
        }

        public final TypedLinkSummaryGenerated copy(String websiteUrl, int websiteTextSize, int websiteSummaryTextSize) {
            Intrinsics.checkNotNullParameter(websiteUrl, "websiteUrl");
            return new TypedLinkSummaryGenerated(websiteUrl, websiteTextSize, websiteSummaryTextSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TypedLinkSummaryGenerated)) {
                return false;
            }
            TypedLinkSummaryGenerated typedLinkSummaryGenerated = (TypedLinkSummaryGenerated) other;
            return Intrinsics.areEqual(this.websiteUrl, typedLinkSummaryGenerated.websiteUrl) && this.websiteTextSize == typedLinkSummaryGenerated.websiteTextSize && this.websiteSummaryTextSize == typedLinkSummaryGenerated.websiteSummaryTextSize;
        }

        public int hashCode() {
            return (((this.websiteUrl.hashCode() * 31) + Integer.hashCode(this.websiteTextSize)) * 31) + Integer.hashCode(this.websiteSummaryTextSize);
        }

        public String toString() {
            return "TypedLinkSummaryGenerated(websiteUrl=" + this.websiteUrl + ", websiteTextSize=" + this.websiteTextSize + ", websiteSummaryTextSize=" + this.websiteSummaryTextSize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TypedLinkSummaryGenerated$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TypedLinkSummaryGenerated;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<TypedLinkSummaryGenerated> serializer() {
                return AnalyticsEvent$TypedLinkSummaryGenerated$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TypedLinkSummaryGenerated(int i, String str, int i2, int i3, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, AnalyticsEvent$TypedLinkSummaryGenerated$$serializer.INSTANCE.getDescriptor());
            }
            this.websiteUrl = str;
            this.websiteTextSize = i2;
            this.websiteSummaryTextSize = i3;
            if ((i & 8) == 0) {
                this.mode = "text_box_link_summary_generated";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(TypedLinkSummaryGenerated self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.websiteUrl);
            output.encodeIntElement(serialDesc, 1, self.websiteTextSize);
            output.encodeIntElement(serialDesc, 2, self.websiteSummaryTextSize);
            if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.getMode(), "text_box_link_summary_generated")) {
                return;
            }
            output.encodeStringElement(serialDesc, 3, self.getMode());
        }

        public final String getWebsiteUrl() {
            return this.websiteUrl;
        }

        public final int getWebsiteTextSize() {
            return this.websiteTextSize;
        }

        public final int getWebsiteSummaryTextSize() {
            return this.websiteSummaryTextSize;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypedLinkSummaryGenerated(String str, int i, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "websiteUrl");
            this.websiteUrl = str;
            this.websiteTextSize = i;
            this.websiteSummaryTextSize = i2;
            this.mode = "text_box_link_summary_generated";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B7\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ArticleSummaryGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "textSize", "", "<init>", "(Ljava/lang/String;I)V", "seen0", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getTextSize", "()I", "getMode", "getParams", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ArticleSummaryGenerated extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;
        private final int textSize;

        public static /* synthetic */ ArticleSummaryGenerated copy$default(ArticleSummaryGenerated articleSummaryGenerated, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = articleSummaryGenerated.language;
            }
            if ((i2 & 2) != 0) {
                i = articleSummaryGenerated.textSize;
            }
            return articleSummaryGenerated.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        public final ArticleSummaryGenerated copy(String language, int textSize) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new ArticleSummaryGenerated(language, textSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArticleSummaryGenerated)) {
                return false;
            }
            ArticleSummaryGenerated articleSummaryGenerated = (ArticleSummaryGenerated) other;
            return Intrinsics.areEqual(this.language, articleSummaryGenerated.language) && this.textSize == articleSummaryGenerated.textSize;
        }

        public int hashCode() {
            return (this.language.hashCode() * 31) + Integer.hashCode(this.textSize);
        }

        public String toString() {
            return "ArticleSummaryGenerated(language=" + this.language + ", textSize=" + this.textSize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ArticleSummaryGenerated$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ArticleSummaryGenerated;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ArticleSummaryGenerated> serializer() {
                return AnalyticsEvent$ArticleSummaryGenerated$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ArticleSummaryGenerated(int i, String str, int i2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, AnalyticsEvent$ArticleSummaryGenerated$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            this.textSize = i2;
            if ((i & 4) == 0) {
                this.mode = "article_summary_generated";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(ArticleSummaryGenerated self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            output.encodeIntElement(serialDesc, 1, self.textSize);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.getMode(), "article_summary_generated")) {
                return;
            }
            output.encodeStringElement(serialDesc, 2, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArticleSummaryGenerated(String str, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.textSize = i;
            this.mode = "article_summary_generated";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B7\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ArticleSummaryInterpreted;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "textSize", "", "<init>", "(Ljava/lang/String;I)V", "seen0", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getTextSize", "()I", "getMode", "getParams", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ArticleSummaryInterpreted extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;
        private final int textSize;

        public static /* synthetic */ ArticleSummaryInterpreted copy$default(ArticleSummaryInterpreted articleSummaryInterpreted, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = articleSummaryInterpreted.language;
            }
            if ((i2 & 2) != 0) {
                i = articleSummaryInterpreted.textSize;
            }
            return articleSummaryInterpreted.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        public final ArticleSummaryInterpreted copy(String language, int textSize) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new ArticleSummaryInterpreted(language, textSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArticleSummaryInterpreted)) {
                return false;
            }
            ArticleSummaryInterpreted articleSummaryInterpreted = (ArticleSummaryInterpreted) other;
            return Intrinsics.areEqual(this.language, articleSummaryInterpreted.language) && this.textSize == articleSummaryInterpreted.textSize;
        }

        public int hashCode() {
            return (this.language.hashCode() * 31) + Integer.hashCode(this.textSize);
        }

        public String toString() {
            return "ArticleSummaryInterpreted(language=" + this.language + ", textSize=" + this.textSize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ArticleSummaryInterpreted$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ArticleSummaryInterpreted;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ArticleSummaryInterpreted> serializer() {
                return AnalyticsEvent$ArticleSummaryInterpreted$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ArticleSummaryInterpreted(int i, String str, int i2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, AnalyticsEvent$ArticleSummaryInterpreted$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            this.textSize = i2;
            if ((i & 4) == 0) {
                this.mode = "article_summary_interpreted";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(ArticleSummaryInterpreted self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            output.encodeIntElement(serialDesc, 1, self.textSize);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.getMode(), "article_summary_interpreted")) {
                return;
            }
            output.encodeStringElement(serialDesc, 2, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArticleSummaryInterpreted(String str, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.textSize = i;
            this.mode = "article_summary_interpreted";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006#"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ImageScanButtonClicked;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ImageScanButtonClicked extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;

        public static /* synthetic */ ImageScanButtonClicked copy$default(ImageScanButtonClicked imageScanButtonClicked, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imageScanButtonClicked.language;
            }
            return imageScanButtonClicked.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        public final ImageScanButtonClicked copy(String language) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new ImageScanButtonClicked(language);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ImageScanButtonClicked) && Intrinsics.areEqual(this.language, ((ImageScanButtonClicked) other).language);
        }

        public int hashCode() {
            return this.language.hashCode();
        }

        public String toString() {
            return "ImageScanButtonClicked(language=" + this.language + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ImageScanButtonClicked$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$ImageScanButtonClicked;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<ImageScanButtonClicked> serializer() {
                return AnalyticsEvent$ImageScanButtonClicked$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ImageScanButtonClicked(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$ImageScanButtonClicked$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            if ((i & 2) == 0) {
                this.mode = "scan_opened";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(ImageScanButtonClicked self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "scan_opened")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageScanButtonClicked(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.mode = "scan_opened";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB?\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\n\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006*"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$InterpretedExtractedText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "scanTextSize", "", "scanTextSummarySize", "<init>", "(Ljava/lang/String;II)V", "seen0", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getScanTextSize", "()I", "getScanTextSummarySize", "getMode", "getParams", "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InterpretedExtractedText extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;
        private final int scanTextSize;
        private final int scanTextSummarySize;

        public static /* synthetic */ InterpretedExtractedText copy$default(InterpretedExtractedText interpretedExtractedText, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = interpretedExtractedText.language;
            }
            if ((i3 & 2) != 0) {
                i = interpretedExtractedText.scanTextSize;
            }
            if ((i3 & 4) != 0) {
                i2 = interpretedExtractedText.scanTextSummarySize;
            }
            return interpretedExtractedText.copy(str, i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getScanTextSize() {
            return this.scanTextSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getScanTextSummarySize() {
            return this.scanTextSummarySize;
        }

        public final InterpretedExtractedText copy(String language, int scanTextSize, int scanTextSummarySize) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new InterpretedExtractedText(language, scanTextSize, scanTextSummarySize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InterpretedExtractedText)) {
                return false;
            }
            InterpretedExtractedText interpretedExtractedText = (InterpretedExtractedText) other;
            return Intrinsics.areEqual(this.language, interpretedExtractedText.language) && this.scanTextSize == interpretedExtractedText.scanTextSize && this.scanTextSummarySize == interpretedExtractedText.scanTextSummarySize;
        }

        public int hashCode() {
            return (((this.language.hashCode() * 31) + Integer.hashCode(this.scanTextSize)) * 31) + Integer.hashCode(this.scanTextSummarySize);
        }

        public String toString() {
            return "InterpretedExtractedText(language=" + this.language + ", scanTextSize=" + this.scanTextSize + ", scanTextSummarySize=" + this.scanTextSummarySize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$InterpretedExtractedText$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$InterpretedExtractedText;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<InterpretedExtractedText> serializer() {
                return AnalyticsEvent$InterpretedExtractedText$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ InterpretedExtractedText(int i, String str, int i2, int i3, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, AnalyticsEvent$InterpretedExtractedText$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            this.scanTextSize = i2;
            this.scanTextSummarySize = i3;
            if ((i & 8) == 0) {
                this.mode = "scan_interpreted";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(InterpretedExtractedText self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            output.encodeIntElement(serialDesc, 1, self.scanTextSize);
            output.encodeIntElement(serialDesc, 2, self.scanTextSummarySize);
            if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.getMode(), "scan_interpreted")) {
                return;
            }
            output.encodeStringElement(serialDesc, 3, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        public final int getScanTextSize() {
            return this.scanTextSize;
        }

        public final int getScanTextSummarySize() {
            return this.scanTextSummarySize;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InterpretedExtractedText(String str, int i, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.scanTextSize = i;
            this.scanTextSummarySize = i2;
            this.mode = "scan_interpreted";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$InterpretationModeChange;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "interpretationMode", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInterpretationMode$annotations", "()V", "getInterpretationMode", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class InterpretationModeChange extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String interpretationMode;
        private final String mode;

        public static /* synthetic */ InterpretationModeChange copy$default(InterpretationModeChange interpretationModeChange, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = interpretationModeChange.interpretationMode;
            }
            return interpretationModeChange.copy(str);
        }

        @SerialName("interpretation_mode")
        public static /* synthetic */ void getInterpretationMode$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getInterpretationMode() {
            return this.interpretationMode;
        }

        public final InterpretationModeChange copy(String interpretationMode) {
            Intrinsics.checkNotNullParameter(interpretationMode, "interpretationMode");
            return new InterpretationModeChange(interpretationMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InterpretationModeChange) && Intrinsics.areEqual(this.interpretationMode, ((InterpretationModeChange) other).interpretationMode);
        }

        public int hashCode() {
            return this.interpretationMode.hashCode();
        }

        public String toString() {
            return "InterpretationModeChange(interpretationMode=" + this.interpretationMode + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$InterpretationModeChange$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$InterpretationModeChange;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<InterpretationModeChange> serializer() {
                return AnalyticsEvent$InterpretationModeChange$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ InterpretationModeChange(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$InterpretationModeChange$$serializer.INSTANCE.getDescriptor());
            }
            this.interpretationMode = str;
            if ((i & 2) == 0) {
                this.mode = "interpretation_mode_change";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(InterpretationModeChange self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.interpretationMode);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "interpretation_mode_change")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getInterpretationMode() {
            return this.interpretationMode;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InterpretationModeChange(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "interpretationMode");
            this.interpretationMode = str;
            this.mode = "interpretation_mode_change";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006#"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SpeakerLanguageChanged;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SpeakerLanguageChanged extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;

        public static /* synthetic */ SpeakerLanguageChanged copy$default(SpeakerLanguageChanged speakerLanguageChanged, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = speakerLanguageChanged.language;
            }
            return speakerLanguageChanged.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        public final SpeakerLanguageChanged copy(String language) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new SpeakerLanguageChanged(language);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SpeakerLanguageChanged) && Intrinsics.areEqual(this.language, ((SpeakerLanguageChanged) other).language);
        }

        public int hashCode() {
            return this.language.hashCode();
        }

        public String toString() {
            return "SpeakerLanguageChanged(language=" + this.language + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SpeakerLanguageChanged$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SpeakerLanguageChanged;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SpeakerLanguageChanged> serializer() {
                return AnalyticsEvent$SpeakerLanguageChanged$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SpeakerLanguageChanged(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$SpeakerLanguageChanged$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            if ((i & 2) == 0) {
                this.mode = "transcription_language_changed";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(SpeakerLanguageChanged self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "transcription_language_changed")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpeakerLanguageChanged(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.mode = "transcription_language_changed";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B7\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TtsUsed;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "textSize", "", "<init>", "(Ljava/lang/String;I)V", "seen0", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getTextSize", "()I", "getMode", "getParams", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TtsUsed extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;
        private final int textSize;

        public static /* synthetic */ TtsUsed copy$default(TtsUsed ttsUsed, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = ttsUsed.language;
            }
            if ((i2 & 2) != 0) {
                i = ttsUsed.textSize;
            }
            return ttsUsed.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        public final TtsUsed copy(String language, int textSize) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new TtsUsed(language, textSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TtsUsed)) {
                return false;
            }
            TtsUsed ttsUsed = (TtsUsed) other;
            return Intrinsics.areEqual(this.language, ttsUsed.language) && this.textSize == ttsUsed.textSize;
        }

        public int hashCode() {
            return (this.language.hashCode() * 31) + Integer.hashCode(this.textSize);
        }

        public String toString() {
            return "TtsUsed(language=" + this.language + ", textSize=" + this.textSize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TtsUsed$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$TtsUsed;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<TtsUsed> serializer() {
                return AnalyticsEvent$TtsUsed$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TtsUsed(int i, String str, int i2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, AnalyticsEvent$TtsUsed$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            this.textSize = i2;
            if ((i & 4) == 0) {
                this.mode = "text_spoken";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(TtsUsed self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            output.encodeIntElement(serialDesc, 1, self.textSize);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.getMode(), "text_spoken")) {
                return;
            }
            output.encodeStringElement(serialDesc, 2, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TtsUsed(String str, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.textSize = i;
            this.mode = "text_spoken";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B7\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SuggestionSavedToPredef;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "textSize", "", "<init>", "(Ljava/lang/String;I)V", "seen0", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getTextSize", "()I", "getMode", "getParams", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SuggestionSavedToPredef extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;
        private final int textSize;

        public static /* synthetic */ SuggestionSavedToPredef copy$default(SuggestionSavedToPredef suggestionSavedToPredef, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = suggestionSavedToPredef.language;
            }
            if ((i2 & 2) != 0) {
                i = suggestionSavedToPredef.textSize;
            }
            return suggestionSavedToPredef.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        public final SuggestionSavedToPredef copy(String language, int textSize) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new SuggestionSavedToPredef(language, textSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuggestionSavedToPredef)) {
                return false;
            }
            SuggestionSavedToPredef suggestionSavedToPredef = (SuggestionSavedToPredef) other;
            return Intrinsics.areEqual(this.language, suggestionSavedToPredef.language) && this.textSize == suggestionSavedToPredef.textSize;
        }

        public int hashCode() {
            return (this.language.hashCode() * 31) + Integer.hashCode(this.textSize);
        }

        public String toString() {
            return "SuggestionSavedToPredef(language=" + this.language + ", textSize=" + this.textSize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SuggestionSavedToPredef$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SuggestionSavedToPredef;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SuggestionSavedToPredef> serializer() {
                return AnalyticsEvent$SuggestionSavedToPredef$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SuggestionSavedToPredef(int i, String str, int i2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, AnalyticsEvent$SuggestionSavedToPredef$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            this.textSize = i2;
            if ((i & 4) == 0) {
                this.mode = "preconfigured_custom_sentence_added";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(SuggestionSavedToPredef self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            output.encodeIntElement(serialDesc, 1, self.textSize);
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && Intrinsics.areEqual(self.getMode(), "preconfigured_custom_sentence_added")) {
                return;
            }
            output.encodeStringElement(serialDesc, 2, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        public final int getTextSize() {
            return this.textSize;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SuggestionSavedToPredef(String str, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.textSize = i;
            this.mode = "preconfigured_custom_sentence_added";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B-\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SessionSummaryGenerated;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "textSize", "", "<init>", "(I)V", "seen0", "mode", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTextSize", "()I", "getMode", "()Ljava/lang/String;", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SessionSummaryGenerated extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String mode;
        private final int textSize;

        public static /* synthetic */ SessionSummaryGenerated copy$default(SessionSummaryGenerated sessionSummaryGenerated, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = sessionSummaryGenerated.textSize;
            }
            return sessionSummaryGenerated.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        public final SessionSummaryGenerated copy(int textSize) {
            return new SessionSummaryGenerated(textSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SessionSummaryGenerated) && this.textSize == ((SessionSummaryGenerated) other).textSize;
        }

        public int hashCode() {
            return Integer.hashCode(this.textSize);
        }

        public String toString() {
            return "SessionSummaryGenerated(textSize=" + this.textSize + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SessionSummaryGenerated$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SessionSummaryGenerated;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SessionSummaryGenerated> serializer() {
                return AnalyticsEvent$SessionSummaryGenerated$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SessionSummaryGenerated(int i, int i2, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$SessionSummaryGenerated$$serializer.INSTANCE.getDescriptor());
            }
            this.textSize = i2;
            if ((i & 2) == 0) {
                this.mode = "session_summary_interpreted";
            } else {
                this.mode = str;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(SessionSummaryGenerated self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.textSize);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "session_summary_interpreted")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final int getTextSize() {
            return this.textSize;
        }

        public SessionSummaryGenerated(int i) {
            super(null);
            this.textSize = i;
            this.mode = "session_summary_interpreted";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006#"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$GlobalLanguageChanged;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "language", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguage", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class GlobalLanguageChanged extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final String mode;

        public static /* synthetic */ GlobalLanguageChanged copy$default(GlobalLanguageChanged globalLanguageChanged, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = globalLanguageChanged.language;
            }
            return globalLanguageChanged.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        public final GlobalLanguageChanged copy(String language) {
            Intrinsics.checkNotNullParameter(language, "language");
            return new GlobalLanguageChanged(language);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GlobalLanguageChanged) && Intrinsics.areEqual(this.language, ((GlobalLanguageChanged) other).language);
        }

        public int hashCode() {
            return this.language.hashCode();
        }

        public String toString() {
            return "GlobalLanguageChanged(language=" + this.language + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$GlobalLanguageChanged$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$GlobalLanguageChanged;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<GlobalLanguageChanged> serializer() {
                return AnalyticsEvent$GlobalLanguageChanged$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GlobalLanguageChanged(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$GlobalLanguageChanged$$serializer.INSTANCE.getDescriptor());
            }
            this.language = str;
            if ((i & 2) == 0) {
                this.mode = "global_language_changed";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(GlobalLanguageChanged self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.language);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "global_language_changed")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getLanguage() {
            return this.language;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GlobalLanguageChanged(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "language");
            this.language = str;
            this.mode = "global_language_changed";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SpeakerDetection;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "modeStatus", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModeStatus$annotations", "()V", "getModeStatus", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SpeakerDetection extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String mode;
        private final String modeStatus;

        public static /* synthetic */ SpeakerDetection copy$default(SpeakerDetection speakerDetection, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = speakerDetection.modeStatus;
            }
            return speakerDetection.copy(str);
        }

        @SerialName("mode_status")
        public static /* synthetic */ void getModeStatus$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getModeStatus() {
            return this.modeStatus;
        }

        public final SpeakerDetection copy(String modeStatus) {
            Intrinsics.checkNotNullParameter(modeStatus, "modeStatus");
            return new SpeakerDetection(modeStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SpeakerDetection) && Intrinsics.areEqual(this.modeStatus, ((SpeakerDetection) other).modeStatus);
        }

        public int hashCode() {
            return this.modeStatus.hashCode();
        }

        public String toString() {
            return "SpeakerDetection(modeStatus=" + this.modeStatus + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SpeakerDetection$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$SpeakerDetection;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SpeakerDetection> serializer() {
                return AnalyticsEvent$SpeakerDetection$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SpeakerDetection(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$SpeakerDetection$$serializer.INSTANCE.getDescriptor());
            }
            this.modeStatus = str;
            if ((i & 2) == 0) {
                this.mode = "speaker_detection";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(SpeakerDetection self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.modeStatus);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "speaker_detection")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getModeStatus() {
            return this.modeStatus;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpeakerDetection(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "modeStatus");
            this.modeStatus = str;
            this.mode = "speaker_detection";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$HighSpeedMode;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "modeStatus", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "mode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModeStatus$annotations", "()V", "getModeStatus", "()Ljava/lang/String;", "getMode", "getParams", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class HighSpeedMode extends AnalyticsEvent {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String mode;
        private final String modeStatus;

        public static /* synthetic */ HighSpeedMode copy$default(HighSpeedMode highSpeedMode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = highSpeedMode.modeStatus;
            }
            return highSpeedMode.copy(str);
        }

        @SerialName("mode_status")
        public static /* synthetic */ void getModeStatus$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getModeStatus() {
            return this.modeStatus;
        }

        public final HighSpeedMode copy(String modeStatus) {
            Intrinsics.checkNotNullParameter(modeStatus, "modeStatus");
            return new HighSpeedMode(modeStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof HighSpeedMode) && Intrinsics.areEqual(this.modeStatus, ((HighSpeedMode) other).modeStatus);
        }

        public int hashCode() {
            return this.modeStatus.hashCode();
        }

        public String toString() {
            return "HighSpeedMode(modeStatus=" + this.modeStatus + ")";
        }

        /* JADX INFO: compiled from: AnalyticsEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$HighSpeedMode$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent$HighSpeedMode;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<HighSpeedMode> serializer() {
                return AnalyticsEvent$HighSpeedMode$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HighSpeedMode(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, AnalyticsEvent$HighSpeedMode$$serializer.INSTANCE.getDescriptor());
            }
            this.modeStatus = str;
            if ((i & 2) == 0) {
                this.mode = "high_speed_mode";
            } else {
                this.mode = str2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_release(HighSpeedMode self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.modeStatus);
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.getMode(), "high_speed_mode")) {
                return;
            }
            output.encodeStringElement(serialDesc, 1, self.getMode());
        }

        public final String getModeStatus() {
            return this.modeStatus;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HighSpeedMode(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "modeStatus");
            this.modeStatus = str;
            this.mode = "high_speed_mode";
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public String getMode() {
            return this.mode;
        }

        @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent
        public Map<String, String> getParams() {
            Json json = ParamConverter.INSTANCE.getJson();
            json.getSerializersModule();
            JsonObject jsonObjectEncodeToJsonElement = json.encodeToJsonElement(INSTANCE.serializer(), this);
            JsonObject jsonObject = jsonObjectEncodeToJsonElement instanceof JsonObject ? jsonObjectEncodeToJsonElement : null;
            if (jsonObject == null) {
                return MapsKt.emptyMap();
            }
            Set<Map.Entry> setEntrySet = jsonObject.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
            for (Map.Entry entry : setEntrySet) {
                Pair pair = TuplesKt.to((String) entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }
    }
}
