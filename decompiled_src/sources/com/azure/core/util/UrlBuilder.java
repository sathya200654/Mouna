package com.azure.core.util;

import androidx.webkit.ProxyConfig;
import com.azure.core.implementation.ImplUtils;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UrlBuilder {
    private static final URL HTTP;
    private static final URL HTTPS;
    private static final Map<String, UrlBuilder> PARSED_URLS = new ConcurrentHashMap();
    private String host;
    private String path;
    private Integer port;
    private Map<String, QueryParameter> query;
    private Map<String, QueryParameter> queryToCopy;
    private String scheme;

    static {
        try {
            HTTP = new URL("http://azure.com");
            HTTPS = new URL("https://azure.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public UrlBuilder() {
        this(null);
    }

    private UrlBuilder(Map<String, QueryParameter> map) {
        this.queryToCopy = map;
    }

    public UrlBuilder setScheme(String str) {
        if (str == null || str.isEmpty()) {
            this.scheme = null;
            return this;
        }
        with(str, UrlTokenizerState.SCHEME);
        return this;
    }

    public String getScheme() {
        return this.scheme;
    }

    public UrlBuilder setHost(String str) {
        if (str == null || str.isEmpty()) {
            this.host = null;
            return this;
        }
        with(str, UrlTokenizerState.SCHEME_OR_HOST);
        return this;
    }

    public String getHost() {
        return this.host;
    }

    public UrlBuilder setPort(String str) {
        if (CoreUtils.isNullOrEmpty(str)) {
            this.port = null;
            return this;
        }
        return with(str, UrlTokenizerState.PORT);
    }

    public UrlBuilder setPort(int i) {
        this.port = Integer.valueOf(i);
        return this;
    }

    public Integer getPort() {
        return this.port;
    }

    public UrlBuilder setPath(String str) {
        if (str == null || str.isEmpty()) {
            this.path = null;
            return this;
        }
        with(str, UrlTokenizerState.PATH);
        return this;
    }

    public String getPath() {
        return this.path;
    }

    public UrlBuilder setQueryParameter(String str, String str2) {
        initializeQuery();
        this.query.put(str, new QueryParameter(str, str2));
        return this;
    }

    public UrlBuilder addQueryParameter(final String str, final String str2) {
        initializeQuery();
        this.query.compute(str, new BiFunction() { // from class: com.azure.core.util.UrlBuilder$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return UrlBuilder.lambda$addQueryParameter$0(str, str2, (String) obj, (QueryParameter) obj2);
            }
        });
        return this;
    }

    static /* synthetic */ QueryParameter lambda$addQueryParameter$0(String str, String str2, String str3, QueryParameter queryParameter) {
        if (queryParameter == null) {
            return new QueryParameter(str, str2);
        }
        queryParameter.addValue(str2);
        return queryParameter;
    }

    public UrlBuilder setQuery(String str) {
        return (str == null || str.isEmpty()) ? clearQuery() : with(str, UrlTokenizerState.QUERY);
    }

    public UrlBuilder clearQuery() {
        if (CoreUtils.isNullOrEmpty(this.query)) {
            return this;
        }
        this.query.clear();
        return this;
    }

    public Map<String, String> getQuery() {
        initializeQuery();
        return (Map) this.query.entrySet().stream().collect(Collectors.toMap(new Function() { // from class: com.azure.core.util.UrlBuilder$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getKey();
            }
        }, new Function() { // from class: com.azure.core.util.UrlBuilder$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((QueryParameter) ((Map.Entry) obj).getValue()).getValue();
            }
        }));
    }

    public String getQueryString() {
        if (CoreUtils.isNullOrEmpty(this.queryToCopy) && CoreUtils.isNullOrEmpty(this.query)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        appendQueryString(sb);
        return sb.toString();
    }

    private void appendQueryString(StringBuilder sb) {
        if (CoreUtils.isNullOrEmpty(this.queryToCopy) && CoreUtils.isNullOrEmpty(this.query)) {
            return;
        }
        sb.append('?');
        Map<String, QueryParameter> map = this.query;
        boolean zWriteQueryValues = true;
        if (map == null) {
            this.query = new LinkedHashMap(this.queryToCopy.size());
            for (Map.Entry<String, QueryParameter> entry : this.queryToCopy.entrySet()) {
                zWriteQueryValues = writeQueryValues(sb, entry.getKey(), entry.getValue().getValuesList(), zWriteQueryValues);
                this.query.put(entry.getKey(), entry.getValue());
            }
            return;
        }
        for (Map.Entry<String, QueryParameter> entry2 : map.entrySet()) {
            zWriteQueryValues = writeQueryValues(sb, entry2.getKey(), entry2.getValue().getValuesList(), zWriteQueryValues);
        }
    }

    private static boolean writeQueryValues(StringBuilder sb, String str, List<String> list, boolean z) {
        for (String str2 : list) {
            if (!z) {
                sb.append('&');
            }
            sb.append(str).append('=').append(str2);
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UrlBuilder with(String str, UrlTokenizerState urlTokenizerState) {
        UrlTokenizer urlTokenizer = new UrlTokenizer(str, urlTokenizerState);
        while (urlTokenizer.next()) {
            UrlToken urlTokenCurrent = urlTokenizer.current();
            String strEmptyToNull = emptyToNull(urlTokenCurrent.text());
            int i = AnonymousClass1.$SwitchMap$com$azure$core$util$UrlTokenType[urlTokenCurrent.type().ordinal()];
            if (i == 1) {
                this.scheme = strEmptyToNull;
            } else if (i == 2) {
                this.host = strEmptyToNull;
            } else if (i == 3) {
                this.port = strEmptyToNull == null ? null : Integer.valueOf(Integer.parseInt(strEmptyToNull));
            } else if (i == 4) {
                String str2 = this.path;
                if (str2 == null || RemoteSettings.FORWARD_SLASH_STRING.equals(str2) || !RemoteSettings.FORWARD_SLASH_STRING.equals(strEmptyToNull)) {
                    this.path = strEmptyToNull;
                }
            } else if (i == 5) {
                CoreUtils.parseQueryParameters(strEmptyToNull).forEachRemaining(new Consumer() { // from class: com.azure.core.util.UrlBuilder$$ExternalSyntheticLambda4
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m1241lambda$with$2$comazurecoreutilUrlBuilder((Map.Entry) obj);
                    }
                });
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: com.azure.core.util.UrlBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$azure$core$util$UrlTokenType;

        static {
            int[] iArr = new int[UrlTokenType.values().length];
            $SwitchMap$com$azure$core$util$UrlTokenType = iArr;
            try {
                iArr[UrlTokenType.SCHEME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenType[UrlTokenType.HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenType[UrlTokenType.PORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenType[UrlTokenType.PATH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenType[UrlTokenType.QUERY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: lambda$with$2$com-azure-core-util-UrlBuilder, reason: not valid java name */
    /* synthetic */ void m1241lambda$with$2$comazurecoreutilUrlBuilder(Map.Entry entry) {
        addQueryParameter((String) entry.getKey(), (String) entry.getValue());
    }

    public URL toUrl() throws MalformedURLException {
        if (ProxyConfig.MATCH_HTTP.equals(this.scheme)) {
            return new URL(HTTP, toString());
        }
        if (ProxyConfig.MATCH_HTTPS.equals(this.scheme)) {
            return new URL(HTTPS, toString());
        }
        return ImplUtils.createUrl(toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.path;
        if (str == null || (!str.startsWith("http://") && !this.path.startsWith("https://"))) {
            String str2 = this.scheme;
            if (str2 != null) {
                sb.append(str2);
                if (!this.scheme.endsWith("://")) {
                    sb.append("://");
                }
            }
            String str3 = this.host;
            if (str3 != null) {
                sb.append(str3);
            }
        }
        if (this.port != null) {
            sb.append(':');
            sb.append(this.port);
        }
        if (this.path != null) {
            if (sb.length() != 0 && !this.path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                sb.append(JsonPointer.SEPARATOR);
            }
            sb.append(this.path);
        }
        appendQueryString(sb);
        return sb.toString();
    }

    static Map<String, UrlBuilder> getParsedUrls() {
        return PARSED_URLS;
    }

    public static UrlBuilder parse(String str) {
        if (str == null) {
            str = "";
        }
        Map<String, UrlBuilder> map = PARSED_URLS;
        if (map.size() >= 10000) {
            map.clear();
        }
        return map.computeIfAbsent(str, new Function() { // from class: com.azure.core.util.UrlBuilder$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new UrlBuilder().with((String) obj, UrlTokenizerState.SCHEME_OR_HOST);
            }
        }).copy();
    }

    public static UrlBuilder parse(URL url) {
        return ImplUtils.parseUrl(url, true);
    }

    private static String emptyToNull(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return str;
    }

    private UrlBuilder copy() {
        UrlBuilder urlBuilder = new UrlBuilder(this.query);
        urlBuilder.scheme = this.scheme;
        urlBuilder.host = this.host;
        urlBuilder.path = this.path;
        urlBuilder.port = this.port;
        return urlBuilder;
    }

    private void initializeQuery() {
        if (this.query == null) {
            this.query = new LinkedHashMap();
        }
        Map<String, QueryParameter> map = this.queryToCopy;
        if (map != null) {
            this.query.putAll(map);
            this.queryToCopy = null;
        }
    }
}
