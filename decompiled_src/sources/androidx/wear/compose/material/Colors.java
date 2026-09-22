package androidx.wear.compose.material;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Colors.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\u0092\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020$H\u0016R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0019\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001f\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/wear/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onSurfaceVariant", "onError", "(JJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "J", "getError-0d7_KjU", "getOnBackground-0d7_KjU", "getOnError-0d7_KjU", "getOnPrimary-0d7_KjU", "getOnSecondary-0d7_KjU", "getOnSurface-0d7_KjU", "getOnSurfaceVariant-0d7_KjU", "getPrimary-0d7_KjU", "getPrimaryVariant-0d7_KjU", "getSecondary-0d7_KjU", "getSecondaryVariant-0d7_KjU", "getSurface-0d7_KjU", "copy", "copy-daRQuJA", "(JJJJJJJJJJJJJ)Landroidx/wear/compose/material/Colors;", "toString", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Colors {
    public static final int $stable = 0;
    private final long background;
    private final long error;
    private final long onBackground;
    private final long onError;
    private final long onPrimary;
    private final long onSecondary;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long primary;
    private final long primaryVariant;
    private final long secondary;
    private final long secondaryVariant;
    private final long surface;

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13);
    }

    private Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
        this.primary = j;
        this.primaryVariant = j2;
        this.secondary = j3;
        this.secondaryVariant = j4;
        this.background = j5;
        this.surface = j6;
        this.error = j7;
        this.onPrimary = j8;
        this.onSecondary = j9;
        this.onBackground = j10;
        this.onSurface = j11;
        this.onSurfaceVariant = j12;
        this.onError = j13;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long jColor = (i & 1) != 0 ? ColorKt.Color(4289645562L) : j;
        long jColor2 = (i & 2) != 0 ? ColorKt.Color(4287280376L) : j2;
        long jColor3 = (i & 4) != 0 ? ColorKt.Color(4294828691L) : j3;
        long jColor4 = (i & 8) != 0 ? ColorKt.Color(4284043059L) : j4;
        long j14 = (i & 16) != 0 ? Color.Companion.getBlack-0d7_KjU() : j5;
        long jColor5 = (i & 32) != 0 ? ColorKt.Color(4281348403L) : j6;
        long jColor6 = (i & 64) != 0 ? ColorKt.Color(4293814108L) : j7;
        long jColor7 = (i & 128) != 0 ? ColorKt.Color(4281348403L) : j8;
        this(jColor, jColor2, jColor3, jColor4, j14, jColor5, jColor6, jColor7, (i & 256) != 0 ? ColorKt.Color(4281348403L) : j9, (i & 512) != 0 ? Color.Companion.getWhite-0d7_KjU() : j10, (i & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? Color.Companion.getWhite-0d7_KjU() : j11, (i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? ColorKt.Color(4292533472L) : j12, (i & 4096) != 0 ? ColorKt.Color(4278190080L) : j13, null);
    }

    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimary() {
        return this.primary;
    }

    /* JADX INFO: renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimaryVariant() {
        return this.primaryVariant;
    }

    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondary() {
        return this.secondary;
    }

    /* JADX INFO: renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondaryVariant() {
        return this.secondaryVariant;
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurface() {
        return this.surface;
    }

    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name and from getter */
    public final long getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnPrimary() {
        return this.onPrimary;
    }

    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSecondary() {
        return this.onSecondary;
    }

    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnBackground() {
        return this.onBackground;
    }

    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSurface() {
        return this.onSurface;
    }

    /* JADX INFO: renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnError() {
        return this.onError;
    }

    /* JADX INFO: renamed from: copy-daRQuJA$default, reason: not valid java name */
    public static /* synthetic */ Colors m558copydaRQuJA$default(Colors colors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i, Object obj) {
        long j14;
        long j15;
        long j16 = (i & 1) != 0 ? colors.primary : j;
        long j17 = (i & 2) != 0 ? colors.primaryVariant : j2;
        long j18 = (i & 4) != 0 ? colors.secondary : j3;
        long j19 = (i & 8) != 0 ? colors.secondaryVariant : j4;
        long j20 = (i & 16) != 0 ? colors.background : j5;
        long j21 = (i & 32) != 0 ? colors.surface : j6;
        long j22 = (i & 64) != 0 ? colors.error : j7;
        long j23 = j16;
        long j24 = (i & 128) != 0 ? colors.onPrimary : j8;
        long j25 = (i & 256) != 0 ? colors.onSecondary : j9;
        long j26 = (i & 512) != 0 ? colors.onBackground : j10;
        long j27 = (i & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? colors.onSurface : j11;
        long j28 = (i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? colors.onSurfaceVariant : j12;
        if ((i & 4096) != 0) {
            j15 = j28;
            j14 = colors.onError;
        } else {
            j14 = j13;
            j15 = j28;
        }
        return colors.m559copydaRQuJA(j23, j17, j18, j19, j20, j21, j22, j24, j25, j26, j27, j15, j14);
    }

    /* JADX INFO: renamed from: copy-daRQuJA, reason: not valid java name */
    public final Colors m559copydaRQuJA(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onSurfaceVariant, long onError) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onSurfaceVariant, onError, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Colors(primary=");
        sb.append((Object) Color.toString-impl(this.primary)).append(", primaryVariant=").append((Object) Color.toString-impl(this.primaryVariant)).append(", secondary=").append((Object) Color.toString-impl(this.secondary)).append(", secondaryVariant=").append((Object) Color.toString-impl(this.secondaryVariant)).append(", background=").append((Object) Color.toString-impl(this.background)).append(", surface=").append((Object) Color.toString-impl(this.surface)).append(", error=").append((Object) Color.toString-impl(this.error)).append(", onPrimary=").append((Object) Color.toString-impl(this.onPrimary)).append(", onSecondary=").append((Object) Color.toString-impl(this.onSecondary)).append(", onBackground=").append((Object) Color.toString-impl(this.onBackground)).append(", onSurface=").append((Object) Color.toString-impl(this.onSurface)).append(", onSurfaceVariant=");
        sb.append((Object) Color.toString-impl(this.onSurfaceVariant)).append(", onError=").append((Object) Color.toString-impl(this.onError)).append(')');
        return sb.toString();
    }
}
