package com.azure.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class Contexts {
    private Context context;

    private Contexts(Context context) {
        this.context = (Context) Objects.requireNonNull(context, "'context' must not be null");
    }

    public static Contexts empty() {
        return with(Context.NONE);
    }

    public static Contexts with(Context context) {
        return new Contexts(context);
    }

    public Contexts setHttpRequestProgressReporter(ProgressReporter progressReporter) {
        this.context = this.context.addData(Keys.HTTP_REQUEST_PROGRESS_REPORTER, progressReporter);
        return this;
    }

    public ProgressReporter getHttpRequestProgressReporter() {
        return (ProgressReporter) this.context.getData(Keys.HTTP_REQUEST_PROGRESS_REPORTER).orElse(null);
    }

    public Context getContext() {
        return this.context;
    }

    private static final class Keys {
        public static final String HTTP_REQUEST_PROGRESS_REPORTER = "com.azure.core.http.request.progress.reporter";

        private Keys() {
        }
    }
}
