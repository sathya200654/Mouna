package com.google.mediapipe.tasks.vision.imageclassifier;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.mediapipe.framework.AndroidPacketGetter;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import com.google.mediapipe.framework.ProtoUtil;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.components.containers.ClassificationResult;
import com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto;
import com.google.mediapipe.tasks.components.processors.proto.ClassifierOptionsProto;
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
import com.google.mediapipe.tasks.vision.imageclassifier.proto.ImageClassifierGraphOptionsProto;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ImageClassifier extends BaseVisionTaskApi {
    private static final int CLASSIFICATIONS_OUT_STREAM_INDEX = 0;
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 1;
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String TAG = "ImageClassifier";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.image_classifier.ImageClassifierGraph";
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in"));
    private static final List<String> OUTPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("CLASSIFICATIONS:classifications_out", "IMAGE:image_out"));

    static {
        System.loadLibrary("mediapipe_tasks_jni");
        ProtoUtil.registerTypeName(ClassificationsProto.ClassificationResult.class, "mediapipe.tasks.components.containers.proto.ClassificationResult");
    }

    public static ImageClassifier createFromFile(Context context, String modelPath) {
        return createFromOptions(context, ImageClassifierOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelPath).build()).build());
    }

    public static ImageClassifier createFromFile(Context context, File modelFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelFile, 268435456);
        try {
            ImageClassifier imageClassifierCreateFromOptions = createFromOptions(context, ImageClassifierOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return imageClassifierCreateFromOptions;
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

    public static ImageClassifier createFromBuffer(Context context, final ByteBuffer modelBuffer) {
        return createFromOptions(context, ImageClassifierOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelBuffer).build()).build());
    }

    public static ImageClassifier createFromOptions(Context context, final ImageClassifierOptions options) {
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<ImageClassifierResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public ImageClassifierResult convertToTaskResult(List<Packet> packets) {
                try {
                    return ImageClassifierResult.create(ClassificationResult.createFromProto((ClassificationsProto.ClassificationResult) PacketGetter.getProto(packets.get(0), ClassificationsProto.ClassificationResult.getDefaultInstance())), BaseVisionTaskApi.generateResultTimestampMs(options.runningMode(), packets.get(0)));
                } catch (IOException e) {
                    throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), e.getMessage());
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(1))).build();
            }
        });
        Optional<OutputHandler.ResultListener<ImageClassifierResult, MPImage>> optionalResultListener = options.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = options.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new ImageClassifier(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(options.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(OUTPUT_STREAMS).setTaskOptions(options).setEnableFlowLimiting(options.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), options.runningMode());
    }

    private ImageClassifier(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
    }

    public ImageClassifierResult classify(MPImage image) {
        return classify(image, ImageProcessingOptions.builder().build());
    }

    public ImageClassifierResult classify(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        return (ImageClassifierResult) processImageData(image, imageProcessingOptions);
    }

    public ImageClassifierResult classifyForVideo(MPImage image, long timestampMs) {
        return classifyForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public ImageClassifierResult classifyForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        return (ImageClassifierResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void classifyAsync(MPImage image, long timestampMs) {
        classifyAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void classifyAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static abstract class ImageClassifierOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract List<String> categoryAllowlist();

        abstract List<String> categoryDenylist();

        abstract Optional<String> displayNamesLocale();

        abstract Optional<ErrorListener> errorListener();

        abstract Optional<Integer> maxResults();

        abstract Optional<OutputHandler.ResultListener<ImageClassifierResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        abstract Optional<Float> scoreThreshold();

        public static abstract class Builder {
            abstract ImageClassifierOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions baseOptions);

            public abstract Builder setCategoryAllowlist(List<String> categoryAllowlist);

            public abstract Builder setCategoryDenylist(List<String> categoryDenylist);

            public abstract Builder setDisplayNamesLocale(String locale);

            public abstract Builder setErrorListener(ErrorListener errorListener);

            public abstract Builder setMaxResults(Integer maxResults);

            public abstract Builder setResultListener(OutputHandler.ResultListener<ImageClassifierResult, MPImage> resultListener);

            public abstract Builder setRunningMode(RunningMode runningMode);

            public abstract Builder setScoreThreshold(Float scoreThreshold);

            public final ImageClassifierOptions build() {
                ImageClassifierOptions imageClassifierOptionsAutoBuild = autoBuild();
                if (imageClassifierOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!imageClassifierOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The image classifier is in the live stream mode, a user-defined result listener must be provided in the ImageClassifierOptions.");
                    }
                } else if (imageClassifierOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The image classifier is in the image or video mode, a user-defined result listener shouldn't be provided in ImageClassifierOptions.");
                }
                if (imageClassifierOptionsAutoBuild.maxResults().isPresent() && imageClassifierOptionsAutoBuild.maxResults().get().intValue() <= 0) {
                    throw new IllegalArgumentException("If specified, maxResults must be > 0.");
                }
                if (imageClassifierOptionsAutoBuild.categoryAllowlist().isEmpty() || imageClassifierOptionsAutoBuild.categoryDenylist().isEmpty()) {
                    return imageClassifierOptionsAutoBuild;
                }
                throw new IllegalArgumentException("Category allowlist and denylist are mutually exclusive.");
            }
        }

        public static Builder builder() {
            return new AutoValue_ImageClassifier_ImageClassifierOptions.Builder().setRunningMode(RunningMode.IMAGE).setCategoryAllowlist(Collections.emptyList()).setCategoryDenylist(Collections.emptyList());
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            BaseOptionsProto.BaseOptions.Builder builderNewBuilder = BaseOptionsProto.BaseOptions.newBuilder();
            builderNewBuilder.setUseStreamMode(runningMode() != RunningMode.IMAGE);
            builderNewBuilder.mergeFrom(convertBaseOptionsToProto(baseOptions()));
            final ClassifierOptionsProto.ClassifierOptions.Builder builderNewBuilder2 = ClassifierOptionsProto.ClassifierOptions.newBuilder();
            Optional<String> optionalDisplayNamesLocale = displayNamesLocale();
            Objects.requireNonNull(builderNewBuilder2);
            optionalDisplayNamesLocale.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier$ImageClassifierOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setDisplayNamesLocale((String) obj);
                }
            });
            Optional<Integer> optionalMaxResults = maxResults();
            Objects.requireNonNull(builderNewBuilder2);
            optionalMaxResults.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier$ImageClassifierOptions$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setMaxResults(((Integer) obj).intValue());
                }
            });
            Optional<Float> optionalScoreThreshold = scoreThreshold();
            Objects.requireNonNull(builderNewBuilder2);
            optionalScoreThreshold.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imageclassifier.ImageClassifier$ImageClassifierOptions$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setScoreThreshold(((Float) obj).floatValue());
                }
            });
            if (!categoryAllowlist().isEmpty()) {
                builderNewBuilder2.addAllCategoryAllowlist(categoryAllowlist());
            }
            if (!categoryDenylist().isEmpty()) {
                builderNewBuilder2.addAllCategoryDenylist(categoryDenylist());
            }
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(ImageClassifierGraphOptionsProto.ImageClassifierGraphOptions.ext, (ImageClassifierGraphOptionsProto.ImageClassifierGraphOptions) ImageClassifierGraphOptionsProto.ImageClassifierGraphOptions.newBuilder().setBaseOptions(builderNewBuilder).setClassifierOptions(builderNewBuilder2).build()).build();
        }
    }
}
