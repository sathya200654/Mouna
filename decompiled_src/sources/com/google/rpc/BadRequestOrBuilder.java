package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface BadRequestOrBuilder extends MessageLiteOrBuilder {
    BadRequest.FieldViolation getFieldViolations(int i);

    int getFieldViolationsCount();

    List<BadRequest.FieldViolation> getFieldViolationsList();
}
