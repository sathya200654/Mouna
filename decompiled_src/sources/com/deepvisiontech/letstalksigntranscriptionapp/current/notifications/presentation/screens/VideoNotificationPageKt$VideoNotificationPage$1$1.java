package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens;

import androidx.media3.common.MediaItem;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: VideoNotificationPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$VideoNotificationPage$1$1", f = "VideoNotificationPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoNotificationPageKt$VideoNotificationPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<MediaItem, Unit> $onLoadVideo;
    final /* synthetic */ NotificationData $pageData;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoNotificationPageKt$VideoNotificationPage$1$1(NotificationData notificationData, Function1<? super MediaItem, Unit> function1, Continuation<? super VideoNotificationPageKt$VideoNotificationPage$1$1> continuation) {
        super(2, continuation);
        this.$pageData = notificationData;
        this.$onLoadVideo = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoNotificationPageKt$VideoNotificationPage$1$1(this.$pageData, this.$onLoadVideo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String video = this.$pageData.getVideo();
        if (video != null) {
            Function1<MediaItem, Unit> function1 = this.$onLoadVideo;
            if (!StringsKt.isBlank(video)) {
                MediaItem mediaItemFromUri = MediaItem.fromUri(video);
                Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
                function1.invoke(mediaItemFromUri);
            }
        }
        return Unit.INSTANCE;
    }
}
