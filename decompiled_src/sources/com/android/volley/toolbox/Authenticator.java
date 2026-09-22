package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Authenticator {
    String getAuthToken() throws AuthFailureError;

    void invalidateAuthToken(String str);
}
