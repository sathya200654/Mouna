package coil3.network.okhttp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: OkHttpNetworkFetcher.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4 extends FunctionReferenceImpl implements Function0<OkHttpClient> {
    public static final OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4 INSTANCE = new OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4();

    OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4() {
        super(0, OkHttpClient.class, "<init>", "<init>()V", 0);
    }

    public final OkHttpClient invoke() {
        return new OkHttpClient();
    }
}
