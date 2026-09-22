package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CurvedParentData.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"parentDataModifier", "Landroidx/wear/compose/foundation/CurvedModifier;", "modifyParentData", "Lkotlin/Function1;", "", "weight", "", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedParentDataKt {
    public static final CurvedModifier parentDataModifier(CurvedModifier curvedModifier, final Function1<Object, ? extends Object> function1) {
        return CurvedModifierKt.then(curvedModifier, new Element() { // from class: androidx.wear.compose.foundation.CurvedParentDataKt$$ExternalSyntheticLambda0
            @Override // androidx.wear.compose.foundation.Element
            public final CurvedChild wrap(CurvedChild curvedChild) {
                return CurvedParentDataKt.parentDataModifier$lambda$0(function1, curvedChild);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CurvedChild parentDataModifier$lambda$0(Function1 function1, CurvedChild curvedChild) {
        return new ParentDataWrapper(curvedChild, function1);
    }

    public static final CurvedModifier weight(CurvedModifier curvedModifier, final float f) {
        return parentDataModifier(curvedModifier, new Function1<Object, Object>() { // from class: androidx.wear.compose.foundation.CurvedParentDataKt.weight.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(Object obj) {
                if (f <= 0.0f) {
                    throw new IllegalArgumentException("Weights must be positive.".toString());
                }
                CurvedScopeParentData curvedScopeParentData = obj instanceof CurvedScopeParentData ? (CurvedScopeParentData) obj : null;
                if (curvedScopeParentData == null) {
                    curvedScopeParentData = new CurvedScopeParentData(0.0f, 1, null);
                }
                curvedScopeParentData.setWeight(f);
                return curvedScopeParentData;
            }
        });
    }
}
