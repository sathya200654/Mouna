package androidx.wear.compose.material;

import android.graphics.Shader;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.TileMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Card.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B9\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/wear/compose/material/FortyFiveDegreeLinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "ltr", "", "(Ljava/util/List;Ljava/util/List;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "other", "", "hashCode", "", "toString", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FortyFiveDegreeLinearGradient extends ShaderBrush {
    public static final int $stable = 0;
    private final List<Color> colors;
    private final boolean ltr;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ FortyFiveDegreeLinearGradient(List list, List list2, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, i, z);
    }

    public /* synthetic */ FortyFiveDegreeLinearGradient(List list, List list2, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, (i2 & 4) != 0 ? TileMode.Companion.getClamp-3opZhB0() : i, z, null);
    }

    private FortyFiveDegreeLinearGradient(List<Color> list, List<Float> list2, int i, boolean z) {
        this.colors = list;
        this.stops = list2;
        this.tileMode = i;
        this.ltr = z;
    }

    /* JADX INFO: renamed from: createShader-uvyYCjk, reason: not valid java name */
    public Shader m596createShaderuvyYCjk(long size) {
        float fMin = Math.min(Size.getHeight-impl(size), Size.getWidth-impl(size));
        return ShaderKt.LinearGradientShader-VjE6UOU(this.ltr ? OffsetKt.Offset(0.0f, 0.0f) : OffsetKt.Offset(fMin, 0.0f), this.ltr ? OffsetKt.Offset(fMin, fMin) : OffsetKt.Offset(0.0f, fMin), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FortyFiveDegreeLinearGradient)) {
            return false;
        }
        FortyFiveDegreeLinearGradient fortyFiveDegreeLinearGradient = (FortyFiveDegreeLinearGradient) other;
        return Intrinsics.areEqual(this.colors, fortyFiveDegreeLinearGradient.colors) && Intrinsics.areEqual(this.stops, fortyFiveDegreeLinearGradient.stops) && TileMode.equals-impl0(this.tileMode, fortyFiveDegreeLinearGradient.tileMode) && this.ltr == fortyFiveDegreeLinearGradient.ltr;
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + TileMode.hashCode-impl(this.tileMode);
    }

    public String toString() {
        return "FortyFiveDegreeLinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", tileMode=" + ((Object) TileMode.toString-impl(this.tileMode)) + ')';
    }
}
