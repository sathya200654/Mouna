package com.google.mediapipe.proto;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class MediaPipeLoggingEnumsProto {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private MediaPipeLoggingEnumsProto() {
    }

    public enum HostEnvironment implements Internal.EnumLite {
        HOST_ENVIRONMENT_UNKNOWN(0),
        HOST_ENVIRONMENT_ANDROID(1),
        HOST_ENVIRONMENT_IOS(2),
        HOST_ENVIRONMENT_PYTHON(3),
        HOST_ENVIRONMENT_WEB(4);

        public static final int HOST_ENVIRONMENT_ANDROID_VALUE = 1;
        public static final int HOST_ENVIRONMENT_IOS_VALUE = 2;
        public static final int HOST_ENVIRONMENT_PYTHON_VALUE = 3;
        public static final int HOST_ENVIRONMENT_UNKNOWN_VALUE = 0;
        public static final int HOST_ENVIRONMENT_WEB_VALUE = 4;
        private static final Internal.EnumLiteMap<HostEnvironment> internalValueMap = new Internal.EnumLiteMap<HostEnvironment>() { // from class: com.google.mediapipe.proto.MediaPipeLoggingEnumsProto.HostEnvironment.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public HostEnvironment findValueByNumber(int number) {
                return HostEnvironment.forNumber(number);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static HostEnvironment valueOf(int value) {
            return forNumber(value);
        }

        public static HostEnvironment forNumber(int value) {
            if (value == 0) {
                return HOST_ENVIRONMENT_UNKNOWN;
            }
            if (value == 1) {
                return HOST_ENVIRONMENT_ANDROID;
            }
            if (value == 2) {
                return HOST_ENVIRONMENT_IOS;
            }
            if (value == 3) {
                return HOST_ENVIRONMENT_PYTHON;
            }
            if (value != 4) {
                return null;
            }
            return HOST_ENVIRONMENT_WEB;
        }

        public static Internal.EnumLiteMap<HostEnvironment> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return HostEnvironmentVerifier.INSTANCE;
        }

        private static final class HostEnvironmentVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new HostEnvironmentVerifier();

            private HostEnvironmentVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return HostEnvironment.forNumber(number) != null;
            }
        }

        HostEnvironment(int value) {
            this.value = value;
        }
    }

    public enum Platform implements Internal.EnumLite {
        PLATFORM_UNKNOWN(0),
        PLATFORM_ANDROID(1),
        PLATFORM_IOS(2),
        PLATFORM_LINUX(3),
        PLATFORM_MAC(4),
        PLATFORM_WINDOWS(5);

        public static final int PLATFORM_ANDROID_VALUE = 1;
        public static final int PLATFORM_IOS_VALUE = 2;
        public static final int PLATFORM_LINUX_VALUE = 3;
        public static final int PLATFORM_MAC_VALUE = 4;
        public static final int PLATFORM_UNKNOWN_VALUE = 0;
        public static final int PLATFORM_WINDOWS_VALUE = 5;
        private static final Internal.EnumLiteMap<Platform> internalValueMap = new Internal.EnumLiteMap<Platform>() { // from class: com.google.mediapipe.proto.MediaPipeLoggingEnumsProto.Platform.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Platform findValueByNumber(int number) {
                return Platform.forNumber(number);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Platform valueOf(int value) {
            return forNumber(value);
        }

        public static Platform forNumber(int value) {
            if (value == 0) {
                return PLATFORM_UNKNOWN;
            }
            if (value == 1) {
                return PLATFORM_ANDROID;
            }
            if (value == 2) {
                return PLATFORM_IOS;
            }
            if (value == 3) {
                return PLATFORM_LINUX;
            }
            if (value == 4) {
                return PLATFORM_MAC;
            }
            if (value != 5) {
                return null;
            }
            return PLATFORM_WINDOWS;
        }

        public static Internal.EnumLiteMap<Platform> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PlatformVerifier.INSTANCE;
        }

        private static final class PlatformVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PlatformVerifier();

            private PlatformVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return Platform.forNumber(number) != null;
            }
        }

        Platform(int value) {
            this.value = value;
        }
    }

    public enum SolutionName implements Internal.EnumLite {
        SOLUTION_UNKNOWN(0),
        SOLUTION_FACEDETECTION(1),
        SOLUTION_FACEMESH(2),
        SOLUTION_HANDS(3),
        TASKS_AUDIOCLASSIFIER(4),
        TASKS_AUDIOEMBEDDER(5),
        TASKS_TEXTCLASSIFIER(6),
        TASKS_TEXTEMBEDDER(7),
        TASKS_GESTURERECOGNIZER(8),
        TASKS_HANDDETECTOR(9),
        TASKS_HANDLANDMARKER(10),
        TASKS_IMAGECLASSIFIER(11),
        TASKS_IMAGEEMBEDDER(12),
        TASKS_IMAGESEGMENTER(13),
        TASKS_OBJECTDETECTOR(14),
        TASKS_FACEDETECTOR(15),
        TASKS_FACELANDMARKER(16),
        TASKS_FACESTYLIZER(17),
        TASKS_INTERACTIVESEGMENTER(18),
        TASKS_IMAGEGENERATOR(19),
        TASKS_HOLISTICLANDMARKER(20),
        TASKS_LLMINFERENCE(21),
        TASKS_LANGUAGEDETECTOR(22),
        TASKS_POSELANDMARKER(23);

        public static final int SOLUTION_FACEDETECTION_VALUE = 1;
        public static final int SOLUTION_FACEMESH_VALUE = 2;
        public static final int SOLUTION_HANDS_VALUE = 3;
        public static final int SOLUTION_UNKNOWN_VALUE = 0;
        public static final int TASKS_AUDIOCLASSIFIER_VALUE = 4;
        public static final int TASKS_AUDIOEMBEDDER_VALUE = 5;
        public static final int TASKS_FACEDETECTOR_VALUE = 15;
        public static final int TASKS_FACELANDMARKER_VALUE = 16;
        public static final int TASKS_FACESTYLIZER_VALUE = 17;
        public static final int TASKS_GESTURERECOGNIZER_VALUE = 8;
        public static final int TASKS_HANDDETECTOR_VALUE = 9;
        public static final int TASKS_HANDLANDMARKER_VALUE = 10;
        public static final int TASKS_HOLISTICLANDMARKER_VALUE = 20;
        public static final int TASKS_IMAGECLASSIFIER_VALUE = 11;
        public static final int TASKS_IMAGEEMBEDDER_VALUE = 12;
        public static final int TASKS_IMAGEGENERATOR_VALUE = 19;
        public static final int TASKS_IMAGESEGMENTER_VALUE = 13;
        public static final int TASKS_INTERACTIVESEGMENTER_VALUE = 18;
        public static final int TASKS_LANGUAGEDETECTOR_VALUE = 22;
        public static final int TASKS_LLMINFERENCE_VALUE = 21;
        public static final int TASKS_OBJECTDETECTOR_VALUE = 14;
        public static final int TASKS_POSELANDMARKER_VALUE = 23;
        public static final int TASKS_TEXTCLASSIFIER_VALUE = 6;
        public static final int TASKS_TEXTEMBEDDER_VALUE = 7;
        private static final Internal.EnumLiteMap<SolutionName> internalValueMap = new Internal.EnumLiteMap<SolutionName>() { // from class: com.google.mediapipe.proto.MediaPipeLoggingEnumsProto.SolutionName.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SolutionName findValueByNumber(int number) {
                return SolutionName.forNumber(number);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static SolutionName valueOf(int value) {
            return forNumber(value);
        }

        public static SolutionName forNumber(int value) {
            switch (value) {
                case 0:
                    return SOLUTION_UNKNOWN;
                case 1:
                    return SOLUTION_FACEDETECTION;
                case 2:
                    return SOLUTION_FACEMESH;
                case 3:
                    return SOLUTION_HANDS;
                case 4:
                    return TASKS_AUDIOCLASSIFIER;
                case 5:
                    return TASKS_AUDIOEMBEDDER;
                case 6:
                    return TASKS_TEXTCLASSIFIER;
                case 7:
                    return TASKS_TEXTEMBEDDER;
                case 8:
                    return TASKS_GESTURERECOGNIZER;
                case 9:
                    return TASKS_HANDDETECTOR;
                case 10:
                    return TASKS_HANDLANDMARKER;
                case 11:
                    return TASKS_IMAGECLASSIFIER;
                case 12:
                    return TASKS_IMAGEEMBEDDER;
                case 13:
                    return TASKS_IMAGESEGMENTER;
                case 14:
                    return TASKS_OBJECTDETECTOR;
                case 15:
                    return TASKS_FACEDETECTOR;
                case 16:
                    return TASKS_FACELANDMARKER;
                case 17:
                    return TASKS_FACESTYLIZER;
                case 18:
                    return TASKS_INTERACTIVESEGMENTER;
                case 19:
                    return TASKS_IMAGEGENERATOR;
                case 20:
                    return TASKS_HOLISTICLANDMARKER;
                case 21:
                    return TASKS_LLMINFERENCE;
                case 22:
                    return TASKS_LANGUAGEDETECTOR;
                case 23:
                    return TASKS_POSELANDMARKER;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<SolutionName> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return SolutionNameVerifier.INSTANCE;
        }

        private static final class SolutionNameVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new SolutionNameVerifier();

            private SolutionNameVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return SolutionName.forNumber(number) != null;
            }
        }

        SolutionName(int value) {
            this.value = value;
        }
    }

    public enum EventName implements Internal.EnumLite {
        EVENT_START(0),
        EVENT_INVOCATONS(1),
        EVENT_END(2),
        EVENT_ERROR(3);

        public static final int EVENT_END_VALUE = 2;
        public static final int EVENT_ERROR_VALUE = 3;
        public static final int EVENT_INVOCATONS_VALUE = 1;
        public static final int EVENT_START_VALUE = 0;
        private static final Internal.EnumLiteMap<EventName> internalValueMap = new Internal.EnumLiteMap<EventName>() { // from class: com.google.mediapipe.proto.MediaPipeLoggingEnumsProto.EventName.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public EventName findValueByNumber(int number) {
                return EventName.forNumber(number);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static EventName valueOf(int value) {
            return forNumber(value);
        }

        public static EventName forNumber(int value) {
            if (value == 0) {
                return EVENT_START;
            }
            if (value == 1) {
                return EVENT_INVOCATONS;
            }
            if (value == 2) {
                return EVENT_END;
            }
            if (value != 3) {
                return null;
            }
            return EVENT_ERROR;
        }

        public static Internal.EnumLiteMap<EventName> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return EventNameVerifier.INSTANCE;
        }

        private static final class EventNameVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new EventNameVerifier();

            private EventNameVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return EventName.forNumber(number) != null;
            }
        }

        EventName(int value) {
            this.value = value;
        }
    }

    public enum SolutionMode implements Internal.EnumLite {
        MODE_UNKNOWN(0),
        MODE_VIDEO(1),
        MODE_STATIC_IMAGE(2),
        MODE_TASKS_UNSPECIFIED(10),
        MODE_TASKS_IMAGE(11),
        MODE_TASKS_VIDEO(12),
        MODE_TASKS_LIVE_STREAM(13),
        MODE_TASKS_AUDIO_CLIPS(14),
        MODE_TASKS_AUDIO_STREAM(15);

        public static final int MODE_STATIC_IMAGE_VALUE = 2;
        public static final int MODE_TASKS_AUDIO_CLIPS_VALUE = 14;
        public static final int MODE_TASKS_AUDIO_STREAM_VALUE = 15;
        public static final int MODE_TASKS_IMAGE_VALUE = 11;
        public static final int MODE_TASKS_LIVE_STREAM_VALUE = 13;
        public static final int MODE_TASKS_UNSPECIFIED_VALUE = 10;
        public static final int MODE_TASKS_VIDEO_VALUE = 12;
        public static final int MODE_UNKNOWN_VALUE = 0;
        public static final int MODE_VIDEO_VALUE = 1;
        private static final Internal.EnumLiteMap<SolutionMode> internalValueMap = new Internal.EnumLiteMap<SolutionMode>() { // from class: com.google.mediapipe.proto.MediaPipeLoggingEnumsProto.SolutionMode.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SolutionMode findValueByNumber(int number) {
                return SolutionMode.forNumber(number);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static SolutionMode valueOf(int value) {
            return forNumber(value);
        }

        public static SolutionMode forNumber(int value) {
            if (value == 0) {
                return MODE_UNKNOWN;
            }
            if (value == 1) {
                return MODE_VIDEO;
            }
            if (value == 2) {
                return MODE_STATIC_IMAGE;
            }
            switch (value) {
                case 10:
                    return MODE_TASKS_UNSPECIFIED;
                case 11:
                    return MODE_TASKS_IMAGE;
                case 12:
                    return MODE_TASKS_VIDEO;
                case 13:
                    return MODE_TASKS_LIVE_STREAM;
                case 14:
                    return MODE_TASKS_AUDIO_CLIPS;
                case 15:
                    return MODE_TASKS_AUDIO_STREAM;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<SolutionMode> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return SolutionModeVerifier.INSTANCE;
        }

        private static final class SolutionModeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new SolutionModeVerifier();

            private SolutionModeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return SolutionMode.forNumber(number) != null;
            }
        }

        SolutionMode(int value) {
            this.value = value;
        }
    }

    public enum InputDataType implements Internal.EnumLite {
        INPUT_TYPE_UNKNOWN(0),
        INPUT_TYPE_CPU_IMAGE(1),
        INPUT_TYPE_GPU_IMAGE(2),
        INPUT_TYPE_TASKS_CPU(3),
        INPUT_TYPE_TASKS_GPU(4);

        public static final int INPUT_TYPE_CPU_IMAGE_VALUE = 1;
        public static final int INPUT_TYPE_GPU_IMAGE_VALUE = 2;
        public static final int INPUT_TYPE_TASKS_CPU_VALUE = 3;
        public static final int INPUT_TYPE_TASKS_GPU_VALUE = 4;
        public static final int INPUT_TYPE_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<InputDataType> internalValueMap = new Internal.EnumLiteMap<InputDataType>() { // from class: com.google.mediapipe.proto.MediaPipeLoggingEnumsProto.InputDataType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public InputDataType findValueByNumber(int number) {
                return InputDataType.forNumber(number);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static InputDataType valueOf(int value) {
            return forNumber(value);
        }

        public static InputDataType forNumber(int value) {
            if (value == 0) {
                return INPUT_TYPE_UNKNOWN;
            }
            if (value == 1) {
                return INPUT_TYPE_CPU_IMAGE;
            }
            if (value == 2) {
                return INPUT_TYPE_GPU_IMAGE;
            }
            if (value == 3) {
                return INPUT_TYPE_TASKS_CPU;
            }
            if (value != 4) {
                return null;
            }
            return INPUT_TYPE_TASKS_GPU;
        }

        public static Internal.EnumLiteMap<InputDataType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return InputDataTypeVerifier.INSTANCE;
        }

        private static final class InputDataTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new InputDataTypeVerifier();

            private InputDataTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return InputDataType.forNumber(number) != null;
            }
        }

        InputDataType(int value) {
            this.value = value;
        }
    }

    public enum ErrorCode implements Internal.EnumLite {
        ERROR_UNKNOWN(0),
        ERROR_UNSUPPORTED_INPUT(1),
        ERROR_UNSUPPORTED_OUTPUT(2),
        ERROR_INIT(3);

        public static final int ERROR_INIT_VALUE = 3;
        public static final int ERROR_UNKNOWN_VALUE = 0;
        public static final int ERROR_UNSUPPORTED_INPUT_VALUE = 1;
        public static final int ERROR_UNSUPPORTED_OUTPUT_VALUE = 2;
        private static final Internal.EnumLiteMap<ErrorCode> internalValueMap = new Internal.EnumLiteMap<ErrorCode>() { // from class: com.google.mediapipe.proto.MediaPipeLoggingEnumsProto.ErrorCode.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ErrorCode findValueByNumber(int number) {
                return ErrorCode.forNumber(number);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ErrorCode valueOf(int value) {
            return forNumber(value);
        }

        public static ErrorCode forNumber(int value) {
            if (value == 0) {
                return ERROR_UNKNOWN;
            }
            if (value == 1) {
                return ERROR_UNSUPPORTED_INPUT;
            }
            if (value == 2) {
                return ERROR_UNSUPPORTED_OUTPUT;
            }
            if (value != 3) {
                return null;
            }
            return ERROR_INIT;
        }

        public static Internal.EnumLiteMap<ErrorCode> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ErrorCodeVerifier.INSTANCE;
        }

        private static final class ErrorCodeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new ErrorCodeVerifier();

            private ErrorCodeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return ErrorCode.forNumber(number) != null;
            }
        }

        ErrorCode(int value) {
            this.value = value;
        }
    }
}
