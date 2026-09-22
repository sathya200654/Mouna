package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface PreconditionFailureOrBuilder extends MessageLiteOrBuilder {
    PreconditionFailure.Violation getViolations(int i);

    int getViolationsCount();

    List<PreconditionFailure.Violation> getViolationsList();
}
