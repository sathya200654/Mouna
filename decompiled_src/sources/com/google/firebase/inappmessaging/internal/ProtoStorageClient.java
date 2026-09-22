package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ProtoStorageClient {
    private final Application application;
    private final String fileName;

    public ProtoStorageClient(Application application, String str) {
        this.application = application;
        this.fileName = str;
    }

    public Completable write(final AbstractMessageLite abstractMessageLite) {
        return Completable.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.ProtoStorageClient$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m2034xb45a41fd(abstractMessageLite);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$write$0$com-google-firebase-inappmessaging-internal-ProtoStorageClient, reason: not valid java name */
    /* synthetic */ Object m2034xb45a41fd(AbstractMessageLite abstractMessageLite) throws Exception {
        synchronized (this) {
            FileOutputStream fileOutputStreamOpenFileOutput = this.application.openFileOutput(this.fileName, 0);
            try {
                fileOutputStreamOpenFileOutput.write(abstractMessageLite.toByteArray());
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return abstractMessageLite;
    }

    public <T extends AbstractMessageLite> Maybe<T> read(final Parser<T> parser) {
        return Maybe.fromCallable(new Callable() { // from class: com.google.firebase.inappmessaging.internal.ProtoStorageClient$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m2033xe77c986b(parser);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$read$1$com-google-firebase-inappmessaging-internal-ProtoStorageClient, reason: not valid java name */
    /* synthetic */ AbstractMessageLite m2033xe77c986b(Parser parser) throws Exception {
        AbstractMessageLite abstractMessageLite;
        synchronized (this) {
            try {
                FileInputStream fileInputStreamOpenFileInput = this.application.openFileInput(this.fileName);
                try {
                    abstractMessageLite = (AbstractMessageLite) parser.parseFrom(fileInputStreamOpenFileInput);
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                } catch (Throwable th) {
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (InvalidProtocolBufferException | FileNotFoundException e) {
                Logging.logi("Recoverable exception while reading cache: " + e.getMessage());
                return null;
            }
        }
        return abstractMessageLite;
    }
}
