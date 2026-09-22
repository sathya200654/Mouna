package com.google.firebase.inappmessaging.ktx;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InAppMessaging.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"inAppMessaging", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessaging;", "Lcom/google/firebase/ktx/Firebase;", "getInAppMessaging", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/inappmessaging/FirebaseInAppMessaging;", "com.google.firebase-firebase-inappmessaging"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InAppMessagingKt {
    public static final FirebaseInAppMessaging getInAppMessaging(Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseInAppMessaging firebaseInAppMessaging = FirebaseInAppMessaging.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseInAppMessaging, "getInstance()");
        return firebaseInAppMessaging;
    }
}
