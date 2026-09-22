package com.google.mediapipe.tasks.vision.poselandmarker;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.framework.AndroidPacketGetter;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.framework.image.ByteBufferImageBuilder;
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
import com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto;
import com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarksDetectorGraphOptionsProto;
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
public final class PoseLandmarker extends BaseVisionTaskApi {
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 2;
    private static final int LANDMARKS_OUT_STREAM_INDEX = 0;
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    public static final Set<Connection> POSE_LANDMARKS;
    private static final String TAG = "PoseLandmarker";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.pose_landmarker.PoseLandmarkerGraph";
    private static final int WORLD_LANDMARKS_OUT_STREAM_INDEX = 1;
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in"));
    private static int segmentationMasksOutStreamIndex = -1;

    static {
        System.loadLibrary("mediapipe_tasks_jni");
        POSE_LANDMARKS = PoseLandmarksConnections.POSE_LANDMARKS;
    }

    public static PoseLandmarker createFromFile(Context context, String modelPath) {
        return createFromOptions(context, PoseLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelPath).build()).build());
    }

    public static PoseLandmarker createFromFile(Context context, File modelFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelFile, 268435456);
        try {
            PoseLandmarker poseLandmarkerCreateFromOptions = createFromOptions(context, PoseLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return poseLandmarkerCreateFromOptions;
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

    public static PoseLandmarker createFromBuffer(Context context, final ByteBuffer modelBuffer) {
        return createFromOptions(context, PoseLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelBuffer).build()).build());
    }

    public static PoseLandmarker createFromOptions(Context context, final PoseLandmarkerOptions landmarkerOptions) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("NORM_LANDMARKS:pose_landmarks");
        arrayList.add("WORLD_LANDMARKS:world_landmarks");
        arrayList.add("IMAGE:image_out");
        if (landmarkerOptions.outputSegmentationMasks()) {
            arrayList.add("SEGMENTATION_MASK:segmentation_masks");
            segmentationMasksOutStreamIndex = arrayList.size() - 1;
        }
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<PoseLandmarkerResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public PoseLandmarkerResult convertToTaskResult(List<Packet> packets) {
                if (packets.get(0).isEmpty()) {
                    return PoseLandmarkerResult.create(new ArrayList(), new ArrayList(), Optional.empty(), BaseVisionTaskApi.generateResultTimestampMs(landmarkerOptions.runningMode(), packets.get(0)));
                }
                Optional optionalEmpty = Optional.empty();
                if (landmarkerOptions.outputSegmentationMasks()) {
                    optionalEmpty = PoseLandmarker.getSegmentationMasks(packets);
                }
                return PoseLandmarkerResult.create(PacketGetter.getProtoVector(packets.get(0), LandmarkProto.NormalizedLandmarkList.parser()), PacketGetter.getProtoVector(packets.get(1), LandmarkProto.LandmarkList.parser()), optionalEmpty, BaseVisionTaskApi.generateResultTimestampMs(landmarkerOptions.runningMode(), packets.get(0)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(2))).build();
            }
        });
        Optional<OutputHandler.ResultListener<PoseLandmarkerResult, MPImage>> optionalResultListener = landmarkerOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = landmarkerOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new PoseLandmarker(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(landmarkerOptions.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(arrayList).setTaskOptions(landmarkerOptions).setEnableFlowLimiting(landmarkerOptions.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), landmarkerOptions.runningMode());
    }

    private PoseLandmarker(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
    }

    public PoseLandmarkerResult detect(MPImage image) {
        return detect(image, ImageProcessingOptions.builder().build());
    }

    public PoseLandmarkerResult detect(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (PoseLandmarkerResult) processImageData(image, imageProcessingOptions);
    }

    public PoseLandmarkerResult detectForVideo(MPImage image, long timestampMs) {
        return detectForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public PoseLandmarkerResult detectForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (PoseLandmarkerResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void detectAsync(MPImage image, long timestampMs) {
        detectAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void detectAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static abstract class PoseLandmarkerOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract Optional<ErrorListener> errorListener();

        abstract Optional<Float> minPoseDetectionConfidence();

        abstract Optional<Float> minPosePresenceConfidence();

        abstract Optional<Float> minTrackingConfidence();

        abstract Optional<Integer> numPoses();

        abstract boolean outputSegmentationMasks();

        abstract Optional<OutputHandler.ResultListener<PoseLandmarkerResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        public static abstract class Builder {
            abstract PoseLandmarkerOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setMinPoseDetectionConfidence(Float value);

            public abstract Builder setMinPosePresenceConfidence(Float value);

            public abstract Builder setMinTrackingConfidence(Float value);

            public abstract Builder setNumPoses(Integer value);

            public abstract Builder setOutputSegmentationMasks(boolean value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<PoseLandmarkerResult, MPImage> value);

            public abstract Builder setRunningMode(RunningMode value);

            public final PoseLandmarkerOptions build() {
                PoseLandmarkerOptions poseLandmarkerOptionsAutoBuild = autoBuild();
                if (poseLandmarkerOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!poseLandmarkerOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The pose landmarker is in the live stream mode, a user-defined result listener must be provided in PoseLandmarkerOptions.");
                    }
                } else if (poseLandmarkerOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The pose landmarker is in the image or the video mode, a user-defined result listener shouldn't be provided in PoseLandmarkerOptions.");
                }
                return poseLandmarkerOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            Builder numPoses = new AutoValue_PoseLandmarker_PoseLandmarkerOptions.Builder().setRunningMode(RunningMode.IMAGE).setNumPoses(1);
            Float fValueOf = Float.valueOf(0.5f);
            return numPoses.setMinPoseDetectionConfidence(fValueOf).setMinPosePresenceConfidence(fValueOf).setMinTrackingConfidence(fValueOf).setOutputSegmentationMasks(false);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            final PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptions.Builder baseOptions = PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptions.newBuilder().setBaseOptions((BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder().setUseStreamMode(runningMode() != RunningMode.IMAGE).mergeFrom(convertBaseOptionsToProto(baseOptions())).build());
            final PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.Builder builderNewBuilder = PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.newBuilder();
            Optional<Integer> optionalNumPoses = numPoses();
            Objects.requireNonNull(builderNewBuilder);
            optionalNumPoses.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker$PoseLandmarkerOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setNumPoses(((Integer) obj).intValue());
                }
            });
            Optional<Float> optionalMinPoseDetectionConfidence = minPoseDetectionConfidence();
            Objects.requireNonNull(builderNewBuilder);
            optionalMinPoseDetectionConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker$PoseLandmarkerOptions$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            final PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.Builder builderNewBuilder2 = PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.newBuilder();
            Optional<Float> optionalMinPosePresenceConfidence = minPosePresenceConfidence();
            Objects.requireNonNull(builderNewBuilder2);
            optionalMinPosePresenceConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker$PoseLandmarkerOptions$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinTrackingConfidence = minTrackingConfidence();
            Objects.requireNonNull(baseOptions);
            optionalMinTrackingConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker$PoseLandmarkerOptions$$ExternalSyntheticLambda3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    baseOptions.setMinTrackingConfidence(((Float) obj).floatValue());
                }
            });
            baseOptions.setPoseDetectorGraphOptions((PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions) builderNewBuilder.build()).setPoseLandmarksDetectorGraphOptions((PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions) builderNewBuilder2.build());
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptions.ext, (PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptions) baseOptions.build()).build();
        }
    }

    private static void validateImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        if (imageProcessingOptions.regionOfInterest().isPresent()) {
            throw new IllegalArgumentException("PoseLandmarker doesn't support region-of-interest.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Optional<List<MPImage>> getSegmentationMasks(List<Packet> packets) {
        Optional<List<MPImage>> optionalOf = Optional.of(new ArrayList());
        int imageWidthFromImageList = PacketGetter.getImageWidthFromImageList(packets.get(segmentationMasksOutStreamIndex));
        int imageHeightFromImageList = PacketGetter.getImageHeightFromImageList(packets.get(segmentationMasksOutStreamIndex));
        int imageListSize = PacketGetter.getImageListSize(packets.get(segmentationMasksOutStreamIndex));
        ByteBuffer[] byteBufferArr = new ByteBuffer[imageListSize];
        for (int i = 0; i < imageListSize; i++) {
            byteBufferArr[i] = ByteBuffer.allocateDirect(imageWidthFromImageList * imageHeightFromImageList * 4);
        }
        if (!PacketGetter.getImageList(packets.get(segmentationMasksOutStreamIndex), byteBufferArr, true)) {
            throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), "There is an error getting segmented masks.");
        }
        for (int i2 = 0; i2 < imageListSize; i2++) {
            optionalOf.get().add(new ByteBufferImageBuilder(byteBufferArr[i2], imageWidthFromImageList, imageHeightFromImageList, 10).build());
        }
        return optionalOf;
    }
}
