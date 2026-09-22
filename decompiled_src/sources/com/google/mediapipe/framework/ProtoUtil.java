package com.google.mediapipe.framework;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ProtoUtil {
    static TypeNameRegistry typeNameRegistry = new TypeNameRegistryConcrete();

    public static <T extends MessageLite> void registerTypeName(Class<T> clazz, String typeName) {
        typeNameRegistry.registerTypeName(clazz, typeName);
    }

    public static <T extends MessageLite> String getTypeName(Class<T> clazz) {
        return typeNameRegistry.getTypeName(clazz);
    }

    public static ExtensionRegistryLite getExtensionRegistry() {
        return ExtensionRegistryLite.getEmptyRegistry();
    }

    public static <T extends MessageLite> SerializedMessage pack(T message) {
        SerializedMessage serializedMessage = new SerializedMessage();
        serializedMessage.typeName = getTypeName(message.getClass());
        if (serializedMessage.typeName == null) {
            throw new NoSuchElementException("Cannot determine the protobuf type name for class: " + message.getClass() + ". Have you called ProtoUtil.registerTypeName?");
        }
        serializedMessage.value = message.toByteArray();
        return serializedMessage;
    }

    public static <T extends MessageLite> T unpack(SerializedMessage serialized, T defaultInstance) throws InvalidProtocolBufferException {
        String typeName = getTypeName(defaultInstance.getClass());
        if (!serialized.typeName.equals(typeName)) {
            throw new InvalidProtocolBufferException("Message type does not match the expected type. Expected: " + typeName + " Got: " + serialized.typeName);
        }
        return (T) defaultInstance.getParserForType().parseFrom(serialized.value, getExtensionRegistry());
    }

    private ProtoUtil() {
    }

    static class SerializedMessage {
        public String typeName;
        public byte[] value;

        SerializedMessage() {
        }
    }
}
