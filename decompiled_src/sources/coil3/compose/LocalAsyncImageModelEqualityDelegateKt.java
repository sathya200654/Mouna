package coil3.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LocalAsyncImageModelEqualityDelegate.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LocalAsyncImageModelEqualityDelegate", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcoil3/compose/AsyncImageModelEqualityDelegate;", "getLocalAsyncImageModelEqualityDelegate$annotations", "()V", "getLocalAsyncImageModelEqualityDelegate", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LocalAsyncImageModelEqualityDelegateKt {
    private static final ProvidableCompositionLocal<AsyncImageModelEqualityDelegate> LocalAsyncImageModelEqualityDelegate = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: coil3.compose.LocalAsyncImageModelEqualityDelegateKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            return AsyncImageModelEqualityDelegate.Default;
        }
    });

    public static /* synthetic */ void getLocalAsyncImageModelEqualityDelegate$annotations() {
    }

    public static final ProvidableCompositionLocal<AsyncImageModelEqualityDelegate> getLocalAsyncImageModelEqualityDelegate() {
        return LocalAsyncImageModelEqualityDelegate;
    }
}
