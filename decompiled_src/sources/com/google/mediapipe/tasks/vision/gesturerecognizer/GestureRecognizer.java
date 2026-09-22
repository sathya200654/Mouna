package com.google.mediapipe.tasks.vision.gesturerecognizer;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.mediapipe.formats.proto.ClassificationProto;
import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.framework.AndroidPacketGetter;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.components.processors.ClassifierOptions;
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
import com.google.mediapipe.tasks.vision.gesturerecognizer.proto.GestureClassifierGraphOptionsProto;
import com.google.mediapipe.tasks.vision.gesturerecognizer.proto.GestureRecognizerGraphOptionsProto;
import com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto;
import com.google.mediapipe.tasks.vision.handdetector.proto.HandDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto;
import com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarksDetectorGraphOptionsProto;
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
public final class GestureRecognizer extends BaseVisionTaskApi {
    private static final int HANDEDNESS_OUT_STREAM_INDEX = 2;
    private static final int HAND_GESTURES_OUT_STREAM_INDEX = 3;
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 4;
    private static final int LANDMARKS_OUT_STREAM_INDEX = 0;
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String TAG = "GestureRecognizer";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.gesture_recognizer.GestureRecognizerGraph";
    private static final int WORLD_LANDMARKS_OUT_STREAM_INDEX = 1;
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in"));
    private static final List<String> OUTPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("LANDMARKS:hand_landmarks", "WORLD_LANDMARKS:world_hand_landmarks", "HANDEDNESS:handedness", "HAND_GESTURES:hand_gestures", "IMAGE:image_out"));

    static {
        System.loadLibrary("mediapipe_tasks_jni");
    }

    public static GestureRecognizer createFromFile(Context context, String modelPath) {
        return createFromOptions(context, GestureRecognizerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelPath).build()).build());
    }

    public static GestureRecognizer createFromFile(Context context, File modelFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelFile, 268435456);
        try {
            GestureRecognizer gestureRecognizerCreateFromOptions = createFromOptions(context, GestureRecognizerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return gestureRecognizerCreateFromOptions;
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

    public static GestureRecognizer createFromBuffer(Context context, final ByteBuffer modelBuffer) {
        return createFromOptions(context, GestureRecognizerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelBuffer).build()).build());
    }

    public static GestureRecognizer createFromOptions(Context context, final GestureRecognizerOptions recognizerOptions) {
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<GestureRecognizerResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public GestureRecognizerResult convertToTaskResult(List<Packet> packets) {
                if (packets.get(3).isEmpty()) {
                    return GestureRecognizerResult.create(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), BaseVisionTaskApi.generateResultTimestampMs(recognizerOptions.runningMode(), packets.get(3)));
                }
                return GestureRecognizerResult.create(PacketGetter.getProtoVector(packets.get(0), LandmarkProto.NormalizedLandmarkList.parser()), PacketGetter.getProtoVector(packets.get(1), LandmarkProto.LandmarkList.parser()), PacketGetter.getProtoVector(packets.get(2), ClassificationProto.ClassificationList.parser()), PacketGetter.getProtoVector(packets.get(3), ClassificationProto.ClassificationList.parser()), BaseVisionTaskApi.generateResultTimestampMs(recognizerOptions.runningMode(), packets.get(3)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(4))).build();
            }
        });
        Optional<OutputHandler.ResultListener<GestureRecognizerResult, MPImage>> optionalResultListener = recognizerOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = recognizerOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new GestureRecognizer(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(recognizerOptions.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(OUTPUT_STREAMS).setTaskOptions(recognizerOptions).setEnableFlowLimiting(recognizerOptions.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), recognizerOptions.runningMode());
    }

    private GestureRecognizer(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
    }

    public GestureRecognizerResult recognize(MPImage image) {
        return recognize(image, ImageProcessingOptions.builder().build());
    }

    public GestureRecognizerResult recognize(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (GestureRecognizerResult) processImageData(image, imageProcessingOptions);
    }

    public GestureRecognizerResult recognizeForVideo(MPImage image, long timestampMs) {
        return recognizeForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public GestureRecognizerResult recognizeForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (GestureRecognizerResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void recognizeAsync(MPImage image, long timestampMs) {
        recognizeAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void recognizeAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static abstract class GestureRecognizerOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract Optional<ClassifierOptions> cannedGesturesClassifierOptions();

        abstract Optional<ClassifierOptions> customGesturesClassifierOptions();

        abstract Optional<ErrorListener> errorListener();

        abstract Optional<Float> minHandDetectionConfidence();

        abstract Optional<Float> minHandPresenceConfidence();

        abstract Optional<Float> minTrackingConfidence();

        abstract Optional<Integer> numHands();

        abstract Optional<OutputHandler.ResultListener<GestureRecognizerResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        public static abstract class Builder {
            abstract GestureRecognizerOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setCannedGesturesClassifierOptions(ClassifierOptions classifierOptions);

            public abstract Builder setCustomGesturesClassifierOptions(ClassifierOptions classifierOptions);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setMinHandDetectionConfidence(Float value);

            public abstract Builder setMinHandPresenceConfidence(Float value);

            public abstract Builder setMinTrackingConfidence(Float value);

            public abstract Builder setNumHands(Integer value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<GestureRecognizerResult, MPImage> value);

            public abstract Builder setRunningMode(RunningMode value);

            public final GestureRecognizerOptions build() {
                GestureRecognizerOptions gestureRecognizerOptionsAutoBuild = autoBuild();
                if (gestureRecognizerOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!gestureRecognizerOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The gesture recognizer is in the live stream mode, a user-defined result listener must be provided in GestureRecognizerOptions.");
                    }
                } else if (gestureRecognizerOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The gesture recognizer is in the image or the video mode, a user-defined result listener shouldn't be provided in GestureRecognizerOptions.");
                }
                return gestureRecognizerOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            Builder numHands = new AutoValue_GestureRecognizer_GestureRecognizerOptions.Builder().setRunningMode(RunningMode.IMAGE).setNumHands(1);
            Float fValueOf = Float.valueOf(0.5f);
            return numHands.setMinHandDetectionConfidence(fValueOf).setMinHandPresenceConfidence(fValueOf).setMinTrackingConfidence(fValueOf);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            GestureRecognizerGraphOptionsProto.GestureRecognizerGraphOptions.Builder baseOptions = GestureRecognizerGraphOptionsProto.GestureRecognizerGraphOptions.newBuilder().setBaseOptions((BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder().setUseStreamMode(runningMode() != RunningMode.IMAGE).mergeFrom(convertBaseOptionsToProto(baseOptions())).build());
            final HandDetectorGraphOptionsProto.HandDetectorGraphOptions.Builder builderNewBuilder = HandDetectorGraphOptionsProto.HandDetectorGraphOptions.newBuilder();
            Optional<Integer> optionalNumHands = numHands();
            Objects.requireNonNull(builderNewBuilder);
            optionalNumHands.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer$GestureRecognizerOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setNumHands(((Integer) obj).intValue());
                }
            });
            Optional<Float> optionalMinHandDetectionConfidence = minHandDetectionConfidence();
            Objects.requireNonNull(builderNewBuilder);
            optionalMinHandDetectionConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer$GestureRecognizerOptions$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            final HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.Builder builderNewBuilder2 = HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.newBuilder();
            Optional<Float> optionalMinHandPresenceConfidence = minHandPresenceConfidence();
            Objects.requireNonNull(builderNewBuilder2);
            optionalMinHandPresenceConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer$GestureRecognizerOptions$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            final HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptions.Builder builderNewBuilder3 = HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptions.newBuilder();
            Optional<Float> optionalMinTrackingConfidence = minTrackingConfidence();
            Objects.requireNonNull(builderNewBuilder3);
            optionalMinTrackingConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer$GestureRecognizerOptions$$ExternalSyntheticLambda3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder3.setMinTrackingConfidence(((Float) obj).floatValue());
                }
            });
            builderNewBuilder3.setHandDetectorGraphOptions((HandDetectorGraphOptionsProto.HandDetectorGraphOptions) builderNewBuilder.build()).setHandLandmarksDetectorGraphOptions((HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions) builderNewBuilder2.build());
            final HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptions.Builder builderNewBuilder4 = HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptions.newBuilder();
            cannedGesturesClassifierOptions().ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer$GestureRecognizerOptions$$ExternalSyntheticLambda4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder4.setCannedGestureClassifierGraphOptions((GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions) GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.newBuilder().setClassifierOptions(((ClassifierOptions) obj).convertToProto()).build());
                }
            });
            customGesturesClassifierOptions().ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.gesturerecognizer.GestureRecognizer$GestureRecognizerOptions$$ExternalSyntheticLambda5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder4.setCustomGestureClassifierGraphOptions((GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions) GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.newBuilder().setClassifierOptions(((ClassifierOptions) obj).convertToProto()).build());
                }
            });
            baseOptions.setHandLandmarkerGraphOptions((HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptions) builderNewBuilder3.build()).setHandGestureRecognizerGraphOptions((HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptions) builderNewBuilder4.build());
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(GestureRecognizerGraphOptionsProto.GestureRecognizerGraphOptions.ext, (GestureRecognizerGraphOptionsProto.GestureRecognizerGraphOptions) baseOptions.build()).build();
        }
    }

    private static void validateImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        if (imageProcessingOptions.regionOfInterest().isPresent()) {
            throw new IllegalArgumentException("GestureRecognizer doesn't support region-of-interest.");
        }
    }
}
