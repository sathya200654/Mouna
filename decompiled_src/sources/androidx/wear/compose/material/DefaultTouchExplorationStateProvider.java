package androidx.wear.compose.material;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchExplorationStateProvider.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0017¢\u0006\u0002\u0010\u0006J7\u0010\u0007\u001a\u00020\b*\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/wear/compose/material/DefaultTouchExplorationStateProvider;", "Landroidx/wear/compose/material/TouchExplorationStateProvider;", "()V", "touchExplorationState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "ObserveState", "", "Landroidx/lifecycle/Lifecycle;", "handleEvent", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "onDispose", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Listener", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultTouchExplorationStateProvider implements TouchExplorationStateProvider {
    public static final int $stable = 0;

    @Override // androidx.wear.compose.material.TouchExplorationStateProvider
    public State<Boolean> touchExplorationState(Composer composer, int i) {
        composer.startReplaceGroup(-121883960);
        ComposerKt.sourceInformation(composer, "C(touchExplorationState)58@2416L7,59@2459L112,63@2596L43,65@2669L7,66@2727L246,73@2999L205,65@2687L527:TouchExplorationStateProvider.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-121883960, i, -1, "androidx.wear.compose.material.DefaultTouchExplorationStateProvider.touchExplorationState (TouchExplorationStateProvider.kt:57)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, -1281327827, "CC(remember):TouchExplorationStateProvider.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            Object systemService = context.getSystemService("accessibility");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            objRememberedValue = (AccessibilityManager) systemService;
            composer.updateRememberedValue(objRememberedValue);
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1281323512, "CC(remember):TouchExplorationStateProvider.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Listener(accessibilityManager);
            composer.updateRememberedValue(objRememberedValue2);
        }
        final Listener listener = (Listener) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        CompositionLocal localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Lifecycle lifecycle = ((LifecycleOwner) objConsume2).getLifecycle();
        ComposerKt.sourceInformationMarkerStart(composer, -1281319117, "CC(remember):TouchExplorationStateProvider.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.Companion.getEmpty()) {
            objRememberedValue3 = (Function1) new Function1<Lifecycle.Event, Unit>() { // from class: androidx.wear.compose.material.DefaultTouchExplorationStateProvider$touchExplorationState$1$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Lifecycle.Event) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_RESUME) {
                        listener.register();
                    } else if (event == Lifecycle.Event.ON_PAUSE) {
                        listener.unregister();
                    }
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function1<? super Lifecycle.Event, Unit> function1 = (Function1) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1281310454, "CC(remember):TouchExplorationStateProvider.kt#9igjgp");
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == Composer.Companion.getEmpty()) {
            objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.DefaultTouchExplorationStateProvider$touchExplorationState$2$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m590invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m590invoke() {
                    listener.unregister();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ObserveState(lifecycle, function1, (Function0) objRememberedValue4, composer, ((i << 9) & 7168) | 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ObserveState(final Lifecycle lifecycle, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1255032864);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ObserveState)88@3430L301,88@3407L324:TouchExplorationStateProvider.kt#gj9v0t");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(lifecycle) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                function1 = new Function1<Lifecycle.Event, Unit>() { // from class: androidx.wear.compose.material.DefaultTouchExplorationStateProvider.ObserveState.1
                    public final void invoke(Lifecycle.Event event) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Lifecycle.Event) obj);
                        return Unit.INSTANCE;
                    }
                };
            }
            if (i5 != 0) {
                function0 = new Function0<Unit>() { // from class: androidx.wear.compose.material.DefaultTouchExplorationStateProvider.ObserveState.2
                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m589invoke() {
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m589invoke();
                        return Unit.INSTANCE;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1255032864, i3, -1, "androidx.wear.compose.material.DefaultTouchExplorationStateProvider.ObserveState (TouchExplorationStateProvider.kt:87)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1411986286, "CC(remember):TouchExplorationStateProvider.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(lifecycle) | ((i3 & 896) == 256);
            DefaultTouchExplorationStateProvider$ObserveState$3$1 defaultTouchExplorationStateProvider$ObserveState$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || defaultTouchExplorationStateProvider$ObserveState$3$1RememberedValue == Composer.Companion.getEmpty()) {
                defaultTouchExplorationStateProvider$ObserveState$3$1RememberedValue = new DefaultTouchExplorationStateProvider$ObserveState$3$1(lifecycle, function1, function0);
                composerStartRestartGroup.updateRememberedValue(defaultTouchExplorationStateProvider$ObserveState$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(lifecycle, (Function1) defaultTouchExplorationStateProvider$ObserveState$3$1RememberedValue, composerStartRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Function1<? super Lifecycle.Event, Unit> function2 = function1;
        final Function0<Unit> function3 = function0;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.DefaultTouchExplorationStateProvider.ObserveState.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    DefaultTouchExplorationStateProvider.this.ObserveState(lifecycle, function2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TouchExplorationStateProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018R+\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Landroidx/wear/compose/material/DefaultTouchExplorationStateProvider$Listener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "Landroidx/compose/runtime/State;", "", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "(Landroid/view/accessibility/AccessibilityManager;)V", "<set-?>", "accessibilityEnabled", "getAccessibilityEnabled", "()Z", "setAccessibilityEnabled", "(Z)V", "accessibilityEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "touchExplorationEnabled", "getTouchExplorationEnabled", "setTouchExplorationEnabled", "touchExplorationEnabled$delegate", "value", "getValue", "()Ljava/lang/Boolean;", "onAccessibilityStateChanged", "", "it", "onTouchExplorationStateChanged", "register", "unregister", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class Listener implements AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener, State<Boolean> {

        /* JADX INFO: renamed from: accessibilityEnabled$delegate, reason: from kotlin metadata */
        private final MutableState accessibilityEnabled;
        private final AccessibilityManager accessibilityManager;

        /* JADX INFO: renamed from: touchExplorationEnabled$delegate, reason: from kotlin metadata */
        private final MutableState touchExplorationEnabled;

        public Listener(AccessibilityManager accessibilityManager) {
            this.accessibilityManager = accessibilityManager;
            this.accessibilityEnabled = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(accessibilityManager.isEnabled()), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.touchExplorationEnabled = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(accessibilityManager.isTouchExplorationEnabled()), (SnapshotMutationPolicy) null, 2, (Object) null);
        }

        private final boolean getAccessibilityEnabled() {
            return ((Boolean) this.accessibilityEnabled.getValue()).booleanValue();
        }

        private final void setAccessibilityEnabled(boolean z) {
            this.accessibilityEnabled.setValue(Boolean.valueOf(z));
        }

        private final boolean getTouchExplorationEnabled() {
            return ((Boolean) this.touchExplorationEnabled.getValue()).booleanValue();
        }

        private final void setTouchExplorationEnabled(boolean z) {
            this.touchExplorationEnabled.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: renamed from: getValue, reason: merged with bridge method [inline-methods] */
        public Boolean m588getValue() {
            return Boolean.valueOf(getAccessibilityEnabled() && getTouchExplorationEnabled());
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean it) {
            setAccessibilityEnabled(it);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean it) {
            setTouchExplorationEnabled(it);
        }

        public final void register() {
            setAccessibilityEnabled(this.accessibilityManager.isEnabled());
            setTouchExplorationEnabled(this.accessibilityManager.isTouchExplorationEnabled());
            this.accessibilityManager.addTouchExplorationStateChangeListener(this);
            this.accessibilityManager.addAccessibilityStateChangeListener(this);
        }

        public final void unregister() {
            this.accessibilityManager.removeTouchExplorationStateChangeListener(this);
            this.accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
    }
}
