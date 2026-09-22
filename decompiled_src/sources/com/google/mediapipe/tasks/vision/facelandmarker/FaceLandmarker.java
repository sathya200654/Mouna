package com.google.mediapipe.tasks.vision.facelandmarker;

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
import com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto;
import com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto;
import com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FaceLandmarker extends BaseVisionTaskApi {
    public static final Set<Connection> FACE_LANDMARKS_CONNECTORS;
    public static final Set<Connection> FACE_LANDMARKS_FACE_OVAL;
    public static final Set<Connection> FACE_LANDMARKS_LEFT_EYE;
    public static final Set<Connection> FACE_LANDMARKS_LEFT_EYE_BROW;
    public static final Set<Connection> FACE_LANDMARKS_LEFT_IRIS;
    public static final Set<Connection> FACE_LANDMARKS_LIPS;
    public static final Set<Connection> FACE_LANDMARKS_RIGHT_EYE;
    public static final Set<Connection> FACE_LANDMARKS_RIGHT_EYE_BROW;
    public static final Set<Connection> FACE_LANDMARKS_RIGHT_IRIS;
    public static final Set<Connection> FACE_LANDMARKS_TESSELATION;
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 1;
    private static final int LANDMARKS_OUT_STREAM_INDEX = 0;
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String TAG = "FaceLandmarker";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.face_landmarker.FaceLandmarkerGraph";
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in"));
    private static int blendshapesOutStreamIndex = -1;
    private static int faceGeometryOutStreamIndex = -1;

    static {
        System.loadLibrary("mediapipe_tasks_jni");
        FACE_LANDMARKS_LIPS = FaceLandmarksConnections.FACE_LANDMARKS_LIPS;
        FACE_LANDMARKS_LEFT_EYE = FaceLandmarksConnections.FACE_LANDMARKS_LEFT_EYE;
        FACE_LANDMARKS_LEFT_EYE_BROW = FaceLandmarksConnections.FACE_LANDMARKS_LEFT_EYE_BROW;
        FACE_LANDMARKS_LEFT_IRIS = FaceLandmarksConnections.FACE_LANDMARKS_LEFT_IRIS;
        FACE_LANDMARKS_RIGHT_EYE = FaceLandmarksConnections.FACE_LANDMARKS_RIGHT_EYE;
        FACE_LANDMARKS_RIGHT_EYE_BROW = FaceLandmarksConnections.FACE_LANDMARKS_RIGHT_EYE_BROW;
        FACE_LANDMARKS_RIGHT_IRIS = FaceLandmarksConnections.FACE_LANDMARKS_RIGHT_IRIS;
        FACE_LANDMARKS_FACE_OVAL = FaceLandmarksConnections.FACE_LANDMARKS_FACE_OVAL;
        FACE_LANDMARKS_CONNECTORS = FaceLandmarksConnections.FACE_LANDMARKS_CONNECTORS;
        FACE_LANDMARKS_TESSELATION = FaceLandmarksConnections.FACE_LANDMARKS_TESSELATION;
    }

    public static FaceLandmarker createFromFile(Context context, String modelAssetPath) {
        return createFromOptions(context, FaceLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelAssetPath).build()).build());
    }

    public static FaceLandmarker createFromFile(Context context, File modelAssetFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelAssetFile, 268435456);
        try {
            FaceLandmarker faceLandmarkerCreateFromOptions = createFromOptions(context, FaceLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return faceLandmarkerCreateFromOptions;
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

    public static FaceLandmarker createFromBuffer(Context context, final ByteBuffer modelAssetBuffer) {
        return createFromOptions(context, FaceLandmarkerOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelAssetBuffer).build()).build());
    }

    public static FaceLandmarker createFromOptions(Context context, final FaceLandmarkerOptions landmarkerOptions) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("NORM_LANDMARKS:face_landmarks");
        arrayList.add("IMAGE:image_out");
        if (landmarkerOptions.outputFaceBlendshapes()) {
            arrayList.add("BLENDSHAPES:face_blendshapes");
            blendshapesOutStreamIndex = arrayList.size() - 1;
        }
        if (landmarkerOptions.outputFacialTransformationMatrixes()) {
            arrayList.add("FACE_GEOMETRY:face_geometry");
            faceGeometryOutStreamIndex = arrayList.size() - 1;
        }
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<FaceLandmarkerResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.facelandmarker.FaceLandmarker.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public FaceLandmarkerResult convertToTaskResult(List<Packet> packets) {
                if (packets.get(0).isEmpty()) {
                    return FaceLandmarkerResult.create(new ArrayList(), Optional.empty(), Optional.empty(), BaseVisionTaskApi.generateResultTimestampMs(landmarkerOptions.runningMode(), packets.get(0)));
                }
                Optional optionalEmpty = Optional.empty();
                if (landmarkerOptions.outputFaceBlendshapes()) {
                    optionalEmpty = Optional.of(PacketGetter.getProtoVector(packets.get(FaceLandmarker.blendshapesOutStreamIndex), ClassificationProto.ClassificationList.parser()));
                }
                Optional optionalEmpty2 = Optional.empty();
                if (landmarkerOptions.outputFacialTransformationMatrixes()) {
                    List protoVector = PacketGetter.getProtoVector(packets.get(FaceLandmarker.faceGeometryOutStreamIndex), FaceGeometryProto.FaceGeometry.parser());
                    Optional optionalOf = Optional.of(new ArrayList());
                    Iterator it = protoVector.iterator();
                    while (it.hasNext()) {
                        ((List) optionalOf.get()).add(((FaceGeometryProto.FaceGeometry) it.next()).getPoseTransformMatrix());
                    }
                    optionalEmpty2 = optionalOf;
                }
                return FaceLandmarkerResult.create(PacketGetter.getProtoVector(packets.get(0), LandmarkProto.NormalizedLandmarkList.parser()), optionalEmpty, optionalEmpty2, BaseVisionTaskApi.generateResultTimestampMs(landmarkerOptions.runningMode(), packets.get(0)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(1))).build();
            }
        });
        Optional<OutputHandler.ResultListener<FaceLandmarkerResult, MPImage>> optionalResultListener = landmarkerOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.facelandmarker.FaceLandmarker$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = landmarkerOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.facelandmarker.FaceLandmarker$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new FaceLandmarker(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(landmarkerOptions.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(arrayList).setTaskOptions(landmarkerOptions).setEnableFlowLimiting(landmarkerOptions.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), landmarkerOptions.runningMode());
    }

    private FaceLandmarker(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
    }

    public FaceLandmarkerResult detect(MPImage image) {
        return detect(image, ImageProcessingOptions.builder().build());
    }

    public FaceLandmarkerResult detect(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (FaceLandmarkerResult) processImageData(image, imageProcessingOptions);
    }

    public FaceLandmarkerResult detectForVideo(MPImage image, long timestampMs) {
        return detectForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public FaceLandmarkerResult detectForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (FaceLandmarkerResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void detectAsync(MPImage image, long timestampMs) {
        detectAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void detectAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static abstract class FaceLandmarkerOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract Optional<ErrorListener> errorListener();

        abstract Optional<Float> minFaceDetectionConfidence();

        abstract Optional<Float> minFacePresenceConfidence();

        abstract Optional<Float> minTrackingConfidence();

        abstract Optional<Integer> numFaces();

        abstract boolean outputFaceBlendshapes();

        abstract boolean outputFacialTransformationMatrixes();

        abstract Optional<OutputHandler.ResultListener<FaceLandmarkerResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        public static abstract class Builder {
            abstract FaceLandmarkerOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setMinFaceDetectionConfidence(Float value);

            public abstract Builder setMinFacePresenceConfidence(Float value);

            public abstract Builder setMinTrackingConfidence(Float value);

            public abstract Builder setNumFaces(Integer value);

            public abstract Builder setOutputFaceBlendshapes(boolean value);

            public abstract Builder setOutputFacialTransformationMatrixes(boolean value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<FaceLandmarkerResult, MPImage> value);

            public abstract Builder setRunningMode(RunningMode value);

            public final FaceLandmarkerOptions build() {
                FaceLandmarkerOptions faceLandmarkerOptionsAutoBuild = autoBuild();
                if (faceLandmarkerOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!faceLandmarkerOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The face landmarker is in the live stream mode, a user-defined result listener must be provided in FaceLandmarkerOptions.");
                    }
                } else if (faceLandmarkerOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The face landmarker is in the image or the video mode, a user-defined result listener shouldn't be provided in FaceLandmarkerOptions.");
                }
                return faceLandmarkerOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            Builder numFaces = new AutoValue_FaceLandmarker_FaceLandmarkerOptions.Builder().setRunningMode(RunningMode.IMAGE).setNumFaces(1);
            Float fValueOf = Float.valueOf(0.5f);
            return numFaces.setMinFaceDetectionConfidence(fValueOf).setMinFacePresenceConfidence(fValueOf).setMinTrackingConfidence(fValueOf).setOutputFaceBlendshapes(false).setOutputFacialTransformationMatrixes(false);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            final FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions.Builder baseOptions = FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions.newBuilder().setBaseOptions((BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder().setUseStreamMode(runningMode() != RunningMode.IMAGE).mergeFrom(convertBaseOptionsToProto(baseOptions())).build());
            final FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.Builder builderNewBuilder = FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.newBuilder();
            Optional<Integer> optionalNumFaces = numFaces();
            Objects.requireNonNull(builderNewBuilder);
            optionalNumFaces.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.facelandmarker.FaceLandmarker$FaceLandmarkerOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setNumFaces(((Integer) obj).intValue());
                }
            });
            Optional<Float> optionalMinFaceDetectionConfidence = minFaceDetectionConfidence();
            Objects.requireNonNull(builderNewBuilder);
            optionalMinFaceDetectionConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.facelandmarker.FaceLandmarker$FaceLandmarkerOptions$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            final FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.Builder builderNewBuilder2 = FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.newBuilder();
            Optional<Float> optionalMinFacePresenceConfidence = minFacePresenceConfidence();
            Objects.requireNonNull(builderNewBuilder2);
            optionalMinFacePresenceConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.facelandmarker.FaceLandmarker$FaceLandmarkerOptions$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setMinDetectionConfidence(((Float) obj).floatValue());
                }
            });
            Optional<Float> optionalMinTrackingConfidence = minTrackingConfidence();
            Objects.requireNonNull(baseOptions);
            optionalMinTrackingConfidence.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.facelandmarker.FaceLandmarker$FaceLandmarkerOptions$$ExternalSyntheticLambda3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    baseOptions.setMinTrackingConfidence(((Float) obj).floatValue());
                }
            });
            baseOptions.setFaceDetectorGraphOptions((FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions) builderNewBuilder.build()).setFaceLandmarksDetectorGraphOptions((FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions) builderNewBuilder2.build());
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions.ext, (FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions) baseOptions.build()).build();
        }
    }

    private static void validateImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        if (imageProcessingOptions.regionOfInterest().isPresent()) {
            throw new IllegalArgumentException("FaceLandmarker doesn't support region-of-interest.");
        }
    }
}
