package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/wear/compose/foundation/RevealValue;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class RevealValue {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Covered = m399constructorimpl(0);
    private static final int Revealing = m399constructorimpl(1);
    private static final int Revealed = m399constructorimpl(2);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RevealValue m398boximpl(int i) {
        return new RevealValue(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m399constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m400equalsimpl(int i, Object obj) {
        return (obj instanceof RevealValue) && i == ((RevealValue) obj).m404unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m401equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m402hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m403toStringimpl(int i) {
        return "RevealValue(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m400equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m402hashCodeimpl(this.value);
    }

    public String toString() {
        return m403toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m404unboximpl() {
        return this.value;
    }

    /* JADX INFO: compiled from: SwipeToReveal.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/wear/compose/foundation/RevealValue$Companion;", "", "()V", "Covered", "Landroidx/wear/compose/foundation/RevealValue;", "getCovered-EhNvi2Q", "()I", "I", "Revealed", "getRevealed-EhNvi2Q", "Revealing", "getRevealing-EhNvi2Q", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getCovered-EhNvi2Q, reason: not valid java name */
        public final int m405getCoveredEhNvi2Q() {
            return RevealValue.Covered;
        }

        /* JADX INFO: renamed from: getRevealing-EhNvi2Q, reason: not valid java name */
        public final int m407getRevealingEhNvi2Q() {
            return RevealValue.Revealing;
        }

        /* JADX INFO: renamed from: getRevealed-EhNvi2Q, reason: not valid java name */
        public final int m406getRevealedEhNvi2Q() {
            return RevealValue.Revealed;
        }
    }

    private /* synthetic */ RevealValue(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
