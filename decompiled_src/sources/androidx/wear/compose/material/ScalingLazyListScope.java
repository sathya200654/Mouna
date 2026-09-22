package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ScalingLazyColumn.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ScalingLazyScopeMarker
@Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\nJo\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000621\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\u0002\b\b¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\u0013\u0082\u0001\u0001\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/wear/compose/material/ScalingLazyListScope;", "", "item", "", "key", "content", "Lkotlin/Function1;", "Landroidx/wear/compose/material/ScalingLazyListItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "Landroidx/wear/compose/material/ScalingLazyListScopeImpl;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ScalingLazyListScope {
    void item(Object key, Function3<? super ScalingLazyListItemScope, ? super Composer, ? super Integer, Unit> content);

    void items(int count, Function1<? super Integer, ? extends Object> key, Function4<? super ScalingLazyListItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent);

    static /* synthetic */ void item$default(ScalingLazyListScope scalingLazyListScope, Object obj, Function3 function3, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        scalingLazyListScope.item(obj, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void items$default(ScalingLazyListScope scalingLazyListScope, int i, Function1 function1, Function4 function4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        scalingLazyListScope.items(i, function1, function4);
    }
}
