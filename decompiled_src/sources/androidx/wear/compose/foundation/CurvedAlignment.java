package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedAlignment.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/wear/compose/foundation/CurvedAlignment;", "", "Angular", "Radial", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CurvedAlignment {

    /* JADX INFO: compiled from: CurvedAlignment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/wear/compose/foundation/CurvedAlignment$Radial;", "", "ratio", "", "constructor-impl", "(F)F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Radial {
        private final float ratio;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final float Inner = m264constructorimpl(1.0f);
        private static final float Center = m264constructorimpl(0.5f);
        private static final float Outer = m264constructorimpl(0.0f);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Radial m263boximpl(float f) {
            return new Radial(f);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static float m264constructorimpl(float f) {
            return f;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m265equalsimpl(float f, Object obj) {
            return (obj instanceof Radial) && Float.compare(f, ((Radial) obj).getRatio()) == 0;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m266equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m267hashCodeimpl(float f) {
            return Float.hashCode(f);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m268toStringimpl(float f) {
            return "Radial(ratio=" + f + ')';
        }

        public boolean equals(Object obj) {
            return m265equalsimpl(this.ratio, obj);
        }

        public int hashCode() {
            return m267hashCodeimpl(this.ratio);
        }

        public String toString() {
            return m268toStringimpl(this.ratio);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ float getRatio() {
            return this.ratio;
        }

        /* JADX INFO: compiled from: CurvedAlignment.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/wear/compose/foundation/CurvedAlignment$Radial$Companion;", "", "()V", "Center", "Landroidx/wear/compose/foundation/CurvedAlignment$Radial;", "getCenter-BjYtHoc", "()F", "F", "Inner", "getInner-BjYtHoc", "Outer", "getOuter-BjYtHoc", "Custom", "ratio", "", "Custom-Tt6c-v8", "(F)F", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getInner-BjYtHoc, reason: not valid java name */
            public final float m272getInnerBjYtHoc() {
                return Radial.Inner;
            }

            /* JADX INFO: renamed from: getCenter-BjYtHoc, reason: not valid java name */
            public final float m271getCenterBjYtHoc() {
                return Radial.Center;
            }

            /* JADX INFO: renamed from: getOuter-BjYtHoc, reason: not valid java name */
            public final float m273getOuterBjYtHoc() {
                return Radial.Outer;
            }

            /* JADX INFO: renamed from: Custom-Tt6c-v8, reason: not valid java name */
            public final float m270CustomTt6cv8(float ratio) {
                return Radial.m264constructorimpl(ratio);
            }
        }

        private /* synthetic */ Radial(float f) {
            this.ratio = f;
        }
    }

    /* JADX INFO: compiled from: CurvedAlignment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/wear/compose/foundation/CurvedAlignment$Angular;", "", "ratio", "", "constructor-impl", "(F)F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Angular {
        private final float ratio;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final float Start = m253constructorimpl(0.0f);
        private static final float Center = m253constructorimpl(0.5f);
        private static final float End = m253constructorimpl(1.0f);

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Angular m252boximpl(float f) {
            return new Angular(f);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static float m253constructorimpl(float f) {
            return f;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m254equalsimpl(float f, Object obj) {
            return (obj instanceof Angular) && Float.compare(f, ((Angular) obj).getRatio()) == 0;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m255equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m256hashCodeimpl(float f) {
            return Float.hashCode(f);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m257toStringimpl(float f) {
            return "Angular(ratio=" + f + ')';
        }

        public boolean equals(Object obj) {
            return m254equalsimpl(this.ratio, obj);
        }

        public int hashCode() {
            return m256hashCodeimpl(this.ratio);
        }

        public String toString() {
            return m257toStringimpl(this.ratio);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ float getRatio() {
            return this.ratio;
        }

        /* JADX INFO: compiled from: CurvedAlignment.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/wear/compose/foundation/CurvedAlignment$Angular$Companion;", "", "()V", "Center", "Landroidx/wear/compose/foundation/CurvedAlignment$Angular;", "getCenter-yWRYBYk", "()F", "F", "End", "getEnd-yWRYBYk", "Start", "getStart-yWRYBYk", "Custom", "ratio", "", "Custom-MIL3zXU", "(F)F", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getStart-yWRYBYk, reason: not valid java name */
            public final float m262getStartyWRYBYk() {
                return Angular.Start;
            }

            /* JADX INFO: renamed from: getCenter-yWRYBYk, reason: not valid java name */
            public final float m260getCenteryWRYBYk() {
                return Angular.Center;
            }

            /* JADX INFO: renamed from: getEnd-yWRYBYk, reason: not valid java name */
            public final float m261getEndyWRYBYk() {
                return Angular.End;
            }

            /* JADX INFO: renamed from: Custom-MIL3zXU, reason: not valid java name */
            public final float m259CustomMIL3zXU(float ratio) {
                return Angular.m253constructorimpl(ratio);
            }
        }

        private /* synthetic */ Angular(float f) {
            this.ratio = f;
        }
    }
}
