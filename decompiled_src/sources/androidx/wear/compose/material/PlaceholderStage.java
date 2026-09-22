package androidx.wear.compose.material;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/wear/compose/material/PlaceholderStage;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class PlaceholderStage {
    private final int type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ShowPlaceholder = m667constructorimpl(0);
    private static final int WipeOff = m667constructorimpl(1);
    private static final int ShowContent = m667constructorimpl(2);
    private static final int ResetContent = m667constructorimpl(3);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PlaceholderStage m666boximpl(int i) {
        return new PlaceholderStage(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m667constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m668equalsimpl(int i, Object obj) {
        return (obj instanceof PlaceholderStage) && i == ((PlaceholderStage) obj).getType();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m669equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m670hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m668equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m670hashCodeimpl(this.type);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getType() {
        return this.type;
    }

    private /* synthetic */ PlaceholderStage(int i) {
        this.type = i;
    }

    /* JADX INFO: compiled from: Placeholder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/wear/compose/material/PlaceholderStage$Companion;", "", "()V", "ResetContent", "Landroidx/wear/compose/material/PlaceholderStage;", "getResetContent-47HYLpQ", "()I", "I", "ShowContent", "getShowContent-47HYLpQ", "ShowPlaceholder", "getShowPlaceholder-47HYLpQ", "WipeOff", "getWipeOff-47HYLpQ", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getShowPlaceholder-47HYLpQ, reason: not valid java name */
        public final int m675getShowPlaceholder47HYLpQ() {
            return PlaceholderStage.ShowPlaceholder;
        }

        /* JADX INFO: renamed from: getWipeOff-47HYLpQ, reason: not valid java name */
        public final int m676getWipeOff47HYLpQ() {
            return PlaceholderStage.WipeOff;
        }

        /* JADX INFO: renamed from: getShowContent-47HYLpQ, reason: not valid java name */
        public final int m674getShowContent47HYLpQ() {
            return PlaceholderStage.ShowContent;
        }

        /* JADX INFO: renamed from: getResetContent-47HYLpQ, reason: not valid java name */
        public final int m673getResetContent47HYLpQ() {
            return PlaceholderStage.ResetContent;
        }
    }

    public String toString() {
        return m671toStringimpl(this.type);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m671toStringimpl(int i) {
        if (m669equalsimpl0(i, ShowPlaceholder)) {
            return "PlaceholderStage.ShowPlaceholder";
        }
        if (m669equalsimpl0(i, WipeOff)) {
            return "PlaceholderStage.WipeOff";
        }
        return m669equalsimpl0(i, ResetContent) ? "PlaceholderStage.ResetContent" : "PlaceholderStage.ShowContent";
    }
}
