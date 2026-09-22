package com.azure.core.implementation.util;

import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class Providers<TProvider, TInstance> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) Providers.class);
    private final Map<String, TProvider> availableProviders;
    private final String defaultImplementation;
    private final TProvider defaultProvider;
    private final String defaultProviderName;
    private final boolean noDefaultImplementation;
    private final String noProviderMessage;
    private final Class<TProvider> providerClass;

    public Providers(Class<TProvider> cls, String str, String str2) {
        Throwable e;
        this.providerClass = cls;
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(cls, Providers.class.getClassLoader());
        this.availableProviders = new HashMap();
        TProvider tprovider = null;
        String str3 = null;
        for (Object obj : serviceLoaderLoad) {
            try {
                String name = obj.getClass().getName();
                this.availableProviders.put(name, (TProvider) obj);
                if (tprovider == null) {
                    try {
                        LOGGER.atVerbose().addKeyValue("providerName", name).addKeyValue("providerClass", cls.getName()).log("Loaded default provider.");
                        tprovider = (TProvider) obj;
                        str3 = name;
                    } catch (LinkageError | ServiceConfigurationError e2) {
                        e = e2;
                        str3 = name;
                        LOGGER.atWarning().log(new Supplier() { // from class: com.azure.core.implementation.util.Providers$$ExternalSyntheticLambda0
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                return Providers.lambda$new$0();
                            }
                        }, e);
                        tprovider = (TProvider) obj;
                    }
                } else {
                    LOGGER.atVerbose().addKeyValue("providerName", name).log("Additional provider found on the classpath");
                }
            } catch (LinkageError | ServiceConfigurationError e3) {
                obj = tprovider;
                e = e3;
            }
        }
        this.defaultProvider = tprovider;
        this.defaultProviderName = str3;
        this.defaultImplementation = str;
        this.noDefaultImplementation = CoreUtils.isNullOrEmpty(str);
        this.noProviderMessage = str2;
    }

    static /* synthetic */ String lambda$new$0() {
        return "Failed to load a provider instance.";
    }

    private String formatNoSpecificProviderErrorMessage(String str) {
        return "A request was made to use a specific " + this.providerClass.getSimpleName() + " but it wasn't found on the classpath. If you're using a dependency manager ensure you're including the dependency that provides the specific implementation. If you're including the specific implementation ensure that the " + this.providerClass.getSimpleName() + " service it supplies is being included in the 'META-INF/services' file '" + this.providerClass.getName() + "'. The requested provider was: " + str + ".";
    }

    public TInstance create(Function<TProvider, TInstance> function, TInstance tinstance, Class<? extends TProvider> cls) {
        String name;
        TProvider tprovider;
        if (cls == null && this.noDefaultImplementation) {
            name = this.defaultProviderName;
            tprovider = this.defaultProvider;
            if (tprovider == null) {
                if (tinstance != null) {
                    return tinstance;
                }
                throw LOGGER.logExceptionAsError(new IllegalStateException(this.noProviderMessage));
            }
        } else {
            name = cls == null ? this.defaultImplementation : cls.getName();
            tprovider = this.availableProviders.get(name);
            if (tprovider == null) {
                throw LOGGER.logExceptionAsError(new IllegalStateException(formatNoSpecificProviderErrorMessage(name)));
            }
        }
        try {
            return function.apply(tprovider);
        } catch (ClassCastException e) {
            throw LOGGER.logExceptionAsError(new IllegalStateException(formatNoSpecificProviderErrorMessage(name), e));
        }
    }
}
