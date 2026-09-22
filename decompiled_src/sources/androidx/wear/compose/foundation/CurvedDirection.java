package androidx.wear.compose.foundation;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedDirection.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/wear/compose/foundation/CurvedDirection;", "", "Angular", "Radial", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CurvedDirection {

    /* JADX INFO: compiled from: CurvedDirection.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0017"}, d2 = {"Landroidx/wear/compose/foundation/CurvedDirection$Angular;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "resolveClockwise", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resolveClockwise-impl$compose_foundation_release", "(ILandroidx/compose/ui/unit/LayoutDirection;)Z", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Angular {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Normal = m283constructorimpl(0);
        private static final int Reversed = m283constructorimpl(1);
        private static final int Clockwise = m283constructorimpl(2);
        private static final int CounterClockwise = m283constructorimpl(3);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Angular m282boximpl(int i) {
            return new Angular(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m283constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m284equalsimpl(int i, Object obj) {
            return (obj instanceof Angular) && i == ((Angular) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m285equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m286hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m288toStringimpl(int i) {
            return "Angular(value=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m284equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m286hashCodeimpl(this.value);
        }

        public String toString() {
            return m288toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        private /* synthetic */ Angular(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: resolveClockwise-impl$compose_foundation_release, reason: not valid java name */
        public static final boolean m287resolveClockwiseimpl$compose_foundation_release(int i, LayoutDirection layoutDirection) {
            boolean z = layoutDirection == LayoutDirection.Ltr;
            if (m285equalsimpl0(i, Reversed)) {
                return !z;
            }
            if (m285equalsimpl0(i, Clockwise)) {
                return true;
            }
            if (m285equalsimpl0(i, CounterClockwise)) {
                return false;
            }
            return z;
        }

        /* JADX INFO: compiled from: CurvedDirection.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/wear/compose/foundation/CurvedDirection$Angular$Companion;", "", "()V", "Clockwise", "Landroidx/wear/compose/foundation/CurvedDirection$Angular;", "getClockwise-gmlPZk4", "()I", "I", "CounterClockwise", "getCounterClockwise-gmlPZk4", "Normal", "getNormal-gmlPZk4", "Reversed", "getReversed-gmlPZk4", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getNormal-gmlPZk4, reason: not valid java name */
            public final int m292getNormalgmlPZk4() {
                return Angular.Normal;
            }

            /* JADX INFO: renamed from: getReversed-gmlPZk4, reason: not valid java name */
            public final int m293getReversedgmlPZk4() {
                return Angular.Reversed;
            }

            /* JADX INFO: renamed from: getClockwise-gmlPZk4, reason: not valid java name */
            public final int m290getClockwisegmlPZk4() {
                return Angular.Clockwise;
            }

            /* JADX INFO: renamed from: getCounterClockwise-gmlPZk4, reason: not valid java name */
            public final int m291getCounterClockwisegmlPZk4() {
                return Angular.CounterClockwise;
            }
        }
    }

    /* JADX INFO: compiled from: CurvedDirection.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/wear/compose/foundation/CurvedDirection$Radial;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Radial {
        private final int value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int OutsideIn = m295constructorimpl(0);
        private static final int InsideOut = m295constructorimpl(1);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Radial m294boximpl(int i) {
            return new Radial(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m295constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m296equalsimpl(int i, Object obj) {
            return (obj instanceof Radial) && i == ((Radial) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m297equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m298hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m299toStringimpl(int i) {
            return "Radial(value=" + i + ')';
        }

        public boolean equals(Object obj) {
            return m296equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m298hashCodeimpl(this.value);
        }

        public String toString() {
            return m299toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: CurvedDirection.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/wear/compose/foundation/CurvedDirection$Radial$Companion;", "", "()V", "InsideOut", "Landroidx/wear/compose/foundation/CurvedDirection$Radial;", "getInsideOut-Ysh6JRM", "()I", "I", "OutsideIn", "getOutsideIn-Ysh6JRM", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getOutsideIn-Ysh6JRM, reason: not valid java name */
            public final int m302getOutsideInYsh6JRM() {
                return Radial.OutsideIn;
            }

            /* JADX INFO: renamed from: getInsideOut-Ysh6JRM, reason: not valid java name */
            public final int m301getInsideOutYsh6JRM() {
                return Radial.InsideOut;
            }
        }

        private /* synthetic */ Radial(int i) {
            this.value = i;
        }
    }
}
