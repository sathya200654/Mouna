package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HardwareConfigState {
    private static final File FD_SIZE_LIST = new File("/proc/self/fd");
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_O = 700;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    static final int MIN_HARDWARE_DIMENSION_O = 128;
    private static final int MIN_HARDWARE_DIMENSION_P = 0;
    private static volatile HardwareConfigState instance;
    private int decodesSinceLastFdCheck;
    private boolean isFdSizeBelowHardwareLimit = true;
    private final boolean isHardwareConfigAllowedByDeviceModel = isHardwareConfigAllowedByDeviceModel();
    private final int fdCountLimit = MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P;
    private final int minHardwareDimension = 0;

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                if (instance == null) {
                    instance = new HardwareConfigState();
                }
            }
        }
        return instance;
    }

    HardwareConfigState() {
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        int i3;
        return z && this.isHardwareConfigAllowedByDeviceModel && !z2 && i >= (i3 = this.minHardwareDimension) && i2 >= i3 && isFdSizeBelowHardwareLimit();
    }

    boolean setHardwareConfigIfAllowed(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zIsHardwareConfigAllowed = isHardwareConfigAllowed(i, i2, z, z2);
        if (zIsHardwareConfigAllowed) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zIsHardwareConfigAllowed;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:37:0x006f. Please report as an issue. */
    private static boolean isHardwareConfigAllowedByDeviceModel() {
        if (Build.MODEL != null && Build.MODEL.length() >= 7) {
            byte b = 0;
            String strSubstring = Build.MODEL.substring(0, 7);
            strSubstring.hashCode();
            switch (strSubstring.hashCode()) {
                case -1398613787:
                    if (!strSubstring.equals("SM-A520")) {
                        b = -1;
                    }
                    break;
                case -1398431166:
                    b = !strSubstring.equals("SM-G930") ? (byte) -1 : (byte) 1;
                    break;
                case -1398431161:
                    b = !strSubstring.equals("SM-G935") ? (byte) -1 : (byte) 2;
                    break;
                case -1398431073:
                    b = !strSubstring.equals("SM-G960") ? (byte) -1 : (byte) 3;
                    break;
                case -1398431068:
                    b = !strSubstring.equals("SM-G965") ? (byte) -1 : (byte) 4;
                    break;
                case -1398343746:
                    b = !strSubstring.equals("SM-J720") ? (byte) -1 : (byte) 5;
                    break;
                case -1398222624:
                    b = !strSubstring.equals("SM-N935") ? (byte) -1 : (byte) 6;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
            }
        }
        return true;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        boolean z = true;
        int i = this.decodesSinceLastFdCheck + 1;
        this.decodesSinceLastFdCheck = i;
        if (i >= 50) {
            this.decodesSinceLastFdCheck = 0;
            int length = FD_SIZE_LIST.list().length;
            if (length >= this.fdCountLimit) {
                z = false;
            }
            this.isFdSizeBelowHardwareLimit = z;
            if (!z && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.fdCountLimit);
            }
        }
        return this.isFdSizeBelowHardwareLimit;
    }
}
