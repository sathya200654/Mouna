package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen;

import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawerContent.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0001HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/components/appscreen/DrawerItem;", "", "labelRes", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "route", "<init>", "(ILandroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/Object;)V", "getLabelRes", "()I", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getRoute", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DrawerItem {
    public static final int $stable = 8;
    private final ImageVector icon;
    private final int labelRes;
    private final Object route;

    public static /* synthetic */ DrawerItem copy$default(DrawerItem drawerItem, int i, ImageVector imageVector, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = drawerItem.labelRes;
        }
        if ((i2 & 2) != 0) {
            imageVector = drawerItem.icon;
        }
        if ((i2 & 4) != 0) {
            obj = drawerItem.route;
        }
        return drawerItem.copy(i, imageVector, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLabelRes() {
        return this.labelRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImageVector getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getRoute() {
        return this.route;
    }

    public final DrawerItem copy(int labelRes, ImageVector icon, Object route) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(route, "route");
        return new DrawerItem(labelRes, icon, route);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawerItem)) {
            return false;
        }
        DrawerItem drawerItem = (DrawerItem) other;
        return this.labelRes == drawerItem.labelRes && Intrinsics.areEqual(this.icon, drawerItem.icon) && Intrinsics.areEqual(this.route, drawerItem.route);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.labelRes) * 31) + this.icon.hashCode()) * 31) + this.route.hashCode();
    }

    public String toString() {
        return "DrawerItem(labelRes=" + this.labelRes + ", icon=" + this.icon + ", route=" + this.route + ")";
    }

    public DrawerItem(int i, ImageVector imageVector, Object obj) {
        Intrinsics.checkNotNullParameter(imageVector, "icon");
        Intrinsics.checkNotNullParameter(obj, "route");
        this.labelRes = i;
        this.icon = imageVector;
        this.route = obj;
    }

    public final int getLabelRes() {
        return this.labelRes;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    public final Object getRoute() {
        return this.route;
    }
}
