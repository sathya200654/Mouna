package androidx.wear.compose.foundation;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedModifier.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/wear/compose/foundation/CurvedModifierImpl;", "Landroidx/wear/compose/foundation/CurvedModifier;", "elements", "", "Landroidx/wear/compose/foundation/Element;", "(Ljava/util/List;)V", "getElements$compose_foundation_release", "()Ljava/util/List;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class CurvedModifierImpl implements CurvedModifier {
    public static final int $stable = 0;
    private final List<Element> elements;

    /* JADX WARN: Multi-variable type inference failed */
    public CurvedModifierImpl(List<? extends Element> list) {
        this.elements = list;
    }

    public final List<Element> getElements$compose_foundation_release() {
        return this.elements;
    }
}
