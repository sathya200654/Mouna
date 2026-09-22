package androidx.wear.compose.material;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/wear/compose/material/PositionIndicatorVisibility;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class PositionIndicatorVisibility {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Show = m718constructorimpl(1);
    private static final int Hide = m718constructorimpl(2);
    private static final int AutoHide = m718constructorimpl(3);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PositionIndicatorVisibility m717boximpl(int i) {
        return new PositionIndicatorVisibility(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m718constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m719equalsimpl(int i, Object obj) {
        return (obj instanceof PositionIndicatorVisibility) && i == ((PositionIndicatorVisibility) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m720equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m721hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m722toStringimpl(int i) {
        return "PositionIndicatorVisibility(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m719equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m721hashCodeimpl(this.value);
    }

    public String toString() {
        return m722toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: PositionIndicator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/wear/compose/material/PositionIndicatorVisibility$Companion;", "", "()V", "AutoHide", "Landroidx/wear/compose/material/PositionIndicatorVisibility;", "getAutoHide-GLQwCHQ", "()I", "I", "Hide", "getHide-GLQwCHQ", "Show", "getShow-GLQwCHQ", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getShow-GLQwCHQ, reason: not valid java name */
        public final int m726getShowGLQwCHQ() {
            return PositionIndicatorVisibility.Show;
        }

        /* JADX INFO: renamed from: getHide-GLQwCHQ, reason: not valid java name */
        public final int m725getHideGLQwCHQ() {
            return PositionIndicatorVisibility.Hide;
        }

        /* JADX INFO: renamed from: getAutoHide-GLQwCHQ, reason: not valid java name */
        public final int m724getAutoHideGLQwCHQ() {
            return PositionIndicatorVisibility.AutoHide;
        }
    }

    private /* synthetic */ PositionIndicatorVisibility(int i) {
        this.value = i;
    }
}
