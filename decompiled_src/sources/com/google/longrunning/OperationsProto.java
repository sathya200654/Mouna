package com.google.longrunning;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class OperationsProto {
    public static final int OPERATION_INFO_FIELD_NUMBER = 1049;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MethodOptions, OperationInfo> operationInfo = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.MethodOptions.getDefaultInstance(), OperationInfo.getDefaultInstance(), OperationInfo.getDefaultInstance(), null, OPERATION_INFO_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, OperationInfo.class);

    private OperationsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) operationInfo);
    }
}
