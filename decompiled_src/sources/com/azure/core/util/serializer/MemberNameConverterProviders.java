package com.azure.core.util.serializer;

import java.util.Iterator;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class MemberNameConverterProviders {
    private static final String CANNOT_FIND_MEMBER_NAME_CONVERTER_PROVIDER = "Cannot find any member name converter provider on the classpath.";
    private static boolean attemptedLoad;
    private static MemberNameConverterProvider defaultProvider;

    public static MemberNameConverter createInstance() {
        if (defaultProvider == null) {
            loadFromClasspath();
        }
        return defaultProvider.createInstance();
    }

    private static synchronized void loadFromClasspath() {
        boolean z = attemptedLoad;
        if (!z || defaultProvider == null) {
            if (z) {
                throw new IllegalStateException(CANNOT_FIND_MEMBER_NAME_CONVERTER_PROVIDER);
            }
            attemptedLoad = true;
            Iterator it = ServiceLoader.load(MemberNameConverterProvider.class, MemberNameConverterProviders.class.getClassLoader()).iterator();
            if (it.hasNext()) {
                defaultProvider = (MemberNameConverterProvider) it.next();
                return;
            }
            throw new IllegalStateException(CANNOT_FIND_MEMBER_NAME_CONVERTER_PROVIDER);
        }
    }

    private MemberNameConverterProviders() {
    }
}
