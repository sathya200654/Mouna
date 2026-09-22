package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface PerfSessionOrBuilder extends MessageLiteOrBuilder {
    String getSessionId();

    ByteString getSessionIdBytes();

    SessionVerbosity getSessionVerbosity(int i);

    int getSessionVerbosityCount();

    List<SessionVerbosity> getSessionVerbosityList();

    boolean hasSessionId();
}
