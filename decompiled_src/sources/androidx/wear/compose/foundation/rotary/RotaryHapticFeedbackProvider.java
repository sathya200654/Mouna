package androidx.wear.compose.foundation.rotary;

import android.view.View;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Haptics.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryHapticFeedbackProvider;", "", "view", "Landroid/view/View;", "hapticConstants", "Landroidx/wear/compose/foundation/rotary/HapticConstants;", "(Landroid/view/View;Landroidx/wear/compose/foundation/rotary/HapticConstants;)V", "performHapticFeedback", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/wear/compose/foundation/rotary/RotaryHapticsType;", "performHapticFeedback-gZ48kpk", "(I)V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RotaryHapticFeedbackProvider {
    private final HapticConstants hapticConstants;
    private final View view;

    public RotaryHapticFeedbackProvider(View view, HapticConstants hapticConstants) {
        this.view = view;
        this.hapticConstants = hapticConstants;
    }

    /* JADX INFO: renamed from: performHapticFeedback-gZ48kpk, reason: not valid java name */
    public final void m484performHapticFeedbackgZ48kpk(int type) {
        Integer scrollLimit;
        if (RotaryHapticsType.m488equalsimpl0(type, RotaryHapticsType.INSTANCE.m492getScrollItemFocusuC3O9gs())) {
            Integer scrollFocus = this.hapticConstants.getScrollFocus();
            if (scrollFocus != null) {
                this.view.performHapticFeedback(scrollFocus.intValue());
                return;
            }
            return;
        }
        if (RotaryHapticsType.m488equalsimpl0(type, RotaryHapticsType.INSTANCE.m494getScrollTickuC3O9gs())) {
            Integer scrollTick = this.hapticConstants.getScrollTick();
            if (scrollTick != null) {
                this.view.performHapticFeedback(scrollTick.intValue());
                return;
            }
            return;
        }
        if (!RotaryHapticsType.m488equalsimpl0(type, RotaryHapticsType.INSTANCE.m493getScrollLimituC3O9gs()) || (scrollLimit = this.hapticConstants.getScrollLimit()) == null) {
            return;
        }
        this.view.performHapticFeedback(scrollLimit.intValue());
    }
}
