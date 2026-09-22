package androidx.wear.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BasicCurvedText.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0013\b\u0002\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"basicCurvedText", "", "Landroidx/wear/compose/foundation/CurvedScope;", "text", "", "modifier", "Landroidx/wear/compose/foundation/CurvedModifier;", "angularDirection", "Landroidx/wear/compose/foundation/CurvedDirection$Angular;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "style", "Lkotlin/Function0;", "Landroidx/wear/compose/foundation/CurvedTextStyle;", "Landroidx/compose/runtime/Composable;", "basicCurvedText-zBu2efk", "(Landroidx/wear/compose/foundation/CurvedScope;Ljava/lang/String;Landroidx/wear/compose/foundation/CurvedModifier;Landroidx/wear/compose/foundation/CurvedDirection$Angular;ILkotlin/jvm/functions/Function2;)V", "basicCurvedText-q1JGhlM", "(Landroidx/wear/compose/foundation/CurvedScope;Ljava/lang/String;Landroidx/wear/compose/foundation/CurvedTextStyle;Landroidx/wear/compose/foundation/CurvedModifier;Landroidx/wear/compose/foundation/CurvedDirection$Angular;I)V", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicCurvedTextKt {
    /* JADX INFO: renamed from: basicCurvedText-zBu2efk$default, reason: not valid java name */
    public static /* synthetic */ void m240basicCurvedTextzBu2efk$default(CurvedScope curvedScope, String str, CurvedModifier curvedModifier, CurvedDirection.Angular angular, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            curvedModifier = CurvedModifier.INSTANCE;
        }
        CurvedModifier curvedModifier2 = curvedModifier;
        if ((i2 & 4) != 0) {
            angular = null;
        }
        CurvedDirection.Angular angular2 = angular;
        if ((i2 & 8) != 0) {
            i = TextOverflow.Companion.getClip-gIe3tQ8();
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            function2 = new Function2<Composer, Integer, CurvedTextStyle>() { // from class: androidx.wear.compose.foundation.BasicCurvedTextKt$basicCurvedText$1
                public final CurvedTextStyle invoke(Composer composer, int i4) {
                    composer.startReplaceGroup(309598800);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(309598800, i4, -1, "androidx.wear.compose.foundation.basicCurvedText.<anonymous> (BasicCurvedText.kt:78)");
                    }
                    CurvedTextStyle curvedTextStyle = new CurvedTextStyle(0L, 0L, 0L, null, null, null, null, 127, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return curvedTextStyle;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke((Composer) obj2, ((Number) obj3).intValue());
                }
            };
        }
        m239basicCurvedTextzBu2efk(curvedScope, str, curvedModifier2, angular2, i3, function2);
    }

    /* JADX INFO: renamed from: basicCurvedText-zBu2efk, reason: not valid java name */
    public static final void m239basicCurvedTextzBu2efk(CurvedScope curvedScope, String str, CurvedModifier curvedModifier, CurvedDirection.Angular angular, int i, Function2<? super Composer, ? super Integer, CurvedTextStyle> function2) {
        curvedScope.add$compose_foundation_release(new CurvedTextChild(str, CurvedLayoutDirection.m315copy3m8pbNU$default(curvedScope.getCurvedLayoutDirection(), null, angular, 1, null).absoluteClockwise(), function2, i, null), curvedModifier);
    }

    /* JADX INFO: renamed from: basicCurvedText-q1JGhlM$default, reason: not valid java name */
    public static /* synthetic */ void m238basicCurvedTextq1JGhlM$default(CurvedScope curvedScope, String str, CurvedTextStyle curvedTextStyle, CurvedModifier curvedModifier, CurvedDirection.Angular angular, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            curvedModifier = CurvedModifier.INSTANCE;
        }
        CurvedModifier curvedModifier2 = curvedModifier;
        if ((i2 & 8) != 0) {
            angular = null;
        }
        CurvedDirection.Angular angular2 = angular;
        if ((i2 & 16) != 0) {
            i = TextOverflow.Companion.getClip-gIe3tQ8();
        }
        m237basicCurvedTextq1JGhlM(curvedScope, str, curvedTextStyle, curvedModifier2, angular2, i);
    }

    /* JADX INFO: renamed from: basicCurvedText-q1JGhlM, reason: not valid java name */
    public static final void m237basicCurvedTextq1JGhlM(CurvedScope curvedScope, String str, final CurvedTextStyle curvedTextStyle, CurvedModifier curvedModifier, CurvedDirection.Angular angular, int i) {
        m239basicCurvedTextzBu2efk(curvedScope, str, curvedModifier, angular, i, new Function2<Composer, Integer, CurvedTextStyle>() { // from class: androidx.wear.compose.foundation.BasicCurvedTextKt$basicCurvedText$2
            {
                super(2);
            }

            public final CurvedTextStyle invoke(Composer composer, int i2) {
                composer.startReplaceGroup(-1103088279);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1103088279, i2, -1, "androidx.wear.compose.foundation.basicCurvedText.<anonymous> (BasicCurvedText.kt:108)");
                }
                CurvedTextStyle curvedTextStyle2 = curvedTextStyle;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return curvedTextStyle2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((Composer) obj, ((Number) obj2).intValue());
            }
        });
    }
}
