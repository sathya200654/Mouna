package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/wear/compose/material/ChipColors;", "", "background", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/painter/Painter;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "iconColor", "secondaryContentColor", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ChipColors {
    State<Painter> background(boolean z, Composer composer, int i);

    State<Color> contentColor(boolean z, Composer composer, int i);

    State<Color> iconColor(boolean z, Composer composer, int i);

    State<Color> secondaryContentColor(boolean z, Composer composer, int i);
}
