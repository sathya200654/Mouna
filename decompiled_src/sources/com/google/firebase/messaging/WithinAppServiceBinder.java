package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.camera.compose.CameraXViewfinderKt$CameraXViewfinder$viewfinderArgs$2$1$;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class WithinAppServiceBinder extends Binder {
    private final IntentHandler intentHandler;

    interface IntentHandler {
        Task<Void> handle(Intent intent);
    }

    WithinAppServiceBinder(IntentHandler intentHandler) {
        this.intentHandler = intentHandler;
    }

    void send(final WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "service received new intent via bind strategy");
        }
        this.intentHandler.handle(bindRequest.intent).addOnCompleteListener(new CameraXViewfinderKt$CameraXViewfinder$viewfinderArgs$2$1$.ExternalSyntheticLambda0(), new OnCompleteListener() { // from class: com.google.firebase.messaging.WithinAppServiceBinder$$ExternalSyntheticLambda0
            public final void onComplete(Task task) {
                bindRequest.finish();
            }
        });
    }
}
