package androidx.wear.compose.materialcore;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: compiled from: SelectionControls.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a\u0080\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2A\u0010\u0010\u001a=\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\u0002\b\u00172A\u0010\u0018\u001a=\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\u0002\b\u00172\u0006\u0010\u0014\u001a\u00020\r2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0082\u0002\u0010'\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2A\u0010)\u001a=\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\u0002\b\u00172A\u0010*\u001a=\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\u0002\b\u00172\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010,2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u0094\u0003\u00106\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2A\u00107\u001a=\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\u0002\b\u00172A\u00108\u001a=\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\u0002\b\u00172A\u00109\u001a=\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\u0002\b\u00172A\u0010:\u001a=\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\u0002\b\u00172\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020>2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a7\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010E\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\b0\u001eH\u0003¢\u0006\u0002\u0010H\u001aV\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u00162\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00160NH\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a\u0015\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\bH\u0007¢\u0006\u0002\u0010T\u001a>\u0010U\u001a\u00020\u000b*\u00020V2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bZ\u0010[\u001a6\u0010\\\u001a\u00020\u000b*\u00020V2\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a6\u0010_\u001a\u00020\u000b*\u00020V2\u0006\u0010`\u001a\u00020\u00162\u0006\u0010a\u001a\u00020\u00162\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\bd\u0010e\u001a6\u0010f\u001a\u00020\u000b*\u00020V2\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\bg\u0010^\u001a\u001e\u0010h\u001a\u00020\u000b*\u00020i2\u0006\u0010j\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001aX\u0010m\u001a\u00020\u000f*\u00020\u000f2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010,2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010n\u001a\u00020$2\u0006\u0010o\u001a\u00020\u00012\u0006\u0010p\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\bq\u0010r\u001a^\u0010s\u001a\u00020\u000f*\u00020\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010n\u001a\u00020$2\u0006\u0010o\u001a\u00020\u00012\u0006\u0010p\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\bt\u0010u\u001a\u001e\u0010v\u001a\u00020\u000b*\u00020i2\u0006\u0010j\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bw\u0010l\u001a\u001e\u0010x\u001a\u00020R*\u00020R2\u0006\u0010S\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\by\u0010z\u001a&\u0010x\u001a\u00020R*\u00020R2\u0006\u0010S\u001a\u00020\b2\u0006\u0010{\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\b|\u0010}\u001a\u0017\u0010~\u001a\u00020R*\u00020RH\u0002ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001\u001a\r\u0010\u0081\u0001\u001a\u00020\b*\u00020\bH\u0007\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0082\u0001"}, d2 = {"RADIO_CIRCLE_RADIUS", "Landroidx/compose/ui/unit/Dp;", "F", "RADIO_CIRCLE_STROKE", "RADIO_DOT_RADIUS", "SWITCH_TRACK_BORDER", "TICK_BASE_LENGTH", "TICK_ROTATION", "", "TICK_STICK_LENGTH", "Checkbox", "", "checked", "", "modifier", "Landroidx/compose/ui/Modifier;", "boxColor", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "enabled", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/runtime/Composable;", "checkmarkColor", "onCheckedChange", "Lkotlin/Function1;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "progressAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "drawBox", "Landroidx/wear/compose/materialcore/FunctionDrawBox;", "width", "height", "ripple", "Landroidx/compose/foundation/Indication;", "Checkbox-w41Enmo", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;ZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/animation/core/TweenSpec;Landroidx/wear/compose/materialcore/FunctionDrawBox;FFLandroidx/compose/foundation/Indication;Landroidx/compose/runtime/Composer;III)V", "RadioButton", "selected", "ringColor", "dotColor", "onClick", "Lkotlin/Function0;", "dotRadiusProgressDuration", "Landroidx/wear/compose/materialcore/FunctionDotRadiusProgressDuration;", "dotAlphaProgressDuration", "", "dotAlphaProgressDelay", "easing", "Landroidx/compose/animation/core/CubicBezierEasing;", "RadioButton-q3QzNKE", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/wear/compose/materialcore/FunctionDotRadiusProgressDuration;IILandroidx/compose/animation/core/CubicBezierEasing;FFLandroidx/compose/foundation/Indication;Landroidx/compose/runtime/Composer;II)V", "Switch", "trackFillColor", "trackStrokeColor", "thumbColor", "thumbIconColor", "trackWidth", "trackHeight", "drawThumb", "Landroidx/wear/compose/materialcore/FunctionDrawThumb;", "Switch-Z7GKWWo", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;FFLandroidx/wear/compose/materialcore/FunctionDrawThumb;Landroidx/compose/animation/core/TweenSpec;FFLandroidx/compose/foundation/Indication;Landroidx/compose/runtime/Composer;II)V", "animateProgress", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/wear/compose/materialcore/SelectionStage;", Constants.ScionAnalytics.PARAM_LABEL, "", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Landroidx/compose/animation/core/TweenSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateSelectionColor", "checkedColor", "uncheckedColor", "disabledCheckedColor", "disabledUncheckedColor", "Landroidx/compose/animation/core/AnimationSpec;", "animateSelectionColor-NghDbR4", "(ZZJJJJLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "directionVector", "Landroidx/compose/ui/geometry/Offset;", "angleRadians", "(F)J", "animateTick", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "tickColor", "tickProgress", "startXOffset", "animateTick-TN_IhPg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;ZZJFF)V", "drawTick", "drawTick-K7VD59E", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFZ)V", "drawTrack", "fillColor", "strokeColor", "trackWidthPx", "trackHeightPx", "drawTrack-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "eraseTick", "eraseTick-K7VD59E", "lineTo", "Landroidx/compose/ui/graphics/Path;", "offset", "lineTo-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "maybeSelectable", "indication", "canvasWidth", "canvasHeight", "maybeSelectable-AWlRVLg", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;FF)Landroidx/compose/ui/Modifier;", "maybeToggleable", "maybeToggleable-AWlRVLg", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;FF)Landroidx/compose/ui/Modifier;", "moveTo", "moveTo-Uv8p0NA", "rotate", "rotate-3MmeM6k", "(JF)J", "center", "rotate-YOhFQsI", "(JFJ)J", "rotate90", "rotate90-k-4lQ0M", "(J)J", "toRadians", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionControlsKt {
    private static final float TICK_ROTATION = 15.0f;
    private static final float TICK_BASE_LENGTH = Dp.constructor-impl(4);
    private static final float TICK_STICK_LENGTH = Dp.constructor-impl(8);
    private static final float SWITCH_TRACK_BORDER = Dp.constructor-impl(1);
    private static final float RADIO_CIRCLE_RADIUS = Dp.constructor-impl(9);
    private static final float RADIO_CIRCLE_STROKE = Dp.constructor-impl(2);
    private static final float RADIO_DOT_RADIUS = Dp.constructor-impl(5);

    /* JADX INFO: compiled from: SelectionControls.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SelectionStage.values().length];
            try {
                iArr[SelectionStage.Unchecked.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectionStage.Checked.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final float toRadians(float f) {
        return (f * 3.1415927f) / 180.0f;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:103:0x0125  */
    /* JADX WARN: Code duplicated, block: B:105:0x012b  */
    /* JADX WARN: Code duplicated, block: B:106:0x012e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0136  */
    /* JADX WARN: Code duplicated, block: B:110:0x0139  */
    /* JADX WARN: Code duplicated, block: B:112:0x013d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0143  */
    /* JADX WARN: Code duplicated, block: B:115:0x0145  */
    /* JADX WARN: Code duplicated, block: B:117:0x0149  */
    /* JADX WARN: Code duplicated, block: B:120:0x014f  */
    /* JADX WARN: Code duplicated, block: B:121:0x0152  */
    /* JADX WARN: Code duplicated, block: B:123:0x0156  */
    /* JADX WARN: Code duplicated, block: B:125:0x015e  */
    /* JADX WARN: Code duplicated, block: B:130:0x016f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x0185  */
    /* JADX WARN: Code duplicated, block: B:138:0x018a  */
    /* JADX WARN: Code duplicated, block: B:141:0x0192  */
    /* JADX WARN: Code duplicated, block: B:143:0x019c  */
    /* JADX WARN: Code duplicated, block: B:144:0x019f  */
    /* JADX WARN: Code duplicated, block: B:147:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:151:0x0239  */
    /* JADX WARN: Code duplicated, block: B:157:0x0248  */
    /* JADX WARN: Code duplicated, block: B:160:0x0261  */
    /* JADX WARN: Code duplicated, block: B:161:0x0263  */
    /* JADX WARN: Code duplicated, block: B:164:0x026a  */
    /* JADX WARN: Code duplicated, block: B:165:0x026c  */
    /* JADX WARN: Code duplicated, block: B:168:0x027e  */
    /* JADX WARN: Code duplicated, block: B:172:0x0289  */
    /* JADX WARN: Code duplicated, block: B:175:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:179:0x02be  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:89:0x0102  */
    /* JADX WARN: Code duplicated, block: B:91:0x0107  */
    /* JADX WARN: Code duplicated, block: B:92:0x010c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0112  */
    /* JADX WARN: Code duplicated, block: B:95:0x0115  */
    /* JADX WARN: Code duplicated, block: B:99:0x011c  */
    /* JADX INFO: renamed from: Checkbox-w41Enmo, reason: not valid java name */
    public static final void m916Checkboxw41Enmo(final boolean z, Modifier modifier, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function4, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function5, final boolean z2, final Function1<? super Boolean, Unit> function1, final MutableInteractionSource mutableInteractionSource, final TweenSpec<Float> tweenSpec, final FunctionDrawBox functionDrawBox, final float f, final float f2, final Indication indication, Composer composer, final int i, final int i2, final int i3) throws NoWhenBranchMatchedException {
        int i4;
        boolean z3;
        Function1<? super Boolean, Unit> function2;
        int i5;
        int i6;
        int i7;
        boolean zChangedInstance;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier modifier2;
        SelectionStage selectionStage;
        final State<Float> stateAnimateProgress;
        final boolean zIsLayoutDirectionRtl;
        float f3;
        final float f4;
        final State state;
        final State state2;
        Modifier modifierM927maybeToggleableAWlRVLg;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean zChanged;
        Object objRememberedValue;
        Modifier modifier3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1104848843);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)P(1,7!2,4,8,6,9!1,11:c#ui.unit.Dp,5:c#ui.unit.Dp)97@4404L59,98@4483L113,101@4613L22,106@4860L26,107@4917L32,126@5462L458,111@5074L852:SelectionControls.kt#f7tims");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i13 = i3 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function5) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i3 & 16) == 0) {
            if ((i & 24576) == 0) {
                z3 = z2;
                i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
            }
            if ((i3 & 32) != 0) {
                i4 |= 196608;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i5 = 131072;
                    } else {
                        i5 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i5;
                }
            }
            if ((i3 & 64) != 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
            if ((i3 & 128) != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(tweenSpec)) {
                    i7 = 8388608;
                } else {
                    i7 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i4 |= i7;
            }
            if ((i3 & 256) != 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if ((134217728 & i) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(functionDrawBox);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(functionDrawBox);
                }
                if (zChangedInstance) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i4 |= i8;
            }
            if ((i3 & 512) != 0) {
                if ((805306368 & i) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i9 = 536870912;
                    } else {
                        i9 = 268435456;
                    }
                }
                i10 = i4;
                if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                    i11 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i12 = 4;
                    } else {
                        i12 = 2;
                    }
                    i11 = i2 | i12;
                } else {
                    i11 = i2;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    if ((i2 & 48) == 0) {
                        i11 |= composerStartRestartGroup.changed(indication) ? 32 : 16;
                    }
                    if ((i10 & 306783379) == 306783378 || (i11 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                        }
                        if (z) {
                            selectionStage = SelectionStage.Checked;
                        } else {
                            selectionStage = SelectionStage.Unchecked;
                        }
                        stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                        zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                        if (zIsLayoutDirectionRtl) {
                            f3 = Dp.constructor-impl(0);
                        } else {
                            f3 = Dp.constructor-impl(f - f2);
                        }
                        f4 = f3;
                        int i14 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                        state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i14 | (i10 & 896)));
                        state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i14 | ((i10 >> 3) & 896)));
                        Modifier modifier5 = modifier2;
                        modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                            }
                        }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                        if ((i10 & 234881024) != 67108864 || ((i10 & 134217728) != 0 && composerStartRestartGroup.changedInstance(functionDrawBox))) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean zChanged2 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                        if ((i10 & 57344) == 16384) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean z7 = zChanged2 | z5;
                        if ((i10 & 14) == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        zChanged = z7 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                            modifier3 = modifierM927maybeToggleableAWlRVLg;
                            objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                    final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                    final State<Color> state3 = state;
                                    final State<Float> state4 = stateAnimateProgress;
                                    final boolean z8 = zIsLayoutDirectionRtl;
                                    final boolean z9 = z2;
                                    final boolean z10 = z;
                                    final State<Color> state5 = state2;
                                    final float f5 = f4;
                                    return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((ContentDrawScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(ContentDrawScope contentDrawScope) {
                                            DrawScope drawScope = (DrawScope) contentDrawScope;
                                            functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z8);
                                            SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z9, z10, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                        }
                                    });
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            modifier3 = modifierM927maybeToggleableAWlRVLg;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer2, int i15) throws NoWhenBranchMatchedException {
                                SelectionControlsKt.m916Checkboxw41Enmo(z, modifier4, function4, function5, z2, function1, mutableInteractionSource, tweenSpec, functionDrawBox, f, f2, indication, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                    }
                }
                i11 |= 48;
                if ((i10 & 306783379) == 306783378) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                    }
                    if (z) {
                        selectionStage = SelectionStage.Checked;
                    } else {
                        selectionStage = SelectionStage.Unchecked;
                    }
                    stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                    zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                    if (zIsLayoutDirectionRtl) {
                        f3 = Dp.constructor-impl(0);
                    } else {
                        f3 = Dp.constructor-impl(f - f2);
                    }
                    f4 = f3;
                    int i15 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                    state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i15 | (i10 & 896)));
                    state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i15 | ((i10 >> 3) & 896)));
                    Modifier modifier6 = modifier2;
                    modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                        }
                    }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                    if ((i10 & 234881024) != 67108864) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    boolean zChanged3 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                    if ((i10 & 57344) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean z8 = zChanged3 | z5;
                    if ((i10 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    zChanged = z8 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z9 = zIsLayoutDirectionRtl;
                                final boolean z10 = z2;
                                final boolean z11 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z9);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z10, z11, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z9 = zIsLayoutDirectionRtl;
                                final boolean z10 = z2;
                                final boolean z11 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z9);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z10, z11, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier6;
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                    }
                    if (z) {
                        selectionStage = SelectionStage.Checked;
                    } else {
                        selectionStage = SelectionStage.Unchecked;
                    }
                    stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                    zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                    if (zIsLayoutDirectionRtl) {
                        f3 = Dp.constructor-impl(0);
                    } else {
                        f3 = Dp.constructor-impl(f - f2);
                    }
                    f4 = f3;
                    int i16 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                    state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i16 | (i10 & 896)));
                    state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i16 | ((i10 >> 3) & 896)));
                    Modifier modifier7 = modifier2;
                    modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                        }
                    }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                    if ((i10 & 234881024) != 67108864) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    boolean zChanged4 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                    if ((i10 & 57344) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean z9 = zChanged4 | z5;
                    if ((i10 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    zChanged = z9 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z10 = zIsLayoutDirectionRtl;
                                final boolean z11 = z2;
                                final boolean z12 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z10);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z11, z12, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z10 = zIsLayoutDirectionRtl;
                                final boolean z11 = z2;
                                final boolean z12 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z10);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z11, z12, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer2, int i17) throws NoWhenBranchMatchedException {
                            SelectionControlsKt.m916Checkboxw41Enmo(z, modifier4, function4, function5, z2, function1, mutableInteractionSource, tweenSpec, functionDrawBox, f, f2, indication, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i9 = 805306368;
            i4 |= i9;
            i10 = i4;
            if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                if ((i2 & 48) == 0) {
                    i11 |= composerStartRestartGroup.changed(indication) ? 32 : 16;
                }
                if ((i10 & 306783379) == 306783378) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                    }
                    if (z) {
                        selectionStage = SelectionStage.Checked;
                    } else {
                        selectionStage = SelectionStage.Unchecked;
                    }
                    stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                    zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                    if (zIsLayoutDirectionRtl) {
                        f3 = Dp.constructor-impl(0);
                    } else {
                        f3 = Dp.constructor-impl(f - f2);
                    }
                    f4 = f3;
                    int i17 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                    state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i17 | (i10 & 896)));
                    state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i17 | ((i10 >> 3) & 896)));
                    Modifier modifier8 = modifier2;
                    modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                        }
                    }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                    if ((i10 & 234881024) != 67108864) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    boolean zChanged5 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                    if ((i10 & 57344) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean z10 = zChanged5 | z5;
                    if ((i10 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    zChanged = z10 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z11 = zIsLayoutDirectionRtl;
                                final boolean z12 = z2;
                                final boolean z13 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z11);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z12, z13, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z11 = zIsLayoutDirectionRtl;
                                final boolean z12 = z2;
                                final boolean z13 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z11);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z12, z13, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier8;
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                    }
                    if (z) {
                        selectionStage = SelectionStage.Checked;
                    } else {
                        selectionStage = SelectionStage.Unchecked;
                    }
                    stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                    zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                    if (zIsLayoutDirectionRtl) {
                        f3 = Dp.constructor-impl(0);
                    } else {
                        f3 = Dp.constructor-impl(f - f2);
                    }
                    f4 = f3;
                    int i18 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                    state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i18 | (i10 & 896)));
                    state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i18 | ((i10 >> 3) & 896)));
                    Modifier modifier9 = modifier2;
                    modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                        }
                    }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                    if ((i10 & 234881024) != 67108864) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    boolean zChanged6 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                    if ((i10 & 57344) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean z11 = zChanged6 | z5;
                    if ((i10 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    zChanged = z11 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z12 = zIsLayoutDirectionRtl;
                                final boolean z13 = z2;
                                final boolean z14 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z12);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z13, z14, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z12 = zIsLayoutDirectionRtl;
                                final boolean z13 = z2;
                                final boolean z14 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z12);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z13, z14, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier9;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer2, int i19) throws NoWhenBranchMatchedException {
                            SelectionControlsKt.m916Checkboxw41Enmo(z, modifier4, function4, function5, z2, function1, mutableInteractionSource, tweenSpec, functionDrawBox, f, f2, indication, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i11 |= 48;
            if ((i10 & 306783379) == 306783378) {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                }
                if (z) {
                    selectionStage = SelectionStage.Checked;
                } else {
                    selectionStage = SelectionStage.Unchecked;
                }
                stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                if (zIsLayoutDirectionRtl) {
                    f3 = Dp.constructor-impl(0);
                } else {
                    f3 = Dp.constructor-impl(f - f2);
                }
                f4 = f3;
                int i19 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i19 | (i10 & 896)));
                state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i19 | ((i10 >> 3) & 896)));
                Modifier modifier10 = modifier2;
                modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                    }
                }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                if ((i10 & 234881024) != 67108864) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                boolean zChanged7 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                if ((i10 & 57344) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z12 = zChanged7 | z5;
                if ((i10 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zChanged = z12 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z13 = zIsLayoutDirectionRtl;
                            final boolean z14 = z2;
                            final boolean z15 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z13);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z14, z15, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z13 = zIsLayoutDirectionRtl;
                            final boolean z14 = z2;
                            final boolean z15 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z13);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z14, z15, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier10;
            } else {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                }
                if (z) {
                    selectionStage = SelectionStage.Checked;
                } else {
                    selectionStage = SelectionStage.Unchecked;
                }
                stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                if (zIsLayoutDirectionRtl) {
                    f3 = Dp.constructor-impl(0);
                } else {
                    f3 = Dp.constructor-impl(f - f2);
                }
                f4 = f3;
                int i110 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i110 | (i10 & 896)));
                state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i110 | ((i10 >> 3) & 896)));
                Modifier modifier11 = modifier2;
                modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                    }
                }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                if ((i10 & 234881024) != 67108864) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                boolean zChanged8 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                if ((i10 & 57344) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z13 = zChanged8 | z5;
                if ((i10 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zChanged = z13 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z14 = zIsLayoutDirectionRtl;
                            final boolean z15 = z2;
                            final boolean z16 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z14);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z15, z16, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z14 = zIsLayoutDirectionRtl;
                            final boolean z15 = z2;
                            final boolean z16 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z14);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z15, z16, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer2, int i111) throws NoWhenBranchMatchedException {
                        SelectionControlsKt.m916Checkboxw41Enmo(z, modifier4, function4, function5, z2, function1, mutableInteractionSource, tweenSpec, functionDrawBox, f, f2, indication, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i4 |= 24576;
        z3 = z2;
        if ((i3 & 32) != 0) {
            i4 |= 196608;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 131072;
                } else {
                    i5 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i5;
            }
        }
        if ((i3 & 64) != 0) {
            i4 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i6 = 1048576;
            } else {
                i6 = 524288;
            }
            i4 |= i6;
        }
        if ((i3 & 128) != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(tweenSpec)) {
                i7 = 8388608;
            } else {
                i7 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            }
            i4 |= i7;
        }
        if ((i3 & 256) != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if ((134217728 & i) == 0) {
                zChangedInstance = composerStartRestartGroup.changed(functionDrawBox);
            } else {
                zChangedInstance = composerStartRestartGroup.changedInstance(functionDrawBox);
            }
            if (zChangedInstance) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i4 |= i8;
        }
        if ((i3 & 512) != 0) {
            if ((805306368 & i) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i9 = 536870912;
                } else {
                    i9 = 268435456;
                }
            }
            i10 = i4;
            if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                i11 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i11 = i2 | i12;
            } else {
                i11 = i2;
            }
            if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                if ((i2 & 48) == 0) {
                    i11 |= composerStartRestartGroup.changed(indication) ? 32 : 16;
                }
                if ((i10 & 306783379) == 306783378) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                    }
                    if (z) {
                        selectionStage = SelectionStage.Checked;
                    } else {
                        selectionStage = SelectionStage.Unchecked;
                    }
                    stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                    zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                    if (zIsLayoutDirectionRtl) {
                        f3 = Dp.constructor-impl(0);
                    } else {
                        f3 = Dp.constructor-impl(f - f2);
                    }
                    f4 = f3;
                    int i111 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                    state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i111 | (i10 & 896)));
                    state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i111 | ((i10 >> 3) & 896)));
                    Modifier modifier12 = modifier2;
                    modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                        }
                    }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                    if ((i10 & 234881024) != 67108864) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    boolean zChanged9 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                    if ((i10 & 57344) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean z14 = zChanged9 | z5;
                    if ((i10 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    zChanged = z14 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z15 = zIsLayoutDirectionRtl;
                                final boolean z16 = z2;
                                final boolean z17 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z15);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z16, z17, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z15 = zIsLayoutDirectionRtl;
                                final boolean z16 = z2;
                                final boolean z17 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z15);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z16, z17, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier12;
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                    }
                    if (z) {
                        selectionStage = SelectionStage.Checked;
                    } else {
                        selectionStage = SelectionStage.Unchecked;
                    }
                    stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                    zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                    if (zIsLayoutDirectionRtl) {
                        f3 = Dp.constructor-impl(0);
                    } else {
                        f3 = Dp.constructor-impl(f - f2);
                    }
                    f4 = f3;
                    int i112 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                    state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i112 | (i10 & 896)));
                    state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i112 | ((i10 >> 3) & 896)));
                    Modifier modifier13 = modifier2;
                    modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                        }
                    }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                    if ((i10 & 234881024) != 67108864) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    boolean zChanged10 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                    if ((i10 & 57344) == 16384) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean z15 = zChanged10 | z5;
                    if ((i10 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    zChanged = z15 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z16 = zIsLayoutDirectionRtl;
                                final boolean z17 = z2;
                                final boolean z18 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z16);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z17, z18, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        modifier3 = modifierM927maybeToggleableAWlRVLg;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                                final State<Color> state3 = state;
                                final State<Float> state4 = stateAnimateProgress;
                                final boolean z16 = zIsLayoutDirectionRtl;
                                final boolean z17 = z2;
                                final boolean z18 = z;
                                final State<Color> state5 = state2;
                                final float f5 = f4;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z16);
                                        SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z17, z18, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer2, int i113) throws NoWhenBranchMatchedException {
                            SelectionControlsKt.m916Checkboxw41Enmo(z, modifier4, function4, function5, z2, function1, mutableInteractionSource, tweenSpec, functionDrawBox, f, f2, indication, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i11 |= 48;
            if ((i10 & 306783379) == 306783378) {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                }
                if (z) {
                    selectionStage = SelectionStage.Checked;
                } else {
                    selectionStage = SelectionStage.Unchecked;
                }
                stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                if (zIsLayoutDirectionRtl) {
                    f3 = Dp.constructor-impl(0);
                } else {
                    f3 = Dp.constructor-impl(f - f2);
                }
                f4 = f3;
                int i113 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i113 | (i10 & 896)));
                state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i113 | ((i10 >> 3) & 896)));
                Modifier modifier14 = modifier2;
                modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                    }
                }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                if ((i10 & 234881024) != 67108864) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                boolean zChanged11 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                if ((i10 & 57344) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z16 = zChanged11 | z5;
                if ((i10 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zChanged = z16 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z17 = zIsLayoutDirectionRtl;
                            final boolean z18 = z2;
                            final boolean z19 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z17);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z18, z19, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z17 = zIsLayoutDirectionRtl;
                            final boolean z18 = z2;
                            final boolean z19 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z17);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z18, z19, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier14;
            } else {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                }
                if (z) {
                    selectionStage = SelectionStage.Checked;
                } else {
                    selectionStage = SelectionStage.Unchecked;
                }
                stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                if (zIsLayoutDirectionRtl) {
                    f3 = Dp.constructor-impl(0);
                } else {
                    f3 = Dp.constructor-impl(f - f2);
                }
                f4 = f3;
                int i114 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i114 | (i10 & 896)));
                state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i114 | ((i10 >> 3) & 896)));
                Modifier modifier15 = modifier2;
                modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                    }
                }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                if ((i10 & 234881024) != 67108864) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                boolean zChanged12 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                if ((i10 & 57344) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z17 = zChanged12 | z5;
                if ((i10 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zChanged = z17 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z18 = zIsLayoutDirectionRtl;
                            final boolean z19 = z2;
                            final boolean z110 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z18);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z19, z110, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z18 = zIsLayoutDirectionRtl;
                            final boolean z19 = z2;
                            final boolean z110 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z18);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z19, z110, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer2, int i115) throws NoWhenBranchMatchedException {
                        SelectionControlsKt.m916Checkboxw41Enmo(z, modifier4, function4, function5, z2, function1, mutableInteractionSource, tweenSpec, functionDrawBox, f, f2, indication, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i9 = 805306368;
        i4 |= i9;
        i10 = i4;
        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
            i11 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i12 = 4;
            } else {
                i12 = 2;
            }
            i11 = i2 | i12;
        } else {
            i11 = i2;
        }
        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
            if ((i2 & 48) == 0) {
                i11 |= composerStartRestartGroup.changed(indication) ? 32 : 16;
            }
            if ((i10 & 306783379) == 306783378) {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                }
                if (z) {
                    selectionStage = SelectionStage.Checked;
                } else {
                    selectionStage = SelectionStage.Unchecked;
                }
                stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                if (zIsLayoutDirectionRtl) {
                    f3 = Dp.constructor-impl(0);
                } else {
                    f3 = Dp.constructor-impl(f - f2);
                }
                f4 = f3;
                int i115 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i115 | (i10 & 896)));
                state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i115 | ((i10 >> 3) & 896)));
                Modifier modifier16 = modifier2;
                modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                    }
                }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                if ((i10 & 234881024) != 67108864) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                boolean zChanged13 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                if ((i10 & 57344) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z18 = zChanged13 | z5;
                if ((i10 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zChanged = z18 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z19 = zIsLayoutDirectionRtl;
                            final boolean z110 = z2;
                            final boolean z111 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z19);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z110, z111, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z19 = zIsLayoutDirectionRtl;
                            final boolean z110 = z2;
                            final boolean z111 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z19);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z110, z111, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier16;
            } else {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
                }
                if (z) {
                    selectionStage = SelectionStage.Checked;
                } else {
                    selectionStage = SelectionStage.Unchecked;
                }
                stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
                zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
                if (zIsLayoutDirectionRtl) {
                    f3 = Dp.constructor-impl(0);
                } else {
                    f3 = Dp.constructor-impl(f - f2);
                }
                f4 = f3;
                int i116 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
                state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i116 | (i10 & 896)));
                state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i116 | ((i10 >> 3) & 896)));
                Modifier modifier17 = modifier2;
                modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                    }
                }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
                if ((i10 & 234881024) != 67108864) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                boolean zChanged14 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
                if ((i10 & 57344) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z19 = zChanged14 | z5;
                if ((i10 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                zChanged = z19 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z110 = zIsLayoutDirectionRtl;
                            final boolean z111 = z2;
                            final boolean z112 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z110);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z111, z112, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    modifier3 = modifierM927maybeToggleableAWlRVLg;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                            final State<Color> state3 = state;
                            final State<Float> state4 = stateAnimateProgress;
                            final boolean z110 = zIsLayoutDirectionRtl;
                            final boolean z111 = z2;
                            final boolean z112 = z;
                            final State<Color> state5 = state2;
                            final float f5 = f4;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z110);
                                    SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z111, z112, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier17;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer2, int i117) throws NoWhenBranchMatchedException {
                        SelectionControlsKt.m916Checkboxw41Enmo(z, modifier4, function4, function5, z2, function1, mutableInteractionSource, tweenSpec, functionDrawBox, f, f2, indication, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i11 |= 48;
        if ((i10 & 306783379) == 306783378) {
            if (i13 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
            }
            if (z) {
                selectionStage = SelectionStage.Checked;
            } else {
                selectionStage = SelectionStage.Unchecked;
            }
            stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
            zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
            if (zIsLayoutDirectionRtl) {
                f3 = Dp.constructor-impl(0);
            } else {
                f3 = Dp.constructor-impl(f - f2);
            }
            f4 = f3;
            int i117 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
            state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i117 | (i10 & 896)));
            state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i117 | ((i10 >> 3) & 896)));
            Modifier modifier18 = modifier2;
            modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                }
            }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
            if ((i10 & 234881024) != 67108864) {
                z4 = true;
            } else {
                z4 = true;
            }
            boolean zChanged15 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
            if ((i10 & 57344) == 16384) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z110 = zChanged15 | z5;
            if ((i10 & 14) == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            zChanged = z110 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                modifier3 = modifierM927maybeToggleableAWlRVLg;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                        final State<Color> state3 = state;
                        final State<Float> state4 = stateAnimateProgress;
                        final boolean z111 = zIsLayoutDirectionRtl;
                        final boolean z112 = z2;
                        final boolean z113 = z;
                        final State<Color> state5 = state2;
                        final float f5 = f4;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z111);
                                SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z112, z113, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                modifier3 = modifierM927maybeToggleableAWlRVLg;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                        final State<Color> state3 = state;
                        final State<Float> state4 = stateAnimateProgress;
                        final boolean z111 = zIsLayoutDirectionRtl;
                        final boolean z112 = z2;
                        final boolean z113 = z;
                        final State<Color> state5 = state2;
                        final float f5 = f4;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z111);
                                SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z112, z113, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier18;
        } else {
            if (i13 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1104848843, i10, i11, "androidx.wear.compose.materialcore.Checkbox (SelectionControls.kt:95)");
            }
            if (z) {
                selectionStage = SelectionStage.Checked;
            } else {
                selectionStage = SelectionStage.Unchecked;
            }
            stateAnimateProgress = animateProgress(TransitionKt.updateTransition(selectionStage, "checkboxTransition", composerStartRestartGroup, 48, 0), "Checkbox", tweenSpec, composerStartRestartGroup, ((i10 >> 15) & 896) | 48);
            zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
            if (zIsLayoutDirectionRtl) {
                f3 = Dp.constructor-impl(0);
            } else {
                f3 = Dp.constructor-impl(f - f2);
            }
            f4 = f3;
            int i118 = ((i10 >> 12) & 14) | ((i10 << 3) & 112);
            state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i118 | (i10 & 896)));
            state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i118 | ((i10 >> 3) & 896)));
            Modifier modifier19 = modifier2;
            modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getCheckbox-o7Vup1c());
                }
            }, 1, (Object) null), function2, z3, z, mutableInteractionSource, indication, f, f2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -361494161, "CC(remember):SelectionControls.kt#9igjgp");
            if ((i10 & 234881024) != 67108864) {
                z4 = true;
            } else {
                z4 = true;
            }
            boolean zChanged16 = z4 | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(stateAnimateProgress) | composerStartRestartGroup.changed(zIsLayoutDirectionRtl);
            if ((i10 & 57344) == 16384) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z111 = zChanged16 | z5;
            if ((i10 & 14) == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            zChanged = z111 | z6 | composerStartRestartGroup.changed(state2) | composerStartRestartGroup.changed(f4);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                modifier3 = modifierM927maybeToggleableAWlRVLg;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                        final State<Color> state3 = state;
                        final State<Float> state4 = stateAnimateProgress;
                        final boolean z112 = zIsLayoutDirectionRtl;
                        final boolean z113 = z2;
                        final boolean z114 = z;
                        final State<Color> state5 = state2;
                        final float f5 = f4;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z112);
                                SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z113, z114, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                modifier3 = modifierM927maybeToggleableAWlRVLg;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final FunctionDrawBox functionDrawBox2 = functionDrawBox;
                        final State<Color> state3 = state;
                        final State<Float> state4 = stateAnimateProgress;
                        final boolean z112 = zIsLayoutDirectionRtl;
                        final boolean z113 = z2;
                        final boolean z114 = z;
                        final State<Color> state5 = state2;
                        final float f5 = f4;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                functionDrawBox2.mo866invokeRPmYEkk(drawScope, ((Color) state3.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), z112);
                                SelectionControlsKt.m921animateTickTN_IhPg(drawScope, z113, z114, ((Color) state5.getValue()).unbox-impl(), ((Number) state4.getValue()).floatValue(), f5);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifier3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier19;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Checkbox$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final void invoke(Composer composer2, int i119) throws NoWhenBranchMatchedException {
                    SelectionControlsKt.m916Checkboxw41Enmo(z, modifier4, function4, function5, z2, function1, mutableInteractionSource, tweenSpec, functionDrawBox, f, f2, indication, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                }
            });
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:158:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:162:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:165:0x02de  */
    /* JADX INFO: renamed from: Switch-Z7GKWWo, reason: not valid java name */
    public static final void m918SwitchZ7GKWWo(final Modifier modifier, final boolean z, final boolean z2, final Function1<? super Boolean, Unit> function1, final MutableInteractionSource mutableInteractionSource, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function4, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function5, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function6, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function7, final float f, final float f2, final FunctionDrawThumb functionDrawThumb, final TweenSpec<Float> tweenSpec, final float f3, final float f4, final Indication indication, Composer composer, final int i, final int i2) throws NoWhenBranchMatchedException {
        int i3;
        boolean z3;
        MutableInteractionSource mutableInteractionSource2;
        int i4;
        float f5;
        Composer composer2;
        FunctionDrawThumb functionDrawThumb2;
        boolean z4;
        boolean zChanged;
        Object objRememberedValue;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1084526499);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Switch)P(5!1,2,6,4,11,13,9,10,14:c#ui.unit.Dp,12:c#ui.unit.Dp!1,7,15:c#ui.unit.Dp,3:c#ui.unit.Dp)189@8434L57,190@8508L22,192@8556L90,198@8679L28,199@8728L32,200@8796L32,201@8866L34,220@9411L684,205@9025L1071:SelectionControls.kt#f7tims");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            z3 = z2;
            i3 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        } else {
            z3 = z2;
        }
        int i6 = i & 3072;
        int i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
        if (i6 == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            mutableInteractionSource2 = mutableInteractionSource;
            i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i & 196608) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function7) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(f2) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= (i2 & 64) == 0 ? composerStartRestartGroup.changed(functionDrawThumb) : composerStartRestartGroup.changedInstance(functionDrawThumb) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(tweenSpec) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            f5 = f3;
            if (!composerStartRestartGroup.changed(f5)) {
                i7 = 1024;
            }
            i4 |= i7;
        } else {
            f5 = f3;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= composerStartRestartGroup.changed(indication) ? 131072 : 65536;
        }
        int i8 = i4;
        if ((i3 & 306783379) != 306783378 || (74899 & i8) != 74898 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1084526499, i3, i8, "androidx.wear.compose.materialcore.Switch (SelectionControls.kt:187)");
            }
            Transition transitionUpdateTransition = TransitionKt.updateTransition(z ? SelectionStage.Checked : SelectionStage.Unchecked, "switchTransition", composerStartRestartGroup, 48, 0);
            final boolean zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
            final State<Float> stateAnimateProgress = animateProgress(transitionUpdateTransition, "Switch", tweenSpec, composerStartRestartGroup, (i8 & 896) | 48);
            int i9 = ((i3 >> 6) & 14) | (i3 & 112);
            final State state = (State) function6.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(((i3 >> 15) & 896) | i9));
            final State state2 = (State) function7.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i9 | ((i3 >> 18) & 896)));
            final State state3 = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i9 | ((i3 >> 9) & 896)));
            final State state4 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i9 | ((i3 >> 12) & 896)));
            composer2 = composerStartRestartGroup;
            int i10 = i3;
            Modifier modifierM927maybeToggleableAWlRVLg = m927maybeToggleableAWlRVLg(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getSwitch-o7Vup1c());
                }
            }, 1, (Object) null), function1, z3, z, mutableInteractionSource2, indication, f5, f4);
            ComposerKt.sourceInformationMarkerStart(composer2, -1278112862, "CC(remember):SelectionControls.kt#9igjgp");
            boolean zChanged2 = composer2.changed(state3) | composer2.changed(state4) | ((i10 & 1879048192) == 536870912) | ((i8 & 14) == 4);
            if ((i8 & 112) != 32) {
                if ((i8 & 64) != 0) {
                    functionDrawThumb2 = functionDrawThumb;
                    if (composer2.changedInstance(functionDrawThumb2)) {
                    }
                    zChanged = zChanged2 | z4 | composer2.changed(state) | composer2.changed(stateAnimateProgress) | composer2.changed(state2) | composer2.changed(zIsLayoutDirectionRtl);
                    objRememberedValue = composer2.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        final FunctionDrawThumb functionDrawThumb3 = functionDrawThumb2;
                        i5 = 0;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final State<Color> state5 = state3;
                                final State<Color> state6 = state4;
                                final float f6 = f;
                                final float f7 = f2;
                                final FunctionDrawThumb functionDrawThumb4 = functionDrawThumb3;
                                final State<Color> state7 = state;
                                final State<Float> state8 = stateAnimateProgress;
                                final State<Color> state9 = state2;
                                final boolean z5 = zIsLayoutDirectionRtl;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        SelectionControlsKt.m923drawTrack1wkBAMs(drawScope, ((Color) state5.getValue()).unbox-impl(), ((Color) state6.getValue()).unbox-impl(), contentDrawScope.toPx-0680j_4(f6), contentDrawScope.toPx-0680j_4(f7));
                                        functionDrawThumb4.mo867invokewffgcV4(drawScope, ((Color) state7.getValue()).unbox-impl(), ((Number) state8.getValue()).floatValue(), ((Color) state9.getValue()).unbox-impl(), z5);
                                    }
                                });
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        i5 = 0;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierM927maybeToggleableAWlRVLg, (Function1) objRememberedValue), composer2, i5);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    functionDrawThumb2 = functionDrawThumb;
                }
                z4 = false;
                zChanged = zChanged2 | z4 | composer2.changed(state) | composer2.changed(stateAnimateProgress) | composer2.changed(state2) | composer2.changed(zIsLayoutDirectionRtl);
                objRememberedValue = composer2.rememberedValue();
                if (zChanged) {
                    final FunctionDrawThumb functionDrawThumb4 = functionDrawThumb2;
                    i5 = 0;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final State<Color> state5 = state3;
                            final State<Color> state6 = state4;
                            final float f6 = f;
                            final float f7 = f2;
                            final FunctionDrawThumb functionDrawThumb5 = functionDrawThumb4;
                            final State<Color> state7 = state;
                            final State<Float> state8 = stateAnimateProgress;
                            final State<Color> state9 = state2;
                            final boolean z5 = zIsLayoutDirectionRtl;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    SelectionControlsKt.m923drawTrack1wkBAMs(drawScope, ((Color) state5.getValue()).unbox-impl(), ((Color) state6.getValue()).unbox-impl(), contentDrawScope.toPx-0680j_4(f6), contentDrawScope.toPx-0680j_4(f7));
                                    functionDrawThumb5.mo867invokewffgcV4(drawScope, ((Color) state7.getValue()).unbox-impl(), ((Number) state8.getValue()).floatValue(), ((Color) state9.getValue()).unbox-impl(), z5);
                                }
                            });
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    final FunctionDrawThumb functionDrawThumb5 = functionDrawThumb2;
                    i5 = 0;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final State<Color> state5 = state3;
                            final State<Color> state6 = state4;
                            final float f6 = f;
                            final float f7 = f2;
                            final FunctionDrawThumb functionDrawThumb6 = functionDrawThumb5;
                            final State<Color> state7 = state;
                            final State<Float> state8 = stateAnimateProgress;
                            final State<Color> state9 = state2;
                            final boolean z5 = zIsLayoutDirectionRtl;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    SelectionControlsKt.m923drawTrack1wkBAMs(drawScope, ((Color) state5.getValue()).unbox-impl(), ((Color) state6.getValue()).unbox-impl(), contentDrawScope.toPx-0680j_4(f6), contentDrawScope.toPx-0680j_4(f7));
                                    functionDrawThumb6.mo867invokewffgcV4(drawScope, ((Color) state7.getValue()).unbox-impl(), ((Number) state8.getValue()).floatValue(), ((Color) state9.getValue()).unbox-impl(), z5);
                                }
                            });
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierM927maybeToggleableAWlRVLg, (Function1) objRememberedValue), composer2, i5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                functionDrawThumb2 = functionDrawThumb;
            }
            z4 = true;
            zChanged = zChanged2 | z4 | composer2.changed(state) | composer2.changed(stateAnimateProgress) | composer2.changed(state2) | composer2.changed(zIsLayoutDirectionRtl);
            objRememberedValue = composer2.rememberedValue();
            if (zChanged) {
                final FunctionDrawThumb functionDrawThumb6 = functionDrawThumb2;
                i5 = 0;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final State<Color> state5 = state3;
                        final State<Color> state6 = state4;
                        final float f6 = f;
                        final float f7 = f2;
                        final FunctionDrawThumb functionDrawThumb7 = functionDrawThumb6;
                        final State<Color> state7 = state;
                        final State<Float> state8 = stateAnimateProgress;
                        final State<Color> state9 = state2;
                        final boolean z5 = zIsLayoutDirectionRtl;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                SelectionControlsKt.m923drawTrack1wkBAMs(drawScope, ((Color) state5.getValue()).unbox-impl(), ((Color) state6.getValue()).unbox-impl(), contentDrawScope.toPx-0680j_4(f6), contentDrawScope.toPx-0680j_4(f7));
                                functionDrawThumb7.mo867invokewffgcV4(drawScope, ((Color) state7.getValue()).unbox-impl(), ((Number) state8.getValue()).floatValue(), ((Color) state9.getValue()).unbox-impl(), z5);
                            }
                        });
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                final FunctionDrawThumb functionDrawThumb7 = functionDrawThumb2;
                i5 = 0;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final State<Color> state5 = state3;
                        final State<Color> state6 = state4;
                        final float f6 = f;
                        final float f7 = f2;
                        final FunctionDrawThumb functionDrawThumb8 = functionDrawThumb7;
                        final State<Color> state7 = state;
                        final State<Float> state8 = stateAnimateProgress;
                        final State<Color> state9 = state2;
                        final boolean z5 = zIsLayoutDirectionRtl;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                SelectionControlsKt.m923drawTrack1wkBAMs(drawScope, ((Color) state5.getValue()).unbox-impl(), ((Color) state6.getValue()).unbox-impl(), contentDrawScope.toPx-0680j_4(f6), contentDrawScope.toPx-0680j_4(f7));
                                functionDrawThumb8.mo867invokewffgcV4(drawScope, ((Color) state7.getValue()).unbox-impl(), ((Number) state8.getValue()).floatValue(), ((Color) state9.getValue()).unbox-impl(), z5);
                            }
                        });
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierM927maybeToggleableAWlRVLg, (Function1) objRememberedValue), composer2, i5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$Switch$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final void invoke(Composer composer3, int i11) throws NoWhenBranchMatchedException {
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier, z, z2, function1, mutableInteractionSource, function4, function5, function6, function7, f, f2, functionDrawThumb, tweenSpec, f3, f4, indication, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX INFO: renamed from: RadioButton-q3QzNKE, reason: not valid java name */
    public static final void m917RadioButtonq3QzNKE(final Modifier modifier, final boolean z, final boolean z2, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function4, final Function4<? super Boolean, ? super Boolean, ? super Composer, ? super Integer, ? extends State<Color>> function5, final Function0<Unit> function0, final MutableInteractionSource mutableInteractionSource, final FunctionDotRadiusProgressDuration functionDotRadiusProgressDuration, final int i, final int i2, final CubicBezierEasing cubicBezierEasing, final float f, final float f2, final Indication indication, Composer composer, final int i3, final int i4) throws NoWhenBranchMatchedException {
        int i5;
        boolean z3;
        int i6;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1899074485);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadioButton)P(8,12,5,10,2,9,7,3,1!2,13:c#ui.unit.Dp,6:c#ui.unit.Dp)283@12287L29,284@12333L22,286@12382L28,287@12435L27,289@12492L163,319@13609L1132,311@13256L1486:SelectionControls.kt#f7tims");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            z3 = z2;
            i5 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        } else {
            z3 = z2;
        }
        int i7 = i3 & 3072;
        int i8 = RecyclerView.ItemAnimator.FLAG_MOVED;
        if (i7 == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function5) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= (i3 & 16777216) == 0 ? composerStartRestartGroup.changed(functionDotRadiusProgressDuration) : composerStartRestartGroup.changedInstance(functionDotRadiusProgressDuration) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerStartRestartGroup.changed(cubicBezierEasing) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            if (!composerStartRestartGroup.changed(indication)) {
                i8 = 1024;
            }
            i6 |= i8;
        }
        int i9 = i6;
        if ((i5 & 306783379) != 306783378 || (i9 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1899074485, i5, i9, "androidx.wear.compose.materialcore.RadioButton (SelectionControls.kt:281)");
            }
            SelectionStage selectionStage = z ? SelectionStage.Checked : SelectionStage.Unchecked;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(selectionStage, (String) null, composerStartRestartGroup, 0, 2);
            final boolean zIsLayoutDirectionRtl = ResourcesKt.isLayoutDirectionRtl(composerStartRestartGroup, 0);
            int i10 = i5 >> 6;
            int i11 = (i10 & 14) | (i5 & 112);
            final State state = (State) function4.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i11 | ((i5 >> 3) & 896)));
            final State state2 = (State) function5.invoke(Boolean.valueOf(z3), Boolean.valueOf(z), composerStartRestartGroup, Integer.valueOf(i11 | (i10 & 896)));
            Easing easing = (Easing) cubicBezierEasing;
            final State<Float> stateAnimateProgress = animateProgress(transitionUpdateTransition, "dot-radius", AnimationSpecKt.tween(functionDotRadiusProgressDuration.invoke(z), 0, easing), composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceGroup(-655744133);
            ComposerKt.sourceInformation(composerStartRestartGroup, "297@12820L281");
            State<Float> stateAnimateProgress2 = selectionStage == SelectionStage.Unchecked ? animateProgress(transitionUpdateTransition, "dot-alpha", AnimationSpecKt.tween(i, i2, easing), composerStartRestartGroup, 48) : null;
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            final State<Float> state3 = stateAnimateProgress2;
            Modifier modifierM926maybeSelectableAWlRVLg = m926maybeSelectableAWlRVLg(modifier, function0, z3, z, mutableInteractionSource, indication, f, f2);
            ComposerKt.sourceInformationMarkerStart(composer2, -655716297, "CC(remember):SelectionControls.kt#9igjgp");
            boolean zChanged = composer2.changed(zIsLayoutDirectionRtl) | ((i9 & 112) == 32) | ((i9 & 896) == 256) | composer2.changed(state) | composer2.changed(stateAnimateProgress) | composer2.changed(state2) | composer2.changed(state3);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$RadioButton$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        float f3;
                        if (zIsLayoutDirectionRtl) {
                            f3 = -cacheDrawScope.toPx-0680j_4(Dp.constructor-impl(f - f2));
                        } else {
                            f3 = cacheDrawScope.toPx-0680j_4(Dp.constructor-impl(f - f2));
                        }
                        final float f4 = f3 / 2;
                        final State<Color> state4 = state;
                        final State<Float> state5 = stateAnimateProgress;
                        final State<Color> state6 = state2;
                        final State<Float> state7 = state3;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$RadioButton$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                long jOffset = OffsetKt.Offset(Offset.getX-impl(contentDrawScope.getCenter-F1C5BW0()) + f4, Offset.getY-impl(contentDrawScope.getCenter-F1C5BW0()));
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                DrawScope.drawCircle-VaOC9Bg$default(drawScope, ((Color) state4.getValue()).unbox-impl(), contentDrawScope.toPx-0680j_4(SelectionControlsKt.RADIO_CIRCLE_RADIUS), jOffset, 0.0f, new Stroke(contentDrawScope.toPx-0680j_4(SelectionControlsKt.RADIO_CIRCLE_STROKE), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 104, (Object) null);
                                float fFloatValue = ((Number) state5.getValue()).floatValue() * contentDrawScope.toPx-0680j_4(SelectionControlsKt.RADIO_DOT_RADIUS);
                                long j = ((Color) state6.getValue()).unbox-impl();
                                State<Float> state8 = state7;
                                DrawScope.drawCircle-VaOC9Bg$default(drawScope, Color.copy-wmQWz5c$default(j, (state8 != null ? ((Number) state8.getValue()).floatValue() : 1.0f) * Color.getAlpha-impl(((Color) state6.getValue()).unbox-impl()), 0.0f, 0.0f, 0.0f, 14, (Object) null), fFloatValue, jOffset, 0.0f, Fill.INSTANCE, (ColorFilter) null, 0, 104, (Object) null);
                            }
                        });
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierM926maybeSelectableAWlRVLg, (Function1) objRememberedValue), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt$RadioButton$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final void invoke(Composer composer3, int i12) throws NoWhenBranchMatchedException {
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier, z, z2, function4, function5, function0, mutableInteractionSource, functionDotRadiusProgressDuration, i, i2, cubicBezierEasing, f, f2, indication, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4));
                }
            });
        }
    }

    /* JADX INFO: renamed from: animateSelectionColor-NghDbR4, reason: not valid java name */
    public static final State<Color> m920animateSelectionColorNghDbR4(boolean z, boolean z2, long j, long j2, long j3, long j4, AnimationSpec<Color> animationSpec, Composer composer, int i) {
        long j5;
        ComposerKt.sourceInformationMarkerStart(composer, -755800682, "C(animateSelectionColor)P(5,1,2:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)366@15759L233:SelectionControls.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-755800682, i, -1, "androidx.wear.compose.materialcore.animateSelectionColor (SelectionControls.kt:366)");
        }
        if (z) {
            j5 = z2 ? j : j2;
        } else {
            j5 = z2 ? j3 : j4;
        }
        State<Color> state = SingleValueAnimationKt.animateColorAsState-euL9pac(j5, animationSpec, (String) null, (Function1) null, composer, (i >> 15) & 112, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return state;
    }

    /* JADX INFO: renamed from: animateTick-TN_IhPg, reason: not valid java name */
    public static final void m921animateTickTN_IhPg(DrawScope drawScope, boolean z, boolean z2, long j, float f, float f2) {
        if ((z2 ? SelectionStage.Checked : SelectionStage.Unchecked) == SelectionStage.Checked) {
            m922drawTickK7VD59E(drawScope, j, f, f2, z);
        } else {
            m924eraseTickK7VD59E(drawScope, j, f, f2, z);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private static final State<Float> animateProgress(Transition<SelectionStage> transition, String str, final TweenSpec<Float> tweenSpec, Composer composer, int i) throws NoWhenBranchMatchedException {
        float f;
        ComposerKt.sourceInformationMarkerStart(composer, 1848167121, "C(animateProgress)P(2,1)424@17475L183:SelectionControls.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1848167121, i, -1, "androidx.wear.compose.materialcore.animateProgress (SelectionControls.kt:424)");
        }
        Function3<Transition.Segment<SelectionStage>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<SelectionStage>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.wear.compose.materialcore.SelectionControlsKt.animateProgress.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Transition.Segment<SelectionStage>) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<SelectionStage> segment, Composer composer2, int i2) {
                composer2.startReplaceGroup(409139710);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(409139710, i2, -1, "androidx.wear.compose.materialcore.animateProgress.<anonymous> (SelectionControls.kt:426)");
                }
                FiniteAnimationSpec<Float> finiteAnimationSpec = tweenSpec;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return finiteAnimationSpec;
            }
        };
        int i2 = ((i << 3) & 896) | (i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
        TwoWayConverter vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int i3 = ((i2 << 3) & 7168) | (i2 & 14);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        SelectionStage selectionStage = (SelectionStage) transition.getCurrentState();
        composer.startReplaceGroup(658780729);
        ComposerKt.sourceInformation(composer, "C:SelectionControls.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(658780729, 0, -1, "androidx.wear.compose.materialcore.animateProgress.<anonymous> (SelectionControls.kt:429)");
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[selectionStage.ordinal()];
        float f2 = 1.0f;
        if (i4 == 1) {
            f = 0.0f;
        } else {
            if (i4 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        SelectionStage selectionStage2 = (SelectionStage) transition.getTargetState();
        composer.startReplaceGroup(658780729);
        ComposerKt.sourceInformation(composer, "C:SelectionControls.kt#f7tims");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(658780729, 0, -1, "androidx.wear.compose.materialcore.animateProgress.<anonymous> (SelectionControls.kt:429)");
        }
        int i5 = WhenMappings.$EnumSwitchMapping$0[selectionStage2.ordinal()];
        if (i5 == 1) {
            f2 = 0.0f;
        } else if (i5 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State<Float> stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composer, 0), vectorConverter, str, composer, (i3 & 14) | ((i3 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    /* JADX INFO: renamed from: maybeToggleable-AWlRVLg, reason: not valid java name */
    private static final Modifier m927maybeToggleableAWlRVLg(Modifier modifier, Function1<? super Boolean, Unit> function1, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, Indication indication, float f, float f2) {
        Modifier modifier2 = SizeKt.requiredSize-VpY3zN4(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenterEnd(), false, 2, (Object) null), f, f2);
        return function1 == null ? modifier2 : modifier2.then(ToggleableKt.toggleable-O2vRcR0$default(Modifier.Companion, z2, mutableInteractionSource, indication, z, (Role) null, function1, 16, (Object) null));
    }

    /* JADX INFO: renamed from: maybeSelectable-AWlRVLg, reason: not valid java name */
    private static final Modifier m926maybeSelectableAWlRVLg(Modifier modifier, Function0<Unit> function0, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, Indication indication, float f, float f2) {
        Modifier modifier2 = SizeKt.requiredSize-VpY3zN4(SizeKt.wrapContentSize$default(modifier, Alignment.Companion.getCenter(), false, 2, (Object) null), f, f2);
        return function0 == null ? modifier2 : modifier2.then(SelectableKt.selectable-O2vRcR0(Modifier.Companion, z2, mutableInteractionSource, indication, z, Role.box-impl(Role.Companion.getRadioButton-o7Vup1c()), function0));
    }

    /* JADX INFO: renamed from: drawTick-K7VD59E, reason: not valid java name */
    private static final void m922drawTickK7VD59E(DrawScope drawScope, long j, float f, float f2, boolean z) {
        float f3 = drawScope.toPx-0680j_4(TICK_BASE_LENGTH);
        float f4 = drawScope.toPx-0680j_4(TICK_STICK_LENGTH);
        float f5 = f3 + f4;
        float f6 = f * f5;
        float f7 = drawScope.toPx-0680j_4(f2);
        float f8 = 12;
        long jOffset = OffsetKt.Offset(drawScope.toPx-0680j_4(Dp.constructor-impl(f8)) + f7, drawScope.toPx-0680j_4(Dp.constructor-impl(f8)));
        float radians = toRadians(TICK_ROTATION - ((TICK_ROTATION / f5) * f6));
        long jOffset2 = OffsetKt.Offset(drawScope.toPx-0680j_4(Dp.constructor-impl(6.7f)) + f7, drawScope.toPx-0680j_4(Dp.constructor-impl(12.3f)));
        float fMin = Math.min(f6, f3);
        Path Path = AndroidPath_androidKt.Path();
        m928moveToUv8p0NA(Path, m930rotateYOhFQsI(jOffset2, radians, jOffset));
        m925lineToUv8p0NA(Path, m930rotateYOhFQsI(Offset.plus-MK-Hz9U(jOffset2, OffsetKt.Offset(fMin, fMin)), radians, jOffset));
        if (f6 > f3) {
            float fMin2 = Math.min(f6 - f3, f4);
            long jOffset3 = OffsetKt.Offset(drawScope.toPx-0680j_4(Dp.constructor-impl(9.3f)) + f7, drawScope.toPx-0680j_4(Dp.constructor-impl(16.3f)));
            m928moveToUv8p0NA(Path, m930rotateYOhFQsI(jOffset3, radians, jOffset));
            m925lineToUv8p0NA(Path, m930rotateYOhFQsI(OffsetKt.Offset(Offset.getX-impl(jOffset3) + fMin2, Offset.getY-impl(jOffset3) - fMin2), radians, jOffset));
        }
        DrawScope.drawPath-LG529CI$default(drawScope, Path, j, 0.0f, new Stroke(drawScope.toPx-0680j_4(Dp.constructor-impl(2)), 0.0f, StrokeCap.Companion.getButt-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, z ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : BlendMode.Companion.getHardlight-0nO6VwU(), 20, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawTrack-1wkBAMs, reason: not valid java name */
    public static final void m923drawTrack1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        Path Path = AndroidPath_androidKt.Path();
        float f3 = f2 / 2.0f;
        m928moveToUv8p0NA(Path, OffsetKt.Offset(f3, Offset.getY-impl(drawScope.getCenter-F1C5BW0())));
        m925lineToUv8p0NA(Path, OffsetKt.Offset(f - f3, Offset.getY-impl(drawScope.getCenter-F1C5BW0())));
        DrawScope.drawPath-LG529CI$default(drawScope, Path, j2, 0.0f, new Stroke(f2, 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 52, (Object) null);
        if (Color.equals-impl0(j2, j)) {
            return;
        }
        DrawScope.drawPath-LG529CI$default(drawScope, Path, j, 0.0f, new Stroke(f2 - (2 * drawScope.toPx-0680j_4(SWITCH_TRACK_BORDER)), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 52, (Object) null);
    }

    /* JADX INFO: renamed from: eraseTick-K7VD59E, reason: not valid java name */
    private static final void m924eraseTickK7VD59E(DrawScope drawScope, long j, float f, float f2, boolean z) {
        float f3 = drawScope.toPx-0680j_4(TICK_BASE_LENGTH);
        float f4 = drawScope.toPx-0680j_4(TICK_STICK_LENGTH);
        float f5 = (f3 + f4) * f;
        float f6 = drawScope.toPx-0680j_4(f2);
        float f7 = drawScope.toPx-0680j_4(Dp.constructor-impl(17.3f)) + f6;
        float f8 = drawScope.toPx-0680j_4(Dp.constructor-impl(8.3f));
        float fMin = Math.min(f5, f4);
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(f7, f8);
        Path.lineTo(f7 - fMin, f8 + fMin);
        if (fMin > f4) {
            float fMin2 = Math.min(f5 - f4, f3);
            float f9 = drawScope.toPx-0680j_4(Dp.constructor-impl(10.7f)) + f6;
            float f10 = drawScope.toPx-0680j_4(Dp.constructor-impl(16.3f));
            Path.moveTo(f9, f10);
            Path.lineTo(f9 - fMin2, f10 - fMin2);
        }
        DrawScope.drawPath-LG529CI$default(drawScope, Path, j, 0.0f, new Stroke(drawScope.toPx-0680j_4(Dp.constructor-impl(2)), 0.0f, StrokeCap.Companion.getButt-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, z ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : BlendMode.Companion.getHardlight-0nO6VwU(), 20, (Object) null);
    }

    /* JADX INFO: renamed from: moveTo-Uv8p0NA, reason: not valid java name */
    private static final void m928moveToUv8p0NA(Path path, long j) {
        path.moveTo(Offset.getX-impl(j), Offset.getY-impl(j));
    }

    /* JADX INFO: renamed from: lineTo-Uv8p0NA, reason: not valid java name */
    private static final void m925lineToUv8p0NA(Path path, long j) {
        path.lineTo(Offset.getX-impl(j), Offset.getY-impl(j));
    }

    /* JADX INFO: renamed from: rotate-3MmeM6k, reason: not valid java name */
    private static final long m929rotate3MmeM6k(long j, float f) {
        long jDirectionVector = directionVector(f);
        return Offset.plus-MK-Hz9U(Offset.times-tuRUvjQ(jDirectionVector, Offset.getX-impl(j)), Offset.times-tuRUvjQ(m931rotate90k4lQ0M(jDirectionVector), Offset.getY-impl(j)));
    }

    /* JADX INFO: renamed from: rotate-YOhFQsI, reason: not valid java name */
    private static final long m930rotateYOhFQsI(long j, float f, long j2) {
        return Offset.plus-MK-Hz9U(m929rotate3MmeM6k(Offset.minus-MK-Hz9U(j, j2), f), j2);
    }

    public static final long directionVector(float f) {
        double d = f;
        return OffsetKt.Offset((float) Math.cos(d), (float) Math.sin(d));
    }

    /* JADX INFO: renamed from: rotate90-k-4lQ0M, reason: not valid java name */
    private static final long m931rotate90k4lQ0M(long j) {
        return OffsetKt.Offset(-Offset.getY-impl(j), Offset.getX-impl(j));
    }
}
