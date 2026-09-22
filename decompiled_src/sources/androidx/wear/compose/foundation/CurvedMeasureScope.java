package androidx.wear.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedLayout.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0017\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0012\u001a\u00020\u0013*\u00020\u0017H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u0014*\u00020\u0017H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001a\u001a\u00020\u0014*\u00020\u0006H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u001a\u001a\u00020\u0014*\u00020\u0013H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001fJ\u0017\u0010 \u001a\u00020!*\u00020\"H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u0006*\u00020\u0014H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u001eJ\u0017\u0010%\u001a\u00020\u0006*\u00020\u0017H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001cJ\r\u0010(\u001a\u00020)*\u00020*H\u0097\u0001J\u0017\u0010+\u001a\u00020\"*\u00020!H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010$J\u0017\u0010-\u001a\u00020\u0017*\u00020\u0014H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001a\u0010-\u001a\u00020\u0017*\u00020\u0006H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010/J\u001a\u0010-\u001a\u00020\u0017*\u00020\u0013H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00068\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/wear/compose/foundation/CurvedMeasureScope;", "Landroidx/compose/ui/unit/Density;", "subDensity", "curvedLayoutDirection", "Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "radius", "", "(Landroidx/compose/ui/unit/Density;Landroidx/wear/compose/foundation/CurvedLayoutDirection;F)V", "getCurvedLayoutDirection", "()Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "density", "getDensity", "()F", "fontScale", "getFontScale", "getRadius", "getSubDensity", "()Landroidx/compose/ui/unit/Density;", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedMeasureScope implements Density {
    public static final int $stable = 0;
    private final CurvedLayoutDirection curvedLayoutDirection;
    private final float radius;
    private final Density subDensity;

    public float getDensity() {
        return this.subDensity.getDensity();
    }

    public float getFontScale() {
        return this.subDensity.getFontScale();
    }

    /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public int m324roundToPxR2X_6o(long j) {
        return this.subDensity.roundToPx--R2X_6o(j);
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int m325roundToPx0680j_4(float f) {
        return this.subDensity.roundToPx-0680j_4(f);
    }

    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float m326toDpGaN1DYA(long j) {
        return this.subDensity.toDp-GaN1DYA(j);
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float m327toDpu2uoSUM(float f) {
        return this.subDensity.toDp-u2uoSUM(f);
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float m328toDpu2uoSUM(int i) {
        return this.subDensity.toDp-u2uoSUM(i);
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long m329toDpSizekrfVVM(long j) {
        return this.subDensity.toDpSize-k-rfVVM(j);
    }

    /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
    public float m330toPxR2X_6o(long j) {
        return this.subDensity.toPx--R2X_6o(j);
    }

    /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
    public float m331toPx0680j_4(float f) {
        return this.subDensity.toPx-0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        return this.subDensity.toRect(dpRect);
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long m332toSizeXkaWNTQ(long j) {
        return this.subDensity.toSize-XkaWNTQ(j);
    }

    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    public long m333toSp0xMU5do(float f) {
        return this.subDensity.toSp-0xMU5do(f);
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long m334toSpkPz2Gy4(float f) {
        return this.subDensity.toSp-kPz2Gy4(f);
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long m335toSpkPz2Gy4(int i) {
        return this.subDensity.toSp-kPz2Gy4(i);
    }

    public CurvedMeasureScope(Density density, CurvedLayoutDirection curvedLayoutDirection, float f) {
        this.subDensity = density;
        this.curvedLayoutDirection = curvedLayoutDirection;
        this.radius = f;
    }

    public final Density getSubDensity() {
        return this.subDensity;
    }

    public final CurvedLayoutDirection getCurvedLayoutDirection() {
        return this.curvedLayoutDirection;
    }

    public final float getRadius() {
        return this.radius;
    }
}
