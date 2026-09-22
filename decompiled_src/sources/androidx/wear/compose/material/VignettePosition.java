package androidx.wear.compose.material;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Vignette.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0017"}, d2 = {"Landroidx/wear/compose/material/VignettePosition;", "", "key", "", "constructor-impl", "(I)I", "drawBottom", "", "drawBottom-impl$compose_material_release", "(I)Z", "drawTop", "drawTop-impl$compose_material_release", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class VignettePosition {
    private final int key;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Top = m871constructorimpl(0);
    private static final int Bottom = m871constructorimpl(1);
    private static final int TopAndBottom = m871constructorimpl(2);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ VignettePosition m870boximpl(int i) {
        return new VignettePosition(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m871constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: drawBottom-impl$compose_material_release, reason: not valid java name */
    public static final boolean m872drawBottomimpl$compose_material_release(int i) {
        return i != 0;
    }

    /* JADX INFO: renamed from: drawTop-impl$compose_material_release, reason: not valid java name */
    public static final boolean m873drawTopimpl$compose_material_release(int i) {
        return i != 1;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m874equalsimpl(int i, Object obj) {
        return (obj instanceof VignettePosition) && i == ((VignettePosition) obj).getKey();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m875equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m876hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m874equalsimpl(this.key, obj);
    }

    public int hashCode() {
        return m876hashCodeimpl(this.key);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getKey() {
        return this.key;
    }

    private /* synthetic */ VignettePosition(int i) {
        this.key = i;
    }

    /* JADX INFO: compiled from: Vignette.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/wear/compose/material/VignettePosition$Companion;", "", "()V", "Bottom", "Landroidx/wear/compose/material/VignettePosition;", "getBottom-GuQh5Jg", "()I", "I", "Top", "getTop-GuQh5Jg", "TopAndBottom", "getTopAndBottom-GuQh5Jg", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getTop-GuQh5Jg, reason: not valid java name */
        public final int m880getTopGuQh5Jg() {
            return VignettePosition.Top;
        }

        /* JADX INFO: renamed from: getBottom-GuQh5Jg, reason: not valid java name */
        public final int m879getBottomGuQh5Jg() {
            return VignettePosition.Bottom;
        }

        /* JADX INFO: renamed from: getTopAndBottom-GuQh5Jg, reason: not valid java name */
        public final int m881getTopAndBottomGuQh5Jg() {
            return VignettePosition.TopAndBottom;
        }
    }

    public String toString() {
        return m877toStringimpl(this.key);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m877toStringimpl(int i) {
        if (m875equalsimpl0(i, Top)) {
            return "VignetteValue.Top";
        }
        return m875equalsimpl0(i, Bottom) ? "VignetteValue.Bottom" : "VignetteValue.Both";
    }
}
