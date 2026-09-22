package com.azure.core.http;

import com.azure.core.implementation.util.HttpHeadersAccessHelper;
import com.azure.core.util.CoreUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpHeaders implements Iterable<HttpHeader> {
    private final Map<String, HttpHeader> headers;

    static {
        HttpHeadersAccessHelper.setAccessor(new HttpHeadersAccessHelper.HttpHeadersAccessor() { // from class: com.azure.core.http.HttpHeaders.1
            @Override // com.azure.core.implementation.util.HttpHeadersAccessHelper.HttpHeadersAccessor
            public Map<String, HttpHeader> getRawHeaderMap(HttpHeaders httpHeaders) {
                return httpHeaders.headers;
            }

            @Override // com.azure.core.implementation.util.HttpHeadersAccessHelper.HttpHeadersAccessor
            public void addInternal(HttpHeaders httpHeaders, String str, String str2, String str3) {
                httpHeaders.addInternal(str, str2, str3);
            }

            @Override // com.azure.core.implementation.util.HttpHeadersAccessHelper.HttpHeadersAccessor
            public void setInternal(HttpHeaders httpHeaders, String str, String str2, List<String> list) {
                httpHeaders.setInternal(str, str2, list);
            }
        });
    }

    public HttpHeaders() {
        this.headers = new HashMap();
    }

    public HttpHeaders(Map<String, String> map) {
        this.headers = new HashMap(map.size());
        map.forEach(new BiConsumer() { // from class: com.azure.core.http.HttpHeaders$$ExternalSyntheticLambda2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.set((String) obj, (String) obj2);
            }
        });
    }

    public HttpHeaders(Iterable<HttpHeader> iterable) {
        this.headers = new HashMap();
        for (HttpHeader httpHeader : iterable) {
            set(httpHeader.getName(), httpHeader.getValuesList());
        }
    }

    HttpHeaders(HttpHeaders httpHeaders) {
        this.headers = new HashMap((int) (httpHeaders.headers.size() / 0.75f));
        httpHeaders.headers.forEach(new BiConsumer() { // from class: com.azure.core.http.HttpHeaders$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m1120lambda$new$0$comazurecorehttpHttpHeaders((String) obj, (HttpHeader) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-azure-core-http-HttpHeaders, reason: not valid java name */
    /* synthetic */ void m1120lambda$new$0$comazurecorehttpHttpHeaders(String str, HttpHeader httpHeader) {
        this.headers.put(str, new HttpHeader(httpHeader.getName(), httpHeader.getValuesList()));
    }

    public HttpHeaders(int i) {
        this.headers = new HashMap(i);
    }

    public int getSize() {
        return this.headers.size();
    }

    @Deprecated
    public HttpHeaders add(String str, String str2) {
        return addInternal(formatKey(str), str, str2);
    }

    public HttpHeaders add(HttpHeaderName httpHeaderName, String str) {
        return addInternal(httpHeaderName.getCaseInsensitiveName(), httpHeaderName.getCaseSensitiveName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpHeaders addInternal(String str, final String str2, final String str3) {
        if (str2 != null && str3 != null) {
            this.headers.compute(str, new BiFunction() { // from class: com.azure.core.http.HttpHeaders$$ExternalSyntheticLambda1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return HttpHeaders.lambda$addInternal$1(str2, str3, (String) obj, (HttpHeader) obj2);
                }
            });
        }
        return this;
    }

    static /* synthetic */ HttpHeader lambda$addInternal$1(String str, String str2, String str3, HttpHeader httpHeader) {
        if (httpHeader == null) {
            return new HttpHeader(str, str2);
        }
        httpHeader.addValue(str2);
        return httpHeader;
    }

    @Deprecated
    public HttpHeaders put(String str, String str2) {
        return set(str, str2);
    }

    @Deprecated
    public HttpHeaders set(String str, String str2) {
        return setInternal(formatKey(str), str, str2);
    }

    public HttpHeaders set(HttpHeaderName httpHeaderName, String str) {
        return setInternal(httpHeaderName.getCaseInsensitiveName(), httpHeaderName.getCaseSensitiveName(), str);
    }

    private HttpHeaders setInternal(String str, String str2, String str3) {
        if (str2 == null) {
            return this;
        }
        if (str3 == null) {
            removeInternal(str2);
            return this;
        }
        this.headers.put(str, new HttpHeader(str2, str3));
        return this;
    }

    @Deprecated
    public HttpHeaders set(String str, List<String> list) {
        return setInternal(formatKey(str), str, list);
    }

    public HttpHeaders set(HttpHeaderName httpHeaderName, List<String> list) {
        return setInternal(httpHeaderName.getCaseInsensitiveName(), httpHeaderName.getCaseSensitiveName(), list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpHeaders setInternal(String str, String str2, List<String> list) {
        if (str == null) {
            return this;
        }
        if (CoreUtils.isNullOrEmpty(list)) {
            removeInternal(str);
            return this;
        }
        this.headers.put(str, new HttpHeader(str2, list));
        return this;
    }

    public HttpHeaders setAll(Map<String, List<String>> map) {
        map.forEach(new BiConsumer() { // from class: com.azure.core.http.HttpHeaders$$ExternalSyntheticLambda4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.set((String) obj, (List<String>) obj2);
            }
        });
        return this;
    }

    public HttpHeaders setAllHttpHeaders(HttpHeaders httpHeaders) {
        if (httpHeaders != null) {
            httpHeaders.headers.forEach(new BiConsumer() { // from class: com.azure.core.http.HttpHeaders$$ExternalSyntheticLambda3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f$0.m1121lambda$setAllHttpHeaders$2$comazurecorehttpHttpHeaders((String) obj, (HttpHeader) obj2);
                }
            });
        }
        return this;
    }

    /* JADX INFO: renamed from: lambda$setAllHttpHeaders$2$com-azure-core-http-HttpHeaders, reason: not valid java name */
    /* synthetic */ void m1121lambda$setAllHttpHeaders$2$comazurecorehttpHttpHeaders(String str, HttpHeader httpHeader) {
        setInternal(str, httpHeader.getName(), httpHeader.getValuesList());
    }

    @Deprecated
    public HttpHeader get(String str) {
        return getInternal(formatKey(str));
    }

    public HttpHeader get(HttpHeaderName httpHeaderName) {
        return getInternal(httpHeaderName.getCaseInsensitiveName());
    }

    private HttpHeader getInternal(String str) {
        return this.headers.get(str);
    }

    @Deprecated
    public HttpHeader remove(String str) {
        return removeInternal(formatKey(str));
    }

    public HttpHeader remove(HttpHeaderName httpHeaderName) {
        return removeInternal(httpHeaderName.getCaseInsensitiveName());
    }

    private HttpHeader removeInternal(String str) {
        return this.headers.remove(str);
    }

    @Deprecated
    public String getValue(String str) {
        return getValueInternal(formatKey(str));
    }

    public String getValue(HttpHeaderName httpHeaderName) {
        return getValueInternal(httpHeaderName.getCaseInsensitiveName());
    }

    private String getValueInternal(String str) {
        HttpHeader internal = getInternal(str);
        if (internal == null) {
            return null;
        }
        return internal.getValue();
    }

    @Deprecated
    public String[] getValues(String str) {
        return getValuesInternal(formatKey(str));
    }

    public String[] getValues(HttpHeaderName httpHeaderName) {
        return getValuesInternal(httpHeaderName.getCaseInsensitiveName());
    }

    private String[] getValuesInternal(String str) {
        HttpHeader internal = getInternal(str);
        if (internal == null) {
            return null;
        }
        return internal.getValues();
    }

    public Map<String, String> toMap() {
        HashMap map = new HashMap();
        for (HttpHeader httpHeader : this.headers.values()) {
            map.put(httpHeader.getName(), httpHeader.getValue());
        }
        return Collections.unmodifiableMap(map);
    }

    Map<String, String[]> toMultiMap() {
        HashMap map = new HashMap();
        for (HttpHeader httpHeader : this.headers.values()) {
            map.put(httpHeader.getName(), httpHeader.getValues());
        }
        return Collections.unmodifiableMap(map);
    }

    @Override // java.lang.Iterable
    public Iterator<HttpHeader> iterator() {
        return this.headers.values().iterator();
    }

    public Stream<HttpHeader> stream() {
        return this.headers.values().stream();
    }

    public String toString() {
        return (String) stream().map(new Function() { // from class: com.azure.core.http.HttpHeaders$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HttpHeaders.lambda$toString$3((HttpHeader) obj);
            }
        }).collect(Collectors.joining(", "));
    }

    static /* synthetic */ String lambda$toString$3(HttpHeader httpHeader) {
        return httpHeader.getName() + "=" + httpHeader.getValue();
    }

    private static String formatKey(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.ROOT);
    }
}
