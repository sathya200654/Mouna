package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.camera.core.ImageProxy;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import coil3.util.UtilsKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.DetectionResult;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.YuvToRgbConverter;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.usecase.UploadVideoUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.mappers.AppErrorMapperKt;
import com.google.mediapipe.tasks.components.containers.Detection;
import com.google.mediapipe.tasks.vision.facedetector.FaceDetectorResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SignUploadViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020#H\u0003J\u001c\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(J\u0006\u00100\u001a\u00020\u001fJ\b\u00101\u001a\u00020\u001fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/VideoUploadViewModel;", "Landroidx/lifecycle/ViewModel;", "uploadVideoUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/usecase/UploadVideoUseCase;", "visionDetectorProvider", "Ljavax/inject/Provider;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/VisionDetector;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/usecase/UploadVideoUseCase;Ljavax/inject/Provider;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/DetectionUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "videoRecordingJob", "Lkotlinx/coroutines/Job;", "activeRecording", "Landroidx/camera/video/Recording;", "totalFramesProcessed", "", "faceFramesCount", "visionDetector", "yuvToRgbConverter", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/YuvToRgbConverter;", "bitmapBuffer", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "setupDetector", "", "closeDetector", "processFrame", "imageProxy", "Landroidx/camera/core/ImageProxy;", "convertAndRotateImageProxy", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/presentation/viewmodels/ProcessedFrame;", "startRecording", "context", "Landroid/content/Context;", "videoCapture", "Landroidx/camera/video/VideoCapture;", "Landroidx/camera/video/Recorder;", "onVideoNameChange", "name", "", "startUpload", "resetToIdle", "onCleared", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoUploadViewModel extends ViewModel {
    private static final double FACE_VALIDITY_THRESHOLD = 0.4d;
    private final MutableStateFlow<DetectionUiState> _uiState;
    private Recording activeRecording;
    private Bitmap bitmapBuffer;
    private int faceFramesCount;
    private final Matrix matrix;
    private int totalFramesProcessed;
    private final StateFlow<DetectionUiState> uiState;
    private final UploadVideoUseCase uploadVideoUseCase;
    private Job videoRecordingJob;
    private VisionDetector visionDetector;
    private final Provider<VisionDetector> visionDetectorProvider;
    private final YuvToRgbConverter yuvToRgbConverter;
    public static final int $stable = 8;

    @Inject
    public VideoUploadViewModel(UploadVideoUseCase uploadVideoUseCase, Provider<VisionDetector> provider) {
        Intrinsics.checkNotNullParameter(uploadVideoUseCase, "uploadVideoUseCase");
        Intrinsics.checkNotNullParameter(provider, "visionDetectorProvider");
        this.uploadVideoUseCase = uploadVideoUseCase;
        this.visionDetectorProvider = provider;
        MutableStateFlow<DetectionUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DetectionUiState(null, null, 0, 0, 0.0f, null, 0, null, null, false, false, null, null, 8191, null));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        this.yuvToRgbConverter = new YuvToRgbConverter();
        this.matrix = new Matrix();
    }

    public final StateFlow<DetectionUiState> getUiState() {
        return this.uiState;
    }

    public final void setupDetector() {
        VisionDetector visionDetector = this.visionDetector;
        if (visionDetector != null) {
            visionDetector.close();
        }
        this.visionDetector = (VisionDetector) this.visionDetectorProvider.get();
    }

    public final void closeDetector() {
        VisionDetector visionDetector = this.visionDetector;
        if (visionDetector != null) {
            visionDetector.close();
        }
        this.visionDetector = null;
    }

    public final void processFrame(ImageProxy imageProxy) {
        Flow<DetectionResult> flowDetectLivestreamFrame;
        Flow flowOnEach;
        Flow flowCatch;
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        ProcessedFrame processedFrameConvertAndRotateImageProxy = convertAndRotateImageProxy(imageProxy);
        VisionDetector visionDetector = this.visionDetector;
        if (visionDetector == null || (flowDetectLivestreamFrame = visionDetector.detectLivestreamFrame(processedFrameConvertAndRotateImageProxy.getBitmap(), processedFrameConvertAndRotateImageProxy.getHeight(), processedFrameConvertAndRotateImageProxy.getWidth())) == null || (flowOnEach = FlowKt.onEach(flowDetectLivestreamFrame, new AnonymousClass1(null))) == null || (flowCatch = FlowKt.catch(flowOnEach, new AnonymousClass2(null))) == null) {
            return;
        }
        FlowKt.launchIn(flowCatch, ViewModelKt.getViewModelScope(this));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$processFrame$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignUploadViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/DetectionResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$processFrame$1", f = "SignUploadViewModel.kt", i = {0}, l = {126}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<DetectionResult, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = VideoUploadViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(DetectionResult detectionResult, Continuation<? super Unit> continuation) {
            return create(detectionResult, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$processFrame$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SignUploadViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$processFrame$1$1", f = "SignUploadViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DetectionResult $result;
            int label;
            final /* synthetic */ VideoUploadViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00511(VideoUploadViewModel videoUploadViewModel, DetectionResult detectionResult, Continuation<? super C00511> continuation) {
                super(2, continuation);
                this.this$0 = videoUploadViewModel;
                this.$result = detectionResult;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00511(this.this$0, this.$result, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object value;
                List<Detection> listDetections;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (((DetectionUiState) this.this$0._uiState.getValue()).getRecordingState() == RecordingState.RECORDING) {
                        this.this$0.totalFramesProcessed++;
                        FaceDetectorResult faceDetectorResult = this.$result.getFaceDetectorResult();
                        if (faceDetectorResult != null && (listDetections = faceDetectorResult.detections()) != null && listDetections.size() == 1) {
                            this.this$0.faceFramesCount++;
                        }
                    }
                    MutableStateFlow mutableStateFlow = this.this$0._uiState;
                    DetectionResult detectionResult = this.$result;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, DetectionUiState.copy$default((DetectionUiState) value, detectionResult.getFaceDetectorResult(), null, detectionResult.getInputImageHeight(), detectionResult.getInputImageWidth(), 0.0f, null, 0, null, null, false, false, null, null, 8178, null)));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invokeSuspend(Object obj) {
            DetectionResult detectionResult = (DetectionResult) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(detectionResult);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C00511(VideoUploadViewModel.this, detectionResult, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$processFrame$2, reason: invalid class name */
    /* JADX INFO: compiled from: SignUploadViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/DetectionResult;", "error", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$processFrame$2", f = "SignUploadViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super DetectionResult>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(FlowCollector<? super DetectionResult> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Log.e("VideoUploadViewModel", "Detection flow error: " + th.getMessage());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    private final ProcessedFrame convertAndRotateImageProxy(ImageProxy imageProxy) {
        Bitmap bitmap = this.bitmapBuffer;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            if (bitmap.getWidth() == imageProxy.getWidth()) {
                Bitmap bitmap2 = this.bitmapBuffer;
                Intrinsics.checkNotNull(bitmap2);
                if (bitmap2.getHeight() != imageProxy.getHeight()) {
                    this.bitmapBuffer = Bitmap.createBitmap(imageProxy.getWidth(), imageProxy.getHeight(), Bitmap.Config.ARGB_8888);
                }
            } else {
                this.bitmapBuffer = Bitmap.createBitmap(imageProxy.getWidth(), imageProxy.getHeight(), Bitmap.Config.ARGB_8888);
            }
        } else {
            this.bitmapBuffer = Bitmap.createBitmap(imageProxy.getWidth(), imageProxy.getHeight(), Bitmap.Config.ARGB_8888);
        }
        YuvToRgbConverter yuvToRgbConverter = this.yuvToRgbConverter;
        Image image = imageProxy.getImage();
        Intrinsics.checkNotNull(image);
        Bitmap bitmap3 = this.bitmapBuffer;
        Intrinsics.checkNotNull(bitmap3);
        yuvToRgbConverter.yuvToRgb(image, bitmap3);
        this.matrix.reset();
        this.matrix.postRotate(imageProxy.getImageInfo().getRotationDegrees());
        Bitmap bitmap4 = this.bitmapBuffer;
        Intrinsics.checkNotNull(bitmap4);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap4, 0, 0, imageProxy.getWidth(), imageProxy.getHeight(), this.matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return new ProcessedFrame(bitmapCreateBitmap, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
    }

    public final void startRecording(Context context, VideoCapture<Recorder> videoCapture) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoCapture, "videoCapture");
        Job job = this.videoRecordingJob;
        if (job == null || !job.isActive()) {
            this.videoRecordingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C03081(context, videoCapture, null), 3, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$startRecording$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignUploadViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$startRecording$1", f = "SignUploadViewModel.kt", i = {0, 0, 0}, l = {182}, m = "invokeSuspend", n = {UtilsKt.SCHEME_FILE, "outputOptions", "i"}, s = {"L$0", "L$1", "I$0"})
    static final class C03081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ VideoCapture<Recorder> $videoCapture;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03081(Context context, VideoCapture<Recorder> videoCapture, Continuation<? super C03081> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$videoCapture = videoCapture;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(VideoRecordEvent videoRecordEvent) {
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VideoUploadViewModel.this.new C03081(this.$context, this.$videoCapture, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0126 A[LOOP:0: B:14:0x00c6->B:21:0x0126, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:41:0x0102 A[EDGE_INSN: B:41:0x0102->B:16:0x0102 BREAK  A[LOOP:0: B:14:0x00c6->B:21:0x0126], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x011b -> B:20:0x011f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:14:0x00c6
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instruction units count: 450
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel.C03081.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void onVideoNameChange(String name) {
        String str = name;
        Intrinsics.checkNotNullParameter(str, "name");
        MutableStateFlow<DetectionUiState> mutableStateFlow = this._uiState;
        while (true) {
            Object value = mutableStateFlow.getValue();
            if (mutableStateFlow.compareAndSet(value, DetectionUiState.copy$default((DetectionUiState) value, null, null, 0, 0, 0.0f, null, 0, str, null, false, false, null, null, 8063, null))) {
                return;
            } else {
                str = name;
            }
        }
    }

    public final void startUpload(Context context) throws FileNotFoundException {
        long statSize;
        Object value;
        Object value2;
        Intrinsics.checkNotNullParameter(context, "context");
        DetectionUiState detectionUiState = (DetectionUiState) this._uiState.getValue();
        Uri recordedVideoUri = detectionUiState.getRecordedVideoUri();
        if (recordedVideoUri == null) {
            return;
        }
        if (StringsKt.isBlank(detectionUiState.getVideoName())) {
            MutableStateFlow<DetectionUiState> mutableStateFlow = this._uiState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, DetectionUiState.copy$default((DetectionUiState) value2, null, null, 0, 0, 0.0f, null, 0, null, null, false, false, Integer.valueOf(R.string.sign_video_name_empty_warning), null, 2047, null)));
            return;
        }
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(recordedVideoUri, "r");
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
            try {
                statSize = parcelFileDescriptor.getStatSize();
                CloseableKt.closeFinally(parcelFileDescriptor, (Throwable) null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(parcelFileDescriptor, th);
                    throw th2;
                }
            }
        } else {
            statSize = 0;
        }
        long j = statSize / ((long) 1048576);
        if (j > 50) {
            MutableStateFlow<DetectionUiState> mutableStateFlow2 = this._uiState;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, DetectionUiState.copy$default((DetectionUiState) value, null, null, 0, 0, 0.0f, null, 0, null, null, false, false, null, "File size (" + j + " MB) is too large. Limit is 50 MB.", 2047, null)));
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(context, recordedVideoUri, detectionUiState, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$startUpload$3, reason: invalid class name */
    /* JADX INFO: compiled from: SignUploadViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel$startUpload$3", f = "SignUploadViewModel.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ DetectionUiState $currentUiState;
        final /* synthetic */ Uri $videoUri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Context context, Uri uri, DetectionUiState detectionUiState, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$videoUri = uri;
            this.$currentUiState = detectionUiState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VideoUploadViewModel.this.new AnonymousClass3(this.$context, this.$videoUri, this.$currentUiState, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
            Object value;
            Object objInvoke;
            Object value2;
            Object value3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = VideoUploadViewModel.this._uiState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, DetectionUiState.copy$default((DetectionUiState) value, null, null, 0, 0, 0.0f, null, 0, null, null, true, false, null, null, 1535, null)));
                this.label = 1;
                objInvoke = VideoUploadViewModel.this.uploadVideoUseCase.invoke(this.$context, this.$videoUri, this.$currentUiState.getVideoName(), (Continuation) this);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objInvoke = obj;
            }
            ResponseResource responseResource = (ResponseResource) objInvoke;
            if (responseResource instanceof ResponseResource.Error) {
                MutableStateFlow mutableStateFlow2 = VideoUploadViewModel.this._uiState;
                do {
                    value3 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value3, DetectionUiState.copy$default((DetectionUiState) value3, null, null, 0, 0, 0.0f, null, 0, null, null, false, false, Boxing.boxInt(AppErrorMapperKt.toVideoUploadErrorMessageRes(((ResponseResource.Error) responseResource).getError())), null, 1535, null)));
            } else if (!Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                if (responseResource instanceof ResponseResource.Success) {
                    MutableStateFlow mutableStateFlow3 = VideoUploadViewModel.this._uiState;
                    do {
                        value2 = mutableStateFlow3.getValue();
                    } while (!mutableStateFlow3.compareAndSet(value2, DetectionUiState.copy$default((DetectionUiState) value2, null, null, 0, 0, 0.0f, null, 0, null, null, false, true, null, null, 6655, null)));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void resetToIdle() {
        Object value;
        String path;
        Uri recordedVideoUri = ((DetectionUiState) this._uiState.getValue()).getRecordedVideoUri();
        if (recordedVideoUri != null && (path = recordedVideoUri.getPath()) != null) {
            new File(path).delete();
        }
        MutableStateFlow<DetectionUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, DetectionUiState.copy$default((DetectionUiState) value, null, null, 0, 0, 0.0f, RecordingState.IDLE, 0, "", null, false, false, null, null, 95, null)));
    }

    protected void onCleared() {
        super.onCleared();
        closeDetector();
        Job job = this.videoRecordingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Recording recording = this.activeRecording;
        if (recording != null) {
            recording.stop();
        }
    }
}
