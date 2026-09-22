package com.google.mediapipe.tasks.audio.audioclassifier;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter;
import com.google.mediapipe.framework.ProtoUtil;
import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto;
import com.google.mediapipe.tasks.audio.core.BaseAudioTaskApi;
import com.google.mediapipe.tasks.audio.core.RunningMode;
import com.google.mediapipe.tasks.components.containers.AudioData;
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
public final class AudioClassifier extends BaseAudioTaskApi {
    private static final String AUDIO_IN_STREAM_NAME = "audio_in";
    private static final int CLASSIFICATIONS_OUT_STREAM_INDEX = 0;
    private static final long MICROSECONDS_PER_MILLISECOND = 1000;
    private static final String SAMPLE_RATE_IN_STREAM_NAME = "sample_rate_in";
    private static final String TAG = "AudioClassifier";
    private static final String TASK_GRAPH_NAME = "mediapipe.tasks.audio.audio_classifier.AudioClassifierGraph";
    private static final int TIMESTAMPED_CLASSIFICATIONS_OUT_STREAM_INDEX = 1;
    private static final List<String> INPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("AUDIO:audio_in", "SAMPLE_RATE:sample_rate_in"));
    private static final List<String> OUTPUT_STREAMS = Collections.unmodifiableList(Arrays.asList("CLASSIFICATIONS:classifications_out", "TIMESTAMPED_CLASSIFICATIONS:timestamped_classifications_out"));

    static {
        ProtoUtil.registerTypeName(ClassificationsProto.ClassificationResult.class, "mediapipe.tasks.components.containers.proto.ClassificationResult");
    }

    public static AudioClassifier createFromFile(Context context, String modelPath) {
        return createFromOptions(context, AudioClassifierOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(modelPath).build()).build());
    }

    public static AudioClassifier createFromFile(Context context, File modelFile) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(modelFile, 268435456);
        try {
            AudioClassifier audioClassifierCreateFromOptions = createFromOptions(context, AudioClassifierOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetFileDescriptor(Integer.valueOf(parcelFileDescriptorOpen.getFd())).build()).build());
            if (parcelFileDescriptorOpen != null) {
                parcelFileDescriptorOpen.close();
            }
            return audioClassifierCreateFromOptions;
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

    public static AudioClassifier createFromBuffer(Context context, final ByteBuffer modelBuffer) {
        return createFromOptions(context, AudioClassifierOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetBuffer(modelBuffer).build()).build());
    }

    public static AudioClassifier createFromOptions(Context context, final AudioClassifierOptions options) {
        final OutputHandler outputHandler = new OutputHandler();
        outputHandler.setOutputPacketConverter(new OutputHandler.OutputPacketConverter<AudioClassifierResult, Void>() { // from class: com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifier.1
            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            /* JADX INFO: renamed from: convertToTaskInput, reason: avoid collision after fix types in other method */
            public Void convertToTaskInput2(List<Packet> packets) {
                return null;
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ Void convertToTaskInput(List packets) {
                return convertToTaskInput2((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public /* bridge */ /* synthetic */ TaskResult convertToTaskResult(List packets) {
                return convertToTaskResult((List<Packet>) packets);
            }

            @Override // com.google.mediapipe.tasks.core.OutputHandler.OutputPacketConverter
            public AudioClassifierResult convertToTaskResult(List<Packet> packets) {
                try {
                    if (!packets.get(0).isEmpty()) {
                        return AudioClassifierResult.createFromProto((ClassificationsProto.ClassificationResult) PacketGetter.getProto(packets.get(0), ClassificationsProto.ClassificationResult.getDefaultInstance()), packets.get(0).getTimestamp() / 1000);
                    }
                    return AudioClassifierResult.createFromProtoList(PacketGetter.getProtoVector(packets.get(1), ClassificationsProto.ClassificationResult.parser()), -1L);
                } catch (IOException e) {
                    throw new MediaPipeException(MediaPipeException.StatusCode.INTERNAL.ordinal(), e.getMessage());
                }
            }
        });
        if (options.resultListener().isPresent()) {
            outputHandler.setResultListener(new OutputHandler.ResultListener<AudioClassifierResult, Void>() { // from class: com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifier.2
                @Override // com.google.mediapipe.tasks.core.OutputHandler.ResultListener
                public void run(AudioClassifierResult audioClassifierResult, Void input) {
                    options.resultListener().get().run(audioClassifierResult);
                }
            });
        }
        Optional<ErrorListener> optionalErrorListener = options.errorListener();
        Objects.requireNonNull(outputHandler);
        optionalErrorListener.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifier$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                outputHandler.setErrorListener((ErrorListener) obj);
            }
        });
        return new AudioClassifier(TaskRunner.create(context, TaskInfo.builder().setTaskName(TAG).setTaskRunningModeName(options.runningMode().name()).setTaskGraphName(TASK_GRAPH_NAME).setInputStreams(INPUT_STREAMS).setOutputStreams(OUTPUT_STREAMS).setTaskOptions(options).setEnableFlowLimiting(false).build(), outputHandler), options.runningMode());
    }

    private AudioClassifier(TaskRunner taskRunner, RunningMode runningMode) {
        super(taskRunner, runningMode, AUDIO_IN_STREAM_NAME, SAMPLE_RATE_IN_STREAM_NAME);
    }

    public AudioClassifierResult classify(AudioData audioClip) {
        return (AudioClassifierResult) processAudioClip(audioClip);
    }

    public void classifyAsync(AudioData audioBlock, long timestampMs) {
        checkOrSetSampleRate(audioBlock.getFormat().getSampleRate());
        sendAudioStreamData(audioBlock, timestampMs);
    }

    public static abstract class AudioClassifierOptions extends TaskOptions {
        abstract BaseOptions baseOptions();

        abstract List<String> categoryAllowlist();

        abstract List<String> categoryDenylist();

        abstract Optional<String> displayNamesLocale();

        abstract Optional<ErrorListener> errorListener();

        abstract Optional<Integer> maxResults();

        abstract Optional<OutputHandler.PureResultListener<AudioClassifierResult>> resultListener();

        abstract RunningMode runningMode();

        abstract Optional<Float> scoreThreshold();

        public static abstract class Builder {
            abstract AudioClassifierOptions autoBuild();

            public abstract Builder setBaseOptions(BaseOptions baseOptions);

            public abstract Builder setCategoryAllowlist(List<String> categoryAllowlist);

            public abstract Builder setCategoryDenylist(List<String> categoryDenylist);

            public abstract Builder setDisplayNamesLocale(String locale);

            public abstract Builder setErrorListener(ErrorListener errorListener);

            public abstract Builder setMaxResults(Integer maxResults);

            public abstract Builder setResultListener(OutputHandler.PureResultListener<AudioClassifierResult> resultListener);

            public abstract Builder setRunningMode(RunningMode runningMode);

            public abstract Builder setScoreThreshold(Float scoreThreshold);

            public final AudioClassifierOptions build() {
                AudioClassifierOptions audioClassifierOptionsAutoBuild = autoBuild();
                if (audioClassifierOptionsAutoBuild.runningMode() == RunningMode.AUDIO_STREAM) {
                    if (!audioClassifierOptionsAutoBuild.resultListener().isPresent()) {
                        throw new IllegalArgumentException("The audio classifier is in the audio stream mode, a user-defined result listener must be provided in the AudioClassifierOptions.");
                    }
                } else if (audioClassifierOptionsAutoBuild.resultListener().isPresent()) {
                    throw new IllegalArgumentException("The audio classifier is in the audio clips mode, a user-defined result listener shouldn't be provided in AudioClassifierOptions.");
                }
                if (audioClassifierOptionsAutoBuild.maxResults().isPresent() && audioClassifierOptionsAutoBuild.maxResults().get().intValue() <= 0) {
                    throw new IllegalArgumentException("If specified, maxResults must be > 0.");
                }
                if (audioClassifierOptionsAutoBuild.categoryAllowlist().isEmpty() || audioClassifierOptionsAutoBuild.categoryDenylist().isEmpty()) {
                    return audioClassifierOptionsAutoBuild;
                }
                throw new IllegalArgumentException("Category allowlist and denylist are mutually exclusive.");
            }
        }

        public static Builder builder() {
            return new AutoValue_AudioClassifier_AudioClassifierOptions.Builder().setRunningMode(RunningMode.AUDIO_CLIPS).setCategoryAllowlist(Collections.emptyList()).setCategoryDenylist(Collections.emptyList());
        }

        @Override // com.google.mediapipe.tasks.core.TaskOptions
        public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
            BaseOptionsProto.BaseOptions.Builder builderNewBuilder = BaseOptionsProto.BaseOptions.newBuilder();
            builderNewBuilder.setUseStreamMode(runningMode() == RunningMode.AUDIO_STREAM);
            builderNewBuilder.mergeFrom(convertBaseOptionsToProto(baseOptions()));
            final ClassifierOptionsProto.ClassifierOptions.Builder builderNewBuilder2 = ClassifierOptionsProto.ClassifierOptions.newBuilder();
            Optional<String> optionalDisplayNamesLocale = displayNamesLocale();
            Objects.requireNonNull(builderNewBuilder2);
            optionalDisplayNamesLocale.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifier$AudioClassifierOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setDisplayNamesLocale((String) obj);
                }
            });
            Optional<Integer> optionalMaxResults = maxResults();
            Objects.requireNonNull(builderNewBuilder2);
            optionalMaxResults.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifier$AudioClassifierOptions$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    builderNewBuilder2.setMaxResults(((Integer) obj).intValue());
                }
            });
            Optional<Float> optionalScoreThreshold = scoreThreshold();
            Objects.requireNonNull(builderNewBuilder2);
            optionalScoreThreshold.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifier$AudioClassifierOptions$$ExternalSyntheticLambda2
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
            return (CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(AudioClassifierGraphOptionsProto.AudioClassifierGraphOptions.ext, (AudioClassifierGraphOptionsProto.AudioClassifierGraphOptions) AudioClassifierGraphOptionsProto.AudioClassifierGraphOptions.newBuilder().setBaseOptions(builderNewBuilder).setClassifierOptions(builderNewBuilder2).build()).build();
        }
    }
}
