package coil3.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil3.SingletonImageLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SingletonAsyncImagePainter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a[\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\t2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"rememberAsyncImagePainter", "Lcoil3/compose/AsyncImagePainter;", "model", "", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-MqR-F_0", "(Ljava/lang/Object;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-19ie5dc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "coil-compose_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SingletonAsyncImagePainterKt {
    /* JADX INFO: renamed from: rememberAsyncImagePainter-MqR-F_0, reason: not valid java name */
    public static final AsyncImagePainter m1025rememberAsyncImagePainterMqRF_0(Object obj, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1650263642, "C(rememberAsyncImagePainter)P(4,8,1,2,6,7,5!,3:c#ui.graphics.FilterQuality)47@2345L7,45@2235L341:SingletonAsyncImagePainter.kt#8xxpns");
        Painter painter4 = (i3 & 2) != 0 ? null : painter;
        if ((i3 & 4) != 0) {
            painter2 = null;
        }
        Painter painter5 = (i3 & 8) != 0 ? painter2 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function4 = (i3 & 16) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function5 = (i3 & 32) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Error, Unit> function6 = (i3 & 64) != 0 ? null : function3;
        ContentScale fit = (i3 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int i4 = (i3 & 256) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1650263642, i2, -1, "coil3.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:45)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i5 = i2 << 3;
        AsyncImagePainter asyncImagePainterM1006rememberAsyncImagePainter3HmZ8SU = AsyncImagePainterKt.m1006rememberAsyncImagePainter3HmZ8SU(obj, SingletonImageLoader.get((Context) objConsume), painter4, painter2, painter5, function4, function5, function6, fit, i4, composer, (i2 & 14) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return asyncImagePainterM1006rememberAsyncImagePainter3HmZ8SU;
    }

    /* JADX INFO: renamed from: rememberAsyncImagePainter-19ie5dc, reason: not valid java name */
    public static final AsyncImagePainter m1024rememberAsyncImagePainter19ie5dc(Object obj, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -1093003120, "C(rememberAsyncImagePainter)P(2,4,3!,1:c#ui.graphics.FilterQuality)84@3952L7,82@3842L239:SingletonAsyncImagePainter.kt#8xxpns");
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> defaultTransform = (i3 & 2) != 0 ? AsyncImagePainter.INSTANCE.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function3 = (i3 & 4) != 0 ? null : function2;
        ContentScale fit = (i3 & 8) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int i4 = (i3 & 16) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1093003120, i2, -1, "coil3.compose.rememberAsyncImagePainter (SingletonAsyncImagePainter.kt:82)");
        }
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i5 = i2 << 3;
        AsyncImagePainter asyncImagePainterM1007rememberAsyncImagePainter5jETZwI = AsyncImagePainterKt.m1007rememberAsyncImagePainter5jETZwI(obj, SingletonImageLoader.get((Context) objConsume), defaultTransform, function3, fit, i4, composer, (i2 & 14) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return asyncImagePainterM1007rememberAsyncImagePainter5jETZwI;
    }
}
