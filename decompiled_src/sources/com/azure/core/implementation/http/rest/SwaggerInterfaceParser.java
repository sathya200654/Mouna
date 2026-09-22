package com.azure.core.implementation.http.rest;

import com.azure.core.annotation.Host;
import com.azure.core.annotation.ServiceInterface;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SwaggerInterfaceParser {
    private static final Map<Class<?>, SwaggerInterfaceParser> INTERFACE_PARSERS = new ConcurrentHashMap();
    private final String host;
    private final Map<Method, SwaggerMethodParser> methodParsers = new ConcurrentHashMap();
    private final String serviceName;

    public static SwaggerInterfaceParser getInstance(Class<?> cls) {
        Map<Class<?>, SwaggerInterfaceParser> map = INTERFACE_PARSERS;
        if (map.size() >= 10000) {
            map.clear();
        }
        return map.computeIfAbsent(cls, new Function() { // from class: com.azure.core.implementation.http.rest.SwaggerInterfaceParser$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new SwaggerInterfaceParser((Class) obj);
            }
        });
    }

    SwaggerInterfaceParser(Class<?> cls) {
        Host host = (Host) cls.getAnnotation(Host.class);
        if (host != null && !host.value().isEmpty()) {
            this.host = host.value();
            ServiceInterface serviceInterface = (ServiceInterface) cls.getAnnotation(ServiceInterface.class);
            if (serviceInterface != null && !serviceInterface.name().isEmpty()) {
                this.serviceName = serviceInterface.name();
                return;
            }
            throw new MissingRequiredAnnotationException((Class<? extends Annotation>) ServiceInterface.class, cls);
        }
        throw new MissingRequiredAnnotationException((Class<? extends Annotation>) Host.class, cls);
    }

    public SwaggerMethodParser getMethodParser(Method method) {
        return this.methodParsers.computeIfAbsent(method, new Function() { // from class: com.azure.core.implementation.http.rest.SwaggerInterfaceParser$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1191x82419958((Method) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getMethodParser$0$com-azure-core-implementation-http-rest-SwaggerInterfaceParser, reason: not valid java name */
    /* synthetic */ SwaggerMethodParser m1191x82419958(Method method) {
        return new SwaggerMethodParser(this, method);
    }

    public String getHost() {
        return this.host;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
