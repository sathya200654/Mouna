package com.google.firebase.inappmessaging;

import androidx.room.util.TableInfo;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.type.Date;
import com.google.type.TimeOfDay;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class CommonTypesProto {

    public interface CampaignTimeOrBuilder extends MessageLiteOrBuilder {
        Date getDate();

        TimeOfDay getTime();

        String getTimeZone();

        ByteString getTimeZoneBytes();

        boolean hasDate();

        boolean hasTime();
    }

    public interface DailyAnalyticsSummaryOrBuilder extends MessageLiteOrBuilder {
        int getClicks();

        int getErrors();

        int getImpressions();

        long getStartOfDayMillis();
    }

    public interface DailyConversionSummaryOrBuilder extends MessageLiteOrBuilder {
        int getConversions();

        long getStartOfDayMillis();
    }

    public interface EventOrBuilder extends MessageLiteOrBuilder {
        int getCount();

        String getName();

        ByteString getNameBytes();

        long getPreviousTimestampMillis();

        long getTimestampMillis();

        TriggerParam getTriggerParams(int i);

        int getTriggerParamsCount();

        List<TriggerParam> getTriggerParamsList();
    }

    public interface ExperimentVariantOrBuilder extends MessageLiteOrBuilder {
        MessagesProto.Content getContent();

        int getIndex();

        boolean hasContent();
    }

    public interface PriorityOrBuilder extends MessageLiteOrBuilder {
        int getValue();
    }

    public interface ScionConversionEventOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();
    }

    public interface TriggerParamOrBuilder extends MessageLiteOrBuilder {
        double getDoubleValue();

        float getFloatValue();

        long getIntValue();

        String getName();

        ByteString getNameBytes();

        String getStringValue();

        ByteString getStringValueBytes();
    }

    public interface TriggeringConditionOrBuilder extends MessageLiteOrBuilder {
        TriggeringCondition.ConditionCase getConditionCase();

        Event getEvent();

        Trigger getFiamTrigger();

        int getFiamTriggerValue();

        boolean hasEvent();

        boolean hasFiamTrigger();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private CommonTypesProto() {
    }

    public enum Trigger implements Internal.EnumLite {
        UNKNOWN_TRIGGER(0),
        APP_LAUNCH(1),
        ON_FOREGROUND(2),
        UNRECOGNIZED(-1);

        public static final int APP_LAUNCH_VALUE = 1;
        public static final int ON_FOREGROUND_VALUE = 2;
        public static final int UNKNOWN_TRIGGER_VALUE = 0;
        private static final Internal.EnumLiteMap<Trigger> internalValueMap = new Internal.EnumLiteMap<Trigger>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.Trigger.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Trigger findValueByNumber(int i) {
                return Trigger.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static Trigger valueOf(int i) {
            return forNumber(i);
        }

        public static Trigger forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_TRIGGER;
            }
            if (i == 1) {
                return APP_LAUNCH;
            }
            if (i != 2) {
                return null;
            }
            return ON_FOREGROUND;
        }

        public static Internal.EnumLiteMap<Trigger> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return TriggerVerifier.INSTANCE;
        }

        private static final class TriggerVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new TriggerVerifier();

            private TriggerVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Trigger.forNumber(i) != null;
            }
        }

        Trigger(int i) {
            this.value = i;
        }
    }

    public enum CampaignState implements Internal.EnumLite {
        UNKNOWN_CAMPAIGN_STATE(0),
        DRAFT(1),
        PUBLISHED(2),
        STOPPED(3),
        DELETED(4),
        UNRECOGNIZED(-1);

        public static final int DELETED_VALUE = 4;
        public static final int DRAFT_VALUE = 1;
        public static final int PUBLISHED_VALUE = 2;
        public static final int STOPPED_VALUE = 3;
        public static final int UNKNOWN_CAMPAIGN_STATE_VALUE = 0;
        private static final Internal.EnumLiteMap<CampaignState> internalValueMap = new Internal.EnumLiteMap<CampaignState>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.CampaignState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CampaignState findValueByNumber(int i) {
                return CampaignState.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static CampaignState valueOf(int i) {
            return forNumber(i);
        }

        public static CampaignState forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_CAMPAIGN_STATE;
            }
            if (i == 1) {
                return DRAFT;
            }
            if (i == 2) {
                return PUBLISHED;
            }
            if (i == 3) {
                return STOPPED;
            }
            if (i != 4) {
                return null;
            }
            return DELETED;
        }

        public static Internal.EnumLiteMap<CampaignState> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return CampaignStateVerifier.INSTANCE;
        }

        private static final class CampaignStateVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new CampaignStateVerifier();

            private CampaignStateVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return CampaignState.forNumber(i) != null;
            }
        }

        CampaignState(int i) {
            this.value = i;
        }
    }

    public enum ExperimentalCampaignState implements Internal.EnumLite {
        UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE(0),
        EXPERIMENT_DRAFT(1),
        EXPERIMENT_RUNNING(2),
        EXPERIMENT_STOPPED(3),
        EXPERIMENT_ROLLED_OUT(4),
        UNRECOGNIZED(-1);

        public static final int EXPERIMENT_DRAFT_VALUE = 1;
        public static final int EXPERIMENT_ROLLED_OUT_VALUE = 4;
        public static final int EXPERIMENT_RUNNING_VALUE = 2;
        public static final int EXPERIMENT_STOPPED_VALUE = 3;
        public static final int UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE_VALUE = 0;
        private static final Internal.EnumLiteMap<ExperimentalCampaignState> internalValueMap = new Internal.EnumLiteMap<ExperimentalCampaignState>() { // from class: com.google.firebase.inappmessaging.CommonTypesProto.ExperimentalCampaignState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ExperimentalCampaignState findValueByNumber(int i) {
                return ExperimentalCampaignState.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static ExperimentalCampaignState valueOf(int i) {
            return forNumber(i);
        }

        public static ExperimentalCampaignState forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE;
            }
            if (i == 1) {
                return EXPERIMENT_DRAFT;
            }
            if (i == 2) {
                return EXPERIMENT_RUNNING;
            }
            if (i == 3) {
                return EXPERIMENT_STOPPED;
            }
            if (i != 4) {
                return null;
            }
            return EXPERIMENT_ROLLED_OUT;
        }

        public static Internal.EnumLiteMap<ExperimentalCampaignState> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ExperimentalCampaignStateVerifier.INSTANCE;
        }

        private static final class ExperimentalCampaignStateVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new ExperimentalCampaignStateVerifier();

            private ExperimentalCampaignStateVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return ExperimentalCampaignState.forNumber(i) != null;
            }
        }

        ExperimentalCampaignState(int i) {
            this.value = i;
        }
    }

    public static final class CampaignTime extends GeneratedMessageLite<CampaignTime, Builder> implements CampaignTimeOrBuilder {
        public static final int DATE_FIELD_NUMBER = 1;
        private static final CampaignTime DEFAULT_INSTANCE;
        private static volatile Parser<CampaignTime> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        public static final int TIME_ZONE_FIELD_NUMBER = 3;
        private int bitField0_;
        private Date date_;
        private String timeZone_ = "";
        private TimeOfDay time_;

        private CampaignTime() {
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public boolean hasDate() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public Date getDate() {
            Date date = this.date_;
            return date == null ? Date.getDefaultInstance() : date;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDate(Date date) {
            date.getClass();
            this.date_ = date;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDate(Date date) {
            date.getClass();
            Date date2 = this.date_;
            if (date2 != null && date2 != Date.getDefaultInstance()) {
                this.date_ = Date.newBuilder(this.date_).mergeFrom(date).buildPartial();
            } else {
                this.date_ = date;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDate() {
            this.date_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public boolean hasTime() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public TimeOfDay getTime() {
            TimeOfDay timeOfDay = this.time_;
            return timeOfDay == null ? TimeOfDay.getDefaultInstance() : timeOfDay;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(TimeOfDay timeOfDay) {
            timeOfDay.getClass();
            this.time_ = timeOfDay;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTime(TimeOfDay timeOfDay) {
            timeOfDay.getClass();
            TimeOfDay timeOfDay2 = this.time_;
            if (timeOfDay2 != null && timeOfDay2 != TimeOfDay.getDefaultInstance()) {
                this.time_ = TimeOfDay.newBuilder(this.time_).mergeFrom(timeOfDay).buildPartial();
            } else {
                this.time_ = timeOfDay;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.time_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public String getTimeZone() {
            return this.timeZone_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
        public ByteString getTimeZoneBytes() {
            return ByteString.copyFromUtf8(this.timeZone_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeZone(String str) {
            str.getClass();
            this.timeZone_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeZone() {
            this.timeZone_ = getDefaultInstance().getTimeZone();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeZoneBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.timeZone_ = byteString.toStringUtf8();
        }

        public static CampaignTime parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CampaignTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CampaignTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CampaignTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(InputStream inputStream) throws IOException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CampaignTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CampaignTime parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CampaignTime) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CampaignTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CampaignTime) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CampaignTime parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CampaignTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CampaignTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(CampaignTime campaignTime) {
            return DEFAULT_INSTANCE.createBuilder(campaignTime);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<CampaignTime, Builder> implements CampaignTimeOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(CampaignTime.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public boolean hasDate() {
                return ((CampaignTime) this.instance).hasDate();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public Date getDate() {
                return ((CampaignTime) this.instance).getDate();
            }

            public Builder setDate(Date date) {
                copyOnWrite();
                ((CampaignTime) this.instance).setDate(date);
                return this;
            }

            public Builder setDate(Date.Builder builder) {
                copyOnWrite();
                ((CampaignTime) this.instance).setDate(builder.build());
                return this;
            }

            public Builder mergeDate(Date date) {
                copyOnWrite();
                ((CampaignTime) this.instance).mergeDate(date);
                return this;
            }

            public Builder clearDate() {
                copyOnWrite();
                ((CampaignTime) this.instance).clearDate();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public boolean hasTime() {
                return ((CampaignTime) this.instance).hasTime();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public TimeOfDay getTime() {
                return ((CampaignTime) this.instance).getTime();
            }

            public Builder setTime(TimeOfDay timeOfDay) {
                copyOnWrite();
                ((CampaignTime) this.instance).setTime(timeOfDay);
                return this;
            }

            public Builder setTime(TimeOfDay.Builder builder) {
                copyOnWrite();
                ((CampaignTime) this.instance).setTime(builder.build());
                return this;
            }

            public Builder mergeTime(TimeOfDay timeOfDay) {
                copyOnWrite();
                ((CampaignTime) this.instance).mergeTime(timeOfDay);
                return this;
            }

            public Builder clearTime() {
                copyOnWrite();
                ((CampaignTime) this.instance).clearTime();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public String getTimeZone() {
                return ((CampaignTime) this.instance).getTimeZone();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder
            public ByteString getTimeZoneBytes() {
                return ((CampaignTime) this.instance).getTimeZoneBytes();
            }

            public Builder setTimeZone(String str) {
                copyOnWrite();
                ((CampaignTime) this.instance).setTimeZone(str);
                return this;
            }

            public Builder clearTimeZone() {
                copyOnWrite();
                ((CampaignTime) this.instance).clearTimeZone();
                return this;
            }

            public Builder setTimeZoneBytes(ByteString byteString) {
                copyOnWrite();
                ((CampaignTime) this.instance).setTimeZoneBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new CampaignTime();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ", new Object[]{"bitField0_", "date_", "time_", "timeZone_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CampaignTime> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (CampaignTime.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            CampaignTime campaignTime = new CampaignTime();
            DEFAULT_INSTANCE = campaignTime;
            GeneratedMessageLite.registerDefaultInstance(CampaignTime.class, campaignTime);
        }

        public static CampaignTime getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CampaignTime> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.CommonTypesProto$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class TriggeringCondition extends GeneratedMessageLite<TriggeringCondition, Builder> implements TriggeringConditionOrBuilder {
        private static final TriggeringCondition DEFAULT_INSTANCE;
        public static final int EVENT_FIELD_NUMBER = 2;
        public static final int FIAM_TRIGGER_FIELD_NUMBER = 1;
        private static volatile Parser<TriggeringCondition> PARSER;
        private int conditionCase_ = 0;
        private Object condition_;

        private TriggeringCondition() {
        }

        public enum ConditionCase {
            FIAM_TRIGGER(1),
            EVENT(2),
            CONDITION_NOT_SET(0);

            private final int value;

            ConditionCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static ConditionCase valueOf(int i) {
                return forNumber(i);
            }

            public static ConditionCase forNumber(int i) {
                if (i == 0) {
                    return CONDITION_NOT_SET;
                }
                if (i == 1) {
                    return FIAM_TRIGGER;
                }
                if (i != 2) {
                    return null;
                }
                return EVENT;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public ConditionCase getConditionCase() {
            return ConditionCase.forNumber(this.conditionCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCondition() {
            this.conditionCase_ = 0;
            this.condition_ = null;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public boolean hasFiamTrigger() {
            return this.conditionCase_ == 1;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public int getFiamTriggerValue() {
            if (this.conditionCase_ == 1) {
                return ((Integer) this.condition_).intValue();
            }
            return 0;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public Trigger getFiamTrigger() {
            if (this.conditionCase_ == 1) {
                Trigger triggerForNumber = Trigger.forNumber(((Integer) this.condition_).intValue());
                return triggerForNumber == null ? Trigger.UNRECOGNIZED : triggerForNumber;
            }
            return Trigger.UNKNOWN_TRIGGER;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFiamTriggerValue(int i) {
            this.conditionCase_ = 1;
            this.condition_ = Integer.valueOf(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFiamTrigger(Trigger trigger) {
            this.condition_ = Integer.valueOf(trigger.getNumber());
            this.conditionCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFiamTrigger() {
            if (this.conditionCase_ == 1) {
                this.conditionCase_ = 0;
                this.condition_ = null;
            }
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public boolean hasEvent() {
            return this.conditionCase_ == 2;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
        public Event getEvent() {
            if (this.conditionCase_ == 2) {
                return (Event) this.condition_;
            }
            return Event.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvent(Event event) {
            event.getClass();
            this.condition_ = event;
            this.conditionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEvent(Event event) {
            event.getClass();
            if (this.conditionCase_ == 2 && this.condition_ != Event.getDefaultInstance()) {
                this.condition_ = Event.newBuilder((Event) this.condition_).mergeFrom(event).buildPartial();
            } else {
                this.condition_ = event;
            }
            this.conditionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEvent() {
            if (this.conditionCase_ == 2) {
                this.conditionCase_ = 0;
                this.condition_ = null;
            }
        }

        public static TriggeringCondition parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static TriggeringCondition parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TriggeringCondition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TriggeringCondition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(InputStream inputStream) throws IOException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggeringCondition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggeringCondition parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TriggeringCondition) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggeringCondition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TriggeringCondition) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggeringCondition parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TriggeringCondition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TriggeringCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TriggeringCondition triggeringCondition) {
            return DEFAULT_INSTANCE.createBuilder(triggeringCondition);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TriggeringCondition, Builder> implements TriggeringConditionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(TriggeringCondition.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public ConditionCase getConditionCase() {
                return ((TriggeringCondition) this.instance).getConditionCase();
            }

            public Builder clearCondition() {
                copyOnWrite();
                ((TriggeringCondition) this.instance).clearCondition();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public boolean hasFiamTrigger() {
                return ((TriggeringCondition) this.instance).hasFiamTrigger();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public int getFiamTriggerValue() {
                return ((TriggeringCondition) this.instance).getFiamTriggerValue();
            }

            public Builder setFiamTriggerValue(int i) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).setFiamTriggerValue(i);
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public Trigger getFiamTrigger() {
                return ((TriggeringCondition) this.instance).getFiamTrigger();
            }

            public Builder setFiamTrigger(Trigger trigger) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).setFiamTrigger(trigger);
                return this;
            }

            public Builder clearFiamTrigger() {
                copyOnWrite();
                ((TriggeringCondition) this.instance).clearFiamTrigger();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public boolean hasEvent() {
                return ((TriggeringCondition) this.instance).hasEvent();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder
            public Event getEvent() {
                return ((TriggeringCondition) this.instance).getEvent();
            }

            public Builder setEvent(Event event) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).setEvent(event);
                return this;
            }

            public Builder setEvent(Event.Builder builder) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).setEvent(builder.build());
                return this;
            }

            public Builder mergeEvent(Event event) {
                copyOnWrite();
                ((TriggeringCondition) this.instance).mergeEvent(event);
                return this;
            }

            public Builder clearEvent() {
                copyOnWrite();
                ((TriggeringCondition) this.instance).clearEvent();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new TriggeringCondition();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001?\u0000\u0002<\u0000", new Object[]{"condition_", "conditionCase_", Event.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TriggeringCondition> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (TriggeringCondition.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            TriggeringCondition triggeringCondition = new TriggeringCondition();
            DEFAULT_INSTANCE = triggeringCondition;
            GeneratedMessageLite.registerDefaultInstance(TriggeringCondition.class, triggeringCondition);
        }

        public static TriggeringCondition getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TriggeringCondition> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Event extends GeneratedMessageLite<Event, Builder> implements EventOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 5;
        private static final Event DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<Event> PARSER = null;
        public static final int PREVIOUS_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 3;
        public static final int TRIGGER_PARAMS_FIELD_NUMBER = 1;
        private int count_;
        private long previousTimestampMillis_;
        private long timestampMillis_;
        private Internal.ProtobufList<TriggerParam> triggerParams_ = emptyProtobufList();
        private String name_ = "";

        private Event() {
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public List<TriggerParam> getTriggerParamsList() {
            return this.triggerParams_;
        }

        public List<? extends TriggerParamOrBuilder> getTriggerParamsOrBuilderList() {
            return this.triggerParams_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public int getTriggerParamsCount() {
            return this.triggerParams_.size();
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public TriggerParam getTriggerParams(int i) {
            return this.triggerParams_.get(i);
        }

        public TriggerParamOrBuilder getTriggerParamsOrBuilder(int i) {
            return this.triggerParams_.get(i);
        }

        private void ensureTriggerParamsIsMutable() {
            Internal.ProtobufList<TriggerParam> protobufList = this.triggerParams_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.triggerParams_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTriggerParams(int i, TriggerParam triggerParam) {
            triggerParam.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.set(i, triggerParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggerParams(TriggerParam triggerParam) {
            triggerParam.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(triggerParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addTriggerParams(int i, TriggerParam triggerParam) {
            triggerParam.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(i, triggerParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllTriggerParams(Iterable<? extends TriggerParam> iterable) {
            ensureTriggerParamsIsMutable();
            AbstractMessageLite.addAll(iterable, this.triggerParams_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTriggerParams() {
            this.triggerParams_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeTriggerParams(int i) {
            ensureTriggerParamsIsMutable();
            this.triggerParams_.remove(i);
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public long getTimestampMillis() {
            return this.timestampMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestampMillis(long j) {
            this.timestampMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestampMillis() {
            this.timestampMillis_ = 0L;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public long getPreviousTimestampMillis() {
            return this.previousTimestampMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPreviousTimestampMillis(long j) {
            this.previousTimestampMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPreviousTimestampMillis() {
            this.previousTimestampMillis_ = 0L;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCount(int i) {
            this.count_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCount() {
            this.count_ = 0;
        }

        public static Event parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Event parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Event parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Event parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Event parseFrom(InputStream inputStream) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Event) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Event parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Event) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Event event) {
            return DEFAULT_INSTANCE.createBuilder(event);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Event, Builder> implements EventOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Event.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public List<TriggerParam> getTriggerParamsList() {
                return Collections.unmodifiableList(((Event) this.instance).getTriggerParamsList());
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public int getTriggerParamsCount() {
                return ((Event) this.instance).getTriggerParamsCount();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public TriggerParam getTriggerParams(int i) {
                return ((Event) this.instance).getTriggerParams(i);
            }

            public Builder setTriggerParams(int i, TriggerParam triggerParam) {
                copyOnWrite();
                ((Event) this.instance).setTriggerParams(i, triggerParam);
                return this;
            }

            public Builder setTriggerParams(int i, TriggerParam.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).setTriggerParams(i, builder.build());
                return this;
            }

            public Builder addTriggerParams(TriggerParam triggerParam) {
                copyOnWrite();
                ((Event) this.instance).addTriggerParams(triggerParam);
                return this;
            }

            public Builder addTriggerParams(int i, TriggerParam triggerParam) {
                copyOnWrite();
                ((Event) this.instance).addTriggerParams(i, triggerParam);
                return this;
            }

            public Builder addTriggerParams(TriggerParam.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).addTriggerParams(builder.build());
                return this;
            }

            public Builder addTriggerParams(int i, TriggerParam.Builder builder) {
                copyOnWrite();
                ((Event) this.instance).addTriggerParams(i, builder.build());
                return this;
            }

            public Builder addAllTriggerParams(Iterable<? extends TriggerParam> iterable) {
                copyOnWrite();
                ((Event) this.instance).addAllTriggerParams(iterable);
                return this;
            }

            public Builder clearTriggerParams() {
                copyOnWrite();
                ((Event) this.instance).clearTriggerParams();
                return this;
            }

            public Builder removeTriggerParams(int i) {
                copyOnWrite();
                ((Event) this.instance).removeTriggerParams(i);
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public String getName() {
                return ((Event) this.instance).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public ByteString getNameBytes() {
                return ((Event) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((Event) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((Event) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((Event) this.instance).setNameBytes(byteString);
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public long getTimestampMillis() {
                return ((Event) this.instance).getTimestampMillis();
            }

            public Builder setTimestampMillis(long j) {
                copyOnWrite();
                ((Event) this.instance).setTimestampMillis(j);
                return this;
            }

            public Builder clearTimestampMillis() {
                copyOnWrite();
                ((Event) this.instance).clearTimestampMillis();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public long getPreviousTimestampMillis() {
                return ((Event) this.instance).getPreviousTimestampMillis();
            }

            public Builder setPreviousTimestampMillis(long j) {
                copyOnWrite();
                ((Event) this.instance).setPreviousTimestampMillis(j);
                return this;
            }

            public Builder clearPreviousTimestampMillis() {
                copyOnWrite();
                ((Event) this.instance).clearPreviousTimestampMillis();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder
            public int getCount() {
                return ((Event) this.instance).getCount();
            }

            public Builder setCount(int i) {
                copyOnWrite();
                ((Event) this.instance).setCount(i);
                return this;
            }

            public Builder clearCount() {
                copyOnWrite();
                ((Event) this.instance).clearCount();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Event();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002Ȉ\u0003\u0002\u0004\u0002\u0005\u0004", new Object[]{"triggerParams_", TriggerParam.class, "name_", "timestampMillis_", "previousTimestampMillis_", "count_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Event> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Event.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Event event = new Event();
            DEFAULT_INSTANCE = event;
            GeneratedMessageLite.registerDefaultInstance(Event.class, event);
        }

        public static Event getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Event> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class TriggerParam extends GeneratedMessageLite<TriggerParam, Builder> implements TriggerParamOrBuilder {
        private static final TriggerParam DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 5;
        public static final int FLOAT_VALUE_FIELD_NUMBER = 4;
        public static final int INT_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<TriggerParam> PARSER = null;
        public static final int STRING_VALUE_FIELD_NUMBER = 2;
        private double doubleValue_;
        private float floatValue_;
        private long intValue_;
        private String name_ = "";
        private String stringValue_ = "";

        private TriggerParam() {
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public String getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public ByteString getStringValueBytes() {
            return ByteString.copyFromUtf8(this.stringValue_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String str) {
            str.getClass();
            this.stringValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStringValue() {
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValueBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.stringValue_ = byteString.toStringUtf8();
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public long getIntValue() {
            return this.intValue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(long j) {
            this.intValue_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIntValue() {
            this.intValue_ = 0L;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public float getFloatValue() {
            return this.floatValue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(float f) {
            this.floatValue_ = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFloatValue() {
            this.floatValue_ = 0.0f;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
        public double getDoubleValue() {
            return this.doubleValue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDoubleValue(double d) {
            this.doubleValue_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDoubleValue() {
            this.doubleValue_ = 0.0d;
        }

        public static TriggerParam parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static TriggerParam parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TriggerParam parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TriggerParam parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(InputStream inputStream) throws IOException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggerParam parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggerParam parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TriggerParam) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriggerParam parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TriggerParam) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriggerParam parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TriggerParam parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TriggerParam) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TriggerParam triggerParam) {
            return DEFAULT_INSTANCE.createBuilder(triggerParam);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TriggerParam, Builder> implements TriggerParamOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(TriggerParam.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public String getName() {
                return ((TriggerParam) this.instance).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public ByteString getNameBytes() {
                return ((TriggerParam) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((TriggerParam) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((TriggerParam) this.instance).setNameBytes(byteString);
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public String getStringValue() {
                return ((TriggerParam) this.instance).getStringValue();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public ByteString getStringValueBytes() {
                return ((TriggerParam) this.instance).getStringValueBytes();
            }

            public Builder setStringValue(String str) {
                copyOnWrite();
                ((TriggerParam) this.instance).setStringValue(str);
                return this;
            }

            public Builder clearStringValue() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearStringValue();
                return this;
            }

            public Builder setStringValueBytes(ByteString byteString) {
                copyOnWrite();
                ((TriggerParam) this.instance).setStringValueBytes(byteString);
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public long getIntValue() {
                return ((TriggerParam) this.instance).getIntValue();
            }

            public Builder setIntValue(long j) {
                copyOnWrite();
                ((TriggerParam) this.instance).setIntValue(j);
                return this;
            }

            public Builder clearIntValue() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearIntValue();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public float getFloatValue() {
                return ((TriggerParam) this.instance).getFloatValue();
            }

            public Builder setFloatValue(float f) {
                copyOnWrite();
                ((TriggerParam) this.instance).setFloatValue(f);
                return this;
            }

            public Builder clearFloatValue() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearFloatValue();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder
            public double getDoubleValue() {
                return ((TriggerParam) this.instance).getDoubleValue();
            }

            public Builder setDoubleValue(double d) {
                copyOnWrite();
                ((TriggerParam) this.instance).setDoubleValue(d);
                return this;
            }

            public Builder clearDoubleValue() {
                copyOnWrite();
                ((TriggerParam) this.instance).clearDoubleValue();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new TriggerParam();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0001\u0005\u0000", new Object[]{"name_", "stringValue_", "intValue_", "floatValue_", "doubleValue_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TriggerParam> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (TriggerParam.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            TriggerParam triggerParam = new TriggerParam();
            DEFAULT_INSTANCE = triggerParam;
            GeneratedMessageLite.registerDefaultInstance(TriggerParam.class, triggerParam);
        }

        public static TriggerParam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TriggerParam> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Priority extends GeneratedMessageLite<Priority, Builder> implements PriorityOrBuilder {
        private static final Priority DEFAULT_INSTANCE;
        private static volatile Parser<Priority> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 1;
        private int value_;

        private Priority() {
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.PriorityOrBuilder
        public int getValue() {
            return this.value_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(int i) {
            this.value_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = 0;
        }

        public static Priority parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Priority parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Priority parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Priority parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Priority parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Priority parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Priority parseFrom(InputStream inputStream) throws IOException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Priority parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Priority parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Priority) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Priority parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Priority) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Priority parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Priority parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Priority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Priority priority) {
            return DEFAULT_INSTANCE.createBuilder(priority);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Priority, Builder> implements PriorityOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Priority.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.PriorityOrBuilder
            public int getValue() {
                return ((Priority) this.instance).getValue();
            }

            public Builder setValue(int i) {
                copyOnWrite();
                ((Priority) this.instance).setValue(i);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((Priority) this.instance).clearValue();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new Priority();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Priority> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Priority.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Priority priority = new Priority();
            DEFAULT_INSTANCE = priority;
            GeneratedMessageLite.registerDefaultInstance(Priority.class, priority);
        }

        public static Priority getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Priority> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ScionConversionEvent extends GeneratedMessageLite<ScionConversionEvent, Builder> implements ScionConversionEventOrBuilder {
        private static final ScionConversionEvent DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<ScionConversionEvent> PARSER;
        private String name_ = "";

        private ScionConversionEvent() {
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        public static ScionConversionEvent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ScionConversionEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ScionConversionEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ScionConversionEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(InputStream inputStream) throws IOException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScionConversionEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScionConversionEvent parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ScionConversionEvent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScionConversionEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScionConversionEvent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScionConversionEvent parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ScionConversionEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScionConversionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ScionConversionEvent scionConversionEvent) {
            return DEFAULT_INSTANCE.createBuilder(scionConversionEvent);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ScionConversionEvent, Builder> implements ScionConversionEventOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ScionConversionEvent.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
            public String getName() {
                return ((ScionConversionEvent) this.instance).getName();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder
            public ByteString getNameBytes() {
                return ((ScionConversionEvent) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((ScionConversionEvent) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((ScionConversionEvent) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((ScionConversionEvent) this.instance).setNameBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new ScionConversionEvent();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"name_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ScionConversionEvent> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ScionConversionEvent.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ScionConversionEvent scionConversionEvent = new ScionConversionEvent();
            DEFAULT_INSTANCE = scionConversionEvent;
            GeneratedMessageLite.registerDefaultInstance(ScionConversionEvent.class, scionConversionEvent);
        }

        public static ScionConversionEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ScionConversionEvent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ExperimentVariant extends GeneratedMessageLite<ExperimentVariant, Builder> implements ExperimentVariantOrBuilder {
        public static final int CONTENT_FIELD_NUMBER = 2;
        private static final ExperimentVariant DEFAULT_INSTANCE;
        public static final int INDEX_FIELD_NUMBER = 1;
        private static volatile Parser<ExperimentVariant> PARSER;
        private int bitField0_;
        private MessagesProto.Content content_;
        private int index_;

        private ExperimentVariant() {
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public int getIndex() {
            return this.index_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIndex(int i) {
            this.index_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndex() {
            this.index_ = 0;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public boolean hasContent() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
        public MessagesProto.Content getContent() {
            MessagesProto.Content content = this.content_;
            return content == null ? MessagesProto.Content.getDefaultInstance() : content;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(MessagesProto.Content content) {
            content.getClass();
            this.content_ = content;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeContent(MessagesProto.Content content) {
            content.getClass();
            MessagesProto.Content content2 = this.content_;
            if (content2 != null && content2 != MessagesProto.Content.getDefaultInstance()) {
                this.content_ = MessagesProto.Content.newBuilder(this.content_).mergeFrom(content).buildPartial();
            } else {
                this.content_ = content;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.content_ = null;
            this.bitField0_ &= -2;
        }

        public static ExperimentVariant parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ExperimentVariant parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExperimentVariant parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExperimentVariant parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(InputStream inputStream) throws IOException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentVariant parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentVariant parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExperimentVariant) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExperimentVariant parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentVariant) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExperimentVariant parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExperimentVariant parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExperimentVariant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ExperimentVariant experimentVariant) {
            return DEFAULT_INSTANCE.createBuilder(experimentVariant);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ExperimentVariant, Builder> implements ExperimentVariantOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ExperimentVariant.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public int getIndex() {
                return ((ExperimentVariant) this.instance).getIndex();
            }

            public Builder setIndex(int i) {
                copyOnWrite();
                ((ExperimentVariant) this.instance).setIndex(i);
                return this;
            }

            public Builder clearIndex() {
                copyOnWrite();
                ((ExperimentVariant) this.instance).clearIndex();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public boolean hasContent() {
                return ((ExperimentVariant) this.instance).hasContent();
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder
            public MessagesProto.Content getContent() {
                return ((ExperimentVariant) this.instance).getContent();
            }

            public Builder setContent(MessagesProto.Content content) {
                copyOnWrite();
                ((ExperimentVariant) this.instance).setContent(content);
                return this;
            }

            public Builder setContent(MessagesProto.Content.Builder builder) {
                copyOnWrite();
                ((ExperimentVariant) this.instance).setContent(builder.build());
                return this;
            }

            public Builder mergeContent(MessagesProto.Content content) {
                copyOnWrite();
                ((ExperimentVariant) this.instance).mergeContent(content);
                return this;
            }

            public Builder clearContent() {
                copyOnWrite();
                ((ExperimentVariant) this.instance).clearContent();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new ExperimentVariant();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", TableInfo.Index.DEFAULT_PREFIX, "content_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExperimentVariant> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ExperimentVariant.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ExperimentVariant experimentVariant = new ExperimentVariant();
            DEFAULT_INSTANCE = experimentVariant;
            GeneratedMessageLite.registerDefaultInstance(ExperimentVariant.class, experimentVariant);
        }

        public static ExperimentVariant getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExperimentVariant> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DailyAnalyticsSummary extends GeneratedMessageLite<DailyAnalyticsSummary, Builder> implements DailyAnalyticsSummaryOrBuilder {
        public static final int CLICKS_FIELD_NUMBER = 3;
        private static final DailyAnalyticsSummary DEFAULT_INSTANCE;
        public static final int ERRORS_FIELD_NUMBER = 4;
        public static final int IMPRESSIONS_FIELD_NUMBER = 2;
        private static volatile Parser<DailyAnalyticsSummary> PARSER = null;
        public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
        private int clicks_;
        private int errors_;
        private int impressions_;
        private long startOfDayMillis_;

        private DailyAnalyticsSummary() {
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public long getStartOfDayMillis() {
            return this.startOfDayMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartOfDayMillis(long j) {
            this.startOfDayMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartOfDayMillis() {
            this.startOfDayMillis_ = 0L;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getImpressions() {
            return this.impressions_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImpressions(int i) {
            this.impressions_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImpressions() {
            this.impressions_ = 0;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getClicks() {
            return this.clicks_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClicks(int i) {
            this.clicks_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClicks() {
            this.clicks_ = 0;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
        public int getErrors() {
            return this.errors_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrors(int i) {
            this.errors_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrors() {
            this.errors_ = 0;
        }

        public static DailyAnalyticsSummary parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DailyAnalyticsSummary parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DailyAnalyticsSummary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DailyAnalyticsSummary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(InputStream inputStream) throws IOException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyAnalyticsSummary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DailyAnalyticsSummary) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyAnalyticsSummary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DailyAnalyticsSummary) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyAnalyticsSummary parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DailyAnalyticsSummary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DailyAnalyticsSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DailyAnalyticsSummary dailyAnalyticsSummary) {
            return DEFAULT_INSTANCE.createBuilder(dailyAnalyticsSummary);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DailyAnalyticsSummary, Builder> implements DailyAnalyticsSummaryOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DailyAnalyticsSummary.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public long getStartOfDayMillis() {
                return ((DailyAnalyticsSummary) this.instance).getStartOfDayMillis();
            }

            public Builder setStartOfDayMillis(long j) {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).setStartOfDayMillis(j);
                return this;
            }

            public Builder clearStartOfDayMillis() {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).clearStartOfDayMillis();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getImpressions() {
                return ((DailyAnalyticsSummary) this.instance).getImpressions();
            }

            public Builder setImpressions(int i) {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).setImpressions(i);
                return this;
            }

            public Builder clearImpressions() {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).clearImpressions();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getClicks() {
                return ((DailyAnalyticsSummary) this.instance).getClicks();
            }

            public Builder setClicks(int i) {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).setClicks(i);
                return this;
            }

            public Builder clearClicks() {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).clearClicks();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder
            public int getErrors() {
                return ((DailyAnalyticsSummary) this.instance).getErrors();
            }

            public Builder setErrors(int i) {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).setErrors(i);
                return this;
            }

            public Builder clearErrors() {
                copyOnWrite();
                ((DailyAnalyticsSummary) this.instance).clearErrors();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new DailyAnalyticsSummary();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003\u0004\u0004\u0004", new Object[]{"startOfDayMillis_", "impressions_", "clicks_", "errors_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DailyAnalyticsSummary> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DailyAnalyticsSummary.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            DailyAnalyticsSummary dailyAnalyticsSummary = new DailyAnalyticsSummary();
            DEFAULT_INSTANCE = dailyAnalyticsSummary;
            GeneratedMessageLite.registerDefaultInstance(DailyAnalyticsSummary.class, dailyAnalyticsSummary);
        }

        public static DailyAnalyticsSummary getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DailyAnalyticsSummary> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DailyConversionSummary extends GeneratedMessageLite<DailyConversionSummary, Builder> implements DailyConversionSummaryOrBuilder {
        public static final int CONVERSIONS_FIELD_NUMBER = 2;
        private static final DailyConversionSummary DEFAULT_INSTANCE;
        private static volatile Parser<DailyConversionSummary> PARSER = null;
        public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
        private int conversions_;
        private long startOfDayMillis_;

        private DailyConversionSummary() {
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
        public long getStartOfDayMillis() {
            return this.startOfDayMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartOfDayMillis(long j) {
            this.startOfDayMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartOfDayMillis() {
            this.startOfDayMillis_ = 0L;
        }

        @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
        public int getConversions() {
            return this.conversions_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConversions(int i) {
            this.conversions_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConversions() {
            this.conversions_ = 0;
        }

        public static DailyConversionSummary parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DailyConversionSummary parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DailyConversionSummary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DailyConversionSummary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(InputStream inputStream) throws IOException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyConversionSummary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyConversionSummary parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DailyConversionSummary) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DailyConversionSummary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DailyConversionSummary) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DailyConversionSummary parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DailyConversionSummary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DailyConversionSummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DailyConversionSummary dailyConversionSummary) {
            return DEFAULT_INSTANCE.createBuilder(dailyConversionSummary);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DailyConversionSummary, Builder> implements DailyConversionSummaryOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DailyConversionSummary.DEFAULT_INSTANCE);
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
            public long getStartOfDayMillis() {
                return ((DailyConversionSummary) this.instance).getStartOfDayMillis();
            }

            public Builder setStartOfDayMillis(long j) {
                copyOnWrite();
                ((DailyConversionSummary) this.instance).setStartOfDayMillis(j);
                return this;
            }

            public Builder clearStartOfDayMillis() {
                copyOnWrite();
                ((DailyConversionSummary) this.instance).clearStartOfDayMillis();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder
            public int getConversions() {
                return ((DailyConversionSummary) this.instance).getConversions();
            }

            public Builder setConversions(int i) {
                copyOnWrite();
                ((DailyConversionSummary) this.instance).setConversions(i);
                return this;
            }

            public Builder clearConversions() {
                copyOnWrite();
                ((DailyConversionSummary) this.instance).clearConversions();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new DailyConversionSummary();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"startOfDayMillis_", "conversions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DailyConversionSummary> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DailyConversionSummary.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            DailyConversionSummary dailyConversionSummary = new DailyConversionSummary();
            DEFAULT_INSTANCE = dailyConversionSummary;
            GeneratedMessageLite.registerDefaultInstance(DailyConversionSummary.class, dailyConversionSummary);
        }

        public static DailyConversionSummary getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DailyConversionSummary> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
