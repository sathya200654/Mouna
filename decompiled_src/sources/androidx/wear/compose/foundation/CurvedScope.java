package androidx.wear.compose.foundation;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedContainer.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Landroidx/wear/compose/foundation/CurvedScope;", "", "curvedLayoutDirection", "Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "(Landroidx/wear/compose/foundation/CurvedLayoutDirection;)V", "getCurvedLayoutDirection$compose_foundation_release", "()Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "nodes", "", "Landroidx/wear/compose/foundation/CurvedChild;", "getNodes$compose_foundation_release", "()Ljava/util/List;", "add", "", "node", "modifier", "Landroidx/wear/compose/foundation/CurvedModifier;", "add$compose_foundation_release", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedScope {
    public static final int $stable = 8;
    private final CurvedLayoutDirection curvedLayoutDirection;
    private final List<CurvedChild> nodes = new ArrayList();

    public CurvedScope(CurvedLayoutDirection curvedLayoutDirection) {
        this.curvedLayoutDirection = curvedLayoutDirection;
    }

    /* JADX INFO: renamed from: getCurvedLayoutDirection$compose_foundation_release, reason: from getter */
    public final CurvedLayoutDirection getCurvedLayoutDirection() {
        return this.curvedLayoutDirection;
    }

    public final List<CurvedChild> getNodes$compose_foundation_release() {
        return this.nodes;
    }

    public final void add$compose_foundation_release(CurvedChild node, CurvedModifier modifier) {
        this.nodes.add(CurvedModifierKt.wrap(modifier, node));
    }
}
