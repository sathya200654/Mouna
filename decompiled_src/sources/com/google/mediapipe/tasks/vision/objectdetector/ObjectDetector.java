package com.google.mediapipe.tasks.vision.objectdetector;

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
import com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto;
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
public final class ObjectDetector extends BaseVisionTaskApi {
    private static final int DETECTIONS_OUT_STREAM_INDEX = 0;
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 1;
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String TAG = "ObjectDetector";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.ObjectDetectorGraph";
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in"));
    private static final List<String> OUTPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("DETECTIONS:detections_out", "IMAGE:image_out"));

    static {
        System.loadLibrary("mediapipe_tasks_jni");
    }

    public static ObjectDetector createFromFile(Context context, String modelPath) {
        return createFromOptions(context, ObjectDetectorOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelPath).build()).build());
    }

    public static ObjectDetector createFromFile(Context context, File modelFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelFile, 268435456);
        try {
            ObjectDetector objectDetectorCreateFromOptions = createFromOptions(context, ObjectDetectorOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return objectDetectorCreateFromOptions;
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

    public static ObjectDetector createFromBuffer(Context context, final ByteBuffer modelBuffer) {
        return createFromOptions(context, ObjectDetectorOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelBuffer).build()).build());
    }

    public static ObjectDetector createFromOptions(Context context, final ObjectDetectorOptions detectorOptions) {
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<ObjectDetectorResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public ObjectDetectorResult convertToTaskResult(List<Packet> packets) {
                if (packets.get(0).isEmpty()) {
                    return ObjectDetectorResult.create((List<DetectionProto.Detection>) new ArrayList(), BaseVisionTaskApi.generateResultTimestampMs(detectorOptions.runningMode(), packets.get(0)));
                }
                return ObjectDetectorResult.create((List<DetectionProto.Detection>) PacketGetter.getProtoVector(packets.get(0), DetectionProto.Detection.parser()), BaseVisionTaskApi.generateResultTimestampMs(detectorOptions.runningMode(), packets.get(0)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(1))).build();
            }
        });
        Optional<OutputHandler.ResultListener<ObjectDetectorResult, MPImage>> optionalResultListener = detectorOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = detectorOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new ObjectDetector(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(detectorOptions.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(OUTPUT_STREAMS).setTaskOptions(detectorOptions).setEnableFlowLimiting(detectorOptions.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), detectorOptions.runningMode());
    }

    private ObjectDetector(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
    }

    public ObjectDetectorResult detect(MPImage image) {
        return detect(image, ImageProcessingOptions.builder().build());
    }

    public ObjectDetectorResult detect(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (ObjectDetectorResult) processImageData(image, imageProcessingOptions);
    }

    public ObjectDetectorResult detectForVideo(MPImage image, long timestampMs) {
        return detectForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public ObjectDetectorResult detectForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        return (ObjectDetectorResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void detectAsync(MPImage image, long timestampMs) {
        detectAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void detectAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        validateImageProcessingOptions(imageProcessingOptions);
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static abstract class ObjectDetectorOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract List<String> categoryAllowlist();

        abstract List<String> categoryDenylist();

        abstract Optional<String> displayNamesLocale();

        abstract Optional<ErrorListener> errorListener();

        abstract Optional<Integer> maxResults();

        abstract Optional<OutputHandler.ResultListener<ObjectDetectorResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        abstract Optional<Float> scoreThreshold();

        public static abstract class Builder {
            abstract ObjectDetectorOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setCategoryAllowlist(List<String> value);

            public abstract Builder setCategoryDenylist(List<String> value);

            public abstract Builder setDisplayNamesLocale(String value);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setMaxResults(Integer value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<ObjectDetectorResult, MPImage> value);

            public abstract Builder setRunningMode(RunningMode value);

            public abstract Builder setScoreThreshold(Float value);

            public final ObjectDetectorOptions build() {
                ObjectDetectorOptions objectDetectorOptionsAutoBuild = autoBuild();
                if (objectDetectorOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!objectDetectorOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The object detector is in the live stream mode, a user-defined result listener must be provided in ObjectDetectorOptions.");
                    }
                } else if (objectDetectorOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The object detector is in the image or the video mode, a user-defined result listener shouldn't be provided in ObjectDetectorOptions.");
                }
                return objectDetectorOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            return new AutoValue_ObjectDetector_ObjectDetectorOptions.Builder().setRunningMode(RunningMode.IMAGE).setCategoryAllowlist(Collections.emptyList()).setCategoryDenylist(Collections.emptyList());
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            BaseOptionsProto.BaseOptions.Builder builderNewBuilder = BaseOptionsProto.BaseOptions.newBuilder();
            builderNewBuilder.setUseStreamMode(runningMode() != RunningMode.IMAGE);
            builderNewBuilder.mergeFrom(convertBaseOptionsToProto(baseOptions()));
            final ObjectDetectorOptionsProto.ObjectDetectorOptions.Builder baseOptions = ObjectDetectorOptionsProto.ObjectDetectorOptions.newBuilder().setBaseOptions(builderNewBuilder);
            Optional<String> optionalDisplayNamesLocale = displayNamesLocale();
            Objects.requireNonNull(baseOptions);
            optionalDisplayNamesLocale.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector$ObjectDetectorOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    baseOptions.setDisplayNamesLocale((String) obj);
                }
            });
            Optional<Integer> optionalMaxResults = maxResults();
            Objects.requireNonNull(baseOptions);
            optionalMaxResults.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector$ObjectDetectorOptions$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    baseOptions.setMaxResults(((Integer) obj).intValue());
                }
            });
            Optional<Float> optionalScoreThreshold = scoreThreshold();
            Objects.requireNonNull(baseOptions);
            optionalScoreThreshold.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.objectdetector.ObjectDetector$ObjectDetectorOptions$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    baseOptions.setScoreThreshold(((Float) obj).floatValue());
                }
            });
            if (!categoryAllowlist().isEmpty()) {
                baseOptions.addAllCategoryAllowlist(categoryAllowlist());
            }
            if (!categoryDenylist().isEmpty()) {
                baseOptions.addAllCategoryDenylist(categoryDenylist());
            }
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(ObjectDetectorOptionsProto.ObjectDetectorOptions.ext, (ObjectDetectorOptionsProto.ObjectDetectorOptions) baseOptions.build()).build();
        }
    }

    private static void validateImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        if (imageProcessingOptions.regionOfInterest().isPresent()) {
            throw new IllegalArgumentException("ObjectDetector doesn't support region-of-interest.");
        }
    }
}
