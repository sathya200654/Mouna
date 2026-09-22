package com.google.mediapipe.util.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class RenderDataProto {

    public interface RenderAnnotationOrBuilder extends MessageLiteOrBuilder {
        RenderAnnotation.Arrow getArrow();

        ColorProto.Color getColor();

        RenderAnnotation.DataCase getDataCase();

        RenderAnnotation.FilledOval getFilledOval();

        RenderAnnotation.FilledRectangle getFilledRectangle();

        RenderAnnotation.FilledRoundedRectangle getFilledRoundedRectangle();

        RenderAnnotation.GradientLine getGradientLine();

        RenderAnnotation.Line getLine();

        RenderAnnotation.Oval getOval();

        RenderAnnotation.Point getPoint();

        RenderAnnotation.Rectangle getRectangle();

        RenderAnnotation.RoundedRectangle getRoundedRectangle();

        String getSceneTag();

        ByteString getSceneTagBytes();

        RenderAnnotation.Scribble getScribble();

        RenderAnnotation.Text getText();

        double getThickness();

        boolean hasArrow();

        boolean hasColor();

        boolean hasFilledOval();

        boolean hasFilledRectangle();

        boolean hasFilledRoundedRectangle();

        boolean hasGradientLine();

        boolean hasLine();

        boolean hasOval();

        boolean hasPoint();

        boolean hasRectangle();

        boolean hasRoundedRectangle();

        boolean hasSceneTag();

        boolean hasScribble();

        boolean hasText();

        boolean hasThickness();
    }

    public interface RenderDataOrBuilder extends MessageLiteOrBuilder {
        RenderAnnotation getRenderAnnotations(int index);

        int getRenderAnnotationsCount();

        List<RenderAnnotation> getRenderAnnotationsList();

        String getSceneClass();

        ByteString getSceneClassBytes();

        RenderViewport getSceneViewport();

        boolean hasSceneClass();

        boolean hasSceneViewport();
    }

    public interface RenderViewportOrBuilder extends MessageLiteOrBuilder {
        boolean getComposeOnVideo();

        int getHeightPx();

        String getId();

        ByteString getIdBytes();

        int getWidthPx();

        boolean hasComposeOnVideo();

        boolean hasHeightPx();

        boolean hasId();

        boolean hasWidthPx();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private RenderDataProto() {
    }

    public static final class RenderData extends GeneratedMessageLite<RenderData, Builder> implements RenderDataOrBuilder {
        private static final RenderData DEFAULT_INSTANCE;
        private static volatile Parser<RenderData> PARSER = null;
        public static final int RENDER_ANNOTATIONS_FIELD_NUMBER = 1;
        public static final int SCENE_CLASS_FIELD_NUMBER = 2;
        public static final int SCENE_VIEWPORT_FIELD_NUMBER = 3;
        private int bitField0_;
        private Internal.ProtobufList<RenderAnnotation> renderAnnotations_ = emptyProtobufList();
        private String sceneClass_ = "";
        private RenderViewport sceneViewport_;

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        private RenderData() {
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
        public List<RenderAnnotation> getRenderAnnotationsList() {
            return this.renderAnnotations_;
        }

        public List<? extends RenderAnnotationOrBuilder> getRenderAnnotationsOrBuilderList() {
            return this.renderAnnotations_;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
        public int getRenderAnnotationsCount() {
            return this.renderAnnotations_.size();
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
        public RenderAnnotation getRenderAnnotations(int index) {
            return this.renderAnnotations_.get(index);
        }

        public RenderAnnotationOrBuilder getRenderAnnotationsOrBuilder(int index) {
            return this.renderAnnotations_.get(index);
        }

        private void ensureRenderAnnotationsIsMutable() {
            Internal.ProtobufList<RenderAnnotation> protobufList = this.renderAnnotations_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.renderAnnotations_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRenderAnnotations(int index, RenderAnnotation value) {
            value.getClass();
            ensureRenderAnnotationsIsMutable();
            this.renderAnnotations_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRenderAnnotations(RenderAnnotation value) {
            value.getClass();
            ensureRenderAnnotationsIsMutable();
            this.renderAnnotations_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRenderAnnotations(int index, RenderAnnotation value) {
            value.getClass();
            ensureRenderAnnotationsIsMutable();
            this.renderAnnotations_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllRenderAnnotations(Iterable<? extends RenderAnnotation> values) {
            ensureRenderAnnotationsIsMutable();
            AbstractMessageLite.addAll(values, this.renderAnnotations_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRenderAnnotations() {
            this.renderAnnotations_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeRenderAnnotations(int index) {
            ensureRenderAnnotationsIsMutable();
            this.renderAnnotations_.remove(index);
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
        public boolean hasSceneClass() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
        public String getSceneClass() {
            return this.sceneClass_;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
        public ByteString getSceneClassBytes() {
            return ByteString.copyFromUtf8(this.sceneClass_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSceneClass(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.sceneClass_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSceneClass() {
            this.bitField0_ &= -2;
            this.sceneClass_ = getDefaultInstance().getSceneClass();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSceneClassBytes(ByteString value) {
            this.sceneClass_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
        public boolean hasSceneViewport() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
        public RenderViewport getSceneViewport() {
            RenderViewport renderViewport = this.sceneViewport_;
            return renderViewport == null ? RenderViewport.getDefaultInstance() : renderViewport;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSceneViewport(RenderViewport value) {
            value.getClass();
            this.sceneViewport_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSceneViewport(RenderViewport value) {
            value.getClass();
            RenderViewport renderViewport = this.sceneViewport_;
            if (renderViewport != null && renderViewport != RenderViewport.getDefaultInstance()) {
                this.sceneViewport_ = (RenderViewport) RenderViewport.newBuilder(this.sceneViewport_).mergeFrom(value).buildPartial();
            } else {
                this.sceneViewport_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSceneViewport() {
            this.sceneViewport_ = null;
            this.bitField0_ &= -3;
        }

        public static RenderData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderData parseFrom(InputStream input) throws IOException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RenderData parseDelimitedFrom(InputStream input) throws IOException {
            return (RenderData) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderData) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RenderData parseFrom(CodedInputStream input) throws IOException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RenderData prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RenderData, Builder> implements RenderDataOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return super.build();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return super.buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return super.clear();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                return super.internalMergeFrom((GeneratedMessageLite) message);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                return super.mergeFrom(other);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            private Builder() {
                super(RenderData.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
            public List<RenderAnnotation> getRenderAnnotationsList() {
                return Collections.unmodifiableList(((RenderData) this.instance).getRenderAnnotationsList());
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
            public int getRenderAnnotationsCount() {
                return ((RenderData) this.instance).getRenderAnnotationsCount();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
            public RenderAnnotation getRenderAnnotations(int index) {
                return ((RenderData) this.instance).getRenderAnnotations(index);
            }

            public Builder setRenderAnnotations(int index, RenderAnnotation value) {
                copyOnWrite();
                ((RenderData) this.instance).setRenderAnnotations(index, value);
                return this;
            }

            public Builder setRenderAnnotations(int index, RenderAnnotation.Builder builderForValue) {
                copyOnWrite();
                ((RenderData) this.instance).setRenderAnnotations(index, (RenderAnnotation) builderForValue.build());
                return this;
            }

            public Builder addRenderAnnotations(RenderAnnotation value) {
                copyOnWrite();
                ((RenderData) this.instance).addRenderAnnotations(value);
                return this;
            }

            public Builder addRenderAnnotations(int index, RenderAnnotation value) {
                copyOnWrite();
                ((RenderData) this.instance).addRenderAnnotations(index, value);
                return this;
            }

            public Builder addRenderAnnotations(RenderAnnotation.Builder builderForValue) {
                copyOnWrite();
                ((RenderData) this.instance).addRenderAnnotations((RenderAnnotation) builderForValue.build());
                return this;
            }

            public Builder addRenderAnnotations(int index, RenderAnnotation.Builder builderForValue) {
                copyOnWrite();
                ((RenderData) this.instance).addRenderAnnotations(index, (RenderAnnotation) builderForValue.build());
                return this;
            }

            public Builder addAllRenderAnnotations(Iterable<? extends RenderAnnotation> values) {
                copyOnWrite();
                ((RenderData) this.instance).addAllRenderAnnotations(values);
                return this;
            }

            public Builder clearRenderAnnotations() {
                copyOnWrite();
                ((RenderData) this.instance).clearRenderAnnotations();
                return this;
            }

            public Builder removeRenderAnnotations(int index) {
                copyOnWrite();
                ((RenderData) this.instance).removeRenderAnnotations(index);
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
            public boolean hasSceneClass() {
                return ((RenderData) this.instance).hasSceneClass();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
            public String getSceneClass() {
                return ((RenderData) this.instance).getSceneClass();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
            public ByteString getSceneClassBytes() {
                return ((RenderData) this.instance).getSceneClassBytes();
            }

            public Builder setSceneClass(String value) {
                copyOnWrite();
                ((RenderData) this.instance).setSceneClass(value);
                return this;
            }

            public Builder clearSceneClass() {
                copyOnWrite();
                ((RenderData) this.instance).clearSceneClass();
                return this;
            }

            public Builder setSceneClassBytes(ByteString value) {
                copyOnWrite();
                ((RenderData) this.instance).setSceneClassBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
            public boolean hasSceneViewport() {
                return ((RenderData) this.instance).hasSceneViewport();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderDataOrBuilder
            public RenderViewport getSceneViewport() {
                return ((RenderData) this.instance).getSceneViewport();
            }

            public Builder setSceneViewport(RenderViewport value) {
                copyOnWrite();
                ((RenderData) this.instance).setSceneViewport(value);
                return this;
            }

            public Builder setSceneViewport(RenderViewport.Builder builderForValue) {
                copyOnWrite();
                ((RenderData) this.instance).setSceneViewport((RenderViewport) builderForValue.build());
                return this;
            }

            public Builder mergeSceneViewport(RenderViewport value) {
                copyOnWrite();
                ((RenderData) this.instance).mergeSceneViewport(value);
                return this;
            }

            public Builder clearSceneViewport() {
                copyOnWrite();
                ((RenderData) this.instance).clearSceneViewport();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new RenderData();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "renderAnnotations_", RenderAnnotation.class, "sceneClass_", "sceneViewport_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RenderData> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (RenderData.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RenderData renderData = new RenderData();
            DEFAULT_INSTANCE = renderData;
            GeneratedMessageLite.registerDefaultInstance(RenderData.class, renderData);
        }

        public static RenderData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RenderData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.util.proto.RenderDataProto$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class RenderAnnotation extends GeneratedMessageLite<RenderAnnotation, Builder> implements RenderAnnotationOrBuilder {
        public static final int ARROW_FIELD_NUMBER = 7;
        public static final int COLOR_FIELD_NUMBER = 12;
        private static final RenderAnnotation DEFAULT_INSTANCE;
        public static final int FILLED_OVAL_FIELD_NUMBER = 4;
        public static final int FILLED_RECTANGLE_FIELD_NUMBER = 2;
        public static final int FILLED_ROUNDED_RECTANGLE_FIELD_NUMBER = 10;
        public static final int GRADIENT_LINE_FIELD_NUMBER = 14;
        public static final int LINE_FIELD_NUMBER = 6;
        public static final int OVAL_FIELD_NUMBER = 3;
        private static volatile Parser<RenderAnnotation> PARSER = null;
        public static final int POINT_FIELD_NUMBER = 5;
        public static final int RECTANGLE_FIELD_NUMBER = 1;
        public static final int ROUNDED_RECTANGLE_FIELD_NUMBER = 9;
        public static final int SCENE_TAG_FIELD_NUMBER = 13;
        public static final int SCRIBBLE_FIELD_NUMBER = 15;
        public static final int TEXT_FIELD_NUMBER = 8;
        public static final int THICKNESS_FIELD_NUMBER = 11;
        private int bitField0_;
        private ColorProto.Color color_;
        private Object data_;
        private int dataCase_ = 0;
        private double thickness_ = 1.0d;
        private String sceneTag_ = "";

        public interface ArrowOrBuilder extends MessageLiteOrBuilder {
            boolean getNormalized();

            double getXEnd();

            double getXStart();

            double getYEnd();

            double getYStart();

            boolean hasNormalized();

            boolean hasXEnd();

            boolean hasXStart();

            boolean hasYEnd();

            boolean hasYStart();
        }

        public interface FilledOvalOrBuilder extends MessageLiteOrBuilder {
            ColorProto.Color getFillColor();

            Oval getOval();

            boolean hasFillColor();

            boolean hasOval();
        }

        public interface FilledRectangleOrBuilder extends MessageLiteOrBuilder {
            ColorProto.Color getFillColor();

            Rectangle getRectangle();

            boolean hasFillColor();

            boolean hasRectangle();
        }

        public interface FilledRoundedRectangleOrBuilder extends MessageLiteOrBuilder {
            ColorProto.Color getFillColor();

            RoundedRectangle getRoundedRectangle();

            boolean hasFillColor();

            boolean hasRoundedRectangle();
        }

        public interface GradientLineOrBuilder extends MessageLiteOrBuilder {
            ColorProto.Color getColor1();

            ColorProto.Color getColor2();

            boolean getNormalized();

            double getXEnd();

            double getXStart();

            double getYEnd();

            double getYStart();

            boolean hasColor1();

            boolean hasColor2();

            boolean hasNormalized();

            boolean hasXEnd();

            boolean hasXStart();

            boolean hasYEnd();

            boolean hasYStart();
        }

        public interface LineOrBuilder extends MessageLiteOrBuilder {
            Line.LineType getLineType();

            boolean getNormalized();

            double getXEnd();

            double getXStart();

            double getYEnd();

            double getYStart();

            boolean hasLineType();

            boolean hasNormalized();

            boolean hasXEnd();

            boolean hasXStart();

            boolean hasYEnd();

            boolean hasYStart();
        }

        public interface OvalOrBuilder extends MessageLiteOrBuilder {
            Rectangle getRectangle();

            boolean hasRectangle();
        }

        public interface PointOrBuilder extends MessageLiteOrBuilder {
            boolean getNormalized();

            double getX();

            double getY();

            boolean hasNormalized();

            boolean hasX();

            boolean hasY();
        }

        public interface RectangleOrBuilder extends MessageLiteOrBuilder {
            double getBottom();

            double getLeft();

            boolean getNormalized();

            double getRight();

            double getRotation();

            double getTop();

            double getTopLeftThickness();

            boolean hasBottom();

            boolean hasLeft();

            boolean hasNormalized();

            boolean hasRight();

            boolean hasRotation();

            boolean hasTop();

            boolean hasTopLeftThickness();
        }

        public interface RoundedRectangleOrBuilder extends MessageLiteOrBuilder {
            int getCornerRadius();

            int getLineType();

            Rectangle getRectangle();

            boolean hasCornerRadius();

            boolean hasLineType();

            boolean hasRectangle();
        }

        public interface ScribbleOrBuilder extends MessageLiteOrBuilder {
            Point getPoint(int index);

            int getPointCount();

            List<Point> getPointList();
        }

        public interface TextOrBuilder extends MessageLiteOrBuilder {
            double getBaseline();

            boolean getCenterHorizontally();

            boolean getCenterVertically();

            String getDisplayText();

            ByteString getDisplayTextBytes();

            int getFontFace();

            double getFontHeight();

            double getLeft();

            boolean getNormalized();

            ColorProto.Color getOutlineColor();

            double getOutlineThickness();

            boolean hasBaseline();

            boolean hasCenterHorizontally();

            boolean hasCenterVertically();

            boolean hasDisplayText();

            boolean hasFontFace();

            boolean hasFontHeight();

            boolean hasLeft();

            boolean hasNormalized();

            boolean hasOutlineColor();

            boolean hasOutlineThickness();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        private RenderAnnotation() {
        }

        public static final class Rectangle extends GeneratedMessageLite<Rectangle, Builder> implements RectangleOrBuilder {
            public static final int BOTTOM_FIELD_NUMBER = 4;
            private static final Rectangle DEFAULT_INSTANCE;
            public static final int LEFT_FIELD_NUMBER = 1;
            public static final int NORMALIZED_FIELD_NUMBER = 5;
            private static volatile Parser<Rectangle> PARSER = null;
            public static final int RIGHT_FIELD_NUMBER = 3;
            public static final int ROTATION_FIELD_NUMBER = 6;
            public static final int TOP_FIELD_NUMBER = 2;
            public static final int TOP_LEFT_THICKNESS_FIELD_NUMBER = 7;
            private int bitField0_;
            private double bottom_;
            private double left_;
            private boolean normalized_;
            private double right_;
            private double rotation_;
            private double topLeftThickness_;
            private double top_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private Rectangle() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public boolean hasLeft() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public double getLeft() {
                return this.left_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLeft(double value) {
                this.bitField0_ |= 1;
                this.left_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLeft() {
                this.bitField0_ &= -2;
                this.left_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public boolean hasTop() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public double getTop() {
                return this.top_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTop(double value) {
                this.bitField0_ |= 2;
                this.top_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTop() {
                this.bitField0_ &= -3;
                this.top_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public boolean hasRight() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public double getRight() {
                return this.right_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRight(double value) {
                this.bitField0_ |= 4;
                this.right_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRight() {
                this.bitField0_ &= -5;
                this.right_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public boolean hasBottom() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public double getBottom() {
                return this.bottom_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBottom(double value) {
                this.bitField0_ |= 8;
                this.bottom_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBottom() {
                this.bitField0_ &= -9;
                this.bottom_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public boolean hasNormalized() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public boolean getNormalized() {
                return this.normalized_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNormalized(boolean value) {
                this.bitField0_ |= 16;
                this.normalized_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNormalized() {
                this.bitField0_ &= -17;
                this.normalized_ = false;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public boolean hasRotation() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public double getRotation() {
                return this.rotation_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRotation(double value) {
                this.bitField0_ |= 32;
                this.rotation_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRotation() {
                this.bitField0_ &= -33;
                this.rotation_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public boolean hasTopLeftThickness() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
            public double getTopLeftThickness() {
                return this.topLeftThickness_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTopLeftThickness(double value) {
                this.bitField0_ |= 64;
                this.topLeftThickness_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTopLeftThickness() {
                this.bitField0_ &= -65;
                this.topLeftThickness_ = 0.0d;
            }

            public static Rectangle parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Rectangle parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Rectangle parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Rectangle parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Rectangle parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Rectangle parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Rectangle parseFrom(InputStream input) throws IOException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Rectangle parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Rectangle parseDelimitedFrom(InputStream input) throws IOException {
                return (Rectangle) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Rectangle parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Rectangle) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Rectangle parseFrom(CodedInputStream input) throws IOException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Rectangle parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Rectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Rectangle prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Rectangle, Builder> implements RectangleOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(Rectangle.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public boolean hasLeft() {
                    return ((Rectangle) this.instance).hasLeft();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public double getLeft() {
                    return ((Rectangle) this.instance).getLeft();
                }

                public Builder setLeft(double value) {
                    copyOnWrite();
                    ((Rectangle) this.instance).setLeft(value);
                    return this;
                }

                public Builder clearLeft() {
                    copyOnWrite();
                    ((Rectangle) this.instance).clearLeft();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public boolean hasTop() {
                    return ((Rectangle) this.instance).hasTop();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public double getTop() {
                    return ((Rectangle) this.instance).getTop();
                }

                public Builder setTop(double value) {
                    copyOnWrite();
                    ((Rectangle) this.instance).setTop(value);
                    return this;
                }

                public Builder clearTop() {
                    copyOnWrite();
                    ((Rectangle) this.instance).clearTop();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public boolean hasRight() {
                    return ((Rectangle) this.instance).hasRight();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public double getRight() {
                    return ((Rectangle) this.instance).getRight();
                }

                public Builder setRight(double value) {
                    copyOnWrite();
                    ((Rectangle) this.instance).setRight(value);
                    return this;
                }

                public Builder clearRight() {
                    copyOnWrite();
                    ((Rectangle) this.instance).clearRight();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public boolean hasBottom() {
                    return ((Rectangle) this.instance).hasBottom();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public double getBottom() {
                    return ((Rectangle) this.instance).getBottom();
                }

                public Builder setBottom(double value) {
                    copyOnWrite();
                    ((Rectangle) this.instance).setBottom(value);
                    return this;
                }

                public Builder clearBottom() {
                    copyOnWrite();
                    ((Rectangle) this.instance).clearBottom();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public boolean hasNormalized() {
                    return ((Rectangle) this.instance).hasNormalized();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public boolean getNormalized() {
                    return ((Rectangle) this.instance).getNormalized();
                }

                public Builder setNormalized(boolean value) {
                    copyOnWrite();
                    ((Rectangle) this.instance).setNormalized(value);
                    return this;
                }

                public Builder clearNormalized() {
                    copyOnWrite();
                    ((Rectangle) this.instance).clearNormalized();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public boolean hasRotation() {
                    return ((Rectangle) this.instance).hasRotation();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public double getRotation() {
                    return ((Rectangle) this.instance).getRotation();
                }

                public Builder setRotation(double value) {
                    copyOnWrite();
                    ((Rectangle) this.instance).setRotation(value);
                    return this;
                }

                public Builder clearRotation() {
                    copyOnWrite();
                    ((Rectangle) this.instance).clearRotation();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public boolean hasTopLeftThickness() {
                    return ((Rectangle) this.instance).hasTopLeftThickness();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RectangleOrBuilder
                public double getTopLeftThickness() {
                    return ((Rectangle) this.instance).getTopLeftThickness();
                }

                public Builder setTopLeftThickness(double value) {
                    copyOnWrite();
                    ((Rectangle) this.instance).setTopLeftThickness(value);
                    return this;
                }

                public Builder clearTopLeftThickness() {
                    copyOnWrite();
                    ((Rectangle) this.instance).clearTopLeftThickness();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new Rectangle();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005ဇ\u0004\u0006က\u0005\u0007က\u0006", new Object[]{"bitField0_", "left_", "top_", "right_", "bottom_", "normalized_", "rotation_", "topLeftThickness_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Rectangle> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Rectangle.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Rectangle rectangle = new Rectangle();
                DEFAULT_INSTANCE = rectangle;
                GeneratedMessageLite.registerDefaultInstance(Rectangle.class, rectangle);
            }

            public static Rectangle getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Rectangle> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class FilledRectangle extends GeneratedMessageLite<FilledRectangle, Builder> implements FilledRectangleOrBuilder {
            private static final FilledRectangle DEFAULT_INSTANCE;
            public static final int FILL_COLOR_FIELD_NUMBER = 2;
            private static volatile Parser<FilledRectangle> PARSER = null;
            public static final int RECTANGLE_FIELD_NUMBER = 1;
            private int bitField0_;
            private ColorProto.Color fillColor_;
            private Rectangle rectangle_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private FilledRectangle() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRectangleOrBuilder
            public boolean hasRectangle() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRectangleOrBuilder
            public Rectangle getRectangle() {
                Rectangle rectangle = this.rectangle_;
                return rectangle == null ? Rectangle.getDefaultInstance() : rectangle;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRectangle(Rectangle value) {
                value.getClass();
                this.rectangle_ = value;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeRectangle(Rectangle value) {
                value.getClass();
                Rectangle rectangle = this.rectangle_;
                if (rectangle != null && rectangle != Rectangle.getDefaultInstance()) {
                    this.rectangle_ = (Rectangle) Rectangle.newBuilder(this.rectangle_).mergeFrom(value).buildPartial();
                } else {
                    this.rectangle_ = value;
                }
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRectangle() {
                this.rectangle_ = null;
                this.bitField0_ &= -2;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRectangleOrBuilder
            public boolean hasFillColor() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRectangleOrBuilder
            public ColorProto.Color getFillColor() {
                ColorProto.Color color = this.fillColor_;
                return color == null ? ColorProto.Color.getDefaultInstance() : color;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFillColor(ColorProto.Color value) {
                value.getClass();
                this.fillColor_ = value;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeFillColor(ColorProto.Color value) {
                value.getClass();
                ColorProto.Color color = this.fillColor_;
                if (color != null && color != ColorProto.Color.getDefaultInstance()) {
                    this.fillColor_ = (ColorProto.Color) ColorProto.Color.newBuilder(this.fillColor_).mergeFrom(value).buildPartial();
                } else {
                    this.fillColor_ = value;
                }
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFillColor() {
                this.fillColor_ = null;
                this.bitField0_ &= -3;
            }

            public static FilledRectangle parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledRectangle parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledRectangle parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledRectangle parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledRectangle parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledRectangle parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledRectangle parseFrom(InputStream input) throws IOException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledRectangle parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static FilledRectangle parseDelimitedFrom(InputStream input) throws IOException {
                return (FilledRectangle) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledRectangle parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledRectangle) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static FilledRectangle parseFrom(CodedInputStream input) throws IOException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledRectangle parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(FilledRectangle prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<FilledRectangle, Builder> implements FilledRectangleOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(FilledRectangle.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRectangleOrBuilder
                public boolean hasRectangle() {
                    return ((FilledRectangle) this.instance).hasRectangle();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRectangleOrBuilder
                public Rectangle getRectangle() {
                    return ((FilledRectangle) this.instance).getRectangle();
                }

                public Builder setRectangle(Rectangle value) {
                    copyOnWrite();
                    ((FilledRectangle) this.instance).setRectangle(value);
                    return this;
                }

                public Builder setRectangle(Rectangle.Builder builderForValue) {
                    copyOnWrite();
                    ((FilledRectangle) this.instance).setRectangle((Rectangle) builderForValue.build());
                    return this;
                }

                public Builder mergeRectangle(Rectangle value) {
                    copyOnWrite();
                    ((FilledRectangle) this.instance).mergeRectangle(value);
                    return this;
                }

                public Builder clearRectangle() {
                    copyOnWrite();
                    ((FilledRectangle) this.instance).clearRectangle();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRectangleOrBuilder
                public boolean hasFillColor() {
                    return ((FilledRectangle) this.instance).hasFillColor();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRectangleOrBuilder
                public ColorProto.Color getFillColor() {
                    return ((FilledRectangle) this.instance).getFillColor();
                }

                public Builder setFillColor(ColorProto.Color value) {
                    copyOnWrite();
                    ((FilledRectangle) this.instance).setFillColor(value);
                    return this;
                }

                public Builder setFillColor(ColorProto.Color.Builder builderForValue) {
                    copyOnWrite();
                    ((FilledRectangle) this.instance).setFillColor((ColorProto.Color) builderForValue.build());
                    return this;
                }

                public Builder mergeFillColor(ColorProto.Color value) {
                    copyOnWrite();
                    ((FilledRectangle) this.instance).mergeFillColor(value);
                    return this;
                }

                public Builder clearFillColor() {
                    copyOnWrite();
                    ((FilledRectangle) this.instance).clearFillColor();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new FilledRectangle();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "rectangle_", "fillColor_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<FilledRectangle> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (FilledRectangle.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                FilledRectangle filledRectangle = new FilledRectangle();
                DEFAULT_INSTANCE = filledRectangle;
                GeneratedMessageLite.registerDefaultInstance(FilledRectangle.class, filledRectangle);
            }

            public static FilledRectangle getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<FilledRectangle> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class RoundedRectangle extends GeneratedMessageLite<RoundedRectangle, Builder> implements RoundedRectangleOrBuilder {
            public static final int CORNER_RADIUS_FIELD_NUMBER = 2;
            private static final RoundedRectangle DEFAULT_INSTANCE;
            public static final int LINE_TYPE_FIELD_NUMBER = 3;
            private static volatile Parser<RoundedRectangle> PARSER = null;
            public static final int RECTANGLE_FIELD_NUMBER = 1;
            private int bitField0_;
            private int cornerRadius_;
            private int lineType_ = 4;
            private Rectangle rectangle_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private RoundedRectangle() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
            public boolean hasRectangle() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
            public Rectangle getRectangle() {
                Rectangle rectangle = this.rectangle_;
                return rectangle == null ? Rectangle.getDefaultInstance() : rectangle;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRectangle(Rectangle value) {
                value.getClass();
                this.rectangle_ = value;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeRectangle(Rectangle value) {
                value.getClass();
                Rectangle rectangle = this.rectangle_;
                if (rectangle != null && rectangle != Rectangle.getDefaultInstance()) {
                    this.rectangle_ = (Rectangle) Rectangle.newBuilder(this.rectangle_).mergeFrom(value).buildPartial();
                } else {
                    this.rectangle_ = value;
                }
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRectangle() {
                this.rectangle_ = null;
                this.bitField0_ &= -2;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
            public boolean hasCornerRadius() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
            public int getCornerRadius() {
                return this.cornerRadius_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCornerRadius(int value) {
                this.bitField0_ |= 2;
                this.cornerRadius_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCornerRadius() {
                this.bitField0_ &= -3;
                this.cornerRadius_ = 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
            public boolean hasLineType() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
            public int getLineType() {
                return this.lineType_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLineType(int value) {
                this.bitField0_ |= 4;
                this.lineType_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLineType() {
                this.bitField0_ &= -5;
                this.lineType_ = 4;
            }

            public static RoundedRectangle parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RoundedRectangle parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RoundedRectangle parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RoundedRectangle parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RoundedRectangle parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RoundedRectangle parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RoundedRectangle parseFrom(InputStream input) throws IOException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static RoundedRectangle parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static RoundedRectangle parseDelimitedFrom(InputStream input) throws IOException {
                return (RoundedRectangle) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static RoundedRectangle parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RoundedRectangle) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static RoundedRectangle parseFrom(CodedInputStream input) throws IOException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static RoundedRectangle parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(RoundedRectangle prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<RoundedRectangle, Builder> implements RoundedRectangleOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(RoundedRectangle.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
                public boolean hasRectangle() {
                    return ((RoundedRectangle) this.instance).hasRectangle();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
                public Rectangle getRectangle() {
                    return ((RoundedRectangle) this.instance).getRectangle();
                }

                public Builder setRectangle(Rectangle value) {
                    copyOnWrite();
                    ((RoundedRectangle) this.instance).setRectangle(value);
                    return this;
                }

                public Builder setRectangle(Rectangle.Builder builderForValue) {
                    copyOnWrite();
                    ((RoundedRectangle) this.instance).setRectangle((Rectangle) builderForValue.build());
                    return this;
                }

                public Builder mergeRectangle(Rectangle value) {
                    copyOnWrite();
                    ((RoundedRectangle) this.instance).mergeRectangle(value);
                    return this;
                }

                public Builder clearRectangle() {
                    copyOnWrite();
                    ((RoundedRectangle) this.instance).clearRectangle();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
                public boolean hasCornerRadius() {
                    return ((RoundedRectangle) this.instance).hasCornerRadius();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
                public int getCornerRadius() {
                    return ((RoundedRectangle) this.instance).getCornerRadius();
                }

                public Builder setCornerRadius(int value) {
                    copyOnWrite();
                    ((RoundedRectangle) this.instance).setCornerRadius(value);
                    return this;
                }

                public Builder clearCornerRadius() {
                    copyOnWrite();
                    ((RoundedRectangle) this.instance).clearCornerRadius();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
                public boolean hasLineType() {
                    return ((RoundedRectangle) this.instance).hasLineType();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.RoundedRectangleOrBuilder
                public int getLineType() {
                    return ((RoundedRectangle) this.instance).getLineType();
                }

                public Builder setLineType(int value) {
                    copyOnWrite();
                    ((RoundedRectangle) this.instance).setLineType(value);
                    return this;
                }

                public Builder clearLineType() {
                    copyOnWrite();
                    ((RoundedRectangle) this.instance).clearLineType();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new RoundedRectangle();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"bitField0_", "rectangle_", "cornerRadius_", "lineType_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<RoundedRectangle> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (RoundedRectangle.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                RoundedRectangle roundedRectangle = new RoundedRectangle();
                DEFAULT_INSTANCE = roundedRectangle;
                GeneratedMessageLite.registerDefaultInstance(RoundedRectangle.class, roundedRectangle);
            }

            public static RoundedRectangle getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<RoundedRectangle> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class FilledRoundedRectangle extends GeneratedMessageLite<FilledRoundedRectangle, Builder> implements FilledRoundedRectangleOrBuilder {
            private static final FilledRoundedRectangle DEFAULT_INSTANCE;
            public static final int FILL_COLOR_FIELD_NUMBER = 2;
            private static volatile Parser<FilledRoundedRectangle> PARSER = null;
            public static final int ROUNDED_RECTANGLE_FIELD_NUMBER = 1;
            private int bitField0_;
            private ColorProto.Color fillColor_;
            private RoundedRectangle roundedRectangle_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private FilledRoundedRectangle() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRoundedRectangleOrBuilder
            public boolean hasRoundedRectangle() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRoundedRectangleOrBuilder
            public RoundedRectangle getRoundedRectangle() {
                RoundedRectangle roundedRectangle = this.roundedRectangle_;
                return roundedRectangle == null ? RoundedRectangle.getDefaultInstance() : roundedRectangle;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRoundedRectangle(RoundedRectangle value) {
                value.getClass();
                this.roundedRectangle_ = value;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeRoundedRectangle(RoundedRectangle value) {
                value.getClass();
                RoundedRectangle roundedRectangle = this.roundedRectangle_;
                if (roundedRectangle != null && roundedRectangle != RoundedRectangle.getDefaultInstance()) {
                    this.roundedRectangle_ = (RoundedRectangle) RoundedRectangle.newBuilder(this.roundedRectangle_).mergeFrom(value).buildPartial();
                } else {
                    this.roundedRectangle_ = value;
                }
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRoundedRectangle() {
                this.roundedRectangle_ = null;
                this.bitField0_ &= -2;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRoundedRectangleOrBuilder
            public boolean hasFillColor() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRoundedRectangleOrBuilder
            public ColorProto.Color getFillColor() {
                ColorProto.Color color = this.fillColor_;
                return color == null ? ColorProto.Color.getDefaultInstance() : color;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFillColor(ColorProto.Color value) {
                value.getClass();
                this.fillColor_ = value;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeFillColor(ColorProto.Color value) {
                value.getClass();
                ColorProto.Color color = this.fillColor_;
                if (color != null && color != ColorProto.Color.getDefaultInstance()) {
                    this.fillColor_ = (ColorProto.Color) ColorProto.Color.newBuilder(this.fillColor_).mergeFrom(value).buildPartial();
                } else {
                    this.fillColor_ = value;
                }
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFillColor() {
                this.fillColor_ = null;
                this.bitField0_ &= -3;
            }

            public static FilledRoundedRectangle parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledRoundedRectangle parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledRoundedRectangle parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledRoundedRectangle parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledRoundedRectangle parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledRoundedRectangle parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledRoundedRectangle parseFrom(InputStream input) throws IOException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledRoundedRectangle parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static FilledRoundedRectangle parseDelimitedFrom(InputStream input) throws IOException {
                return (FilledRoundedRectangle) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledRoundedRectangle parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledRoundedRectangle) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static FilledRoundedRectangle parseFrom(CodedInputStream input) throws IOException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledRoundedRectangle parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledRoundedRectangle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(FilledRoundedRectangle prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<FilledRoundedRectangle, Builder> implements FilledRoundedRectangleOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(FilledRoundedRectangle.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRoundedRectangleOrBuilder
                public boolean hasRoundedRectangle() {
                    return ((FilledRoundedRectangle) this.instance).hasRoundedRectangle();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRoundedRectangleOrBuilder
                public RoundedRectangle getRoundedRectangle() {
                    return ((FilledRoundedRectangle) this.instance).getRoundedRectangle();
                }

                public Builder setRoundedRectangle(RoundedRectangle value) {
                    copyOnWrite();
                    ((FilledRoundedRectangle) this.instance).setRoundedRectangle(value);
                    return this;
                }

                public Builder setRoundedRectangle(RoundedRectangle.Builder builderForValue) {
                    copyOnWrite();
                    ((FilledRoundedRectangle) this.instance).setRoundedRectangle((RoundedRectangle) builderForValue.build());
                    return this;
                }

                public Builder mergeRoundedRectangle(RoundedRectangle value) {
                    copyOnWrite();
                    ((FilledRoundedRectangle) this.instance).mergeRoundedRectangle(value);
                    return this;
                }

                public Builder clearRoundedRectangle() {
                    copyOnWrite();
                    ((FilledRoundedRectangle) this.instance).clearRoundedRectangle();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRoundedRectangleOrBuilder
                public boolean hasFillColor() {
                    return ((FilledRoundedRectangle) this.instance).hasFillColor();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledRoundedRectangleOrBuilder
                public ColorProto.Color getFillColor() {
                    return ((FilledRoundedRectangle) this.instance).getFillColor();
                }

                public Builder setFillColor(ColorProto.Color value) {
                    copyOnWrite();
                    ((FilledRoundedRectangle) this.instance).setFillColor(value);
                    return this;
                }

                public Builder setFillColor(ColorProto.Color.Builder builderForValue) {
                    copyOnWrite();
                    ((FilledRoundedRectangle) this.instance).setFillColor((ColorProto.Color) builderForValue.build());
                    return this;
                }

                public Builder mergeFillColor(ColorProto.Color value) {
                    copyOnWrite();
                    ((FilledRoundedRectangle) this.instance).mergeFillColor(value);
                    return this;
                }

                public Builder clearFillColor() {
                    copyOnWrite();
                    ((FilledRoundedRectangle) this.instance).clearFillColor();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new FilledRoundedRectangle();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "roundedRectangle_", "fillColor_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<FilledRoundedRectangle> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (FilledRoundedRectangle.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                FilledRoundedRectangle filledRoundedRectangle = new FilledRoundedRectangle();
                DEFAULT_INSTANCE = filledRoundedRectangle;
                GeneratedMessageLite.registerDefaultInstance(FilledRoundedRectangle.class, filledRoundedRectangle);
            }

            public static FilledRoundedRectangle getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<FilledRoundedRectangle> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Oval extends GeneratedMessageLite<Oval, Builder> implements OvalOrBuilder {
            private static final Oval DEFAULT_INSTANCE;
            private static volatile Parser<Oval> PARSER = null;
            public static final int RECTANGLE_FIELD_NUMBER = 1;
            private int bitField0_;
            private Rectangle rectangle_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private Oval() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.OvalOrBuilder
            public boolean hasRectangle() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.OvalOrBuilder
            public Rectangle getRectangle() {
                Rectangle rectangle = this.rectangle_;
                return rectangle == null ? Rectangle.getDefaultInstance() : rectangle;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRectangle(Rectangle value) {
                value.getClass();
                this.rectangle_ = value;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeRectangle(Rectangle value) {
                value.getClass();
                Rectangle rectangle = this.rectangle_;
                if (rectangle != null && rectangle != Rectangle.getDefaultInstance()) {
                    this.rectangle_ = (Rectangle) Rectangle.newBuilder(this.rectangle_).mergeFrom(value).buildPartial();
                } else {
                    this.rectangle_ = value;
                }
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRectangle() {
                this.rectangle_ = null;
                this.bitField0_ &= -2;
            }

            public static Oval parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Oval parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Oval parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Oval parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Oval parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Oval parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Oval parseFrom(InputStream input) throws IOException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Oval parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Oval parseDelimitedFrom(InputStream input) throws IOException {
                return (Oval) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Oval parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Oval) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Oval parseFrom(CodedInputStream input) throws IOException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Oval parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Oval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Oval prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Oval, Builder> implements OvalOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(Oval.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.OvalOrBuilder
                public boolean hasRectangle() {
                    return ((Oval) this.instance).hasRectangle();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.OvalOrBuilder
                public Rectangle getRectangle() {
                    return ((Oval) this.instance).getRectangle();
                }

                public Builder setRectangle(Rectangle value) {
                    copyOnWrite();
                    ((Oval) this.instance).setRectangle(value);
                    return this;
                }

                public Builder setRectangle(Rectangle.Builder builderForValue) {
                    copyOnWrite();
                    ((Oval) this.instance).setRectangle((Rectangle) builderForValue.build());
                    return this;
                }

                public Builder mergeRectangle(Rectangle value) {
                    copyOnWrite();
                    ((Oval) this.instance).mergeRectangle(value);
                    return this;
                }

                public Builder clearRectangle() {
                    copyOnWrite();
                    ((Oval) this.instance).clearRectangle();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new Oval();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "rectangle_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Oval> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Oval.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Oval oval = new Oval();
                DEFAULT_INSTANCE = oval;
                GeneratedMessageLite.registerDefaultInstance(Oval.class, oval);
            }

            public static Oval getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Oval> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class FilledOval extends GeneratedMessageLite<FilledOval, Builder> implements FilledOvalOrBuilder {
            private static final FilledOval DEFAULT_INSTANCE;
            public static final int FILL_COLOR_FIELD_NUMBER = 2;
            public static final int OVAL_FIELD_NUMBER = 1;
            private static volatile Parser<FilledOval> PARSER;
            private int bitField0_;
            private ColorProto.Color fillColor_;
            private Oval oval_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private FilledOval() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledOvalOrBuilder
            public boolean hasOval() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledOvalOrBuilder
            public Oval getOval() {
                Oval oval = this.oval_;
                return oval == null ? Oval.getDefaultInstance() : oval;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOval(Oval value) {
                value.getClass();
                this.oval_ = value;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeOval(Oval value) {
                value.getClass();
                Oval oval = this.oval_;
                if (oval != null && oval != Oval.getDefaultInstance()) {
                    this.oval_ = (Oval) Oval.newBuilder(this.oval_).mergeFrom(value).buildPartial();
                } else {
                    this.oval_ = value;
                }
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOval() {
                this.oval_ = null;
                this.bitField0_ &= -2;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledOvalOrBuilder
            public boolean hasFillColor() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledOvalOrBuilder
            public ColorProto.Color getFillColor() {
                ColorProto.Color color = this.fillColor_;
                return color == null ? ColorProto.Color.getDefaultInstance() : color;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFillColor(ColorProto.Color value) {
                value.getClass();
                this.fillColor_ = value;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeFillColor(ColorProto.Color value) {
                value.getClass();
                ColorProto.Color color = this.fillColor_;
                if (color != null && color != ColorProto.Color.getDefaultInstance()) {
                    this.fillColor_ = (ColorProto.Color) ColorProto.Color.newBuilder(this.fillColor_).mergeFrom(value).buildPartial();
                } else {
                    this.fillColor_ = value;
                }
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFillColor() {
                this.fillColor_ = null;
                this.bitField0_ &= -3;
            }

            public static FilledOval parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledOval parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledOval parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledOval parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledOval parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FilledOval parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FilledOval parseFrom(InputStream input) throws IOException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledOval parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static FilledOval parseDelimitedFrom(InputStream input) throws IOException {
                return (FilledOval) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledOval parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledOval) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static FilledOval parseFrom(CodedInputStream input) throws IOException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static FilledOval parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FilledOval) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(FilledOval prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<FilledOval, Builder> implements FilledOvalOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(FilledOval.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledOvalOrBuilder
                public boolean hasOval() {
                    return ((FilledOval) this.instance).hasOval();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledOvalOrBuilder
                public Oval getOval() {
                    return ((FilledOval) this.instance).getOval();
                }

                public Builder setOval(Oval value) {
                    copyOnWrite();
                    ((FilledOval) this.instance).setOval(value);
                    return this;
                }

                public Builder setOval(Oval.Builder builderForValue) {
                    copyOnWrite();
                    ((FilledOval) this.instance).setOval((Oval) builderForValue.build());
                    return this;
                }

                public Builder mergeOval(Oval value) {
                    copyOnWrite();
                    ((FilledOval) this.instance).mergeOval(value);
                    return this;
                }

                public Builder clearOval() {
                    copyOnWrite();
                    ((FilledOval) this.instance).clearOval();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledOvalOrBuilder
                public boolean hasFillColor() {
                    return ((FilledOval) this.instance).hasFillColor();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.FilledOvalOrBuilder
                public ColorProto.Color getFillColor() {
                    return ((FilledOval) this.instance).getFillColor();
                }

                public Builder setFillColor(ColorProto.Color value) {
                    copyOnWrite();
                    ((FilledOval) this.instance).setFillColor(value);
                    return this;
                }

                public Builder setFillColor(ColorProto.Color.Builder builderForValue) {
                    copyOnWrite();
                    ((FilledOval) this.instance).setFillColor((ColorProto.Color) builderForValue.build());
                    return this;
                }

                public Builder mergeFillColor(ColorProto.Color value) {
                    copyOnWrite();
                    ((FilledOval) this.instance).mergeFillColor(value);
                    return this;
                }

                public Builder clearFillColor() {
                    copyOnWrite();
                    ((FilledOval) this.instance).clearFillColor();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new FilledOval();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "oval_", "fillColor_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<FilledOval> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (FilledOval.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                FilledOval filledOval = new FilledOval();
                DEFAULT_INSTANCE = filledOval;
                GeneratedMessageLite.registerDefaultInstance(FilledOval.class, filledOval);
            }

            public static FilledOval getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<FilledOval> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Point extends GeneratedMessageLite<Point, Builder> implements PointOrBuilder {
            private static final Point DEFAULT_INSTANCE;
            public static final int NORMALIZED_FIELD_NUMBER = 3;
            private static volatile Parser<Point> PARSER = null;
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            private int bitField0_;
            private boolean normalized_;
            private double x_;
            private double y_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private Point() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
            public boolean hasX() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
            public double getX() {
                return this.x_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setX(double value) {
                this.bitField0_ |= 1;
                this.x_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearX() {
                this.bitField0_ &= -2;
                this.x_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
            public boolean hasY() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
            public double getY() {
                return this.y_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setY(double value) {
                this.bitField0_ |= 2;
                this.y_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearY() {
                this.bitField0_ &= -3;
                this.y_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
            public boolean hasNormalized() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
            public boolean getNormalized() {
                return this.normalized_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNormalized(boolean value) {
                this.bitField0_ |= 4;
                this.normalized_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNormalized() {
                this.bitField0_ &= -5;
                this.normalized_ = false;
            }

            public static Point parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Point parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Point parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Point parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Point parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Point parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Point parseFrom(InputStream input) throws IOException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Point parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Point parseDelimitedFrom(InputStream input) throws IOException {
                return (Point) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Point parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Point) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Point parseFrom(CodedInputStream input) throws IOException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Point parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Point prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Point, Builder> implements PointOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(Point.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
                public boolean hasX() {
                    return ((Point) this.instance).hasX();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
                public double getX() {
                    return ((Point) this.instance).getX();
                }

                public Builder setX(double value) {
                    copyOnWrite();
                    ((Point) this.instance).setX(value);
                    return this;
                }

                public Builder clearX() {
                    copyOnWrite();
                    ((Point) this.instance).clearX();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
                public boolean hasY() {
                    return ((Point) this.instance).hasY();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
                public double getY() {
                    return ((Point) this.instance).getY();
                }

                public Builder setY(double value) {
                    copyOnWrite();
                    ((Point) this.instance).setY(value);
                    return this;
                }

                public Builder clearY() {
                    copyOnWrite();
                    ((Point) this.instance).clearY();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
                public boolean hasNormalized() {
                    return ((Point) this.instance).hasNormalized();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.PointOrBuilder
                public boolean getNormalized() {
                    return ((Point) this.instance).getNormalized();
                }

                public Builder setNormalized(boolean value) {
                    copyOnWrite();
                    ((Point) this.instance).setNormalized(value);
                    return this;
                }

                public Builder clearNormalized() {
                    copyOnWrite();
                    ((Point) this.instance).clearNormalized();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new Point();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003ဇ\u0002", new Object[]{"bitField0_", "x_", "y_", "normalized_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Point> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Point.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Point point = new Point();
                DEFAULT_INSTANCE = point;
                GeneratedMessageLite.registerDefaultInstance(Point.class, point);
            }

            public static Point getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Point> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Line extends GeneratedMessageLite<Line, Builder> implements LineOrBuilder {
            private static final Line DEFAULT_INSTANCE;
            public static final int LINE_TYPE_FIELD_NUMBER = 6;
            public static final int NORMALIZED_FIELD_NUMBER = 5;
            private static volatile Parser<Line> PARSER = null;
            public static final int X_END_FIELD_NUMBER = 3;
            public static final int X_START_FIELD_NUMBER = 1;
            public static final int Y_END_FIELD_NUMBER = 4;
            public static final int Y_START_FIELD_NUMBER = 2;
            private int bitField0_;
            private int lineType_ = 1;
            private boolean normalized_;
            private double xEnd_;
            private double xStart_;
            private double yEnd_;
            private double yStart_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private Line() {
            }

            public enum LineType implements Internal.EnumLite {
                UNKNOWN(0),
                SOLID(1),
                DASHED(2);

                public static final int DASHED_VALUE = 2;
                public static final int SOLID_VALUE = 1;
                public static final int UNKNOWN_VALUE = 0;
                private static final Internal.EnumLiteMap<LineType> internalValueMap = new Internal.EnumLiteMap<LineType>() { // from class: com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.Line.LineType.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public LineType findValueByNumber(int number) {
                        return LineType.forNumber(number);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static LineType valueOf(int value) {
                    return forNumber(value);
                }

                public static LineType forNumber(int value) {
                    if (value == 0) {
                        return UNKNOWN;
                    }
                    if (value == 1) {
                        return SOLID;
                    }
                    if (value != 2) {
                        return null;
                    }
                    return DASHED;
                }

                public static Internal.EnumLiteMap<LineType> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return LineTypeVerifier.INSTANCE;
                }

                private static final class LineTypeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new LineTypeVerifier();

                    private LineTypeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int number) {
                        return LineType.forNumber(number) != null;
                    }
                }

                LineType(int value) {
                    this.value = value;
                }
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public boolean hasXStart() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public double getXStart() {
                return this.xStart_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXStart(double value) {
                this.bitField0_ |= 1;
                this.xStart_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXStart() {
                this.bitField0_ &= -2;
                this.xStart_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public boolean hasYStart() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public double getYStart() {
                return this.yStart_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYStart(double value) {
                this.bitField0_ |= 2;
                this.yStart_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYStart() {
                this.bitField0_ &= -3;
                this.yStart_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public boolean hasXEnd() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public double getXEnd() {
                return this.xEnd_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXEnd(double value) {
                this.bitField0_ |= 4;
                this.xEnd_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXEnd() {
                this.bitField0_ &= -5;
                this.xEnd_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public boolean hasYEnd() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public double getYEnd() {
                return this.yEnd_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYEnd(double value) {
                this.bitField0_ |= 8;
                this.yEnd_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYEnd() {
                this.bitField0_ &= -9;
                this.yEnd_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public boolean hasNormalized() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public boolean getNormalized() {
                return this.normalized_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNormalized(boolean value) {
                this.bitField0_ |= 16;
                this.normalized_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNormalized() {
                this.bitField0_ &= -17;
                this.normalized_ = false;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public boolean hasLineType() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
            public LineType getLineType() {
                LineType lineTypeForNumber = LineType.forNumber(this.lineType_);
                return lineTypeForNumber == null ? LineType.SOLID : lineTypeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLineType(LineType value) {
                this.lineType_ = value.getNumber();
                this.bitField0_ |= 32;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLineType() {
                this.bitField0_ &= -33;
                this.lineType_ = 1;
            }

            public static Line parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Line parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Line parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Line parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Line parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Line parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Line parseFrom(InputStream input) throws IOException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Line parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Line parseDelimitedFrom(InputStream input) throws IOException {
                return (Line) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Line parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Line) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Line parseFrom(CodedInputStream input) throws IOException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Line parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Line) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Line prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Line, Builder> implements LineOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(Line.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public boolean hasXStart() {
                    return ((Line) this.instance).hasXStart();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public double getXStart() {
                    return ((Line) this.instance).getXStart();
                }

                public Builder setXStart(double value) {
                    copyOnWrite();
                    ((Line) this.instance).setXStart(value);
                    return this;
                }

                public Builder clearXStart() {
                    copyOnWrite();
                    ((Line) this.instance).clearXStart();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public boolean hasYStart() {
                    return ((Line) this.instance).hasYStart();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public double getYStart() {
                    return ((Line) this.instance).getYStart();
                }

                public Builder setYStart(double value) {
                    copyOnWrite();
                    ((Line) this.instance).setYStart(value);
                    return this;
                }

                public Builder clearYStart() {
                    copyOnWrite();
                    ((Line) this.instance).clearYStart();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public boolean hasXEnd() {
                    return ((Line) this.instance).hasXEnd();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public double getXEnd() {
                    return ((Line) this.instance).getXEnd();
                }

                public Builder setXEnd(double value) {
                    copyOnWrite();
                    ((Line) this.instance).setXEnd(value);
                    return this;
                }

                public Builder clearXEnd() {
                    copyOnWrite();
                    ((Line) this.instance).clearXEnd();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public boolean hasYEnd() {
                    return ((Line) this.instance).hasYEnd();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public double getYEnd() {
                    return ((Line) this.instance).getYEnd();
                }

                public Builder setYEnd(double value) {
                    copyOnWrite();
                    ((Line) this.instance).setYEnd(value);
                    return this;
                }

                public Builder clearYEnd() {
                    copyOnWrite();
                    ((Line) this.instance).clearYEnd();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public boolean hasNormalized() {
                    return ((Line) this.instance).hasNormalized();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public boolean getNormalized() {
                    return ((Line) this.instance).getNormalized();
                }

                public Builder setNormalized(boolean value) {
                    copyOnWrite();
                    ((Line) this.instance).setNormalized(value);
                    return this;
                }

                public Builder clearNormalized() {
                    copyOnWrite();
                    ((Line) this.instance).clearNormalized();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public boolean hasLineType() {
                    return ((Line) this.instance).hasLineType();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.LineOrBuilder
                public LineType getLineType() {
                    return ((Line) this.instance).getLineType();
                }

                public Builder setLineType(LineType value) {
                    copyOnWrite();
                    ((Line) this.instance).setLineType(value);
                    return this;
                }

                public Builder clearLineType() {
                    copyOnWrite();
                    ((Line) this.instance).clearLineType();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new Line();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005ဇ\u0004\u0006᠌\u0005", new Object[]{"bitField0_", "xStart_", "yStart_", "xEnd_", "yEnd_", "normalized_", "lineType_", LineType.internalGetVerifier()});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Line> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Line.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Line line = new Line();
                DEFAULT_INSTANCE = line;
                GeneratedMessageLite.registerDefaultInstance(Line.class, line);
            }

            public static Line getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Line> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class GradientLine extends GeneratedMessageLite<GradientLine, Builder> implements GradientLineOrBuilder {
            public static final int COLOR1_FIELD_NUMBER = 6;
            public static final int COLOR2_FIELD_NUMBER = 7;
            private static final GradientLine DEFAULT_INSTANCE;
            public static final int NORMALIZED_FIELD_NUMBER = 5;
            private static volatile Parser<GradientLine> PARSER = null;
            public static final int X_END_FIELD_NUMBER = 3;
            public static final int X_START_FIELD_NUMBER = 1;
            public static final int Y_END_FIELD_NUMBER = 4;
            public static final int Y_START_FIELD_NUMBER = 2;
            private int bitField0_;
            private ColorProto.Color color1_;
            private ColorProto.Color color2_;
            private boolean normalized_;
            private double xEnd_;
            private double xStart_;
            private double yEnd_;
            private double yStart_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private GradientLine() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public boolean hasXStart() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public double getXStart() {
                return this.xStart_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXStart(double value) {
                this.bitField0_ |= 1;
                this.xStart_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXStart() {
                this.bitField0_ &= -2;
                this.xStart_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public boolean hasYStart() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public double getYStart() {
                return this.yStart_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYStart(double value) {
                this.bitField0_ |= 2;
                this.yStart_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYStart() {
                this.bitField0_ &= -3;
                this.yStart_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public boolean hasXEnd() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public double getXEnd() {
                return this.xEnd_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXEnd(double value) {
                this.bitField0_ |= 4;
                this.xEnd_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXEnd() {
                this.bitField0_ &= -5;
                this.xEnd_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public boolean hasYEnd() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public double getYEnd() {
                return this.yEnd_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYEnd(double value) {
                this.bitField0_ |= 8;
                this.yEnd_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYEnd() {
                this.bitField0_ &= -9;
                this.yEnd_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public boolean hasNormalized() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public boolean getNormalized() {
                return this.normalized_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNormalized(boolean value) {
                this.bitField0_ |= 16;
                this.normalized_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNormalized() {
                this.bitField0_ &= -17;
                this.normalized_ = false;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public boolean hasColor1() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public ColorProto.Color getColor1() {
                ColorProto.Color color = this.color1_;
                return color == null ? ColorProto.Color.getDefaultInstance() : color;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setColor1(ColorProto.Color value) {
                value.getClass();
                this.color1_ = value;
                this.bitField0_ |= 32;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeColor1(ColorProto.Color value) {
                value.getClass();
                ColorProto.Color color = this.color1_;
                if (color != null && color != ColorProto.Color.getDefaultInstance()) {
                    this.color1_ = (ColorProto.Color) ColorProto.Color.newBuilder(this.color1_).mergeFrom(value).buildPartial();
                } else {
                    this.color1_ = value;
                }
                this.bitField0_ |= 32;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearColor1() {
                this.color1_ = null;
                this.bitField0_ &= -33;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public boolean hasColor2() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
            public ColorProto.Color getColor2() {
                ColorProto.Color color = this.color2_;
                return color == null ? ColorProto.Color.getDefaultInstance() : color;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setColor2(ColorProto.Color value) {
                value.getClass();
                this.color2_ = value;
                this.bitField0_ |= 64;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeColor2(ColorProto.Color value) {
                value.getClass();
                ColorProto.Color color = this.color2_;
                if (color != null && color != ColorProto.Color.getDefaultInstance()) {
                    this.color2_ = (ColorProto.Color) ColorProto.Color.newBuilder(this.color2_).mergeFrom(value).buildPartial();
                } else {
                    this.color2_ = value;
                }
                this.bitField0_ |= 64;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearColor2() {
                this.color2_ = null;
                this.bitField0_ &= -65;
            }

            public static GradientLine parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static GradientLine parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static GradientLine parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static GradientLine parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static GradientLine parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static GradientLine parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static GradientLine parseFrom(InputStream input) throws IOException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static GradientLine parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static GradientLine parseDelimitedFrom(InputStream input) throws IOException {
                return (GradientLine) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static GradientLine parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (GradientLine) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static GradientLine parseFrom(CodedInputStream input) throws IOException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static GradientLine parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (GradientLine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(GradientLine prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<GradientLine, Builder> implements GradientLineOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(GradientLine.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public boolean hasXStart() {
                    return ((GradientLine) this.instance).hasXStart();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public double getXStart() {
                    return ((GradientLine) this.instance).getXStart();
                }

                public Builder setXStart(double value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setXStart(value);
                    return this;
                }

                public Builder clearXStart() {
                    copyOnWrite();
                    ((GradientLine) this.instance).clearXStart();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public boolean hasYStart() {
                    return ((GradientLine) this.instance).hasYStart();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public double getYStart() {
                    return ((GradientLine) this.instance).getYStart();
                }

                public Builder setYStart(double value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setYStart(value);
                    return this;
                }

                public Builder clearYStart() {
                    copyOnWrite();
                    ((GradientLine) this.instance).clearYStart();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public boolean hasXEnd() {
                    return ((GradientLine) this.instance).hasXEnd();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public double getXEnd() {
                    return ((GradientLine) this.instance).getXEnd();
                }

                public Builder setXEnd(double value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setXEnd(value);
                    return this;
                }

                public Builder clearXEnd() {
                    copyOnWrite();
                    ((GradientLine) this.instance).clearXEnd();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public boolean hasYEnd() {
                    return ((GradientLine) this.instance).hasYEnd();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public double getYEnd() {
                    return ((GradientLine) this.instance).getYEnd();
                }

                public Builder setYEnd(double value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setYEnd(value);
                    return this;
                }

                public Builder clearYEnd() {
                    copyOnWrite();
                    ((GradientLine) this.instance).clearYEnd();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public boolean hasNormalized() {
                    return ((GradientLine) this.instance).hasNormalized();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public boolean getNormalized() {
                    return ((GradientLine) this.instance).getNormalized();
                }

                public Builder setNormalized(boolean value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setNormalized(value);
                    return this;
                }

                public Builder clearNormalized() {
                    copyOnWrite();
                    ((GradientLine) this.instance).clearNormalized();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public boolean hasColor1() {
                    return ((GradientLine) this.instance).hasColor1();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public ColorProto.Color getColor1() {
                    return ((GradientLine) this.instance).getColor1();
                }

                public Builder setColor1(ColorProto.Color value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setColor1(value);
                    return this;
                }

                public Builder setColor1(ColorProto.Color.Builder builderForValue) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setColor1((ColorProto.Color) builderForValue.build());
                    return this;
                }

                public Builder mergeColor1(ColorProto.Color value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).mergeColor1(value);
                    return this;
                }

                public Builder clearColor1() {
                    copyOnWrite();
                    ((GradientLine) this.instance).clearColor1();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public boolean hasColor2() {
                    return ((GradientLine) this.instance).hasColor2();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.GradientLineOrBuilder
                public ColorProto.Color getColor2() {
                    return ((GradientLine) this.instance).getColor2();
                }

                public Builder setColor2(ColorProto.Color value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setColor2(value);
                    return this;
                }

                public Builder setColor2(ColorProto.Color.Builder builderForValue) {
                    copyOnWrite();
                    ((GradientLine) this.instance).setColor2((ColorProto.Color) builderForValue.build());
                    return this;
                }

                public Builder mergeColor2(ColorProto.Color value) {
                    copyOnWrite();
                    ((GradientLine) this.instance).mergeColor2(value);
                    return this;
                }

                public Builder clearColor2() {
                    copyOnWrite();
                    ((GradientLine) this.instance).clearColor2();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new GradientLine();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005ဇ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"bitField0_", "xStart_", "yStart_", "xEnd_", "yEnd_", "normalized_", "color1_", "color2_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<GradientLine> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (GradientLine.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                GradientLine gradientLine = new GradientLine();
                DEFAULT_INSTANCE = gradientLine;
                GeneratedMessageLite.registerDefaultInstance(GradientLine.class, gradientLine);
            }

            public static GradientLine getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<GradientLine> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Scribble extends GeneratedMessageLite<Scribble, Builder> implements ScribbleOrBuilder {
            private static final Scribble DEFAULT_INSTANCE;
            private static volatile Parser<Scribble> PARSER = null;
            public static final int POINT_FIELD_NUMBER = 1;
            private Internal.ProtobufList<Point> point_ = emptyProtobufList();

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private Scribble() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ScribbleOrBuilder
            public List<Point> getPointList() {
                return this.point_;
            }

            public List<? extends PointOrBuilder> getPointOrBuilderList() {
                return this.point_;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ScribbleOrBuilder
            public int getPointCount() {
                return this.point_.size();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ScribbleOrBuilder
            public Point getPoint(int index) {
                return this.point_.get(index);
            }

            public PointOrBuilder getPointOrBuilder(int index) {
                return this.point_.get(index);
            }

            private void ensurePointIsMutable() {
                Internal.ProtobufList<Point> protobufList = this.point_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.point_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPoint(int index, Point value) {
                value.getClass();
                ensurePointIsMutable();
                this.point_.set(index, value);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addPoint(Point value) {
                value.getClass();
                ensurePointIsMutable();
                this.point_.add(value);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addPoint(int index, Point value) {
                value.getClass();
                ensurePointIsMutable();
                this.point_.add(index, value);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllPoint(Iterable<? extends Point> values) {
                ensurePointIsMutable();
                AbstractMessageLite.addAll(values, this.point_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPoint() {
                this.point_ = emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removePoint(int index) {
                ensurePointIsMutable();
                this.point_.remove(index);
            }

            public static Scribble parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Scribble parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Scribble parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Scribble parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Scribble parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Scribble parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Scribble parseFrom(InputStream input) throws IOException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Scribble parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Scribble parseDelimitedFrom(InputStream input) throws IOException {
                return (Scribble) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Scribble parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Scribble) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Scribble parseFrom(CodedInputStream input) throws IOException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Scribble parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Scribble prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Scribble, Builder> implements ScribbleOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(Scribble.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ScribbleOrBuilder
                public List<Point> getPointList() {
                    return Collections.unmodifiableList(((Scribble) this.instance).getPointList());
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ScribbleOrBuilder
                public int getPointCount() {
                    return ((Scribble) this.instance).getPointCount();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ScribbleOrBuilder
                public Point getPoint(int index) {
                    return ((Scribble) this.instance).getPoint(index);
                }

                public Builder setPoint(int index, Point value) {
                    copyOnWrite();
                    ((Scribble) this.instance).setPoint(index, value);
                    return this;
                }

                public Builder setPoint(int index, Point.Builder builderForValue) {
                    copyOnWrite();
                    ((Scribble) this.instance).setPoint(index, (Point) builderForValue.build());
                    return this;
                }

                public Builder addPoint(Point value) {
                    copyOnWrite();
                    ((Scribble) this.instance).addPoint(value);
                    return this;
                }

                public Builder addPoint(int index, Point value) {
                    copyOnWrite();
                    ((Scribble) this.instance).addPoint(index, value);
                    return this;
                }

                public Builder addPoint(Point.Builder builderForValue) {
                    copyOnWrite();
                    ((Scribble) this.instance).addPoint((Point) builderForValue.build());
                    return this;
                }

                public Builder addPoint(int index, Point.Builder builderForValue) {
                    copyOnWrite();
                    ((Scribble) this.instance).addPoint(index, (Point) builderForValue.build());
                    return this;
                }

                public Builder addAllPoint(Iterable<? extends Point> values) {
                    copyOnWrite();
                    ((Scribble) this.instance).addAllPoint(values);
                    return this;
                }

                public Builder clearPoint() {
                    copyOnWrite();
                    ((Scribble) this.instance).clearPoint();
                    return this;
                }

                public Builder removePoint(int index) {
                    copyOnWrite();
                    ((Scribble) this.instance).removePoint(index);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new Scribble();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"point_", Point.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Scribble> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Scribble.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Scribble scribble = new Scribble();
                DEFAULT_INSTANCE = scribble;
                GeneratedMessageLite.registerDefaultInstance(Scribble.class, scribble);
            }

            public static Scribble getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Scribble> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Arrow extends GeneratedMessageLite<Arrow, Builder> implements ArrowOrBuilder {
            private static final Arrow DEFAULT_INSTANCE;
            public static final int NORMALIZED_FIELD_NUMBER = 5;
            private static volatile Parser<Arrow> PARSER = null;
            public static final int X_END_FIELD_NUMBER = 3;
            public static final int X_START_FIELD_NUMBER = 1;
            public static final int Y_END_FIELD_NUMBER = 4;
            public static final int Y_START_FIELD_NUMBER = 2;
            private int bitField0_;
            private boolean normalized_;
            private double xEnd_;
            private double xStart_;
            private double yEnd_;
            private double yStart_;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private Arrow() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public boolean hasXStart() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public double getXStart() {
                return this.xStart_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXStart(double value) {
                this.bitField0_ |= 1;
                this.xStart_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXStart() {
                this.bitField0_ &= -2;
                this.xStart_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public boolean hasYStart() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public double getYStart() {
                return this.yStart_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYStart(double value) {
                this.bitField0_ |= 2;
                this.yStart_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYStart() {
                this.bitField0_ &= -3;
                this.yStart_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public boolean hasXEnd() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public double getXEnd() {
                return this.xEnd_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXEnd(double value) {
                this.bitField0_ |= 4;
                this.xEnd_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXEnd() {
                this.bitField0_ &= -5;
                this.xEnd_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public boolean hasYEnd() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public double getYEnd() {
                return this.yEnd_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYEnd(double value) {
                this.bitField0_ |= 8;
                this.yEnd_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYEnd() {
                this.bitField0_ &= -9;
                this.yEnd_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public boolean hasNormalized() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
            public boolean getNormalized() {
                return this.normalized_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNormalized(boolean value) {
                this.bitField0_ |= 16;
                this.normalized_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNormalized() {
                this.bitField0_ &= -17;
                this.normalized_ = false;
            }

            public static Arrow parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Arrow parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Arrow parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Arrow parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Arrow parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Arrow parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Arrow parseFrom(InputStream input) throws IOException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Arrow parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Arrow parseDelimitedFrom(InputStream input) throws IOException {
                return (Arrow) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Arrow parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Arrow) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Arrow parseFrom(CodedInputStream input) throws IOException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Arrow parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Arrow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Arrow prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Arrow, Builder> implements ArrowOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(Arrow.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public boolean hasXStart() {
                    return ((Arrow) this.instance).hasXStart();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public double getXStart() {
                    return ((Arrow) this.instance).getXStart();
                }

                public Builder setXStart(double value) {
                    copyOnWrite();
                    ((Arrow) this.instance).setXStart(value);
                    return this;
                }

                public Builder clearXStart() {
                    copyOnWrite();
                    ((Arrow) this.instance).clearXStart();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public boolean hasYStart() {
                    return ((Arrow) this.instance).hasYStart();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public double getYStart() {
                    return ((Arrow) this.instance).getYStart();
                }

                public Builder setYStart(double value) {
                    copyOnWrite();
                    ((Arrow) this.instance).setYStart(value);
                    return this;
                }

                public Builder clearYStart() {
                    copyOnWrite();
                    ((Arrow) this.instance).clearYStart();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public boolean hasXEnd() {
                    return ((Arrow) this.instance).hasXEnd();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public double getXEnd() {
                    return ((Arrow) this.instance).getXEnd();
                }

                public Builder setXEnd(double value) {
                    copyOnWrite();
                    ((Arrow) this.instance).setXEnd(value);
                    return this;
                }

                public Builder clearXEnd() {
                    copyOnWrite();
                    ((Arrow) this.instance).clearXEnd();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public boolean hasYEnd() {
                    return ((Arrow) this.instance).hasYEnd();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public double getYEnd() {
                    return ((Arrow) this.instance).getYEnd();
                }

                public Builder setYEnd(double value) {
                    copyOnWrite();
                    ((Arrow) this.instance).setYEnd(value);
                    return this;
                }

                public Builder clearYEnd() {
                    copyOnWrite();
                    ((Arrow) this.instance).clearYEnd();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public boolean hasNormalized() {
                    return ((Arrow) this.instance).hasNormalized();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.ArrowOrBuilder
                public boolean getNormalized() {
                    return ((Arrow) this.instance).getNormalized();
                }

                public Builder setNormalized(boolean value) {
                    copyOnWrite();
                    ((Arrow) this.instance).setNormalized(value);
                    return this;
                }

                public Builder clearNormalized() {
                    copyOnWrite();
                    ((Arrow) this.instance).clearNormalized();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new Arrow();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005ဇ\u0004", new Object[]{"bitField0_", "xStart_", "yStart_", "xEnd_", "yEnd_", "normalized_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Arrow> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Arrow.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Arrow arrow = new Arrow();
                DEFAULT_INSTANCE = arrow;
                GeneratedMessageLite.registerDefaultInstance(Arrow.class, arrow);
            }

            public static Arrow getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Arrow> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Text extends GeneratedMessageLite<Text, Builder> implements TextOrBuilder {
            public static final int BASELINE_FIELD_NUMBER = 3;
            public static final int CENTER_HORIZONTALLY_FIELD_NUMBER = 7;
            public static final int CENTER_VERTICALLY_FIELD_NUMBER = 8;
            private static final Text DEFAULT_INSTANCE;
            public static final int DISPLAY_TEXT_FIELD_NUMBER = 1;
            public static final int FONT_FACE_FIELD_NUMBER = 6;
            public static final int FONT_HEIGHT_FIELD_NUMBER = 4;
            public static final int LEFT_FIELD_NUMBER = 2;
            public static final int NORMALIZED_FIELD_NUMBER = 5;
            public static final int OUTLINE_COLOR_FIELD_NUMBER = 12;
            public static final int OUTLINE_THICKNESS_FIELD_NUMBER = 11;
            private static volatile Parser<Text> PARSER;
            private double baseline_;
            private int bitField0_;
            private boolean centerHorizontally_;
            private boolean centerVertically_;
            private int fontFace_;
            private double left_;
            private boolean normalized_;
            private ColorProto.Color outlineColor_;
            private double outlineThickness_;
            private String displayText_ = "";
            private double fontHeight_ = 8.0d;

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private Text() {
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasDisplayText() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public String getDisplayText() {
                return this.displayText_;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public ByteString getDisplayTextBytes() {
                return ByteString.copyFromUtf8(this.displayText_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDisplayText(String value) {
                value.getClass();
                this.bitField0_ |= 1;
                this.displayText_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDisplayText() {
                this.bitField0_ &= -2;
                this.displayText_ = getDefaultInstance().getDisplayText();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDisplayTextBytes(ByteString value) {
                this.displayText_ = value.toStringUtf8();
                this.bitField0_ |= 1;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasLeft() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public double getLeft() {
                return this.left_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLeft(double value) {
                this.bitField0_ |= 2;
                this.left_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLeft() {
                this.bitField0_ &= -3;
                this.left_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasBaseline() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public double getBaseline() {
                return this.baseline_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBaseline(double value) {
                this.bitField0_ |= 4;
                this.baseline_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBaseline() {
                this.bitField0_ &= -5;
                this.baseline_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasFontHeight() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public double getFontHeight() {
                return this.fontHeight_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFontHeight(double value) {
                this.bitField0_ |= 8;
                this.fontHeight_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFontHeight() {
                this.bitField0_ &= -9;
                this.fontHeight_ = 8.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasNormalized() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean getNormalized() {
                return this.normalized_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNormalized(boolean value) {
                this.bitField0_ |= 16;
                this.normalized_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNormalized() {
                this.bitField0_ &= -17;
                this.normalized_ = false;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasFontFace() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public int getFontFace() {
                return this.fontFace_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFontFace(int value) {
                this.bitField0_ |= 32;
                this.fontFace_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFontFace() {
                this.bitField0_ &= -33;
                this.fontFace_ = 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasCenterHorizontally() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean getCenterHorizontally() {
                return this.centerHorizontally_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCenterHorizontally(boolean value) {
                this.bitField0_ |= 64;
                this.centerHorizontally_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCenterHorizontally() {
                this.bitField0_ &= -65;
                this.centerHorizontally_ = false;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasCenterVertically() {
                return (this.bitField0_ & 128) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean getCenterVertically() {
                return this.centerVertically_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCenterVertically(boolean value) {
                this.bitField0_ |= 128;
                this.centerVertically_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCenterVertically() {
                this.bitField0_ &= -129;
                this.centerVertically_ = false;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasOutlineThickness() {
                return (this.bitField0_ & 256) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public double getOutlineThickness() {
                return this.outlineThickness_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOutlineThickness(double value) {
                this.bitField0_ |= 256;
                this.outlineThickness_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOutlineThickness() {
                this.bitField0_ &= -257;
                this.outlineThickness_ = 0.0d;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public boolean hasOutlineColor() {
                return (this.bitField0_ & 512) != 0;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
            public ColorProto.Color getOutlineColor() {
                ColorProto.Color color = this.outlineColor_;
                return color == null ? ColorProto.Color.getDefaultInstance() : color;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOutlineColor(ColorProto.Color value) {
                value.getClass();
                this.outlineColor_ = value;
                this.bitField0_ |= 512;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeOutlineColor(ColorProto.Color value) {
                value.getClass();
                ColorProto.Color color = this.outlineColor_;
                if (color != null && color != ColorProto.Color.getDefaultInstance()) {
                    this.outlineColor_ = (ColorProto.Color) ColorProto.Color.newBuilder(this.outlineColor_).mergeFrom(value).buildPartial();
                } else {
                    this.outlineColor_ = value;
                }
                this.bitField0_ |= 512;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOutlineColor() {
                this.outlineColor_ = null;
                this.bitField0_ &= -513;
            }

            public static Text parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Text parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Text parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Text parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Text parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static Text parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static Text parseFrom(InputStream input) throws IOException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Text parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Text parseDelimitedFrom(InputStream input) throws IOException {
                return (Text) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static Text parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Text) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Text parseFrom(CodedInputStream input) throws IOException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static Text parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (Text) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Text prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Text, Builder> implements TextOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                    return super.mo2196clone();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                    return super.internalMergeFrom((GeneratedMessageLite) message);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                    return super.mergeFrom(other);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                    return super.mergeFrom(input);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                    return super.mergeFrom(input, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length);
                }

                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(input, offset, length, extensionRegistry);
                }

                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return super.mergeFrom(data, extensionRegistry);
                }

                private Builder() {
                    super(Text.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasDisplayText() {
                    return ((Text) this.instance).hasDisplayText();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public String getDisplayText() {
                    return ((Text) this.instance).getDisplayText();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public ByteString getDisplayTextBytes() {
                    return ((Text) this.instance).getDisplayTextBytes();
                }

                public Builder setDisplayText(String value) {
                    copyOnWrite();
                    ((Text) this.instance).setDisplayText(value);
                    return this;
                }

                public Builder clearDisplayText() {
                    copyOnWrite();
                    ((Text) this.instance).clearDisplayText();
                    return this;
                }

                public Builder setDisplayTextBytes(ByteString value) {
                    copyOnWrite();
                    ((Text) this.instance).setDisplayTextBytes(value);
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasLeft() {
                    return ((Text) this.instance).hasLeft();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public double getLeft() {
                    return ((Text) this.instance).getLeft();
                }

                public Builder setLeft(double value) {
                    copyOnWrite();
                    ((Text) this.instance).setLeft(value);
                    return this;
                }

                public Builder clearLeft() {
                    copyOnWrite();
                    ((Text) this.instance).clearLeft();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasBaseline() {
                    return ((Text) this.instance).hasBaseline();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public double getBaseline() {
                    return ((Text) this.instance).getBaseline();
                }

                public Builder setBaseline(double value) {
                    copyOnWrite();
                    ((Text) this.instance).setBaseline(value);
                    return this;
                }

                public Builder clearBaseline() {
                    copyOnWrite();
                    ((Text) this.instance).clearBaseline();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasFontHeight() {
                    return ((Text) this.instance).hasFontHeight();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public double getFontHeight() {
                    return ((Text) this.instance).getFontHeight();
                }

                public Builder setFontHeight(double value) {
                    copyOnWrite();
                    ((Text) this.instance).setFontHeight(value);
                    return this;
                }

                public Builder clearFontHeight() {
                    copyOnWrite();
                    ((Text) this.instance).clearFontHeight();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasNormalized() {
                    return ((Text) this.instance).hasNormalized();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean getNormalized() {
                    return ((Text) this.instance).getNormalized();
                }

                public Builder setNormalized(boolean value) {
                    copyOnWrite();
                    ((Text) this.instance).setNormalized(value);
                    return this;
                }

                public Builder clearNormalized() {
                    copyOnWrite();
                    ((Text) this.instance).clearNormalized();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasFontFace() {
                    return ((Text) this.instance).hasFontFace();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public int getFontFace() {
                    return ((Text) this.instance).getFontFace();
                }

                public Builder setFontFace(int value) {
                    copyOnWrite();
                    ((Text) this.instance).setFontFace(value);
                    return this;
                }

                public Builder clearFontFace() {
                    copyOnWrite();
                    ((Text) this.instance).clearFontFace();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasCenterHorizontally() {
                    return ((Text) this.instance).hasCenterHorizontally();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean getCenterHorizontally() {
                    return ((Text) this.instance).getCenterHorizontally();
                }

                public Builder setCenterHorizontally(boolean value) {
                    copyOnWrite();
                    ((Text) this.instance).setCenterHorizontally(value);
                    return this;
                }

                public Builder clearCenterHorizontally() {
                    copyOnWrite();
                    ((Text) this.instance).clearCenterHorizontally();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasCenterVertically() {
                    return ((Text) this.instance).hasCenterVertically();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean getCenterVertically() {
                    return ((Text) this.instance).getCenterVertically();
                }

                public Builder setCenterVertically(boolean value) {
                    copyOnWrite();
                    ((Text) this.instance).setCenterVertically(value);
                    return this;
                }

                public Builder clearCenterVertically() {
                    copyOnWrite();
                    ((Text) this.instance).clearCenterVertically();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasOutlineThickness() {
                    return ((Text) this.instance).hasOutlineThickness();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public double getOutlineThickness() {
                    return ((Text) this.instance).getOutlineThickness();
                }

                public Builder setOutlineThickness(double value) {
                    copyOnWrite();
                    ((Text) this.instance).setOutlineThickness(value);
                    return this;
                }

                public Builder clearOutlineThickness() {
                    copyOnWrite();
                    ((Text) this.instance).clearOutlineThickness();
                    return this;
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public boolean hasOutlineColor() {
                    return ((Text) this.instance).hasOutlineColor();
                }

                @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotation.TextOrBuilder
                public ColorProto.Color getOutlineColor() {
                    return ((Text) this.instance).getOutlineColor();
                }

                public Builder setOutlineColor(ColorProto.Color value) {
                    copyOnWrite();
                    ((Text) this.instance).setOutlineColor(value);
                    return this;
                }

                public Builder setOutlineColor(ColorProto.Color.Builder builderForValue) {
                    copyOnWrite();
                    ((Text) this.instance).setOutlineColor((ColorProto.Color) builderForValue.build());
                    return this;
                }

                public Builder mergeOutlineColor(ColorProto.Color value) {
                    copyOnWrite();
                    ((Text) this.instance).mergeOutlineColor(value);
                    return this;
                }

                public Builder clearOutlineColor() {
                    copyOnWrite();
                    ((Text) this.instance).clearOutlineColor();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
                AnonymousClass1 anonymousClass1 = null;
                switch (i) {
                    case 1:
                        return new Text();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\f\n\u0000\u0000\u0000\u0001ဈ\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005ဇ\u0004\u0006င\u0005\u0007ဇ\u0006\bဇ\u0007\u000bက\b\fဉ\t", new Object[]{"bitField0_", "displayText_", "left_", "baseline_", "fontHeight_", "normalized_", "fontFace_", "centerHorizontally_", "centerVertically_", "outlineThickness_", "outlineColor_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Text> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (Text.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Text text = new Text();
                DEFAULT_INSTANCE = text;
                GeneratedMessageLite.registerDefaultInstance(Text.class, text);
            }

            public static Text getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Text> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public enum DataCase {
            RECTANGLE(1),
            FILLED_RECTANGLE(2),
            OVAL(3),
            FILLED_OVAL(4),
            POINT(5),
            LINE(6),
            ARROW(7),
            TEXT(8),
            ROUNDED_RECTANGLE(9),
            FILLED_ROUNDED_RECTANGLE(10),
            GRADIENT_LINE(14),
            SCRIBBLE(15),
            DATA_NOT_SET(0);

            private final int value;

            DataCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DataCase valueOf(int value) {
                return forNumber(value);
            }

            public static DataCase forNumber(int value) {
                if (value == 14) {
                    return GRADIENT_LINE;
                }
                if (value == 15) {
                    return SCRIBBLE;
                }
                switch (value) {
                    case 0:
                        return DATA_NOT_SET;
                    case 1:
                        return RECTANGLE;
                    case 2:
                        return FILLED_RECTANGLE;
                    case 3:
                        return OVAL;
                    case 4:
                        return FILLED_OVAL;
                    case 5:
                        return POINT;
                    case 6:
                        return LINE;
                    case 7:
                        return ARROW;
                    case 8:
                        return TEXT;
                    case 9:
                        return ROUNDED_RECTANGLE;
                    case 10:
                        return FILLED_ROUNDED_RECTANGLE;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public DataCase getDataCase() {
            return DataCase.forNumber(this.dataCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.dataCase_ = 0;
            this.data_ = null;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasRectangle() {
            return this.dataCase_ == 1;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public Rectangle getRectangle() {
            if (this.dataCase_ == 1) {
                return (Rectangle) this.data_;
            }
            return Rectangle.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRectangle(Rectangle value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRectangle(Rectangle value) {
            value.getClass();
            if (this.dataCase_ == 1 && this.data_ != Rectangle.getDefaultInstance()) {
                this.data_ = Rectangle.newBuilder((Rectangle) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRectangle() {
            if (this.dataCase_ == 1) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasFilledRectangle() {
            return this.dataCase_ == 2;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public FilledRectangle getFilledRectangle() {
            if (this.dataCase_ == 2) {
                return (FilledRectangle) this.data_;
            }
            return FilledRectangle.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilledRectangle(FilledRectangle value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFilledRectangle(FilledRectangle value) {
            value.getClass();
            if (this.dataCase_ == 2 && this.data_ != FilledRectangle.getDefaultInstance()) {
                this.data_ = FilledRectangle.newBuilder((FilledRectangle) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilledRectangle() {
            if (this.dataCase_ == 2) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasOval() {
            return this.dataCase_ == 3;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public Oval getOval() {
            if (this.dataCase_ == 3) {
                return (Oval) this.data_;
            }
            return Oval.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOval(Oval value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeOval(Oval value) {
            value.getClass();
            if (this.dataCase_ == 3 && this.data_ != Oval.getDefaultInstance()) {
                this.data_ = Oval.newBuilder((Oval) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOval() {
            if (this.dataCase_ == 3) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasFilledOval() {
            return this.dataCase_ == 4;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public FilledOval getFilledOval() {
            if (this.dataCase_ == 4) {
                return (FilledOval) this.data_;
            }
            return FilledOval.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilledOval(FilledOval value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFilledOval(FilledOval value) {
            value.getClass();
            if (this.dataCase_ == 4 && this.data_ != FilledOval.getDefaultInstance()) {
                this.data_ = FilledOval.newBuilder((FilledOval) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilledOval() {
            if (this.dataCase_ == 4) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasPoint() {
            return this.dataCase_ == 5;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public Point getPoint() {
            if (this.dataCase_ == 5) {
                return (Point) this.data_;
            }
            return Point.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPoint(Point value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePoint(Point value) {
            value.getClass();
            if (this.dataCase_ == 5 && this.data_ != Point.getDefaultInstance()) {
                this.data_ = Point.newBuilder((Point) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPoint() {
            if (this.dataCase_ == 5) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasLine() {
            return this.dataCase_ == 6;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public Line getLine() {
            if (this.dataCase_ == 6) {
                return (Line) this.data_;
            }
            return Line.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLine(Line value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLine(Line value) {
            value.getClass();
            if (this.dataCase_ == 6 && this.data_ != Line.getDefaultInstance()) {
                this.data_ = Line.newBuilder((Line) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLine() {
            if (this.dataCase_ == 6) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasArrow() {
            return this.dataCase_ == 7;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public Arrow getArrow() {
            if (this.dataCase_ == 7) {
                return (Arrow) this.data_;
            }
            return Arrow.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setArrow(Arrow value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeArrow(Arrow value) {
            value.getClass();
            if (this.dataCase_ == 7 && this.data_ != Arrow.getDefaultInstance()) {
                this.data_ = Arrow.newBuilder((Arrow) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearArrow() {
            if (this.dataCase_ == 7) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasText() {
            return this.dataCase_ == 8;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public Text getText() {
            if (this.dataCase_ == 8) {
                return (Text) this.data_;
            }
            return Text.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText(Text value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeText(Text value) {
            value.getClass();
            if (this.dataCase_ == 8 && this.data_ != Text.getDefaultInstance()) {
                this.data_ = Text.newBuilder((Text) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearText() {
            if (this.dataCase_ == 8) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasRoundedRectangle() {
            return this.dataCase_ == 9;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public RoundedRectangle getRoundedRectangle() {
            if (this.dataCase_ == 9) {
                return (RoundedRectangle) this.data_;
            }
            return RoundedRectangle.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoundedRectangle(RoundedRectangle value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRoundedRectangle(RoundedRectangle value) {
            value.getClass();
            if (this.dataCase_ == 9 && this.data_ != RoundedRectangle.getDefaultInstance()) {
                this.data_ = RoundedRectangle.newBuilder((RoundedRectangle) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRoundedRectangle() {
            if (this.dataCase_ == 9) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasFilledRoundedRectangle() {
            return this.dataCase_ == 10;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public FilledRoundedRectangle getFilledRoundedRectangle() {
            if (this.dataCase_ == 10) {
                return (FilledRoundedRectangle) this.data_;
            }
            return FilledRoundedRectangle.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilledRoundedRectangle(FilledRoundedRectangle value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFilledRoundedRectangle(FilledRoundedRectangle value) {
            value.getClass();
            if (this.dataCase_ == 10 && this.data_ != FilledRoundedRectangle.getDefaultInstance()) {
                this.data_ = FilledRoundedRectangle.newBuilder((FilledRoundedRectangle) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilledRoundedRectangle() {
            if (this.dataCase_ == 10) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasGradientLine() {
            return this.dataCase_ == 14;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public GradientLine getGradientLine() {
            if (this.dataCase_ == 14) {
                return (GradientLine) this.data_;
            }
            return GradientLine.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGradientLine(GradientLine value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeGradientLine(GradientLine value) {
            value.getClass();
            if (this.dataCase_ == 14 && this.data_ != GradientLine.getDefaultInstance()) {
                this.data_ = GradientLine.newBuilder((GradientLine) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGradientLine() {
            if (this.dataCase_ == 14) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasScribble() {
            return this.dataCase_ == 15;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public Scribble getScribble() {
            if (this.dataCase_ == 15) {
                return (Scribble) this.data_;
            }
            return Scribble.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScribble(Scribble value) {
            value.getClass();
            this.data_ = value;
            this.dataCase_ = 15;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeScribble(Scribble value) {
            value.getClass();
            if (this.dataCase_ == 15 && this.data_ != Scribble.getDefaultInstance()) {
                this.data_ = Scribble.newBuilder((Scribble) this.data_).mergeFrom(value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.dataCase_ = 15;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScribble() {
            if (this.dataCase_ == 15) {
                this.dataCase_ = 0;
                this.data_ = null;
            }
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasThickness() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public double getThickness() {
            return this.thickness_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThickness(double value) {
            this.bitField0_ |= 1;
            this.thickness_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThickness() {
            this.bitField0_ &= -2;
            this.thickness_ = 1.0d;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasColor() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public ColorProto.Color getColor() {
            ColorProto.Color color = this.color_;
            return color == null ? ColorProto.Color.getDefaultInstance() : color;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColor(ColorProto.Color value) {
            value.getClass();
            this.color_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeColor(ColorProto.Color value) {
            value.getClass();
            ColorProto.Color color = this.color_;
            if (color != null && color != ColorProto.Color.getDefaultInstance()) {
                this.color_ = (ColorProto.Color) ColorProto.Color.newBuilder(this.color_).mergeFrom(value).buildPartial();
            } else {
                this.color_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearColor() {
            this.color_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public boolean hasSceneTag() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public String getSceneTag() {
            return this.sceneTag_;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
        public ByteString getSceneTagBytes() {
            return ByteString.copyFromUtf8(this.sceneTag_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSceneTag(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.sceneTag_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSceneTag() {
            this.bitField0_ &= -5;
            this.sceneTag_ = getDefaultInstance().getSceneTag();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSceneTagBytes(ByteString value) {
            this.sceneTag_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static RenderAnnotation parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderAnnotation parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderAnnotation parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderAnnotation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderAnnotation parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderAnnotation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderAnnotation parseFrom(InputStream input) throws IOException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderAnnotation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RenderAnnotation parseDelimitedFrom(InputStream input) throws IOException {
            return (RenderAnnotation) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderAnnotation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderAnnotation) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RenderAnnotation parseFrom(CodedInputStream input) throws IOException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderAnnotation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderAnnotation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RenderAnnotation prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RenderAnnotation, Builder> implements RenderAnnotationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return super.build();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return super.buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return super.clear();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                return super.internalMergeFrom((GeneratedMessageLite) message);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                return super.mergeFrom(other);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            private Builder() {
                super(RenderAnnotation.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public DataCase getDataCase() {
                return ((RenderAnnotation) this.instance).getDataCase();
            }

            public Builder clearData() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearData();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasRectangle() {
                return ((RenderAnnotation) this.instance).hasRectangle();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public Rectangle getRectangle() {
                return ((RenderAnnotation) this.instance).getRectangle();
            }

            public Builder setRectangle(Rectangle value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setRectangle(value);
                return this;
            }

            public Builder setRectangle(Rectangle.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setRectangle((Rectangle) builderForValue.build());
                return this;
            }

            public Builder mergeRectangle(Rectangle value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeRectangle(value);
                return this;
            }

            public Builder clearRectangle() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearRectangle();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasFilledRectangle() {
                return ((RenderAnnotation) this.instance).hasFilledRectangle();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public FilledRectangle getFilledRectangle() {
                return ((RenderAnnotation) this.instance).getFilledRectangle();
            }

            public Builder setFilledRectangle(FilledRectangle value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setFilledRectangle(value);
                return this;
            }

            public Builder setFilledRectangle(FilledRectangle.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setFilledRectangle((FilledRectangle) builderForValue.build());
                return this;
            }

            public Builder mergeFilledRectangle(FilledRectangle value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeFilledRectangle(value);
                return this;
            }

            public Builder clearFilledRectangle() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearFilledRectangle();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasOval() {
                return ((RenderAnnotation) this.instance).hasOval();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public Oval getOval() {
                return ((RenderAnnotation) this.instance).getOval();
            }

            public Builder setOval(Oval value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setOval(value);
                return this;
            }

            public Builder setOval(Oval.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setOval((Oval) builderForValue.build());
                return this;
            }

            public Builder mergeOval(Oval value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeOval(value);
                return this;
            }

            public Builder clearOval() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearOval();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasFilledOval() {
                return ((RenderAnnotation) this.instance).hasFilledOval();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public FilledOval getFilledOval() {
                return ((RenderAnnotation) this.instance).getFilledOval();
            }

            public Builder setFilledOval(FilledOval value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setFilledOval(value);
                return this;
            }

            public Builder setFilledOval(FilledOval.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setFilledOval((FilledOval) builderForValue.build());
                return this;
            }

            public Builder mergeFilledOval(FilledOval value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeFilledOval(value);
                return this;
            }

            public Builder clearFilledOval() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearFilledOval();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasPoint() {
                return ((RenderAnnotation) this.instance).hasPoint();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public Point getPoint() {
                return ((RenderAnnotation) this.instance).getPoint();
            }

            public Builder setPoint(Point value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setPoint(value);
                return this;
            }

            public Builder setPoint(Point.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setPoint((Point) builderForValue.build());
                return this;
            }

            public Builder mergePoint(Point value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergePoint(value);
                return this;
            }

            public Builder clearPoint() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearPoint();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasLine() {
                return ((RenderAnnotation) this.instance).hasLine();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public Line getLine() {
                return ((RenderAnnotation) this.instance).getLine();
            }

            public Builder setLine(Line value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setLine(value);
                return this;
            }

            public Builder setLine(Line.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setLine((Line) builderForValue.build());
                return this;
            }

            public Builder mergeLine(Line value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeLine(value);
                return this;
            }

            public Builder clearLine() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearLine();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasArrow() {
                return ((RenderAnnotation) this.instance).hasArrow();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public Arrow getArrow() {
                return ((RenderAnnotation) this.instance).getArrow();
            }

            public Builder setArrow(Arrow value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setArrow(value);
                return this;
            }

            public Builder setArrow(Arrow.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setArrow((Arrow) builderForValue.build());
                return this;
            }

            public Builder mergeArrow(Arrow value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeArrow(value);
                return this;
            }

            public Builder clearArrow() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearArrow();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasText() {
                return ((RenderAnnotation) this.instance).hasText();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public Text getText() {
                return ((RenderAnnotation) this.instance).getText();
            }

            public Builder setText(Text value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setText(value);
                return this;
            }

            public Builder setText(Text.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setText((Text) builderForValue.build());
                return this;
            }

            public Builder mergeText(Text value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeText(value);
                return this;
            }

            public Builder clearText() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearText();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasRoundedRectangle() {
                return ((RenderAnnotation) this.instance).hasRoundedRectangle();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public RoundedRectangle getRoundedRectangle() {
                return ((RenderAnnotation) this.instance).getRoundedRectangle();
            }

            public Builder setRoundedRectangle(RoundedRectangle value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setRoundedRectangle(value);
                return this;
            }

            public Builder setRoundedRectangle(RoundedRectangle.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setRoundedRectangle((RoundedRectangle) builderForValue.build());
                return this;
            }

            public Builder mergeRoundedRectangle(RoundedRectangle value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeRoundedRectangle(value);
                return this;
            }

            public Builder clearRoundedRectangle() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearRoundedRectangle();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasFilledRoundedRectangle() {
                return ((RenderAnnotation) this.instance).hasFilledRoundedRectangle();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public FilledRoundedRectangle getFilledRoundedRectangle() {
                return ((RenderAnnotation) this.instance).getFilledRoundedRectangle();
            }

            public Builder setFilledRoundedRectangle(FilledRoundedRectangle value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setFilledRoundedRectangle(value);
                return this;
            }

            public Builder setFilledRoundedRectangle(FilledRoundedRectangle.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setFilledRoundedRectangle((FilledRoundedRectangle) builderForValue.build());
                return this;
            }

            public Builder mergeFilledRoundedRectangle(FilledRoundedRectangle value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeFilledRoundedRectangle(value);
                return this;
            }

            public Builder clearFilledRoundedRectangle() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearFilledRoundedRectangle();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasGradientLine() {
                return ((RenderAnnotation) this.instance).hasGradientLine();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public GradientLine getGradientLine() {
                return ((RenderAnnotation) this.instance).getGradientLine();
            }

            public Builder setGradientLine(GradientLine value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setGradientLine(value);
                return this;
            }

            public Builder setGradientLine(GradientLine.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setGradientLine((GradientLine) builderForValue.build());
                return this;
            }

            public Builder mergeGradientLine(GradientLine value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeGradientLine(value);
                return this;
            }

            public Builder clearGradientLine() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearGradientLine();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasScribble() {
                return ((RenderAnnotation) this.instance).hasScribble();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public Scribble getScribble() {
                return ((RenderAnnotation) this.instance).getScribble();
            }

            public Builder setScribble(Scribble value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setScribble(value);
                return this;
            }

            public Builder setScribble(Scribble.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setScribble((Scribble) builderForValue.build());
                return this;
            }

            public Builder mergeScribble(Scribble value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeScribble(value);
                return this;
            }

            public Builder clearScribble() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearScribble();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasThickness() {
                return ((RenderAnnotation) this.instance).hasThickness();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public double getThickness() {
                return ((RenderAnnotation) this.instance).getThickness();
            }

            public Builder setThickness(double value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setThickness(value);
                return this;
            }

            public Builder clearThickness() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearThickness();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasColor() {
                return ((RenderAnnotation) this.instance).hasColor();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public ColorProto.Color getColor() {
                return ((RenderAnnotation) this.instance).getColor();
            }

            public Builder setColor(ColorProto.Color value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setColor(value);
                return this;
            }

            public Builder setColor(ColorProto.Color.Builder builderForValue) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setColor((ColorProto.Color) builderForValue.build());
                return this;
            }

            public Builder mergeColor(ColorProto.Color value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).mergeColor(value);
                return this;
            }

            public Builder clearColor() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearColor();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public boolean hasSceneTag() {
                return ((RenderAnnotation) this.instance).hasSceneTag();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public String getSceneTag() {
                return ((RenderAnnotation) this.instance).getSceneTag();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderAnnotationOrBuilder
            public ByteString getSceneTagBytes() {
                return ((RenderAnnotation) this.instance).getSceneTagBytes();
            }

            public Builder setSceneTag(String value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setSceneTag(value);
                return this;
            }

            public Builder clearSceneTag() {
                copyOnWrite();
                ((RenderAnnotation) this.instance).clearSceneTag();
                return this;
            }

            public Builder setSceneTagBytes(ByteString value) {
                copyOnWrite();
                ((RenderAnnotation) this.instance).setSceneTagBytes(value);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new RenderAnnotation();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000f\u0001\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000bက\u0000\fဉ\u0001\rဈ\u0002\u000e<\u0000\u000f<\u0000", new Object[]{"data_", "dataCase_", "bitField0_", Rectangle.class, FilledRectangle.class, Oval.class, FilledOval.class, Point.class, Line.class, Arrow.class, Text.class, RoundedRectangle.class, FilledRoundedRectangle.class, "thickness_", "color_", "sceneTag_", GradientLine.class, Scribble.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RenderAnnotation> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (RenderAnnotation.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RenderAnnotation renderAnnotation = new RenderAnnotation();
            DEFAULT_INSTANCE = renderAnnotation;
            GeneratedMessageLite.registerDefaultInstance(RenderAnnotation.class, renderAnnotation);
        }

        public static RenderAnnotation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RenderAnnotation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RenderViewport extends GeneratedMessageLite<RenderViewport, Builder> implements RenderViewportOrBuilder {
        public static final int COMPOSE_ON_VIDEO_FIELD_NUMBER = 4;
        private static final RenderViewport DEFAULT_INSTANCE;
        public static final int HEIGHT_PX_FIELD_NUMBER = 3;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile Parser<RenderViewport> PARSER = null;
        public static final int WIDTH_PX_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean composeOnVideo_;
        private int heightPx_;
        private String id_ = "";
        private int widthPx_;

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        private RenderViewport() {
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public boolean hasId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public String getId() {
            return this.id_;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public ByteString getIdBytes() {
            return ByteString.copyFromUtf8(this.id_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.id_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.bitField0_ &= -2;
            this.id_ = getDefaultInstance().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdBytes(ByteString value) {
            this.id_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public boolean hasWidthPx() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public int getWidthPx() {
            return this.widthPx_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidthPx(int value) {
            this.bitField0_ |= 2;
            this.widthPx_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidthPx() {
            this.bitField0_ &= -3;
            this.widthPx_ = 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public boolean hasHeightPx() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public int getHeightPx() {
            return this.heightPx_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeightPx(int value) {
            this.bitField0_ |= 4;
            this.heightPx_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeightPx() {
            this.bitField0_ &= -5;
            this.heightPx_ = 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public boolean hasComposeOnVideo() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
        public boolean getComposeOnVideo() {
            return this.composeOnVideo_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setComposeOnVideo(boolean value) {
            this.bitField0_ |= 8;
            this.composeOnVideo_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearComposeOnVideo() {
            this.bitField0_ &= -9;
            this.composeOnVideo_ = false;
        }

        public static RenderViewport parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderViewport parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderViewport parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderViewport parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderViewport parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RenderViewport parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RenderViewport parseFrom(InputStream input) throws IOException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderViewport parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RenderViewport parseDelimitedFrom(InputStream input) throws IOException {
            return (RenderViewport) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderViewport parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderViewport) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RenderViewport parseFrom(CodedInputStream input) throws IOException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RenderViewport parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RenderViewport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RenderViewport prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RenderViewport, Builder> implements RenderViewportOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return super.build();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return super.buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return super.clear();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                return super.internalMergeFrom((GeneratedMessageLite) message);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                return super.mergeFrom(other);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            private Builder() {
                super(RenderViewport.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public boolean hasId() {
                return ((RenderViewport) this.instance).hasId();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public String getId() {
                return ((RenderViewport) this.instance).getId();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public ByteString getIdBytes() {
                return ((RenderViewport) this.instance).getIdBytes();
            }

            public Builder setId(String value) {
                copyOnWrite();
                ((RenderViewport) this.instance).setId(value);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((RenderViewport) this.instance).clearId();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                copyOnWrite();
                ((RenderViewport) this.instance).setIdBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public boolean hasWidthPx() {
                return ((RenderViewport) this.instance).hasWidthPx();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public int getWidthPx() {
                return ((RenderViewport) this.instance).getWidthPx();
            }

            public Builder setWidthPx(int value) {
                copyOnWrite();
                ((RenderViewport) this.instance).setWidthPx(value);
                return this;
            }

            public Builder clearWidthPx() {
                copyOnWrite();
                ((RenderViewport) this.instance).clearWidthPx();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public boolean hasHeightPx() {
                return ((RenderViewport) this.instance).hasHeightPx();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public int getHeightPx() {
                return ((RenderViewport) this.instance).getHeightPx();
            }

            public Builder setHeightPx(int value) {
                copyOnWrite();
                ((RenderViewport) this.instance).setHeightPx(value);
                return this;
            }

            public Builder clearHeightPx() {
                copyOnWrite();
                ((RenderViewport) this.instance).clearHeightPx();
                return this;
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public boolean hasComposeOnVideo() {
                return ((RenderViewport) this.instance).hasComposeOnVideo();
            }

            @Override // com.google.mediapipe.util.proto.RenderDataProto.RenderViewportOrBuilder
            public boolean getComposeOnVideo() {
                return ((RenderViewport) this.instance).getComposeOnVideo();
            }

            public Builder setComposeOnVideo(boolean value) {
                copyOnWrite();
                ((RenderViewport) this.instance).setComposeOnVideo(value);
                return this;
            }

            public Builder clearComposeOnVideo() {
                copyOnWrite();
                ((RenderViewport) this.instance).clearComposeOnVideo();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new RenderViewport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003", new Object[]{"bitField0_", "id_", "widthPx_", "heightPx_", "composeOnVideo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RenderViewport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (RenderViewport.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RenderViewport renderViewport = new RenderViewport();
            DEFAULT_INSTANCE = renderViewport;
            GeneratedMessageLite.registerDefaultInstance(RenderViewport.class, renderViewport);
        }

        public static RenderViewport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RenderViewport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
