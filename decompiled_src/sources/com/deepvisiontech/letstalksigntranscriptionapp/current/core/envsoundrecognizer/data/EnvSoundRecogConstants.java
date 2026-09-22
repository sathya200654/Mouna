package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: EnvSoundRecogConstants.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/EnvSoundRecogConstants;", "", "<init>", "()V", "YAMNET_MODEL_FILE", "", "CONFIDENCE_THRESHOLD", "", "LIST_OF_CURATED_LABELS", "", "getLIST_OF_CURATED_LABELS", "()Ljava/util/List;", "LIST_OF_HIGH_PRIORITY_LABELS", "getLIST_OF_HIGH_PRIORITY_LABELS", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EnvSoundRecogConstants {
    public static final float CONFIDENCE_THRESHOLD = 0.3f;
    public static final String YAMNET_MODEL_FILE = "yamnet.tflite";
    public static final EnvSoundRecogConstants INSTANCE = new EnvSoundRecogConstants();
    private static final List<String> LIST_OF_CURATED_LABELS = CollectionsKt.listOf(new String[]{"Alarm", "Siren", "Emergency vehicle (siren)", "Fire alarm", "Smoke detector", "Bell", "Doorbell", "Speech", "Whispering", "Shouting", "Crying", "Laughter", "Snoring", "Telephone", "Door", "Knock", "Water tap (faucet) running", "Clock", "Microwave oven", "Vehicle", "Car", "Bus", "Aircraft", "Horn", "Train horn", "Motor vehicle (road)", "Music", "Announcements", "Public address", "Clapping", "Crowd", "Dog", "Bark", "Cat", "Bird", "Wind", "Rain", "Thunder", "Drill", "Hammering", "Sawing"});
    private static final List<String> LIST_OF_HIGH_PRIORITY_LABELS = CollectionsKt.listOf(new String[]{"Fire alarm", "Smoke detector", "Siren", "Emergency vehicle (siren)", "Alarm", "Shouting", "Crying", "Doorbell", "Dog", "Cat", "Knock", "Telephone"});
    public static final int $stable = 8;

    private EnvSoundRecogConstants() {
    }

    public final List<String> getLIST_OF_CURATED_LABELS() {
        return LIST_OF_CURATED_LABELS;
    }

    public final List<String> getLIST_OF_HIGH_PRIORITY_LABELS() {
        return LIST_OF_HIGH_PRIORITY_LABELS;
    }
}
