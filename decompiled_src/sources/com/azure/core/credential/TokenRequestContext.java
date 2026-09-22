package com.azure.core.credential;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class TokenRequestContext {
    private String claims;
    private boolean enableCae;
    ProofOfPossessionOptions proofOfPossessionOptions;
    private final List<String> scopes = new ArrayList();
    private String tenantId;

    public List<String> getScopes() {
        return this.scopes;
    }

    public TokenRequestContext setScopes(List<String> list) {
        Objects.requireNonNull(list, "'scopes' cannot be null.");
        this.scopes.clear();
        this.scopes.addAll(list);
        return this;
    }

    public TokenRequestContext addScopes(String... strArr) {
        this.scopes.addAll(Arrays.asList(strArr));
        return this;
    }

    public TokenRequestContext setClaims(String str) {
        this.claims = str;
        return this;
    }

    public String getClaims() {
        return this.claims;
    }

    public TokenRequestContext setTenantId(String str) {
        this.tenantId = str;
        return this;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public TokenRequestContext setCaeEnabled(boolean z) {
        this.enableCae = z;
        return this;
    }

    public boolean isCaeEnabled() {
        return this.enableCae;
    }

    public ProofOfPossessionOptions getProofOfPossessionOptions() {
        return this.proofOfPossessionOptions;
    }

    public TokenRequestContext setProofOfPossessionOptions(ProofOfPossessionOptions proofOfPossessionOptions) {
        this.proofOfPossessionOptions = proofOfPossessionOptions;
        return this;
    }
}
