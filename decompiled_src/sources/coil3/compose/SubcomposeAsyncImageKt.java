package coil3.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.recyclerview.widget.RecyclerView;
import coil3.ImageLoader;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.SubcomposeContentPainterElement;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import coil3.size.SizeResolver;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÉ\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2&\b\u0002\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122&\b\u0002\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'\u001a¿\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b*\u0010+\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0004\b.\u0010/\u001ae\u00100\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u00103\u001a\u0095\u0001\u00104\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\r\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122$\u0010\u0015\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0002\u00105¨\u00066"}, d2 = {"SubcomposeAsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil3/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "loading", "Lkotlin/Function2;", "Lcoil3/compose/SubcomposeAsyncImageScope;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "success", "Lcoil3/compose/AsyncImagePainter$State$Success;", "error", "Lcoil3/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "SubcomposeAsyncImage-MokUVwQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "onState", "content", "SubcomposeAsyncImage-QgsmV_s", "(Ljava/lang/Object;Ljava/lang/String;Lcoil3/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcoil3/compose/internal/AsyncImageState;", "SubcomposeAsyncImage-gl8XCv8", "(Lcoil3/compose/internal/AsyncImageState;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil3/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLandroidx/compose/runtime/Composer;II)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SubcomposeAsyncImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImageContent$lambda$3(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, int i, int i2, Composer composer, int i3) {
        SubcomposeAsyncImageContent(subcomposeAsyncImageScope, modifier, painter, str, alignment, contentScale, f, colorFilter, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImage_gl8XCv8$lambda$2(AsyncImageState asyncImageState, String str, Modifier modifier, Function1 function1, Function1 function2, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        m1032SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier, function1, function2, alignment, contentScale, f, colorFilter, i, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-MokUVwQ, reason: not valid java name */
    public static final void m1030SubcomposeAsyncImageMokUVwQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function5, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function6, Function1<? super AsyncImagePainter.State.Loading, Unit> function2, Function1<? super AsyncImagePainter.State.Success, Unit> function3, Function1<? super AsyncImagePainter.State.Error, Unit> function7, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 831032125, "C(SubcomposeAsyncImage)P(10,4,8,11,16,9,15,6,13,14,12!1,5!1,3,7:c#ui.graphics.FilterQuality)83@4395L35,82@4361L453:SubcomposeAsyncImage.kt#8xxpns");
        Modifier modifier2 = (i4 & 8) != 0 ? (Modifier) Modifier.Companion : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function8 = (i4 & 32) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function9 = (i4 & 64) != 0 ? null : function5;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function10 = (i4 & 128) != 0 ? null : function6;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function11 = (i4 & 256) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Success, Unit> function12 = (i4 & 512) != 0 ? null : function3;
        Function1<? super AsyncImagePainter.State.Error, Unit> function13 = (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? null : function7;
        Alignment center = (i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 4096) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 8192) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 16384) != 0 ? null : colorFilter;
        int i5 = (i4 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        boolean z2 = (i4 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831032125, i2, i3, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:82)");
        }
        int i6 = i2 >> 3;
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        CompositionLocal localAsyncImageModelEqualityDelegate = LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localAsyncImageModelEqualityDelegate);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) objConsume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i7 = (i2 & 112) | (i6 & 896) | (i6 & 7168);
        int i8 = i3 << 12;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function14 = defaultTransform;
        Alignment alignment2 = center;
        Modifier modifier3 = modifier2;
        m1032SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier3, function14, UtilsKt.onStateOf(function11, function12, function13), alignment2, fit, f2, colorFilter2, i5, z2, contentOf(function8, function9, function10), composer, i7 | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8) | (i8 & 1879048192), (i3 >> 18) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-QgsmV_s, reason: not valid java name */
    public static final void m1031SubcomposeAsyncImageQgsmV_s(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -734720902, "C(SubcomposeAsyncImage)P(9,5,8,10,12,11!1,6!1,3,7:c#ui.graphics.FilterQuality)142@7300L35,141@7266L393:SubcomposeAsyncImage.kt#8xxpns");
        Modifier modifier2 = (i4 & 8) != 0 ? (Modifier) Modifier.Companion : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 16) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function4 = (i4 & 32) != 0 ? null : function2;
        Alignment center = (i4 & 64) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 512) == 0 ? colorFilter : null;
        int i5 = (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        boolean z2 = (i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-734720902, i2, i3, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:141)");
        }
        int i6 = i2 >> 3;
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        CompositionLocal localAsyncImageModelEqualityDelegate = LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localAsyncImageModelEqualityDelegate);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) objConsume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        m1032SubcomposeAsyncImagegl8XCv8(asyncImageState, str, modifier2, defaultTransform, function4, center, fit, f2, colorFilter2, i5, z2, function3, composer, ((i3 << 27) & 1879048192) | (i6 & 234881024) | (i2 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6), (i3 >> 3) & 126, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0122  */
    /* JADX WARN: Code duplicated, block: B:103:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x012d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0132  */
    /* JADX WARN: Code duplicated, block: B:108:0x013a  */
    /* JADX WARN: Code duplicated, block: B:111:0x017e  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:116:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:117:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:122:0x0203  */
    /* JADX WARN: Code duplicated, block: B:124:0x0263  */
    /* JADX WARN: Code duplicated, block: B:127:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:129:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:132:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:33:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0082  */
    /* JADX WARN: Code duplicated, block: B:46:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:49:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:89:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x010a  */
    /* JADX INFO: renamed from: SubcomposeAsyncImage-gl8XCv8, reason: not valid java name */
    private static final void m1032SubcomposeAsyncImagegl8XCv8(final AsyncImageState asyncImageState, final String str, Modifier modifier, final Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, final Function1<? super AsyncImagePainter.State, Unit> function2, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter, final int i, final boolean z, final Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function4;
        int i6;
        int i7;
        boolean z2;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        int i8;
        int i9;
        final AsyncImagePainter asyncImagePainterM1007rememberAsyncImagePainter5jETZwI;
        final SizeResolver sizeResolver;
        Modifier modifier4;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Composer composerStartRestartGroup = composer.startRestartGroup(-205779950);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImage)P(10,5,8,11,9!1,6!1,3,7:c#ui.graphics.FilterQuality)171@8122L98,175@8239L232:SubcomposeAsyncImage.kt#8xxpns");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(asyncImageState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i18 = i4 & 4;
        if (i18 == 0) {
            if ((i2 & 384) == 0) {
                i5 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                function4 = function1;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i17 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i17 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i5 |= i17;
            } else {
                function4 = function1;
            }
            if ((i2 & 24576) != 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i16 = 16384;
                } else {
                    i16 = 8192;
                }
                i5 |= i16;
            }
            if ((i2 & 196608) == 0) {
                if (composerStartRestartGroup.changed(alignment)) {
                    i15 = 131072;
                } else {
                    i15 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i5 |= i15;
            }
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(contentScale)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i5 |= i14;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i13 = 8388608;
                } else {
                    i13 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i5 |= i13;
            }
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(colorFilter)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i5 |= i12;
            }
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i11 = 536870912;
                } else {
                    i11 = 268435456;
                }
                i5 |= i11;
            }
            if ((i3 & 6) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i10 = 4;
                } else {
                    i10 = 2;
                }
                i6 = i3 | i10;
            } else {
                i6 = i3;
            }
            if ((i3 & 48) == 0) {
                i6 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
            }
            i7 = i6;
            if ((306783379 & i5) == 306783378 || (i7 & 19) != 18) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
            } else {
                if (i18 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-205779950, i5, i7, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:170)");
                }
                ImageRequest imageRequestRequestOfWithSizeResolver = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, composerStartRestartGroup, (i5 >> 15) & 112);
                i8 = i5 >> 6;
                i9 = i5 >> 12;
                asyncImagePainterM1007rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m1007rememberAsyncImagePainter5jETZwI(imageRequestRequestOfWithSizeResolver, asyncImageState.getImageLoader(), function4, function2, contentScale, i, composerStartRestartGroup, ((i5 >> 3) & 8064) | (i8 & 57344) | (i9 & 458752), 0);
                sizeResolver = imageRequestRequestOfWithSizeResolver.getSizeResolver();
                if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                    composerStartRestartGroup.startReplaceGroup(-1470550590);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "211@9543L739,207@9394L888");
                    composerStartRestartGroup = composerStartRestartGroup;
                    modifier4 = modifier3;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier4, alignment, true, ComposableLambdaKt.rememberComposableLambda(-374957172, true, new Function3() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SubcomposeAsyncImageKt.SubcomposeAsyncImage_gl8XCv8$lambda$1(sizeResolver, function3, asyncImagePainterM1007rememberAsyncImagePainter5jETZwI, str, alignment, contentScale, f, colorFilter, z, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 3456 | (i9 & 112), 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1471239317);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "188@8695L543");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                    constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -293812529, "C202@9219L9:SubcomposeAsyncImage.kt#8xxpns");
                    function3.invoke(new RealSubcomposeAsyncImageScope(boxScope, asyncImagePainterM1007rememberAsyncImagePainter5jETZwI, str, alignment, contentScale, f, colorFilter, z), composerStartRestartGroup, Integer.valueOf(i7 & 112));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup = composerStartRestartGroup;
                    modifier4 = modifier3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return SubcomposeAsyncImageKt.SubcomposeAsyncImage_gl8XCv8$lambda$2(asyncImageState, str, modifier2, function1, function2, alignment, contentScale, f, colorFilter, i, z, function3, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        if ((i2 & 3072) == 0) {
            function4 = function1;
            if (composerStartRestartGroup.changedInstance(function4)) {
                i17 = RecyclerView.ItemAnimator.FLAG_MOVED;
            } else {
                i17 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i5 |= i17;
        } else {
            function4 = function1;
        }
        if ((i2 & 24576) != 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i5 |= i16;
        }
        if ((i2 & 196608) == 0) {
            if (composerStartRestartGroup.changed(alignment)) {
                i15 = 131072;
            } else {
                i15 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            }
            i5 |= i15;
        }
        if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(contentScale)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i5 |= i14;
        }
        if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i13 = 8388608;
            } else {
                i13 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            }
            i5 |= i13;
        }
        if ((i2 & 100663296) == 0) {
            if (composerStartRestartGroup.changed(colorFilter)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i5 |= i12;
        }
        if ((i2 & 805306368) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i11 = 536870912;
            } else {
                i11 = 268435456;
            }
            i5 |= i11;
        }
        if ((i3 & 6) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i10 = 4;
            } else {
                i10 = 2;
            }
            i6 = i3 | i10;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        i7 = i6;
        if ((306783379 & i5) == 306783378) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i18 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-205779950, i5, i7, "coil3.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:170)");
            }
            ImageRequest imageRequestRequestOfWithSizeResolver2 = UtilsKt.requestOfWithSizeResolver(asyncImageState.getModel(), contentScale, composerStartRestartGroup, (i5 >> 15) & 112);
            i8 = i5 >> 6;
            i9 = i5 >> 12;
            asyncImagePainterM1007rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m1007rememberAsyncImagePainter5jETZwI(imageRequestRequestOfWithSizeResolver2, asyncImageState.getImageLoader(), function4, function2, contentScale, i, composerStartRestartGroup, ((i5 >> 3) & 8064) | (i8 & 57344) | (i9 & 458752), 0);
            sizeResolver = imageRequestRequestOfWithSizeResolver2.getSizeResolver();
            if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
                composerStartRestartGroup.startReplaceGroup(-1470550590);
                ComposerKt.sourceInformation(composerStartRestartGroup, "211@9543L739,207@9394L888");
                composerStartRestartGroup = composerStartRestartGroup;
                modifier4 = modifier3;
                BoxWithConstraintsKt.BoxWithConstraints(modifier4, alignment, true, ComposableLambdaKt.rememberComposableLambda(-374957172, true, new Function3() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SubcomposeAsyncImageKt.SubcomposeAsyncImage_gl8XCv8$lambda$1(sizeResolver, function3, asyncImagePainterM1007rememberAsyncImagePainter5jETZwI, str, alignment, contentScale, f, colorFilter, z, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 3456 | (i9 & 112), 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1471239317);
                ComposerKt.sourceInformation(composerStartRestartGroup, "188@8695L543");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(alignment, true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -293812529, "C202@9219L9:SubcomposeAsyncImage.kt#8xxpns");
                function3.invoke(new RealSubcomposeAsyncImageScope(boxScope2, asyncImagePainterM1007rememberAsyncImagePainter5jETZwI, str, alignment, contentScale, f, colorFilter, z), composerStartRestartGroup, Integer.valueOf(i7 & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup = composerStartRestartGroup;
                modifier4 = modifier3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return SubcomposeAsyncImageKt.SubcomposeAsyncImage_gl8XCv8$lambda$2(asyncImageState, str, modifier2, function1, function2, alignment, contentScale, f, colorFilter, i, z, function3, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcomposeAsyncImage_gl8XCv8$lambda$1(SizeResolver sizeResolver, Function3 function3, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C226@10263L9:SubcomposeAsyncImage.kt#8xxpns");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(boxWithConstraintsScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374957172, i2, -1, "coil3.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:215)");
            }
            ((ConstraintsSizeResolver) sizeResolver).m1012setConstraintsBRTryo0(boxWithConstraintsScope.getConstraints-msEJaDk());
            function3.invoke(new RealSubcomposeAsyncImageScope((BoxScope) boxWithConstraintsScope, asyncImagePainter, str, alignment, contentScale, f, colorFilter, z), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x010d  */
    /* JADX WARN: Code duplicated, block: B:101:0x010f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0118  */
    /* JADX WARN: Code duplicated, block: B:130:0x0162 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x0164  */
    /* JADX WARN: Code duplicated, block: B:134:0x016d  */
    /* JADX WARN: Code duplicated, block: B:137:0x017a  */
    /* JADX WARN: Code duplicated, block: B:140:0x0185  */
    /* JADX WARN: Code duplicated, block: B:143:0x0190  */
    /* JADX WARN: Code duplicated, block: B:146:0x019b  */
    /* JADX WARN: Code duplicated, block: B:149:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:152:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:155:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:158:0x0216  */
    /* JADX WARN: Code duplicated, block: B:161:0x0222  */
    /* JADX WARN: Code duplicated, block: B:162:0x0226  */
    /* JADX WARN: Code duplicated, block: B:167:0x0262  */
    /* JADX WARN: Code duplicated, block: B:170:0x027f  */
    /* JADX WARN: Code duplicated, block: B:172:0x0285  */
    /* JADX WARN: Code duplicated, block: B:175:0x0296  */
    /* JADX WARN: Code duplicated, block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x00df  */
    /* JADX WARN: Code duplicated, block: B:86:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:93:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:94:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:97:0x0101  */
    public static final void SubcomposeAsyncImageContent(final SubcomposeAsyncImageScope subcomposeAsyncImageScope, Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Painter painter2;
        String contentDescription;
        Alignment alignment2;
        ContentScale contentScale2;
        float alpha;
        ColorFilter colorFilter2;
        boolean clipToBounds;
        boolean z2;
        final Modifier modifier3;
        final Painter painter3;
        final String str2;
        final Alignment alignment3;
        final ContentScale contentScale3;
        final float f2;
        final ColorFilter colorFilter3;
        final boolean z3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        int i4;
        int i5;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1375825518);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubcomposeAsyncImageContent)P(6,7,4!1,5!1,3)276@11723L417:SubcomposeAsyncImage.kt#8xxpns");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 1;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 2) == 0) {
                    painter2 = painter;
                    int i8 = composerStartRestartGroup.changedInstance(painter2) ? 256 : 128;
                    i3 |= i8;
                } else {
                    painter2 = painter;
                }
                i3 |= i8;
            } else {
                painter2 = painter;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 4) == 0) {
                    contentDescription = str;
                    if (composerStartRestartGroup.changed(contentDescription)) {
                        i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i6;
                } else {
                    contentDescription = str;
                }
                i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i6;
            } else {
                contentDescription = str;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 8) == 0) {
                    alignment2 = alignment;
                    int i9 = composerStartRestartGroup.changed(alignment2) ? 16384 : 8192;
                    i3 |= i9;
                } else {
                    alignment2 = alignment;
                }
                i3 |= i9;
            } else {
                alignment2 = alignment;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 16) == 0) {
                    contentScale2 = contentScale;
                    if (composerStartRestartGroup.changed(contentScale2)) {
                        i5 = 131072;
                    }
                    i3 |= i5;
                } else {
                    contentScale2 = contentScale;
                }
                i5 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                i3 |= i5;
            } else {
                contentScale2 = contentScale;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 32) == 0) {
                    alpha = f;
                    int i10 = composerStartRestartGroup.changed(alpha) ? 1048576 : 524288;
                    i3 |= i10;
                } else {
                    alpha = f;
                }
                i3 |= i10;
            } else {
                alpha = f;
            }
            if ((12582912 & i) == 0) {
                if ((i2 & 64) == 0) {
                    colorFilter2 = colorFilter;
                    if (composerStartRestartGroup.changed(colorFilter2)) {
                        i4 = 8388608;
                    }
                    i3 |= i4;
                } else {
                    colorFilter2 = colorFilter;
                }
                i4 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i3 |= i4;
            } else {
                colorFilter2 = colorFilter;
            }
            if ((100663296 & i) == 0) {
                if ((i2 & 128) == 0) {
                    clipToBounds = z;
                    int i11 = composerStartRestartGroup.changed(clipToBounds) ? 67108864 : 33554432;
                    i3 |= i11;
                } else {
                    clipToBounds = z;
                }
                i3 |= i11;
            } else {
                clipToBounds = z;
            }
            if ((38347923 & i3) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -897;
                        painter2 = subcomposeAsyncImageScope.getPainter();
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -7169;
                        contentDescription = subcomposeAsyncImageScope.getContentDescription();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -57345;
                        alignment2 = subcomposeAsyncImageScope.getAlignment();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -458753;
                        contentScale2 = subcomposeAsyncImageScope.getContentScale();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -3670017;
                        alpha = subcomposeAsyncImageScope.getAlpha();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -29360129;
                        colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -234881025;
                        clipToBounds = subcomposeAsyncImageScope.getClipToBounds();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -234881025;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1375825518, i3, -1, "coil3.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:276)");
                }
                Modifier modifierThen = modifier2.then(new SubcomposeContentPainterElement(painter2, alignment2, contentScale2, alpha, colorFilter2, clipToBounds, contentDescription));
                MeasurePolicy useMinConstraintsMeasurePolicy = UtilsKt.getUseMinConstraintsMeasurePolicy();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)121@4798L23,124@4949L333:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.Companion.getConstructor();
                Modifier modifier4 = modifier2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, useMinConstraintsMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            painter3 = painter2;
            str2 = contentDescription;
            alignment3 = alignment2;
            contentScale3 = contentScale2;
            f2 = alpha;
            colorFilter3 = colorFilter2;
            z3 = clipToBounds;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        return SubcomposeAsyncImageKt.SubcomposeAsyncImageContent$lambda$3(subcomposeAsyncImageScope, modifier3, painter3, str2, alignment3, contentScale3, f2, colorFilter3, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 2) == 0) {
                painter2 = painter;
                if (composerStartRestartGroup.changedInstance(painter2)) {
                }
                i3 |= i8;
            } else {
                painter2 = painter;
            }
            i3 |= i8;
        } else {
            painter2 = painter;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 4) == 0) {
                contentDescription = str;
                if (composerStartRestartGroup.changed(contentDescription)) {
                    i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i6;
            } else {
                contentDescription = str;
            }
            i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i6;
        } else {
            contentDescription = str;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 8) == 0) {
                alignment2 = alignment;
                if (composerStartRestartGroup.changed(alignment2)) {
                }
                i3 |= i9;
            } else {
                alignment2 = alignment;
            }
            i3 |= i9;
        } else {
            alignment2 = alignment;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 16) == 0) {
                contentScale2 = contentScale;
                if (composerStartRestartGroup.changed(contentScale2)) {
                    i5 = 131072;
                }
                i3 |= i5;
            } else {
                contentScale2 = contentScale;
            }
            i5 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            i3 |= i5;
        } else {
            contentScale2 = contentScale;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 32) == 0) {
                alpha = f;
                if (composerStartRestartGroup.changed(alpha)) {
                }
                i3 |= i10;
            } else {
                alpha = f;
            }
            i3 |= i10;
        } else {
            alpha = f;
        }
        if ((12582912 & i) == 0) {
            if ((i2 & 64) == 0) {
                colorFilter2 = colorFilter;
                if (composerStartRestartGroup.changed(colorFilter2)) {
                    i4 = 8388608;
                }
                i3 |= i4;
            } else {
                colorFilter2 = colorFilter;
            }
            i4 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            i3 |= i4;
        } else {
            colorFilter2 = colorFilter;
        }
        if ((100663296 & i) == 0) {
            if ((i2 & 128) == 0) {
                clipToBounds = z;
                if (composerStartRestartGroup.changed(clipToBounds)) {
                }
                i3 |= i11;
            } else {
                clipToBounds = z;
            }
            i3 |= i11;
        } else {
            clipToBounds = z;
        }
        if ((38347923 & i3) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -897;
                    painter2 = subcomposeAsyncImageScope.getPainter();
                }
                if ((i2 & 4) != 0) {
                    i3 &= -7169;
                    contentDescription = subcomposeAsyncImageScope.getContentDescription();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -57345;
                    alignment2 = subcomposeAsyncImageScope.getAlignment();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -458753;
                    contentScale2 = subcomposeAsyncImageScope.getContentScale();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -3670017;
                    alpha = subcomposeAsyncImageScope.getAlpha();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -29360129;
                    colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                }
                if ((i2 & 128) != 0) {
                    i3 &= -234881025;
                    clipToBounds = subcomposeAsyncImageScope.getClipToBounds();
                }
            } else {
                if (i7 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -897;
                    painter2 = subcomposeAsyncImageScope.getPainter();
                }
                if ((i2 & 4) != 0) {
                    i3 &= -7169;
                    contentDescription = subcomposeAsyncImageScope.getContentDescription();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -57345;
                    alignment2 = subcomposeAsyncImageScope.getAlignment();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -458753;
                    contentScale2 = subcomposeAsyncImageScope.getContentScale();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -3670017;
                    alpha = subcomposeAsyncImageScope.getAlpha();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -29360129;
                    colorFilter2 = subcomposeAsyncImageScope.getColorFilter();
                }
                if ((i2 & 128) != 0) {
                    i3 &= -234881025;
                    clipToBounds = subcomposeAsyncImageScope.getClipToBounds();
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1375825518, i3, -1, "coil3.compose.SubcomposeAsyncImageContent (SubcomposeAsyncImage.kt:276)");
            }
            Modifier modifierThen2 = modifier2.then(new SubcomposeContentPainterElement(painter2, alignment2, contentScale2, alpha, colorFilter2, clipToBounds, contentDescription));
            MeasurePolicy useMinConstraintsMeasurePolicy2 = UtilsKt.getUseMinConstraintsMeasurePolicy();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 544976794, "CC(Layout)P(1)121@4798L23,124@4949L333:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            constructor = ComposeUiNode.Companion.getConstructor();
            Modifier modifier5 = modifier2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, useMinConstraintsMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer2.getInserting()) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        painter3 = painter2;
        str2 = contentDescription;
        alignment3 = alignment2;
        contentScale3 = contentScale2;
        f2 = alpha;
        colorFilter3 = colorFilter2;
        z3 = clipToBounds;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return SubcomposeAsyncImageKt.SubcomposeAsyncImageContent$lambda$3(subcomposeAsyncImageScope, modifier3, painter3, str2, alignment3, contentScale3, f2, colorFilter3, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function5, final Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function6) {
        return (function4 == null && function5 == null && function6 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.getLambda$1938077476$coil_compose_core_release() : ComposableLambdaKt.composableLambdaInstance(-1106738291, true, new Function3() { // from class: coil3.compose.SubcomposeAsyncImageKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SubcomposeAsyncImageKt.contentOf$lambda$7(function4, function5, function6, (SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit contentOf$lambda$7(Function4 function4, Function4 function5, Function4 function6, SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) throws NoWhenBranchMatchedException {
        int i2;
        ComposerKt.sourceInformation(composer, "C300@12612L16:SubcomposeAsyncImage.kt#8xxpns");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(subcomposeAsyncImageScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1106738291, i2, -1, "coil3.compose.contentOf.<anonymous> (SubcomposeAsyncImage.kt:299)");
            }
            AsyncImagePainter.State state = (AsyncImagePainter.State) SnapshotStateKt.collectAsState(subcomposeAsyncImageScope.getPainter().getState(), (CoroutineContext) null, composer, 0, 1).getValue();
            if (state instanceof AsyncImagePainter.State.Loading) {
                if (function4 != null) {
                    composer.startReplaceGroup(1576397282);
                    ComposerKt.sourceInformation(composer, "301@12695L14");
                    function4.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                    Unit unit = Unit.INSTANCE;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(1611065525);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1611065525);
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(1576407562);
                    ComposerKt.sourceInformation(composer, "306@13031L29");
                    SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, Constants.MAX_HOST_LENGTH);
                    composer.endReplaceGroup();
                }
            } else if (!(state instanceof AsyncImagePainter.State.Success)) {
                if (state instanceof AsyncImagePainter.State.Error) {
                    if (function6 == null) {
                        composer.startReplaceGroup(1611065525);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(1576403106);
                        ComposerKt.sourceInformation(composer, "303@12879L12");
                        function6.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                        Unit unit2 = Unit.INSTANCE;
                        composer.endReplaceGroup();
                        composer.startReplaceGroup(1611065525);
                        composer.endReplaceGroup();
                    }
                } else if (!(state instanceof AsyncImagePainter.State.Empty)) {
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(1576407562);
                ComposerKt.sourceInformation(composer, "306@13031L29");
                SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, Constants.MAX_HOST_LENGTH);
                composer.endReplaceGroup();
            } else if (function5 != null) {
                composer.startReplaceGroup(1576400290);
                ComposerKt.sourceInformation(composer, "302@12789L14");
                function5.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf(i2 & 14));
                Unit unit3 = Unit.INSTANCE;
                composer.endReplaceGroup();
                composer.startReplaceGroup(1611065525);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1611065525);
                composer.endReplaceGroup();
                composer.startReplaceGroup(1576407562);
                ComposerKt.sourceInformation(composer, "306@13031L29");
                SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, Constants.MAX_HOST_LENGTH);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
