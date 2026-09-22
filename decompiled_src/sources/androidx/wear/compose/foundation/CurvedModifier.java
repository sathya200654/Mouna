package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: CurvedModifier.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\u0011\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0096\u0004\u0082\u0001\u0002\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/wear/compose/foundation/CurvedModifier;", "", "then", "other", "Companion", "Landroidx/wear/compose/foundation/CurvedModifier$Companion;", "Landroidx/wear/compose/foundation/CurvedModifierImpl;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CurvedModifier {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: CurvedModifier.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static CurvedModifier then(CurvedModifier curvedModifier, CurvedModifier curvedModifier2) {
            return CurvedModifier.super.then(curvedModifier2);
        }
    }

    default CurvedModifier then(CurvedModifier other) {
        return new CurvedModifierImpl(CollectionsKt.plus(CurvedModifierKt.elements(this), CurvedModifierKt.elements(other)));
    }

    /* JADX INFO: compiled from: CurvedModifier.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Landroidx/wear/compose/foundation/CurvedModifier$Companion;", "Landroidx/wear/compose/foundation/CurvedModifier;", "()V", "toString", "", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements CurvedModifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public String toString() {
            return "CurvedModifier";
        }
    }
}
