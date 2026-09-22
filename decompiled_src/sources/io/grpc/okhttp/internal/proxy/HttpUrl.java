package io.grpc.okhttp.internal.proxy;

import androidx.webkit.ProxyConfig;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import io.grpc.internal.GrpcUtil;
import java.io.EOFException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;
import okio.Buffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class HttpUrl {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String host;
    private final int port;
    private final String scheme;
    private final String url;

    static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return c - '7';
    }

    private static void fakeEofExceptionMethod() throws EOFException {
    }

    private HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.url = builder.toString();
    }

    public String scheme() {
        return this.scheme;
    }

    public boolean isHttps() {
        return this.scheme.equals(ProxyConfig.MATCH_HTTPS);
    }

    public String host() {
        return this.host;
    }

    public int port() {
        return this.port;
    }

    public static int defaultPort(String str) {
        if (str.equals(ProxyConfig.MATCH_HTTP)) {
            return 80;
        }
        if (str.equals(ProxyConfig.MATCH_HTTPS)) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        return -1;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        return builder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    public static final class Builder {
        String host;
        int port = -1;
        String scheme;

        public Builder scheme(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (str.equalsIgnoreCase(ProxyConfig.MATCH_HTTP)) {
                this.scheme = ProxyConfig.MATCH_HTTP;
                return this;
            }
            if (str.equalsIgnoreCase(ProxyConfig.MATCH_HTTPS)) {
                this.scheme = ProxyConfig.MATCH_HTTPS;
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + str);
        }

        public Builder host(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String strCanonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (strCanonicalizeHost == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.host = strCanonicalizeHost;
            return this;
        }

        public Builder port(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.port = i;
            return this;
        }

        int effectivePort() {
            int i = this.port;
            return i != -1 ? i : HttpUrl.defaultPort(this.scheme);
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.host == null) {
                throw new IllegalStateException("host == null");
            }
            return new HttpUrl(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme);
            sb.append("://");
            if (this.host.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.host);
                sb.append(']');
            } else {
                sb.append(this.host);
            }
            int iEffectivePort = effectivePort();
            if (iEffectivePort != HttpUrl.defaultPort(this.scheme)) {
                sb.append(':');
                sb.append(iEffectivePort);
            }
            return sb.toString();
        }

        private static String canonicalizeHost(String str, int i, int i2) {
            String strPercentDecode = HttpUrl.percentDecode(str, i, i2, false);
            if (strPercentDecode.startsWith("[") && strPercentDecode.endsWith("]")) {
                InetAddress inetAddressDecodeIpv6 = decodeIpv6(strPercentDecode, 1, strPercentDecode.length() - 1);
                if (inetAddressDecodeIpv6 == null) {
                    return null;
                }
                byte[] address = inetAddressDecodeIpv6.getAddress();
                if (address.length == 16) {
                    return inet6AddressToAscii(address);
                }
                throw new AssertionError();
            }
            return domainToAscii(strPercentDecode);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x004f  */
        /* JADX WARN: Code duplicated, block: B:34:0x005a A[LOOP:1: B:30:0x004d->B:34:0x005a, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:59:0x0060 A[EDGE_INSN: B:59:0x0060->B:35:0x0060 BREAK  A[LOOP:1: B:30:0x004d->B:34:0x005a], SYNTHETIC] */
        private static InetAddress decodeIpv6(String str, int i, int i2) {
            int i3;
            int i4;
            int iDecodeHexDigit;
            byte[] bArr = new byte[16];
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (i < i2) {
                if (i5 == 16) {
                    return null;
                }
                int i8 = i + 2;
                if (i8 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                    if (i6 != -1) {
                        return null;
                    }
                    i5 += 2;
                    i6 = i5;
                    if (i8 == i2) {
                        break;
                    }
                    i7 = i8;
                    i3 = 0;
                    i = i7;
                    while (i < i2) {
                        iDecodeHexDigit = HttpUrl.decodeHexDigit(str.charAt(i));
                        if (iDecodeHexDigit == -1) {
                            break;
                            break;
                        }
                        i3 = (i3 << 4) + iDecodeHexDigit;
                        i++;
                    }
                    i4 = i - i7;
                    if (i4 != 0) {
                    }
                    return null;
                }
                if (i5 != 0) {
                    if (!str.regionMatches(i, ":", 0, 1)) {
                        if (!str.regionMatches(i, ".", 0, 1) || !decodeIpv4Suffix(str, i7, i2, bArr, i5 - 2)) {
                            return null;
                        }
                        i5 += 2;
                        break;
                    }
                    i++;
                }
                i7 = i;
                i3 = 0;
                i = i7;
                while (i < i2) {
                    iDecodeHexDigit = HttpUrl.decodeHexDigit(str.charAt(i));
                    if (iDecodeHexDigit == -1) {
                        break;
                    }
                    i3 = (i3 << 4) + iDecodeHexDigit;
                    i++;
                }
                i4 = i - i7;
                if (i4 != 0 || i4 > 4) {
                    return null;
                }
                int i9 = i5 + 1;
                bArr[i5] = (byte) ((i3 >>> 8) & Constants.MAX_HOST_LENGTH);
                i5 += 2;
                bArr[i9] = (byte) (i3 & Constants.MAX_HOST_LENGTH);
            }
            if (i5 != 16) {
                if (i6 == -1) {
                    return null;
                }
                int i10 = i5 - i6;
                System.arraycopy(bArr, i6, bArr, 16 - i10, i10);
                Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        private static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char cCharAt = str.charAt(i5);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                        return false;
                    }
                    i5++;
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        private static String domainToAscii(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty() || containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private static boolean containsInvalidHostnameAsciiCodes(String str) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static String inet6AddressToAscii(byte[] bArr) {
            int i = -1;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                int i5 = i3;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i3;
                if (i6 > i4) {
                    i = i3;
                    i4 = i6;
                }
                i3 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i2 < bArr.length) {
                if (i2 == i) {
                    buffer.writeByte(58);
                    i2 += i4;
                    if (i2 == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i2 > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong(((bArr[i2] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i2 + 1] & UnsignedBytes.MAX_VALUE));
                    i2 += 2;
                }
            }
            return buffer.readUtf8();
        }
    }

    static String percentDecode(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                percentDecode(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    static void percentDecode(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iDecodeHexDigit = decodeHexDigit(str.charAt(i + 1));
                int iDecodeHexDigit2 = decodeHexDigit(str.charAt(i3));
                if (iDecodeHexDigit != -1 && iDecodeHexDigit2 != -1) {
                    buffer.writeByte((iDecodeHexDigit << 4) + iDecodeHexDigit2);
                    i = i3;
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                buffer.writeByte(32);
            } else {
                buffer.writeUtf8CodePoint(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static void canonicalize(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3) {
        Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z2) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z3) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && !z))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(iCodePointAt);
                    while (!buffer2.exhausted()) {
                        try {
                            fakeEofExceptionMethod();
                            byte b = buffer2.readByte();
                            int i3 = b & UnsignedBytes.MAX_VALUE;
                            buffer.writeByte(37);
                            char[] cArr = HEX_DIGITS;
                            buffer.writeByte(cArr[(i3 >> 4) & 15]);
                            buffer.writeByte(cArr[b & 15]);
                        } catch (EOFException e) {
                            throw new IndexOutOfBoundsException(e.getMessage());
                        }
                    }
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }
}
