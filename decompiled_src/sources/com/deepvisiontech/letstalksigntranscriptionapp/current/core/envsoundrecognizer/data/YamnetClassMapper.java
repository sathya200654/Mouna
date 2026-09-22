package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AlarmKt;
import androidx.compose.material.icons.filled.DirectionsCarKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.MicKt;
import androidx.compose.material.icons.filled.MusicNoteKt;
import androidx.compose.material.icons.filled.PetsKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.EnvironmentSound;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.VibrationLevel;
import com.google.mediapipe.tasks.components.containers.Category;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: YamNetClassMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/YamnetClassMapper;", "", "<init>", "()V", "map", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;", "category", "Lcom/google/mediapipe/tasks/components/containers/Category;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class YamnetClassMapper {
    public static final int $stable = 0;
    public static final YamnetClassMapper INSTANCE = new YamnetClassMapper();

    private YamnetClassMapper() {
    }

    public final EnvironmentSound map(Category category) {
        ImageVector alarm;
        VibrationLevel vibrationLevel;
        Intrinsics.checkNotNullParameter(category, "category");
        String strCategoryName = category.categoryName();
        Intrinsics.checkNotNull(strCategoryName);
        String str = strCategoryName;
        if (StringsKt.contains(str, "Alarm", true) || StringsKt.contains(str, "Siren", true) || StringsKt.contains(str, "Fire alarm", true)) {
            alarm = AlarmKt.getAlarm(Icons.Filled.INSTANCE);
        } else if (StringsKt.contains(str, "Bell", true) || StringsKt.contains(str, "Doorbell", true)) {
            alarm = HomeKt.getHome(Icons.Filled.INSTANCE);
        } else if (StringsKt.contains(str, "Speech", true) || StringsKt.contains(str, "Shouting", true) || StringsKt.contains(str, "Crying", true) || StringsKt.contains(str, "Laughter", true)) {
            alarm = MicKt.getMic(Icons.Filled.INSTANCE);
        } else if (StringsKt.contains(str, "Vehicle", true) || StringsKt.contains(str, "Car", true) || StringsKt.contains(str, "Train", true) || StringsKt.contains(str, "Bus", true)) {
            alarm = DirectionsCarKt.getDirectionsCar(Icons.Filled.INSTANCE);
        } else if (StringsKt.contains(str, "Music", true) || StringsKt.contains(str, "Announcements", true)) {
            alarm = MusicNoteKt.getMusicNote(Icons.Filled.INSTANCE);
        } else if (StringsKt.contains(str, "Dog", true) || StringsKt.contains(str, "Cat", true) || StringsKt.contains(str, "Bird", true)) {
            alarm = PetsKt.getPets(Icons.Filled.INSTANCE);
        } else {
            alarm = MicKt.getMic(Icons.Filled.INSTANCE);
        }
        if (EnvSoundRecogConstants.INSTANCE.getLIST_OF_HIGH_PRIORITY_LABELS().contains(strCategoryName)) {
            vibrationLevel = VibrationLevel.HIGH;
        } else {
            vibrationLevel = EnvSoundRecogConstants.INSTANCE.getLIST_OF_CURATED_LABELS().contains(strCategoryName) ? VibrationLevel.MEDIUM : VibrationLevel.NONE;
        }
        return new EnvironmentSound(strCategoryName, category.score(), alarm, vibrationLevel);
    }
}
