package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import androidx.camera.core.ImageProxy;
import coil3.util.UtilsKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationOcrApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.ocr.OcrResponseDto;
import com.google.protobuf.DescriptorProtos;
import java.io.ByteArrayOutputStream;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ExtractTextFromImageUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086B¢\u0006\u0002\u0010\u0013J0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/ExtractTextFromImageUseCase;", "", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "conversationOcrApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationOcrApi;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationOcrApi;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "getSessionRepository", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "getConversationOcrApi", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationOcrApi;", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/ExtractedText;", "imageProxy", "Landroidx/camera/core/ImageProxy;", "(Landroidx/camera/core/ImageProxy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "imageProxyToCompressedBytes", "", "targetSize", "", "paddingColor", "(Landroidx/camera/core/ImageProxy;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertByteArrayToImagePart", "Lokhttp3/MultipartBody$Part;", "imageByteArray", "convertStringToRequestBody", "Lokhttp3/RequestBody;", "string", "", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExtractTextFromImageUseCase {
    private static final String TAG = "ExtractTextFromImageUseCase";
    private final AnalyticsManager analyticsManager;
    private final ConversationOcrApi conversationOcrApi;
    private final SessionRepository sessionRepository;
    public static final int $stable = AnalyticsManager.$stable;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExtractTextFromImageUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase", f = "ExtractTextFromImageUseCase.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {38, DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER, 40, 48, 52}, m = "invoke", n = {"imageProxy", "customerId", "imageProxy", "customerId", "deviceId", "imageProxy", "customerId", "deviceId", "gmailId", "imageProxy", "customerId", "deviceId", "gmailId", "token", "customerIdBody", "deviceIdBody", "gmailIdBody", "tokenBody", "inputLangBody", "imageProxy", "customerId", "deviceId", "gmailId", "token", "customerIdBody", "deviceIdBody", "gmailIdBody", "tokenBody", "inputLangBody", "byteImage", "imagePart"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtractTextFromImageUseCase.this.invoke(null, (Continuation) this);
        }
    }

    @Inject
    public ExtractTextFromImageUseCase(SessionRepository sessionRepository, ConversationOcrApi conversationOcrApi, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(conversationOcrApi, "conversationOcrApi");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.sessionRepository = sessionRepository;
        this.conversationOcrApi = conversationOcrApi;
        this.analyticsManager = analyticsManager;
    }

    public final SessionRepository getSessionRepository() {
        return this.sessionRepository;
    }

    public final ConversationOcrApi getConversationOcrApi() {
        return this.conversationOcrApi;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02de A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:102:0x02e3 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:104:0x02e9 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:106:0x02ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x02ee A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:109:0x02f6 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02fb A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0301 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0305 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:116:0x0306 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:118:0x030e A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0313 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0319 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:124:0x031d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:125:0x031e A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0326 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:129:0x032b A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0331 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0335 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:134:0x0336 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:136:0x033e A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0343 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0349 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:142:0x034d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:143:0x034e A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0356 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:147:0x035b A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0361 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0365 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:152:0x0366 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:154:0x036e A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0373 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0136 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0150  */
    /* JADX WARN: Code duplicated, block: B:52:0x0152  */
    /* JADX WARN: Code duplicated, block: B:55:0x015d A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:57:0x016e A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:59:0x017f A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0190 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01a0 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01b6 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:71:0x020f A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:73:0x021f A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:76:0x02a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x02a1 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:79:0x02a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02a6 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:82:0x02ae A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:84:0x02b3 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:86:0x02b9 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:88:0x02bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x02be A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:91:0x02c6 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:93:0x02cb A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:95:0x02d1 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:97:0x02d5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x02d6 A[Catch: Exception -> 0x03a9, TryCatch #0 {Exception -> 0x03a9, blocks: (B:16:0x0067, B:21:0x009b, B:69:0x0209, B:71:0x020f, B:73:0x021f, B:77:0x02a1, B:80:0x02a6, B:82:0x02ae, B:84:0x02b3, B:85:0x02b8, B:86:0x02b9, B:89:0x02be, B:91:0x02c6, B:93:0x02cb, B:94:0x02d0, B:25:0x00bb, B:53:0x0157, B:55:0x015d, B:57:0x016e, B:59:0x017f, B:61:0x0190, B:63:0x01a0, B:65:0x01b6, B:95:0x02d1, B:98:0x02d6, B:100:0x02de, B:102:0x02e3, B:103:0x02e8, B:104:0x02e9, B:107:0x02ee, B:109:0x02f6, B:111:0x02fb, B:112:0x0300, B:113:0x0301, B:116:0x0306, B:118:0x030e, B:120:0x0313, B:121:0x0318, B:122:0x0319, B:125:0x031e, B:127:0x0326, B:129:0x032b, B:130:0x0330, B:131:0x0331, B:134:0x0336, B:136:0x033e, B:138:0x0343, B:139:0x0348, B:140:0x0349, B:143:0x034e, B:145:0x0356, B:147:0x035b, B:148:0x0360, B:29:0x00cf, B:47:0x0130, B:49:0x0136, B:149:0x0361, B:152:0x0366, B:154:0x036e, B:156:0x0373, B:157:0x0378, B:32:0x00db, B:41:0x010a, B:43:0x0110, B:158:0x0379, B:161:0x037e, B:163:0x0386, B:165:0x038b, B:166:0x0390, B:35:0x00e2, B:37:0x00ec, B:167:0x0391, B:170:0x0396, B:172:0x039e, B:174:0x03a3, B:175:0x03a8), top: B:179:0x002b }] */
    public final Object invoke(ImageProxy imageProxy, Continuation<? super ResponseResource<ExtractedText>> continuation) {
        AnonymousClass1 anonymousClass1;
        String str;
        ImageProxy imageProxy2;
        String str2;
        String str3;
        ResponseResource responseResource;
        String str4;
        Object token;
        String str5;
        String str6;
        String str7;
        ResponseResource responseResource2;
        String str8;
        ResponseResource<RequestBody> responseResourceConvertStringToRequestBody;
        RequestBody requestBody;
        ResponseResource<RequestBody> responseResourceConvertStringToRequestBody2;
        RequestBody requestBody2;
        ResponseResource<RequestBody> responseResourceConvertStringToRequestBody3;
        RequestBody requestBody3;
        ResponseResource<RequestBody> responseResourceConvertStringToRequestBody4;
        RequestBody requestBody4;
        ResponseResource<RequestBody> responseResourceConvertStringToRequestBody5;
        RequestBody requestBody5;
        ImageProxy imageProxy3;
        Object objImageProxyToCompressedBytes$default;
        RequestBody requestBody6;
        RequestBody requestBody7;
        RequestBody requestBody8;
        ImageProxy imageProxy4;
        RequestBody requestBody9;
        String str9;
        String str10;
        String str11;
        String str12;
        ResponseResource responseResource3;
        byte[] bArr;
        ResponseResource<MultipartBody.Part> responseResourceConvertByteArrayToImagePart;
        Object objApi$default;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ResponseResource<String> customerId = this.sessionRepository.getCustomerId();
                if (!(customerId instanceof ResponseResource.Success)) {
                    if (customerId instanceof ResponseResource.Error) {
                        return customerId;
                    }
                    if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                String str13 = (String) ((ResponseResource.Success) customerId).getData();
                SessionRepository sessionRepository = this.sessionRepository;
                anonymousClass2.L$0 = imageProxy;
                anonymousClass2.L$1 = str13;
                anonymousClass2.label = 1;
                Object deviceId = sessionRepository.getDeviceId(anonymousClass2);
                if (deviceId != coroutine_suspended) {
                    str = str13;
                    obj = deviceId;
                    imageProxy2 = imageProxy;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                str = (String) anonymousClass2.L$1;
                imageProxy2 = (ImageProxy) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    str2 = (String) anonymousClass2.L$2;
                    str3 = (String) anonymousClass2.L$1;
                    imageProxy2 = (ImageProxy) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    responseResource = (ResponseResource) obj;
                    if (responseResource instanceof ResponseResource.Success) {
                        if (responseResource instanceof ResponseResource.Error) {
                            return responseResource;
                        }
                        if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str4 = (String) ((ResponseResource.Success) responseResource).getData();
                    SessionRepository sessionRepository2 = this.sessionRepository;
                    anonymousClass2.L$0 = imageProxy2;
                    anonymousClass2.L$1 = str3;
                    anonymousClass2.L$2 = str2;
                    anonymousClass2.L$3 = str4;
                    anonymousClass2.label = 3;
                    token = sessionRepository2.getToken(anonymousClass2);
                    if (token == coroutine_suspended) {
                        str5 = str4;
                        str6 = str2;
                        obj = token;
                        str7 = str3;
                        responseResource2 = (ResponseResource) obj;
                        if (!(responseResource2 instanceof ResponseResource.Success)) {
                            if (responseResource2 instanceof ResponseResource.Error) {
                                return responseResource2;
                            }
                            if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str8 = (String) ((ResponseResource.Success) responseResource2).getData();
                        responseResourceConvertStringToRequestBody = convertStringToRequestBody(str7);
                        if (!(responseResourceConvertStringToRequestBody instanceof ResponseResource.Success)) {
                            if (responseResourceConvertStringToRequestBody instanceof ResponseResource.Error) {
                                return responseResourceConvertStringToRequestBody;
                            }
                            if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        requestBody = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody).getData();
                        responseResourceConvertStringToRequestBody2 = convertStringToRequestBody(str6);
                        if (!(responseResourceConvertStringToRequestBody2 instanceof ResponseResource.Success)) {
                            if (responseResourceConvertStringToRequestBody2 instanceof ResponseResource.Error) {
                                return responseResourceConvertStringToRequestBody2;
                            }
                            if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody2, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        requestBody2 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody2).getData();
                        responseResourceConvertStringToRequestBody3 = convertStringToRequestBody(str5);
                        if (!(responseResourceConvertStringToRequestBody3 instanceof ResponseResource.Success)) {
                            if (responseResourceConvertStringToRequestBody3 instanceof ResponseResource.Error) {
                                return responseResourceConvertStringToRequestBody3;
                            }
                            if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody3, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        requestBody3 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody3).getData();
                        responseResourceConvertStringToRequestBody4 = convertStringToRequestBody(str8);
                        if (!(responseResourceConvertStringToRequestBody4 instanceof ResponseResource.Success)) {
                            if (responseResourceConvertStringToRequestBody4 instanceof ResponseResource.Error) {
                                return responseResourceConvertStringToRequestBody4;
                            }
                            if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody4, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        requestBody4 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody4).getData();
                        responseResourceConvertStringToRequestBody5 = convertStringToRequestBody(LanguageEnum.ENGLISH.getLanguageCode());
                        if (!(responseResourceConvertStringToRequestBody5 instanceof ResponseResource.Success)) {
                            if (responseResourceConvertStringToRequestBody5 instanceof ResponseResource.Error) {
                                return responseResourceConvertStringToRequestBody5;
                            }
                            if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody5, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        requestBody5 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody5).getData();
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(imageProxy2);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str6);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str8);
                        anonymousClass2.L$5 = requestBody;
                        anonymousClass2.L$6 = requestBody2;
                        anonymousClass2.L$7 = requestBody3;
                        anonymousClass2.L$8 = requestBody4;
                        anonymousClass2.L$9 = requestBody5;
                        anonymousClass2.label = 4;
                        imageProxy3 = imageProxy2;
                        objImageProxyToCompressedBytes$default = imageProxyToCompressedBytes$default(this, imageProxy3, 0, 0, anonymousClass2, 6, null);
                        if (objImageProxyToCompressedBytes$default != coroutine_suspended) {
                            requestBody6 = requestBody3;
                            requestBody7 = requestBody5;
                            requestBody8 = requestBody4;
                            imageProxy4 = imageProxy3;
                            obj = objImageProxyToCompressedBytes$default;
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 3) {
                    String str14 = (String) anonymousClass2.L$3;
                    String str15 = (String) anonymousClass2.L$2;
                    str3 = (String) anonymousClass2.L$1;
                    imageProxy2 = (ImageProxy) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    str5 = str14;
                    str6 = str15;
                    str7 = str3;
                    responseResource2 = (ResponseResource) obj;
                    if (!(responseResource2 instanceof ResponseResource.Success)) {
                        if (responseResource2 instanceof ResponseResource.Error) {
                            return responseResource2;
                        }
                        if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str8 = (String) ((ResponseResource.Success) responseResource2).getData();
                    responseResourceConvertStringToRequestBody = convertStringToRequestBody(str7);
                    if (!(responseResourceConvertStringToRequestBody instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody).getData();
                    responseResourceConvertStringToRequestBody2 = convertStringToRequestBody(str6);
                    if (!(responseResourceConvertStringToRequestBody2 instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody2 instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody2;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody2, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody2 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody2).getData();
                    responseResourceConvertStringToRequestBody3 = convertStringToRequestBody(str5);
                    if (!(responseResourceConvertStringToRequestBody3 instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody3 instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody3;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody3, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody3 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody3).getData();
                    responseResourceConvertStringToRequestBody4 = convertStringToRequestBody(str8);
                    if (!(responseResourceConvertStringToRequestBody4 instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody4 instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody4;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody4, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody4 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody4).getData();
                    responseResourceConvertStringToRequestBody5 = convertStringToRequestBody(LanguageEnum.ENGLISH.getLanguageCode());
                    if (!(responseResourceConvertStringToRequestBody5 instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody5 instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody5;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody5, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody5 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody5).getData();
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(imageProxy2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str6);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str8);
                    anonymousClass2.L$5 = requestBody;
                    anonymousClass2.L$6 = requestBody2;
                    anonymousClass2.L$7 = requestBody3;
                    anonymousClass2.L$8 = requestBody4;
                    anonymousClass2.L$9 = requestBody5;
                    anonymousClass2.label = 4;
                    imageProxy3 = imageProxy2;
                    objImageProxyToCompressedBytes$default = imageProxyToCompressedBytes$default(this, imageProxy3, 0, 0, anonymousClass2, 6, null);
                    if (objImageProxyToCompressedBytes$default != coroutine_suspended) {
                        requestBody6 = requestBody3;
                        requestBody7 = requestBody5;
                        requestBody8 = requestBody4;
                        imageProxy4 = imageProxy3;
                        obj = objImageProxyToCompressedBytes$default;
                    }
                    return coroutine_suspended;
                }
                if (i != 4) {
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                RequestBody requestBody10 = (RequestBody) anonymousClass2.L$9;
                RequestBody requestBody11 = (RequestBody) anonymousClass2.L$8;
                requestBody6 = (RequestBody) anonymousClass2.L$7;
                RequestBody requestBody12 = (RequestBody) anonymousClass2.L$6;
                RequestBody requestBody13 = (RequestBody) anonymousClass2.L$5;
                str8 = (String) anonymousClass2.L$4;
                str5 = (String) anonymousClass2.L$3;
                str6 = (String) anonymousClass2.L$2;
                str7 = (String) anonymousClass2.L$1;
                ImageProxy imageProxy5 = (ImageProxy) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                requestBody2 = requestBody12;
                requestBody8 = requestBody11;
                imageProxy4 = imageProxy5;
                requestBody = requestBody13;
                requestBody7 = requestBody10;
            }
            requestBody9 = requestBody2;
            str9 = str7;
            str10 = str6;
            str11 = str5;
            str12 = str8;
            responseResource3 = (ResponseResource) obj;
            if (responseResource3 instanceof ResponseResource.Success) {
                if (responseResource3 instanceof ResponseResource.Error) {
                    return responseResource3;
                }
                if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                    return ResponseResource.Loading.INSTANCE;
                }
                throw new NoWhenBranchMatchedException();
            }
            bArr = (byte[]) ((ResponseResource.Success) responseResource3).getData();
            responseResourceConvertByteArrayToImagePart = convertByteArrayToImagePart(bArr);
            if (responseResourceConvertByteArrayToImagePart instanceof ResponseResource.Success) {
                if (responseResourceConvertByteArrayToImagePart instanceof ResponseResource.Error) {
                    return responseResourceConvertByteArrayToImagePart;
                }
                if (Intrinsics.areEqual(responseResourceConvertByteArrayToImagePart, ResponseResource.Loading.INSTANCE)) {
                    return ResponseResource.Loading.INSTANCE;
                }
                throw new NoWhenBranchMatchedException();
            }
            MultipartBody.Part part = (MultipartBody.Part) ((ResponseResource.Success) responseResourceConvertByteArrayToImagePart).getData();
            SafeCall safeCall = SafeCall.INSTANCE;
            RequestBody requestBody14 = requestBody;
            RequestBody requestBody15 = requestBody6;
            C02372 c02372 = new C02372(part, requestBody9, requestBody15, requestBody14, requestBody8, requestBody7, null);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(imageProxy4);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str9);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str10);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str11);
            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str12);
            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(requestBody14);
            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(requestBody9);
            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(requestBody15);
            anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(requestBody8);
            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(requestBody7);
            anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(bArr);
            anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(part);
            anonymousClass2.label = 5;
            objApi$default = SafeCall.api$default(safeCall, TAG, null, c02372, anonymousClass3, anonymousClass2, 2, null);
            if (objApi$default != coroutine_suspended) {
                return coroutine_suspended;
            }
            return objApi$default;
            ResponseResource responseResource4 = (ResponseResource) obj;
            if (!(responseResource4 instanceof ResponseResource.Success)) {
                if (responseResource4 instanceof ResponseResource.Error) {
                    return responseResource4;
                }
                if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                    return ResponseResource.Loading.INSTANCE;
                }
                throw new NoWhenBranchMatchedException();
            }
            String str16 = (String) ((ResponseResource.Success) responseResource4).getData();
            SessionRepository sessionRepository3 = this.sessionRepository;
            anonymousClass2.L$0 = imageProxy2;
            anonymousClass2.L$1 = str;
            anonymousClass2.L$2 = str16;
            anonymousClass2.label = 2;
            Object gmailId = sessionRepository3.getGmailId(anonymousClass2);
            if (gmailId != coroutine_suspended) {
                String str17 = str;
                str2 = str16;
                obj = gmailId;
                str3 = str17;
                responseResource = (ResponseResource) obj;
                if (responseResource instanceof ResponseResource.Success) {
                    if (responseResource instanceof ResponseResource.Error) {
                        return responseResource;
                    }
                    if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str4 = (String) ((ResponseResource.Success) responseResource).getData();
                SessionRepository sessionRepository4 = this.sessionRepository;
                anonymousClass2.L$0 = imageProxy2;
                anonymousClass2.L$1 = str3;
                anonymousClass2.L$2 = str2;
                anonymousClass2.L$3 = str4;
                anonymousClass2.label = 3;
                token = sessionRepository4.getToken(anonymousClass2);
                if (token == coroutine_suspended) {
                    str5 = str4;
                    str6 = str2;
                    obj = token;
                    str7 = str3;
                    responseResource2 = (ResponseResource) obj;
                    if (!(responseResource2 instanceof ResponseResource.Success)) {
                        if (responseResource2 instanceof ResponseResource.Error) {
                            return responseResource2;
                        }
                        if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str8 = (String) ((ResponseResource.Success) responseResource2).getData();
                    responseResourceConvertStringToRequestBody = convertStringToRequestBody(str7);
                    if (!(responseResourceConvertStringToRequestBody instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody).getData();
                    responseResourceConvertStringToRequestBody2 = convertStringToRequestBody(str6);
                    if (!(responseResourceConvertStringToRequestBody2 instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody2 instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody2;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody2, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody2 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody2).getData();
                    responseResourceConvertStringToRequestBody3 = convertStringToRequestBody(str5);
                    if (!(responseResourceConvertStringToRequestBody3 instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody3 instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody3;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody3, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody3 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody3).getData();
                    responseResourceConvertStringToRequestBody4 = convertStringToRequestBody(str8);
                    if (!(responseResourceConvertStringToRequestBody4 instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody4 instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody4;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody4, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody4 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody4).getData();
                    responseResourceConvertStringToRequestBody5 = convertStringToRequestBody(LanguageEnum.ENGLISH.getLanguageCode());
                    if (!(responseResourceConvertStringToRequestBody5 instanceof ResponseResource.Success)) {
                        if (responseResourceConvertStringToRequestBody5 instanceof ResponseResource.Error) {
                            return responseResourceConvertStringToRequestBody5;
                        }
                        if (Intrinsics.areEqual(responseResourceConvertStringToRequestBody5, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    requestBody5 = (RequestBody) ((ResponseResource.Success) responseResourceConvertStringToRequestBody5).getData();
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(imageProxy2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str6);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str8);
                    anonymousClass2.L$5 = requestBody;
                    anonymousClass2.L$6 = requestBody2;
                    anonymousClass2.L$7 = requestBody3;
                    anonymousClass2.L$8 = requestBody4;
                    anonymousClass2.L$9 = requestBody5;
                    anonymousClass2.label = 4;
                    imageProxy3 = imageProxy2;
                    objImageProxyToCompressedBytes$default = imageProxyToCompressedBytes$default(this, imageProxy3, 0, 0, anonymousClass2, 6, null);
                    if (objImageProxyToCompressedBytes$default != coroutine_suspended) {
                        requestBody6 = requestBody3;
                        requestBody7 = requestBody5;
                        requestBody8 = requestBody4;
                        imageProxy4 = imageProxy3;
                        obj = objImageProxyToCompressedBytes$default;
                        requestBody9 = requestBody2;
                        str9 = str7;
                        str10 = str6;
                        str11 = str5;
                        str12 = str8;
                        responseResource3 = (ResponseResource) obj;
                        if (responseResource3 instanceof ResponseResource.Success) {
                            if (responseResource3 instanceof ResponseResource.Error) {
                                return responseResource3;
                            }
                            if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        bArr = (byte[]) ((ResponseResource.Success) responseResource3).getData();
                        responseResourceConvertByteArrayToImagePart = convertByteArrayToImagePart(bArr);
                        if (responseResourceConvertByteArrayToImagePart instanceof ResponseResource.Success) {
                            if (responseResourceConvertByteArrayToImagePart instanceof ResponseResource.Error) {
                                return responseResourceConvertByteArrayToImagePart;
                            }
                            if (Intrinsics.areEqual(responseResourceConvertByteArrayToImagePart, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        MultipartBody.Part part2 = (MultipartBody.Part) ((ResponseResource.Success) responseResourceConvertByteArrayToImagePart).getData();
                        SafeCall safeCall2 = SafeCall.INSTANCE;
                        RequestBody requestBody16 = requestBody;
                        RequestBody requestBody17 = requestBody6;
                        C02372 c02373 = new C02372(part2, requestBody9, requestBody17, requestBody16, requestBody8, requestBody7, null);
                        AnonymousClass3 anonymousClass4 = new AnonymousClass3(null);
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(imageProxy4);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str9);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str10);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str11);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str12);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(requestBody16);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(requestBody17);
                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(requestBody7);
                        anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(bArr);
                        anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(part2);
                        anonymousClass2.label = 5;
                        objApi$default = SafeCall.api$default(safeCall2, TAG, null, c02373, anonymousClass4, anonymousClass2, 2, null);
                        if (objApi$default != coroutine_suspended) {
                            return objApi$default;
                        }
                    }
                }
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e(TAG, "Error while extracting text from image", e);
            return new ResponseResource.Error(AppError.UnknownError.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase$invoke$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExtractTextFromImageUseCase.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/ocr/OcrResponseDto;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase$invoke$2", f = "ExtractTextFromImageUseCase.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    static final class C02372 extends SuspendLambda implements Function1<Continuation<? super OcrResponseDto>, Object> {
        final /* synthetic */ RequestBody $customerIdBody;
        final /* synthetic */ RequestBody $deviceIdBody;
        final /* synthetic */ RequestBody $gmailIdBody;
        final /* synthetic */ MultipartBody.Part $imagePart;
        final /* synthetic */ RequestBody $inputLangBody;
        final /* synthetic */ RequestBody $tokenBody;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02372(MultipartBody.Part part, RequestBody requestBody, RequestBody requestBody2, RequestBody requestBody3, RequestBody requestBody4, RequestBody requestBody5, Continuation<? super C02372> continuation) {
            super(1, continuation);
            this.$imagePart = part;
            this.$deviceIdBody = requestBody;
            this.$gmailIdBody = requestBody2;
            this.$customerIdBody = requestBody3;
            this.$tokenBody = requestBody4;
            this.$inputLangBody = requestBody5;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ExtractTextFromImageUseCase.this.new C02372(this.$imagePart, this.$deviceIdBody, this.$gmailIdBody, this.$customerIdBody, this.$tokenBody, this.$inputLangBody, continuation);
        }

        public final Object invoke(Continuation<? super OcrResponseDto> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objPerformOcr = ExtractTextFromImageUseCase.this.getConversationOcrApi().performOcr(this.$imagePart, this.$deviceIdBody, this.$gmailIdBody, this.$customerIdBody, this.$tokenBody, this.$inputLangBody, (Continuation) this);
            return objPerformOcr == coroutine_suspended ? coroutine_suspended : objPerformOcr;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: ExtractTextFromImageUseCase.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/ExtractedText;", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/ocr/OcrResponseDto;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase$invoke$3", f = "ExtractTextFromImageUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<OcrResponseDto, Continuation<? super ExtractedText>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(OcrResponseDto ocrResponseDto, Continuation<? super ExtractedText> continuation) {
            return create(ocrResponseDto, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            OcrResponseDto ocrResponseDto = (OcrResponseDto) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (ocrResponseDto.getData() == null) {
                throw new IllegalStateException("Extracted data is null");
            }
            if (ocrResponseDto.getData().getExtractedText() == null) {
                throw new IllegalStateException("Extracted data is null");
            }
            return new ExtractedText(ocrResponseDto.getData().getExtractedText(), LanguageEnum.ENGLISH);
        }
    }

    static /* synthetic */ Object imageProxyToCompressedBytes$default(ExtractTextFromImageUseCase extractTextFromImageUseCase, ImageProxy imageProxy, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 600;
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        return extractTextFromImageUseCase.imageProxyToCompressedBytes(imageProxy, i, i2, continuation);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase$imageProxyToCompressedBytes$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExtractTextFromImageUseCase.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource$Success;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase$imageProxyToCompressedBytes$2", f = "ExtractTextFromImageUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResponseResource.Success<? extends byte[]>>, Object> {
        final /* synthetic */ ImageProxy $imageProxy;
        final /* synthetic */ int $paddingColor;
        final /* synthetic */ int $targetSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ImageProxy imageProxy, int i, int i2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$imageProxy = imageProxy;
            this.$targetSize = i;
            this.$paddingColor = i2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$imageProxy, this.$targetSize, this.$paddingColor, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResponseResource.Success<byte[]>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Bitmap bitmapCreateScaledBitmap;
            byte[] byteArray;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Bitmap bitmap = this.$imageProxy.toBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "toBitmap(...)");
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == height) {
                int i = this.$targetSize;
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i, true);
            } else {
                int iMax = Math.max(width, height);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawColor(this.$paddingColor);
                canvas.drawBitmap(bitmap, (iMax - width) / 2, (iMax - height) / 2, (Paint) null);
                int i2 = this.$targetSize;
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, i2, i2, true);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 80;
            do {
                byteArrayOutputStream.reset();
                bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                i3 -= 5;
                if (byteArray.length <= 102400) {
                    break;
                }
            } while (i3 > 10);
            return new ResponseResource.Success(byteArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object imageProxyToCompressedBytes(ImageProxy imageProxy, int i, int i2, Continuation<? super ResponseResource<byte[]>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(imageProxy, i, i2, null), continuation);
    }

    private final ResponseResource<MultipartBody.Part> convertByteArrayToImagePart(byte[] imageByteArray) {
        return new ResponseResource.Success(MultipartBody.Part.Companion.createFormData("image", "ocr_image.jpg", RequestBody.Companion.create$default(RequestBody.Companion, imageByteArray, MediaType.Companion.get(UtilsKt.MIME_TYPE_JPEG), 0, 0, 6, (Object) null)));
    }

    private final ResponseResource<RequestBody> convertStringToRequestBody(String string) {
        return new ResponseResource.Success(RequestBody.Companion.create(string, MediaType.Companion.get("text/plain")));
    }
}
