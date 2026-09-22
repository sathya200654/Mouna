package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.usecase;

import android.content.Context;
import android.net.Uri;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository.VideoUploadRepository;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoUploadUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086B¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/usecase/UploadVideoUseCase;", "", "videoUploadRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/repository/VideoUploadRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/repository/VideoUploadRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "context", "Landroid/content/Context;", "videoUri", "Landroid/net/Uri;", "signName", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadVideoUseCase {
    public static final int $stable = AnalyticsManager.$stable;
    private final AnalyticsManager analyticsManager;
    private final SessionRepository sessionRepository;
    private final VideoUploadRepository videoUploadRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.usecase.UploadVideoUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoUploadUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.usecase.UploadVideoUseCase", f = "VideoUploadUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {20, 26}, m = "invoke", n = {"context", "videoUri", "signName", "context", "videoUri", "signName", "gmailIdResult", "gmailId"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadVideoUseCase.this.invoke(null, null, null, (Continuation) this);
        }
    }

    @Inject
    public UploadVideoUseCase(VideoUploadRepository videoUploadRepository, SessionRepository sessionRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(videoUploadRepository, "videoUploadRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.videoUploadRepository = videoUploadRepository;
        this.sessionRepository = sessionRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Context context, Uri uri, String str, Continuation<? super ResponseResource<Unit>> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object gmailId = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(gmailId);
            SessionRepository sessionRepository = this.sessionRepository;
            anonymousClass2.L$0 = context;
            anonymousClass2.L$1 = uri;
            anonymousClass2.L$2 = str;
            anonymousClass2.label = 1;
            gmailId = sessionRepository.getGmailId(anonymousClass2);
            if (gmailId != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(gmailId);
            return gmailId;
        }
        str = (String) anonymousClass2.L$2;
        uri = (Uri) anonymousClass2.L$1;
        context = (Context) anonymousClass2.L$0;
        ResultKt.throwOnFailure(gmailId);
        Uri uri2 = uri;
        String str2 = str;
        ResponseResource responseResource = (ResponseResource) gmailId;
        if (responseResource instanceof ResponseResource.Success) {
            String str3 = (String) ((ResponseResource.Success) responseResource).getData();
            if (str3.length() == 0) {
                return new ResponseResource.Error(AppError.MissingParameter.INSTANCE);
            }
            this.analyticsManager.logEvent(AnalyticsEvent.SignVideoUploaded.INSTANCE);
            VideoUploadRepository videoUploadRepository = this.videoUploadRepository;
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(uri2);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(responseResource);
            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str3);
            anonymousClass2.label = 2;
            Object objUploadVideo = videoUploadRepository.uploadVideo(context, uri2, str2, str3, anonymousClass2);
            return objUploadVideo == coroutine_suspended ? coroutine_suspended : objUploadVideo;
        }
        if (responseResource instanceof ResponseResource.Error) {
            return responseResource;
        }
        if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
            return ResponseResource.Loading.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
