package com.google.firebase.inappmessaging.display.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class FiamImageLoader {
    private final RequestManager requestManager;
    private final Map<String, Set<CustomTarget>> tags = new HashMap();

    @Inject
    public FiamImageLoader(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public FiamImageRequestCreator load(String str) {
        Logging.logd("Starting Downloading Image : " + str);
        return new FiamImageRequestCreator(this.requestManager.load((Object) new GlideUrl(str, new LazyHeaders.Builder().addHeader(HttpHeaders.ACCEPT, "image/*").build())).format(DecodeFormat.PREFER_ARGB_8888));
    }

    public void cancelTag(Class cls) {
        String simpleName = cls.getSimpleName();
        synchronized (simpleName) {
            if (this.tags.containsKey(simpleName)) {
                for (CustomTarget customTarget : this.tags.get(simpleName)) {
                    if (customTarget != null) {
                        this.requestManager.clear(customTarget);
                    }
                }
            }
        }
    }

    boolean containsTag(String str) {
        Map<String, Set<CustomTarget>> map = this.tags;
        return map != null && map.containsKey(str) && this.tags.get(str) != null && this.tags.get(str).size() > 0;
    }

    public class FiamImageRequestCreator {
        private final RequestBuilder<Drawable> requestBuilder;
        private String tag;
        private Callback target;

        public FiamImageRequestCreator(RequestBuilder<Drawable> requestBuilder) {
            this.requestBuilder = requestBuilder;
        }

        public FiamImageRequestCreator placeholder(int i) {
            this.requestBuilder.placeholder(i);
            Logging.logd("Downloading Image Placeholder : " + i);
            return this;
        }

        public FiamImageRequestCreator addErrorListener(GlideErrorListener glideErrorListener) {
            this.requestBuilder.addListener(glideErrorListener);
            return this;
        }

        public FiamImageRequestCreator tag(Class cls) {
            this.tag = cls.getSimpleName();
            checkAndTag();
            return this;
        }

        private void checkAndTag() {
            Set hashSet;
            if (this.target == null || TextUtils.isEmpty(this.tag)) {
                return;
            }
            synchronized (FiamImageLoader.this.tags) {
                if (FiamImageLoader.this.tags.containsKey(this.tag)) {
                    hashSet = (Set) FiamImageLoader.this.tags.get(this.tag);
                } else {
                    hashSet = new HashSet();
                    FiamImageLoader.this.tags.put(this.tag, hashSet);
                }
                if (!hashSet.contains(this.target)) {
                    hashSet.add(this.target);
                }
            }
        }

        public void into(ImageView imageView, Callback callback) {
            Logging.logd("Downloading Image Callback : " + callback);
            callback.setImageView(imageView);
            this.requestBuilder.into(callback);
            this.target = callback;
            checkAndTag();
        }
    }

    public static abstract class Callback extends CustomTarget<Drawable> {
        private ImageView imageView;

        public abstract void onError(Exception exc);

        public abstract void onSuccess();

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            Logging.logd("Downloading Image Failed");
            setImage(drawable);
            onError(new Exception("Image loading failed!"));
        }

        private void setImage(Drawable drawable) {
            ImageView imageView = this.imageView;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }

        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
            Logging.logd("Downloading Image Success!!!");
            setImage(drawable);
            onSuccess();
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            Logging.logd("Downloading Image Cleared");
            setImage(drawable);
            onSuccess();
        }

        void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }
    }
}
