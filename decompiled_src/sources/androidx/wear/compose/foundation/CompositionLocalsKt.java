package androidx.wear.compose.foundation;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: CompositionLocals.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"LocalReduceMotion", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/wear/compose/foundation/ReduceMotion;", "getLocalReduceMotion$annotations", "()V", "getLocalReduceMotion", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalSwipeToDismissBackgroundScrimColor", "Landroidx/compose/ui/graphics/Color;", "getLocalSwipeToDismissBackgroundScrimColor", "LocalSwipeToDismissContentScrimColor", "getLocalSwipeToDismissContentScrimColor", "REDUCE_MOTION", "", "REDUCE_MOTION_DEFAULT", "", "TAG", "reduceMotionCache", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/flow/StateFlow;", "", "getReduceMotionFlowFor", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;Landroidx/compose/runtime/Composer;I)Lkotlinx/coroutines/flow/StateFlow;", "getReducedMotionSettingValue", "resolver", "Landroid/content/ContentResolver;", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompositionLocalsKt {
    private static final String REDUCE_MOTION = "reduce_motion";
    private static final int REDUCE_MOTION_DEFAULT = 0;
    public static final String TAG = "CompositionLocals";
    private static final ProvidableCompositionLocal<ReduceMotion> LocalReduceMotion = CompositionLocalKt.staticCompositionLocalOf(new Function0<ReduceMotion>() { // from class: androidx.wear.compose.foundation.CompositionLocalsKt$LocalReduceMotion$1
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ReduceMotion m248invoke() {
            return new ReduceMotion() { // from class: androidx.wear.compose.foundation.CompositionLocalsKt$LocalReduceMotion$1.1
                @Override // androidx.wear.compose.foundation.ReduceMotion
                public final boolean enabled(Composer composer, int i) {
                    composer.startReplaceGroup(-1249473022);
                    ComposerKt.sourceInformation(composer, "C(enabled)52@2112L7,53@2158L31,54@2203L29:CompositionLocals.kt#m5emhl");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1249473022, i, -1, "androidx.wear.compose.foundation.LocalReduceMotion.<anonymous>.<no name provided>.enabled (CompositionLocals.kt:52)");
                    }
                    CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composer.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    boolean zBooleanValue = ((Boolean) FlowExtKt.collectAsStateWithLifecycle(CompositionLocalsKt.getReduceMotionFlowFor(((Context) objConsume).getApplicationContext(), composer, 0), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7).getValue()).booleanValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return zBooleanValue;
                }
            };
        }
    });
    private static final ProvidableCompositionLocal<Color> LocalSwipeToDismissBackgroundScrimColor = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0<Color>() { // from class: androidx.wear.compose.foundation.CompositionLocalsKt$LocalSwipeToDismissBackgroundScrimColor$1
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.box-impl(m249invoke0d7_KjU());
        }

        /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
        public final long m249invoke0d7_KjU() {
            return Color.Companion.getBlack-0d7_KjU();
        }
    }, 1, (Object) null);
    private static final ProvidableCompositionLocal<Color> LocalSwipeToDismissContentScrimColor = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0<Color>() { // from class: androidx.wear.compose.foundation.CompositionLocalsKt$LocalSwipeToDismissContentScrimColor$1
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.box-impl(m250invoke0d7_KjU());
        }

        /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
        public final long m250invoke0d7_KjU() {
            return Color.Companion.getBlack-0d7_KjU();
        }
    }, 1, (Object) null);
    private static final AtomicReference<StateFlow<Boolean>> reduceMotionCache = new AtomicReference<>();

    public static /* synthetic */ void getLocalReduceMotion$annotations() {
    }

    public static final ProvidableCompositionLocal<ReduceMotion> getLocalReduceMotion() {
        return LocalReduceMotion;
    }

    public static final ProvidableCompositionLocal<Color> getLocalSwipeToDismissBackgroundScrimColor() {
        return LocalSwipeToDismissBackgroundScrimColor;
    }

    public static final ProvidableCompositionLocal<Color> getLocalSwipeToDismissContentScrimColor() {
        return LocalSwipeToDismissContentScrimColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow<Boolean> getReduceMotionFlowFor(Context context, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 317344124, "C(getReduceMotionFlowFor)92@3464L24,94@3532L1233:CompositionLocals.kt#m5emhl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(317344124, i, -1, "androidx.wear.compose.foundation.getReduceMotionFlowFor (CompositionLocals.kt:89)");
        }
        final ContentResolver contentResolver = context.getContentResolver();
        final Uri uriFor = Settings.Global.getUriFor(REDUCE_MOTION);
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, -954363344, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd(composer);
        AtomicReference<StateFlow<Boolean>> atomicReference = reduceMotionCache;
        ComposerKt.sourceInformationMarkerStart(composer, -189810897, "CC(remember):CompositionLocals.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(contentResolver) | composer.changedInstance(coroutineScope) | composer.changedInstance(uriFor);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = (Function1) new Function1<StateFlow<? extends Boolean>, StateFlow<? extends Boolean>>() { // from class: androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX INFO: renamed from: androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: CompositionLocals.kt */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1", f = "CompositionLocals.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $coroutineScope;
                    final /* synthetic */ Uri $reduceMotionUri;
                    final /* synthetic */ ContentResolver $resolver;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(CoroutineScope coroutineScope, ContentResolver contentResolver, Uri uri, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$coroutineScope = coroutineScope;
                        this.$resolver = contentResolver;
                        this.$reduceMotionUri = uri;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$coroutineScope, this.$resolver, this.$reduceMotionUri, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
                        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1] */
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            final ProducerScope producerScope = (ProducerScope) this.L$0;
                            final Handler handlerCreateAsync = HandlerCompat.createAsync(Looper.getMainLooper());
                            final ContentResolver contentResolver = this.$resolver;
                            final ?? r3 = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: CONSTRUCTOR (r3v0 'r3' ?? I:androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1) = 
                                  (r12v2 'producerScope' kotlinx.coroutines.channels.ProducerScope A[DONT_INLINE])
                                  (r4v0 'contentResolver' android.content.ContentResolver A[DONT_INLINE])
                                  (r1v2 'handlerCreateAsync' android.os.Handler A[DONT_INLINE])
                                 A[DECLARE_VAR, MD:(kotlinx.coroutines.channels.ProducerScope<? super java.lang.Boolean>, android.content.ContentResolver, android.os.Handler):void (m)] call: androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1.<init>(kotlinx.coroutines.channels.ProducerScope, android.content.ContentResolver, android.os.Handler):void type: CONSTRUCTOR in method: androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:345)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 96 more
                                */
                            /*
                                this = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r11.label
                                r2 = 1
                                if (r1 == 0) goto L17
                                if (r1 != r2) goto Lf
                                kotlin.ResultKt.throwOnFailure(r12)
                                goto L57
                            Lf:
                                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                                r11.<init>(r12)
                                throw r11
                            L17:
                                kotlin.ResultKt.throwOnFailure(r12)
                                java.lang.Object r12 = r11.L$0
                                kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
                                android.os.Looper r1 = android.os.Looper.getMainLooper()
                                android.os.Handler r1 = androidx.core.os.HandlerCompat.createAsync(r1)
                                androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1 r3 = new androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1
                                android.content.ContentResolver r4 = r11.$resolver
                                r3.<init>(r12, r4, r1)
                                kotlinx.coroutines.CoroutineScope r5 = r11.$coroutineScope
                                androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$1 r1 = new androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$1
                                android.content.ContentResolver r4 = r11.$resolver
                                android.net.Uri r6 = r11.$reduceMotionUri
                                r7 = 0
                                r1.<init>(r4, r6, r3, r7)
                                r8 = r1
                                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                                r9 = 3
                                r10 = 0
                                r6 = 0
                                kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
                                androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$2 r1 = new androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$2
                                android.content.ContentResolver r4 = r11.$resolver
                                r1.<init>()
                                kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
                                r3 = r11
                                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                                r11.label = r2
                                java.lang.Object r11 = kotlinx.coroutines.channels.ProduceKt.awaitClose(r12, r1, r3)
                                if (r11 != r0) goto L57
                                return r0
                            L57:
                                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                                return r11
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        /* JADX INFO: renamed from: androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: CompositionLocals.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.wear.compose.foundation.CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$1", f = "CompositionLocals.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        static final class C00061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1 $contentObserver;
                            final /* synthetic */ Uri $reduceMotionUri;
                            final /* synthetic */ ContentResolver $resolver;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00061(ContentResolver contentResolver, Uri uri, CompositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1 compositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1, Continuation<? super C00061> continuation) {
                                super(2, continuation);
                                this.$resolver = contentResolver;
                                this.$reduceMotionUri = uri;
                                this.$contentObserver = compositionLocalsKt$getReduceMotionFlowFor$1$1$1$contentObserver$1;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00061(this.$resolver, this.$reduceMotionUri, this.$contentObserver, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                this.$resolver.registerContentObserver(this.$reduceMotionUri, false, this.$contentObserver);
                                this.$resolver.notifyChange(this.$reduceMotionUri, this.$contentObserver);
                                return Unit.INSTANCE;
                            }
                        }
                    }

                    public final StateFlow<Boolean> invoke(StateFlow<Boolean> stateFlow) {
                        return stateFlow == null ? FlowKt.stateIn(FlowKt.callbackFlow(new AnonymousClass1(coroutineScope, contentResolver, uriFor, null)), CoroutineScopeKt.MainScope(), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), Boolean.valueOf(CompositionLocalsKt.getReducedMotionSettingValue(contentResolver))) : stateFlow;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            final Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            StateFlow<Boolean> stateFlowUpdateAndGet = atomicReference.updateAndGet(new UnaryOperator() { // from class: androidx.wear.compose.foundation.CompositionLocalsKt$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return CompositionLocalsKt.getReduceMotionFlowFor$lambda$1(function1, (StateFlow) obj);
                }
            });
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return stateFlowUpdateAndGet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StateFlow getReduceMotionFlowFor$lambda$1(Function1 function1, StateFlow stateFlow) {
            return (StateFlow) function1.invoke(stateFlow);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean getReducedMotionSettingValue(ContentResolver contentResolver) {
            try {
                return Settings.Global.getInt(contentResolver, REDUCE_MOTION, 0) == 1;
            } catch (SecurityException e) {
                Log.w(TAG, "Failed to fetch reduce motion setting, using value: false", e);
                return false;
            }
        }
    }
