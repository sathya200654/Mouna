package com.azure.core.implementation;

import com.azure.core.util.CoreUtils;
import java.io.IOException;
import java.util.Objects;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SemanticVersion implements Comparable<SemanticVersion> {
    public static final String UNKNOWN_VERSION = "unknown";
    private final int major;
    private final int minor;
    private final int patch;
    private final String prerelease;
    private final String versionString;

    public static SemanticVersion getPackageVersionForClass(String str) {
        try {
            return getPackageVersion(Class.forName(str));
        } catch (Exception unused) {
            return createInvalid();
        }
    }

    public static SemanticVersion parse(String str) {
        String str2;
        char cCharAt;
        Objects.requireNonNull(str, "'version' cannot be null.");
        int iIndexOf = str.indexOf(46);
        if (iIndexOf < 0) {
            return createInvalid(str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(46, i);
        if (iIndexOf2 < 0) {
            return createInvalid(str);
        }
        int i2 = iIndexOf2 + 1;
        int i3 = i2;
        while (i3 < str.length() && (cCharAt = str.charAt(i3)) != '.' && cCharAt != '-' && cCharAt != '+') {
            i3++;
        }
        int iIndexOf3 = str.indexOf(43, i3);
        if (iIndexOf3 < 0) {
            iIndexOf3 = str.length();
        }
        try {
            str2 = str;
            try {
                return new SemanticVersion(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(i, iIndexOf2)), Integer.parseInt(str.substring(i2, i3)), i3 == iIndexOf3 ? "" : str.substring(i3 + 1, iIndexOf3), str2);
            } catch (NumberFormatException unused) {
                return createInvalid(str2);
            }
        } catch (NumberFormatException unused2) {
            str2 = str;
        }
    }

    private static SemanticVersion getPackageVersion(Class<?> cls) {
        Objects.requireNonNull(cls, "'clazz' cannot be null.");
        if (cls.getPackage() == null) {
            return createInvalid();
        }
        String implementationVersion = cls.getPackage().getImplementationVersion();
        if (implementationVersion != null) {
            return parse(implementationVersion);
        }
        try {
            JarFile jarFile = new JarFile(cls.getProtectionDomain().getCodeSource().getLocation().getFile());
            try {
                Manifest manifest = jarFile.getManifest();
                String value = manifest.getMainAttributes().getValue("Implementation-Version");
                if (value == null) {
                    value = manifest.getMainAttributes().getValue("Bundle-Version");
                }
                SemanticVersion semanticVersion = parse(value);
                jarFile.close();
                return semanticVersion;
            } catch (Throwable th) {
                try {
                    jarFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | SecurityException unused) {
            return createInvalid();
        }
    }

    public static SemanticVersion createInvalid() {
        return createInvalid(UNKNOWN_VERSION);
    }

    private static SemanticVersion createInvalid(String str) {
        return new SemanticVersion(-1, -1, -1, null, str);
    }

    SemanticVersion(int i, int i2, int i3, String str, String str2) {
        Objects.requireNonNull(str2, "'versionString' cannot be null.");
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        this.prerelease = str;
        this.versionString = str2;
    }

    public String getVersionString() {
        return this.versionString;
    }

    public int getMajorVersion() {
        return this.major;
    }

    @Override // java.lang.Comparable
    public int compareTo(SemanticVersion semanticVersion) {
        if (this == semanticVersion) {
            return 0;
        }
        if (semanticVersion == null) {
            return -1;
        }
        int i = this.major;
        int i2 = semanticVersion.major;
        if (i != i2) {
            return i > i2 ? 1 : -1;
        }
        int i3 = this.minor;
        int i4 = semanticVersion.minor;
        if (i3 != i4) {
            return i3 > i4 ? 1 : -1;
        }
        int i5 = this.patch;
        int i6 = semanticVersion.patch;
        if (i5 != i6) {
            return i5 > i6 ? 1 : -1;
        }
        if (CoreUtils.isNullOrEmpty(this.prerelease)) {
            return !CoreUtils.isNullOrEmpty(semanticVersion.prerelease) ? 1 : 0;
        }
        if (CoreUtils.isNullOrEmpty(semanticVersion.prerelease)) {
            return -1;
        }
        return this.prerelease.compareTo(semanticVersion.prerelease);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SemanticVersion) {
            return this.versionString.equals(((SemanticVersion) obj).versionString);
        }
        return false;
    }

    public int hashCode() {
        return this.versionString.hashCode();
    }

    public String toString() {
        return this.versionString;
    }

    public boolean isValid() {
        return this.major >= 0;
    }
}
