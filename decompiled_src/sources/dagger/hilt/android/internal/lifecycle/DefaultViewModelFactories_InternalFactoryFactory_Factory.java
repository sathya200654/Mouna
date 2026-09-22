package dagger.hilt.android.internal.lifecycle;

import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class DefaultViewModelFactories_InternalFactoryFactory_Factory implements Factory<DefaultViewModelFactories.InternalFactoryFactory> {
    private final Provider<Map<Class<?>, Boolean>> keySetProvider;
    private final Provider<ViewModelComponentBuilder> viewModelComponentBuilderProvider;

    private DefaultViewModelFactories_InternalFactoryFactory_Factory(Provider<Map<Class<?>, Boolean>> keySetProvider, Provider<ViewModelComponentBuilder> viewModelComponentBuilderProvider) {
        this.keySetProvider = keySetProvider;
        this.viewModelComponentBuilderProvider = viewModelComponentBuilderProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DefaultViewModelFactories.InternalFactoryFactory m2263get() {
        return newInstance((Map) this.keySetProvider.get(), (ViewModelComponentBuilder) this.viewModelComponentBuilderProvider.get());
    }

    public static DefaultViewModelFactories_InternalFactoryFactory_Factory create(Provider<Map<Class<?>, Boolean>> keySetProvider, Provider<ViewModelComponentBuilder> viewModelComponentBuilderProvider) {
        return new DefaultViewModelFactories_InternalFactoryFactory_Factory(keySetProvider, viewModelComponentBuilderProvider);
    }

    public static DefaultViewModelFactories.InternalFactoryFactory newInstance(Map<Class<?>, Boolean> keySet, ViewModelComponentBuilder viewModelComponentBuilder) {
        return new DefaultViewModelFactories.InternalFactoryFactory(keySet, viewModelComponentBuilder);
    }
}
