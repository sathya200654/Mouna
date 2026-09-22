package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ProxyAnalyticsConnector implements AnalyticsConnector {
    private volatile Object instance;

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
    }

    public int getMaxUserProperties(String str) {
        return 0;
    }

    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
    }

    public ProxyAnalyticsConnector(Deferred<AnalyticsConnector> deferred) {
        this.instance = deferred;
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector$$ExternalSyntheticLambda0
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                this.f$0.m2036x45aa62b7(provider);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-google-firebase-inappmessaging-internal-ProxyAnalyticsConnector, reason: not valid java name */
    /* synthetic */ void m2036x45aa62b7(Provider provider) {
        this.instance = provider.get();
    }

    private AnalyticsConnector safeGet() {
        Object obj = this.instance;
        if (obj instanceof AnalyticsConnector) {
            return (AnalyticsConnector) obj;
        }
        return null;
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        AnalyticsConnector analyticsConnectorSafeGet = safeGet();
        if (analyticsConnectorSafeGet != null) {
            analyticsConnectorSafeGet.logEvent(str, str2, bundle);
        }
    }

    public void setUserProperty(String str, String str2, Object obj) {
        AnalyticsConnector analyticsConnectorSafeGet = safeGet();
        if (analyticsConnectorSafeGet != null) {
            analyticsConnectorSafeGet.setUserProperty(str, str2, obj);
        }
    }

    public Map<String, Object> getUserProperties(boolean z) {
        return Collections.emptyMap();
    }

    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj = this.instance;
        if (obj instanceof AnalyticsConnector) {
            return ((AnalyticsConnector) obj).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
        }
        return new ProxyAnalyticsConnectorHandle(str, analyticsConnectorListener, (Deferred) obj);
    }

    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ProxyAnalyticsConnectorHandle implements AnalyticsConnector.AnalyticsConnectorHandle {
        private static final Object UNREGISTERED = new Object();
        private Set<String> eventNames;
        private volatile Object instance;

        private ProxyAnalyticsConnectorHandle(final String str, final AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, Deferred<AnalyticsConnector> deferred) {
            this.eventNames = new HashSet();
            deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector$ProxyAnalyticsConnectorHandle$$ExternalSyntheticLambda0
                @Override // com.google.firebase.inject.Deferred.DeferredHandler
                public final void handle(Provider provider) {
                    this.f$0.m2037xb77d9fb0(str, analyticsConnectorListener, provider);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$new$0$com-google-firebase-inappmessaging-internal-ProxyAnalyticsConnector$ProxyAnalyticsConnectorHandle, reason: not valid java name */
        /* synthetic */ void m2037xb77d9fb0(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, Provider provider) {
            if (this.instance == UNREGISTERED) {
                return;
            }
            AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener = ((AnalyticsConnector) provider.get()).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
            this.instance = analyticsConnectorHandleRegisterAnalyticsConnectorListener;
            synchronized (this) {
                if (!this.eventNames.isEmpty()) {
                    analyticsConnectorHandleRegisterAnalyticsConnectorListener.registerEventNames(this.eventNames);
                    this.eventNames = new HashSet();
                }
            }
        }

        public void unregister() {
            Object obj = this.instance;
            Object obj2 = UNREGISTERED;
            if (obj == obj2) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregister();
            }
            this.instance = obj2;
            synchronized (this) {
                this.eventNames.clear();
            }
        }

        public void registerEventNames(Set<String> set) {
            Object obj = this.instance;
            if (obj == UNREGISTERED) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).registerEventNames(set);
            } else {
                synchronized (this) {
                    this.eventNames.addAll(set);
                }
            }
        }

        public void unregisterEventNames() {
            Object obj = this.instance;
            if (obj == UNREGISTERED) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregisterEventNames();
            } else {
                synchronized (this) {
                    this.eventNames.clear();
                }
            }
        }
    }
}
