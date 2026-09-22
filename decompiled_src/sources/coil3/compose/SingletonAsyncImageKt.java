package coil3.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import coil3.SingletonImageLoader;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SingletonAsyncImage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a×\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0\r2\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"AsyncImage", "", "model", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "clipToBounds", "", "AsyncImage-x1rPTaM", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "AsyncImage-10Xjiaw", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;IZLandroidx/compose/runtime/Composer;III)V", "coil-compose_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SingletonAsyncImageKt {
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    /* JADX INFO: renamed from: AsyncImage-x1rPTaM, reason: not valid java name */
    public static final void m1023AsyncImagex1rPTaM(Object obj, String str, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) throws KotlinNothingValueException {
        ComposerKt.sourceInformationMarkerStart(composer, -846727149, "C(AsyncImage)P(9,4,10,14,6,7,12,13,11!1,5!1,3,8:c#ui.graphics.FilterQuality)64@3265L7,61@3125L506:SingletonAsyncImage.kt#8xxpns");
        Modifier modifier2 = (i4 & 4) != 0 ? (Modifier) Modifier.Companion : modifier;
        Painter painter4 = (i4 & 8) != 0 ? null : painter;
        Painter painter5 = (i4 & 16) != 0 ? null : painter2;
        Painter painter6 = (i4 & 32) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function4 = (i4 & 64) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function5 = (i4 & 128) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Error, Unit> function6 = (i4 & 256) != 0 ? null : function3;
        Alignment center = (i4 & 512) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 4096) != 0 ? null : colorFilter;
        int i5 = (i4 & 8192) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        boolean z2 = (i4 & 16384) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-846727149, i2, i3, "coil3.compose.AsyncImage (SingletonAsyncImage.kt:61)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i6 = i2 << 3;
        int i7 = (i6 & 7168) | (i2 & 126) | (i6 & 57344) | (i6 & 458752) | (i6 & 3670016) | (i6 & 29360128) | (i6 & 234881024) | (i6 & 1879048192);
        int i8 = i3 << 3;
        int i9 = (i8 & 896) | ((i2 >> 27) & 14) | (i8 & 112) | (i8 & 7168) | (i8 & 57344) | (i8 & 458752);
        Alignment alignment2 = center;
        ColorFilter colorFilter3 = colorFilter2;
        Painter painter7 = painter4;
        Painter painter8 = painter6;
        Modifier modifier3 = modifier2;
        AsyncImageKt.m999AsyncImagenc27qi8(obj, str, SingletonImageLoader.get((Context) objConsume), modifier3, painter7, painter5, painter8, function4, function5, function6, alignment2, fit, f2, colorFilter3, i5, z2, composer, i7, i9, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    /* JADX INFO: renamed from: AsyncImage-10Xjiaw, reason: not valid java name */
    public static final void m1022AsyncImage10Xjiaw(Object obj, String str, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, boolean z, Composer composer, int i2, int i3, int i4) throws KotlinNothingValueException {
        ComposerKt.sourceInformationMarkerStart(composer, 1976030921, "C(AsyncImage)P(7,4,8,10,9!1,5!1,3,6:c#ui.graphics.FilterQuality)120@5795L7,117@5655L404:SingletonAsyncImage.kt#8xxpns");
        Modifier modifier2 = (i4 & 4) != 0 ? (Modifier) Modifier.Companion : modifier;
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i4 & 8) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function3 = (i4 & 16) != 0 ? null : function2;
        Alignment center = (i4 & 32) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i4 & 64) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i4 & 128) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i4 & 256) == 0 ? colorFilter : null;
        int i5 = (i4 & 512) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        boolean z2 = (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1976030921, i2, i3, "coil3.compose.AsyncImage (SingletonAsyncImage.kt:117)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i6 = i2 << 3;
        AsyncImageKt.m1000AsyncImagesKDTAoQ(obj, str, SingletonImageLoader.get((Context) objConsume), modifier2, defaultTransform, function3, center, fit, f2, colorFilter2, i5, z2, composer, (i2 & 126) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (234881024 & i6) | (i6 & 1879048192), ((i2 >> 27) & 14) | ((i3 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }
}
