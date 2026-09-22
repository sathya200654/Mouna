package androidx.wear.compose.foundation;

import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CurvedModifier.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0080\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\t"}, d2 = {"elements", "", "Landroidx/wear/compose/foundation/Element;", "Landroidx/wear/compose/foundation/CurvedModifier;", "then", "other", "wrap", "Landroidx/wear/compose/foundation/CurvedChild;", "child", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedModifierKt {
    public static final List<Element> elements(CurvedModifier curvedModifier) {
        if (Intrinsics.areEqual(curvedModifier, CurvedModifier.INSTANCE)) {
            return CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(curvedModifier, "null cannot be cast to non-null type androidx.wear.compose.foundation.CurvedModifierImpl");
        return ((CurvedModifierImpl) curvedModifier).getElements$compose_foundation_release();
    }

    public static final CurvedModifier then(CurvedModifier curvedModifier, Element element) {
        return new CurvedModifierImpl(CollectionsKt.plus(elements(curvedModifier), element));
    }

    public static final CurvedChild wrap(CurvedModifier curvedModifier, CurvedChild curvedChild) {
        List<Element> listElements = elements(curvedModifier);
        if (!listElements.isEmpty()) {
            ListIterator<Element> listIterator = listElements.listIterator(listElements.size());
            while (listIterator.hasPrevious()) {
                curvedChild = listIterator.previous().wrap(curvedChild);
            }
        }
        return curvedChild;
    }
}
