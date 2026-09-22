package com.deepvisiontech.letstalksigntranscriptionapp.legacy.network;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VolleySingleton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/network/VolleySingleton;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "requestQueue", "Lcom/android/volley/RequestQueue;", "getRequestQueue", "()Lcom/android/volley/RequestQueue;", "requestQueue$delegate", "Lkotlin/Lazy;", "addToRequestQueue", "", "T", "req", "Lcom/android/volley/Request;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VolleySingleton {
    private static volatile VolleySingleton INSTANCE;

    /* JADX INFO: renamed from: requestQueue$delegate, reason: from kotlin metadata */
    private final Lazy requestQueue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ VolleySingleton(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    /* JADX INFO: compiled from: VolleySingleton.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/network/VolleySingleton$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/network/VolleySingleton;", "getInstance", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VolleySingleton getInstance(Context context) {
            VolleySingleton volleySingleton;
            Intrinsics.checkNotNullParameter(context, "context");
            VolleySingleton volleySingleton2 = VolleySingleton.INSTANCE;
            if (volleySingleton2 != null) {
                return volleySingleton2;
            }
            synchronized (this) {
                volleySingleton = VolleySingleton.INSTANCE;
                if (volleySingleton == null) {
                    volleySingleton = new VolleySingleton(context, null);
                    Companion companion = VolleySingleton.INSTANCE;
                    VolleySingleton.INSTANCE = volleySingleton;
                }
            }
            return volleySingleton;
        }
    }

    private VolleySingleton(final Context context) {
        this.requestQueue = LazyKt.lazy(new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.legacy.network.VolleySingleton$$ExternalSyntheticLambda0
            public final Object invoke() {
                return VolleySingleton.requestQueue_delegate$lambda$0(context);
            }
        });
    }

    private final RequestQueue getRequestQueue() {
        return (RequestQueue) this.requestQueue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestQueue requestQueue_delegate$lambda$0(Context context) {
        RequestQueue requestQueueNewRequestQueue;
        try {
            requestQueueNewRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        } catch (Exception e) {
            Log.e("VolleySingleton", "Error initializing request queue", e);
            requestQueueNewRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        Intrinsics.checkNotNull(requestQueueNewRequestQueue);
        return requestQueueNewRequestQueue;
    }

    public final <T> void addToRequestQueue(Request<T> req) {
        Intrinsics.checkNotNullParameter(req, "req");
        try {
            getRequestQueue().add(req);
        } catch (Exception e) {
            Log.e("VolleySingleton", "Error adding request to queue", e);
        }
    }
}
