package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CurvedColumn.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0002\b\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"curvedColumn", "", "Landroidx/wear/compose/foundation/CurvedScope;", "modifier", "Landroidx/wear/compose/foundation/CurvedModifier;", "radialDirection", "Landroidx/wear/compose/foundation/CurvedDirection$Radial;", "angularAlignment", "Landroidx/wear/compose/foundation/CurvedAlignment$Angular;", "contentBuilder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "curvedColumn-6v4VuIY", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedColumnKt {
    /* JADX INFO: renamed from: curvedColumn-6v4VuIY$default, reason: not valid java name */
    public static /* synthetic */ void m278curvedColumn6v4VuIY$default(CurvedScope curvedScope, CurvedModifier curvedModifier, CurvedDirection.Radial radial, CurvedAlignment.Angular angular, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            curvedModifier = CurvedModifier.INSTANCE;
        }
        if ((i & 2) != 0) {
            radial = null;
        }
        if ((i & 4) != 0) {
            angular = null;
        }
        m277curvedColumn6v4VuIY(curvedScope, curvedModifier, radial, angular, function1);
    }

    /* JADX INFO: renamed from: curvedColumn-6v4VuIY, reason: not valid java name */
    public static final void m277curvedColumn6v4VuIY(CurvedScope curvedScope, CurvedModifier curvedModifier, CurvedDirection.Radial radial, CurvedAlignment.Angular angular, Function1<? super CurvedScope, Unit> function1) {
        curvedScope.add$compose_foundation_release(new CurvedColumnChild(CurvedLayoutDirection.m315copy3m8pbNU$default(curvedScope.getCurvedLayoutDirection(), radial, null, 2, null), angular, function1, null), curvedModifier);
    }
}
