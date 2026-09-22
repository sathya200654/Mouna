package androidx.wear.compose.foundation.rotary;

import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import kotlin.Metadata;

/* JADX INFO: compiled from: RotaryVelocityTracker.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryVelocityTracker;", "", "()V", "velocity", "", "getVelocity", "()F", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "end", "", "move", "currentTime", "", "delta", "start", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RotaryVelocityTracker {
    public static final int $stable = 8;
    private VelocityTracker1D velocityTracker = new VelocityTracker1D(true);

    public final float getVelocity() {
        return this.velocityTracker.calculateVelocity();
    }

    public final void start(long currentTime) {
        this.velocityTracker.resetTracking();
        this.velocityTracker.addDataPoint(currentTime, 0.0f);
    }

    public final void move(long currentTime, float delta) {
        this.velocityTracker.addDataPoint(currentTime, delta);
    }

    public final void end() {
        this.velocityTracker.resetTracking();
    }
}
