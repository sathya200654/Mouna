package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingBackend.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final /* synthetic */ class EmbeddingBackend$Companion$overrideDecorator$1 extends FunctionReferenceImpl implements Function1<EmbeddingBackend, EmbeddingBackend> {
    EmbeddingBackend$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, EmbeddingBackendDecorator.class, "decorate", "decorate(Landroidx/window/embedding/EmbeddingBackend;)Landroidx/window/embedding/EmbeddingBackend;", 0);
    }

    public final EmbeddingBackend invoke(EmbeddingBackend embeddingBackend) {
        Intrinsics.checkNotNullParameter(embeddingBackend, "p0");
        return ((EmbeddingBackendDecorator) this.receiver).decorate(embeddingBackend);
    }
}
