package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt;
import androidx.wear.compose.foundation.CompositionLocalsKt;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.grpc.internal.GrpcUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: SwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0099\u0001\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u001221\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0099\u0001\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u001d2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u001221\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001e\u001a\u0089\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u001221\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0089\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u001221\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010!\u001a\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0002\u001a3\u0010'\u001a\u00020\u001d2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00120+H\u0007¢\u0006\u0002\u0010,\u001a(\u0010-\u001a\u00020\b*\u00020\b2\u0006\u0010.\u001a\u00020\u001d2\b\b\u0002\u0010/\u001a\u000200H\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"SWIPE_TO_DISMISS_BOX_ANIMATION_SPEC", "Landroidx/compose/animation/core/TweenSpec;", "", "SwipeToDismissBox", "", "onDismissed", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/foundation/SwipeToDismissBoxState;", "backgroundScrimColor", "Landroidx/compose/ui/graphics/Color;", "contentScrimColor", "backgroundKey", "", "contentKey", "hasBackground", "", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/BoxScope;", "Lkotlin/ParameterName;", "name", "isBackground", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SwipeToDismissBox-LHOAhiI", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/wear/compose/foundation/SwipeToDismissBoxState;JJLjava/lang/Object;Ljava/lang/Object;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "Landroidx/wear/compose/material/SwipeToDismissBoxState;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/wear/compose/material/SwipeToDismissBoxState;JJLjava/lang/Object;Ljava/lang/Object;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SwipeToDismissBox-njYn8yo", "(Landroidx/wear/compose/foundation/SwipeToDismissBoxState;Landroidx/compose/ui/Modifier;JJLjava/lang/Object;Ljava/lang/Object;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/wear/compose/material/SwipeToDismissBoxState;Landroidx/compose/ui/Modifier;JJLjava/lang/Object;Ljava/lang/Object;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "convertFromFoundationSwipeToDismissValue", "Landroidx/wear/compose/material/SwipeToDismissValue;", "value", "Landroidx/wear/compose/foundation/SwipeToDismissValue;", "convertToFoundationSwipeToDismissValue", "rememberSwipeToDismissBoxState", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/SwipeToDismissBoxState;", "edgeSwipeToDismiss", "swipeToDismissBoxState", "edgeWidth", "Landroidx/compose/ui/unit/Dp;", "edgeSwipeToDismiss-wH6b6FI", "(Landroidx/compose/ui/Modifier;Landroidx/wear/compose/material/SwipeToDismissBoxState;F)Landroidx/compose/ui/Modifier;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissBoxKt {
    private static final TweenSpec<Float> SWIPE_TO_DISMISS_BOX_ANIMATION_SPEC = new TweenSpec<>(200, 0, EasingKt.getLinearOutSlowInEasing());

    /* JADX INFO: compiled from: SwipeToDismissBox.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SwipeToDismissValue.values().length];
            try {
                iArr[SwipeToDismissValue.Default.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SwipeToDismissValue.Dismissed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[androidx.wear.compose.foundation.SwipeToDismissValue.values().length];
            try {
                iArr2[androidx.wear.compose.foundation.SwipeToDismissValue.Default.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[androidx.wear.compose.foundation.SwipeToDismissValue.Dismissed.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0137 A[PHI: r3 r4 r6 r7 r9 r14
  0x0137: PHI (r3v6 java.lang.Object) = (r3v2 java.lang.Object), (r3v1 java.lang.Object), (r3v1 java.lang.Object) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r4v26 int) = (r4v20 int), (r4v27 int), (r4v28 int) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r6v6 androidx.compose.ui.Modifier) = (r6v3 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r7v10 long) = (r7v7 long), (r7v6 long), (r7v6 long) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r9v7 long) = (r9v3 long), (r9v2 long), (r9v2 long) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r14v6 java.lang.Object) = (r14v3 java.lang.Object), (r14v2 java.lang.Object), (r14v2 java.lang.Object) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:107:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x013c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0146  */
    /* JADX WARN: Code duplicated, block: B:114:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x016a  */
    /* JADX WARN: Code duplicated, block: B:120:0x016f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0179  */
    /* JADX WARN: Code duplicated, block: B:126:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:130:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:95:0x0119  */
    /* JADX WARN: Code duplicated, block: B:97:0x0121  */
    /* JADX INFO: renamed from: SwipeToDismissBox-njYn8yo, reason: not valid java name */
    public static final void m809SwipeToDismissBoxnjYn8yo(final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState, Modifier modifier, long j, long j2, Object obj, Object obj2, boolean z, final Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long background;
        long background2;
        int i4;
        Object obj3;
        int i5;
        int i6;
        Object obj4;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        final Object obj5;
        final long j3;
        final Modifier modifier3;
        final boolean z3;
        final long j4;
        final Object obj6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-880364781);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeToDismissBox)P(7,6,1:c#ui.graphics.Color,4:c#ui.graphics.Color!1,3,5)73@3748L6,74@3812L6,83@4229L298,80@4046L481:SwipeToDismissBox.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(swipeToDismissBoxState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    background = j;
                    int i13 = composerStartRestartGroup.changed(background) ? 256 : 128;
                    i3 |= i13;
                } else {
                    background = j;
                }
                i3 |= i13;
            } else {
                background = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    background2 = j2;
                    if (composerStartRestartGroup.changed(background2)) {
                        i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i11;
                } else {
                    background2 = j2;
                }
                i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i11;
            } else {
                background2 = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    obj3 = obj;
                    if (composerStartRestartGroup.changedInstance(obj3)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= 196608;
                    obj4 = obj2;
                } else {
                    obj4 = obj2;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(obj4)) {
                            i7 = 131072;
                        } else {
                            i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i7;
                    }
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i2 & 128) != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 4793491) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                            }
                            final boolean z4 = z2;
                            final Object obj7 = obj4;
                            final Modifier modifier4 = modifier2;
                            final Object obj8 = obj3;
                            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj9, Object obj10) {
                                    invoke((Composer) obj9, ((Number) obj10).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i14) {
                                    ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                                    if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                                        }
                                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier4, obj8, obj7, z4, function4, composer2, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            obj5 = obj4;
                            j3 = background;
                            modifier3 = modifier2;
                            long j5 = background2;
                            z3 = z4;
                            j4 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        z2 = z;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                        }
                        final boolean z5 = z2;
                        final Object obj9 = obj4;
                        final Modifier modifier5 = modifier2;
                        final Object obj10 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                                invoke((Composer) obj11, ((Number) obj12).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                                if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier5, obj10, obj9, z5, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj5 = obj4;
                        j3 = background;
                        modifier3 = modifier2;
                        long j6 = background2;
                        z3 = z5;
                        j4 = j6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        obj5 = obj4;
                        j3 = background;
                        modifier3 = modifier2;
                        j4 = background2;
                        z3 = z;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                                invoke((Composer) obj11, ((Number) obj12).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                SwipeToDismissBoxKt.m809SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                    }
                    final boolean z6 = z2;
                    final Object obj11 = obj4;
                    final Modifier modifier6 = modifier2;
                    final Object obj12 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj13, Object obj14) {
                            invoke((Composer) obj13, ((Number) obj14).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier6, obj12, obj11, z6, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j7 = background2;
                    z3 = z6;
                    j4 = j7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                    }
                    final boolean z7 = z2;
                    final Object obj13 = obj4;
                    final Modifier modifier7 = modifier2;
                    final Object obj14 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                            invoke((Composer) obj15, ((Number) obj16).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier7, obj14, obj13, z7, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j8 = background2;
                    z3 = z7;
                    j4 = j8;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                            invoke((Composer) obj15, ((Number) obj16).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            SwipeToDismissBoxKt.m809SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            obj3 = obj;
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= 196608;
                obj4 = obj2;
            } else {
                obj4 = obj2;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(obj4)) {
                        i7 = 131072;
                    } else {
                        i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i10;
                }
                if ((i3 & 4793491) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                    }
                    final boolean z8 = z2;
                    final Object obj15 = obj4;
                    final Modifier modifier8 = modifier2;
                    final Object obj16 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj17, Object obj18) {
                            invoke((Composer) obj17, ((Number) obj18).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier8, obj16, obj15, z8, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j9 = background2;
                    z3 = z8;
                    j4 = j9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                    }
                    final boolean z9 = z2;
                    final Object obj17 = obj4;
                    final Modifier modifier9 = modifier2;
                    final Object obj18 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj110) {
                            invoke((Composer) obj19, ((Number) obj110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier9, obj18, obj17, z9, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j10 = background2;
                    z3 = z9;
                    j4 = j10;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj110) {
                            invoke((Composer) obj19, ((Number) obj110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            SwipeToDismissBoxKt.m809SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                }
                final boolean z10 = z2;
                final Object obj19 = obj4;
                final Modifier modifier10 = modifier2;
                final Object obj110 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj111, Object obj112) {
                        invoke((Composer) obj111, ((Number) obj112).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier10, obj110, obj19, z10, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j11 = background2;
                z3 = z10;
                j4 = j11;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                }
                final boolean z11 = z2;
                final Object obj111 = obj4;
                final Modifier modifier11 = modifier2;
                final Object obj112 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj113, Object obj114) {
                        invoke((Composer) obj113, ((Number) obj114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier11, obj112, obj111, z11, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j12 = background2;
                z3 = z11;
                j4 = j12;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj113, Object obj114) {
                        invoke((Composer) obj113, ((Number) obj114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        SwipeToDismissBoxKt.m809SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                background = j;
                if (composerStartRestartGroup.changed(background)) {
                }
                i3 |= i13;
            } else {
                background = j;
            }
            i3 |= i13;
        } else {
            background = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                background2 = j2;
                if (composerStartRestartGroup.changed(background2)) {
                    i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i11;
            } else {
                background2 = j2;
            }
            i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i11;
        } else {
            background2 = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                obj3 = obj;
                if (composerStartRestartGroup.changedInstance(obj3)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= 196608;
                obj4 = obj2;
            } else {
                obj4 = obj2;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(obj4)) {
                        i7 = 131072;
                    } else {
                        i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i10;
                }
                if ((i3 & 4793491) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                    }
                    final boolean z12 = z2;
                    final Object obj113 = obj4;
                    final Modifier modifier12 = modifier2;
                    final Object obj114 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj115, Object obj116) {
                            invoke((Composer) obj115, ((Number) obj116).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier12, obj114, obj113, z12, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j13 = background2;
                    z3 = z12;
                    j4 = j13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                    }
                    final boolean z13 = z2;
                    final Object obj115 = obj4;
                    final Modifier modifier13 = modifier2;
                    final Object obj116 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj117, Object obj118) {
                            invoke((Composer) obj117, ((Number) obj118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier13, obj116, obj115, z13, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j14 = background2;
                    z3 = z13;
                    j4 = j14;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj117, Object obj118) {
                            invoke((Composer) obj117, ((Number) obj118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            SwipeToDismissBoxKt.m809SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                }
                final boolean z14 = z2;
                final Object obj117 = obj4;
                final Modifier modifier14 = modifier2;
                final Object obj118 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj119, Object obj1110) {
                        invoke((Composer) obj119, ((Number) obj1110).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier14, obj118, obj117, z14, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j15 = background2;
                z3 = z14;
                j4 = j15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                }
                final boolean z15 = z2;
                final Object obj119 = obj4;
                final Modifier modifier15 = modifier2;
                final Object obj1110 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111, Object obj1112) {
                        invoke((Composer) obj1111, ((Number) obj1112).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier15, obj1110, obj119, z15, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j16 = background2;
                z3 = z15;
                j4 = j16;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111, Object obj1112) {
                        invoke((Composer) obj1111, ((Number) obj1112).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        SwipeToDismissBoxKt.m809SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        obj3 = obj;
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= 196608;
            obj4 = obj2;
        } else {
            obj4 = obj2;
            if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(obj4)) {
                    i7 = 131072;
                } else {
                    i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((i2 & 128) != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i3 |= i10;
            }
            if ((i3 & 4793491) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                }
                final boolean z16 = z2;
                final Object obj1111 = obj4;
                final Modifier modifier16 = modifier2;
                final Object obj1112 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1113, Object obj1114) {
                        invoke((Composer) obj1113, ((Number) obj1114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier16, obj1112, obj1111, z16, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j17 = background2;
                z3 = z16;
                j4 = j17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
                }
                final boolean z17 = z2;
                final Object obj1113 = obj4;
                final Modifier modifier17 = modifier2;
                final Object obj1114 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1115, Object obj1116) {
                        invoke((Composer) obj1115, ((Number) obj1116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier17, obj1114, obj1113, z17, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j18 = background2;
                z3 = z17;
                j4 = j18;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1115, Object obj1116) {
                        invoke((Composer) obj1115, ((Number) obj1116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        SwipeToDismissBoxKt.m809SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i3 & 4793491) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
            }
            final boolean z18 = z2;
            final Object obj1115 = obj4;
            final Modifier modifier18 = modifier2;
            final Object obj1116 = obj3;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj1117, Object obj1118) {
                    invoke((Composer) obj1117, ((Number) obj1118).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i14) {
                    ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                    if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                        }
                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier18, obj1116, obj1115, z18, function4, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            obj5 = obj4;
            j3 = background;
            modifier3 = modifier2;
            long j19 = background2;
            z3 = z18;
            j4 = j19;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:79)");
            }
            final boolean z19 = z2;
            final Object obj1117 = obj4;
            final Modifier modifier19 = modifier2;
            final Object obj1118 = obj3;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj1119, Object obj11110) {
                    invoke((Composer) obj1119, ((Number) obj11110).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i14) {
                    ComposerKt.sourceInformation(composer2, "C84@4272L249:SwipeToDismissBox.kt#gj9v0t");
                    if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:84)");
                        }
                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState, modifier19, obj1118, obj1117, z19, function4, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            obj5 = obj4;
            j3 = background;
            modifier3 = modifier2;
            long j110 = background2;
            z3 = z19;
            j4 = j110;
        }
        obj6 = obj3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj1119, Object obj11110) {
                    invoke((Composer) obj1119, ((Number) obj11110).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i14) {
                    SwipeToDismissBoxKt.m809SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0137 A[PHI: r3 r4 r6 r7 r9 r14
  0x0137: PHI (r3v6 java.lang.Object) = (r3v2 java.lang.Object), (r3v1 java.lang.Object), (r3v1 java.lang.Object) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r4v26 int) = (r4v20 int), (r4v27 int), (r4v28 int) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r6v6 androidx.compose.ui.Modifier) = (r6v3 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r7v10 long) = (r7v7 long), (r7v6 long), (r7v6 long) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r9v7 long) = (r9v3 long), (r9v2 long), (r9v2 long) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]
  0x0137: PHI (r14v6 java.lang.Object) = (r14v3 java.lang.Object), (r14v2 java.lang.Object), (r14v2 java.lang.Object) binds: [B:119:0x016d, B:104:0x0133, B:105:0x0135] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:107:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x013c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0146  */
    /* JADX WARN: Code duplicated, block: B:114:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x016a  */
    /* JADX WARN: Code duplicated, block: B:120:0x016f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0179  */
    /* JADX WARN: Code duplicated, block: B:126:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:130:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:95:0x0119  */
    /* JADX WARN: Code duplicated, block: B:97:0x0121  */
    @Deprecated(message = "This overload is provided for backwards compatibility. A newer overload is available that uses androidx.wear.compose.foundation.SwipeToDismissBoxState.", replaceWith = @ReplaceWith(expression = "SwipeToDismissBox(state, modifier, backgroundScrimColor, contentScrimColor, backgroundKey, contentKey,hasBackground, content)", imports = {}))
    /* JADX INFO: renamed from: SwipeToDismissBox-njYn8yo, reason: not valid java name */
    public static final void m810SwipeToDismissBoxnjYn8yo(final SwipeToDismissBoxState swipeToDismissBoxState, Modifier modifier, long j, long j2, Object obj, Object obj2, boolean z, final Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long background;
        long background2;
        int i4;
        Object obj3;
        int i5;
        int i6;
        Object obj4;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        final Object obj5;
        final long j3;
        final Modifier modifier3;
        final boolean z3;
        final long j4;
        final Object obj6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-880364781);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeToDismissBox)P(7,6,1:c#ui.graphics.Color,4:c#ui.graphics.Color!1,3,5)142@7139L6,143@7203L6,152@7620L314,149@7437L497:SwipeToDismissBox.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(swipeToDismissBoxState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    background = j;
                    int i13 = composerStartRestartGroup.changed(background) ? 256 : 128;
                    i3 |= i13;
                } else {
                    background = j;
                }
                i3 |= i13;
            } else {
                background = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    background2 = j2;
                    if (composerStartRestartGroup.changed(background2)) {
                        i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i11;
                } else {
                    background2 = j2;
                }
                i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i11;
            } else {
                background2 = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    obj3 = obj;
                    if (composerStartRestartGroup.changedInstance(obj3)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= 196608;
                    obj4 = obj2;
                } else {
                    obj4 = obj2;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(obj4)) {
                            i7 = 131072;
                        } else {
                            i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i7;
                    }
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i2 & 128) != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 8388608;
                        } else {
                            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 4793491) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                            }
                            final boolean z4 = z2;
                            final Object obj7 = obj4;
                            final Modifier modifier4 = modifier2;
                            final Object obj8 = obj3;
                            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj9, Object obj10) {
                                    invoke((Composer) obj9, ((Number) obj10).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i14) {
                                    ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                                    if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                                        }
                                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier4, obj8, obj7, z4, function4, composer2, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            obj5 = obj4;
                            j3 = background;
                            modifier3 = modifier2;
                            long j5 = background2;
                            z3 = z4;
                            j4 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        z2 = z;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                        }
                        final boolean z5 = z2;
                        final Object obj9 = obj4;
                        final Modifier modifier5 = modifier2;
                        final Object obj10 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                                invoke((Composer) obj11, ((Number) obj12).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                                if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier5, obj10, obj9, z5, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj5 = obj4;
                        j3 = background;
                        modifier3 = modifier2;
                        long j6 = background2;
                        z3 = z5;
                        j4 = j6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        obj5 = obj4;
                        j3 = background;
                        modifier3 = modifier2;
                        j4 = background2;
                        z3 = z;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                                invoke((Composer) obj11, ((Number) obj12).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                SwipeToDismissBoxKt.m810SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                    }
                    final boolean z6 = z2;
                    final Object obj11 = obj4;
                    final Modifier modifier6 = modifier2;
                    final Object obj12 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj13, Object obj14) {
                            invoke((Composer) obj13, ((Number) obj14).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier6, obj12, obj11, z6, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j7 = background2;
                    z3 = z6;
                    j4 = j7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                    }
                    final boolean z7 = z2;
                    final Object obj13 = obj4;
                    final Modifier modifier7 = modifier2;
                    final Object obj14 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                            invoke((Composer) obj15, ((Number) obj16).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier7, obj14, obj13, z7, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j8 = background2;
                    z3 = z7;
                    j4 = j8;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                            invoke((Composer) obj15, ((Number) obj16).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            SwipeToDismissBoxKt.m810SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            obj3 = obj;
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= 196608;
                obj4 = obj2;
            } else {
                obj4 = obj2;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(obj4)) {
                        i7 = 131072;
                    } else {
                        i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i10;
                }
                if ((i3 & 4793491) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                    }
                    final boolean z8 = z2;
                    final Object obj15 = obj4;
                    final Modifier modifier8 = modifier2;
                    final Object obj16 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj17, Object obj18) {
                            invoke((Composer) obj17, ((Number) obj18).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier8, obj16, obj15, z8, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j9 = background2;
                    z3 = z8;
                    j4 = j9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                    }
                    final boolean z9 = z2;
                    final Object obj17 = obj4;
                    final Modifier modifier9 = modifier2;
                    final Object obj18 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj110) {
                            invoke((Composer) obj19, ((Number) obj110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier9, obj18, obj17, z9, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j10 = background2;
                    z3 = z9;
                    j4 = j10;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj110) {
                            invoke((Composer) obj19, ((Number) obj110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            SwipeToDismissBoxKt.m810SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                }
                final boolean z10 = z2;
                final Object obj19 = obj4;
                final Modifier modifier10 = modifier2;
                final Object obj110 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj111, Object obj112) {
                        invoke((Composer) obj111, ((Number) obj112).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier10, obj110, obj19, z10, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j11 = background2;
                z3 = z10;
                j4 = j11;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                }
                final boolean z11 = z2;
                final Object obj111 = obj4;
                final Modifier modifier11 = modifier2;
                final Object obj112 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj113, Object obj114) {
                        invoke((Composer) obj113, ((Number) obj114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier11, obj112, obj111, z11, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j12 = background2;
                z3 = z11;
                j4 = j12;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj113, Object obj114) {
                        invoke((Composer) obj113, ((Number) obj114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        SwipeToDismissBoxKt.m810SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                background = j;
                if (composerStartRestartGroup.changed(background)) {
                }
                i3 |= i13;
            } else {
                background = j;
            }
            i3 |= i13;
        } else {
            background = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                background2 = j2;
                if (composerStartRestartGroup.changed(background2)) {
                    i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i11;
            } else {
                background2 = j2;
            }
            i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i11;
        } else {
            background2 = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                obj3 = obj;
                if (composerStartRestartGroup.changedInstance(obj3)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= 196608;
                obj4 = obj2;
            } else {
                obj4 = obj2;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(obj4)) {
                        i7 = 131072;
                    } else {
                        i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i2 & 128) != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 8388608;
                    } else {
                        i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i10;
                }
                if ((i3 & 4793491) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                    }
                    final boolean z12 = z2;
                    final Object obj113 = obj4;
                    final Modifier modifier12 = modifier2;
                    final Object obj114 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj115, Object obj116) {
                            invoke((Composer) obj115, ((Number) obj116).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier12, obj114, obj113, z12, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j13 = background2;
                    z3 = z12;
                    j4 = j13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                    }
                    final boolean z13 = z2;
                    final Object obj115 = obj4;
                    final Modifier modifier13 = modifier2;
                    final Object obj116 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj117, Object obj118) {
                            invoke((Composer) obj117, ((Number) obj118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier13, obj116, obj115, z13, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj5 = obj4;
                    j3 = background;
                    modifier3 = modifier2;
                    long j14 = background2;
                    z3 = z13;
                    j4 = j14;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj117, Object obj118) {
                            invoke((Composer) obj117, ((Number) obj118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            SwipeToDismissBoxKt.m810SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                }
                final boolean z14 = z2;
                final Object obj117 = obj4;
                final Modifier modifier14 = modifier2;
                final Object obj118 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj119, Object obj1110) {
                        invoke((Composer) obj119, ((Number) obj1110).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier14, obj118, obj117, z14, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j15 = background2;
                z3 = z14;
                j4 = j15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                }
                final boolean z15 = z2;
                final Object obj119 = obj4;
                final Modifier modifier15 = modifier2;
                final Object obj1110 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111, Object obj1112) {
                        invoke((Composer) obj1111, ((Number) obj1112).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier15, obj1110, obj119, z15, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j16 = background2;
                z3 = z15;
                j4 = j16;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111, Object obj1112) {
                        invoke((Composer) obj1111, ((Number) obj1112).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        SwipeToDismissBoxKt.m810SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        obj3 = obj;
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= 196608;
            obj4 = obj2;
        } else {
            obj4 = obj2;
            if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(obj4)) {
                    i7 = 131072;
                } else {
                    i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((i2 & 128) != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 8388608;
                } else {
                    i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i3 |= i10;
            }
            if ((i3 & 4793491) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                }
                final boolean z16 = z2;
                final Object obj1111 = obj4;
                final Modifier modifier16 = modifier2;
                final Object obj1112 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1113, Object obj1114) {
                        invoke((Composer) obj1113, ((Number) obj1114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier16, obj1112, obj1111, z16, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j17 = background2;
                z3 = z16;
                j4 = j17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
                }
                final boolean z17 = z2;
                final Object obj1113 = obj4;
                final Modifier modifier17 = modifier2;
                final Object obj1114 = obj3;
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1115, Object obj1116) {
                        invoke((Composer) obj1115, ((Number) obj1116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                        if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier17, obj1114, obj1113, z17, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                j3 = background;
                modifier3 = modifier2;
                long j18 = background2;
                z3 = z17;
                j4 = j18;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1115, Object obj1116) {
                        invoke((Composer) obj1115, ((Number) obj1116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i14) {
                        SwipeToDismissBoxKt.m810SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i3 & 4793491) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
            }
            final boolean z18 = z2;
            final Object obj1115 = obj4;
            final Modifier modifier18 = modifier2;
            final Object obj1116 = obj3;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj1117, Object obj1118) {
                    invoke((Composer) obj1117, ((Number) obj1118).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i14) {
                    ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                    if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                        }
                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier18, obj1116, obj1115, z18, function4, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            obj5 = obj4;
            j3 = background;
            modifier3 = modifier2;
            long j19 = background2;
            z3 = z18;
            j4 = j19;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880364781, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:148)");
            }
            final boolean z19 = z2;
            final Object obj1117 = obj4;
            final Modifier modifier19 = modifier2;
            final Object obj1118 = obj3;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background)), CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2))}, ComposableLambdaKt.rememberComposableLambda(-1003730989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj1119, Object obj11110) {
                    invoke((Composer) obj1119, ((Number) obj11110).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i14) {
                    ComposerKt.sourceInformation(composer2, "C153@7663L265:SwipeToDismissBox.kt#gj9v0t");
                    if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1003730989, i14, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:153)");
                        }
                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(swipeToDismissBoxState.getFoundationState(), modifier19, obj1118, obj1117, z19, function4, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            obj5 = obj4;
            j3 = background;
            modifier3 = modifier2;
            long j110 = background2;
            z3 = z19;
            j4 = j110;
        }
        obj6 = obj3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj1119, Object obj11110) {
                    invoke((Composer) obj1119, ((Number) obj11110).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i14) {
                    SwipeToDismissBoxKt.m810SwipeToDismissBoxnjYn8yo(swipeToDismissBoxState, modifier3, j3, j4, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0124  */
    /* JADX WARN: Code duplicated, block: B:107:0x0138  */
    /* JADX WARN: Code duplicated, block: B:109:0x0142  */
    /* JADX WARN: Code duplicated, block: B:121:0x015e A[PHI: r3 r4 r6 r7 r8 r10 r15
  0x015e: PHI (r3v9 java.lang.Object) = (r3v2 java.lang.Object), (r3v1 java.lang.Object), (r3v1 java.lang.Object) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r4v34 int) = (r4v22 int), (r4v36 int), (r4v37 int) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r6v7 androidx.compose.ui.Modifier) = (r6v3 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r7v11 androidx.wear.compose.foundation.SwipeToDismissBoxState) = 
  (r7v7 androidx.wear.compose.foundation.SwipeToDismissBoxState)
  (r7v6 androidx.wear.compose.foundation.SwipeToDismissBoxState)
  (r7v6 androidx.wear.compose.foundation.SwipeToDismissBoxState)
 binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r8v6 long) = (r8v3 long), (r8v2 long), (r8v2 long) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r10v7 long) = (r10v3 long), (r10v2 long), (r10v2 long) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r15v7 java.lang.Object) = (r15v4 java.lang.Object), (r15v3 java.lang.Object), (r15v3 java.lang.Object) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:122:0x0161 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x0163  */
    /* JADX WARN: Code duplicated, block: B:126:0x016c  */
    /* JADX WARN: Code duplicated, block: B:129:0x017b  */
    /* JADX WARN: Code duplicated, block: B:132:0x018b  */
    /* JADX WARN: Code duplicated, block: B:134:0x019a  */
    /* JADX WARN: Code duplicated, block: B:136:0x019f  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:145:0x0210  */
    /* JADX WARN: Code duplicated, block: B:149:0x0222  */
    /* JADX WARN: Code duplicated, block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:92:0x0104  */
    /* JADX WARN: Code duplicated, block: B:94:0x0108  */
    /* JADX WARN: Code duplicated, block: B:96:0x0110  */
    /* JADX WARN: Code duplicated, block: B:97:0x0113  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: SwipeToDismissBox-LHOAhiI, reason: not valid java name */
    public static final void m807SwipeToDismissBoxLHOAhiI(final Function0<Unit> function0, Modifier modifier, androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState, long j, long j2, Object obj, Object obj2, boolean z, final Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState;
        long background;
        long background2;
        int i4;
        Object obj3;
        int i5;
        int i6;
        Object obj4;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        char c;
        final Modifier modifier3;
        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState2;
        final long j3;
        final boolean z3;
        final long j4;
        final Object obj5;
        final Object obj6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1794054631);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeToDismissBox)P(7,6,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color!1,3,5)204@10291L32,205@10373L6,206@10437L6,215@10854L337,212@10671L520:SwipeToDismissBox.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
                    int i13 = composerStartRestartGroup.changed(swipeToDismissBoxStateRememberSwipeToDismissBoxState) ? 256 : 128;
                    i3 |= i13;
                } else {
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
                }
                i3 |= i13;
            } else {
                swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    background = j;
                    if (composerStartRestartGroup.changed(background)) {
                        i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i11;
                } else {
                    background = j;
                }
                i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i11;
            } else {
                background = j;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    background2 = j2;
                    int i14 = composerStartRestartGroup.changed(background2) ? 16384 : 8192;
                    i3 |= i14;
                } else {
                    background2 = j2;
                }
                i3 |= i14;
            } else {
                background2 = j2;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    obj3 = obj;
                    if (composerStartRestartGroup.changedInstance(obj3)) {
                        i5 = 131072;
                    } else {
                        i5 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    obj4 = obj2;
                } else {
                    obj4 = obj2;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(obj4)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i9 = 8388608;
                        } else {
                            i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 67108864;
                            } else {
                                i10 = 33554432;
                            }
                            i3 |= i10;
                        }
                        if ((i3 & 38347923) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                                }
                                if ((i2 & 8) != 0) {
                                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                    i3 &= -57345;
                                }
                                if (i4 != 0) {
                                    obj3 = SwipeToDismissKeys.Background;
                                }
                                if (i6 != 0) {
                                    obj4 = SwipeToDismissKeys.Content;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    c = 1;
                                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                                } else {
                                    c = 1;
                                }
                                ProvidedValue[] providedValueArr = new ProvidedValue[2];
                                providedValueArr[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                                providedValueArr[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                                final boolean z4 = z2;
                                final Object obj7 = obj4;
                                final Modifier modifier4 = modifier2;
                                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState3 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                final Object obj8 = obj3;
                                CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj9, Object obj10) {
                                        invoke((Composer) obj9, ((Number) obj10).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i15) {
                                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                            }
                                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier4, swipeToDismissBoxState3, obj8, obj7, z4, function4, composer2, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                j3 = background2;
                                z3 = z4;
                                j4 = background;
                                obj5 = obj7;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                            }
                            z2 = z;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                c = 1;
                                ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                            } else {
                                c = 1;
                            }
                            ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                            providedValueArr2[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                            providedValueArr2[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                            final boolean z5 = z2;
                            final Object obj9 = obj4;
                            final Modifier modifier5 = modifier2;
                            final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState4 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                            final Object obj10 = obj3;
                            CompositionLocalKt.CompositionLocalProvider(providedValueArr2, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                                    invoke((Composer) obj11, ((Number) obj12).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i15) {
                                    ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                        }
                                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier5, swipeToDismissBoxState4, obj10, obj9, z5, function4, composer2, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                            j3 = background2;
                            z3 = z5;
                            j4 = background;
                            obj5 = obj9;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            j4 = background;
                            obj5 = obj4;
                            swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                            j3 = background2;
                            z3 = z;
                        }
                        obj6 = obj3;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                                    invoke((Composer) obj11, ((Number) obj12).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i15) {
                                    SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i3 & 38347923) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr3 = new ProvidedValue[2];
                        providedValueArr3[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr3[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z6 = z2;
                        final Object obj11 = obj4;
                        final Modifier modifier6 = modifier2;
                        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState5 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj12 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr3, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj13, Object obj14) {
                                invoke((Composer) obj13, ((Number) obj14).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier6, swipeToDismissBoxState5, obj12, obj11, z6, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z6;
                        j4 = background;
                        obj5 = obj11;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr4 = new ProvidedValue[2];
                        providedValueArr4[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr4[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z7 = z2;
                        final Object obj13 = obj4;
                        final Modifier modifier7 = modifier2;
                        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState6 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj14 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr4, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                                invoke((Composer) obj15, ((Number) obj16).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier7, swipeToDismissBoxState6, obj14, obj13, z7, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z7;
                        j4 = background;
                        obj5 = obj13;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                                invoke((Composer) obj15, ((Number) obj16).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i2 & 256) != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 38347923) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr5 = new ProvidedValue[2];
                        providedValueArr5[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr5[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z8 = z2;
                        final Object obj15 = obj4;
                        final Modifier modifier8 = modifier2;
                        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState7 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj16 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr5, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj17, Object obj18) {
                                invoke((Composer) obj17, ((Number) obj18).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier8, swipeToDismissBoxState7, obj16, obj15, z8, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z8;
                        j4 = background;
                        obj5 = obj15;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr6 = new ProvidedValue[2];
                        providedValueArr6[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr6[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z9 = z2;
                        final Object obj17 = obj4;
                        final Modifier modifier9 = modifier2;
                        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState8 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj18 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr6, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj110) {
                                invoke((Composer) obj19, ((Number) obj110).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier9, swipeToDismissBoxState8, obj18, obj17, z9, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z9;
                        j4 = background;
                        obj5 = obj17;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj110) {
                                invoke((Composer) obj19, ((Number) obj110).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr7 = new ProvidedValue[2];
                    providedValueArr7[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr7[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z10 = z2;
                    final Object obj19 = obj4;
                    final Modifier modifier10 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState9 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj110 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr7, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111, Object obj112) {
                            invoke((Composer) obj111, ((Number) obj112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier10, swipeToDismissBoxState9, obj110, obj19, z10, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z10;
                    j4 = background;
                    obj5 = obj19;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr8 = new ProvidedValue[2];
                    providedValueArr8[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr8[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z11 = z2;
                    final Object obj111 = obj4;
                    final Modifier modifier11 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState10 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj112 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr8, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj113, Object obj114) {
                            invoke((Composer) obj113, ((Number) obj114).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier11, swipeToDismissBoxState10, obj112, obj111, z11, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z11;
                    j4 = background;
                    obj5 = obj111;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj113, Object obj114) {
                            invoke((Composer) obj113, ((Number) obj114).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            obj3 = obj;
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                obj4 = obj2;
            } else {
                obj4 = obj2;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(obj4)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i9 = 8388608;
                    } else {
                        i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 38347923) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr9 = new ProvidedValue[2];
                        providedValueArr9[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr9[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z12 = z2;
                        final Object obj113 = obj4;
                        final Modifier modifier12 = modifier2;
                        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState11 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj114 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr9, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj115, Object obj116) {
                                invoke((Composer) obj115, ((Number) obj116).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier12, swipeToDismissBoxState11, obj114, obj113, z12, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z12;
                        j4 = background;
                        obj5 = obj113;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr10 = new ProvidedValue[2];
                        providedValueArr10[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr10[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z13 = z2;
                        final Object obj115 = obj4;
                        final Modifier modifier13 = modifier2;
                        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState12 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj116 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr10, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj117, Object obj118) {
                                invoke((Composer) obj117, ((Number) obj118).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier13, swipeToDismissBoxState12, obj116, obj115, z13, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z13;
                        j4 = background;
                        obj5 = obj115;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj117, Object obj118) {
                                invoke((Composer) obj117, ((Number) obj118).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr11 = new ProvidedValue[2];
                    providedValueArr11[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr11[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z14 = z2;
                    final Object obj117 = obj4;
                    final Modifier modifier14 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState13 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj118 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr11, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj119, Object obj1110) {
                            invoke((Composer) obj119, ((Number) obj1110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier14, swipeToDismissBoxState13, obj118, obj117, z14, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z14;
                    j4 = background;
                    obj5 = obj117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr12 = new ProvidedValue[2];
                    providedValueArr12[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr12[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z15 = z2;
                    final Object obj119 = obj4;
                    final Modifier modifier15 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState14 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj1110 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr12, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1111, Object obj1112) {
                            invoke((Composer) obj1111, ((Number) obj1112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier15, swipeToDismissBoxState14, obj1110, obj119, z15, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z15;
                    j4 = background;
                    obj5 = obj119;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1111, Object obj1112) {
                            invoke((Composer) obj1111, ((Number) obj1112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i2 & 256) != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                }
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr13 = new ProvidedValue[2];
                    providedValueArr13[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr13[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z16 = z2;
                    final Object obj1111 = obj4;
                    final Modifier modifier16 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState15 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj1112 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr13, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1113, Object obj1114) {
                            invoke((Composer) obj1113, ((Number) obj1114).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier16, swipeToDismissBoxState15, obj1112, obj1111, z16, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z16;
                    j4 = background;
                    obj5 = obj1111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr14 = new ProvidedValue[2];
                    providedValueArr14[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr14[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z17 = z2;
                    final Object obj1113 = obj4;
                    final Modifier modifier17 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState16 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj1114 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr14, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1115, Object obj1116) {
                            invoke((Composer) obj1115, ((Number) obj1116).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier17, swipeToDismissBoxState16, obj1114, obj1113, z17, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z17;
                    j4 = background;
                    obj5 = obj1113;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1115, Object obj1116) {
                            invoke((Composer) obj1115, ((Number) obj1116).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr15 = new ProvidedValue[2];
                providedValueArr15[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr15[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z18 = z2;
                final Object obj1115 = obj4;
                final Modifier modifier18 = modifier2;
                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState17 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1116 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr15, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1117, Object obj1118) {
                        invoke((Composer) obj1117, ((Number) obj1118).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier18, swipeToDismissBoxState17, obj1116, obj1115, z18, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z18;
                j4 = background;
                obj5 = obj1115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr16 = new ProvidedValue[2];
                providedValueArr16[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr16[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z19 = z2;
                final Object obj1117 = obj4;
                final Modifier modifier19 = modifier2;
                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState18 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1118 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr16, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1119, Object obj11110) {
                        invoke((Composer) obj1119, ((Number) obj11110).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier19, swipeToDismissBoxState18, obj1118, obj1117, z19, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z19;
                j4 = background;
                obj5 = obj1117;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1119, Object obj11110) {
                        invoke((Composer) obj1119, ((Number) obj11110).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
                if (composerStartRestartGroup.changed(swipeToDismissBoxStateRememberSwipeToDismissBoxState)) {
                }
                i3 |= i13;
            } else {
                swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
            }
            i3 |= i13;
        } else {
            swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                background = j;
                if (composerStartRestartGroup.changed(background)) {
                    i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i11;
            } else {
                background = j;
            }
            i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i11;
        } else {
            background = j;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                background2 = j2;
                if (composerStartRestartGroup.changed(background2)) {
                }
                i3 |= i14;
            } else {
                background2 = j2;
            }
            i3 |= i14;
        } else {
            background2 = j2;
        }
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                obj3 = obj;
                if (composerStartRestartGroup.changedInstance(obj3)) {
                    i5 = 131072;
                } else {
                    i5 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i5;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                obj4 = obj2;
            } else {
                obj4 = obj2;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(obj4)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i9 = 8388608;
                    } else {
                        i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 38347923) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr17 = new ProvidedValue[2];
                        providedValueArr17[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr17[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z110 = z2;
                        final Object obj1119 = obj4;
                        final Modifier modifier110 = modifier2;
                        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState19 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj11110 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr17, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11111, Object obj11112) {
                                invoke((Composer) obj11111, ((Number) obj11112).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier110, swipeToDismissBoxState19, obj11110, obj1119, z110, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z110;
                        j4 = background;
                        obj5 = obj1119;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr18 = new ProvidedValue[2];
                        providedValueArr18[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr18[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z111 = z2;
                        final Object obj11111 = obj4;
                        final Modifier modifier111 = modifier2;
                        final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState110 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj11112 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr18, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11113, Object obj11114) {
                                invoke((Composer) obj11113, ((Number) obj11114).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier111, swipeToDismissBoxState110, obj11112, obj11111, z111, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z111;
                        j4 = background;
                        obj5 = obj11111;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11113, Object obj11114) {
                                invoke((Composer) obj11113, ((Number) obj11114).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr19 = new ProvidedValue[2];
                    providedValueArr19[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr19[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z112 = z2;
                    final Object obj11113 = obj4;
                    final Modifier modifier112 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState111 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj11114 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr19, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj11115, Object obj11116) {
                            invoke((Composer) obj11115, ((Number) obj11116).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier112, swipeToDismissBoxState111, obj11114, obj11113, z112, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z112;
                    j4 = background;
                    obj5 = obj11113;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr110 = new ProvidedValue[2];
                    providedValueArr110[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr110[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z113 = z2;
                    final Object obj11115 = obj4;
                    final Modifier modifier113 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState112 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj11116 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr110, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj11117, Object obj11118) {
                            invoke((Composer) obj11117, ((Number) obj11118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier113, swipeToDismissBoxState112, obj11116, obj11115, z113, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z113;
                    j4 = background;
                    obj5 = obj11115;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj11117, Object obj11118) {
                            invoke((Composer) obj11117, ((Number) obj11118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i2 & 256) != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                }
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr111 = new ProvidedValue[2];
                    providedValueArr111[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr111[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z114 = z2;
                    final Object obj11117 = obj4;
                    final Modifier modifier114 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState113 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj11118 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr111, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj11119, Object obj111110) {
                            invoke((Composer) obj11119, ((Number) obj111110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier114, swipeToDismissBoxState113, obj11118, obj11117, z114, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z114;
                    j4 = background;
                    obj5 = obj11117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr112 = new ProvidedValue[2];
                    providedValueArr112[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr112[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z115 = z2;
                    final Object obj11119 = obj4;
                    final Modifier modifier115 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState114 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj111110 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr112, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111111, Object obj111112) {
                            invoke((Composer) obj111111, ((Number) obj111112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier115, swipeToDismissBoxState114, obj111110, obj11119, z115, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z115;
                    j4 = background;
                    obj5 = obj11119;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111111, Object obj111112) {
                            invoke((Composer) obj111111, ((Number) obj111112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr113 = new ProvidedValue[2];
                providedValueArr113[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr113[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z116 = z2;
                final Object obj111111 = obj4;
                final Modifier modifier116 = modifier2;
                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState115 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj111112 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr113, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj111113, Object obj111114) {
                        invoke((Composer) obj111113, ((Number) obj111114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier116, swipeToDismissBoxState115, obj111112, obj111111, z116, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z116;
                j4 = background;
                obj5 = obj111111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr114 = new ProvidedValue[2];
                providedValueArr114[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr114[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z117 = z2;
                final Object obj111113 = obj4;
                final Modifier modifier117 = modifier2;
                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState116 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj111114 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr114, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj111115, Object obj111116) {
                        invoke((Composer) obj111115, ((Number) obj111116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier117, swipeToDismissBoxState116, obj111114, obj111113, z117, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z117;
                j4 = background;
                obj5 = obj111113;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj111115, Object obj111116) {
                        invoke((Composer) obj111115, ((Number) obj111116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        obj3 = obj;
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            obj4 = obj2;
        } else {
            obj4 = obj2;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(obj4)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i9 = 8388608;
                } else {
                    i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                }
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr115 = new ProvidedValue[2];
                    providedValueArr115[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr115[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z118 = z2;
                    final Object obj111115 = obj4;
                    final Modifier modifier118 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState117 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj111116 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr115, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111117, Object obj111118) {
                            invoke((Composer) obj111117, ((Number) obj111118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier118, swipeToDismissBoxState117, obj111116, obj111115, z118, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z118;
                    j4 = background;
                    obj5 = obj111115;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr116 = new ProvidedValue[2];
                    providedValueArr116[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr116[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z119 = z2;
                    final Object obj111117 = obj4;
                    final Modifier modifier119 = modifier2;
                    final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState118 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj111118 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr116, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111119, Object obj1111110) {
                            invoke((Composer) obj111119, ((Number) obj1111110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier119, swipeToDismissBoxState118, obj111118, obj111117, z119, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z119;
                    j4 = background;
                    obj5 = obj111117;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111119, Object obj1111110) {
                            invoke((Composer) obj111119, ((Number) obj1111110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr117 = new ProvidedValue[2];
                providedValueArr117[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr117[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z1110 = z2;
                final Object obj111119 = obj4;
                final Modifier modifier1110 = modifier2;
                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState119 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1111110 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr117, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111111, Object obj1111112) {
                        invoke((Composer) obj1111111, ((Number) obj1111112).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1110, swipeToDismissBoxState119, obj1111110, obj111119, z1110, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z1110;
                j4 = background;
                obj5 = obj111119;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr118 = new ProvidedValue[2];
                providedValueArr118[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr118[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z1111 = z2;
                final Object obj1111111 = obj4;
                final Modifier modifier1111 = modifier2;
                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState1110 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1111112 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr118, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111113, Object obj1111114) {
                        invoke((Composer) obj1111113, ((Number) obj1111114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1111, swipeToDismissBoxState1110, obj1111112, obj1111111, z1111, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z1111;
                j4 = background;
                obj5 = obj1111111;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111113, Object obj1111114) {
                        invoke((Composer) obj1111113, ((Number) obj1111114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i2 & 256) != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i3 |= i10;
            }
            if ((i3 & 38347923) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr119 = new ProvidedValue[2];
                providedValueArr119[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr119[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z1112 = z2;
                final Object obj1111113 = obj4;
                final Modifier modifier1112 = modifier2;
                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState1111 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1111114 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr119, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111115, Object obj1111116) {
                        invoke((Composer) obj1111115, ((Number) obj1111116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1112, swipeToDismissBoxState1111, obj1111114, obj1111113, z1112, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z1112;
                j4 = background;
                obj5 = obj1111113;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr1110 = new ProvidedValue[2];
                providedValueArr1110[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr1110[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z1113 = z2;
                final Object obj1111115 = obj4;
                final Modifier modifier1113 = modifier2;
                final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState1112 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1111116 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr1110, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111117, Object obj1111118) {
                        invoke((Composer) obj1111117, ((Number) obj1111118).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1113, swipeToDismissBoxState1112, obj1111116, obj1111115, z1113, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z1113;
                j4 = background;
                obj5 = obj1111115;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111117, Object obj1111118) {
                        invoke((Composer) obj1111117, ((Number) obj1111118).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i3 & 38347923) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                c = 1;
                ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
            } else {
                c = 1;
            }
            ProvidedValue[] providedValueArr1111 = new ProvidedValue[2];
            providedValueArr1111[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
            providedValueArr1111[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
            final boolean z1114 = z2;
            final Object obj1111117 = obj4;
            final Modifier modifier1114 = modifier2;
            final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState1113 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
            final Object obj1111118 = obj3;
            CompositionLocalKt.CompositionLocalProvider(providedValueArr1111, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj1111119, Object obj11111110) {
                    invoke((Composer) obj1111119, ((Number) obj11111110).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                        }
                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1114, swipeToDismissBoxState1113, obj1111118, obj1111117, z1114, function4, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
            j3 = background2;
            z3 = z1114;
            j4 = background;
            obj5 = obj1111117;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = BasicSwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                c = 1;
                ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:211)");
            } else {
                c = 1;
            }
            ProvidedValue[] providedValueArr1112 = new ProvidedValue[2];
            providedValueArr1112[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
            providedValueArr1112[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
            final boolean z1115 = z2;
            final Object obj1111119 = obj4;
            final Modifier modifier1115 = modifier2;
            final androidx.wear.compose.foundation.SwipeToDismissBoxState swipeToDismissBoxState1114 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
            final Object obj11111110 = obj3;
            CompositionLocalKt.CompositionLocalProvider(providedValueArr1112, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj11111111, Object obj11111112) {
                    invoke((Composer) obj11111111, ((Number) obj11111112).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C216@10897L288:SwipeToDismissBox.kt#gj9v0t");
                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:216)");
                        }
                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1115, swipeToDismissBoxState1114, obj11111110, obj1111119, z1115, function4, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
            j3 = background2;
            z3 = z1115;
            j4 = background;
            obj5 = obj1111119;
        }
        obj6 = obj3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj11111111, Object obj11111112) {
                    invoke((Composer) obj11111111, ((Number) obj11111112).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    SwipeToDismissBoxKt.m807SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, (Function4<? super BoxScope, ? super Boolean, ? super Composer, ? super Integer, Unit>) function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0124  */
    /* JADX WARN: Code duplicated, block: B:107:0x0138  */
    /* JADX WARN: Code duplicated, block: B:109:0x0142  */
    /* JADX WARN: Code duplicated, block: B:121:0x015e A[PHI: r3 r4 r6 r7 r8 r10 r15
  0x015e: PHI (r3v9 java.lang.Object) = (r3v2 java.lang.Object), (r3v1 java.lang.Object), (r3v1 java.lang.Object) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r4v34 int) = (r4v22 int), (r4v36 int), (r4v37 int) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r6v7 androidx.compose.ui.Modifier) = (r6v3 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r7v11 androidx.wear.compose.material.SwipeToDismissBoxState) = 
  (r7v7 androidx.wear.compose.material.SwipeToDismissBoxState)
  (r7v6 androidx.wear.compose.material.SwipeToDismissBoxState)
  (r7v6 androidx.wear.compose.material.SwipeToDismissBoxState)
 binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r8v6 long) = (r8v3 long), (r8v2 long), (r8v2 long) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r10v7 long) = (r10v3 long), (r10v2 long), (r10v2 long) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r15v7 java.lang.Object) = (r15v4 java.lang.Object), (r15v3 java.lang.Object), (r15v3 java.lang.Object) binds: [B:137:0x01a2, B:119:0x015a, B:120:0x015c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:122:0x0161 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x0163  */
    /* JADX WARN: Code duplicated, block: B:126:0x016c  */
    /* JADX WARN: Code duplicated, block: B:129:0x017b  */
    /* JADX WARN: Code duplicated, block: B:132:0x018b  */
    /* JADX WARN: Code duplicated, block: B:134:0x019a  */
    /* JADX WARN: Code duplicated, block: B:136:0x019f  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:145:0x0210  */
    /* JADX WARN: Code duplicated, block: B:149:0x0222  */
    /* JADX WARN: Code duplicated, block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:92:0x0104  */
    /* JADX WARN: Code duplicated, block: B:94:0x0108  */
    /* JADX WARN: Code duplicated, block: B:96:0x0110  */
    /* JADX WARN: Code duplicated, block: B:97:0x0113  */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is provided for backwards compatibility. A newer overload is available that uses androidx.wear.compose.foundation.SwipeToDismissBoxState.", replaceWith = @ReplaceWith(expression = "SwipeToDismissBox(onDismiss, modifier, state, backgroundScrimColor, contentScrimColor, backgroundKey,contentKey, hasBackground, content)", imports = {}))
    /* JADX INFO: renamed from: SwipeToDismissBox-LHOAhiI, reason: not valid java name */
    public static final /* synthetic */ void m808SwipeToDismissBoxLHOAhiI(final Function0 function0, Modifier modifier, SwipeToDismissBoxState swipeToDismissBoxState, long j, long j2, Object obj, Object obj2, boolean z, final Function4 function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState;
        long background;
        long background2;
        int i4;
        Object obj3;
        int i5;
        int i6;
        Object obj4;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        char c;
        final Modifier modifier3;
        final SwipeToDismissBoxState swipeToDismissBoxState2;
        final long j3;
        final boolean z3;
        final long j4;
        final Object obj5;
        final Object obj6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1794054631);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeToDismissBox)P(7,6,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color!1,3,5)278@13937L32,279@14019L6,280@14083L6,289@14500L353,286@14317L536:SwipeToDismissBox.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
                    int i13 = composerStartRestartGroup.changed(swipeToDismissBoxStateRememberSwipeToDismissBoxState) ? 256 : 128;
                    i3 |= i13;
                } else {
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
                }
                i3 |= i13;
            } else {
                swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    background = j;
                    if (composerStartRestartGroup.changed(background)) {
                        i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i11;
                } else {
                    background = j;
                }
                i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i11;
            } else {
                background = j;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    background2 = j2;
                    int i14 = composerStartRestartGroup.changed(background2) ? 16384 : 8192;
                    i3 |= i14;
                } else {
                    background2 = j2;
                }
                i3 |= i14;
            } else {
                background2 = j2;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    obj3 = obj;
                    if (composerStartRestartGroup.changedInstance(obj3)) {
                        i5 = 131072;
                    } else {
                        i5 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    obj4 = obj2;
                } else {
                    obj4 = obj2;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(obj4)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i9 = 8388608;
                        } else {
                            i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i10 = 67108864;
                            } else {
                                i10 = 33554432;
                            }
                            i3 |= i10;
                        }
                        if ((i3 & 38347923) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = (Modifier) Modifier.Companion;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                                }
                                if ((i2 & 8) != 0) {
                                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                    i3 &= -57345;
                                }
                                if (i4 != 0) {
                                    obj3 = SwipeToDismissKeys.Background;
                                }
                                if (i6 != 0) {
                                    obj4 = SwipeToDismissKeys.Content;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    c = 1;
                                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                                } else {
                                    c = 1;
                                }
                                ProvidedValue[] providedValueArr = new ProvidedValue[2];
                                providedValueArr[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                                providedValueArr[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                                final boolean z4 = z2;
                                final Object obj7 = obj4;
                                final Modifier modifier4 = modifier2;
                                final SwipeToDismissBoxState swipeToDismissBoxState3 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                final Object obj8 = obj3;
                                CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj9, Object obj10) {
                                        invoke((Composer) obj9, ((Number) obj10).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i15) {
                                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                            }
                                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier4, swipeToDismissBoxState3.getFoundationState(), obj8, obj7, z4, function4, composer2, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                                j3 = background2;
                                z3 = z4;
                                j4 = background;
                                obj5 = obj7;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                            }
                            z2 = z;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                c = 1;
                                ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                            } else {
                                c = 1;
                            }
                            ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                            providedValueArr2[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                            providedValueArr2[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                            final boolean z5 = z2;
                            final Object obj9 = obj4;
                            final Modifier modifier5 = modifier2;
                            final SwipeToDismissBoxState swipeToDismissBoxState4 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                            final Object obj10 = obj3;
                            CompositionLocalKt.CompositionLocalProvider(providedValueArr2, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                                    invoke((Composer) obj11, ((Number) obj12).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i15) {
                                    ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                        }
                                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier5, swipeToDismissBoxState4.getFoundationState(), obj10, obj9, z5, function4, composer2, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                            j3 = background2;
                            z3 = z5;
                            j4 = background;
                            obj5 = obj9;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            j4 = background;
                            obj5 = obj4;
                            swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                            j3 = background2;
                            z3 = z;
                        }
                        obj6 = obj3;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                                    invoke((Composer) obj11, ((Number) obj12).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i15) {
                                    SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i3 & 38347923) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr3 = new ProvidedValue[2];
                        providedValueArr3[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr3[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z6 = z2;
                        final Object obj11 = obj4;
                        final Modifier modifier6 = modifier2;
                        final SwipeToDismissBoxState swipeToDismissBoxState5 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj12 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr3, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj13, Object obj14) {
                                invoke((Composer) obj13, ((Number) obj14).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier6, swipeToDismissBoxState5.getFoundationState(), obj12, obj11, z6, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z6;
                        j4 = background;
                        obj5 = obj11;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr4 = new ProvidedValue[2];
                        providedValueArr4[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr4[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z7 = z2;
                        final Object obj13 = obj4;
                        final Modifier modifier7 = modifier2;
                        final SwipeToDismissBoxState swipeToDismissBoxState6 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj14 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr4, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                                invoke((Composer) obj15, ((Number) obj16).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier7, swipeToDismissBoxState6.getFoundationState(), obj14, obj13, z7, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z7;
                        j4 = background;
                        obj5 = obj13;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                                invoke((Composer) obj15, ((Number) obj16).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i2 & 256) != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 38347923) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr5 = new ProvidedValue[2];
                        providedValueArr5[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr5[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z8 = z2;
                        final Object obj15 = obj4;
                        final Modifier modifier8 = modifier2;
                        final SwipeToDismissBoxState swipeToDismissBoxState7 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj16 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr5, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj17, Object obj18) {
                                invoke((Composer) obj17, ((Number) obj18).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier8, swipeToDismissBoxState7.getFoundationState(), obj16, obj15, z8, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z8;
                        j4 = background;
                        obj5 = obj15;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr6 = new ProvidedValue[2];
                        providedValueArr6[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr6[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z9 = z2;
                        final Object obj17 = obj4;
                        final Modifier modifier9 = modifier2;
                        final SwipeToDismissBoxState swipeToDismissBoxState8 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj18 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr6, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj110) {
                                invoke((Composer) obj19, ((Number) obj110).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier9, swipeToDismissBoxState8.getFoundationState(), obj18, obj17, z9, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z9;
                        j4 = background;
                        obj5 = obj17;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj110) {
                                invoke((Composer) obj19, ((Number) obj110).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr7 = new ProvidedValue[2];
                    providedValueArr7[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr7[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z10 = z2;
                    final Object obj19 = obj4;
                    final Modifier modifier10 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState9 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj110 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr7, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111, Object obj112) {
                            invoke((Composer) obj111, ((Number) obj112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier10, swipeToDismissBoxState9.getFoundationState(), obj110, obj19, z10, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z10;
                    j4 = background;
                    obj5 = obj19;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr8 = new ProvidedValue[2];
                    providedValueArr8[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr8[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z11 = z2;
                    final Object obj111 = obj4;
                    final Modifier modifier11 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState10 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj112 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr8, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj113, Object obj114) {
                            invoke((Composer) obj113, ((Number) obj114).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier11, swipeToDismissBoxState10.getFoundationState(), obj112, obj111, z11, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z11;
                    j4 = background;
                    obj5 = obj111;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj113, Object obj114) {
                            invoke((Composer) obj113, ((Number) obj114).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            obj3 = obj;
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                obj4 = obj2;
            } else {
                obj4 = obj2;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(obj4)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i9 = 8388608;
                    } else {
                        i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 38347923) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr9 = new ProvidedValue[2];
                        providedValueArr9[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr9[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z12 = z2;
                        final Object obj113 = obj4;
                        final Modifier modifier12 = modifier2;
                        final SwipeToDismissBoxState swipeToDismissBoxState11 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj114 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr9, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj115, Object obj116) {
                                invoke((Composer) obj115, ((Number) obj116).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier12, swipeToDismissBoxState11.getFoundationState(), obj114, obj113, z12, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z12;
                        j4 = background;
                        obj5 = obj113;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr10 = new ProvidedValue[2];
                        providedValueArr10[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr10[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z13 = z2;
                        final Object obj115 = obj4;
                        final Modifier modifier13 = modifier2;
                        final SwipeToDismissBoxState swipeToDismissBoxState12 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj116 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr10, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj117, Object obj118) {
                                invoke((Composer) obj117, ((Number) obj118).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier13, swipeToDismissBoxState12.getFoundationState(), obj116, obj115, z13, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z13;
                        j4 = background;
                        obj5 = obj115;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj117, Object obj118) {
                                invoke((Composer) obj117, ((Number) obj118).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr11 = new ProvidedValue[2];
                    providedValueArr11[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr11[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z14 = z2;
                    final Object obj117 = obj4;
                    final Modifier modifier14 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState13 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj118 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr11, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj119, Object obj1110) {
                            invoke((Composer) obj119, ((Number) obj1110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier14, swipeToDismissBoxState13.getFoundationState(), obj118, obj117, z14, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z14;
                    j4 = background;
                    obj5 = obj117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr12 = new ProvidedValue[2];
                    providedValueArr12[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr12[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z15 = z2;
                    final Object obj119 = obj4;
                    final Modifier modifier15 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState14 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj1110 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr12, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1111, Object obj1112) {
                            invoke((Composer) obj1111, ((Number) obj1112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier15, swipeToDismissBoxState14.getFoundationState(), obj1110, obj119, z15, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z15;
                    j4 = background;
                    obj5 = obj119;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1111, Object obj1112) {
                            invoke((Composer) obj1111, ((Number) obj1112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i2 & 256) != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                }
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr13 = new ProvidedValue[2];
                    providedValueArr13[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr13[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z16 = z2;
                    final Object obj1111 = obj4;
                    final Modifier modifier16 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState15 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj1112 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr13, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1113, Object obj1114) {
                            invoke((Composer) obj1113, ((Number) obj1114).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier16, swipeToDismissBoxState15.getFoundationState(), obj1112, obj1111, z16, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z16;
                    j4 = background;
                    obj5 = obj1111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr14 = new ProvidedValue[2];
                    providedValueArr14[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr14[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z17 = z2;
                    final Object obj1113 = obj4;
                    final Modifier modifier17 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState16 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj1114 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr14, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1115, Object obj1116) {
                            invoke((Composer) obj1115, ((Number) obj1116).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier17, swipeToDismissBoxState16.getFoundationState(), obj1114, obj1113, z17, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z17;
                    j4 = background;
                    obj5 = obj1113;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj1115, Object obj1116) {
                            invoke((Composer) obj1115, ((Number) obj1116).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr15 = new ProvidedValue[2];
                providedValueArr15[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr15[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z18 = z2;
                final Object obj1115 = obj4;
                final Modifier modifier18 = modifier2;
                final SwipeToDismissBoxState swipeToDismissBoxState17 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1116 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr15, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1117, Object obj1118) {
                        invoke((Composer) obj1117, ((Number) obj1118).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier18, swipeToDismissBoxState17.getFoundationState(), obj1116, obj1115, z18, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z18;
                j4 = background;
                obj5 = obj1115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr16 = new ProvidedValue[2];
                providedValueArr16[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr16[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z19 = z2;
                final Object obj1117 = obj4;
                final Modifier modifier19 = modifier2;
                final SwipeToDismissBoxState swipeToDismissBoxState18 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1118 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr16, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1119, Object obj11110) {
                        invoke((Composer) obj1119, ((Number) obj11110).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier19, swipeToDismissBoxState18.getFoundationState(), obj1118, obj1117, z19, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z19;
                j4 = background;
                obj5 = obj1117;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1119, Object obj11110) {
                        invoke((Composer) obj1119, ((Number) obj11110).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
                if (composerStartRestartGroup.changed(swipeToDismissBoxStateRememberSwipeToDismissBoxState)) {
                }
                i3 |= i13;
            } else {
                swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
            }
            i3 |= i13;
        } else {
            swipeToDismissBoxStateRememberSwipeToDismissBoxState = swipeToDismissBoxState;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                background = j;
                if (composerStartRestartGroup.changed(background)) {
                    i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i11;
            } else {
                background = j;
            }
            i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i11;
        } else {
            background = j;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                background2 = j2;
                if (composerStartRestartGroup.changed(background2)) {
                }
                i3 |= i14;
            } else {
                background2 = j2;
            }
            i3 |= i14;
        } else {
            background2 = j2;
        }
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                obj3 = obj;
                if (composerStartRestartGroup.changedInstance(obj3)) {
                    i5 = 131072;
                } else {
                    i5 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i5;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                obj4 = obj2;
            } else {
                obj4 = obj2;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(obj4)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i9 = 8388608;
                    } else {
                        i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 38347923) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr17 = new ProvidedValue[2];
                        providedValueArr17[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr17[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z110 = z2;
                        final Object obj1119 = obj4;
                        final Modifier modifier110 = modifier2;
                        final SwipeToDismissBoxState swipeToDismissBoxState19 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj11110 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr17, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11111, Object obj11112) {
                                invoke((Composer) obj11111, ((Number) obj11112).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier110, swipeToDismissBoxState19.getFoundationState(), obj11110, obj1119, z110, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z110;
                        j4 = background;
                        obj5 = obj1119;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if ((i2 & 8) != 0) {
                                background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                obj3 = SwipeToDismissKeys.Background;
                            }
                            if (i6 != 0) {
                                obj4 = SwipeToDismissKeys.Content;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            c = 1;
                            ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                        } else {
                            c = 1;
                        }
                        ProvidedValue[] providedValueArr18 = new ProvidedValue[2];
                        providedValueArr18[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                        providedValueArr18[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                        final boolean z111 = z2;
                        final Object obj11111 = obj4;
                        final Modifier modifier111 = modifier2;
                        final SwipeToDismissBoxState swipeToDismissBoxState110 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        final Object obj11112 = obj3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr18, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11113, Object obj11114) {
                                invoke((Composer) obj11113, ((Number) obj11114).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                    }
                                    BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier111, swipeToDismissBoxState110.getFoundationState(), obj11112, obj11111, z111, function4, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                        j3 = background2;
                        z3 = z111;
                        j4 = background;
                        obj5 = obj11111;
                    }
                    obj6 = obj3;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj11113, Object obj11114) {
                                invoke((Composer) obj11113, ((Number) obj11114).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr19 = new ProvidedValue[2];
                    providedValueArr19[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr19[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z112 = z2;
                    final Object obj11113 = obj4;
                    final Modifier modifier112 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState111 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj11114 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr19, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj11115, Object obj11116) {
                            invoke((Composer) obj11115, ((Number) obj11116).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier112, swipeToDismissBoxState111.getFoundationState(), obj11114, obj11113, z112, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z112;
                    j4 = background;
                    obj5 = obj11113;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr110 = new ProvidedValue[2];
                    providedValueArr110[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr110[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z113 = z2;
                    final Object obj11115 = obj4;
                    final Modifier modifier113 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState112 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj11116 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr110, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj11117, Object obj11118) {
                            invoke((Composer) obj11117, ((Number) obj11118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier113, swipeToDismissBoxState112.getFoundationState(), obj11116, obj11115, z113, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z113;
                    j4 = background;
                    obj5 = obj11115;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj11117, Object obj11118) {
                            invoke((Composer) obj11117, ((Number) obj11118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i2 & 256) != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                }
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr111 = new ProvidedValue[2];
                    providedValueArr111[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr111[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z114 = z2;
                    final Object obj11117 = obj4;
                    final Modifier modifier114 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState113 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj11118 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr111, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj11119, Object obj111110) {
                            invoke((Composer) obj11119, ((Number) obj111110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier114, swipeToDismissBoxState113.getFoundationState(), obj11118, obj11117, z114, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z114;
                    j4 = background;
                    obj5 = obj11117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr112 = new ProvidedValue[2];
                    providedValueArr112[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr112[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z115 = z2;
                    final Object obj11119 = obj4;
                    final Modifier modifier115 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState114 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj111110 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr112, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111111, Object obj111112) {
                            invoke((Composer) obj111111, ((Number) obj111112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier115, swipeToDismissBoxState114.getFoundationState(), obj111110, obj11119, z115, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z115;
                    j4 = background;
                    obj5 = obj11119;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111111, Object obj111112) {
                            invoke((Composer) obj111111, ((Number) obj111112).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr113 = new ProvidedValue[2];
                providedValueArr113[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr113[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z116 = z2;
                final Object obj111111 = obj4;
                final Modifier modifier116 = modifier2;
                final SwipeToDismissBoxState swipeToDismissBoxState115 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj111112 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr113, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj111113, Object obj111114) {
                        invoke((Composer) obj111113, ((Number) obj111114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier116, swipeToDismissBoxState115.getFoundationState(), obj111112, obj111111, z116, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z116;
                j4 = background;
                obj5 = obj111111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr114 = new ProvidedValue[2];
                providedValueArr114[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr114[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z117 = z2;
                final Object obj111113 = obj4;
                final Modifier modifier117 = modifier2;
                final SwipeToDismissBoxState swipeToDismissBoxState116 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj111114 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr114, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj111115, Object obj111116) {
                        invoke((Composer) obj111115, ((Number) obj111116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier117, swipeToDismissBoxState116.getFoundationState(), obj111114, obj111113, z117, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z117;
                j4 = background;
                obj5 = obj111113;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj111115, Object obj111116) {
                        invoke((Composer) obj111115, ((Number) obj111116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        obj3 = obj;
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            obj4 = obj2;
        } else {
            obj4 = obj2;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(obj4)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i9 = 8388608;
                } else {
                    i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                }
                if ((i3 & 38347923) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr115 = new ProvidedValue[2];
                    providedValueArr115[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr115[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z118 = z2;
                    final Object obj111115 = obj4;
                    final Modifier modifier118 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState117 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj111116 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr115, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111117, Object obj111118) {
                            invoke((Composer) obj111117, ((Number) obj111118).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier118, swipeToDismissBoxState117.getFoundationState(), obj111116, obj111115, z118, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z118;
                    j4 = background;
                    obj5 = obj111115;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if ((i2 & 8) != 0) {
                            background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            obj3 = SwipeToDismissKeys.Background;
                        }
                        if (i6 != 0) {
                            obj4 = SwipeToDismissKeys.Content;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        c = 1;
                        ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                    } else {
                        c = 1;
                    }
                    ProvidedValue[] providedValueArr116 = new ProvidedValue[2];
                    providedValueArr116[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                    providedValueArr116[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                    final boolean z119 = z2;
                    final Object obj111117 = obj4;
                    final Modifier modifier119 = modifier2;
                    final SwipeToDismissBoxState swipeToDismissBoxState118 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    final Object obj111118 = obj3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr116, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111119, Object obj1111110) {
                            invoke((Composer) obj111119, ((Number) obj1111110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                                }
                                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier119, swipeToDismissBoxState118.getFoundationState(), obj111118, obj111117, z119, function4, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                    j3 = background2;
                    z3 = z119;
                    j4 = background;
                    obj5 = obj111117;
                }
                obj6 = obj3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj111119, Object obj1111110) {
                            invoke((Composer) obj111119, ((Number) obj1111110).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr117 = new ProvidedValue[2];
                providedValueArr117[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr117[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z1110 = z2;
                final Object obj111119 = obj4;
                final Modifier modifier1110 = modifier2;
                final SwipeToDismissBoxState swipeToDismissBoxState119 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1111110 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr117, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111111, Object obj1111112) {
                        invoke((Composer) obj1111111, ((Number) obj1111112).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1110, swipeToDismissBoxState119.getFoundationState(), obj1111110, obj111119, z1110, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z1110;
                j4 = background;
                obj5 = obj111119;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr118 = new ProvidedValue[2];
                providedValueArr118[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr118[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z1111 = z2;
                final Object obj1111111 = obj4;
                final Modifier modifier1111 = modifier2;
                final SwipeToDismissBoxState swipeToDismissBoxState1110 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1111112 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr118, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111113, Object obj1111114) {
                        invoke((Composer) obj1111113, ((Number) obj1111114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1111, swipeToDismissBoxState1110.getFoundationState(), obj1111112, obj1111111, z1111, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z1111;
                j4 = background;
                obj5 = obj1111111;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111113, Object obj1111114) {
                        invoke((Composer) obj1111113, ((Number) obj1111114).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i2 & 256) != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i3 |= i10;
            }
            if ((i3 & 38347923) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr119 = new ProvidedValue[2];
                providedValueArr119[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr119[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z1112 = z2;
                final Object obj1111113 = obj4;
                final Modifier modifier1112 = modifier2;
                final SwipeToDismissBoxState swipeToDismissBoxState1111 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1111114 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr119, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111115, Object obj1111116) {
                        invoke((Composer) obj1111115, ((Number) obj1111116).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1112, swipeToDismissBoxState1111.getFoundationState(), obj1111114, obj1111113, z1112, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z1112;
                j4 = background;
                obj5 = obj1111113;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if ((i2 & 8) != 0) {
                        background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        obj3 = SwipeToDismissKeys.Background;
                    }
                    if (i6 != 0) {
                        obj4 = SwipeToDismissKeys.Content;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    c = 1;
                    ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
                } else {
                    c = 1;
                }
                ProvidedValue[] providedValueArr1110 = new ProvidedValue[2];
                providedValueArr1110[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
                providedValueArr1110[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
                final boolean z1113 = z2;
                final Object obj1111115 = obj4;
                final Modifier modifier1113 = modifier2;
                final SwipeToDismissBoxState swipeToDismissBoxState1112 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                final Object obj1111116 = obj3;
                CompositionLocalKt.CompositionLocalProvider(providedValueArr1110, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111117, Object obj1111118) {
                        invoke((Composer) obj1111117, ((Number) obj1111118).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                            }
                            BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1113, swipeToDismissBoxState1112.getFoundationState(), obj1111116, obj1111115, z1113, function4, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
                j3 = background2;
                z3 = z1113;
                j4 = background;
                obj5 = obj1111115;
            }
            obj6 = obj3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj1111117, Object obj1111118) {
                        invoke((Composer) obj1111117, ((Number) obj1111118).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i3 & 38347923) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                c = 1;
                ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
            } else {
                c = 1;
            }
            ProvidedValue[] providedValueArr1111 = new ProvidedValue[2];
            providedValueArr1111[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
            providedValueArr1111[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
            final boolean z1114 = z2;
            final Object obj1111117 = obj4;
            final Modifier modifier1114 = modifier2;
            final SwipeToDismissBoxState swipeToDismissBoxState1113 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
            final Object obj1111118 = obj3;
            CompositionLocalKt.CompositionLocalProvider(providedValueArr1111, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj1111119, Object obj11111110) {
                    invoke((Composer) obj1111119, ((Number) obj11111110).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                        }
                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1114, swipeToDismissBoxState1113.getFoundationState(), obj1111118, obj1111117, z1114, function4, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
            j3 = background2;
            z3 = z1114;
            j4 = background;
            obj5 = obj1111117;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    swipeToDismissBoxStateRememberSwipeToDismissBoxState = rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
                }
                if ((i2 & 8) != 0) {
                    background = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    background2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground();
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    obj3 = SwipeToDismissKeys.Background;
                }
                if (i6 != 0) {
                    obj4 = SwipeToDismissKeys.Content;
                }
                if (i8 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                c = 1;
                ComposerKt.traceEventStart(1794054631, i3, -1, "androidx.wear.compose.material.SwipeToDismissBox (SwipeToDismissBox.kt:285)");
            } else {
                c = 1;
            }
            ProvidedValue[] providedValueArr1112 = new ProvidedValue[2];
            providedValueArr1112[0] = CompositionLocalsKt.getLocalSwipeToDismissBackgroundScrimColor().provides(Color.box-impl(background));
            providedValueArr1112[c] = CompositionLocalsKt.getLocalSwipeToDismissContentScrimColor().provides(Color.box-impl(background2));
            final boolean z1115 = z2;
            final Object obj1111119 = obj4;
            final Modifier modifier1115 = modifier2;
            final SwipeToDismissBoxState swipeToDismissBoxState1114 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
            final Object obj11111110 = obj3;
            CompositionLocalKt.CompositionLocalProvider(providedValueArr1112, ComposableLambdaKt.rememberComposableLambda(2083634855, c, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj11111111, Object obj11111112) {
                    invoke((Composer) obj11111111, ((Number) obj11111112).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C290@14543L304:SwipeToDismissBox.kt#gj9v0t");
                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2083634855, i15, -1, "androidx.wear.compose.material.SwipeToDismissBox.<anonymous> (SwipeToDismissBox.kt:290)");
                        }
                        BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox(function0, modifier1115, swipeToDismissBoxState1114.getFoundationState(), obj11111110, obj1111119, z1115, function4, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            swipeToDismissBoxState2 = swipeToDismissBoxStateRememberSwipeToDismissBoxState;
            j3 = background2;
            z3 = z1115;
            j4 = background;
            obj5 = obj1111119;
        }
        obj6 = obj3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt$SwipeToDismissBox$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj11111111, Object obj11111112) {
                    invoke((Composer) obj11111111, ((Number) obj11111112).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    SwipeToDismissBoxKt.m808SwipeToDismissBoxLHOAhiI(function0, modifier3, swipeToDismissBoxState2, j4, j3, obj6, obj5, z3, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Deprecated(message = "Please import rememberSwipeToDismissBoxState from androidx.wear.compose.foundation.", replaceWith = @ReplaceWith(expression = "androidx.wear.compose.foundation.rememberSwipeToDismissBoxState(", imports = {"animationSpec, confirmStateChange)"}))
    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(AnimationSpec<Float> animationSpec, Function1<? super SwipeToDismissValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -353693130, "C(rememberSwipeToDismissBoxState)384@18036L117:SwipeToDismissBox.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            animationSpec = (AnimationSpec) SWIPE_TO_DISMISS_BOX_ANIMATION_SPEC;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<SwipeToDismissValue, Boolean>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxKt.rememberSwipeToDismissBoxState.1
                public final Boolean invoke(SwipeToDismissValue swipeToDismissValue) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-353693130, i, -1, "androidx.wear.compose.material.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:383)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1590853762, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        boolean zChanged = ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32) | composer.changed(animationSpec);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SwipeToDismissBoxState(animationSpec, function1);
            composer.updateRememberedValue(objRememberedValue);
        }
        SwipeToDismissBoxState swipeToDismissBoxState = (SwipeToDismissBoxState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeToDismissBoxState;
    }

    /* JADX INFO: renamed from: edgeSwipeToDismiss-wH6b6FI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m812edgeSwipeToDismisswH6b6FI$default(Modifier modifier, SwipeToDismissBoxState swipeToDismissBoxState, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = SwipeToDismissBoxDefaults.INSTANCE.m806getEdgeWidthD9Ej5fM();
        }
        return m811edgeSwipeToDismisswH6b6FI(modifier, swipeToDismissBoxState, f);
    }

    @Deprecated(message = "SwipeToDismiss has been migrated to androidx.wear.compose.foundation. Please import Modifier.edgeSwipeToDismiss from androidx.wear.compose.foundation instead.", replaceWith = @ReplaceWith(expression = "androidx.wear.compose.foundation.edgeSwipeToDismiss(", imports = {"swipeToDismissBoxState, edgeWidth)"}))
    /* JADX INFO: renamed from: edgeSwipeToDismiss-wH6b6FI, reason: not valid java name */
    public static final Modifier m811edgeSwipeToDismisswH6b6FI(Modifier modifier, SwipeToDismissBoxState swipeToDismissBoxState, float f) {
        return BasicSwipeToDismissBoxKt.m241edgeSwipeToDismisswH6b6FI(modifier, swipeToDismissBoxState.getFoundationState(), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final androidx.wear.compose.foundation.SwipeToDismissValue convertToFoundationSwipeToDismissValue(SwipeToDismissValue swipeToDismissValue) throws NoWhenBranchMatchedException {
        int i = WhenMappings.$EnumSwitchMapping$0[swipeToDismissValue.ordinal()];
        if (i == 1) {
            return androidx.wear.compose.foundation.SwipeToDismissValue.Default;
        }
        if (i == 2) {
            return androidx.wear.compose.foundation.SwipeToDismissValue.Dismissed;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final SwipeToDismissValue convertFromFoundationSwipeToDismissValue(androidx.wear.compose.foundation.SwipeToDismissValue swipeToDismissValue) throws NoWhenBranchMatchedException {
        int i = WhenMappings.$EnumSwitchMapping$1[swipeToDismissValue.ordinal()];
        if (i == 1) {
            return SwipeToDismissValue.Default;
        }
        if (i == 2) {
            return SwipeToDismissValue.Dismissed;
        }
        throw new NoWhenBranchMatchedException();
    }
}
