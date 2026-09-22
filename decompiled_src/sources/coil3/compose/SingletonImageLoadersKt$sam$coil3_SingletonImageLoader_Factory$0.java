package coil3.compose;

import android.content.Context;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: singletonImageLoaders.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class SingletonImageLoadersKt$sam$coil3_SingletonImageLoader_Factory$0 implements SingletonImageLoader.Factory, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    SingletonImageLoadersKt$sam$coil3_SingletonImageLoader_Factory$0(Function1 function1) {
        this.function = function1;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof SingletonImageLoader.Factory) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // coil3.SingletonImageLoader.Factory
    public final /* synthetic */ ImageLoader newImageLoader(Context context) {
        return (ImageLoader) this.function.invoke(context);
    }
}
