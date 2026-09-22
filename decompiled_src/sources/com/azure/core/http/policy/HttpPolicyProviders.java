package com.azure.core.http.policy;

import com.azure.core.implementation.http.policy.InstrumentationPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpPolicyProviders {
    private static final List<AfterRetryPolicyProvider> AFTER_PROVIDER;
    private static final List<BeforeRetryPolicyProvider> BEFORE_PROVIDER;
    private static final String INVALID_POLICY = "HttpPipelinePolicy created with %s resulted in a null policy.";

    static {
        final ArrayList arrayList = new ArrayList();
        BEFORE_PROVIDER = arrayList;
        final ArrayList arrayList2 = new ArrayList();
        AFTER_PROVIDER = arrayList2;
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(BeforeRetryPolicyProvider.class, HttpPolicyProviders.class.getClassLoader());
        Objects.requireNonNull(arrayList);
        serviceLoaderLoad.forEach(new Consumer() { // from class: com.azure.core.http.policy.HttpPolicyProviders$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.add((BeforeRetryPolicyProvider) obj);
            }
        });
        ServiceLoader serviceLoaderLoad2 = ServiceLoader.load(AfterRetryPolicyProvider.class, HttpPolicyProviders.class.getClassLoader());
        Objects.requireNonNull(arrayList2);
        serviceLoaderLoad2.forEach(new Consumer() { // from class: com.azure.core.http.policy.HttpPolicyProviders$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList2.add((AfterRetryPolicyProvider) obj);
            }
        });
    }

    private HttpPolicyProviders() {
    }

    public static void addBeforeRetryPolicies(List<HttpPipelinePolicy> list) {
        addPolices(list, BEFORE_PROVIDER);
    }

    public static void addAfterRetryPolicies(List<HttpPipelinePolicy> list) {
        list.add(new InstrumentationPolicy());
        addPolices(list, AFTER_PROVIDER);
    }

    private static void addPolices(List<HttpPipelinePolicy> list, List<? extends HttpPolicyProvider> list2) {
        for (HttpPolicyProvider httpPolicyProvider : list2) {
            HttpPipelinePolicy httpPipelinePolicyCreate = httpPolicyProvider.create();
            if (httpPipelinePolicyCreate == null) {
                throw new NullPointerException(String.format(INVALID_POLICY, httpPolicyProvider.getClass()));
            }
            list.add(httpPipelinePolicyCreate);
        }
    }
}
