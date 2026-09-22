package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.ServiceVersion;
import com.azure.core.util.UserAgentUtil;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class UserAgentPolicy implements HttpPipelinePolicy {
    public static final String APPEND_USER_AGENT_CONTEXT_KEY = "Append-User-Agent";
    public static final String OVERRIDE_USER_AGENT_CONTEXT_KEY = "Override-User-Agent";
    private final HttpPipelineSyncPolicy inner;
    private final String userAgent;

    public UserAgentPolicy() {
        this(null);
    }

    public UserAgentPolicy(String str) {
        this.inner = new HttpPipelineSyncPolicy() { // from class: com.azure.core.http.policy.UserAgentPolicy.1
            @Override // com.azure.core.http.policy.HttpPipelineSyncPolicy
            protected void beforeSendingRequest(HttpPipelineCallContext httpPipelineCallContext) {
                String str2 = (String) httpPipelineCallContext.getData(UserAgentPolicy.OVERRIDE_USER_AGENT_CONTEXT_KEY).orElse(null);
                String str3 = (String) httpPipelineCallContext.getData(UserAgentPolicy.APPEND_USER_AGENT_CONTEXT_KEY).orElse(null);
                if (CoreUtils.isNullOrEmpty(str2)) {
                    str2 = !CoreUtils.isNullOrEmpty(str3) ? UserAgentPolicy.this.userAgent + " " + str3 : UserAgentPolicy.this.userAgent;
                }
                httpPipelineCallContext.getHttpRequest().setHeader(HttpHeaderName.USER_AGENT, str2);
            }
        };
        if (str != null) {
            this.userAgent = str;
        } else {
            this.userAgent = UserAgentUtil.DEFAULT_USER_AGENT_HEADER;
        }
    }

    public UserAgentPolicy(String str, String str2, String str3, Configuration configuration) {
        this.inner = new HttpPipelineSyncPolicy() { // from class: com.azure.core.http.policy.UserAgentPolicy.1
            @Override // com.azure.core.http.policy.HttpPipelineSyncPolicy
            protected void beforeSendingRequest(HttpPipelineCallContext httpPipelineCallContext) {
                String str4 = (String) httpPipelineCallContext.getData(UserAgentPolicy.OVERRIDE_USER_AGENT_CONTEXT_KEY).orElse(null);
                String str5 = (String) httpPipelineCallContext.getData(UserAgentPolicy.APPEND_USER_AGENT_CONTEXT_KEY).orElse(null);
                if (CoreUtils.isNullOrEmpty(str4)) {
                    str4 = !CoreUtils.isNullOrEmpty(str5) ? UserAgentPolicy.this.userAgent + " " + str5 : UserAgentPolicy.this.userAgent;
                }
                httpPipelineCallContext.getHttpRequest().setHeader(HttpHeaderName.USER_AGENT, str4);
            }
        };
        this.userAgent = UserAgentUtil.toUserAgentString(str, str2, str3, configuration);
    }

    @Deprecated
    public UserAgentPolicy(String str, String str2, Configuration configuration, ServiceVersion serviceVersion) {
        this.inner = new HttpPipelineSyncPolicy() { // from class: com.azure.core.http.policy.UserAgentPolicy.1
            @Override // com.azure.core.http.policy.HttpPipelineSyncPolicy
            protected void beforeSendingRequest(HttpPipelineCallContext httpPipelineCallContext) {
                String str4 = (String) httpPipelineCallContext.getData(UserAgentPolicy.OVERRIDE_USER_AGENT_CONTEXT_KEY).orElse(null);
                String str5 = (String) httpPipelineCallContext.getData(UserAgentPolicy.APPEND_USER_AGENT_CONTEXT_KEY).orElse(null);
                if (CoreUtils.isNullOrEmpty(str4)) {
                    str4 = !CoreUtils.isNullOrEmpty(str5) ? UserAgentPolicy.this.userAgent + " " + str5 : UserAgentPolicy.this.userAgent;
                }
                httpPipelineCallContext.getHttpRequest().setHeader(HttpHeaderName.USER_AGENT, str4);
            }
        };
        this.userAgent = UserAgentUtil.toUserAgentString(null, str, str2, configuration);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        return this.inner.process(httpPipelineCallContext, httpPipelineNextPolicy);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        return this.inner.processSync(httpPipelineCallContext, httpPipelineNextSyncPolicy);
    }
}
