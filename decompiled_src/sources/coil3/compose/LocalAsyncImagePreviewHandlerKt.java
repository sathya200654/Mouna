package coil3.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import coil3.Image;
import coil3.ImageLoader;
import coil3.request.ImageRequest;
import coil3.request.SuccessResult;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LocalAsyncImagePreviewHandler.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aE\u0010\u0007\u001a\u00020\u000223\b\u0004\u0010\b\u001a-\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tH\u0087\b¢\u0006\u0004\b\u0011\u0010\u0012\u001aE\u0010\u0007\u001a\u00020\u000225\b\u0004\u0010\b\u001a/\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tH\u0087\b¢\u0006\u0002\u0010\u0012\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"LocalAsyncImagePreviewHandler", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcoil3/compose/AsyncImagePreviewHandler;", "getLocalAsyncImagePreviewHandler$annotations", "()V", "getLocalAsyncImagePreviewHandler", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "AsyncImagePreviewHandler", "image", "Lkotlin/Function2;", "Lcoil3/request/ImageRequest;", "Lkotlin/ParameterName;", "name", "request", "Lkotlin/coroutines/Continuation;", "Lcoil3/Image;", "", "AsyncImagePreviewHandlerNotNull", "(Lkotlin/jvm/functions/Function2;)Lcoil3/compose/AsyncImagePreviewHandler;", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LocalAsyncImagePreviewHandlerKt {
    private static final ProvidableCompositionLocal<AsyncImagePreviewHandler> LocalAsyncImagePreviewHandler = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: coil3.compose.LocalAsyncImagePreviewHandlerKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            return AsyncImagePreviewHandler.Default;
        }
    });

    public static /* synthetic */ void getLocalAsyncImagePreviewHandler$annotations() {
    }

    public static final ProvidableCompositionLocal<AsyncImagePreviewHandler> getLocalAsyncImagePreviewHandler() {
        return LocalAsyncImagePreviewHandler;
    }

    /* JADX INFO: renamed from: coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1, reason: invalid class name */
    /* JADX INFO: compiled from: LocalAsyncImagePreviewHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    public static final class AnonymousClass1 implements AsyncImagePreviewHandler {
        final /* synthetic */ Function2<ImageRequest, Continuation<? super Image>, Object> $image;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function2<? super ImageRequest, ? super Continuation<? super Image>, ? extends Object> function2) {
            this.$image = function2;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // coil3.compose.AsyncImagePreviewHandler
        public final Object handle(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
            LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1;
            if (continuation instanceof LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1) {
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 = (LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1) continuation;
                if ((localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label & Integer.MIN_VALUE) != 0) {
                    localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label -= Integer.MIN_VALUE;
                } else {
                    localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 = new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1(this, continuation);
                }
            } else {
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1 = new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1(this, continuation);
            }
            Object objInvoke = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Function2<ImageRequest, Continuation<? super Image>, Object> function2 = this.$image;
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.L$0 = imageRequest;
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.label = 1;
                objInvoke = function2.invoke(imageRequest, localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                imageRequest = (ImageRequest) localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            ImageRequest imageRequest2 = imageRequest;
            Image image = (Image) objInvoke;
            return new AsyncImagePainter.State.Success(ImagePainter_androidKt.m1019asPainter55t9rM$default(image, imageRequest2.getContext(), 0, 2, null), new SuccessResult(image, imageRequest2, null, null, null, false, false, 124, null));
        }

        public final Object handle$$forInline(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
            new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$1$handle$1(this, continuation);
            Image image = (Image) this.$image.invoke(imageRequest, continuation);
            return new AsyncImagePainter.State.Success(ImagePainter_androidKt.m1019asPainter55t9rM$default(image, imageRequest.getContext(), 0, 2, null), new SuccessResult(image, imageRequest, null, null, null, false, false, 124, null));
        }
    }

    public static final AsyncImagePreviewHandler AsyncImagePreviewHandlerNotNull(Function2<? super ImageRequest, ? super Continuation<? super Image>, ? extends Object> function2) {
        return new AnonymousClass1(function2);
    }

    /* JADX INFO: renamed from: coil3.compose.LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2, reason: invalid class name */
    /* JADX INFO: compiled from: LocalAsyncImagePreviewHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    public static final class AnonymousClass2 implements AsyncImagePreviewHandler {
        final /* synthetic */ Function2<ImageRequest, Continuation<? super Image>, Object> $image;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function2<? super ImageRequest, ? super Continuation<? super Image>, ? extends Object> function2) {
            this.$image = function2;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // coil3.compose.AsyncImagePreviewHandler
        public final Object handle(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
            LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1 localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1;
            if (continuation instanceof LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1) {
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1 = (LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1) continuation;
                if ((localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1.label & Integer.MIN_VALUE) != 0) {
                    localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1.label -= Integer.MIN_VALUE;
                } else {
                    localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1 = new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1(this, continuation);
                }
            } else {
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1 = new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1(this, continuation);
            }
            Object objInvoke = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Function2<ImageRequest, Continuation<? super Image>, Object> function2 = this.$image;
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1.L$0 = imageRequest;
                localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1.label = 1;
                objInvoke = function2.invoke(imageRequest, localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                imageRequest = (ImageRequest) localAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1.L$0;
                ResultKt.throwOnFailure(objInvoke);
            }
            Image image = (Image) objInvoke;
            return new AsyncImagePainter.State.Loading(image != null ? ImagePainter_androidKt.m1019asPainter55t9rM$default(image, imageRequest.getContext(), 0, 2, null) : null);
        }

        public final Object handle$$forInline(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
            new LocalAsyncImagePreviewHandlerKt$AsyncImagePreviewHandler$2$handle$1(this, continuation);
            Image image = (Image) this.$image.invoke(imageRequest, continuation);
            return new AsyncImagePainter.State.Loading(image != null ? ImagePainter_androidKt.m1019asPainter55t9rM$default(image, imageRequest.getContext(), 0, 2, null) : null);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to the AsyncImagePreviewHandler constructor that returns a not null Image. Alternatively, if you need to return a nullable Image, inline this code into your call site.", replaceWith = @ReplaceWith(expression = "AsyncImagePreviewHandler { _, request -> AsyncImagePainter.State.Loading(image(request)?.asPainter(request.context)) }", imports = {"coil3.compose.AsyncImagePainter"}))
    public static final AsyncImagePreviewHandler AsyncImagePreviewHandler(Function2<? super ImageRequest, ? super Continuation<? super Image>, ? extends Object> function2) {
        return new AnonymousClass2(function2);
    }
}
