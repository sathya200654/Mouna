package com.google.mediapipe.tasks.vision.interactivesegmenter;

import android.content.Context;
import com.google.mediapipe.framework.AndroidPacketGetter;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import com.google.mediapipe.framework.ProtoUtil;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.framework.image.ByteBufferImageBuilder;
import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.proto.CalculatorProto;
import com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto;
import com.google.mediapipe.tasks.components.containers.NormalizedKeypoint;
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
import com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenterResult;
import com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto;
import com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto;
import com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InteractiveSegmenter extends BaseVisionTaskApi {
    private static final String IMAGE_IN_STREAM_NAME = "image_in";
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("IMAGE:image_in", "ROI:roi_in", "NORM_RECT:norm_rect_in"));
    private static final String NORM_RECT_IN_STREAM_NAME = "norm_rect_in";
    private static final String ROI_IN_STREAM_NAME = "roi_in";
    private static final String TAG = "InteractiveSegmenter";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.vision.interactive_segmenter.InteractiveSegmenterGraph";
    private static final String TENSORS_TO_SEGMENTATION_CALCULATOR_NAME = "mediapipe.tasks.TensorsToSegmentationCalculator";
    private boolean hasResultListener;
    private List<String> labels;

    static {
        System.loadLibrary("mediapipe_tasks_jni");
        ProtoUtil.registerTypeName(RegionOfInterestProto.RegionOfInterest.class, "mediapipe.tasks.vision.interactive_segmenter.proto.RegionOfInterest");
    }

    public static InteractiveSegmenter createFromOptions(Context context, final InteractiveSegmenterOptions segmenterOptions) {
        if (!segmenterOptions.outputConfidenceMasks() && !segmenterOptions.outputCategoryMask()) {
            throw new IllegalArgumentException("At least one of `outputConfidenceMasks` and `outputCategoryMask` must be set.");
        }
        ArrayList arrayList = new ArrayList();
        if (segmenterOptions.outputConfidenceMasks()) {
            arrayList.add("CONFIDENCE_MASKS:confidence_masks");
        }
        final int size = arrayList.size() - 1;
        if (segmenterOptions.outputCategoryMask()) {
            arrayList.add("CATEGORY_MASK:category_mask");
        }
        final int size2 = arrayList.size() - 1;
        arrayList.add("QUALITY_SCORES:quality_scores");
        final int size3 = arrayList.size() - 1;
        arrayList.add("IMAGE:image_out");
        final int size4 = arrayList.size() - 1;
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<ImageSegmenterResult, MPImage>() { // from class: com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter.1
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
                if (packets.get(size4).isEmpty()) {
                    return ImageSegmenterResult.create(Optional.empty(), Optional.empty(), new ArrayList(), packets.get(size4).getTimestamp());
                }
                boolean zIsPresent = segmenterOptions.resultListener().isPresent();
                boolean z = !zIsPresent;
                Optional optionalEmpty = Optional.empty();
                if (segmenterOptions.outputConfidenceMasks()) {
                    optionalEmpty = Optional.of(new ArrayList());
                    int imageWidthFromImageList = PacketGetter.getImageWidthFromImageList(packets.get(size));
                    int imageHeightFromImageList = PacketGetter.getImageHeightFromImageList(packets.get(size));
                    int imageListSize = PacketGetter.getImageListSize(packets.get(size));
                    ByteBuffer[] byteBufferArr = new ByteBuffer[imageListSize];
                    if (!zIsPresent) {
                        for (int i = 0; i < imageListSize; i++) {
                            byteBufferArr[i] = ByteBuffer.allocateDirect(imageWidthFromImageList * imageHeightFromImageList * 4);
                        }
                    }
                    if (!PacketGetter.getImageList(packets.get(size), byteBufferArr, z)) {
                        throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), "There is an error getting confidence masks.");
                    }
                    for (int i2 = 0; i2 < imageListSize; i2++) {
                        ((List) optionalEmpty.get()).add(new ByteBufferImageBuilder(byteBufferArr[i2], imageWidthFromImageList, imageHeightFromImageList, 10).build());
                    }
                }
                Optional optionalEmpty2 = Optional.empty();
                if (segmenterOptions.outputCategoryMask()) {
                    int imageWidth = PacketGetter.getImageWidth(packets.get(size2));
                    int imageHeight = PacketGetter.getImageHeight(packets.get(size2));
                    if (!zIsPresent) {
                        imageDataDirectly = ByteBuffer.allocateDirect(imageWidth * imageHeight);
                        if (!PacketGetter.getImageData(packets.get(size2), imageDataDirectly)) {
                            throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), "There is an error getting category mask.");
                        }
                    } else {
                        imageDataDirectly = PacketGetter.getImageDataDirectly(packets.get(size2));
                    }
                    optionalEmpty2 = Optional.of(new ByteBufferImageBuilder(imageDataDirectly, imageWidth, imageHeight, 8).build());
                }
                float[] float32Vector = PacketGetter.getFloat32Vector(packets.get(size3));
                ArrayList arrayList2 = new ArrayList(float32Vector.length);
                for (float f : float32Vector) {
                    arrayList2.add(Float.valueOf(f));
                }
                return ImageSegmenterResult.create(optionalEmpty, optionalEmpty2, arrayList2, BaseVisionTaskApi.generateResultTimestampMs(RunningMode.IMAGE, packets.get(size4)));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public MPImage convertToTaskInput(List<Packet> packets) {
                return new BitmapImageBuilder(AndroidPacketGetter.getBitmap(packets.get(size4))).build();
            }
        });
        Optional<OutputHandler.ResultListener<ImageSegmenterResult, MPImage>> optionalResultListener = segmenterOptions.resultListener();
        Objects.requireNonNull(outputHandler);
        optionalResultListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setResultListener((OutputHandler.ResultListener) obj);
            }
        });
        Optional<ErrorListener> optionalErrorListener = segmenterOptions.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.vision.interactivesegmenter.InteractiveSegmenter$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new InteractiveSegmenter(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(RunningMode.IMAGE.name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(arrayList).setTaskOptions(segmenterOptions).setEnableFlowLimiting(false).build(), outputHandler), segmenterOptions.resultListener().isPresent());
    }

    private InteractiveSegmenter(TaskRunner taskRunner, boolean hasResultListener) {
        super(taskRunner, RunningMode.IMAGE, IMAGE_IN_STREAM_NAME, NORM_RECT_IN_STREAM_NAME);
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

    public ImageSegmenterResult segment(MPImage image, RegionOfInterest roi) {
        return segment(image, roi, ImageProcessingOptions.builder().build());
    }

    public ImageSegmenterResult segment(MPImage image, RegionOfInterest roi, ImageProcessingOptions imageProcessingOptions) {
        if (this.hasResultListener) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "ResultListener is provided in the InteractiveSegmenterOptions, but this method will return an ImageSegmentationResult.");
        }
        validateImageProcessingOptions(imageProcessingOptions);
        return processImageWithRoi(image, roi, imageProcessingOptions);
    }

    public void segmentWithResultListener(MPImage image, RegionOfInterest roi) {
        segmentWithResultListener(image, roi, ImageProcessingOptions.builder().build());
    }

    public void segmentWithResultListener(MPImage image, RegionOfInterest roi, ImageProcessingOptions imageProcessingOptions) {
        if (!this.hasResultListener) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "ResultListener is not set in the InteractiveSegmenterOptions, but this method expects a ResultListener to process ImageSegmentationResult.");
        }
        validateImageProcessingOptions(imageProcessingOptions);
        processImageWithRoi(image, roi, imageProcessingOptions);
    }

    List<String> getLabels() {
        return this.labels;
    }

    public static abstract class InteractiveSegmenterOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract Optional<ErrorListener> errorListener();

        abstract boolean outputCategoryMask();

        abstract boolean outputConfidenceMasks();

        abstract Optional<OutputHandler.ResultListener<ImageSegmenterResult, MPImage>> resultListener();

        public static abstract class Builder {
            abstract InteractiveSegmenterOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions value);

            public abstract Builder setErrorListener(ErrorListener value);

            public abstract Builder setOutputCategoryMask(boolean value);

            public abstract Builder setOutputConfidenceMasks(boolean value);

            public abstract Builder setResultListener(OutputHandler.ResultListener<ImageSegmenterResult, MPImage> value);

            public final InteractiveSegmenterOptions build() {
                return autoBuild();
            }
        }

        public static Builder builder() {
            return new AutoValue_InteractiveSegmenter_InteractiveSegmenterOptions.Builder().setOutputConfidenceMasks(true).setOutputCategoryMask(false);
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.Builder baseOptions = ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.newBuilder().setBaseOptions((BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder().setUseStreamMode(false).mergeFrom(convertBaseOptionsToProto(baseOptions())).build());
            baseOptions.setSegmenterOptions(SegmenterOptionsProto.SegmenterOptions.newBuilder());
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.ext, (ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions) baseOptions.build()).build();
        }
    }

    private static void validateImageProcessingOptions(ImageProcessingOptions imageProcessingOptions) {
        if (imageProcessingOptions.regionOfInterest().isPresent()) {
            throw new IllegalArgumentException("InteractiveSegmenter doesn't support region-of-interest.");
        }
    }

    public static class RegionOfInterest {
        private NormalizedKeypoint keypoint;
        private List<NormalizedKeypoint> scribble;

        private RegionOfInterest() {
        }

        public static RegionOfInterest create(NormalizedKeypoint keypoint) {
            RegionOfInterest regionOfInterest = new RegionOfInterest();
            regionOfInterest.keypoint = keypoint;
            return regionOfInterest;
        }

        public static RegionOfInterest create(List<NormalizedKeypoint> scribble) {
            RegionOfInterest regionOfInterest = new RegionOfInterest();
            regionOfInterest.scribble = scribble;
            return regionOfInterest;
        }
    }

    private static RegionOfInterestProto.RegionOfInterest convertToRegionOfInterest(RegionOfInterest roi) {
        RegionOfInterestProto.RegionOfInterest.Builder builderNewBuilder = RegionOfInterestProto.RegionOfInterest.newBuilder();
        if (roi.keypoint == null) {
            if (roi.scribble != null) {
                RegionOfInterestProto.Scribble.Builder builderNewBuilder2 = RegionOfInterestProto.Scribble.newBuilder();
                for (NormalizedKeypoint normalizedKeypoint : roi.scribble) {
                    builderNewBuilder2.addPoint(RegionOfInterestProto.Point.newBuilder().setX(normalizedKeypoint.x()).setY(normalizedKeypoint.y()));
                }
                return (RegionOfInterestProto.RegionOfInterest) builderNewBuilder.setScribble(builderNewBuilder2).build();
            }
            throw new IllegalArgumentException("RegionOfInterest does not include a valid user interaction");
        }
        return (RegionOfInterestProto.RegionOfInterest) builderNewBuilder.setKeypoint(RegionOfInterestProto.Point.newBuilder().setX(roi.keypoint.x()).setY(roi.keypoint.y())).build();
    }

    private ImageSegmenterResult processImageWithRoi(MPImage image, RegionOfInterest roi, ImageProcessingOptions imageProcessingOptions) {
        if (this.runningMode != RunningMode.IMAGE) {
            throw new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "Task is not initialized with the image mode. Current running mode:" + this.runningMode.name());
        }
        HashMap map = new HashMap();
        map.put(IMAGE_IN_STREAM_NAME, this.runner.getPacketCreator().createImage(image));
        map.put(ROI_IN_STREAM_NAME, this.runner.getPacketCreator().createProto(convertToRegionOfInterest(roi)));
        map.put(NORM_RECT_IN_STREAM_NAME, this.runner.getPacketCreator().createProto(convertToNormalizedRect(imageProcessingOptions, image)));
        return (ImageSegmenterResult) this.runner.process(map);
    }
}
