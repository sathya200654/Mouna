package com.google.mediapipe.tasks.vision.handlandmarker;

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
import com.google.mediapipe.tasks.components.containers.Connection;
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
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class HandLandmarker extends BaseVisionTaskApi {
    private static final int HANDEDNESS_OUT_STREAM_INDEX = 2;
    public static final Set<Connection> HAND_CONNECTIONS;
    public static final Set<Connection> HAND_INDEX_FINGER_CONNECTIONS;
    public static final Set<Connection> HAND_MIDDLE_FINGER_CONNECTIONS;
    public static final Set<Connection> HAND_PALM_CONNECTIONS;
    public static final Set<Connection> HAND_PINKY_FINGER_CONNECTIONS;
    public static final Set<Connection> HAND_RING_FINGER_CONNECTIONS;
    public static final Set<Connection> HAND_THUMB_CONNECTIONS;
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 3;
    private static final int LANDMARKS_OUT_STREAM_INDEX = 0;
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String TAG = "HandLandmarker";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.hand_landmarker.HandLandmarkerGraph";
    private static final int WORLD_LANDMARKS_OUT_STREAM_INDEX = 1;
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in"));
    private static final List<String> OUTPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("LANDMARKS:hand_landmarks", "WORLD_LANDMARKS:world_hand_landmarks", "HANDEDNESS:handedness", "IMAGE:image_out"));

    static {
        System.loadLibrary("mediapipe_tasks_jni");
        HAND_PALM_CONNECTIONS = HandLandmarksConnections.HAND_PALM_CONNECTIONS;
        HAND_THUMB_CONNECTIONS = HandLandmarksConnections.HAND_THUMB_CONNECTIONS;
        HAND_INDEX_FINGER_CONNECTIONS = HandLandmarksConnections.HAND_INDEX_FINGER_CONNECTIONS;
        HAND_MIDDLE_FINGER_CONNECTIONS = HandLandmarksConnections.HAND_MIDDLE_FINGER_CONNECTIONS;
        HAND_RING_FINGER_CONNECTIONS = HandLandmarksConnections.HAND_RING_FINGER_CONNECTIONS;
        HAND_PINKY_FINGER_CONNECTIONS = HandLandmarksConnections.HAND_PINKY_FINGER_CONNECTIONS;
        HAND_CONNECTIONS = HandLandmarksConnections.HAND_CONNECTIONS;
    }

    public static HandLandmarker createFromFile(Context context, String modelPath) {
        return createFromOptions(context, HandLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelPath).build()).build());
    }

    public static HandLandmarker createFromFile(Context context, File modelFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelFile, 268435456);
        try {
            HandLandmarker handLandmarkerCreateFromOptions = createFromOptions(context, HandLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return handLandmarkerCreateFromOptions;
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

    public static HandLandmarker createFromBuffer(Context context, final ByteBuffer modelBuffer) {
        return createFromOptions(context, HandLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelBuffer).build()).build());
    }

    public static HandLandmarker createFromOptions(Context context, final HandLandmarkerOptions landmarkerOptions) {
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<HandLandmarkerResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarker.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public HandLandmarkerResult convertToTaskResult(List<Packet> packets) {
                if (packets.get(0).isEmpty()) {
                    return HandLandmarkerResult.create(new ArrayList(), new ArrayList(), new ArrayList(), BaseVisionTaskApi.generateResultTimestampMs(landmarkerOptions.runningMode(), packets.get(0)));
                }
                return HandLandmarkerResult.create(PacketGetter.getProtoVector(packets.get(0), LandmarkProto.NormalizedLandmarkList.parser()), PacketGetter.getProtoVector(packets.get(1), LandmarkProto.LandmarkList.parser()), PacketGetter.getProtoVector(packets.get(2), ClassificationProto.ClassificationList.parser()), BaseVisionTaskApi.generateResultTimestampMs(landmarkerOptions.runningMode(), packets.get(0)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(3))).build();
            }
        });
        Optional<OutputHandler.ResultListener<HandLandmarkerResult, MPImage>> optionalResultListener = landmarkerOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarker$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = landmarkerOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarker$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new HandLandmarker(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(landmarkerOptions.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(OUTPUT_STREAMS).setTaskOptions(landmarkerOptions).setEnableFlowLimiting(landmarkerOptions.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), landmarkerOptions.runningMode());
    }

    private HandLandmarker(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
    }

    public HandLandmarkerResult detect(MPImage image) {
        return detect(image, ImageProcessingOptions.builder().build());
    }

    public HandLandmarkerResult detect(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (HandLandmarkerResult) processImageData(image, imageProcessingOptions);
    }

    public HandLandmarkerResult detectForVideo(MPImage image, long timestampMs) {
        return detectForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public HandLandmarkerResult detectForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (HandLandmarkerResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void detectAsync(MPImage image, long timestampMs) {
        detectAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void detectAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static abstract class HandLandmarkerOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract Optional<ErrorListener> errorListener();

        abstract Optional<Float> minHandDetectionConfidence();

        abstract Optional<Float> minHandPresenceConfidence();

        abstract Optional<Float> minTrackingConfidence();

        abstract Optional<Integer> numHands();

        abstract Optional<OutputHandler.ResultListener<HandLandmarkerResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        public static abstract class Builder {
            abstract HandLandmarkerOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setMinHandDetectionConfidence(Float value);

            public abstract Builder setMinHandPresenceConfidence(Float value);

            public abstract Builder setMinTrackingConfidence(Float value);

            public abstract Builder setNumHands(Integer value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<HandLandmarkerResult, MPImage> value);

            public abstract Builder setRunningMode(RunningMode value);

            public final HandLandmarkerOptions build() {
                HandLandmarkerOptions handLandmarkerOptionsAutoBuild = autoBuild();
                if (handLandmarkerOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!handLandmarkerOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The hand landmarker is in the live stream mode, a user-defined result listener must be provided in HandLandmarkerOptions.");
                    }
                } else if (handLandmarkerOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The hand landmarker is in the image or the video mode, a user-defined result listener shouldn't be provided in HandLandmarkerOptions.");
                }
                return handLandmarkerOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            Builder numHands = new AutoValue_HandLandmarker_HandLandmarkerOptions.Builder().setRunningMode(RunningMode.IMAGE).setNumHands(1);
            Float fValueOf = Float.valueOf(0.5f);
            return numHands.setMinHandDetectionConfidence(fValueOf).setMinHandPresenceConfidence(fValueOf).setMinTrackingConfidence(fValueOf);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            final HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptions.Builder baseOptions = HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptions.newBuilder().setBaseOptions((BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder().setUseStreamMode(runningMode() != RunningMode.IMAGE).mergeFrom(convertBaseOptionsToProto(baseOptions())).build());
            final HandDetectorGraphOptionsProto.HandDetectorGraphOptions.Builder builderNewBuilder = HandDetectorGraphOptionsProto.HandDetectorGraphOptions.newBuilder();
            Optional<Integer> optionalNumHands = numHands();
            Objects.requireNonNull(builderNewBuilder);
            optionalNumHands.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarker$HandLandmarkerOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setNumHands(((Integer) obj).intValue());
                }
            });
            Optional<Float> optionalMinHandDetectionConfidence = minHandDetectionConfidence();
            Objects.requireNonNull(builderNewBuilder);
            optionalMinHandDetectionConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarker$HandLandmarkerOptions$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            final HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.Builder builderNewBuilder2 = HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.newBuilder();
            Optional<Float> optionalMinHandPresenceConfidence = minHandPresenceConfidence();
            Objects.requireNonNull(builderNewBuilder2);
            optionalMinHandPresenceConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarker$HandLandmarkerOptions$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinTrackingConfidence = minTrackingConfidence();
            Objects.requireNonNull(baseOptions);
            optionalMinTrackingConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.handlandmarker.HandLandmarker$HandLandmarkerOptions$$ExternalSyntheticLambda3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    baseOptions.setMinTrackingConfidence(((Float) obj).floatValue());
                }
            });
            baseOptions.setHandDetectorGraphOptions((HandDetectorGraphOptionsProto.HandDetectorGraphOptions) builderNewBuilder.build()).setHandLandmarksDetectorGraphOptions((HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions) builderNewBuilder2.build());
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptions.ext, (HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptions) baseOptions.build()).build();
        }
    }

    private static void validateImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        if (imageProcessingOptions.regionOfInterest().isPresent()) {
            throw new IllegalArgumentException("HandLandmarker doesn't support region-of-interest.");
        }
    }
}
