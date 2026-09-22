package com.deepvisiontech.letstalksigntranscriptionapp.legacy.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UsageUtils.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"getAppVersionDetails", "Lkotlin/Pair;", "", "", "context", "Landroid/content/Context;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UsageUtilsKt {
    public static final Pair<String, Integer> getAppVersionDetails(Context context) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
                Intrinsics.checkNotNull(packageInfo);
            } else {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                Intrinsics.checkNotNull(packageInfo);
            }
            return new Pair<>(packageInfo.versionName, Integer.valueOf((int) packageInfo.getLongVersionCode()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
