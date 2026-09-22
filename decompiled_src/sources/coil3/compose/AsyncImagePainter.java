package coil3.compose;

import android.os.Trace;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil3.Image;
import coil3.ImageLoader;
import coil3.compose.internal.DeferredDispatchKt;
import coil3.compose.internal.UtilsKt;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.size.Precision;
import coil3.size.SizeResolver;
import coil3.target.Target;
import com.azure.core.util.tracing.Tracer;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AsyncImagePainter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0003fghB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010T\u001a\u00020/*\u00020UH\u0014J\u0010\u0010V\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010W\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010X\u001a\u00020/H\u0016J\b\u0010Y\u001a\u00020/H\u0002J\b\u0010Z\u001a\u00020/H\u0016J\b\u0010[\u001a\u00020/H\u0016J\u0006\u0010\\\u001a\u00020/J\u0018\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020\u0014H\u0002J\u0010\u0010a\u001a\u00020/2\u0006\u0010O\u001a\u00020)H\u0002J\f\u0010b\u001a\u00020)*\u00020cH\u0002J\u000e\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001c0eH\u0002R/\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u001c@BX\u0082\u000e¢\u0006\n\n\u0002\u0010 \"\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020\"X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010.\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R\u001a\u00102\u001a\u000203X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u000209X\u0080\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010E\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010\u0006R\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020)0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020)0K¢\u0006\b\n\u0000\u001a\u0004\bP\u0010MR\u0014\u0010Q\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006i"}, d2 = {"Lcoil3/compose/AsyncImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "input", "Lcoil3/compose/AsyncImagePainter$Input;", "<init>", "(Lcoil3/compose/AsyncImagePainter$Input;)V", "<set-?>", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "Landroidx/compose/runtime/MutableState;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "isRemembered", "", "value", "Lkotlinx/coroutines/Job;", "rememberJob", "setRememberJob", "(Lkotlinx/coroutines/Job;)V", "drawSizeFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/compose/ui/geometry/Size;", "drawSize", "setDrawSize-uvyYCjk", "(J)V", "J", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "getScope$coil_compose_core_release", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$coil_compose_core_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "getTransform$coil_compose_core_release", "()Lkotlin/jvm/functions/Function1;", "setTransform$coil_compose_core_release", "(Lkotlin/jvm/functions/Function1;)V", "onState", "", "getOnState$coil_compose_core_release", "setOnState$coil_compose_core_release", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale$coil_compose_core_release", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale$coil_compose_core_release", "(Landroidx/compose/ui/layout/ContentScale;)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$coil_compose_core_release", "()I", "setFilterQuality-vDHp3xo$coil_compose_core_release", "(I)V", "I", "previewHandler", "Lcoil3/compose/AsyncImagePreviewHandler;", "getPreviewHandler$coil_compose_core_release", "()Lcoil3/compose/AsyncImagePreviewHandler;", "setPreviewHandler$coil_compose_core_release", "(Lcoil3/compose/AsyncImagePreviewHandler;)V", "_input", "get_input$coil_compose_core_release", "()Lcoil3/compose/AsyncImagePainter$Input;", "set_input$coil_compose_core_release", "inputFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getInput", "()Lkotlinx/coroutines/flow/StateFlow;", "stateFlow", RemoteConfigConstants.ResponseFieldKey.STATE, "getState", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "applyColorFilter", "onRemembered", "launchJob", "onForgotten", "onAbandoned", "restart", "updateRequest", "Lcoil3/request/ImageRequest;", "request", "isPreview", "updateState", "toState", "Lcoil3/request/ImageResult;", "lazyDrawSizeFlow", "Lkotlinx/coroutines/flow/Flow;", "Input", "State", "Companion", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AsyncImagePainter extends Painter implements RememberObserver {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<State, State> DefaultTransform = new Function1() { // from class: coil3.compose.AsyncImagePainter$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            return AsyncImagePainter.DefaultTransform$lambda$4((AsyncImagePainter.State) obj);
        }
    };
    private Input _input;
    private ColorFilter colorFilter;
    private MutableSharedFlow<Size> drawSizeFlow;
    private final StateFlow<Input> input;
    private final MutableStateFlow<Input> inputFlow;
    private boolean isRemembered;
    private Function1<? super State, Unit> onState;
    private AsyncImagePreviewHandler previewHandler;
    private Job rememberJob;
    public CoroutineScope scope;
    private final StateFlow<State> state;
    private final MutableStateFlow<State> stateFlow;

    /* JADX INFO: renamed from: painter$delegate, reason: from kotlin metadata */
    private final MutableState painter = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private float alpha = 1.0f;
    private long drawSize = Size.Companion.getUnspecified-NH-jbRc();
    private Function1<? super State, ? extends State> transform = DefaultTransform;
    private ContentScale contentScale = ContentScale.Companion.getFit();
    private int filterQuality = DrawScope.Companion.getDefaultFilterQuality-f-v9h1I();

    /* JADX INFO: Access modifiers changed from: private */
    public static final State DefaultTransform$lambda$4(State state) {
        return state;
    }

    public AsyncImagePainter(Input input) {
        this._input = input;
        MutableStateFlow<Input> MutableStateFlow = StateFlowKt.MutableStateFlow(input);
        this.inputFlow = MutableStateFlow;
        this.input = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<State> MutableStateFlow2 = StateFlowKt.MutableStateFlow(State.Empty.INSTANCE);
        this.stateFlow = MutableStateFlow2;
        this.state = FlowKt.asStateFlow(MutableStateFlow2);
    }

    private final Painter getPainter() {
        return (Painter) this.painter.getValue();
    }

    private final void setPainter(Painter painter) {
        this.painter.setValue(painter);
    }

    private final void setRememberJob(Job job) {
        Job job2 = this.rememberJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.rememberJob = job;
    }

    /* JADX INFO: renamed from: setDrawSize-uvyYCjk, reason: not valid java name */
    private final void m1002setDrawSizeuvyYCjk(long j) {
        if (Size.equals-impl0(this.drawSize, j)) {
            return;
        }
        this.drawSize = j;
        MutableSharedFlow<Size> mutableSharedFlow = this.drawSizeFlow;
        if (mutableSharedFlow != null) {
            mutableSharedFlow.tryEmit(Size.box-impl(j));
        }
    }

    public final CoroutineScope getScope$coil_compose_core_release() {
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Tracer.SCOPE_KEY);
        return null;
    }

    public final void setScope$coil_compose_core_release(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }

    public final Function1<State, State> getTransform$coil_compose_core_release() {
        return this.transform;
    }

    public final void setTransform$coil_compose_core_release(Function1<? super State, ? extends State> function1) {
        this.transform = function1;
    }

    public final Function1<State, Unit> getOnState$coil_compose_core_release() {
        return this.onState;
    }

    public final void setOnState$coil_compose_core_release(Function1<? super State, Unit> function1) {
        this.onState = function1;
    }

    /* JADX INFO: renamed from: getContentScale$coil_compose_core_release, reason: from getter */
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale$coil_compose_core_release(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    /* JADX INFO: renamed from: getFilterQuality-f-v9h1I$coil_compose_core_release, reason: not valid java name and from getter */
    public final int getFilterQuality() {
        return this.filterQuality;
    }

    /* JADX INFO: renamed from: setFilterQuality-vDHp3xo$coil_compose_core_release, reason: not valid java name */
    public final void m1005setFilterQualityvDHp3xo$coil_compose_core_release(int i) {
        this.filterQuality = i;
    }

    /* JADX INFO: renamed from: getPreviewHandler$coil_compose_core_release, reason: from getter */
    public final AsyncImagePreviewHandler getPreviewHandler() {
        return this.previewHandler;
    }

    public final void setPreviewHandler$coil_compose_core_release(AsyncImagePreviewHandler asyncImagePreviewHandler) {
        this.previewHandler = asyncImagePreviewHandler;
    }

    /* JADX INFO: renamed from: get_input$coil_compose_core_release, reason: from getter */
    public final Input get_input() {
        return this._input;
    }

    public final void set_input$coil_compose_core_release(Input input) {
        if (Intrinsics.areEqual(this._input, input)) {
            return;
        }
        this._input = input;
        restart();
        if (input != null) {
            this.inputFlow.setValue(input);
        }
    }

    public final StateFlow<Input> getInput() {
        return this.input;
    }

    public final StateFlow<State> getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m1004getIntrinsicSizeNHjbRc() {
        Painter painter = getPainter();
        return painter != null ? painter.getIntrinsicSize-NH-jbRc() : Size.Companion.getUnspecified-NH-jbRc();
    }

    protected void onDraw(DrawScope drawScope) {
        m1002setDrawSizeuvyYCjk(drawScope.getSize-NH-jbRc());
        Painter painter = getPainter();
        if (painter != null) {
            painter.draw-x_KDEd0(drawScope, drawScope.getSize-NH-jbRc(), this.alpha, this.colorFilter);
        }
    }

    protected boolean applyAlpha(float alpha) {
        this.alpha = alpha;
        return true;
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public void onRemembered() {
        Trace.beginSection("AsyncImagePainter.onRemembered");
        try {
            RememberObserver painter = getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? painter : null;
            if (rememberObserver != null) {
                rememberObserver.onRemembered();
            }
            launchJob();
            this.isRemembered = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    private final void launchJob() {
        Input input = this._input;
        if (input == null) {
            return;
        }
        setRememberJob(DeferredDispatchKt.launchWithDeferredDispatch(getScope$coil_compose_core_release(), new AnonymousClass1(input, null)));
    }

    /* JADX INFO: renamed from: coil3.compose.AsyncImagePainter$launchJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "coil3.compose.AsyncImagePainter$launchJob$1", f = "AsyncImagePainter.kt", i = {0, 0, 1, 1}, l = {234, 238}, m = "invokeSuspend", n = {"previewHandler", "request", "previewHandler", "request"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Input $input;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Input input, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = input;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AsyncImagePainter.this.new AnonymousClass1(this.$input, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0065, code lost:
        
            if (r7 == r0) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws kotlin.NoWhenBranchMatchedException {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L33
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r0 = r6.L$2
                coil3.compose.AsyncImagePainter r0 = (coil3.compose.AsyncImagePainter) r0
                java.lang.Object r1 = r6.L$1
                coil3.request.ImageRequest r1 = (coil3.request.ImageRequest) r1
                java.lang.Object r1 = r6.L$0
                coil3.compose.AsyncImagePreviewHandler r1 = (coil3.compose.AsyncImagePreviewHandler) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L9b
            L1f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L27:
                java.lang.Object r0 = r6.L$1
                coil3.request.ImageRequest r0 = (coil3.request.ImageRequest) r0
                java.lang.Object r0 = r6.L$0
                coil3.compose.AsyncImagePreviewHandler r0 = (coil3.compose.AsyncImagePreviewHandler) r0
                kotlin.ResultKt.throwOnFailure(r7)
                goto L68
            L33:
                kotlin.ResultKt.throwOnFailure(r7)
                coil3.compose.AsyncImagePainter r7 = coil3.compose.AsyncImagePainter.this
                coil3.compose.AsyncImagePreviewHandler r7 = r7.getPreviewHandler()
                if (r7 == 0) goto L6b
                coil3.compose.AsyncImagePainter r1 = coil3.compose.AsyncImagePainter.this
                coil3.compose.AsyncImagePainter$Input r2 = r6.$input
                coil3.request.ImageRequest r2 = r2.getRequest()
                coil3.request.ImageRequest r1 = coil3.compose.AsyncImagePainter.access$updateRequest(r1, r2, r3)
                coil3.compose.AsyncImagePainter$Input r2 = r6.$input
                coil3.ImageLoader r2 = r2.getImageLoader()
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r5
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r6.L$1 = r5
                r6.label = r3
                java.lang.Object r7 = r7.handle(r2, r1, r4)
                if (r7 != r0) goto L68
                goto L99
            L68:
                coil3.compose.AsyncImagePainter$State r7 = (coil3.compose.AsyncImagePainter.State) r7
                goto La1
            L6b:
                coil3.compose.AsyncImagePainter r1 = coil3.compose.AsyncImagePainter.this
                coil3.compose.AsyncImagePainter$Input r3 = r6.$input
                coil3.request.ImageRequest r3 = r3.getRequest()
                r4 = 0
                coil3.request.ImageRequest r1 = coil3.compose.AsyncImagePainter.access$updateRequest(r1, r3, r4)
                coil3.compose.AsyncImagePainter r3 = coil3.compose.AsyncImagePainter.this
                coil3.compose.AsyncImagePainter$Input r4 = r6.$input
                coil3.ImageLoader r4 = r4.getImageLoader()
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r6.L$1 = r7
                r6.L$2 = r3
                r6.label = r2
                java.lang.Object r7 = r4.execute(r1, r5)
                if (r7 != r0) goto L9a
            L99:
                return r0
            L9a:
                r0 = r3
            L9b:
                coil3.request.ImageResult r7 = (coil3.request.ImageResult) r7
                coil3.compose.AsyncImagePainter$State r7 = coil3.compose.AsyncImagePainter.access$toState(r0, r7)
            La1:
                coil3.compose.AsyncImagePainter r6 = coil3.compose.AsyncImagePainter.this
                coil3.compose.AsyncImagePainter.access$updateState(r6, r7)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.compose.AsyncImagePainter.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public void onForgotten() {
        setRememberJob(null);
        Painter painter = getPainter();
        RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
        this.isRemembered = false;
    }

    public void onAbandoned() {
        setRememberJob(null);
        Painter painter = getPainter();
        RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
        this.isRemembered = false;
    }

    public final void restart() {
        if (this._input == null) {
            setRememberJob(null);
        } else if (this.isRemembered) {
            launchJob();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageRequest updateRequest(final ImageRequest request, boolean isPreview) {
        SizeResolver sizeResolver = request.getSizeResolver();
        if (sizeResolver instanceof DrawScopeSizeResolver) {
            ((DrawScopeSizeResolver) sizeResolver).connect(lazyDrawSizeFlow());
        }
        ImageRequest.Builder builderTarget = ImageRequest.newBuilder$default(request, null, 1, null).target(new Target() { // from class: coil3.compose.AsyncImagePainter$updateRequest$$inlined$target$default$1
            @Override // coil3.target.Target
            public void onError(Image error) {
            }

            @Override // coil3.target.Target
            public void onSuccess(Image result) {
            }

            @Override // coil3.target.Target
            public void onStart(Image placeholder) {
                this.updateState(new AsyncImagePainter.State.Loading(placeholder != null ? ImagePainter_androidKt.m1018asPainter55t9rM(placeholder, request.getContext(), this.getFilterQuality()) : null));
            }
        });
        if (request.getDefined().getSizeResolver() == null) {
            builderTarget.size(SizeResolver.ORIGINAL);
        }
        if (request.getDefined().getScale() == null) {
            builderTarget.scale(UtilsKt.toScale(this.contentScale));
        }
        if (request.getDefined().getPrecision() == null) {
            builderTarget.precision(Precision.INEXACT);
        }
        if (isPreview) {
            builderTarget.coroutineContext((CoroutineContext) EmptyCoroutineContext.INSTANCE);
        }
        return builderTarget.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(State state) {
        State state2 = (State) this.stateFlow.getValue();
        State state3 = (State) this.transform.invoke(state);
        this.stateFlow.setValue(state3);
        CrossfadePainter crossfadePainterMaybeNewCrossfadePainter = AsyncImagePainter_androidKt.maybeNewCrossfadePainter(state2, state3, this.contentScale);
        setPainter(crossfadePainterMaybeNewCrossfadePainter != null ? crossfadePainterMaybeNewCrossfadePainter : state3.getPainter());
        if (state2.getPainter() != state3.getPainter()) {
            RememberObserver painter = state2.getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? painter : null;
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            Painter painter2 = state3.getPainter();
            RememberObserver rememberObserver2 = painter2 instanceof RememberObserver ? (RememberObserver) painter2 : null;
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
        }
        Function1<? super State, Unit> function1 = this.onState;
        if (function1 != null) {
            function1.invoke(state3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final State toState(ImageResult imageResult) throws NoWhenBranchMatchedException {
        if (imageResult instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) imageResult;
            return new State.Success(ImagePainter_androidKt.m1018asPainter55t9rM(successResult.getImage(), successResult.getRequest().getContext(), this.filterQuality), successResult);
        }
        if (!(imageResult instanceof ErrorResult)) {
            throw new NoWhenBranchMatchedException();
        }
        ErrorResult errorResult = (ErrorResult) imageResult;
        Image image = errorResult.getImage();
        return new State.Error(image != null ? ImagePainter_androidKt.m1018asPainter55t9rM(image, errorResult.getRequest().getContext(), this.filterQuality) : null, errorResult);
    }

    private final Flow<Size> lazyDrawSizeFlow() {
        MutableSharedFlow<Size> mutableSharedFlowMutableSharedFlow$default = this.drawSizeFlow;
        if (mutableSharedFlowMutableSharedFlow$default == null) {
            mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
            long j = this.drawSize;
            if (j != 9205357640488583168L) {
                mutableSharedFlowMutableSharedFlow$default.tryEmit(Size.box-impl(j));
            }
            this.drawSizeFlow = mutableSharedFlowMutableSharedFlow$default;
        }
        return (Flow) mutableSharedFlowMutableSharedFlow$default;
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcoil3/compose/AsyncImagePainter$Input;", "", "imageLoader", "Lcoil3/ImageLoader;", "request", "Lcoil3/request/ImageRequest;", "modelEqualityDelegate", "Lcoil3/compose/AsyncImageModelEqualityDelegate;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/request/ImageRequest;Lcoil3/compose/AsyncImageModelEqualityDelegate;)V", "getImageLoader", "()Lcoil3/ImageLoader;", "getRequest", "()Lcoil3/request/ImageRequest;", "getModelEqualityDelegate", "()Lcoil3/compose/AsyncImageModelEqualityDelegate;", "equals", "", "other", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Input {
        public static final int $stable = 0;
        private final ImageLoader imageLoader;
        private final AsyncImageModelEqualityDelegate modelEqualityDelegate;
        private final ImageRequest request;

        public String toString() {
            return "Input(imageLoader=" + this.imageLoader + ", request=" + this.request + ", modelEqualityDelegate=" + this.modelEqualityDelegate + ")";
        }

        public Input(ImageLoader imageLoader, ImageRequest imageRequest, AsyncImageModelEqualityDelegate asyncImageModelEqualityDelegate) {
            this.imageLoader = imageLoader;
            this.request = imageRequest;
            this.modelEqualityDelegate = asyncImageModelEqualityDelegate;
        }

        public final ImageLoader getImageLoader() {
            return this.imageLoader;
        }

        public final ImageRequest getRequest() {
            return this.request;
        }

        public final AsyncImageModelEqualityDelegate getModelEqualityDelegate() {
            return this.modelEqualityDelegate;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Input)) {
                return false;
            }
            Input input = (Input) other;
            return Intrinsics.areEqual(this.imageLoader, input.imageLoader) && Intrinsics.areEqual(this.modelEqualityDelegate, input.modelEqualityDelegate) && this.modelEqualityDelegate.equals(this.request, input.request);
        }

        public int hashCode() {
            return (((this.imageLoader.hashCode() * 31) + this.modelEqualityDelegate.hashCode()) * 31) + this.modelEqualityDelegate.hashCode(this.request);
        }
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State;", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "Empty", "Loading", "Success", "Error", "Lcoil3/compose/AsyncImagePainter$State$Empty;", "Lcoil3/compose/AsyncImagePainter$State$Error;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "Lcoil3/compose/AsyncImagePainter$State$Success;", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface State {
        Painter getPainter();

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Empty;", "Lcoil3/compose/AsyncImagePainter$State;", "<init>", "()V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Empty implements State {
            public static final int $stable = 0;
            public static final Empty INSTANCE = new Empty();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Empty)) {
                    return false;
                }
                return true;
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return null;
            }

            public int hashCode() {
                return -1625786264;
            }

            public String toString() {
                return "Empty";
            }

            private Empty() {
            }
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Loading;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading implements State {
            public static final int $stable = 8;
            private final Painter painter;

            public static /* synthetic */ Loading copy$default(Loading loading, Painter painter, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = loading.painter;
                }
                return loading.copy(painter);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            public final Loading copy(Painter painter) {
                return new Loading(painter);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Loading) && Intrinsics.areEqual(this.painter, ((Loading) other).painter);
            }

            public int hashCode() {
                Painter painter = this.painter;
                if (painter == null) {
                    return 0;
                }
                return painter.hashCode();
            }

            public String toString() {
                return "Loading(painter=" + this.painter + ")";
            }

            public Loading(Painter painter) {
                this.painter = painter;
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Success;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil3/request/SuccessResult;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil3/request/SuccessResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil3/request/SuccessResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Success implements State {
            public static final int $stable = 8;
            private final Painter painter;
            private final SuccessResult result;

            public static /* synthetic */ Success copy$default(Success success, Painter painter, SuccessResult successResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = success.painter;
                }
                if ((i & 2) != 0) {
                    successResult = success.result;
                }
                return success.copy(painter, successResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final SuccessResult getResult() {
                return this.result;
            }

            public final Success copy(Painter painter, SuccessResult result) {
                return new Success(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.painter, success.painter) && Intrinsics.areEqual(this.result, success.result);
            }

            public int hashCode() {
                return (this.painter.hashCode() * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ")";
            }

            public Success(Painter painter, SuccessResult successResult) {
                this.painter = painter;
                this.result = successResult;
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final SuccessResult getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: AsyncImagePainter.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcoil3/compose/AsyncImagePainter$State$Error;", "Lcoil3/compose/AsyncImagePainter$State;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "result", "Lcoil3/request/ErrorResult;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Lcoil3/request/ErrorResult;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getResult", "()Lcoil3/request/ErrorResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error implements State {
            public static final int $stable = 8;
            private final Painter painter;
            private final ErrorResult result;

            public static /* synthetic */ Error copy$default(Error error, Painter painter, ErrorResult errorResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    painter = error.painter;
                }
                if ((i & 2) != 0) {
                    errorResult = error.result;
                }
                return error.copy(painter, errorResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Painter getPainter() {
                return this.painter;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ErrorResult getResult() {
                return this.result;
            }

            public final Error copy(Painter painter, ErrorResult result) {
                return new Error(painter, result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.painter, error.painter) && Intrinsics.areEqual(this.result, error.result);
            }

            public int hashCode() {
                Painter painter = this.painter;
                return ((painter == null ? 0 : painter.hashCode()) * 31) + this.result.hashCode();
            }

            public String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ")";
            }

            public Error(Painter painter, ErrorResult errorResult) {
                this.painter = painter;
                this.result = errorResult;
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public Painter getPainter() {
                return this.painter;
            }

            public final ErrorResult getResult() {
                return this.result;
            }
        }
    }

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcoil3/compose/AsyncImagePainter$Companion;", "", "<init>", "()V", "DefaultTransform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "getDefaultTransform", "()Lkotlin/jvm/functions/Function1;", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<State, State> getDefaultTransform() {
            return AsyncImagePainter.DefaultTransform;
        }
    }
}
