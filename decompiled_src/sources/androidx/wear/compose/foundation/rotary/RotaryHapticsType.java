package androidx.wear.compose.foundation.rotary;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Haptics.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryHapticsType;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class RotaryHapticsType {
    private final int type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ScrollTick = m486constructorimpl(1);
    private static final int ScrollItemFocus = m486constructorimpl(2);
    private static final int ScrollLimit = m486constructorimpl(3);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RotaryHapticsType m485boximpl(int i) {
        return new RotaryHapticsType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m486constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m487equalsimpl(int i, Object obj) {
        return (obj instanceof RotaryHapticsType) && i == ((RotaryHapticsType) obj).getType();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m488equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m489hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m490toStringimpl(int i) {
        return "RotaryHapticsType(type=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m487equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m489hashCodeimpl(this.type);
    }

    public String toString() {
        return m490toStringimpl(this.type);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: Haptics.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryHapticsType$Companion;", "", "()V", "ScrollItemFocus", "Landroidx/wear/compose/foundation/rotary/RotaryHapticsType;", "getScrollItemFocus-uC3O9gs", "()I", "I", "ScrollLimit", "getScrollLimit-uC3O9gs", "ScrollTick", "getScrollTick-uC3O9gs", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getScrollTick-uC3O9gs, reason: not valid java name */
        public final int m494getScrollTickuC3O9gs() {
            return RotaryHapticsType.ScrollTick;
        }

        /* JADX INFO: renamed from: getScrollItemFocus-uC3O9gs, reason: not valid java name */
        public final int m492getScrollItemFocusuC3O9gs() {
            return RotaryHapticsType.ScrollItemFocus;
        }

        /* JADX INFO: renamed from: getScrollLimit-uC3O9gs, reason: not valid java name */
        public final int m493getScrollLimituC3O9gs() {
            return RotaryHapticsType.ScrollLimit;
        }
    }

    private /* synthetic */ RotaryHapticsType(int i) {
        this.type = i;
    }
}
