package com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local;

import dagger.internal.Factory;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SharedAudioEngine_Factory implements Factory<SharedAudioEngine> {
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SharedAudioEngine m1669get() {
        return newInstance();
    }

    public static SharedAudioEngine_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SharedAudioEngine newInstance() {
        return new SharedAudioEngine();
    }

    private static final class InstanceHolder {
        static final SharedAudioEngine_Factory INSTANCE = new SharedAudioEngine_Factory();

        private InstanceHolder() {
        }
    }
}
