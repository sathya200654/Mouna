package com.google.firebase.inappmessaging.display.internal;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class GlideErrorListener implements RequestListener<Drawable> {
    private final FirebaseInAppMessagingDisplayCallbacks displayCallbacks;
    private final InAppMessage inAppMessage;

    public GlideErrorListener(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.displayCallbacks = firebaseInAppMessagingDisplayCallbacks;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
        Logging.logd("Image Downloading  Error : " + glideException.getMessage() + ":" + glideException.getCause());
        if (this.inAppMessage == null || this.displayCallbacks == null) {
            return false;
        }
        if (glideException.getLocalizedMessage().contains("Failed to decode")) {
            this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT);
            return false;
        }
        this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
        Logging.logd("Image Downloading  Success : " + drawable);
        return false;
    }
}
