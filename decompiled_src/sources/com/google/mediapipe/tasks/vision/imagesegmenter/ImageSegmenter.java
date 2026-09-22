package com.google.mediapipe.tasks.vision.imagesegmenter;

import android.content.Context;
import com.google.mediapipe.framework.AndroidPacketGetter;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.framework.image.ByteBufferImageBuilder;
import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.proto.CalculatorProto;
import com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto;
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
import com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto;
import com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ImageSegmenter extends BaseVisionTaskApi {
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "NORM_RECT:norm_rect_in", "OUTPUT_SIZE:output_size_in"));
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String OUTPUT_SIZE_IN_STREAM_NAME = "output_size_in";
    private static final String TAG = "ImageSegmenter";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.image_segmenter.ImageSegmenterGraph";
    private static final String TENSORS_TO_SEGMENTATION_CALCULATOR_NAME = "mediapipe.tasks.TensorsToSegmentationCalculator";
    private boolean hasResultListener;
    private List<String> labels;

    static {
        System.loadLibrary("mediapipe_tasks_jni");
    }

    public static ImageSegmenter createFromOptions(Context context, final ImageSegmenterOptions segmenterOptions) {
        if (!segmenterOptions.outputConfidenceMasks() && !segmenterOptions.outputCategoryMask()) {
            throw new IllegalArgumentException("At least one of `outputConfidenceMasks` and `outputCategoryMask` must be set.");
        }
        ArrayList arrayList = new ArrayList();
        BiFunction biFunction = new BiFunction() { // from class: com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ImageSegmenter.lambda$createFromOptions$0((List) obj, (String) obj2);
            }
        };
        final int iIntValue = segmenterOptions.outputConfidenceMasks() ? ((Integer) biFunction.apply(arrayList, "CONFIDENCE_MASKS:confidence_masks")).intValue() : -1;
        final int iIntValue2 = segmenterOptions.outputCategoryMask() ? ((Integer) biFunction.apply(arrayList, "CATEGORY_MASK:category_mask")).intValue() : -1;
        final int iIntValue3 = ((Integer) biFunction.apply(arrayList, "QUALITY_SCORES:quality_scores")).intValue();
        final int iIntValue4 = ((Integer) biFunction.apply(arrayList, "IMAGE:image_out")).intValue();
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<ImageSegmenterResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ MPImage convertToTaskInput(List packets) {
                return convertToTaskInput((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public ImageSegmenterResult convertToTaskResult(List<Packet> packets) throws MediaPipeException {
                ByteBuffer imageDataDirectly;
                if (packets.get(iIntValue4).isEmpty()) {
                    return ImageSegmenterResult.create(Optional.empty(), Optional.empty(), new ArrayList(), packets.get(iIntValue4).getTimestamp());
                }
                boolean zIsPresent = segmenterOptions.resultListener().isPresent();
                boolean z = !zIsPresent;
                Optional optionalEmpty = Optional.empty();
                if (segmenterOptions.outputConfidenceMasks()) {
                    int imageWidthFromImageList = PacketGetter.getImageWidthFromImageList(packets.get(iIntValue));
                    int imageHeightFromImageList = PacketGetter.getImageHeightFromImageList(packets.get(iIntValue));
                    Optional optionalOf = Optional.of(new ArrayList());
                    int imageListSize = PacketGetter.getImageListSize(packets.get(iIntValue));
                    ByteBuffer[] byteBufferArr = new ByteBuffer[imageListSize];
                    if (!zIsPresent) {
                        for (int i = 0; i < imageListSize; i++) {
                            byteBufferArr[i] = ByteBuffer.allocateDirect(imageWidthFromImageList * imageHeightFromImageList * 4);
                        }
                    }
                    if (!PacketGetter.getImageList(packets.get(iIntValue), byteBufferArr, z)) {
                        throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), "There is an error getting confidence masks.");
                    }
                    for (int i2 = 0; i2 < imageListSize; i2++) {
                        ((List) optionalOf.get()).add(new ByteBufferImageBuilder(byteBufferArr[i2], imageWidthFromImageList, imageHeightFromImageList, 10).build());
                    }
                    optionalEmpty = optionalOf;
                }
                Optional optionalEmpty2 = Optional.empty();
                if (segmenterOptions.outputCategoryMask()) {
                    int imageWidth = PacketGetter.getImageWidth(packets.get(iIntValue2));
                    int imageHeight = PacketGetter.getImageHeight(packets.get(iIntValue2));
                    if (!zIsPresent) {
                        imageDataDirectly = ByteBuffer.allocateDirect(imageWidth * imageHeight);
                        if (!PacketGetter.getImageData(packets.get(iIntValue2), imageDataDirectly)) {
                            throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), "There is an error getting category mask.");
                        }
                    } else {
                        imageDataDirectly = PacketGetter.getImageDataDirectly(packets.get(iIntValue2));
                    }
                    optionalEmpty2 = Optional.of(new ByteBufferImageBuilder(imageDataDirectly, imageWidth, imageHeight, 8).build());
                }
                float[] float32Vector = PacketGetter.getFloat32Vector(packets.get(iIntValue3));
                ArrayList arrayList2 = new ArrayList(float32Vector.length);
                for (float f : float32Vector) {
                    arrayList2.add(Float.valueOf(f));
                }
                return ImageSegmenterResult.create(optionalEmpty, optionalEmpty2, arrayList2, BaseVisionTaskApi.generateResultTimestampMs(segmenterOptions.runningMode(), packets.get(iIntValue4)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(iIntValue4))).build();
            }
        });
        Optional<OutputHandler.ResultListener<ImageSegmenterResult, MPImage>> optionalResultListener = segmenterOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = segmenterOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenter$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new ImageSegmenter(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(segmenterOptions.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(arrayList).setTaskOptions(segmenterOptions).setEnableFlowLimiting(segmenterOptions.runningMode() == RunningMode.LIVE_STREAM).build(), outputHandler), segmenterOptions.runningMode(), segmenterOptions.resultListener().isPresent());
    }

    static /* synthetic */ Integer lambda$createFromOptions$0(List list, String str) {
        list.add(str);
        return Integer.valueOf(list.size() - 1);
    }

    private ImageSegmenter(TaskRunner taskRunner, RunningMode runningMode, boolean hasResultListener) {
        super(taskRunner, runningMode, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
        this.hasResultListener = false;
        this.labels = new ArrayList();
        this.hasResultListener = hasResultListener;
        populateLabels();
    }

    private void populateLabels() {
        boolean z = false;
        for (CalculatorProto.CalculatorGraphConfig.Node node : this.runner.getCalculatorGraphConfig().getNodeList()) {
            if (node.getName().contains(TENSORS_TO_SEGMENTATION_CALCULATOR_NAME)) {
                if (z) {
                    throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), "The graph has more than one mediapipe.tasks.TensorsToSegmentationCalculator.");
                }
                TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions tensorsToSegmentationCalculatorOptions = (TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions) node.getOptions().getExtension(TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ext);
                for (int i = 0; i < tensorsToSegmentationCalculatorOptions.getLabelItemsMap().size(); i++) {
                    Long lValueOf = Long.valueOf(i);
                    if (!tensorsToSegmentationCalculatorOptions.getLabelItemsMap().containsKey(lValueOf)) {
                        throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), "The lablemap have no expected key: " + lValueOf);
                    }
                    this.labels.add(tensorsToSegmentationCalculatorOptions.getLabelItemsMap().get(lValueOf).getName());
                }
                z = true;
            }
        }
    }

    public ImageSegmenterResult segment(MPImage image) {
        return segment(image, ImageProcessingOptions.builder().build());
    }

    public ImageSegmenterResult segment(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        return segment(image, SegmentationOptions.builder().setOutputWidth(image.getWidth()).setOutputHeight(image.getHeight()).setImageProcessingOptions(imageProcessingOptions).build());
    }

    public ImageSegmenterResult segment(MPImage image, SegmentationOptions segmentationOptions) {
        if (this.hasResultListener) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "ResultListener is provided in the ImageSegmenterOptions, but this method will return an ImageSegmentationResult.");
        }
        return (ImageSegmenterResult) processImageData(buildInputPackets(image, segmentationOptions));
    }

    public void segmentWithResultListener(MPImage image) {
        segmentWithResultListener(image, ImageProcessingOptions.builder().build());
    }

    public void segmentWithResultListener(MPImage image, ImageProcessingOptions imageProcessingOptions) {
        segmentWithResultListener(image, SegmentationOptions.builder().setOutputWidth(image.getWidth()).setOutputHeight(image.getHeight()).setImageProcessingOptions(imageProcessingOptions).build());
    }

    public void segmentWithResultListener(MPImage image, SegmentationOptions segmentationOptions) {
        if (!this.hasResultListener) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "ResultListener is not set in the ImageSegmenterOptions, but this method expects a ResultListener to process ImageSegmentationResult.");
        }
    }

    public ImageSegmenterResult segmentForVideo(MPImage image, long timestampMs) {
        return segmentForVideo(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public ImageSegmenterResult segmentForVideo(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        return segmentForVideo(image, SegmentationOptions.builder().setOutputWidth(image.getWidth()).setOutputHeight(image.getHeight()).setImageProcessingOptions(imageProcessingOptions).build(), timestampMs);
    }

    public ImageSegmenterResult segmentForVideo(MPImage image, SegmentationOptions segmentationOptions, long timestampMs) {
        if (this.hasResultListener) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "ResultListener is provided in the ImageSegmenterOptions, but this method will return an ImageSegmentationResult.");
        }
        return (ImageSegmenterResult) processVideoData(buildInputPackets(image, segmentationOptions), timestampMs);
    }

    public void segmentForVideoWithResultListener(MPImage image, long timestampMs) {
        segmentForVideoWithResultListener(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void segmentForVideoWithResultListener(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        segmentForVideoWithResultListener(image, SegmentationOptions.builder().setOutputWidth(image.getWidth()).setOutputHeight(image.getHeight()).setImageProcessingOptions(imageProcessingOptions).build(), timestampMs);
    }

    public void segmentForVideoWithResultListener(MPImage image, SegmentationOptions segmentationOptions, long timestampMs) {
        if (!this.hasResultListener) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "ResultListener is not set in the ImageSegmenterOptions, but this method expects a ResultListener to process ImageSegmentationResult.");
        }
    }

    public void segmentAsync(MPImage image, long timestampMs) {
        segmentAsync(image, ImageProcessingOptions.builder().build(), timestampMs);
    }

    public void segmentAsync(MPImage image, ImageProcessingOptions imageProcessingOptions, long timestampMs) {
        segmentAsync(image, SegmentationOptions.builder().setOutputWidth(image.getWidth()).setOutputHeight(image.getHeight()).setImageProcessingOptions(imageProcessingOptions).build(), timestampMs);
    }

    public void segmentAsync(MPImage image, SegmentationOptions segmentationOptions, long timestampMs) {
        sendLiveStreamData(buildInputPackets(image, segmentationOptions), timestampMs);
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public static abstract class SegmentationOptions {
        abstract ImageProcessingOptions imageProcessingOptions();

        abstract int outputHeight();

        abstract int outputWidth();

        public static abstract class Builder {
            abstract SegmentationOptions autoBuild();

            public abstract Builder setImageProcessingOptions(ImageProcessingOptions value);

            public abstract Builder setOutputHeight(int value);

            public abstract Builder setOutputWidth(int value);

            public final SegmentationOptions build() {
                SegmentationOptions segmentationOptionsAutoBuild = autoBuild();
                if (segmentationOptionsAutoBuild.outputWidth() <= 0 || segmentationOptionsAutoBuild.outputHeight() <= 0) {
                    throw new IllegalArgumentException("Both outputWidth and outputHeight must be larger than 0.");
                }
                if (segmentationOptionsAutoBuild.imageProcessingOptions().regionOfInterest().isPresent()) {
                    throw new IllegalArgumentException("ImageSegmenter doesn't support region-of-interest.");
                }
                return segmentationOptionsAutoBuild;
            }
        }

        public static Builder builder() {
            return new AutoValue_ImageSegmenter_SegmentationOptions.Builder().setImageProcessingOptions(ImageProcessingOptions.builder().build());
        }
    }

    public static abstract class ImageSegmenterOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract String displayNamesLocale();

        abstract Optional<ErrorListener> errorListener();

        abstract boolean outputCategoryMask();

        abstract boolean outputConfidenceMasks();

        abstract Optional<OutputHandler.ResultListener<ImageSegmenterResult, MPImage>> resultListener();

        abstract RunningMode runningMode();

        public static abstract class Builder {
            abstract ImageSegmenterOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setDisplayNamesLocale(String value);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setOutputCategoryMask(boolean value);

            public abstract Builder setOutputConfidenceMasks(boolean value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<ImageSegmenterResult, MPImage> value);

            public abstract Builder setRunningMode(RunningMode value);

            public final ImageSegmenterOptions build() {
                ImageSegmenterOptions imageSegmenterOptionsAutoBuild = autoBuild();
                if (imageSegmenterOptionsAutoBuild.runningMode() != RunningMode.LIVE_STREAM || imageSegmenterOptionsAutoBuild.resultListener().isPresent()) {
                    return imageSegmenterOptionsAutoBuild;
                }
                throw new IllegalArgumentException("The image segmenter is in the live stream mode, a user-defined result listener must be provided in ImageSegmenterOptions.");
            }
        }

        public static Builder builder() {
            return new AutoValue_ImageSegmenter_ImageSegmenterOptions.Builder().setRunningMode(RunningMode.IMAGE).setDisplayNamesLocale("en").setOutputConfidenceMasks(true).setOutputCategoryMask(false);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.Builder displayNamesLocale = ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.newBuilder().setBaseOptions((BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder().setUseStreamMode(runningMode() != RunningMode.IMAGE).mergeFrom(convertBaseOptionsToProto(baseOptions())).build()).setDisplayNamesLocale(displayNamesLocale());
            displayNamesLocale.setSegmenterOptions(SegmenterOptionsProto.SegmenterOptions.newBuilder());
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.ext, (ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions) displayNamesLocale.build()).build();
        }
    }

    private Map<String, Packet> buildInputPackets(MPImage image, SegmentationOptions segmentationOptions) {
        HashMap map = new HashMap();
        map.put(this.imageStreamName, this.runner.getPacketCreator().createImage(image));
        map.put(OUTPUT_SIZE_IN_STREAM_NAME, this.runner.getPacketCreator().createInt32Pair(segmentationOptions.outputWidth(), segmentationOptions.outputHeight()));
        if (!this.normRectStreamName.isEmpty()) {
            map.put(this.normRectStreamName, this.runner.getPacketCreator().createProto(convertToNormalizedRect(segmentationOptions.imageProcessingOptions(), image)));
        }
        return map;
    }
}
