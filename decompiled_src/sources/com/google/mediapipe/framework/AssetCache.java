package com.google.mediapipe.framework;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.common.flogger.FluentLogger;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class AssetCache {
    static final String MEDIAPIPE_ASSET_CACHE_DIR = "mediapipe_asset_cache";
    private static AssetCache assetCache;
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private int appVersionCode;
    private Context context;
    private AssetCacheDbHelper versionDatabase;

    public static synchronized AssetCache create(Context context) {
        Preconditions.checkNotNull(context);
        if (assetCache == null) {
            assetCache = new AssetCache(context);
        }
        return assetCache;
    }

    public static synchronized void purgeCache(Context context) {
        AssetCacheDbHelper assetCacheDbHelper = new AssetCacheDbHelper(context);
        assetCacheDbHelper.invalidateCache(-1);
        assetCacheDbHelper.close();
    }

    @Nullable
    public static synchronized AssetCache getAssetCache() {
        return assetCache;
    }

    public synchronized void loadAllAssets(String assetsPath) {
        String[] list;
        Preconditions.checkNotNull(assetsPath);
        try {
            list = this.context.getAssets().list(assetsPath);
        } catch (IOException e) {
            logger.atSevere().withCause(e).log("Unable to get files in assets path: %s", assetsPath);
            list = null;
        }
        if (list != null && list.length != 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(assetsPath)) {
                    str = assetsPath + RemoteSettings.FORWARD_SLASH_STRING + str;
                }
                getAbsolutePathFromAsset(str);
            }
            return;
        }
        logger.atWarning().log("No files to load");
    }

    public synchronized String getAbsolutePathFromAsset(String assetPath) {
        InputStream inputStreamOpen;
        int i;
        AssetManager assets = this.context.getAssets();
        File defaultMediaPipeCacheDir = getDefaultMediaPipeCacheDir();
        defaultMediaPipeCacheDir.mkdir();
        File file = new File(defaultMediaPipeCacheDir.getPath(), new File(assetPath).getName());
        if (file.exists() && (i = this.appVersionCode) != 0 && this.versionDatabase.checkVersion(assetPath, i)) {
            return file.getAbsolutePath();
        }
        try {
            inputStreamOpen = assets.open(assetPath);
            try {
                writeStreamToFile(inputStreamOpen, file);
                if (this.appVersionCode != 0) {
                    this.versionDatabase.insertAsset(assetPath, file.getAbsolutePath(), this.appVersionCode);
                }
                return file.getAbsolutePath();
            } catch (IOException e) {
                e = e;
                logger.atSevere().withCause(e).log("Unable to unpack: %s", assetPath);
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused) {
                        return null;
                    }
                }
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamOpen = null;
        }
    }

    public synchronized String[] getAvailableAssets() {
        File defaultMediaPipeCacheDir = getDefaultMediaPipeCacheDir();
        if (defaultMediaPipeCacheDir.exists()) {
            return defaultMediaPipeCacheDir.list();
        }
        return new String[0];
    }

    public File getDefaultMediaPipeCacheDir() {
        return new File(this.context.getCacheDir(), MEDIAPIPE_ASSET_CACHE_DIR);
    }

    private AssetCache(Context context) {
        this.context = context;
        this.versionDatabase = new AssetCacheDbHelper(context);
        try {
            this.appVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            logger.atInfo().log("Current app version code: %d", this.appVersionCode);
            this.versionDatabase.invalidateCache(this.appVersionCode);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Can't get app version code.", e);
        }
    }

    private static void writeStreamToFile(InputStream inStream, File destinationFile) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(destinationFile);
            try {
                byte[] bArr = new byte[1000];
                while (true) {
                    int i = inStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream2.write(bArr, 0, i);
                    } else {
                        fileOutputStream2.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
