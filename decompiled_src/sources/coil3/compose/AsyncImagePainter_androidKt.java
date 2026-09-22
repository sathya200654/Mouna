package coil3.compose;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil3.request.ErrorResult;
import coil3.request.ImageRequests_androidKt;
import coil3.request.SuccessResult;
import coil3.transition.CrossfadeTransition;
import coil3.transition.Transition;
import coil3.transition.TransitionTarget;
import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: AsyncImagePainter.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0001\b\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\"\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n"}, d2 = {"maybeNewCrossfadePainter", "Lcoil3/compose/CrossfadePainter;", "previous", "Lcoil3/compose/AsyncImagePainter$State;", "current", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "FakeTransitionTarget", "coil3/compose/AsyncImagePainter_androidKt$FakeTransitionTarget$1", "Lcoil3/compose/AsyncImagePainter_androidKt$FakeTransitionTarget$1;", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AsyncImagePainter_androidKt {
    private static final AsyncImagePainter_androidKt$FakeTransitionTarget$1 FakeTransitionTarget = new TransitionTarget() { // from class: coil3.compose.AsyncImagePainter_androidKt$FakeTransitionTarget$1
        @Override // coil3.transition.TransitionTarget
        public Drawable getDrawable() {
            return null;
        }

        @Override // coil3.transition.TransitionTarget
        public View getView() {
            throw new UnsupportedOperationException();
        }
    };

    public static final CrossfadePainter maybeNewCrossfadePainter(AsyncImagePainter.State state, AsyncImagePainter.State state2, ContentScale contentScale) {
        ErrorResult result;
        if (!(state2 instanceof AsyncImagePainter.State.Success)) {
            if (state2 instanceof AsyncImagePainter.State.Error) {
                result = ((AsyncImagePainter.State.Error) state2).getResult();
            }
            return null;
        }
        result = ((AsyncImagePainter.State.Success) state2).getResult();
        Transition transitionCreate = ImageRequests_androidKt.getTransitionFactory(result.getRequest()).create(FakeTransitionTarget, result);
        if (transitionCreate instanceof CrossfadeTransition) {
            Painter painter = state instanceof AsyncImagePainter.State.Loading ? state.getPainter() : null;
            Painter painter2 = state2.getPainter();
            Duration.Companion companion = Duration.Companion;
            CrossfadeTransition crossfadeTransition = (CrossfadeTransition) transitionCreate;
            return new CrossfadePainter(painter, painter2, contentScale, DurationKt.toDuration(crossfadeTransition.getDurationMillis(), DurationUnit.MILLISECONDS), null, ((result instanceof SuccessResult) && ((SuccessResult) result).getIsPlaceholderCached()) ? false : true, crossfadeTransition.getPreferExactIntrinsicSize(), 16, null);
        }
        return null;
    }
}
