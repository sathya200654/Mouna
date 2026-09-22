package androidx.wear.compose.foundation.rotary;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0004HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÂ\u0003J\u001a\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bHÂ\u0003J8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bHÆ\u0001J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\f\u0010\u001b\u001a\u00020\n*\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryHandlerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/wear/compose/foundation/rotary/RotaryInputNode;", "behavior", "Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;", "reverseDirection", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/wear/compose/foundation/rotary/RotaryScrollableBehavior;ZLkotlin/jvm/functions/Function1;)V", "component1", "component2", "component3", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class RotaryHandlerElement extends ModifierNodeElement<RotaryInputNode> {
    private final RotaryScrollableBehavior behavior;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final boolean reverseDirection;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final RotaryScrollableBehavior getBehavior() {
        return this.behavior;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    private final Function1<InspectorInfo, Unit> component3() {
        return this.inspectorInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RotaryHandlerElement copy$default(RotaryHandlerElement rotaryHandlerElement, RotaryScrollableBehavior rotaryScrollableBehavior, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            rotaryScrollableBehavior = rotaryHandlerElement.behavior;
        }
        if ((i & 2) != 0) {
            z = rotaryHandlerElement.reverseDirection;
        }
        if ((i & 4) != 0) {
            function1 = rotaryHandlerElement.inspectorInfo;
        }
        return rotaryHandlerElement.copy(rotaryScrollableBehavior, z, function1);
    }

    public final RotaryHandlerElement copy(RotaryScrollableBehavior behavior, boolean reverseDirection, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        return new RotaryHandlerElement(behavior, reverseDirection, inspectorInfo);
    }

    public String toString() {
        return "RotaryHandlerElement(behavior=" + this.behavior + ", reverseDirection=" + this.reverseDirection + ", inspectorInfo=" + this.inspectorInfo + ')';
    }

    public RotaryHandlerElement(RotaryScrollableBehavior rotaryScrollableBehavior, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        this.behavior = rotaryScrollableBehavior;
        this.reverseDirection = z;
        this.inspectorInfo = function1;
    }

    public RotaryInputNode create() {
        return new RotaryInputNode(this.behavior, this.reverseDirection);
    }

    public void update(RotaryInputNode node) {
        node.setBehavior(this.behavior);
        node.setReverseDirection(this.reverseDirection);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.inspectorInfo.invoke(inspectorInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        RotaryHandlerElement rotaryHandlerElement = (RotaryHandlerElement) other;
        return Intrinsics.areEqual(this.behavior, rotaryHandlerElement.behavior) && this.reverseDirection == rotaryHandlerElement.reverseDirection;
    }

    public int hashCode() {
        return (this.behavior.hashCode() * 31) + Boolean.hashCode(this.reverseDirection);
    }
}
