package com.android.volley;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class NetworkError extends VolleyError {
    public NetworkError() {
    }

    public NetworkError(Throwable th) {
        super(th);
    }

    public NetworkError(NetworkResponse networkResponse) {
        super(networkResponse);
    }
}
