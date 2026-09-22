package androidx.wear.compose.foundation.rotary;

import com.google.wear.input.WearHapticFeedbackConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Haptics.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B%\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b\u0082\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Landroidx/wear/compose/foundation/rotary/HapticConstants;", "", "scrollFocus", "", "scrollTick", "scrollLimit", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getScrollFocus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScrollLimit", "getScrollTick", "DisabledHapticConstants", "GalaxyWatchConstants", "Wear3Point5RotaryHapticConstants", "Wear4RotaryHapticConstants", "WearSDKHapticConstants", "Landroidx/wear/compose/foundation/rotary/HapticConstants$DisabledHapticConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants$GalaxyWatchConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants$Wear3Point5RotaryHapticConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants$Wear4RotaryHapticConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants$WearSDKHapticConstants;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class HapticConstants {
    public static final int $stable = 0;
    private final Integer scrollFocus;
    private final Integer scrollLimit;
    private final Integer scrollTick;

    public /* synthetic */ HapticConstants(Integer num, Integer num2, Integer num3, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2, num3);
    }

    private HapticConstants(Integer num, Integer num2, Integer num3) {
        this.scrollFocus = num;
        this.scrollTick = num2;
        this.scrollLimit = num3;
    }

    public final Integer getScrollFocus() {
        return this.scrollFocus;
    }

    public final Integer getScrollTick() {
        return this.scrollTick;
    }

    public final Integer getScrollLimit() {
        return this.scrollLimit;
    }

    /* JADX INFO: compiled from: Haptics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/wear/compose/foundation/rotary/HapticConstants$WearSDKHapticConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants;", "()V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WearSDKHapticConstants extends HapticConstants {
        public static final int $stable = 0;
        public static final WearSDKHapticConstants INSTANCE = new WearSDKHapticConstants();

        private WearSDKHapticConstants() {
            super(Integer.valueOf(WearHapticFeedbackConstants.getScrollItemFocus()), Integer.valueOf(WearHapticFeedbackConstants.getScrollTick()), Integer.valueOf(WearHapticFeedbackConstants.getScrollLimit()), null);
        }
    }

    /* JADX INFO: compiled from: Haptics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/wear/compose/foundation/rotary/HapticConstants$GalaxyWatchConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants;", "()V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class GalaxyWatchConstants extends HapticConstants {
        public static final int $stable = 0;
        public static final GalaxyWatchConstants INSTANCE = new GalaxyWatchConstants();

        private GalaxyWatchConstants() {
            super(102, 101, 50107, null);
        }
    }

    /* JADX INFO: compiled from: Haptics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/wear/compose/foundation/rotary/HapticConstants$Wear4RotaryHapticConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants;", "()V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Wear4RotaryHapticConstants extends HapticConstants {
        public static final int $stable = 0;
        public static final Wear4RotaryHapticConstants INSTANCE = new Wear4RotaryHapticConstants();

        private Wear4RotaryHapticConstants() {
            super(19, 18, 20, null);
        }
    }

    /* JADX INFO: compiled from: Haptics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/wear/compose/foundation/rotary/HapticConstants$Wear3Point5RotaryHapticConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants;", "()V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Wear3Point5RotaryHapticConstants extends HapticConstants {
        public static final int $stable = 0;
        public static final Wear3Point5RotaryHapticConstants INSTANCE = new Wear3Point5RotaryHapticConstants();

        /* JADX WARN: Illegal instructions before constructor call */
        private Wear3Point5RotaryHapticConstants() {
            int i = 10003;
            super(i, 10002, i, null);
        }
    }

    /* JADX INFO: compiled from: Haptics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/wear/compose/foundation/rotary/HapticConstants$DisabledHapticConstants;", "Landroidx/wear/compose/foundation/rotary/HapticConstants;", "()V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DisabledHapticConstants extends HapticConstants {
        public static final int $stable = 0;
        public static final DisabledHapticConstants INSTANCE = new DisabledHapticConstants();

        /* JADX WARN: Illegal instructions before constructor call */
        private DisabledHapticConstants() {
            Integer num = null;
            super(num, num, num, num);
        }
    }
}
