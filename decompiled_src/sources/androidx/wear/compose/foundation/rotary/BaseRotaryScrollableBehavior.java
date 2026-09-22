package androidx.wear.compose.foundation.rotary;

import kotlin.Metadata;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Landroidx/wear/compose/foundation/rotary/BaseRotaryScrollableBehavior;", "Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "()V", "gestureThresholdTime", "", "previousScrollEventTime", "getPreviousScrollEventTime", "()J", "setPreviousScrollEventTime", "(J)V", "isNewScrollEvent", "", "timestamp", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseRotaryScrollableBehavior implements RotaryScrollableBehavior {
    public static final int $stable = 8;
    private final long gestureThresholdTime = 200;
    private long previousScrollEventTime = -1;

    protected final long getPreviousScrollEventTime() {
        return this.previousScrollEventTime;
    }

    protected final void setPreviousScrollEventTime(long j) {
        this.previousScrollEventTime = j;
    }

    protected final boolean isNewScrollEvent(long timestamp) {
        long j = this.previousScrollEventTime;
        return j == -1 || timestamp - j > this.gestureThresholdTime;
    }
}
