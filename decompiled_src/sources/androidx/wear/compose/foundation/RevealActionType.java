package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/wear/compose/foundation/RevealActionType;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class RevealActionType {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int PrimaryAction = m378constructorimpl(0);
    private static final int SecondaryAction = m378constructorimpl(1);
    private static final int UndoAction = m378constructorimpl(2);
    private static final int None = m378constructorimpl(-1);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RevealActionType m377boximpl(int i) {
        return new RevealActionType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m378constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m379equalsimpl(int i, Object obj) {
        return (obj instanceof RevealActionType) && i == ((RevealActionType) obj).m383unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m380equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m381hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m382toStringimpl(int i) {
        return "RevealActionType(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m379equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m381hashCodeimpl(this.value);
    }

    public String toString() {
        return m382toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m383unboximpl() {
        return this.value;
    }

    /* JADX INFO: compiled from: SwipeToReveal.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/wear/compose/foundation/RevealActionType$Companion;", "", "()V", "None", "Landroidx/wear/compose/foundation/RevealActionType;", "getNone-Bxv7xxc", "()I", "I", "PrimaryAction", "getPrimaryAction-Bxv7xxc", "SecondaryAction", "getSecondaryAction-Bxv7xxc", "UndoAction", "getUndoAction-Bxv7xxc", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getPrimaryAction-Bxv7xxc, reason: not valid java name */
        public final int m385getPrimaryActionBxv7xxc() {
            return RevealActionType.PrimaryAction;
        }

        /* JADX INFO: renamed from: getSecondaryAction-Bxv7xxc, reason: not valid java name */
        public final int m386getSecondaryActionBxv7xxc() {
            return RevealActionType.SecondaryAction;
        }

        /* JADX INFO: renamed from: getUndoAction-Bxv7xxc, reason: not valid java name */
        public final int m387getUndoActionBxv7xxc() {
            return RevealActionType.UndoAction;
        }

        /* JADX INFO: renamed from: getNone-Bxv7xxc, reason: not valid java name */
        public final int m384getNoneBxv7xxc() {
            return RevealActionType.None;
        }
    }

    private /* synthetic */ RevealActionType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
