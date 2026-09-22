package androidx.wear.compose.materialcore;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RepeatableClickable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a|\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007ø\u0001\u0000¢\u0006\u0002\b\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u008a\u0084\u0002²\u0006\u0010\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0007X\u008a\u008e\u0002"}, d2 = {"repeatableClickable", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "initialDelay", "", "incrementalDelay", "onClick", "Lkotlin/Function0;", "", "onRepeatableClick", "repeatableClickable-XVZzFYc", "compose-material-core_release", "currentOnRepeatableClick", "currentOnClick", "ignoreOnClick"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RepeatableClickableKt {
    /* JADX INFO: renamed from: repeatableClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m912repeatableClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, long j, long j2, Function0<Unit> function0, Function0<Unit> function1) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new RepeatableClickableKt$repeatableClickable$1(function1, function0, mutableInteractionSource, indication, z, str, role, j, j2), 1, (Object) null);
    }
}
