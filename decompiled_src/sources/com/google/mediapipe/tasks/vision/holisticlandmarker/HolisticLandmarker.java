package com.google.mediapipe.tasks.vision.holisticlandmarker;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.mediapipe.formats.proto.ClassificationProto;
import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.framework.AndroidPacketGetter;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.framework.image.ByteBufferImageBuilder;
import com.google.mediapipe.framework.image.MPImage;
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
import com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarksDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto;
import com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarksDetectorGraphOptionsProto;
import com.google.protobuf.Any;
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
public final class HolisticLandmarker extends BaseVisionTaskApi {
    private static final boolean DEFAULT_OUTPUT_FACE_BLENDSHAPES = false;
    private static final boolean DEFAULT_OUTPUT_SEGMENTATION_MASKS = false;
    private static final float DEFAULT_PRESENCE_THRESHOLD = 0.5f;
    private static final float DEFAULT_SUPPRESION_THRESHOLD = 0.3f;
    private static final String FACE_BLENDSHAPES_STREAM = "extra_blendshapes";
    private static final int FACE_LANDMARKS_OUT_STREAM_INDEX = 0;
    private static final String FACE_LANDMARKS_STREAM = "face_landmarks";
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 7;
    private static final String IMAGE_OUT_STREAM_NAME = "image_out";
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in"));
    private static final int LEFT_HAND_LANDMARKS_OUT_STREAM_INDEX = 3;
    private static final String LEFT_HAND_LANDMARKS_STREAM = "left_hand_landmarks";
    private static final int LEFT_HAND_WORLD_LANDMARKS_OUT_STREAM_INDEX = 4;
    private static final String LEFT_HAND_WORLD_LANDMARKS_STREAM = "left_hand_world_landmarks";
    private static final int POSE_LANDMARKS_OUT_STREAM_INDEX = 1;
    private static final String POSE_LANDMARKS_STREAM = "pose_landmarks";
    private static final String POSE_SEGMENTATION_MASK_STREAM = "pose_segmentation_mask";
    private static final int POSE_WORLD_LANDMARKS_OUT_STREAM_INDEX = 2;
    private static final String POSE_WORLD_LANDMARKS_STREAM = "pose_world_landmarks";
    private static final int RIGHT_HAND_LANDMARKS_OUT_STREAM_INDEX = 5;
    private static final String RIGHT_HAND_LANDMARKS_STREAM = "right_hand_landmarks";
    private static final int RIGHT_HAND_WORLD_LANDMARKS_OUT_STREAM_INDEX = 6;
    private static final String RIGHT_HAND_WORLD_LANDMARKS_STREAM = "right_hand_world_landmarks";
    private static final String TAG = "HolisticLandmarker";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.holistic_landmarker.HolisticLandmarkerGraph";

    static {
        System.loadLibrary("mediapipe_tasks_jni");
    }

