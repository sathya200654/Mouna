package androidx.tracing.perfetto.handshake;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PerfettoSdkSideloader.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0002J/\u0010\n\u001a\u00020\u00032%\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\fj\u0002`\u0010H\u0002Jy\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062%\u0010\u0014\u001a!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\fj\u0002`\u00102:\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0016j\u0002`\u001aJL\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062:\u0010\u001d\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0016j\u0002`\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/tracing/perfetto/handshake/PerfettoSdkSideloader;", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "(Ljava/lang/String;)V", "extractPerfettoBinaryFromZip", "Ljava/io/File;", "sourceZip", "outputDir", "abi", "getDeviceAbi", "executeShellCommand", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "command", "Landroidx/tracing/perfetto/handshake/ShellCommandExecutor;", "sideloadFromZipFile", "sourceZipFile", "tempDirectory", "shellCommandExecutor", "moveLibFileFromTmpDirToAppDir", "Lkotlin/Function2;", "srcFile", "dstFile", "", "Landroidx/tracing/perfetto/handshake/FileMover;", "sideloadSoFile", "libFile", "moveLibFileToAppDir", "Companion", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PerfettoSdkSideloader {
    private static final Companion Companion = new Companion(null);
    private static final String libFileName = "libtracing_perfetto.so";
    private final String packageName;

    public PerfettoSdkSideloader(String str) {
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        this.packageName = str;
    }

    public final File sideloadFromZipFile(File sourceZipFile, File tempDirectory, Function1<? super String, String> shellCommandExecutor, Function2<? super File, ? super File, Unit> moveLibFileFromTmpDirToAppDir) {
        Intrinsics.checkNotNullParameter(sourceZipFile, "sourceZipFile");
        Intrinsics.checkNotNullParameter(tempDirectory, "tempDirectory");
        Intrinsics.checkNotNullParameter(shellCommandExecutor, "shellCommandExecutor");
        Intrinsics.checkNotNullParameter(moveLibFileFromTmpDirToAppDir, "moveLibFileFromTmpDirToAppDir");
        return sideloadSoFile(extractPerfettoBinaryFromZip(sourceZipFile, tempDirectory, getDeviceAbi(shellCommandExecutor)), moveLibFileFromTmpDirToAppDir);
    }

    private final File sideloadSoFile(File libFile, Function2<? super File, ? super File, Unit> moveLibFileToAppDir) {
        File fileLibFileForPackageName = Companion.libFileForPackageName(this.packageName);
        moveLibFileToAppDir.invoke(libFile, fileLibFileForPackageName);
        return fileLibFileForPackageName;
    }

    private final File extractPerfettoBinaryFromZip(File sourceZip, File outputDir, String abi) throws IOException {
        Object next;
        String name;
        File fileResolve = FilesKt.resolve(outputDir, libFileName);
        Regex regex = new Regex(".*(lib|jni)/[^/]*" + abi + "[^/]*/libtracing_perfetto.so");
        ZipFile zipFile = new ZipFile(sourceZip);
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Intrinsics.checkNotNullExpressionValue(enumerationEntries, "zipFile\n            .entries()");
        Iterator it = SequencesKt.asSequence(CollectionsKt.iterator(enumerationEntries)).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            name = ((ZipEntry) next).getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
        } while (!regex.matches(name));
        ZipEntry zipEntry = (ZipEntry) next;
        if (zipEntry == null) {
            throw new IllegalStateException("Unable to locate libtracing_perfetto.so required to enable Perfetto SDK. Tried inside " + sourceZip.getAbsolutePath() + '.');
        }
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        try {
            InputStream inputStream2 = inputStream;
            FileOutputStream fileOutputStream = new FileOutputStream(fileResolve);
            try {
                Intrinsics.checkNotNullExpressionValue(inputStream2, "inputStream");
                ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, (Object) null);
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                CloseableKt.closeFinally(inputStream, (Throwable) null);
                return fileResolve;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStream, th3);
                throw th4;
            }
        }
    }

    private final String getDeviceAbi(Function1<? super String, String> executeShellCommand) {
        return StringsKt.trim((String) CollectionsKt.first(CollectionsKt.plus(StringsKt.split$default((CharSequence) executeShellCommand.invoke("getprop ro.product.cpu.abilist"), new String[]{","}, false, 0, 6, (Object) null), executeShellCommand.invoke("getprop ro.product.cpu.abi")))).toString();
    }

    /* JADX INFO: compiled from: PerfettoSdkSideloader.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/tracing/perfetto/handshake/PerfettoSdkSideloader$Companion;", "", "()V", "libFileName", "", "libFileForPackageName", "Ljava/io/File;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File libFileForPackageName(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
            return new File("/sdcard/Android/media/" + packageName + "/libtracing_perfetto.so");
        }
    }
}
