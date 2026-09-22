package androidx.test;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated
public final class InstrumentationRegistry {
    @Deprecated
    public static Instrumentation getInstrumentation() {
        return androidx.test.platform.app.InstrumentationRegistry.getInstrumentation();
    }

    @Deprecated
    public static Bundle getArguments() {
        return androidx.test.platform.app.InstrumentationRegistry.getArguments();
    }

    @Deprecated
    public static Context getContext() {
        return androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().getContext();
    }

    @Deprecated
    public static Context getTargetContext() {
        return androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Deprecated
    public static void registerInstance(Instrumentation instrumentation, Bundle arguments) {
        androidx.test.platform.app.InstrumentationRegistry.registerInstance(instrumentation, arguments);
    }

    private InstrumentationRegistry() {
    }
}
