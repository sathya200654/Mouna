package androidx.wear.compose.materialcore;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RangeDefaults.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/wear/compose/materialcore/RangeIcons;", "", "()V", "Minus", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getMinus", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_minus", "compose-material-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RangeIcons {
    private static ImageVector _minus;
    public static final RangeIcons INSTANCE = new RangeIcons();
    public static final int $stable = 8;

    private RangeIcons() {
    }

    public final ImageVector getMinus() {
        ImageVector imageVector = _minus;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("MinusIcon", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Brush solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i = StrokeCap.Companion.getButt-KaPHkGw();
        int i2 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.0f, 13.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.horizontalLineToRelative(14.0f);
        pathBuilder.verticalLineToRelative(2.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, (Brush) null, 1.0f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _minus = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }
}
