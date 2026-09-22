package androidx.window.layout.adapter.extensions;

import androidx.window.extensions.layout.WindowLayoutInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionWindowBackendApi1.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1 extends FunctionReferenceImpl implements Function1<WindowLayoutInfo, Unit> {
    ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1(Object obj) {
        super(1, obj, MulticastConsumer.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WindowLayoutInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(WindowLayoutInfo windowLayoutInfo) {
        Intrinsics.checkNotNullParameter(windowLayoutInfo, "p0");
        ((MulticastConsumer) this.receiver).accept(windowLayoutInfo);
    }
}
