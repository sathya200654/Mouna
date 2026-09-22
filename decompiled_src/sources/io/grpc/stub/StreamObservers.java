package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.google.firebase.messaging.Constants;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Deprecated
public final class StreamObservers {
    public static <V> void copyWithFlowControl(final Iterator<V> it, final CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(it, Constants.ScionAnalytics.PARAM_SOURCE);
        Preconditions.checkNotNull(callStreamObserver, "target");
        callStreamObserver.setOnReadyHandler(new Runnable() { // from class: io.grpc.stub.StreamObservers.1FlowControllingOnReadyHandler
            private boolean completed;

            @Override // java.lang.Runnable
            public void run() {
                if (this.completed) {
                    return;
                }
                while (callStreamObserver.isReady() && it.hasNext()) {
                    callStreamObserver.onNext(it.next());
                }
                if (it.hasNext()) {
                    return;
                }
                this.completed = true;
                callStreamObserver.onCompleted();
            }
        });
    }

    public static <V> void copyWithFlowControl(Iterable<V> iterable, CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(iterable, Constants.ScionAnalytics.PARAM_SOURCE);
        copyWithFlowControl(iterable.iterator(), callStreamObserver);
    }
}
