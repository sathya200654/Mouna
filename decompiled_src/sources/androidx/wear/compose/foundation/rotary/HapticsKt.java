package androidx.wear.compose.foundation.rotary;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.azure.core.implementation.logging.DefaultLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Haptics.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0082\b\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\b\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u001a\u001a\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0003¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010$\u001a\u0014\u0010%\u001a\u00020\u0001*\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0002\u001a&\u0010(\u001a\b\u0012\u0004\u0012\u0002H*0)\"\u0004\b\u0000\u0010**\b\u0012\u0004\u0012\u0002H*0)2\u0006\u0010+\u001a\u00020,H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {DefaultLogger.DEBUG, "", "WEAR_PLATFORM_MR_NUMBER", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "getCustomRotaryConstants", "Landroidx/wear/compose/foundation/rotary/HapticConstants;", "view", "Landroid/view/View;", "getWearPlatformMrNumber", "", "context", "Landroid/content/Context;", "hasWearSDK", "isGalaxyWatch", "isWear3_5", "isWear4", "rememberCustomRotaryHapticHandler", "Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/runtime/Composer;I)Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "rememberDisabledRotaryHapticHandler", "(Landroidx/compose/runtime/Composer;I)Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "rememberHapticChannel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/wear/compose/foundation/rotary/RotaryHapticsType;", "(Landroidx/compose/runtime/Composer;I)Lkotlinx/coroutines/channels/Channel;", "rememberRotaryHapticFeedbackProvider", "Landroidx/wear/compose/foundation/rotary/RotaryHapticFeedbackProvider;", "(Landroidx/compose/runtime/Composer;I)Landroidx/wear/compose/foundation/rotary/RotaryHapticFeedbackProvider;", "rememberRotaryHapticHandler", "hapticsEnabled", "(Landroidx/compose/foundation/gestures/ScrollableState;ZLandroidx/compose/runtime/Composer;I)Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "reachedTheLimit", "scrollDelta", "", "throttleLatest", "Lkotlinx/coroutines/flow/Flow;", "T", "timeframe", "", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HapticsKt {
    private static final boolean DEBUG = false;
    private static final String WEAR_PLATFORM_MR_NUMBER = "wear_platform_mr_number";

    private static final void debugLog(Function0<String> function0) {
    }

    public static final RotaryHapticHandler rememberRotaryHapticHandler(ScrollableState scrollableState, boolean z, Composer composer, int i) {
        RotaryHapticHandler rotaryHapticHandlerRememberDisabledRotaryHapticHandler;
        ComposerKt.sourceInformationMarkerStart(composer, 2088785009, "C(rememberRotaryHapticHandler)P(1):Haptics.kt#rtmq1y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2088785009, i, -1, "androidx.wear.compose.foundation.rotary.rememberRotaryHapticHandler (Haptics.kt:73)");
        }
        if (z) {
            composer.startReplaceGroup(-1540290577);
            ComposerKt.sourceInformation(composer, "75@2329L50");
            rotaryHapticHandlerRememberDisabledRotaryHapticHandler = rememberCustomRotaryHapticHandler(scrollableState, composer, i & 14);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1540123456);
            ComposerKt.sourceInformation(composer, "77@2401L37");
            rotaryHapticHandlerRememberDisabledRotaryHapticHandler = rememberDisabledRotaryHapticHandler(composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rotaryHapticHandlerRememberDisabledRotaryHapticHandler;
    }

    private static final RotaryHapticHandler rememberCustomRotaryHapticHandler(ScrollableState scrollableState, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1083730908, "C(rememberCustomRotaryHapticHandler)89@2765L38,91@2908L23,99@3277L734,99@3225L786,116@4023L153:Haptics.kt#rtmq1y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1083730908, i, -1, "androidx.wear.compose.foundation.rotary.rememberCustomRotaryHapticHandler (Haptics.kt:88)");
        }
        RotaryHapticFeedbackProvider rotaryHapticFeedbackProviderRememberRotaryHapticFeedbackProvider = rememberRotaryHapticFeedbackProvider(composer, 0);
        Channel<RotaryHapticsType> channelRememberHapticChannel = rememberHapticChannel(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 1884091834, "CC(remember):Haptics.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(channelRememberHapticChannel) | composer.changedInstance(rotaryHapticFeedbackProviderRememberRotaryHapticFeedbackProvider);
        HapticsKt$rememberCustomRotaryHapticHandler$1$1 hapticsKt$rememberCustomRotaryHapticHandler$1$1RememberedValue = composer.rememberedValue();
        if (zChangedInstance || hapticsKt$rememberCustomRotaryHapticHandler$1$1RememberedValue == Composer.Companion.getEmpty()) {
            hapticsKt$rememberCustomRotaryHapticHandler$1$1RememberedValue = new HapticsKt$rememberCustomRotaryHapticHandler$1$1(channelRememberHapticChannel, 30L, rotaryHapticFeedbackProviderRememberRotaryHapticFeedbackProvider, null);
            composer.updateRememberedValue(hapticsKt$rememberCustomRotaryHapticHandler$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(channelRememberHapticChannel, 30L, (Function2) hapticsKt$rememberCustomRotaryHapticHandler$1$1RememberedValue, composer, 48);
        ComposerKt.sourceInformationMarkerStart(composer, 1884115125, "CC(remember):Haptics.kt#9igjgp");
        boolean zChanged = composer.changed(scrollableState) | composer.changed(channelRememberHapticChannel) | composer.changed(rotaryHapticFeedbackProviderRememberRotaryHapticFeedbackProvider);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new CustomRotaryHapticHandler(scrollableState, channelRememberHapticChannel, 50L);
            composer.updateRememberedValue(objRememberedValue);
        }
        CustomRotaryHapticHandler customRotaryHapticHandler = (CustomRotaryHapticHandler) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return customRotaryHapticHandler;
    }

    private static final RotaryHapticFeedbackProvider rememberRotaryHapticFeedbackProvider(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 454482187, "C(rememberRotaryHapticFeedbackProvider):Haptics.kt#rtmq1y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(454482187, i, -1, "androidx.wear.compose.foundation.rotary.rememberRotaryHapticFeedbackProvider (Haptics.kt:123)");
        }
        composer.startReplaceGroup(351121572);
        ComposerKt.sourceInformation(composer, "*123@4289L7,124@4319L149");
        CompositionLocal localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd(composer);
        View view = (View) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, -836480825, "CC(remember):Haptics.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            RotaryHapticFeedbackProvider rotaryHapticFeedbackProvider = new RotaryHapticFeedbackProvider(view, getCustomRotaryConstants(view));
            composer.updateRememberedValue(rotaryHapticFeedbackProvider);
            objRememberedValue = rotaryHapticFeedbackProvider;
        }
        RotaryHapticFeedbackProvider rotaryHapticFeedbackProvider2 = (RotaryHapticFeedbackProvider) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rotaryHapticFeedbackProvider2;
    }

    public static final HapticConstants getCustomRotaryConstants(View view) {
        if (hasWearSDK(view.getContext())) {
            return HapticConstants.WearSDKHapticConstants.INSTANCE;
        }
        if (isGalaxyWatch()) {
            return HapticConstants.GalaxyWatchConstants.INSTANCE;
        }
        if (isWear3_5(view.getContext())) {
            return HapticConstants.Wear3Point5RotaryHapticConstants.INSTANCE;
        }
        return isWear4() ? HapticConstants.Wear4RotaryHapticConstants.INSTANCE : HapticConstants.DisabledHapticConstants.INSTANCE;
    }

    private static final Channel<RotaryHapticsType> rememberHapticChannel(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2031975940, "C(rememberHapticChannel)189@6322L146:Haptics.kt#rtmq1y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2031975940, i, -1, "androidx.wear.compose.foundation.rotary.rememberHapticChannel (Haptics.kt:189)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1172947863, "CC(remember):Haptics.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = ChannelKt.Channel$default(2, BufferOverflow.DROP_OLDEST, (Function1) null, 4, (Object) null);
            composer.updateRememberedValue(objRememberedValue);
        }
        Channel<RotaryHapticsType> channel = (Channel) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return channel;
    }

    private static final RotaryHapticHandler rememberDisabledRotaryHapticHandler(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1942893065, "C(rememberDisabledRotaryHapticHandler)286@9473L450:Haptics.kt#rtmq1y");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1942893065, i, -1, "androidx.wear.compose.foundation.rotary.rememberDisabledRotaryHapticHandler (Haptics.kt:286)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1598943795, "CC(remember):Haptics.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new RotaryHapticHandler() { // from class: androidx.wear.compose.foundation.rotary.HapticsKt$rememberDisabledRotaryHapticHandler$1$1
                @Override // androidx.wear.compose.foundation.rotary.RotaryHapticHandler
                public void handleLimitHaptic(boolean isStart) {
                }

                @Override // androidx.wear.compose.foundation.rotary.RotaryHapticHandler
                public void handleScrollHaptic(long timestamp, float deltaInPixels) {
                }

                @Override // androidx.wear.compose.foundation.rotary.RotaryHapticHandler
                public void handleSnapHaptic(long timestamp, float deltaInPixels) {
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        HapticsKt$rememberDisabledRotaryHapticHandler$1$1 hapticsKt$rememberDisabledRotaryHapticHandler$1$1 = (HapticsKt$rememberDisabledRotaryHapticHandler$1$1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return hapticsKt$rememberDisabledRotaryHapticHandler$1$1;
    }

    private static final boolean isGalaxyWatch() {
        if (StringsKt.contains(Build.MANUFACTURER, "Samsung", true)) {
            return new Regex("^SM-R.*$").matches(Build.MODEL);
        }
        return false;
    }

    private static final boolean isWear3_5(Context context) {
        return Build.VERSION.SDK_INT == 30 && getWearPlatformMrNumber(context) >= 5;
    }

    private static final boolean isWear4() {
        return Build.VERSION.SDK_INT == 33;
    }

    private static final boolean hasWearSDK(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch") && Build.VERSION.SDK_INT >= 34;
    }

    private static final int getWearPlatformMrNumber(Context context) {
        Integer intOrNull;
        String string = Settings.Global.getString(context.getContentResolver(), WEAR_PLATFORM_MR_NUMBER);
        if (string == null || (intOrNull = StringsKt.toIntOrNull(string)) == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reachedTheLimit(ScrollableState scrollableState, float f) {
        if (f <= 0.0f || scrollableState.getCanScrollForward()) {
            return f < 0.0f && !scrollableState.getCanScrollBackward();
        }
        return true;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1, reason: invalid class name */
    /* JADX INFO: compiled from: Haptics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1", f = "Haptics.kt", i = {}, l = {386}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T> $this_throttleLatest;
        final /* synthetic */ long $timeframe;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T> flow, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_throttleLatest = flow;
            this.$timeframe = j;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1<>(this.$this_throttleLatest, this.$timeframe, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Haptics.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C00111<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<T> $$this$flow;
            final /* synthetic */ long $timeframe;

            /* JADX WARN: Multi-variable type inference failed */
            C00111(FlowCollector<? super T> flowCollector, long j) {
                this.$$this$flow = flowCollector;
                this.$timeframe = j;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
            
                if (kotlinx.coroutines.DelayKt.delay(r5, r0) == r1) goto L21;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1$1$emit$1
                    if (r0 == 0) goto L14
                    r0 = r7
                    androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1$1$emit$1 r0 = (androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L14
                    int r7 = r0.label
                    int r7 = r7 - r2
                    r0.label = r7
                    goto L19
                L14:
                    androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1$1$emit$1 r0 = new androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1$1$emit$1
                    r0.<init>(r5, r7)
                L19:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3d
                    if (r2 == r4) goto L35
                    if (r2 != r3) goto L2d
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L5b
                L2d:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L35:
                    java.lang.Object r5 = r0.L$0
                    androidx.wear.compose.foundation.rotary.HapticsKt$throttleLatest$1$1 r5 = (androidx.wear.compose.foundation.rotary.HapticsKt.AnonymousClass1.C00111) r5
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L4d
                L3d:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector<T> r7 = r5.$$this$flow
                    r0.L$0 = r5
                    r0.label = r4
                    java.lang.Object r6 = r7.emit(r6, r0)
                    if (r6 != r1) goto L4d
                    goto L5a
                L4d:
                    long r5 = r5.$timeframe
                    r7 = 0
                    r0.L$0 = r7
                    r0.label = r3
                    java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r5, r0)
                    if (r5 != r1) goto L5b
                L5a:
                    return r1
                L5b:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.rotary.HapticsKt.AnonymousClass1.C00111.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                this.label = 1;
                if (FlowKt.conflate(this.$this_throttleLatest).collect(new C00111(flowCollector, this.$timeframe), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T> Flow<T> throttleLatest(Flow<? extends T> flow, long j) {
        return FlowKt.flow(new AnonymousClass1(flow, j, null));
    }
}
