package androidx.wear.compose.foundation.rotary;

import androidx.compose.foundation.gestures.ScrollableState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: Haptics.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/wear/compose/foundation/rotary/CustomRotaryHapticHandler;", "Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "hapticsChannel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/wear/compose/foundation/rotary/RotaryHapticsType;", "hapticsThresholdPx", "", "(Landroidx/compose/foundation/gestures/ScrollableState;Lkotlinx/coroutines/channels/Channel;J)V", "currScrollPosition", "", "overscrollHapticTriggered", "", "prevHapticsPosition", "handleLimitHaptic", "", "isStart", "handleScrollHaptic", "timestamp", "deltaInPixels", "handleSnapHaptic", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CustomRotaryHapticHandler implements RotaryHapticHandler {
    private float currScrollPosition;
    private final Channel<RotaryHapticsType> hapticsChannel;
    private final long hapticsThresholdPx;
    private boolean overscrollHapticTriggered;
    private float prevHapticsPosition;
    private final ScrollableState scrollableState;

    public CustomRotaryHapticHandler(ScrollableState scrollableState, Channel<RotaryHapticsType> channel, long j) {
        this.scrollableState = scrollableState;
        this.hapticsChannel = channel;
        this.hapticsThresholdPx = j;
    }

    public /* synthetic */ CustomRotaryHapticHandler(ScrollableState scrollableState, Channel channel, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(scrollableState, channel, (i & 4) != 0 ? 50L : j);
    }

    @Override // androidx.wear.compose.foundation.rotary.RotaryHapticHandler
    public void handleScrollHaptic(long timestamp, float deltaInPixels) {
        if (HapticsKt.reachedTheLimit(this.scrollableState, deltaInPixels)) {
            handleLimitHaptic(this.scrollableState.getCanScrollBackward());
            return;
        }
        this.overscrollHapticTriggered = false;
        float f = this.currScrollPosition + deltaInPixels;
        this.currScrollPosition = f;
        if (Math.abs(f - this.prevHapticsPosition) >= this.hapticsThresholdPx) {
            this.hapticsChannel.trySend-JP2dKIU(RotaryHapticsType.m485boximpl(RotaryHapticsType.INSTANCE.m494getScrollTickuC3O9gs()));
            this.prevHapticsPosition = this.currScrollPosition;
        }
    }

    @Override // androidx.wear.compose.foundation.rotary.RotaryHapticHandler
    public void handleSnapHaptic(long timestamp, float deltaInPixels) {
        if (HapticsKt.reachedTheLimit(this.scrollableState, deltaInPixels)) {
            handleLimitHaptic(this.scrollableState.getCanScrollBackward());
        } else {
            this.overscrollHapticTriggered = false;
            this.hapticsChannel.trySend-JP2dKIU(RotaryHapticsType.m485boximpl(RotaryHapticsType.INSTANCE.m492getScrollItemFocusuC3O9gs()));
        }
    }

    @Override // androidx.wear.compose.foundation.rotary.RotaryHapticHandler
    public void handleLimitHaptic(boolean isStart) {
        if (this.overscrollHapticTriggered) {
            return;
        }
        this.hapticsChannel.trySend-JP2dKIU(RotaryHapticsType.m485boximpl(RotaryHapticsType.INSTANCE.m493getScrollLimituC3O9gs()));
        this.overscrollHapticTriggered = true;
    }
}
