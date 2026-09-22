package com.google.firebase.crashlytics.internal.concurrency;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CrashlyticsWorkers.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class CrashlyticsWorkers$Companion$checkNotMainThread$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    CrashlyticsWorkers$Companion$checkNotMainThread$1(Object obj) {
        super(0, obj, CrashlyticsWorkers.Companion.class, "isNotMainThread", "isNotMainThread()Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m1942invoke() {
        return Boolean.valueOf(((CrashlyticsWorkers.Companion) this.receiver).isNotMainThread());
    }
}
