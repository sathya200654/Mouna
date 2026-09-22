package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: SignPracticeSessionViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState$Success;", "mediaPlayerState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;", "signPractice", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "webViewState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "isTranslatingSignPractice", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel$uiState$1", f = "SignPracticeSessionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SignPracticeSessionViewModel$uiState$1 extends SuspendLambda implements Function5<MediaPlayerState, SignPractice, WebViewState, Boolean, Continuation<? super SignPracticeSessionUiState.Success>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ boolean Z$0;
    int label;

    SignPracticeSessionViewModel$uiState$1(Continuation<? super SignPracticeSessionViewModel$uiState$1> continuation) {
        super(5, continuation);
    }

    public final Object invoke(MediaPlayerState mediaPlayerState, SignPractice signPractice, WebViewState webViewState, boolean z, Continuation<? super SignPracticeSessionUiState.Success> continuation) {
        SignPracticeSessionViewModel$uiState$1 signPracticeSessionViewModel$uiState$1 = new SignPracticeSessionViewModel$uiState$1(continuation);
        signPracticeSessionViewModel$uiState$1.L$0 = mediaPlayerState;
        signPracticeSessionViewModel$uiState$1.L$1 = signPractice;
        signPracticeSessionViewModel$uiState$1.L$2 = webViewState;
        signPracticeSessionViewModel$uiState$1.Z$0 = z;
        return signPracticeSessionViewModel$uiState$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke((MediaPlayerState) obj, (SignPractice) obj2, (WebViewState) obj3, ((Boolean) obj4).booleanValue(), (Continuation<? super SignPracticeSessionUiState.Success>) obj5);
    }

    public final Object invokeSuspend(Object obj) {
        MediaPlayerState mediaPlayerState = (MediaPlayerState) this.L$0;
        SignPractice signPractice = (SignPractice) this.L$1;
        WebViewState webViewState = (WebViewState) this.L$2;
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new SignPracticeSessionUiState.Success(signPractice, mediaPlayerState, z, webViewState);
    }
}
