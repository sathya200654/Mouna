package androidx.wear.compose.material;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeText.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/wear/compose/material/TimeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "onTimeChanged", "Lkotlin/Function0;", "", "onTimeZoneChanged", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnTimeChanged", "()Lkotlin/jvm/functions/Function0;", "getOnTimeZoneChanged", "registered", "", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "register", "unregister", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TimeBroadcastReceiver extends BroadcastReceiver {
    private final Function0<Unit> onTimeChanged;
    private final Function0<Unit> onTimeZoneChanged;
    private boolean registered;

    public final Function0<Unit> getOnTimeChanged() {
        return this.onTimeChanged;
    }

    public final Function0<Unit> getOnTimeZoneChanged() {
        return this.onTimeZoneChanged;
    }

    public TimeBroadcastReceiver(Function0<Unit> function0, Function0<Unit> function1) {
        this.onTimeChanged = function0;
        this.onTimeZoneChanged = function1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.TIMEZONE_CHANGED")) {
            this.onTimeZoneChanged.invoke();
        } else {
            this.onTimeChanged.invoke();
        }
    }

    public final void register(Context context) {
        if (this.registered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        context.registerReceiver(this, intentFilter);
        this.registered = true;
    }

    public final void unregister(Context context) {
        if (this.registered) {
            context.unregisterReceiver(this);
            this.registered = false;
        }
    }
}
