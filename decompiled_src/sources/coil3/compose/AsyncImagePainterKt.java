package coil3.compose;

import android.os.Trace;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil3.ImageLoader;
import coil3.compose.internal.AsyncImageState;
import coil3.compose.internal.UtilsKt;
import coil3.request.ImageRequest;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncImagePainter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001ac\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u000b2\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u000b2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"rememberAsyncImagePainter", "Lcoil3/compose/AsyncImagePainter;", "model", "", "imageLoader", "Lcoil3/ImageLoader;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lkotlin/Function1;", "Lcoil3/compose/AsyncImagePainter$State$Loading;", "", "onSuccess", "Lcoil3/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil3/compose/AsyncImagePainter$State$Error;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-3HmZ8SU", "(Ljava/lang/Object;Lcoil3/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", "transform", "Lcoil3/compose/AsyncImagePainter$State;", "onState", "rememberAsyncImagePainter-5jETZwI", "(Ljava/lang/Object;Lcoil3/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil3/compose/AsyncImagePainter;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcoil3/compose/internal/AsyncImageState;", "rememberAsyncImagePainter-GSdzBsE", "(Lcoil3/compose/internal/AsyncImageState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;I)Lcoil3/compose/AsyncImagePainter;", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AsyncImagePainterKt {
    /* JADX INFO: renamed from: rememberAsyncImagePainter-3HmZ8SU, reason: not valid java name */
    public static final AsyncImagePainter m1006rememberAsyncImagePainter3HmZ8SU(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function2, Function1<? super AsyncImagePainter.State.Error, Unit> function3, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1219624997, "C(rememberAsyncImagePainter)P(5,4,9,1,2,7,8,6!,3:c#ui.graphics.FilterQuality)86@3974L35,85@3935L260:AsyncImagePainter.kt#8xxpns");
        Painter painter4 = (i3 & 4) != 0 ? null : painter;
        Painter painter5 = (i3 & 8) != 0 ? null : painter2;
        Painter painter6 = (i3 & 16) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function4 = (i3 & 32) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function5 = (i3 & 64) != 0 ? null : function2;
        Function1<? super AsyncImagePainter.State.Error, Unit> function6 = (i3 & 128) == 0 ? function3 : null;
        ContentScale fit = (i3 & 256) != 0 ? ContentScale.Companion.getFit() : contentScale;
        int i4 = (i3 & 512) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1219624997, i2, -1, "coil3.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:85)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        CompositionLocal localAsyncImageModelEqualityDelegate = LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localAsyncImageModelEqualityDelegate);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) objConsume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImagePainter asyncImagePainterM1008rememberAsyncImagePainterGSdzBsE = m1008rememberAsyncImagePainterGSdzBsE(asyncImageState, UtilsKt.transformOf(painter4, painter5, painter6), UtilsKt.onStateOf(function4, function5, function6), fit, i4, composer, (i2 >> 15) & 64512);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return asyncImagePainterM1008rememberAsyncImagePainterGSdzBsE;
    }

    /* JADX INFO: renamed from: rememberAsyncImagePainter-5jETZwI, reason: not valid java name */
    public static final AsyncImagePainter m1007rememberAsyncImagePainter5jETZwI(Object obj, ImageLoader imageLoader, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1066092719, "C(rememberAsyncImagePainter)P(3,2,5,4!,1:c#ui.graphics.FilterQuality)120@5612L35,119@5573L195:AsyncImagePainter.kt#8xxpns");
        if ((i3 & 4) != 0) {
            function1 = AsyncImagePainter.INSTANCE.getDefaultTransform();
        }
        Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function3 = function1;
        if ((i3 & 8) != 0) {
            function2 = null;
        }
        if ((i3 & 16) != 0) {
            contentScale = ContentScale.Companion.getFit();
        }
        ContentScale contentScale2 = contentScale;
        if ((i3 & 32) != 0) {
            i = DrawScope.Companion.getDefaultFilterQuality-f-v9h1I();
        }
        int i4 = i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066092719, i2, -1, "coil3.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:119)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1014878424, "CC(AsyncImageState)P(1)148@4782L7:utils.kt#7tflp");
        CompositionLocal localAsyncImageModelEqualityDelegate = LocalAsyncImageModelEqualityDelegateKt.getLocalAsyncImageModelEqualityDelegate();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localAsyncImageModelEqualityDelegate);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImageState asyncImageState = new AsyncImageState(obj, (AsyncImageModelEqualityDelegate) objConsume, imageLoader);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AsyncImagePainter asyncImagePainterM1008rememberAsyncImagePainterGSdzBsE = m1008rememberAsyncImagePainterGSdzBsE(asyncImageState, function3, function2, contentScale2, i4, composer, (i2 >> 3) & 65520);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return asyncImagePainterM1008rememberAsyncImagePainterGSdzBsE;
    }

    /* JADX INFO: renamed from: rememberAsyncImagePainter-GSdzBsE, reason: not valid java name */
    private static final AsyncImagePainter m1008rememberAsyncImagePainterGSdzBsE(AsyncImageState asyncImageState, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function2, ContentScale contentScale, int i, Composer composer, int i2) {
        composer.startReplaceGroup(-1242991349);
        ComposerKt.sourceInformation(composer, "C(rememberAsyncImagePainter)P(3,4,2!,1:c#ui.graphics.FilterQuality)*135@6059L22,139@6209L37,140@6267L24,145@6467L16:AsyncImagePainter.kt#8xxpns");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1242991349, i2, -1, "coil3.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:134)");
        }
        Trace.beginSection("rememberAsyncImagePainter");
        try {
            ImageRequest imageRequestRequestOf = UtilsKt.requestOf(asyncImageState.getModel(), composer, 0);
            UtilsKt.validateRequest(imageRequestRequestOf);
            AsyncImagePainter.Input input = new AsyncImagePainter.Input(asyncImageState.getImageLoader(), imageRequestRequestOf, asyncImageState.getModelEqualityDelegate());
            ComposerKt.sourceInformationMarkerStart(composer, -559165852, "CC(remember):AsyncImagePainter.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new AsyncImagePainter(input);
                composer.updateRememberedValue(objRememberedValue);
            }
            AsyncImagePainter asyncImagePainter = (AsyncImagePainter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            asyncImagePainter.setScope$coil_compose_core_release((CoroutineScope) objRememberedValue2);
            asyncImagePainter.setTransform$coil_compose_core_release(function1);
            asyncImagePainter.setOnState$coil_compose_core_release(function2);
            asyncImagePainter.setContentScale$coil_compose_core_release(contentScale);
            asyncImagePainter.m1005setFilterQualityvDHp3xo$coil_compose_core_release(i);
            asyncImagePainter.setPreviewHandler$coil_compose_core_release(UtilsKt.previewHandler(composer, 0));
            asyncImagePainter.set_input$coil_compose_core_release(input);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return asyncImagePainter;
        } finally {
            Trace.endSection();
        }
    }
}
