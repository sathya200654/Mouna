package androidx.wear.compose.foundation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/wear/compose/foundation/RevealScopeImpl;", "Landroidx/wear/compose/foundation/RevealScope;", "revealState", "Landroidx/wear/compose/foundation/RevealState;", "(Landroidx/wear/compose/foundation/RevealState;)V", "lastActionType", "Landroidx/wear/compose/foundation/RevealActionType;", "getLastActionType-Bxv7xxc", "()I", "revealOffset", "", "getRevealOffset", "()F", "getRevealState", "()Landroidx/wear/compose/foundation/RevealState;", "width", "Landroidx/compose/runtime/MutableFloatState;", "getWidth", "()Landroidx/compose/runtime/MutableFloatState;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RevealScopeImpl implements RevealScope {
    private final RevealState revealState;
    private final MutableFloatState width = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    public RevealScopeImpl(RevealState revealState) {
        this.revealState = revealState;
    }

    public final RevealState getRevealState() {
        return this.revealState;
    }

    public final MutableFloatState getWidth() {
        return this.width;
    }

    @Override // androidx.wear.compose.foundation.RevealScope
    public float getRevealOffset() {
        float floatValue = this.width.getFloatValue();
        Float f = this.revealState.getSwipeAnchors().get(RevealValue.m398boximpl(RevealValue.INSTANCE.m407getRevealingEhNvi2Q()));
        return floatValue * (f != null ? f.floatValue() : 0.0f);
    }

    @Override // androidx.wear.compose.foundation.RevealScope
    /* JADX INFO: renamed from: getLastActionType-Bxv7xxc */
    public int mo388getLastActionTypeBxv7xxc() {
        return this.revealState.m393getLastActionTypeBxv7xxc();
    }
}
