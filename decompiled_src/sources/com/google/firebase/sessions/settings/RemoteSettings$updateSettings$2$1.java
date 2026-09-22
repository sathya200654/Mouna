package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: compiled from: RemoteSettings.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {0, 0, 0, 1, 1, 2}, l = {132, 135, 138, 140, 141, 143}, m = "invokeSuspend", n = {"sessionSamplingRate", "sessionTimeoutSeconds", "cacheDuration", "sessionSamplingRate", "cacheDuration", "cacheDuration"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    public final Object invoke(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        return create(jSONObject, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:48:0x011d A[PHI: r0 r1
  0x011d: PHI (r0v9 kotlin.jvm.internal.Ref$ObjectRef) = 
  (r0v5 kotlin.jvm.internal.Ref$ObjectRef)
  (r0v5 kotlin.jvm.internal.Ref$ObjectRef)
  (r0v11 kotlin.jvm.internal.Ref$ObjectRef)
 binds: [B:44:0x00fb, B:46:0x0119, B:10:0x0032] A[DONT_GENERATE, DONT_INLINE]
  0x011d: PHI (r1v11 kotlin.jvm.internal.Ref$ObjectRef) = 
  (r1v6 kotlin.jvm.internal.Ref$ObjectRef)
  (r1v6 kotlin.jvm.internal.Ref$ObjectRef)
  (r1v15 kotlin.jvm.internal.Ref$ObjectRef)
 binds: [B:44:0x00fb, B:46:0x0119, B:10:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x0123  */
    /* JADX WARN: Code duplicated, block: B:53:0x0142 A[PHI: r0
  0x0142: PHI (r0v12 kotlin.jvm.internal.Ref$ObjectRef) = 
  (r0v9 kotlin.jvm.internal.Ref$ObjectRef)
  (r0v9 kotlin.jvm.internal.Ref$ObjectRef)
  (r0v16 kotlin.jvm.internal.Ref$ObjectRef)
 binds: [B:49:0x0121, B:51:0x013f, B:9:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x0148  */
    /* JADX WARN: Code duplicated, block: B:59:0x016a  */
    /* JADX WARN: Code duplicated, block: B:61:0x016d  */
    /* JADX WARN: Code duplicated, block: B:64:0x018a  */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0164, code lost:
    
        if (r13.updateSessionCacheDuration(r0, r12) == r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a8, code lost:
    
        if (r12.this$0.getSettingsCache().updateSessionCacheUpdatedTime(kotlin.coroutines.jvm.internal.Boxing.boxLong(java.lang.System.currentTimeMillis()), (kotlin.coroutines.Continuation) r12) == r4) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
