package com.azure.core.implementation.http;

import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.UrlBuilder;
import java.net.URL;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UrlSanitizer {
    private final Predicate<String> canLogQueryParam;

    public UrlSanitizer(Collection<String> collection) {
        final String str = "api-version";
        if (CoreUtils.isNullOrEmpty(collection)) {
            this.canLogQueryParam = new Predicate() { // from class: com.azure.core.implementation.http.UrlSanitizer$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return str.equalsIgnoreCase((String) obj);
                }
            };
            return;
        }
        final Set set = (Set) collection.stream().map(new Function() { // from class: com.azure.core.implementation.http.UrlSanitizer$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).toLowerCase(Locale.ROOT);
            }
        }).collect(Collectors.toSet());
        set.add("api-version");
        this.canLogQueryParam = new Predicate() { // from class: com.azure.core.implementation.http.UrlSanitizer$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return set.contains(((String) obj).toLowerCase(Locale.ROOT));
            }
        };
    }

    public String getRedactedUrl(URL url) {
        String query = url.getQuery();
        if (CoreUtils.isNullOrEmpty(query)) {
            return url.toString();
        }
        final UrlBuilder url2 = ImplUtils.parseUrl(url, false);
        CoreUtils.parseQueryParameters(query).forEachRemaining(new Consumer() { // from class: com.azure.core.implementation.http.UrlSanitizer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m1166xe36b7c08(url2, (Map.Entry) obj);
            }
        });
        return url2.toString();
    }

    /* JADX INFO: renamed from: lambda$getRedactedUrl$2$com-azure-core-implementation-http-UrlSanitizer, reason: not valid java name */
    /* synthetic */ void m1166xe36b7c08(UrlBuilder urlBuilder, Map.Entry entry) {
        if (this.canLogQueryParam.test((String) entry.getKey())) {
            urlBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
        } else {
            urlBuilder.addQueryParameter((String) entry.getKey(), LoggingKeys.REDACTED_PLACEHOLDER);
        }
    }
}
