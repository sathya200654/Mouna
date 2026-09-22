package com.azure.core.util.tracing;

import com.azure.core.util.Context;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class StartSpanOptions {
    private List<TracingLink> links;
    private Context parentContext;
    private Map<String, Object> spanAttributes;
    private final SpanKind spanKind;
    private Instant startTimeStamp;

    public StartSpanOptions(SpanKind spanKind) {
        Objects.requireNonNull(spanKind, "'kind' cannot be null.");
        this.spanKind = spanKind;
        this.spanAttributes = null;
        this.startTimeStamp = null;
        this.parentContext = null;
    }

    public StartSpanOptions setAttribute(String str, Object obj) {
        if (this.spanAttributes == null) {
            this.spanAttributes = new HashMap();
        }
        this.spanAttributes.put(str, obj);
        return this;
    }

    public StartSpanOptions setStartTimestamp(Instant instant) {
        this.startTimeStamp = instant;
        return this;
    }

    public Instant getStartTimestamp() {
        return this.startTimeStamp;
    }

    public StartSpanOptions setRemoteParent(Context context) {
        this.parentContext = context;
        return this;
    }

    public Context getRemoteParent() {
        return this.parentContext;
    }

    public StartSpanOptions addLink(TracingLink tracingLink) {
        if (this.links == null) {
            this.links = new ArrayList();
        }
        this.links.add(tracingLink);
        return this;
    }

    public SpanKind getSpanKind() {
        return this.spanKind;
    }

    public Map<String, Object> getAttributes() {
        return this.spanAttributes;
    }

    public List<TracingLink> getLinks() {
        return this.links;
    }
}