    public static HolisticLandmarker createFromFile(Context context, String modelAssetPath) {
        return createFromOptions(context, HolisticLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelAssetPath).build()).build());
    }

    public static HolisticLandmarker createFromFile(Context context, File modelAssetFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelAssetFile, 268435456);
        try {
            HolisticLandmarker holisticLandmarkerCreateFromOptions = createFromOptions(context, HolisticLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return holisticLandmarkerCreateFromOptions;
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

    public static HolisticLandmarker createFromBuffer(Context context, final ByteBuffer modelAssetBuffer) {
        return createFromOptions(context, HolisticLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelAssetBuffer).build()).build());
    }

    public static HolisticLandmarker createFromOptions(Context context, final HolisticLandmarkerOptions landmarkerOptions) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("FACE_LANDMARKS:face_landmarks");
        arrayList.add("POSE_LANDMARKS:pose_landmarks");
        arrayList.add("POSE_WORLD_LANDMARKS:pose_world_landmarks");
        arrayList.add("LEFT_HAND_LANDMARKS:left_hand_landmarks");
        arrayList.add("LEFT_HAND_WORLD_LANDMARKS:left_hand_world_landmarks");
        arrayList.add("RIGHT_HAND_LANDMARKS:right_hand_landmarks");
        arrayList.add("RIGHT_HAND_WORLD_LANDMARKS:right_hand_world_landmarks");
        arrayList.add("IMAGE:image_out");
        final int[] iArr = {-1};
        if (landmarkerOptions.outputFaceBlendshapes()) {
            arrayList.add("FACE_BLENDSHAPES:extra_blendshapes");
            iArr[0] = arrayList.size() - 1;
        }
        final int[] iArr2 = {-1};
        if (landmarkerOptions.outputPoseSegmentationMasks()) {
            arrayList.add("POSE_SEGMENTATION_MASK:pose_segmentation_mask");
            iArr2[0] = arrayList.size() - 1;
        }
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<HolisticLandmarkerResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public HolisticLandmarkerResult convertToTaskResult(List<Packet> packets) {
                Optional optionalEmpty;
                Optional optionalEmpty2;
                LandmarkProto.NormalizedLandmarkList normalizedLandmarkList = HolisticLandmarker.getNormalizedLandmarkList(packets.get(0));
                if (landmarkerOptions.outputFaceBlendshapes()) {
                    optionalEmpty = Optional.of((ClassificationProto.ClassificationList) PacketGetter.getProto(packets.get(iArr[0]), ClassificationProto.ClassificationList.parser()));
                } else {
                    optionalEmpty = Optional.empty();
                }
                Optional optional = optionalEmpty;
                LandmarkProto.NormalizedLandmarkList normalizedLandmarkList2 = HolisticLandmarker.getNormalizedLandmarkList(packets.get(1));
                LandmarkProto.LandmarkList landmarkList = HolisticLandmarker.getLandmarkList(packets.get(2));
                if (landmarkerOptions.outputPoseSegmentationMasks()) {
                    optionalEmpty2 = Optional.of(HolisticLandmarker.getSegmentationMask(packets, iArr2[0]));
                } else {
                    optionalEmpty2 = Optional.empty();
                }
                return HolisticLandmarkerResult.create(normalizedLandmarkList, optional, normalizedLandmarkList2, landmarkList, optionalEmpty2, HolisticLandmarker.getNormalizedLandmarkList(packets.get(3)), HolisticLandmarker.getLandmarkList(packets.get(4)), HolisticLandmarker.getNormalizedLandmarkList(packets.get(5)), HolisticLandmarker.getLandmarkList(packets.get(6)), BaseVisionTaskApi.generateResultTimestampMs(landmarkerOptions.runningMode(), packets.get(0)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(7))).build();
            }
        });
        Optional<OutputHandler.ResultListener<HolisticLandmarkerResult, MPImage>> optionalResultListener = landmarkerOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = landmarkerOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new HolisticLandmarker(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(landmarkerOptions.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(arrayList).setTaskOptions(landmarkerOptions).setEnableFlowLimiting(landmarkerOptions.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), landmarkerOptions.runningMode());
    }

    private HolisticLandmarker(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, "");
    }

    public HolisticLandmarkerResult detect(MPImage image) {
        return detect(image, ImageProcessingOptions.builder().build());
    }

    public HolisticLandmarkerResult detect(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (HolisticLandmarkerResult) processImageData(image, imageProcessingOptions);
    }

    public HolisticLandmarkerResult detectForVideo(MPImage image, long timestampMs) {
        return detectForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public HolisticLandmarkerResult detectForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (HolisticLandmarkerResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void detectAsync(MPImage image, long timestampMs) {
        detectAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void detectAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static abstract class HolisticLandmarkerOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract Optional<ErrorListener> errorListener();

        abstract Optional<Float> minFaceDetectionConfidence();

        abstract Optional<Float> minFacePresenceConfidence();

        abstract Optional<Float> minFaceSuppressionThreshold();

        abstract Optional<Float> minHandLandmarksConfidence();

        abstract Optional<Float> minPoseDetectionConfidence();

        abstract Optional<Float> minPosePresenceConfidence();

        abstract Optional<Float> minPoseSuppressionThreshold();

        abstract boolean outputFaceBlendshapes();

        abstract boolean outputPoseSegmentationMasks();

        abstract Optional<OutputHandler.ResultListener<HolisticLandmarkerResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        public static abstract class Builder {
            abstract HolisticLandmarkerOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setMinFaceDetectionConfidence(Float value);

            public abstract Builder setMinFacePresenceConfidence(Float value);

            public abstract Builder setMinFaceSuppressionThreshold(Float value);

            public abstract Builder setMinHandLandmarksConfidence(Float value);

            public abstract Builder setMinPoseDetectionConfidence(Float value);

            public abstract Builder setMinPosePresenceConfidence(Float value);

            public abstract Builder setMinPoseSuppressionThreshold(Float value);

            public abstract Builder setOutputFaceBlendshapes(boolean value);

            public abstract Builder setOutputPoseSegmentationMasks(boolean value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<HolisticLandmarkerResult, MPImage> value);

            public abstract Builder setRunningMode(RunningMode value);

            public final HolisticLandmarkerOptions build() {
                HolisticLandmarkerOptions holisticLandmarkerOptionsAutoBuild = autoBuild();
                if (holisticLandmarkerOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!holisticLandmarkerOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The holistic landmarker is in the live stream mode, a user-defined result listener must be provided in HolisticLandmarkerOptions.");
                    }
                } else if (holisticLandmarkerOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The holistic landmarker is in the image or the video mode, a user-defined result listener shouldn't be provided in HolisticLandmarkerOptions.");
                }
                return holisticLandmarkerOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            Builder runningMode = new AutoValue_HolisticLandmarker_HolisticLandmarkerOptions.Builder().setRunningMode(RunningMode.IMAGE);
            Float fValueOf = Float.valueOf(0.5f);
            Builder minFaceDetectionConfidence = runningMode.setMinFaceDetectionConfidence(fValueOf);
            Float fValueOf2 = Float.valueOf(0.3f);
            return minFaceDetectionConfidence.setMinFaceSuppressionThreshold(fValueOf2).setMinFacePresenceConfidence(fValueOf).setMinPoseDetectionConfidence(fValueOf).setMinPoseSuppressionThreshold(fValueOf2).setMinPosePresenceConfidence(fValueOf).setMinHandLandmarksConfidence(fValueOf).setOutputFaceBlendshapes(false).setOutputPoseSegmentationMasks(false);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public Any convertToAnyProto() {
            HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptions.Builder baseOptions = HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptions.newBuilder().setBaseOptions((BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder().setUseStreamMode(runningMode() != RunningMode.IMAGE).mergeFrom(convertBaseOptionsToProto(baseOptions())).build());
            final HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.Builder builderNewBuilder = HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.newBuilder();
            final FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.Builder builderNewBuilder2 = FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.newBuilder();
            final FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.Builder builderNewBuilder3 = FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.newBuilder();
            final PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.Builder builderNewBuilder4 = PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.newBuilder();
            final PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.Builder builderNewBuilder5 = PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.newBuilder();
            Optional<Float> optionalMinHandLandmarksConfidence = minHandLandmarksConfidence();
            Objects.requireNonNull(builderNewBuilder);
            optionalMinHandLandmarksConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$HolisticLandmarkerOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinPoseDetectionConfidence = minPoseDetectionConfidence();
            Objects.requireNonNull(builderNewBuilder4);
            optionalMinPoseDetectionConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$HolisticLandmarkerOptions$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder4.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinPoseSuppressionThreshold = minPoseSuppressionThreshold();
            Objects.requireNonNull(builderNewBuilder4);
            optionalMinPoseSuppressionThreshold.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$HolisticLandmarkerOptions$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder4.setMinSuppressionThreshold(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinPosePresenceConfidence = minPosePresenceConfidence();
            Objects.requireNonNull(builderNewBuilder5);
            optionalMinPosePresenceConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$HolisticLandmarkerOptions$$ExternalSyntheticLambda3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder5.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinFaceDetectionConfidence = minFaceDetectionConfidence();
            Objects.requireNonNull(builderNewBuilder2);
            optionalMinFaceDetectionConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$HolisticLandmarkerOptions$$ExternalSyntheticLambda4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinFaceSuppressionThreshold = minFaceSuppressionThreshold();
            Objects.requireNonNull(builderNewBuilder2);
            optionalMinFaceSuppressionThreshold.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$HolisticLandmarkerOptions$$ExternalSyntheticLambda5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setMinSuppressionThreshold(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinFacePresenceConfidence = minFacePresenceConfidence();
            Objects.requireNonNull(builderNewBuilder3);
            optionalMinFacePresenceConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarker$HolisticLandmarkerOptions$$ExternalSyntheticLambda6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder3.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            baseOptions.setHandLandmarksDetectorGraphOptions((HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions) builderNewBuilder.build()).setFaceDetectorGraphOptions((FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions) builderNewBuilder2.build()).setFaceLandmarksDetectorGraphOptions((FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions) builderNewBuilder3.build()).setPoseDetectorGraphOptions((PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions) builderNewBuilder4.build()).setPoseLandmarksDetectorGraphOptions((PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions) builderNewBuilder5.build());
            return Any.newBuilder().setTypeUrl("type.googleapis.com/mediapipe.tasks.vision.holistic_landmarker.proto.HolisticLandmarkerGraphOptions").setValue(((HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptions) baseOptions.build()).toByteString()).build();
        }
    }

    private static void validateImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        if (imageProcessingOptions.regionOfInterest().isPresent()) {
            throw new IllegalArgumentException("HolisticLandmarker doesn't support region-of-interest.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MPImage getSegmentationMask(List<Packet> packets, int packetIndex) {
        int imageWidth = PacketGetter.getImageWidth(packets.get(packetIndex));
        int imageHeight = PacketGetter.getImageHeight(packets.get(packetIndex));
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(imageWidth * imageHeight * 4);
        if (!PacketGetter.getImageData(packets.get(packetIndex), byteBufferAllocateDirect)) {
            throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), "There was an error getting the sefmentation mask.");
        }
        return new ByteBufferImageBuilder(byteBufferAllocateDirect, imageWidth, imageHeight, 10).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LandmarkProto.NormalizedLandmarkList getNormalizedLandmarkList(Packet packet) {
        if (packet.isEmpty()) {
            return LandmarkProto.NormalizedLandmarkList.getDefaultInstance();
        }
        return (LandmarkProto.NormalizedLandmarkList) PacketGetter.getProto(packet, LandmarkProto.NormalizedLandmarkList.parser());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LandmarkProto.LandmarkList getLandmarkList(Packet packet) {
        if (packet.isEmpty()) {
            return LandmarkProto.LandmarkList.getDefaultInstance();
        }
        return (LandmarkProto.LandmarkList) PacketGetter.getProto(packet, LandmarkProto.LandmarkList.parser());
    }
}
