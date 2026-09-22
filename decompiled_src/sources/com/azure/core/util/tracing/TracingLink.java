package com.azure.core.util.tracing;

import com.azure.core.util.Context;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class TracingLink {
    private final Map<String, Object> attributes;
    private final Context context;

    public TracingLink(Context context) {
        this.context = context;
        this.attributes = null;
    }

    public TracingLink(Context context, Map<String, Object> map) {
        this.context = context;
        this.attributes = map;
    }

    public Context getContext() {
        return this.context;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }
}
