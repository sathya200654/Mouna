package androidx.wear.compose.foundation;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedTextStyle.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"DefaultCurvedTextStyles", "Landroidx/wear/compose/foundation/CurvedTextStyle;", "getDefaultCurvedTextStyles", "()Landroidx/wear/compose/foundation/CurvedTextStyle;", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedTextStyleKt {
    private static final CurvedTextStyle DefaultCurvedTextStyles;

    public static final CurvedTextStyle getDefaultCurvedTextStyles() {
        return DefaultCurvedTextStyles;
    }

    static {
        long j = Color.Companion.getBlack-0d7_KjU();
        long sp = TextUnitKt.getSp(14);
        DefaultCurvedTextStyles = new CurvedTextStyle(Color.Companion.getTransparent-0d7_KjU(), j, sp, null, FontWeight.Companion.getNormal(), FontStyle.box-impl(FontStyle.Companion.getNormal-_-LCdwA()), FontSynthesis.box-impl(FontSynthesis.Companion.getAll-GVVA2EU()), 8, null);
    }
}
