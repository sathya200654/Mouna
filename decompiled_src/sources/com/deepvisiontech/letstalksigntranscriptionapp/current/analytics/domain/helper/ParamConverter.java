package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.helper;

import com.google.firebase.messaging.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: ParamConverter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0086\b¢\u0006\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/helper/ParamConverter;", "", "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "toMap", "", "", "T", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "(Ljava/lang/Object;)Ljava/util/Map;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ParamConverter {
    public static final ParamConverter INSTANCE = new ParamConverter();
    private static final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.helper.ParamConverter$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            return ParamConverter.json$lambda$0((JsonBuilder) obj);
        }
    }, 1, (Object) null);
    public static final int $stable = 8;

    private ParamConverter() {
    }

    public final Json getJson() {
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setEncodeDefaults(true);
        jsonBuilder.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    public final /* synthetic */ <T> Map<String, String> toMap(T data) {
        Json json2 = getJson();
        SerializersModule serializersModule = json2.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        JsonElement jsonElementEncodeToJsonElement = json2.encodeToJsonElement(SerializersKt.serializer(serializersModule, (KType) null), data);
        JsonObject jsonObject = jsonElementEncodeToJsonElement instanceof JsonObject ? (JsonObject) jsonElementEncodeToJsonElement : null;
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
