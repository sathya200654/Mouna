package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.util.Log;
import androidx.camera.core.ImageProxy;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.core.BaseOptions;
import com.google.mediapipe.tasks.core.Delegate;
import com.google.mediapipe.tasks.core.ErrorListener;
import com.google.mediapipe.tasks.core.OutputHandler;
import com.google.mediapipe.tasks.core.TaskResult;
import com.google.mediapipe.tasks.vision.core.RunningMode;
import com.google.mediapipe.tasks.vision.facedetector.FaceDetector;
import com.google.mediapipe.tasks.vision.facedetector.FaceDetectorResult;
import com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarker;
import com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarkerResult;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: VisionDetector.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u001a\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u00190\u001b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00190\u001fH\u0002J\u0006\u0010!\u001a\u00020\u0019R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/VisionDetector;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "faceDetector", "Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetector;", "handLandmarker", "Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarker;", "bitmapBuffer", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "detectLivestreamFrame", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/DetectionResult;", "bitmap", "inputImageHeight", "", "inputImageWidth", "rotateAndConvertImageProxy", "imageProxy", "Landroidx/camera/core/ImageProxy;", "setupDetectors", "", "resultCallback", "Lkotlin/Function2;", "Lcom/google/mediapipe/tasks/vision/facedetector/FaceDetectorResult;", "Lcom/google/mediapipe/tasks/vision/handlandmarker/HandLandmarkerResult;", "errorCallback", "Lkotlin/Function1;", "", "close", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VisionDetector {
    public static final String TAG = "VisionDetector";
    private Bitmap bitmapBuffer;

    @ApplicationContext
    private final Context context;
    private FaceDetector faceDetector;
    private HandLandmarker handLandmarker;
    private final Matrix matrix;
    public static final int $stable = 8;

    @Inject
    public VisionDetector(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.matrix = new Matrix();
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$detectLivestreamFrame$1, reason: invalid class name */
    /* JADX INFO: compiled from: VisionDetector.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/DetectionResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$detectLivestreamFrame$1", f = "VisionDetector.kt", i = {0, 0, 0}, l = {68}, m = "invokeSuspend", n = {"$this$callbackFlow", "mpImage", "frameTime"}, s = {"L$0", "L$1", "J$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super DetectionResult>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $inputImageHeight;
        final /* synthetic */ int $inputImageWidth;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bitmap bitmap, int i, int i2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$inputImageHeight = i;
            this.$inputImageWidth = i2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = VisionDetector.this.new AnonymousClass1(this.$bitmap, this.$inputImageHeight, this.$inputImageWidth, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(ProducerScope<? super DetectionResult> producerScope, Continuation<? super Unit> continuation) {
            return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (VisionDetector.this.faceDetector == null || VisionDetector.this.handLandmarker == null) {
                    VisionDetector visionDetector = VisionDetector.this;
                    final int i2 = this.$inputImageHeight;
                    final int i3 = this.$inputImageWidth;
                    visionDetector.setupDetectors(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$detectLivestreamFrame$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2, Object obj3) {
                            return VisionDetector.AnonymousClass1.invokeSuspend$lambda$0(i2, i3, producerScope, (FaceDetectorResult) obj2, (HandLandmarkerResult) obj3);
                        }
                    }, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$detectLivestreamFrame$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2) {
                            return VisionDetector.AnonymousClass1.invokeSuspend$lambda$1(producerScope, (String) obj2);
                        }
                    });
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                MPImage mPImageBuild = new BitmapImageBuilder(this.$bitmap).build();
                FaceDetector faceDetector = VisionDetector.this.faceDetector;
                if (faceDetector != null) {
                    faceDetector.detectAsync(mPImageBuild, jUptimeMillis);
                }
                HandLandmarker handLandmarker = VisionDetector.this.handLandmarker;
                if (handLandmarker != null) {
                    handLandmarker.detectAsync(mPImageBuild, jUptimeMillis);
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(mPImageBuild);
                this.J$0 = jUptimeMillis;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$detectLivestreamFrame$1$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(int i, int i2, ProducerScope producerScope, FaceDetectorResult faceDetectorResult, HandLandmarkerResult handLandmarkerResult) {
            producerScope.trySend-JP2dKIU(new DetectionResult(faceDetectorResult, handLandmarkerResult, i, i2));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(ProducerScope producerScope, String str) {
            Log.e(VisionDetector.TAG, "Detection error: " + str);
            producerScope.close(new RuntimeException(str));
            return Unit.INSTANCE;
        }
    }

    public final Flow<DetectionResult> detectLivestreamFrame(Bitmap bitmap, int inputImageHeight, int inputImageWidth) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return FlowKt.callbackFlow(new AnonymousClass1(bitmap, inputImageHeight, inputImageWidth, null));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    private final Bitmap rotateAndConvertImageProxy(ImageProxy imageProxy) {
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
        ImageProxy imageProxy2 = (AutoCloseable) imageProxy;
        try {
            Bitmap bitmap3 = this.bitmapBuffer;
            Intrinsics.checkNotNull(bitmap3);
            bitmap3.copyPixelsFromBuffer(imageProxy2.getPlanes()[0].getBuffer());
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(imageProxy2, (Throwable) null);
            this.matrix.reset();
            this.matrix.postRotate(imageProxy.getImageInfo().getRotationDegrees());
            Bitmap bitmap4 = this.bitmapBuffer;
            Intrinsics.checkNotNull(bitmap4);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap4, 0, 0, imageProxy.getWidth(), imageProxy.getHeight(), this.matrix, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(imageProxy2, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupDetectors(final Function2<? super FaceDetectorResult, ? super HandLandmarkerResult, Unit> resultCallback, final Function1<? super String, Unit> errorCallback) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        BaseOptions.Builder delegate = BaseOptions.builder().setDelegate(Delegate.CPU);
        try {
            this.faceDetector = FaceDetector.createFromOptions(this.context, FaceDetector.FaceDetectorOptions.builder().setBaseOptions(delegate.setModelAssetPath("models/blaze_face_short_range.tflite").build()).setMinDetectionConfidence(0.7f).setRunningMode(RunningMode.LIVE_STREAM).setResultListener(new OutputHandler.ResultListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$$ExternalSyntheticLambda0
                @Override // com.google.mediapipe.tasks.core.OutputHandler.ResultListener
                public final void run(TaskResult taskResult, Object obj) {
                    VisionDetector.setupDetectors$lambda$1(objectRef, resultCallback, objectRef2, (FaceDetectorResult) taskResult, (MPImage) obj);
                }
            }).setErrorListener(new ErrorListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$$ExternalSyntheticLambda1
                @Override // com.google.mediapipe.tasks.core.ErrorListener
                public final void onError(RuntimeException runtimeException) {
                    VisionDetector.setupDetectors$lambda$2(errorCallback, runtimeException);
                }
            }).build());
        } catch (Exception e) {
            errorCallback.invoke("Face detector init failed: " + e.getMessage());
        }
        try {
            this.handLandmarker = HandLandmarker.createFromOptions(this.context, HandLandmarker.HandLandmarkerOptions.builder().setBaseOptions(delegate.setModelAssetPath("models/hand_landmarker.task").build()).setNumHands(1).setMinHandDetectionConfidence(Float.valueOf(0.5f)).setRunningMode(RunningMode.LIVE_STREAM).setResultListener(new OutputHandler.ResultListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$$ExternalSyntheticLambda2
                @Override // com.google.mediapipe.tasks.core.OutputHandler.ResultListener
                public final void run(TaskResult taskResult, Object obj) {
                    VisionDetector.setupDetectors$lambda$3(objectRef2, resultCallback, objectRef, (HandLandmarkerResult) taskResult, (MPImage) obj);
                }
            }).setErrorListener(new ErrorListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector$$ExternalSyntheticLambda3
                @Override // com.google.mediapipe.tasks.core.ErrorListener
                public final void onError(RuntimeException runtimeException) {
                    VisionDetector.setupDetectors$lambda$4(errorCallback, runtimeException);
                }
            }).build());
        } catch (Exception e2) {
            errorCallback.invoke("Hand landmarker init failed: " + e2.getMessage());
        }
    }

    private static final void setupDetectors$combinedResultListener(Function2<? super FaceDetectorResult, ? super HandLandmarkerResult, Unit> function2, Ref.ObjectRef<FaceDetectorResult> objectRef, Ref.ObjectRef<HandLandmarkerResult> objectRef2) {
        function2.invoke(objectRef.element, objectRef2.element);
        objectRef.element = null;
        objectRef2.element = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDetectors$lambda$1(Ref.ObjectRef objectRef, Function2 function2, Ref.ObjectRef objectRef2, FaceDetectorResult faceDetectorResult, MPImage mPImage) {
        objectRef.element = faceDetectorResult;
        setupDetectors$combinedResultListener(function2, objectRef, objectRef2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDetectors$lambda$2(Function1 function1, RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (message == null) {
            message = "Face detector error";
        }
        function1.invoke(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDetectors$lambda$3(Ref.ObjectRef objectRef, Function2 function2, Ref.ObjectRef objectRef2, HandLandmarkerResult handLandmarkerResult, MPImage mPImage) {
        objectRef.element = handLandmarkerResult;
        setupDetectors$combinedResultListener(function2, objectRef2, objectRef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDetectors$lambda$4(Function1 function1, RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (message == null) {
            message = "Hand landmarker error";
        }
        function1.invoke(message);
    }

    public final void close() {
        FaceDetector faceDetector = this.faceDetector;
        if (faceDetector != null) {
            faceDetector.close();
        }
        HandLandmarker handLandmarker = this.handLandmarker;
        if (handLandmarker != null) {
            handLandmarker.close();
        }
    }
}
