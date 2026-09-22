package coil3.compose;

import coil3.Image;
import coil3.ImageLoader;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: LocalAsyncImagePreviewHandler.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class AsyncImagePreviewHandler$Companion$Default$1 implements AsyncImagePreviewHandler {
    public static final AsyncImagePreviewHandler$Companion$Default$1 INSTANCE = new AsyncImagePreviewHandler$Companion$Default$1();

    AsyncImagePreviewHandler$Companion$Default$1() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // coil3.compose.AsyncImagePreviewHandler
    public final Object handle(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) throws NoWhenBranchMatchedException {
        AsyncImagePreviewHandler$Companion$Default$1$handle$1 asyncImagePreviewHandler$Companion$Default$1$handle$1;
        if (continuation instanceof AsyncImagePreviewHandler$Companion$Default$1$handle$1) {
            asyncImagePreviewHandler$Companion$Default$1$handle$1 = (AsyncImagePreviewHandler$Companion$Default$1$handle$1) continuation;
            if ((asyncImagePreviewHandler$Companion$Default$1$handle$1.label & Integer.MIN_VALUE) != 0) {
                asyncImagePreviewHandler$Companion$Default$1$handle$1.label -= Integer.MIN_VALUE;
            } else {
                asyncImagePreviewHandler$Companion$Default$1$handle$1 = new AsyncImagePreviewHandler$Companion$Default$1$handle$1(this, continuation);
            }
        } else {
            asyncImagePreviewHandler$Companion$Default$1$handle$1 = new AsyncImagePreviewHandler$Companion$Default$1$handle$1(this, continuation);
        }
        Object objExecute = asyncImagePreviewHandler$Companion$Default$1$handle$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = asyncImagePreviewHandler$Companion$Default$1$handle$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objExecute);
            asyncImagePreviewHandler$Companion$Default$1$handle$1.L$0 = SpillingKt.nullOutSpilledVariable(imageLoader);
            asyncImagePreviewHandler$Companion$Default$1$handle$1.L$1 = imageRequest;
            asyncImagePreviewHandler$Companion$Default$1$handle$1.label = 1;
            objExecute = imageLoader.execute(imageRequest, asyncImagePreviewHandler$Companion$Default$1$handle$1);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            imageRequest = (ImageRequest) asyncImagePreviewHandler$Companion$Default$1$handle$1.L$1;
            ResultKt.throwOnFailure(objExecute);
        }
        ImageResult imageResult = (ImageResult) objExecute;
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new AsyncImagePainter.State.Success(ImagePainter_androidKt.m1019asPainter55t9rM$default(successResult.getImage(), imageRequest.getContext(), 0, 2, null), successResult);
        }
        if (!(imageResult instanceof ErrorResult)) {
            throw new NoWhenBranchMatchedException();
        }
        ErrorResult errorResult = (ErrorResult) imageResult;
        Image image = errorResult.getImage();
        return new AsyncImagePainter.State.Error(image != null ? ImagePainter_androidKt.m1019asPainter55t9rM$default(image, imageRequest.getContext(), 0, 2, null) : null, errorResult);
    }
}
