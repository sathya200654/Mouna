package dagger.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class Providers {
    public static <T> Provider<T> asDaggerProvider(final javax.inject.Provider<T> provider) {
        Preconditions.checkNotNull(provider);
        if (provider instanceof Provider) {
            return (Provider) provider;
        }
        return new Provider<T>() { // from class: dagger.internal.Providers.1
            public T get() {
                return (T) provider.get();
            }
        };
    }

    private Providers() {
    }
}
