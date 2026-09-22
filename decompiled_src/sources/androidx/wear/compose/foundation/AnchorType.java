package androidx.wear.compose.foundation;

import com.azure.core.implementation.SemanticVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedLayout.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/wear/compose/foundation/AnchorType;", "", "ratio", "", "constructor-impl", "(F)F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class AnchorType {
    private final float ratio;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Start = m215constructorimpl(0.0f);
    private static final float Center = m215constructorimpl(0.5f);
    private static final float End = m215constructorimpl(1.0f);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AnchorType m214boximpl(float f) {
        return new AnchorType(f);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m215constructorimpl(float f) {
        return f;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m216equalsimpl(float f, Object obj) {
        return (obj instanceof AnchorType) && Float.compare(f, ((AnchorType) obj).getRatio()) == 0;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m217equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m218hashCodeimpl(float f) {
        return Float.hashCode(f);
    }

    public boolean equals(Object obj) {
        return m216equalsimpl(this.ratio, obj);
    }

    public int hashCode() {
        return m218hashCodeimpl(this.ratio);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ float getRatio() {
        return this.ratio;
    }

    /* JADX INFO: compiled from: CurvedLayout.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/wear/compose/foundation/AnchorType$Companion;", "", "()V", "Center", "Landroidx/wear/compose/foundation/AnchorType;", "getCenter-IUldqTk", "()F", "F", "End", "getEnd-IUldqTk", "Start", "getStart-IUldqTk", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getStart-IUldqTk, reason: not valid java name */
        public final float m223getStartIUldqTk() {
            return AnchorType.Start;
        }

        /* JADX INFO: renamed from: getCenter-IUldqTk, reason: not valid java name */
        public final float m221getCenterIUldqTk() {
            return AnchorType.Center;
        }

        /* JADX INFO: renamed from: getEnd-IUldqTk, reason: not valid java name */
        public final float m222getEndIUldqTk() {
            return AnchorType.End;
        }
    }

    private /* synthetic */ AnchorType(float f) {
        this.ratio = f;
    }

    public String toString() {
        return m219toStringimpl(this.ratio);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m219toStringimpl(float f) {
        if (m217equalsimpl0(f, Center)) {
            return "AnchorType.Center";
        }
        if (m217equalsimpl0(f, Start)) {
            return "AnchorType.Start";
        }
        return m217equalsimpl0(f, End) ? "AnchorType.End" : SemanticVersion.UNKNOWN_VERSION;
    }
}
