package com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class TextToSpeechManager_Factory implements Factory<TextToSpeechManager> {
    private final Provider<Context> contextProvider;

    private TextToSpeechManager_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public TextToSpeechManager m1707get() {
        return newInstance((Context) this.contextProvider.get());
    }

    public static TextToSpeechManager_Factory create(Provider<Context> contextProvider) {
        return new TextToSpeechManager_Factory(contextProvider);
    }

    public static TextToSpeechManager newInstance(Context context) {
        return new TextToSpeechManager(context);
    }
}
