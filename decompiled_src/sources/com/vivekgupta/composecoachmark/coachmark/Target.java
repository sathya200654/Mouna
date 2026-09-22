package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Target.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u001a\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010HÆ\u0003JV\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010HÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/Target;", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "revealEffect", "Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "coachStyle", "Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "alignment", "Landroidx/compose/ui/Alignment;", "isForcedAlignment", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getCoachStyle", "()Lcom/vivekgupta/composecoachmark/coachmark/CoachStyle;", "getContent", "()Lkotlin/jvm/functions/Function1;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "()Z", "getRevealEffect", "()Lcom/vivekgupta/composecoachmark/coachmark/RevealEffect;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Target {
    public static final int $stable = 8;
    private final Alignment alignment;
    private final CoachStyle coachStyle;
    private final Function1<BoxScope, Unit> content;
    private final LayoutCoordinates coordinates;
    private final boolean isForcedAlignment;
    private final RevealEffect revealEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Target copy$default(Target target, LayoutCoordinates layoutCoordinates, RevealEffect revealEffect, CoachStyle coachStyle, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutCoordinates = target.coordinates;
        }
        if ((i & 2) != 0) {
            revealEffect = target.revealEffect;
        }
        if ((i & 4) != 0) {
            coachStyle = target.coachStyle;
        }
        if ((i & 8) != 0) {
            alignment = target.alignment;
        }
        if ((i & 16) != 0) {
            z = target.isForcedAlignment;
        }
        if ((i & 32) != 0) {
            function1 = target.content;
        }
        boolean z2 = z;
        Function1 function2 = function1;
        return target.copy(layoutCoordinates, revealEffect, coachStyle, alignment, z2, function2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LayoutCoordinates getCoordinates() {
        return this.coordinates;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RevealEffect getRevealEffect() {
        return this.revealEffect;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CoachStyle getCoachStyle() {
        return this.coachStyle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsForcedAlignment() {
        return this.isForcedAlignment;
    }

    public final Function1<BoxScope, Unit> component6() {
        return this.content;
    }

    public final Target copy(LayoutCoordinates coordinates, RevealEffect revealEffect, CoachStyle coachStyle, Alignment alignment, boolean isForcedAlignment, Function1<? super BoxScope, Unit> content) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(revealEffect, "revealEffect");
        Intrinsics.checkNotNullParameter(coachStyle, "coachStyle");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(content, "content");
        return new Target(coordinates, revealEffect, coachStyle, alignment, isForcedAlignment, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Target)) {
            return false;
        }
        Target target = (Target) other;
        return Intrinsics.areEqual(this.coordinates, target.coordinates) && Intrinsics.areEqual(this.revealEffect, target.revealEffect) && Intrinsics.areEqual(this.coachStyle, target.coachStyle) && Intrinsics.areEqual(this.alignment, target.alignment) && this.isForcedAlignment == target.isForcedAlignment && Intrinsics.areEqual(this.content, target.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((((((this.coordinates.hashCode() * 31) + this.revealEffect.hashCode()) * 31) + this.coachStyle.hashCode()) * 31) + this.alignment.hashCode()) * 31;
        boolean z = this.isForcedAlignment;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.content.hashCode();
    }

    public String toString() {
        return "Target(coordinates=" + this.coordinates + ", revealEffect=" + this.revealEffect + ", coachStyle=" + this.coachStyle + ", alignment=" + this.alignment + ", isForcedAlignment=" + this.isForcedAlignment + ", content=" + this.content + ')';
    }

    public Target(LayoutCoordinates layoutCoordinates, RevealEffect revealEffect, CoachStyle coachStyle, Alignment alignment, boolean z, Function1<? super BoxScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        Intrinsics.checkNotNullParameter(revealEffect, "revealEffect");
        Intrinsics.checkNotNullParameter(coachStyle, "coachStyle");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(function1, "content");
        this.coordinates = layoutCoordinates;
        this.revealEffect = revealEffect;
        this.coachStyle = coachStyle;
        this.alignment = alignment;
        this.isForcedAlignment = z;
        this.content = function1;
    }

    public final LayoutCoordinates getCoordinates() {
        return this.coordinates;
    }

    public /* synthetic */ Target(LayoutCoordinates layoutCoordinates, CircleRevealEffect circleRevealEffect, DefaultCoachStyle defaultCoachStyle, Alignment alignment, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutCoordinates, (i & 2) != 0 ? new CircleRevealEffect() : circleRevealEffect, (i & 4) != 0 ? new DefaultCoachStyle() : defaultCoachStyle, (i & 8) != 0 ? Alignment.Companion.getBottomCenter() : alignment, (i & 16) != 0 ? false : z, function1);
    }

    public final RevealEffect getRevealEffect() {
        return this.revealEffect;
    }

    public final CoachStyle getCoachStyle() {
        return this.coachStyle;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final boolean isForcedAlignment() {
        return this.isForcedAlignment;
    }

    public final Function1<BoxScope, Unit> getContent() {
        return this.content;
    }
}
