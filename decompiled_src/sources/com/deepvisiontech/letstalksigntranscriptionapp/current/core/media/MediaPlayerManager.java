package com.deepvisiontech.letstalksigntranscriptionapp.current.core.media;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import com.azure.core.util.tracing.Tracer;
import com.google.firebase.perf.util.Constants;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: MediaPlayerManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "player", "Landroidx/media3/common/Player;", "getPlayer", "()Landroidx/media3/common/Player;", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "positionUpdateJob", "Lkotlinx/coroutines/Job;", "_mediaPlayerState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;", "mediaPlayerState", "Lkotlinx/coroutines/flow/StateFlow;", "getMediaPlayerState", "()Lkotlinx/coroutines/flow/StateFlow;", "_mediaPlayerEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent;", "mediaPlayerEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getMediaPlayerEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "startPositionUpdates", "", "stopPositionUpdates", "setMediaItem", "mediaItem", "Landroidx/media3/common/MediaItem;", "play", "pause", "stop", "seekTo", "positionMs", "", "setPlaybackSpeed", "speed", "", "onStop", "owner", "Landroidx/lifecycle/LifecycleOwner;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaPlayerManager implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    private final MutableSharedFlow<MediaPlayerEvent> _mediaPlayerEvent;
    private final MutableStateFlow<MediaPlayerState> _mediaPlayerState;

    @ApplicationContext
    private final Context context;
    private ExoPlayer exoPlayer;
    private final SharedFlow<MediaPlayerEvent> mediaPlayerEvent;
    private final StateFlow<MediaPlayerState> mediaPlayerState;
    private Job positionUpdateJob;
    private final CoroutineScope scope;

    public void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Inject
    public MediaPlayerManager(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.exoPlayer = new ExoPlayer.Builder(context).build();
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        MutableStateFlow<MediaPlayerState> MutableStateFlow = StateFlowKt.MutableStateFlow(new MediaPlayerState(0, false, 0.0f, 0L, 0L, null, 63, null));
        this._mediaPlayerState = MutableStateFlow;
        this.mediaPlayerState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<MediaPlayerEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 5, (Object) null);
        this._mediaPlayerEvent = mutableSharedFlowMutableSharedFlow$default;
        this.mediaPlayerEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.addListener(new Player.Listener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerManager.1
                public void onPlaybackStateChanged(int playbackState) {
                    long duration;
                    MutableStateFlow mutableStateFlow = MediaPlayerManager.this._mediaPlayerState;
                    MediaPlayerManager mediaPlayerManager = MediaPlayerManager.this;
                    while (true) {
                        Object value = mutableStateFlow.getValue();
                        MediaPlayerState mediaPlayerState = (MediaPlayerState) value;
                        if (playbackState == 3) {
                            ExoPlayer exoPlayer2 = mediaPlayerManager.exoPlayer;
                            duration = exoPlayer2 != null ? exoPlayer2.getDuration() : 0L;
                        } else {
                            duration = mediaPlayerState.getDuration();
                        }
                        long j = duration;
                        int i = playbackState;
                        if (mutableStateFlow.compareAndSet(value, MediaPlayerState.copy$default(mediaPlayerState, i, false, 0.0f, 0L, j, null, 46, null))) {
                            return;
                        } else {
                            playbackState = i;
                        }
                    }
                }

                public void onIsPlayingChanged(boolean isPlayingValue) {
                    boolean z;
                    MutableStateFlow mutableStateFlow = MediaPlayerManager.this._mediaPlayerState;
                    while (true) {
                        Object value = mutableStateFlow.getValue();
                        z = isPlayingValue;
                        if (mutableStateFlow.compareAndSet(value, MediaPlayerState.copy$default((MediaPlayerState) value, 0, z, 0.0f, 0L, 0L, null, 61, null))) {
                            break;
                        } else {
                            isPlayingValue = z;
                        }
                    }
                    if (z) {
                        MediaPlayerManager.this.startPositionUpdates();
                    } else {
                        MediaPlayerManager.this.stopPositionUpdates();
                    }
                }

                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                    Object value;
                    Intrinsics.checkNotNullParameter(playbackParameters, "playbackParameters");
                    MutableStateFlow mutableStateFlow = MediaPlayerManager.this._mediaPlayerState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, MediaPlayerState.copy$default((MediaPlayerState) value, 0, false, playbackParameters.speed, 0L, 0L, null, 59, null)));
                }

                /* JADX WARN: Code duplicated, block: B:14:0x0029  */
                /* JADX WARN: Code duplicated, block: B:16:0x0031  */
                /* JADX WARN: Code duplicated, block: B:18:0x0039  */
                /* JADX WARN: Code duplicated, block: B:20:0x0041  */
                public void onPlayerError(PlaybackException error) {
                    String message;
                    MediaPlayerEvent.Error.SourceError sourceError;
                    Object value;
                    String message2;
                    Intrinsics.checkNotNullParameter(error, "error");
                    int i = error.errorCode;
                    if (i == 3001 || i == 3002) {
                        message = error.getMessage();
                        if (message == null) {
                            message = "Source Error";
                        }
                        sourceError = new MediaPlayerEvent.Error.SourceError(message);
                    } else if (i != 4005) {
                        switch (i) {
                            case Constants.MAX_URL_LENGTH /* 2000 */:
                            case 2001:
                            case 2002:
                            case 2003:
                            case 2004:
                            case 2005:
                                message = error.getMessage();
                                if (message == null) {
                                    message = "Source Error";
                                }
                                sourceError = new MediaPlayerEvent.Error.SourceError(message);
                                break;
                            default:
                                switch (i) {
                                    case 4001:
                                    case 4002:
                                    case 4003:
                                        message2 = error.getMessage();
                                        if (message2 == null) {
                                            message2 = "Render Error";
                                        }
                                        sourceError = new MediaPlayerEvent.Error.RenderError(message2);
                                        break;
                                    default:
                                        String message3 = error.getMessage();
                                        if (message3 == null) {
                                            message3 = "Unexpected Error";
                                        }
                                        sourceError = new MediaPlayerEvent.Error.UnexpectedError(message3);
                                        break;
                                }
                                break;
                        }
                    } else {
                        message2 = error.getMessage();
                        if (message2 == null) {
                            message2 = "Render Error";
                        }
                        sourceError = new MediaPlayerEvent.Error.RenderError(message2);
                    }
                    MediaPlayerEvent.Error error2 = sourceError;
                    MediaPlayerManager.this._mediaPlayerEvent.tryEmit(error2);
                    MutableStateFlow mutableStateFlow = MediaPlayerManager.this._mediaPlayerState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, MediaPlayerState.copy$default((MediaPlayerState) value, 0, false, 0.0f, 0L, 0L, error2, 31, null)));
                }
            });
        }
    }

    public final Player getPlayer() {
        return this.exoPlayer;
    }

    public final StateFlow<MediaPlayerState> getMediaPlayerState() {
        return this.mediaPlayerState;
    }

    public final SharedFlow<MediaPlayerEvent> getMediaPlayerEvent() {
        return this.mediaPlayerEvent;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerManager$startPositionUpdates$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaPlayerManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerManager$startPositionUpdates$1", f = "MediaPlayerManager.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    static final class C02631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02631(Continuation<? super C02631> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaPlayerManager.this.new C02631(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object value;
            MediaPlayerState mediaPlayerState;
            ExoPlayer exoPlayer;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            do {
                MutableStateFlow mutableStateFlow = MediaPlayerManager.this._mediaPlayerState;
                MediaPlayerManager mediaPlayerManager = MediaPlayerManager.this;
                do {
                    value = mutableStateFlow.getValue();
                    mediaPlayerState = (MediaPlayerState) value;
                    exoPlayer = mediaPlayerManager.exoPlayer;
                } while (!mutableStateFlow.compareAndSet(value, MediaPlayerState.copy$default(mediaPlayerState, 0, false, 0.0f, exoPlayer != null ? exoPlayer.getCurrentPosition() : 0L, 0L, null, 55, null)));
                this.label = 1;
            } while (DelayKt.delay(200L, (Continuation) this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPositionUpdates() {
        Job job = this.positionUpdateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.positionUpdateJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C02631(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopPositionUpdates() {
        Job job = this.positionUpdateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void setMediaItem(MediaItem mediaItem) {
        Object value;
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setMediaItem(mediaItem);
        }
        ExoPlayer exoPlayer2 = this.exoPlayer;
        if (exoPlayer2 != null) {
            exoPlayer2.prepare();
        }
        MutableStateFlow<MediaPlayerState> mutableStateFlow = this._mediaPlayerState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MediaPlayerState.copy$default((MediaPlayerState) value, 0, false, 0.0f, 0L, 0L, null, 31, null)));
    }

    public final void play() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.play();
        }
    }

    public final void pause() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
    }

    public final void stop() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        ExoPlayer exoPlayer2 = this.exoPlayer;
        if (exoPlayer2 != null) {
            exoPlayer2.clearMediaItems();
        }
        this._mediaPlayerState.setValue(new MediaPlayerState(0, false, 0.0f, 0L, 0L, null, 63, null));
    }

    public final void seekTo(long positionMs) {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.seekTo(positionMs);
        }
        MutableStateFlow<MediaPlayerState> mutableStateFlow = this._mediaPlayerState;
        while (true) {
            Object value = mutableStateFlow.getValue();
            long j = positionMs;
            if (mutableStateFlow.compareAndSet(value, MediaPlayerState.copy$default((MediaPlayerState) value, 0, false, 0.0f, j, 0L, null, 55, null))) {
                return;
            } else {
                positionMs = j;
            }
        }
    }

    public final void setPlaybackSpeed(float speed) {
        PlaybackParameters playbackParameters = new PlaybackParameters(speed);
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setPlaybackParameters(playbackParameters);
        }
    }

    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        stopPositionUpdates();
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        this.exoPlayer = null;
    }
}
