package com.google.mediapipe.tasks.vision.facedetector;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.mediapipe.formats.proto.DetectionProto;
import com.google.mediapipe.framework.AndroidPacketGetter;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.BaseOptions;
import com.google.mediapipe.tasks.core.ErrorListener;
import com.google.mediapipe.tasks.core.OutputHandler;
import com.google.mediapipe.tasks.core.TaskInfo;
import com.google.mediapipe.tasks.core.TaskOptions;
import com.google.mediapipe.tasks.core.TaskResult;
import com.google.mediapipe.tasks.core.TaskRunner;
import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
import com.google.mediapipe.tasks.vision.core.BaseVisionTaskApi;
import com.google.mediapipe.tasks.vision.core.ImageProcessingOptions;
import com.google.mediapipe.tasks.vision.core.RunningMode;
import com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FaceDetector extends BaseVisionTaskApi {
    private static final int DETECTIONS_OUT_STREAM_INDEX = 0;
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 1;
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String TAG = "FaceDetector";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.face_detector.FaceDetectorGraph";
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in"));
    private static final List<String> OUTPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("DETECTIONS:detections_out", "IMAGE:image_out"));

    static {
        System.loadLibrary("mediapipe_tasks_jni");
    }

    public static FaceDetector createFromFile(Context context, String modelPath) {
        return createFromOptions(context, FaceDetectorOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelPath).build()).build());
    }

    public static FaceDetector createFromFile(Context context, File modelFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelFile, 268435456);
        try {
            FaceDetector faceDetectorCreateFromOptions = createFromOptions(context, FaceDetectorOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return faceDetectorCreateFromOptions;
        } catch (Throwable th) {
            if (parcelFileDescriptorOpen != null) {
                try {
                    parcelFileDescriptorOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static FaceDetector createFromBuffer(Context context, final ByteBuffer modelBuffer) {
        return createFromOptions(context, FaceDetectorOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelBuffer).build()).build());
    }

    public static FaceDetector createFromOptions(Context context, final FaceDetectorOptions detectorOptions) {
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<FaceDetectorResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.facedetector.FaceDetector.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public FaceDetectorResult convertToTaskResult(List<Packet> packets) {
                if (packets.get(0).isEmpty()) {
                    return FaceDetectorResult.create(new ArrayList(), BaseVisionTaskApi.generateResultTimestampMs(detectorOptions.runningMode(), packets.get(0)));
                }
                return FaceDetectorResult.create(PacketGetter.getProtoVector(packets.get(0), DetectionProto.Detection.parser()), BaseVisionTaskApi.generateResultTimestampMs(detectorOptions.runningMode(), packets.get(0)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(1))).build();
            }
        });
        Optional<OutputHandler.ResultListener<FaceDetectorResult, MPImage>> optionalResultListener = detectorOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.facedetector.FaceDetector$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = detectorOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.facedetector.FaceDetector$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new FaceDetector(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(detectorOptions.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(OUTPUT_STREAMS).setTaskOptions(detectorOptions).setEnableFlowLimiting(detectorOptions.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), detectorOptions.runningMode());
    }

    private FaceDetector(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
    }

    public FaceDetectorResult detect(MPImage image) {
        return detect(image, ImageProcessingOptions.builder().build());
    }

    public FaceDetectorResult detect(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (FaceDetectorResult) processImageData(image, imageProcessingOptions);
    }

    public FaceDetectorResult detectForVideo(MPImage image, long timestampMs) {
        return detectForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public FaceDetectorResult detectForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (FaceDetectorResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void detectAsync(MPImage image, long timestampMs) {
        detectAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void detectAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static abstract class FaceDetectorOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract Optional<ErrorListener> errorListener();

        abstract float minDetectionConfidence();

        abstract float minSuppressionThreshold();

        abstract Optional<OutputHandler.ResultListener<FaceDetectorResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        public static abstract class Builder {
            abstract FaceDetectorOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setMinDetectionConfidence(float value);

            public abstract Builder setMinSuppressionThreshold(float value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<FaceDetectorResult, MPImage> value);

            public abstract Builder setRunningMode(RunningMode value);

            public final FaceDetectorOptions build() {
                FaceDetectorOptions faceDetectorOptionsAutoBuild = autoBuild();
                if (faceDetectorOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!faceDetectorOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The face detector is in the live stream mode, a user-defined result listener must be provided in FaceDetectorOptions.");
                    }
                } else if (faceDetectorOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The face detector is in the image or the video mode, a user-defined result listener shouldn't be provided in FaceDetectorOptions.");
                }
                return faceDetectorOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            return new AutoValue_FaceDetector_FaceDetectorOptions.Builder().setRunningMode(RunningMode.IMAGE).setMinDetectionConfidence(0.5f).setMinSuppressionThreshold(0.3f);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            BaseOptionsProto.BaseOptions.Builder builderNewBuilder = BaseOptionsProto.BaseOptions.newBuilder();
            builderNewBuilder.setUseStreamMode(runningMode() != RunningMode.IMAGE);
            builderNewBuilder.mergeFrom(convertBaseOptionsToProto(baseOptions()));
            FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.Builder baseOptions = FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.newBuilder().setBaseOptions(builderNewBuilder);
            baseOptions.setMinDetectionConfidence(minDetectionConfidence());
            baseOptions.setMinSuppressionThreshold(minSuppressionThreshold());
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.ext, (FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions) baseOptions.build()).build();
        }
    }

    private static void validateImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        if (imageProcessingOptions.regionOfInterest().isPresent()) {
            throw new IllegalArgumentException("FaceDetector doesn't support region-of-interest.");
        }
    }
}
