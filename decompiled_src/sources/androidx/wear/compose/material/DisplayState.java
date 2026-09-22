package androidx.wear.compose.material;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/wear/compose/material/DisplayState;", "", "position", "", "size", "visibility", "Landroidx/wear/compose/material/PositionIndicatorVisibility;", "(FFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPosition", "()F", "getSize", "getVisibility-GLQwCHQ", "()I", "I", "equals", "", "other", "hashCode", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DisplayState {
    public static final int $stable = 0;
    private final float position;
    private final float size;
    private final int visibility;

    public /* synthetic */ DisplayState(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, i);
    }

    private DisplayState(float f, float f2, int i) {
        this.position = f;
        this.size = f2;
        this.visibility = i;
    }

    public final float getPosition() {
        return this.position;
    }

    public final float getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: getVisibility-GLQwCHQ, reason: not valid java name and from getter */
    public final int getVisibility() {
        return this.visibility;
    }

    public int hashCode() {
        return (((Float.hashCode(this.position) * 31) + Float.hashCode(this.size)) * 31) + PositionIndicatorVisibility.m721hashCodeimpl(this.visibility);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DisplayState displayState = (DisplayState) other;
        return this.position == displayState.position && this.size == displayState.size && PositionIndicatorVisibility.m720equalsimpl0(this.visibility, displayState.visibility);
    }
}
