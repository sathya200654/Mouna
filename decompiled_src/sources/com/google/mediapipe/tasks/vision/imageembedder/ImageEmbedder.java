package com.google.mediapipe.tasks.vision.imageembedder;

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
import com.google.mediapipe.tasks.components.containers.Embedding;
import com.google.mediapipe.tasks.components.containers.EmbeddingResult;
import com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto;
import com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto;
import com.google.mediapipe.tasks.components.utils.CosineSimilarity;
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
import com.google.mediapipe.tasks.vision.imageembedder.proto.ImageEmbedderGraphOptionsProto;
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
public final class ImageEmbedder extends BaseVisionTaskApi {
    private static final int EMBEDDINGS_OUT_STREAM_INDEX = 0;
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final int IMAGE_OUT_STREAM_INDEX = 1;
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String TAG = "ImageEmbedder";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.image_embedder.ImageEmbedderGraph";
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in"));
    private static final List<String> OUTPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("EMBEDDINGS:embeddings_out", "IMAGE:image_out"));

    static {
        System.loadLibrary("mediapipe_tasks_jni");
        ProtoUtil.registerTypeName(EmbeddingsProto.EmbeddingResult.class, "mediapipe.tasks.components.containers.proto.EmbeddingResult");
    }

    public static ImageEmbedder createFromFile(Context context, String modelPath) {
        return createFromOptions(context, ImageEmbedderOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelPath).build()).build());
    }

    public static ImageEmbedder createFromFile(Context context, File modelFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelFile, 268435456);
        try {
            ImageEmbedder imageEmbedderCreateFromOptions = createFromOptions(context, ImageEmbedderOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return imageEmbedderCreateFromOptions;
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

    public static ImageEmbedder createFromBuffer(Context context, final ByteBuffer modelBuffer) {
        return createFromOptions(context, ImageEmbedderOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelBuffer).build()).build());
    }

    public static ImageEmbedder createFromOptions(Context context, final ImageEmbedderOptions options) {
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<ImageEmbedderResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.imageembedder.ImageEmbedder.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public ImageEmbedderResult convertToTaskResult(List<Packet> packets) {
                try {
                    return ImageEmbedderResult.create(EmbeddingResult.createFromProto((EmbeddingsProto.EmbeddingResult) PacketGetter.getProto(packets.get(0), EmbeddingsProto.EmbeddingResult.getDefaultInstance())), BaseVisionTaskApi.generateResultTimestampMs(options.runningMode(), packets.get(0)));
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
        Optional<OutputHandler.ResultListener<ImageEmbedderResult, MPImage>> optionalResultListener = options.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imageembedder.ImageEmbedder$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = options.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imageembedder.ImageEmbedder$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new ImageEmbedder(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(options.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(OUTPUT_STREAMS).setTaskOptions(options).setEnableFlowLimiting(options.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), options.runningMode());
    }

    private ImageEmbedder(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
    }

    public ImageEmbedderResult embed(MPImage image) {
        return embed(image, ImageProcessingOptions.builder().build());
    }

    public ImageEmbedderResult embed(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        return (ImageEmbedderResult) processImageData(image, imageProcessingOptions);
    }

    public ImageEmbedderResult embedForVideo(MPImage image, long timestampMs) {
        return embedForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public ImageEmbedderResult embedForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        return (ImageEmbedderResult) processVideoData(image, imageProcessingOptions, timestampMs);
    }

    public void embedAsync(MPImage image, long timestampMs) {
        embedAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void embedAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        sendLiveStreamData(image, imageProcessingOptions, timestampMs);
    }

    public static double cosineSimilarity(Embedding u, Embedding v) {
        return CosineSimilarity.compute(u, v);
    }

    public static abstract class ImageEmbedderOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract Optional<ErrorListener> errorListener();

        abstract boolean l2Normalize();

        abstract boolean quantize();

        abstract Optional<OutputHandler.ResultListener<ImageEmbedderResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        public static abstract class Builder {
            abstract ImageEmbedderOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions baseOptions);

            public abstract Builder setErrorListener(ErrorListener errorListener);

            public abstract Builder setL2Normalize(boolean l2Normalize);

            public abstract Builder setQuantize(boolean quantize);

            public abstract Builder setResultListener(OutputHandler.ResultListener<ImageEmbedderResult, MPImage> resultListener);

            public abstract Builder setRunningMode(RunningMode runningMode);

            public final ImageEmbedderOptions build() {
                ImageEmbedderOptions imageEmbedderOptionsAutoBuild = autoBuild();
                if (imageEmbedderOptionsAutoBuild.runningMode() == RunningMode.LIVE_STREAM) {
                    if (!imageEmbedderOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The image embedder is in the live stream mode, a user-defined result listener must be provided in the ImageEmbedderOptions.");
                    }
                } else if (imageEmbedderOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The image embedder is in the image or video mode, a user-defined result listener shouldn't be provided in ImageEmbedderOptions.");
                }
                return imageEmbedderOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            return new AutoValue_ImageEmbedder_ImageEmbedderOptions.Builder().setRunningMode(RunningMode.IMAGE).setL2Normalize(false).setQuantize(false);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            BaseOptionsProto.BaseOptions.Builder builderNewBuilder = BaseOptionsProto.BaseOptions.newBuilder();
            builderNewBuilder.setUseStreamMode(runningMode() != RunningMode.IMAGE);
            builderNewBuilder.mergeFrom(convertBaseOptionsToProto(baseOptions()));
            EmbedderOptionsProto.EmbedderOptions.Builder builderNewBuilder2 = EmbedderOptionsProto.EmbedderOptions.newBuilder();
            builderNewBuilder2.setL2Normalize(l2Normalize());
            builderNewBuilder2.setQuantize(quantize());
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(ImageEmbedderGraphOptionsProto.ImageEmbedderGraphOptions.ext, (ImageEmbedderGraphOptionsProto.ImageEmbedderGraphOptions) ImageEmbedderGraphOptionsProto.ImageEmbedderGraphOptions.newBuilder().setBaseOptions(builderNewBuilder).setEmbedderOptions(builderNewBuilder2).build()).build();
        }
    }
}
