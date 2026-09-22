package androidx.test.platform.io;

import android.os.Bundle;
import android.util.Log;
import androidx.test.platform.app.InstrumentationRegistry;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class FileTestStorage implements PlatformTestStorage {
    private static final String TAG = "FileTestStorage";
    private final OutputDirCalculator outputDirCalculator = new OutputDirCalculator();

    @Override // androidx.test.platform.io.PlatformTestStorage
    public InputStream openInputFile(String pathname) throws IOException {
        File file = new File(pathname);
        if (file.isAbsolute()) {
            return new FileInputStream(file);
        }
        return InstrumentationRegistry.getInstrumentation().getContext().getAssets().open(pathname);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openOutputFile(String pathname) throws IOException {
        File file = new File(pathname);
        if (!file.isAbsolute()) {
            file = new File(this.outputDirCalculator.getOutputDir(), pathname);
        }
        return new FileOutputStream(file);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openOutputFile(String pathname, boolean append) throws IOException {
        File file = new File(pathname);
        if (!file.isAbsolute()) {
            file = new File(this.outputDirCalculator.getOutputDir(), pathname);
        }
        return new FileOutputStream(file, append);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public String getInputArg(String argName) {
        return InstrumentationRegistry.getArguments().getString(argName);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public Map<String, String> getInputArgs() {
        HashMap map = new HashMap();
        Bundle arguments = InstrumentationRegistry.getArguments();
        for (String str : arguments.keySet()) {
            map.put(str, arguments.getString(str));
        }
        return map;
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public void addOutputProperties(Map<String, Serializable> properties) {
        Log.w(TAG, "Output properties is not supported.");
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public Map<String, Serializable> getOutputProperties() {
        Log.w(TAG, "Output properties is not supported.");
        return Collections.emptyMap();
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public InputStream openInternalInputFile(String pathname) throws IOException {
        return openInputFile(pathname);
    }

    @Override // androidx.test.platform.io.PlatformTestStorage
    public OutputStream openInternalOutputFile(String pathname) throws IOException {
        return openOutputFile(pathname);
    }
}
