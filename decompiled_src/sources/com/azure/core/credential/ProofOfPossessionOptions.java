package com.azure.core.credential;

import com.azure.core.http.HttpMethod;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ProofOfPossessionOptions {
    private String proofOfPossessionNonce;
    private HttpMethod requestMethod;
    private URL requestUrl;

    public String getProofOfPossessionNonce() {
        return this.proofOfPossessionNonce;
    }

    public ProofOfPossessionOptions setProofOfPossessionNonce(String str) {
        this.proofOfPossessionNonce = str;
        return this;
    }

    public URL getRequestUrl() {
        return this.requestUrl;
    }

    public ProofOfPossessionOptions setRequestUrl(URL url) {
        this.requestUrl = url;
        return this;
    }

    public HttpMethod getRequestMethod() {
        return this.requestMethod;
    }

    public ProofOfPossessionOptions setRequestMethod(HttpMethod httpMethod) {
        this.requestMethod = httpMethod;
        return this;
    }
}
