package coil3.compose;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

/* JADX INFO: compiled from: CrossfadePainter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\f\u00100\u001a\u000201*\u000202H\u0014J\u0010\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020(H\u0014J\u0012\u00105\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J#\u00106\u001a\u00020.2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b7\u00108J\u001e\u00109\u001a\u000201*\u0002022\b\u0010:\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u00020(H\u0002J\u001f\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020.H\u0002¢\u0006\u0004\b>\u0010?R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010+\u001a\u0004\u0018\u00010\u0001@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b/\u0010\u0014¨\u0006@"}, d2 = {"Lcoil3/compose/CrossfadePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "start", "end", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "duration", "Lkotlin/time/Duration;", "timeSource", "Lkotlin/time/TimeSource;", "fadeStart", "", "preferExactIntrinsicSize", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;JLkotlin/time/TimeSource;ZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnd", "()Landroidx/compose/ui/graphics/painter/Painter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getDuration-UwyO8pc", "()J", "J", "getTimeSource", "()Lkotlin/time/TimeSource;", "getFadeStart", "()Z", "getPreferExactIntrinsicSize", "<set-?>", "", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableIntState;", "startTime", "Lkotlin/time/TimeMark;", "isDone", "maxAlpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "value", "getStart", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "alpha", "applyColorFilter", "computeIntrinsicSize", "computeIntrinsicSize-xjbvk4A", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)J", "drawPainter", "painter", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CrossfadePainter extends Painter {
    public static final int $stable = 0;
    private ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final long duration;
    private final Painter end;
    private final boolean fadeStart;
    private final long intrinsicSize;

    /* JADX INFO: renamed from: invalidateTick$delegate, reason: from kotlin metadata */
    private final MutableIntState invalidateTick;
    private boolean isDone;
    private float maxAlpha;
    private final boolean preferExactIntrinsicSize;
    private Painter start;
    private TimeMark startTime;
    private final TimeSource timeSource;

    public /* synthetic */ CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, long j, TimeSource timeSource, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, painter2, contentScale, j, timeSource, z, z2);
    }

    public final Painter getEnd() {
        return this.end;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, long j, TimeSource timeSource, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        ContentScale fit = (i & 4) != 0 ? ContentScale.Companion.getFit() : contentScale;
        if ((i & 8) != 0) {
            Duration.Companion companion = Duration.Companion;
            duration = DurationKt.toDuration(200, DurationUnit.MILLISECONDS);
        } else {
            duration = j;
        }
        this(painter, painter2, fit, duration, (i & 16) != 0 ? (TimeSource) TimeSource.Monotonic.INSTANCE : timeSource, (i & 32) != 0 ? true : z, (i & 64) != 0 ? false : z2, null);
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: getDuration-UwyO8pc, reason: not valid java name and from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final TimeSource getTimeSource() {
        return this.timeSource;
    }

    public final boolean getFadeStart() {
        return this.fadeStart;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    private CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, long j, TimeSource timeSource, boolean z, boolean z2) {
        this.end = painter2;
        this.contentScale = contentScale;
        this.duration = j;
        this.timeSource = timeSource;
        this.fadeStart = z;
        this.preferExactIntrinsicSize = z2;
        this.invalidateTick = SnapshotIntStateKt.mutableIntStateOf(0);
        this.maxAlpha = 1.0f;
        this.start = painter;
        this.intrinsicSize = m1014computeIntrinsicSizexjbvk4A(painter, painter2);
    }

    private final int getInvalidateTick() {
        return this.invalidateTick.getIntValue();
    }

    private final void setInvalidateTick(int i) {
        this.invalidateTick.setIntValue(i);
    }

    public final Painter getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name and from getter */
    public long getIntrinsicSize() {
        return this.intrinsicSize;
    }

    protected void onDraw(DrawScope drawScope) {
        if (this.isDone) {
            drawPainter(drawScope, this.end, this.maxAlpha);
            return;
        }
        TimeMark timeMarkMarkNow = this.startTime;
        if (timeMarkMarkNow == null) {
            timeMarkMarkNow = this.timeSource.markNow();
            this.startTime = timeMarkMarkNow;
        }
        float f = Duration.getInWholeMilliseconds-impl(timeMarkMarkNow.elapsedNow-UwyO8pc()) / Duration.getInWholeMilliseconds-impl(this.duration);
        float fCoerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        float f2 = this.maxAlpha;
        float f3 = fCoerceIn * f2;
        if (this.fadeStart) {
            f2 -= f3;
        }
        this.isDone = f >= 1.0f;
        drawPainter(drawScope, this.start, f2);
        drawPainter(drawScope, this.end, f3);
        if (this.isDone) {
            this.start = null;
        } else {
            setInvalidateTick(getInvalidateTick() + 1);
        }
    }

    protected boolean applyAlpha(float alpha) {
        this.maxAlpha = alpha;
        return true;
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    /* JADX INFO: renamed from: computeIntrinsicSize-xjbvk4A, reason: not valid java name */
    private final long m1014computeIntrinsicSizexjbvk4A(Painter start, Painter end) {
        long j = start != null ? start.getIntrinsicSize-NH-jbRc() : Size.Companion.getZero-NH-jbRc();
        long j2 = end != null ? end.getIntrinsicSize-NH-jbRc() : Size.Companion.getZero-NH-jbRc();
        boolean z = j != 9205357640488583168L;
        boolean z2 = j2 != 9205357640488583168L;
        if (z && z2) {
            float fMax = Math.max(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)));
            return Size.constructor-impl((((long) Float.floatToRawIntBits(Math.max(Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 & 4294967295L))))) & 4294967295L) | (((long) Float.floatToRawIntBits(fMax)) << 32));
        }
        if (this.preferExactIntrinsicSize) {
            if (z) {
                return j;
            }
            if (z2) {
                return j2;
            }
        }
        return Size.Companion.getUnspecified-NH-jbRc();
    }

    private final void drawPainter(DrawScope drawScope, Painter painter, float f) {
        if (painter == null || f <= 0.0f) {
            return;
        }
        long j = drawScope.getSize-NH-jbRc();
        long jM1013computeDrawSizex8L_9b0 = m1013computeDrawSizex8L_9b0(painter.getIntrinsicSize-NH-jbRc(), j);
        if (j == 9205357640488583168L || Size.isEmpty-impl(j)) {
            painter.draw-x_KDEd0(drawScope, jM1013computeDrawSizex8L_9b0, f, this.colorFilter);
            return;
        }
        float f2 = 2;
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (jM1013computeDrawSizex8L_9b0 >> 32))) / f2;
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (jM1013computeDrawSizex8L_9b0 & 4294967295L))) / f2;
        drawScope.getDrawContext().getTransform().inset(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat, fIntBitsToFloat2);
        try {
            painter.draw-x_KDEd0(drawScope, jM1013computeDrawSizex8L_9b0, f, this.colorFilter);
        } finally {
            float f3 = -fIntBitsToFloat;
            float f4 = -fIntBitsToFloat2;
            drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
        }
    }

    /* JADX INFO: renamed from: computeDrawSize-x8L_9b0, reason: not valid java name */
    private final long m1013computeDrawSizex8L_9b0(long srcSize, long dstSize) {
        return (srcSize == 9205357640488583168L || Size.isEmpty-impl(srcSize) || dstSize == 9205357640488583168L || Size.isEmpty-impl(dstSize)) ? dstSize : ScaleFactorKt.times-UQTWf7w(srcSize, this.contentScale.computeScaleFactor-H7hwNQA(srcSize, dstSize));
    }
}
