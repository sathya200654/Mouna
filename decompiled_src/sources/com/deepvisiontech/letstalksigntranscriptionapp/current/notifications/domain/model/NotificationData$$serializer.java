package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class NotificationData$$serializer implements GeneratedSerializer<NotificationData> {
    public static final int $stable;
    public static final NotificationData$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private NotificationData$$serializer() {
    }

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NotificationData$$serializer notificationData$$serializer = new NotificationData$$serializer();
        INSTANCE = notificationData$$serializer;
        $stable = 8;
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData", notificationData$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("pageId", false);
        pluginGeneratedSerialDescriptor.addElement("pageType", false);
        pluginGeneratedSerialDescriptor.addElement("pageTitle", false);
        pluginGeneratedSerialDescriptor.addElement("pageBody", false);
        pluginGeneratedSerialDescriptor.addElement("optionsList", true);
        pluginGeneratedSerialDescriptor.addElement("image", true);
        pluginGeneratedSerialDescriptor.addElement("video", true);
        pluginGeneratedSerialDescriptor.addElement("primaryAction", true);
        pluginGeneratedSerialDescriptor.addElement("secondaryAction", true);
        pluginGeneratedSerialDescriptor.addElement("isResponded", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr = NotificationData.$childSerializers;
        return new KSerializer[]{LongSerializer.INSTANCE, lazyArr[1].getValue(), StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[4].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[8].getValue()), BooleanSerializer.INSTANCE};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlinx.serialization.UnknownFieldException */
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public final NotificationData m1729deserialize(Decoder decoder) throws UnknownFieldException {
        boolean zDecodeBooleanElement;
        NotificationResponseType notificationResponseType;
        NotificationPageType notificationPageType;
        long j;
        String str;
        String str2;
        String str3;
        int i;
        List list;
        String str4;
        NotificationResponseType notificationResponseType2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = NotificationData.$childSerializers;
        int i2 = 9;
        int i3 = 6;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
            NotificationPageType notificationPageType2 = (NotificationPageType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            NotificationResponseType notificationResponseType3 = (NotificationResponseType) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), (Object) null);
            notificationResponseType = (NotificationResponseType) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), (Object) null);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 9);
            str4 = strDecodeStringElement2;
            str2 = strDecodeStringElement;
            notificationResponseType2 = notificationResponseType3;
            i = 1023;
            list = list2;
            j = jDecodeLongElement;
            notificationPageType = notificationPageType2;
            str3 = str6;
            str = str5;
        } else {
            int i4 = 4;
            boolean z = true;
            boolean zDecodeBooleanElement2 = false;
            NotificationResponseType notificationResponseType4 = null;
            String str7 = null;
            NotificationResponseType notificationResponseType5 = null;
            String str8 = null;
            String strDecodeStringElement3 = null;
            long jDecodeLongElement2 = 0;
            int i5 = 0;
            List list3 = null;
            NotificationPageType notificationPageType3 = null;
            String strDecodeStringElement4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                        i4 = 4;
                        break;
                    case 0:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                        i5 |= 1;
                        i2 = 9;
                        i3 = 6;
                        i4 = 4;
                        break;
                    case 1:
                        notificationPageType3 = (NotificationPageType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), notificationPageType3);
                        i5 |= 2;
                        i2 = 9;
                        i3 = 6;
                        i4 = 4;
                        break;
                    case 2:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i5 |= 4;
                        i2 = 9;
                        i4 = 4;
                        break;
                    case 3:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i5 |= 8;
                        i2 = 9;
                        break;
                    case 4:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), list3);
                        i5 |= 16;
                        i2 = 9;
                        break;
                    case 5:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str8);
                        i5 |= 32;
                        i2 = 9;
                        break;
                    case 6:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str7);
                        i5 |= 64;
                        break;
                    case 7:
                        notificationResponseType4 = (NotificationResponseType) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), notificationResponseType4);
                        i5 |= 128;
                        break;
                    case 8:
                        notificationResponseType5 = (NotificationResponseType) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), notificationResponseType5);
                        i5 |= 256;
                        break;
                    case 9:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i5 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            zDecodeBooleanElement = zDecodeBooleanElement2;
            notificationResponseType = notificationResponseType5;
            notificationPageType = notificationPageType3;
            j = jDecodeLongElement2;
            str = str8;
            str2 = strDecodeStringElement4;
            str3 = str7;
            i = i5;
            list = list3;
            str4 = strDecodeStringElement3;
            notificationResponseType2 = notificationResponseType4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NotificationData(i, j, notificationPageType, str2, str4, list, str, str3, notificationResponseType2, notificationResponseType, zDecodeBooleanElement, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, NotificationData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        NotificationData.write$Self$app_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
