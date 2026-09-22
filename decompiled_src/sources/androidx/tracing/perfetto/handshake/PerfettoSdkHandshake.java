package androidx.tracing.perfetto.handshake;

import androidx.tracing.perfetto.handshake.protocol.RequestKeys;
import androidx.tracing.perfetto.handshake.protocol.Response;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PerfettoSdkHandshake.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012-\u0010\u0004\u001a)\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t0\u0005\u0012%\u0010\n\u001a!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0012\u0010\u0015\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0016\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0002J-\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010!R-\u0010\n\u001a!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0004\u001a)\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshake;", "", "targetPackage", "", "parseJsonMap", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonString", "", "executeShellCommand", "command", "Landroidx/tracing/perfetto/handshake/ShellCommandExecutor;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "disableTracingColdStart", "Landroidx/tracing/perfetto/handshake/protocol/Response;", "enableTracingColdStart", RequestKeys.KEY_PERSISTENT, "", "librarySource", "Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshake$LibrarySource;", "enableTracingImmediate", "killAppProcess", "", "parseResponse", "rawResponse", "safeExecute", "block", "Lkotlin/Function0;", "sendTracingBroadcast", "action", "libPath", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;Ljava/lang/Boolean;)Landroidx/tracing/perfetto/handshake/protocol/Response;", "LibrarySource", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PerfettoSdkHandshake {
    private final Function1<String, String> executeShellCommand;
    private final Function1<String, Map<String, String>> parseJsonMap;
    private final String targetPackage;

    public final Response enableTracingColdStart() {
        return enableTracingColdStart$default(this, false, null, 3, null);
    }

    public final Response enableTracingColdStart(boolean z) {
        return enableTracingColdStart$default(this, z, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PerfettoSdkHandshake(String str, Function1<? super String, ? extends Map<String, String>> function1, Function1<? super String, String> function2) {
        Intrinsics.checkNotNullParameter(str, "targetPackage");
        Intrinsics.checkNotNullParameter(function1, "parseJsonMap");
        Intrinsics.checkNotNullParameter(function2, "executeShellCommand");
        this.targetPackage = str;
        this.parseJsonMap = function1;
        this.executeShellCommand = function2;
    }

    public static /* synthetic */ Response enableTracingImmediate$default(PerfettoSdkHandshake perfettoSdkHandshake, LibrarySource librarySource, int i, Object obj) {
        if ((i & 1) != 0) {
            librarySource = null;
        }
        return perfettoSdkHandshake.enableTracingImmediate(librarySource);
    }

    public final Response enableTracingImmediate(final LibrarySource librarySource) {
        return safeExecute(new Function0<Response>() { // from class: androidx.tracing.perfetto.handshake.PerfettoSdkHandshake.enableTracingImmediate.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Response m211invoke() throws NoWhenBranchMatchedException {
                File fileSideloadFromZipFile;
                LibrarySource librarySource2 = librarySource;
                if (librarySource2 != null) {
                    PerfettoSdkHandshake perfettoSdkHandshake = this;
                    if (!(librarySource2 instanceof LibrarySource.ZipLibrarySource)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    LibrarySource.ZipLibrarySource zipLibrarySource = (LibrarySource.ZipLibrarySource) librarySource2;
                    fileSideloadFromZipFile = new PerfettoSdkSideloader(perfettoSdkHandshake.targetPackage).sideloadFromZipFile(zipLibrarySource.getLibraryZip(), zipLibrarySource.getTempDirectory(), perfettoSdkHandshake.executeShellCommand, zipLibrarySource.getMoveLibFileFromTmpDirToAppDir$tracing_perfetto_handshake());
                } else {
                    fileSideloadFromZipFile = null;
                }
                return PerfettoSdkHandshake.sendTracingBroadcast$default(this, RequestKeys.ACTION_ENABLE_TRACING, fileSideloadFromZipFile, null, 4, null);
            }
        });
    }

    public static /* synthetic */ Response enableTracingColdStart$default(PerfettoSdkHandshake perfettoSdkHandshake, boolean z, LibrarySource librarySource, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            librarySource = null;
        }
        return perfettoSdkHandshake.enableTracingColdStart(z, librarySource);
    }

    public final Response enableTracingColdStart(final boolean persistent, final LibrarySource librarySource) {
        return safeExecute(new Function0<Response>() { // from class: androidx.tracing.perfetto.handshake.PerfettoSdkHandshake.enableTracingColdStart.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Response m210invoke() throws NoWhenBranchMatchedException, PerfettoSdkHandshakeException {
                File fileSideloadFromZipFile;
                LibrarySource librarySource2 = librarySource;
                if (librarySource2 != null) {
                    PerfettoSdkHandshake perfettoSdkHandshake = this;
                    if (!(librarySource2 instanceof LibrarySource.ZipLibrarySource)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    LibrarySource.ZipLibrarySource zipLibrarySource = (LibrarySource.ZipLibrarySource) librarySource2;
                    fileSideloadFromZipFile = new PerfettoSdkSideloader(perfettoSdkHandshake.targetPackage).sideloadFromZipFile(zipLibrarySource.getLibraryZip(), zipLibrarySource.getTempDirectory(), perfettoSdkHandshake.executeShellCommand, zipLibrarySource.getMoveLibFileFromTmpDirToAppDir$tracing_perfetto_handshake());
                } else {
                    fileSideloadFromZipFile = null;
                }
                this.killAppProcess();
                Response responseSendTracingBroadcast = this.sendTracingBroadcast(RequestKeys.ACTION_ENABLE_TRACING_COLD_START, fileSideloadFromZipFile, Boolean.valueOf(persistent));
                this.killAppProcess();
                return responseSendTracingBroadcast;
            }
        });
    }

    public final Response disableTracingColdStart() {
        return safeExecute(new Function0<Response>() { // from class: androidx.tracing.perfetto.handshake.PerfettoSdkHandshake.disableTracingColdStart.1
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Response m209invoke() throws PerfettoSdkHandshakeException {
                Response responseSendTracingBroadcast$default = PerfettoSdkHandshake.sendTracingBroadcast$default(PerfettoSdkHandshake.this, RequestKeys.ACTION_DISABLE_TRACING_COLD_START, null, null, 6, null);
                PerfettoSdkHandshake.this.killAppProcess();
                return responseSendTracingBroadcast$default;
            }
        });
    }

    static /* synthetic */ Response sendTracingBroadcast$default(PerfettoSdkHandshake perfettoSdkHandshake, String str, File file, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            file = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return perfettoSdkHandshake.sendTracingBroadcast(str, file, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Response sendTracingBroadcast(String action, File libPath, Boolean persistent) throws PerfettoSdkHandshakeException {
        StringBuilder sb = new StringBuilder("am broadcast -a " + action);
        if (persistent != null) {
            sb.append(" --es persistent " + persistent);
        }
        if (libPath != null) {
            sb.append(" --es path " + libPath);
        }
        sb.append(" " + this.targetPackage + "/androidx.tracing.perfetto.TracingReceiver");
        Function1<String, String> function1 = this.executeShellCommand;
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "commandBuilder.toString()");
        String str = (String) function1.invoke(string);
        try {
            return parseResponse(str);
        } catch (Exception e) {
            throw new PerfettoSdkHandshakeException("Exception occurred while trying to parse a response. Error: " + e.getMessage() + ". Raw response: " + str + '.');
        }
    }

    private final Response parseResponse(String rawResponse) throws PerfettoSdkHandshakeException {
        Object next;
        Object next2;
        String value;
        String strSubstringAfter$default;
        String strDropLast;
        MatchGroup matchGroup;
        String value2;
        String value3;
        String strSubstringAfter$default2;
        Iterator it = new Regex("\r?\n").split(rawResponse, 0).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt.contains$default((String) next, "Broadcast completed: result=", false, 2, (Object) null));
        String str = (String) next;
        if (str == null) {
            throw new PerfettoSdkHandshakeException("Cannot parse: " + rawResponse);
        }
        if (Intrinsics.areEqual(str, "Broadcast completed: result=0")) {
            return new Response(0, null, null);
        }
        MatchResult matchResultMatchEntire = new Regex("Broadcast completed: (result=.*?)(, data=\".*?\")?(, extras: .*)?").matchEntire(str);
        if (matchResultMatchEntire == null) {
            throw new PerfettoSdkHandshakeException("Cannot parse: " + rawResponse);
        }
        MatchGroup matchGroup2 = matchResultMatchEntire.getGroups().get(1);
        Integer intOrNull = (matchGroup2 == null || (value3 = matchGroup2.getValue()) == null || (strSubstringAfter$default2 = StringsKt.substringAfter$default(value3, "result=", (String) null, 2, (Object) null)) == null) ? null : StringsKt.toIntOrNull(strSubstringAfter$default2);
        Iterator it2 = matchResultMatchEntire.getGroups().iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            matchGroup = (MatchGroup) next2;
        } while (!((matchGroup == null || (value2 = matchGroup.getValue()) == null) ? false : StringsKt.startsWith$default(value2, ", data=", false, 2, (Object) null)));
        MatchGroup matchGroup3 = (MatchGroup) next2;
        if (matchGroup3 == null || (value = matchGroup3.getValue()) == null || (strSubstringAfter$default = StringsKt.substringAfter$default(value, ", data=\"", (String) null, 2, (Object) null)) == null || (strDropLast = StringsKt.dropLast(strSubstringAfter$default, 1)) == null) {
            throw new PerfettoSdkHandshakeException("Cannot parse: " + rawResponse + ". Unable to detect 'data=' section.");
        }
        Map map = (Map) this.parseJsonMap.invoke(strDropLast);
        String str2 = (String) map.get(ResponseKeys.KEY_RESULT_CODE);
        if (str2 == null) {
            throw new PerfettoSdkHandshakeException("Response missing exitCode value");
        }
        int i = Integer.parseInt(str2);
        String str3 = (String) map.get(ResponseKeys.KEY_REQUIRED_VERSION);
        if (str3 != null) {
            Response response = new Response(i, str3, (String) map.get(ResponseKeys.KEY_MESSAGE));
            int resultCode = response.getResultCode();
            if (intOrNull == null || intOrNull.intValue() != resultCode) {
                throw new PerfettoSdkHandshakeException("Cannot parse: " + rawResponse + ". Result code not matching broadcast result code.");
            }
            return response;
        }
        throw new PerfettoSdkHandshakeException("Response missing requiredVersion value");
    }

    private final Response safeExecute(Function0<Response> block) {
        try {
            return (Response) block.invoke();
        } catch (Exception e) {
            return new Response(99, null, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void killAppProcess() throws PerfettoSdkHandshakeException {
        String str;
        if (StringsKt.contains$default((CharSequence) this.executeShellCommand.invoke("id"), "uid=0(root)", false, 2, (Object) null)) {
            str = (String) this.executeShellCommand.invoke("killall " + this.targetPackage);
        } else {
            str = (String) this.executeShellCommand.invoke("am force-stop " + this.targetPackage);
        }
        String str2 = str;
        if (!StringsKt.isBlank(str2) && !StringsKt.contains$default(str2, "No such process", false, 2, (Object) null)) {
            throw new PerfettoSdkHandshakeException("Issue while trying to kill app process: " + str);
        }
    }

    /* JADX INFO: compiled from: PerfettoSdkHandshake.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshake$LibrarySource;", "", "()V", "Companion", "ZipLibrarySource", "Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshake$LibrarySource$ZipLibrarySource;", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LibrarySource {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ LibrarySource(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static final LibrarySource aarLibrarySource(File file, File file2, Function2<? super File, ? super File, Unit> function2) {
            return INSTANCE.aarLibrarySource(file, file2, function2);
        }

        @JvmStatic
        public static final LibrarySource apkLibrarySource(File file, File file2, Function2<? super File, ? super File, Unit> function2) {
            return INSTANCE.apkLibrarySource(file, file2, function2);
        }

        private LibrarySource() {
        }

        /* JADX INFO: compiled from: PerfettoSdkHandshake.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012:\u0010\u0005\u001a6\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\f¢\u0006\u0002\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRH\u0010\u0005\u001a6\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshake$LibrarySource$ZipLibrarySource;", "Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshake$LibrarySource;", "libraryZip", "Ljava/io/File;", "tempDirectory", "moveLibFileFromTmpDirToAppDir", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "srcFile", "dstFile", "", "Landroidx/tracing/perfetto/handshake/FileMover;", "(Ljava/io/File;Ljava/io/File;Lkotlin/jvm/functions/Function2;)V", "getLibraryZip$tracing_perfetto_handshake", "()Ljava/io/File;", "getMoveLibFileFromTmpDirToAppDir$tracing_perfetto_handshake", "()Lkotlin/jvm/functions/Function2;", "getTempDirectory$tracing_perfetto_handshake", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ZipLibrarySource extends LibrarySource {
            private final File libraryZip;
            private final Function2<File, File, Unit> moveLibFileFromTmpDirToAppDir;
            private final File tempDirectory;

            /* JADX INFO: renamed from: getLibraryZip$tracing_perfetto_handshake, reason: from getter */
            public final File getLibraryZip() {
                return this.libraryZip;
            }

            /* JADX INFO: renamed from: getTempDirectory$tracing_perfetto_handshake, reason: from getter */
            public final File getTempDirectory() {
                return this.tempDirectory;
            }

            public final Function2<File, File, Unit> getMoveLibFileFromTmpDirToAppDir$tracing_perfetto_handshake() {
                return this.moveLibFileFromTmpDirToAppDir;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ZipLibrarySource(File file, File file2, Function2<? super File, ? super File, Unit> function2) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "libraryZip");
                Intrinsics.checkNotNullParameter(file2, "tempDirectory");
                Intrinsics.checkNotNullParameter(function2, "moveLibFileFromTmpDirToAppDir");
                this.libraryZip = file;
                this.tempDirectory = file2;
                this.moveLibFileFromTmpDirToAppDir = function2;
            }
        }

        /* JADX INFO: compiled from: PerfettoSdkHandshake.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062:\u0010\b\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fH\u0007JT\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062:\u0010\b\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fH\u0007¨\u0006\u0012"}, d2 = {"Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshake$LibrarySource$Companion;", "", "()V", "aarLibrarySource", "Landroidx/tracing/perfetto/handshake/PerfettoSdkHandshake$LibrarySource;", "aarFile", "Ljava/io/File;", "tempDirectory", "moveLibFileFromTmpDirToAppDir", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "srcFile", "dstFile", "", "Landroidx/tracing/perfetto/handshake/FileMover;", "apkLibrarySource", "apkFile", "tracing-perfetto-handshake"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final LibrarySource aarLibrarySource(File aarFile, File tempDirectory, Function2<? super File, ? super File, Unit> moveLibFileFromTmpDirToAppDir) {
                Intrinsics.checkNotNullParameter(aarFile, "aarFile");
                Intrinsics.checkNotNullParameter(tempDirectory, "tempDirectory");
                Intrinsics.checkNotNullParameter(moveLibFileFromTmpDirToAppDir, "moveLibFileFromTmpDirToAppDir");
                return new ZipLibrarySource(aarFile, tempDirectory, moveLibFileFromTmpDirToAppDir);
            }

            @JvmStatic
            public final LibrarySource apkLibrarySource(File apkFile, File tempDirectory, Function2<? super File, ? super File, Unit> moveLibFileFromTmpDirToAppDir) {
                Intrinsics.checkNotNullParameter(apkFile, "apkFile");
                Intrinsics.checkNotNullParameter(tempDirectory, "tempDirectory");
                Intrinsics.checkNotNullParameter(moveLibFileFromTmpDirToAppDir, "moveLibFileFromTmpDirToAppDir");
                return new ZipLibrarySource(apkFile, tempDirectory, moveLibFileFromTmpDirToAppDir);
            }
        }
    }
}
