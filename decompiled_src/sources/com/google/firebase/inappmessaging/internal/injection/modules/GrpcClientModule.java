package com.google.firebase.inappmessaging.internal.injection.modules;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.common.io.BaseEncoding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class GrpcClientModule {
    private final FirebaseApp firebaseApp;

    public GrpcClientModule(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    @Provides
    public Metadata providesApiKeyHeaders() {
        Metadata.Key keyOf = Metadata.Key.of("X-Goog-Api-Key", Metadata.ASCII_STRING_MARSHALLER);
        Metadata.Key keyOf2 = Metadata.Key.of("X-Android-Package", Metadata.ASCII_STRING_MARSHALLER);
        Metadata.Key keyOf3 = Metadata.Key.of("X-Android-Cert", Metadata.ASCII_STRING_MARSHALLER);
        Metadata metadata = new Metadata();
        String packageName = this.firebaseApp.getApplicationContext().getPackageName();
        metadata.put(keyOf, this.firebaseApp.getOptions().getApiKey());
        metadata.put(keyOf2, packageName);
        String signature = getSignature(this.firebaseApp.getApplicationContext().getPackageManager(), packageName);
        if (signature != null) {
            metadata.put(keyOf3, signature);
        }
        return metadata;
    }

    public static String getSignature(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length != 0 && packageInfo.signatures[0] != null) {
                return signatureDigest(packageInfo.signatures[0]);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String signatureDigest(Signature signature) {
        try {
            return BaseEncoding.base16().upperCase().encode(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Provides
    public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub providesInAppMessagingSdkServingStub(Channel channel, Metadata metadata) {
        return InAppMessagingSdkServingGrpc.newBlockingStub(ClientInterceptors.intercept(channel, MetadataUtils.newAttachHeadersInterceptor(metadata)));
    }
}
