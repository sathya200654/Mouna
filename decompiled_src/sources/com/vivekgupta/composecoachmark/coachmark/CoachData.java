package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoachData.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J$\u0010 \u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\b\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003J\t\u0010#\u001a\u00020\u000fHÆ\u0003J\t\u0010$\u001a\u00020\u0011HÆ\u0003J`\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001e\b\u0002\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R)\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0002\b\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/CoachData;", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "revealEffect", "Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "alignment", "Landroidx/compose/ui/Alignment;", "isForcedAlignment", "", "coachStyle", "Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function3;Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;Landroidx/compose/ui/Alignment;ZLcom/vivekgupta/composecoachmark/coachmark/CoachStyle;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getCoachStyle", "()Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "getContent", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "()Z", "getRevealEffect", "()Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function3;Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;Landroidx/compose/ui/Alignment;ZLcom/vivekgupta/composecoachmark/coachmark/CoachStyle;)Lcom/vivekgupta/composecoachmark/coachmark/CoachData;", "equals", "other", "hashCode", "", "toString", "", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CoachData {
    public static final int $stable = 8;
    private final Alignment alignment;
    private final CoachStyle coachStyle;
    private final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> content;
    private final LayoutCoordinates coordinates;
    private final boolean isForcedAlignment;
    private final RevealEffect revealEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CoachData copy$default(CoachData coachData, LayoutCoordinates layoutCoordinates, Function3 function3, RevealEffect revealEffect, Alignment alignment, boolean z, CoachStyle coachStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutCoordinates = coachData.coordinates;
        }
        if ((i & 2) != 0) {
            function3 = coachData.content;
        }
        if ((i & 4) != 0) {
            revealEffect = coachData.revealEffect;
        }
        if ((i & 8) != 0) {
            alignment = coachData.alignment;
        }
        if ((i & 16) != 0) {
            z = coachData.isForcedAlignment;
        }
        if ((i & 32) != 0) {
            coachStyle = coachData.coachStyle;
        }
        boolean z2 = z;
        CoachStyle coachStyle2 = coachStyle;
        return coachData.copy(layoutCoordinates, function3, revealEffect, alignment, z2, coachStyle2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LayoutCoordinates getCoordinates() {
        return this.coordinates;
    }

    public final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> component2() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RevealEffect getRevealEffect() {
        return this.revealEffect;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsForcedAlignment() {
        return this.isForcedAlignment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CoachStyle getCoachStyle() {
        return this.coachStyle;
    }

    public final CoachData copy(LayoutCoordinates coordinates, Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> content, RevealEffect revealEffect, Alignment alignment, boolean isForcedAlignment, CoachStyle coachStyle) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(revealEffect, "revealEffect");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(coachStyle, "coachStyle");
        return new CoachData(coordinates, content, revealEffect, alignment, isForcedAlignment, coachStyle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoachData)) {
            return false;
        }
        CoachData coachData = (CoachData) other;
        return Intrinsics.areEqual(this.coordinates, coachData.coordinates) && Intrinsics.areEqual(this.content, coachData.content) && Intrinsics.areEqual(this.revealEffect, coachData.revealEffect) && Intrinsics.areEqual(this.alignment, coachData.alignment) && this.isForcedAlignment == coachData.isForcedAlignment && Intrinsics.areEqual(this.coachStyle, coachData.coachStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((((((this.coordinates.hashCode() * 31) + this.content.hashCode()) * 31) + this.revealEffect.hashCode()) * 31) + this.alignment.hashCode()) * 31;
        boolean z = this.isForcedAlignment;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.coachStyle.hashCode();
    }

    public String toString() {
        return "CoachData(coordinates=" + this.coordinates + ", content=" + this.content + ", revealEffect=" + this.revealEffect + ", alignment=" + this.alignment + ", isForcedAlignment=" + this.isForcedAlignment + ", coachStyle=" + this.coachStyle + ')';
    }

    public CoachData(LayoutCoordinates layoutCoordinates, Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, RevealEffect revealEffect, Alignment alignment, boolean z, CoachStyle coachStyle) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        Intrinsics.checkNotNullParameter(function3, "content");
        Intrinsics.checkNotNullParameter(revealEffect, "revealEffect");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(coachStyle, "coachStyle");
        this.coordinates = layoutCoordinates;
        this.content = function3;
        this.revealEffect = revealEffect;
        this.alignment = alignment;
        this.isForcedAlignment = z;
        this.coachStyle = coachStyle;
    }

    public final LayoutCoordinates getCoordinates() {
        return this.coordinates;
    }

    public final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> getContent() {
        return this.content;
    }

    public /* synthetic */ CoachData(LayoutCoordinates layoutCoordinates, Function3 function3, RectangleRevealEffect rectangleRevealEffect, Alignment alignment, boolean z, DefaultCoachStyle defaultCoachStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutCoordinates, function3, (i & 4) != 0 ? new RectangleRevealEffect() : rectangleRevealEffect, (i & 8) != 0 ? Alignment.Companion.getBottomCenter() : alignment, (i & 16) != 0 ? false : z, (i & 32) != 0 ? new DefaultCoachStyle() : defaultCoachStyle);
    }

    public final RevealEffect getRevealEffect() {
        return this.revealEffect;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final boolean isForcedAlignment() {
        return this.isForcedAlignment;
    }

    public final CoachStyle getCoachStyle() {
        return this.coachStyle;
    }
}
