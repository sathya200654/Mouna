package coil3.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import coil3.SingletonImageLoader;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.AbstractStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: SingletonSubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001aÁ\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2&\b\u0002\u0010\u000b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102&\b\u0002\u0010\u0011\u001a \u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102&\b\u0002\u0010\u0013\u001a \u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b$\u0010%\u001a·\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"SubcomposeAsyncImage", "", "model", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State;", "loading", "Lkotlin/Function2;", "Lcoil3/compose/SubcomposeAsyncImageScope;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "success", "Lcoil3/compose/AsyncImagePainter$State$Success;", "error", "Lcoil3/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "SubcomposeAsyncImage-nc27qi8", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "onState", "content", "SubcomposeAsyncImage-gl8XCv8", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "coil-compose_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SingletonSubcomposeAsyncImageKt {
    /* JADX INFO: renamed from: SubcomposeAsyncImage-nc27qi8, reason: not valid java name */
    public static final void m1027SubcomposeAsyncImagenc27qi8(Object obj, String str, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function5, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function6, Function1<? super AsyncImagePainter.State.Loading, Unit> function2, Function1<? super AsyncImagePainter.State.Success, Unit> function3, Function1<? super AsyncImagePainter.State.Error, Unit> function7, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -982876954, "C(SubcomposeAsyncImage)P(9,4,10,15,8,14,6,12,13,11!1,5!1,3,7:c#ui.graphics.FilterQuality)68@3682L7,65@3532L533:SingletonSubcomposeAsyncImage.kt#8xxpns");
        Modifier modifier2 = (i4 & 4) != 0 ? (Modifier) Modifier.Companion : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 8) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function8 = (i4 & 16) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function9 = (i4 & 32) != 0 ? null : function5;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function10 = (i4 & 64) != 0 ? null : function6;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function11 = (i4 & 128) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Success, Unit> function12 = (i4 & 256) != 0 ? null : function3;
        Function1<? super AsyncImagePainter.State.Error, Unit> function13 = (i4 & 512) != 0 ? null : function7;
        Alignment center = (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 4096) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 8192) != 0 ? null : colorFilter;
        Modifier modifier3 = modifier2;
        int i5 = (i4 & 16384) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        boolean z2 = (i4 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-982876954, i2, i3, "coil3.compose.SubcomposeAsyncImage (SingletonSubcomposeAsyncImage.kt:65)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i6 = i2 << 3;
        int i7 = i3 << 3;
        Alignment alignment2 = center;
        ColorFilter colorFilter3 = colorFilter2;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function14 = defaultTransform;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function15 = function9;
        SubcomposeAsyncImageKt.m1030SubcomposeAsyncImageMokUVwQ(obj, str, SingletonImageLoader.get((Context) objConsume), modifier3, function14, function8, function15, function10, function11, function12, function13, alignment2, fit, f2, colorFilter3, i5, z2, composer, (i6 & 7168) | (i2 & 126) | (i6 & 57344) | (i6 & 458752) | (i6 & 3670016) | (i6 & 29360128) | (i6 & 234881024) | (i6 & 1879048192), ((i2 >> 27) & 14) | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (i7 & 458752) | (i7 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: SubcomposeAsyncImage-gl8XCv8, reason: not valid java name */
    public static final void m1026SubcomposeAsyncImagegl8XCv8(Object obj, String str, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 19935049, "C(SubcomposeAsyncImage)P(8,5,9,11,10!1,6!1,3,7:c#ui.graphics.FilterQuality)130@6555L7,127@6405L437:SingletonSubcomposeAsyncImage.kt#8xxpns");
        Modifier modifier2 = (i4 & 4) != 0 ? (Modifier) Modifier.Companion : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 8) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function4 = (i4 & 16) != 0 ? null : function2;
        Alignment center = (i4 & 32) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 64) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 128) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 256) == 0 ? colorFilter : null;
        int i5 = (i4 & 512) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        boolean z2 = (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(19935049, i2, i3, "coil3.compose.SubcomposeAsyncImage (SingletonSubcomposeAsyncImage.kt:127)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i6 = i2 << 3;
        int i7 = i3 << 3;
        SubcomposeAsyncImageKt.m1031SubcomposeAsyncImageQgsmV_s(obj, str, SingletonImageLoader.get((Context) objConsume), modifier2, defaultTransform, function4, center, fit, f2, colorFilter2, i5, z2, function3, composer, (i6 & 1879048192) | (i2 & 126) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6), ((i2 >> 27) & 14) | (i7 & 112) | (i7 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }
}
