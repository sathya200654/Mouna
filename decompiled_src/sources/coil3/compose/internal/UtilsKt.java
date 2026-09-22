package coil3.compose.internal;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import coil3.ImageLoader;
import coil3.compose.AsyncImageModelEqualityDelegate;
import coil3.compose.AsyncImagePainter;
import coil3.compose.AsyncImagePreviewHandler;
import coil3.compose.ConstraintsSizeResolver;
import coil3.compose.LocalAsyncImageModelEqualityDelegateKt;
import coil3.compose.LocalAsyncImagePreviewHandlerKt;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import coil3.size.Dimension;
import coil3.size.DimensionKt;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u000b\u001a2\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0001\u001aX\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rH\u0001\u001a \u0010\u001b\u001a\u00020\u001c2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0081\b¢\u0006\u0002\u0010\u001f\u001a\f\u0010 \u001a\u00020!*\u00020\u0007H\u0001\u001a\u0013\u0010\"\u001a\u00020#*\u00020$H\u0001¢\u0006\u0004\b%\u0010&\u001a\u0015\u0010'\u001a\u0004\u0018\u00010#*\u00020(H\u0001¢\u0006\u0004\b)\u0010&\u001a\f\u0010*\u001a\u00020+*\u00020,H\u0002\u001a\f\u0010*\u001a\u00020+*\u00020-H\u0002\u001a\u001b\u0010.\u001a\u00020-*\u00020$2\u0006\u0010/\u001a\u00020-H\u0000¢\u0006\u0004\b0\u00101\u001a\u001b\u00102\u001a\u00020-*\u00020$2\u0006\u00103\u001a\u00020-H\u0000¢\u0006\u0004\b4\u00101\u001a\u001b\u00105\u001a\u00020-*\u00020-2\f\u00106\u001a\b\u0012\u0004\u0012\u00020-07H\u0080\b\u001a\u0013\u00108\u001a\u000209*\u00020(H\u0000¢\u0006\u0004\b:\u0010;\u001a\u000f\u0010G\u001a\u0004\u0018\u00010HH\u0001¢\u0006\u0002\u0010I\u001a\u0010\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\u0001H\u0000\u001a\u001a\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\b\b\u0002\u0010X\u001a\u00020WH\u0002\"\u0018\u0010<\u001a\u00020=*\u00020(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?\" \u0010@\u001a\u0004\u0018\u00010A*\u00020B8@X\u0080\u0004¢\u0006\f\u0012\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0014\u0010J\u001a\u00020KX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M\"\u0016\u0010N\u001a\u00020$X\u0080\u0004¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bO\u0010P¨\u0006Y"}, d2 = {"requestOf", "Lcoil3/request/ImageRequest;", "model", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil3/request/ImageRequest;", "requestOfWithSizeResolver", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "(Ljava/lang/Object;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil3/request/ImageRequest;", "rememberSizeResolver", "Lcoil3/size/SizeResolver;", "(Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcoil3/size/SizeResolver;", "transformOf", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onStateOf", "", "onLoading", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "AsyncImageState", "Lcoil3/compose/internal/AsyncImageState;", "imageLoader", "Lcoil3/ImageLoader;", "(Ljava/lang/Object;Lcoil3/ImageLoader;Landroidx/compose/runtime/Composer;I)Lcoil3/compose/internal/AsyncImageState;", "toScale", "Lcoil3/size/Scale;", "toSize", "Lcoil3/size/Size;", "Landroidx/compose/ui/unit/Constraints;", "toSize-BRTryo0", "(J)Lcoil3/size/Size;", "toSizeOrNull", "Landroidx/compose/ui/geometry/Size;", "toSizeOrNull-uvyYCjk", "toDimension", "Lcoil3/size/Dimension;", "", "", "constrainWidth", "width", "constrainWidth-K40F9xA", "(JF)F", "constrainHeight", "height", "constrainHeight-K40F9xA", "takeOrElse", "block", "Lkotlin/Function0;", "toIntSize", "Landroidx/compose/ui/unit/IntSize;", "toIntSize-uvyYCjk", "(J)J", "isPositive", "", "isPositive-uvyYCjk", "(J)Z", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "getDispatcher$annotations", "(Lkotlin/coroutines/CoroutineContext;)V", "getDispatcher", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineDispatcher;", "previewHandler", "Lcoil3/compose/AsyncImagePreviewHandler;", "(Landroidx/compose/runtime/Composer;I)Lcoil3/compose/AsyncImagePreviewHandler;", "UseMinConstraintsMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getUseMinConstraintsMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "ZeroConstraints", "getZeroConstraints", "()J", "J", "validateRequest", "request", "unsupportedData", "", "name", "", "description", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilsKt {
    private static final MeasurePolicy UseMinConstraintsMeasurePolicy = UtilsKt$UseMinConstraintsMeasurePolicy$1.INSTANCE;
    private static final long ZeroConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 5, (Object) null);

    public static /* synthetic */ void getDispatcher$annotations(CoroutineContext coroutineContext) {
    }

    public static final ImageRequest requestOf(Object obj, Composer composer, int i) {
        composer.startReplaceGroup(1319639034);
        ComposerKt.sourceInformation(composer, "C(requestOf):utils.kt#7tflp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1319639034, i, -1, "coil3.compose.internal.requestOf (utils.kt:42)");
        }
        if (obj instanceof ImageRequest) {
            composer.startReplaceGroup(1530922508);
            ImageRequest imageRequest = (ImageRequest) obj;
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return imageRequest;
        }
        composer.startReplaceGroup(1530961754);
        ComposerKt.sourceInformation(composer, "46@1811L7,47@1834L132");
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 1157766622, "CC(remember):utils.kt#9igjgp");
        boolean zChanged = composer.changed(context) | composer.changed(obj);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new ImageRequest.Builder(context).data(obj).build();
            composer.updateRememberedValue(objRememberedValue);
        }
        ImageRequest imageRequest2 = (ImageRequest) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageRequest2;
    }

    public static final ImageRequest requestOfWithSizeResolver(Object obj, ContentScale contentScale, Composer composer, int i) {
        composer.startReplaceGroup(-329318062);
        ComposerKt.sourceInformation(composer, "C(requestOfWithSizeResolver)P(1):utils.kt#7tflp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-329318062, i, -1, "coil3.compose.internal.requestOfWithSizeResolver (utils.kt:61)");
        }
        if (obj instanceof ImageRequest) {
            composer.startReplaceGroup(-1008895720);
            ComposerKt.sourceInformation(composer, "");
            ImageRequest imageRequest = (ImageRequest) obj;
            if (imageRequest.getDefined().getSizeResolver() != null) {
                composer.startReplaceGroup(-1008855668);
                composer.endReplaceGroup();
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return imageRequest;
            }
            composer.startReplaceGroup(-1008807494);
            ComposerKt.sourceInformation(composer, "66@2358L34,67@2412L149");
            SizeResolver sizeResolverRememberSizeResolver = rememberSizeResolver(contentScale, composer, (i >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart(composer, 1352933831, "CC(remember):utils.kt#9igjgp");
            boolean zChanged = composer.changed(imageRequest) | composer.changed(sizeResolverRememberSizeResolver);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = ImageRequest.newBuilder$default(imageRequest, null, 1, null).size(sizeResolverRememberSizeResolver).build();
                composer.updateRememberedValue(objRememberedValue);
            }
            ImageRequest imageRequest2 = (ImageRequest) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return imageRequest2;
        }
        composer.startReplaceGroup(-1008549326);
        ComposerKt.sourceInformation(composer, "74@2628L7,75@2663L34,76@2713L182");
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        SizeResolver sizeResolverRememberSizeResolver2 = rememberSizeResolver(contentScale, composer, (i >> 3) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1352943496, "CC(remember):utils.kt#9igjgp");
        boolean zChanged2 = composer.changed(context) | composer.changed(obj) | composer.changed(sizeResolverRememberSizeResolver2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new ImageRequest.Builder(context).data(obj).size(sizeResolverRememberSizeResolver2).build();
            composer.updateRememberedValue(objRememberedValue2);
        }
        ImageRequest imageRequest3 = (ImageRequest) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageRequest3;
    }

    private static final SizeResolver rememberSizeResolver(ContentScale contentScale, Composer composer, int i) {
        ConstraintsSizeResolver constraintsSizeResolver;
        ComposerKt.sourceInformationMarkerStart(composer, -894086142, "C(rememberSizeResolver)88@3056L145:utils.kt#7tflp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-894086142, i, -1, "coil3.compose.internal.rememberSizeResolver (utils.kt:86)");
        }
        boolean zAreEqual = Intrinsics.areEqual(contentScale, ContentScale.Companion.getNone());
        ComposerKt.sourceInformationMarkerStart(composer, -223318285, "CC(remember):utils.kt#9igjgp");
        boolean zChanged = composer.changed(zAreEqual);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            if (zAreEqual) {
                constraintsSizeResolver = SizeResolver.ORIGINAL;
            } else {
                constraintsSizeResolver = new ConstraintsSizeResolver();
            }
            objRememberedValue = constraintsSizeResolver;
            composer.updateRememberedValue(objRememberedValue);
        }
        SizeResolver sizeResolver = (SizeResolver) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sizeResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncImagePainter.State transformOf$lambda$4(Painter painter, Painter painter2, Painter painter3, AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            return painter != null ? ((AsyncImagePainter.State.Loading) state).copy(painter) : (AsyncImagePainter.State.Loading) state;
        }
        if (!(state instanceof AsyncImagePainter.State.Error)) {
            return state;
        }
        AsyncImagePainter.State.Error errorCopy$default = (AsyncImagePainter.State.Error) state;
        if (errorCopy$default.getResult().getThrowable() instanceof NullRequestDataException) {
            if (painter2 != null) {
                errorCopy$default = AsyncImagePainter.State.Error.copy$default(errorCopy$default, painter2, null, 2, null);
            }
        } else if (painter3 != null) {
            errorCopy$default = AsyncImagePainter.State.Error.copy$default(errorCopy$default, painter3, null, 2, null);
        }
        return errorCopy$default;
    }

    public static final Function1<AsyncImagePainter.State, AsyncImagePainter.State> transformOf(final Painter painter, final Painter painter2, final Painter painter3) {
        if (painter != null || painter2 != null || painter3 != null) {
            return new Function1() { // from class: coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return UtilsKt.transformOf$lambda$4(painter, painter3, painter2, (AsyncImagePainter.State) obj);
                }
            };
        }
        return AsyncImagePainter.INSTANCE.getDefaultTransform();
    }

    public static final Function1<AsyncImagePainter.State, Unit> onStateOf(final Function1<? super AsyncImagePainter.State.Loading, Unit> function1, final Function1<? super AsyncImagePainter.State.Success, Unit> function2, final Function1<? super AsyncImagePainter.State.Error, Unit> function3) {
        if (function1 == null && function2 == null && function3 == null) {
            return null;
        }
        return new Function1() { // from class: coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return UtilsKt.onStateOf$lambda$5(function1, function2, function3, (AsyncImagePainter.State) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit onStateOf$lambda$5(Function1 function1, Function1 function2, Function1 function3, AsyncImagePainter.State state) throws NoWhenBranchMatchedException {
        if (state instanceof AsyncImagePainter.State.Loading) {
            if (function1 != null) {
                function1.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Success) {
            if (function2 != null) {
                function2.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Error) {
            if (function3 != null) {
                function3.invoke(state);
            }
        } else if (!(state instanceof AsyncImagePainter.State.Empty)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    public static final AsyncImageState AsyncImageState(Object obj, ImageLoader imageLoader, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        CompositionLocal localAsyncImageModelEqualityDelegate = LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localAsyncImageModelEqualityDelegate);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) objConsume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        return asyncImageState;
    }

    public static final Scale toScale(ContentScale contentScale) {
        if (Intrinsics.areEqual(contentScale, ContentScale.Companion.getFit()) || Intrinsics.areEqual(contentScale, ContentScale.Companion.getInside())) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    /* JADX INFO: renamed from: toSize-BRTryo0, reason: not valid java name */
    public static final Size m1045toSizeBRTryo0(long j) {
        return new Size(toDimension(Constraints.getMaxWidth-impl(j)), toDimension(Constraints.getMaxHeight-impl(j)));
    }

    /* JADX INFO: renamed from: toSizeOrNull-uvyYCjk, reason: not valid java name */
    public static final Size m1046toSizeOrNulluvyYCjk(long j) {
        if (j == 9205357640488583168L) {
            return Size.ORIGINAL;
        }
        if (m1043isPositiveuvyYCjk(j)) {
            return new Size(toDimension(Float.intBitsToFloat((int) (j >> 32))), toDimension(Float.intBitsToFloat((int) (j & 4294967295L))));
        }
        return null;
    }

    private static final Dimension toDimension(int i) {
        return i != Integer.MAX_VALUE ? Dimension.Pixels.m1093boximpl(DimensionKt.Dimension(i)) : Dimension.Undefined.INSTANCE;
    }

    private static final Dimension toDimension(float f) {
        return Math.abs(f) <= Float.MAX_VALUE ? Dimension.Pixels.m1093boximpl(DimensionKt.Dimension(MathKt.roundToInt(f))) : Dimension.Undefined.INSTANCE;
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final float m1042constrainWidthK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, Constraints.getMinWidth-impl(j), Constraints.getMaxWidth-impl(j));
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final float m1041constrainHeightK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, Constraints.getMinHeight-impl(j), Constraints.getMaxHeight-impl(j));
    }

    public static final float takeOrElse(float f, Function0<Float> function0) {
        return Math.abs(f) <= Float.MAX_VALUE ? f : ((Number) function0.invoke()).floatValue();
    }

    public static final CoroutineDispatcher getDispatcher(CoroutineContext coroutineContext) {
        return coroutineContext.get(CoroutineDispatcher.Key);
    }

    public static final AsyncImagePreviewHandler previewHandler(Composer composer, int i) {
        AsyncImagePreviewHandler asyncImagePreviewHandler;
        ComposerKt.sourceInformationMarkerStart(composer, -2074249623, "C(previewHandler)219@7034L7:utils.kt#7tflp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2074249623, i, -1, "coil3.compose.internal.previewHandler (utils.kt:218)");
        }
        CompositionLocal localInspectionMode = InspectionModeKt.getLocalInspectionMode();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localInspectionMode);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((Boolean) objConsume).booleanValue()) {
            composer.startReplaceGroup(2019071620);
            ComposerKt.sourceInformation(composer, "220@7083L7");
            CompositionLocal localAsyncImagePreviewHandler = LocalAsyncImagePreviewHandlerKt.getLocalAsyncImagePreviewHandler();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localAsyncImagePreviewHandler);
            ComposerKt.sourceInformationMarkerEnd(composer);
            asyncImagePreviewHandler = (AsyncImagePreviewHandler) objConsume2;
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(2019129125);
            composer.endReplaceGroup();
            asyncImagePreviewHandler = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return asyncImagePreviewHandler;
    }

    public static final MeasurePolicy getUseMinConstraintsMeasurePolicy() {
        return UseMinConstraintsMeasurePolicy;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    public static final void validateRequest(ImageRequest imageRequest) throws KotlinNothingValueException {
        Object data = imageRequest.getData();
        if (data instanceof ImageRequest.Builder) {
            unsupportedData("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof ImageVector) {
            unsupportedData$default("ImageVector", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (data instanceof Painter) {
            unsupportedData$default("Painter", null, 2, null);
            throw new KotlinNothingValueException();
        }
        Utils_androidKt.validateRequestProperties(imageRequest);
    }

    static /* synthetic */ Void unsupportedData$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return unsupportedData(str, str2);
    }

    private static final Void unsupportedData(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m1044toIntSizeuvyYCjk(long j) {
        int iRoundToInt = MathKt.roundToInt(Float.intBitsToFloat((int) (j >> 32)));
        return IntSize.constructor-impl((((long) MathKt.roundToInt(Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iRoundToInt) << 32));
    }

    /* JADX INFO: renamed from: isPositive-uvyYCjk, reason: not valid java name */
    public static final boolean m1043isPositiveuvyYCjk(long j) {
        return ((double) Float.intBitsToFloat((int) (j >> 32))) >= 0.5d && ((double) Float.intBitsToFloat((int) (j & 4294967295L))) >= 0.5d;
    }
}
