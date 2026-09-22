package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CurvedParentData.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016R!\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/wear/compose/foundation/ParentDataWrapper;", "Landroidx/wear/compose/foundation/BaseCurvedChildWrapper;", "child", "Landroidx/wear/compose/foundation/CurvedChild;", "modifyParentData", "Lkotlin/Function1;", "", "(Landroidx/wear/compose/foundation/CurvedChild;Lkotlin/jvm/functions/Function1;)V", "getModifyParentData", "()Lkotlin/jvm/functions/Function1;", "computeParentData", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParentDataWrapper extends BaseCurvedChildWrapper {
    public static final int $stable = 0;
    private final Function1<Object, Object> modifyParentData;

    public final Function1<Object, Object> getModifyParentData() {
        return this.modifyParentData;
    }

    public ParentDataWrapper(CurvedChild curvedChild, Function1<Object, ? extends Object> function1) {
        super(curvedChild);
        this.modifyParentData = function1;
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public Object computeParentData() {
        return this.modifyParentData.invoke(getWrapped().computeParentData());
    }
}
