package com.azure.xml.implementation.aalto.in;

import com.azure.xml.implementation.aalto.impl.IoStreamException;
import com.azure.xml.implementation.aalto.impl.LocationImpl;
import com.azure.xml.implementation.aalto.util.CharsetNames;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ByteSourceBootstrapper extends InputBootstrapper {
    private static final byte BYTE_CR = 13;
    private static final byte BYTE_LF = 10;
    private static final byte BYTE_NULL = 0;
    private final InputStream _in;
    private final byte[] _inputBuffer;
    private int _inputLen;
    private int _inputPtr;
    private boolean mBigEndian;
    private boolean mByteSizeFound;
    private int mBytesPerChar;

    private ByteSourceBootstrapper(ReaderConfig readerConfig, InputStream inputStream) {
        super(readerConfig);
        this.mBigEndian = true;
        this.mBytesPerChar = 0;
        this.mByteSizeFound = false;
        this._in = inputStream;
        this._inputBuffer = readerConfig.allocFullBBuffer(ReaderConfig.DEFAULT_CHAR_BUFFER_LEN);
        this._inputPtr = 0;
        this._inputLen = 0;
    }

    private ByteSourceBootstrapper(ReaderConfig readerConfig, byte[] bArr, int i, int i2) {
        super(readerConfig);
        this.mBigEndian = true;
        this.mBytesPerChar = 0;
        this.mByteSizeFound = false;
        this._in = null;
        this._inputBuffer = bArr;
        this._inputPtr = i;
        this._inputLen = i2 + i;
        this._inputProcessed = -i;
    }

    public static ByteSourceBootstrapper construct(ReaderConfig readerConfig, InputStream inputStream) throws XMLStreamException {
        return new ByteSourceBootstrapper(readerConfig, inputStream);
    }

    public static ByteSourceBootstrapper construct(ReaderConfig readerConfig, byte[] bArr, int i, int i2) throws XMLStreamException {
        return new ByteSourceBootstrapper(readerConfig, bArr, i, i2);
    }

    @Override // com.azure.xml.implementation.aalto.in.InputBootstrapper
    public XmlScanner bootstrap() throws XMLStreamException {
        try {
            try {
                XmlScanner xmlScannerDoBootstrap = doBootstrap();
                this._config.freeSmallCBuffer(this.mKeyword);
                return xmlScannerDoBootstrap;
            } catch (IOException e) {
                throw new IoStreamException(e);
            }
        } catch (Throwable th) {
            this._config.freeSmallCBuffer(this.mKeyword);
            throw th;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public XmlScanner doBootstrap() throws XMLStreamException, IOException {
        String strVerifyXmlEncoding;
        determineStreamEncoding();
        if (hasXmlDeclaration()) {
            readXmlDeclaration();
            if (this.mFoundEncoding != null) {
                strVerifyXmlEncoding = verifyXmlEncoding(this.mFoundEncoding);
            } else {
                strVerifyXmlEncoding = null;
            }
        } else {
            strVerifyXmlEncoding = null;
        }
        String str = CharsetNames.CS_UTF16BE;
        if (strVerifyXmlEncoding == null) {
            int i = this.mBytesPerChar;
            if (i == 2) {
                strVerifyXmlEncoding = this.mBigEndian ? CharsetNames.CS_UTF16BE : CharsetNames.CS_UTF16LE;
            } else if (i == 4) {
                strVerifyXmlEncoding = this.mBigEndian ? CharsetNames.CS_UTF32BE : CharsetNames.CS_UTF32LE;
            } else {
                strVerifyXmlEncoding = "UTF-8";
            }
        }
        this._config.setActualEncoding(strVerifyXmlEncoding);
        this._config.setXmlDeclInfo(this.mDeclaredXmlVersion, this.mFoundEncoding, this.mStandalone);
        if (strVerifyXmlEncoding.equals("UTF-8") || strVerifyXmlEncoding.equals(CharsetNames.CS_ISO_LATIN1) || strVerifyXmlEncoding.equals(CharsetNames.CS_US_ASCII)) {
            return new Utf8Scanner(this._config, this._in, this._inputBuffer, this._inputPtr, this._inputLen);
        }
        if (strVerifyXmlEncoding.startsWith(CharsetNames.CS_UTF32)) {
            return new ReaderScanner(this._config, new Utf32Reader(this._config, this.mBigEndian));
        }
        InputStream mergedStream = this._in;
        if (this._inputPtr < this._inputLen) {
            mergedStream = new MergedStream(this._config, mergedStream, this._inputBuffer, this._inputPtr, this._inputLen);
        }
        if (strVerifyXmlEncoding.equals(CharsetNames.CS_UTF16)) {
            if (!this.mBigEndian) {
                str = CharsetNames.CS_UTF16LE;
            }
            strVerifyXmlEncoding = str;
        }
        try {
            return new ReaderScanner(this._config, new InputStreamReader(mergedStream, strVerifyXmlEncoding));
        } catch (UnsupportedEncodingException e) {
            throw new IoStreamException("Unsupported encoding: " + e.getMessage());
        }
    }

    private void determineStreamEncoding() throws IOException {
        if (ensureLoaded(4)) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            int i2 = (bArr[i + 3] & UnsignedBytes.MAX_VALUE) | (bArr[i] << 24) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8);
            if (i2 == -16842752) {
                reportWeirdUCS4("3412");
            } else if (i2 == -131072) {
                this.mBigEndian = false;
                this._inputPtr = i + 4;
                this.mBytesPerChar = 4;
            } else if (i2 == 65279) {
                this.mBigEndian = true;
                this._inputPtr = i + 4;
                this.mBytesPerChar = 4;
            } else if (i2 != 65534) {
                int i3 = i2 >>> 16;
                if (i3 != 65279) {
                    if (i3 != 65534) {
                        if ((i2 >>> 8) == 15711167) {
                            this._inputPtr = i + 3;
                            this.mBytesPerChar = 1;
                            this.mBigEndian = true;
                        } else {
                            switch (i2) {
                                case ReaderConfig.DEFAULT_SMALL_BUFFER_LEN /* 60 */:
                                    this.mBigEndian = true;
                                    this.mBytesPerChar = 4;
                                    break;
                                case 15360:
                                    reportWeirdUCS4("2143");
                                    break;
                                case 3932160:
                                    reportWeirdUCS4("3412");
                                    break;
                                case 3932223:
                                    this.mBytesPerChar = 2;
                                    this.mBigEndian = true;
                                    break;
                                case 1006632960:
                                    this.mBytesPerChar = 4;
                                    this.mBigEndian = false;
                                    break;
                                case 1006649088:
                                    this.mBytesPerChar = 2;
                                    this.mBigEndian = false;
                                    break;
                                case 1010792557:
                                    this.mBytesPerChar = 1;
                                    this.mBigEndian = true;
                                    break;
                                case 1282385812:
                                    reportEBCDIC();
                                    break;
                            }
                        }
                    } else {
                        this._inputPtr = i + 2;
                        this.mBytesPerChar = 2;
                        this.mBigEndian = false;
                    }
                } else {
                    this._inputPtr = i + 2;
                    this.mBytesPerChar = 2;
                    this.mBigEndian = true;
                }
            } else {
                reportWeirdUCS4("2143");
            }
            this._inputRowStart = this._inputPtr;
        }
        boolean z = this.mBytesPerChar > 0;
        this.mByteSizeFound = z;
        if (z) {
            return;
        }
        this.mBytesPerChar = 1;
        this.mBigEndian = true;
    }

    private boolean hasXmlDeclaration() throws XMLStreamException, IOException {
        int i = this.mBytesPerChar;
        if (i == 1) {
            if (!ensureLoaded(6)) {
                return false;
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            if (bArr[i2] != 60 || bArr[i2 + 1] != 63 || bArr[i2 + 2] != 120 || bArr[i2 + 3] != 109 || bArr[i2 + 4] != 108 || (bArr[i2 + 5] & UnsignedBytes.MAX_VALUE) > 32) {
                return false;
            }
            this._inputPtr = i2 + 6;
            return true;
        }
        if (!ensureLoaded(i * 6)) {
            return false;
        }
        int i3 = this._inputPtr;
        if (nextMultiByte() == 60 && nextMultiByte() == 63 && nextMultiByte() == 120 && nextMultiByte() == 109 && nextMultiByte() == 108 && nextMultiByte() <= 32) {
            return true;
        }
        this._inputPtr = i3;
        return false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private String verifyXmlEncoding(String str) throws XMLStreamException {
        String strNormalize = CharsetNames.normalize(str);
        if (strNormalize.equals("UTF-8")) {
            verifyEncoding(strNormalize, 1);
            return strNormalize;
        }
        if (strNormalize.equals(CharsetNames.CS_ISO_LATIN1)) {
            verifyEncoding(strNormalize, 1);
            return strNormalize;
        }
        if (strNormalize.equals(CharsetNames.CS_US_ASCII)) {
            verifyEncoding(strNormalize, 1);
            return strNormalize;
        }
        if (strNormalize.equals(CharsetNames.CS_UTF16)) {
            verifyEncoding(strNormalize, 2);
            return strNormalize;
        }
        if (strNormalize.equals(CharsetNames.CS_UTF16LE)) {
            verifyEncoding(strNormalize, 2, false);
            return strNormalize;
        }
        if (strNormalize.equals(CharsetNames.CS_UTF16BE)) {
            verifyEncoding(strNormalize, 2, true);
            return strNormalize;
        }
        if (strNormalize.equals(CharsetNames.CS_UTF32)) {
            verifyEncoding(strNormalize, 4);
            return strNormalize;
        }
        if (strNormalize.equals(CharsetNames.CS_UTF32LE)) {
            verifyEncoding(strNormalize, 4, false);
            return strNormalize;
        }
        if (strNormalize.equals(CharsetNames.CS_UTF32BE)) {
            verifyEncoding(strNormalize, 4, true);
        }
        return strNormalize;
    }

    private boolean ensureLoaded(int i) throws IOException {
        int i2;
        int i3 = this._inputLen - this._inputPtr;
        while (i3 < i) {
            InputStream inputStream = this._in;
            if (inputStream == null) {
                i2 = -1;
            } else {
                byte[] bArr = this._inputBuffer;
                int i4 = this._inputLen;
                i2 = inputStream.read(bArr, i4, bArr.length - i4);
            }
            if (i2 < 1) {
                return false;
            }
            this._inputLen += i2;
            i3 += i2;
        }
        return true;
    }

    private void loadMore() throws XMLStreamException, IOException {
        this._inputProcessed += this._inputLen;
        this._inputRowStart -= this._inputLen;
        this._inputPtr = 0;
        InputStream inputStream = this._in;
        if (inputStream == null) {
            this._inputLen = -1;
        } else {
            byte[] bArr = this._inputBuffer;
            this._inputLen = inputStream.read(bArr, 0, bArr.length);
        }
        if (this._inputLen < 1) {
            reportEof();
        }
    }

    @Override // com.azure.xml.implementation.aalto.in.InputBootstrapper
    protected void pushback() {
        this._inputPtr -= this.mBytesPerChar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.in.InputBootstrapper
    protected int getNext() throws XMLStreamException, IOException {
        byte bNextByte;
        if (this.mBytesPerChar > 1) {
            return nextMultiByte();
        }
        int i = this._inputPtr;
        if (i < this._inputLen) {
            byte[] bArr = this._inputBuffer;
            this._inputPtr = i + 1;
            bNextByte = bArr[i];
        } else {
            bNextByte = nextByte();
        }
        return bNextByte & UnsignedBytes.MAX_VALUE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.in.InputBootstrapper
    protected int getNextAfterWs() throws XMLStreamException, IOException {
        byte bNextByte;
        if (this.mBytesPerChar > 1) {
            skipMbWs();
        } else {
            skipSbWs();
        }
        if (this.mBytesPerChar > 1) {
            return nextMultiByte();
        }
        int i = this._inputPtr;
        if (i < this._inputLen) {
            byte[] bArr = this._inputBuffer;
            this._inputPtr = i + 1;
            bNextByte = bArr[i];
        } else {
            bNextByte = nextByte();
        }
        return bNextByte & UnsignedBytes.MAX_VALUE;
    }

    @Override // com.azure.xml.implementation.aalto.in.InputBootstrapper
    protected int checkKeyword(String str) throws XMLStreamException, IOException {
        if (this.mBytesPerChar > 1) {
            return checkMbKeyword(str);
        }
        return checkSbKeyword(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // com.azure.xml.implementation.aalto.in.InputBootstrapper
    protected int readQuotedValue(char[] cArr, int i) throws XMLStreamException, IOException {
        byte bNextByte;
        int length = cArr.length;
        boolean z = this.mBytesPerChar > 1;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = 10;
            if (z) {
                int iNextMultiByte = nextMultiByte();
                if (iNextMultiByte == 13 || iNextMultiByte == 10) {
                    skipMbLF(iNextMultiByte);
                } else {
                    i3 = iNextMultiByte;
                }
            } else {
                int i4 = this._inputPtr;
                if (i4 < this._inputLen) {
                    byte[] bArr = this._inputBuffer;
                    this._inputPtr = i4 + 1;
                    bNextByte = bArr[i4];
                } else {
                    bNextByte = nextByte();
                }
                if (bNextByte == 0) {
                    reportNull();
                }
                if (bNextByte == 13 || bNextByte == 10) {
                    skipSbLF(bNextByte);
                } else {
                    i3 = bNextByte;
                }
                i3 &= Constants.MAX_HOST_LENGTH;
            }
            if (i3 == i) {
                return i2;
            }
            cArr[i2] = (char) i3;
        }
        return -1;
    }

    @Override // com.azure.xml.implementation.aalto.in.InputBootstrapper
    protected Location getLocation() {
        int i = this._inputProcessed;
        int i2 = this._inputPtr;
        int i3 = i + i2;
        int i4 = i2 - this._inputRowStart;
        int i5 = this.mBytesPerChar;
        if (i5 > 1) {
            i3 /= i5;
            i4 /= i5;
        }
        return LocationImpl.fromZeroBased(i3, this._inputRow, i4);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private byte nextByte() throws XMLStreamException, IOException {
        if (this._inputPtr >= this._inputLen) {
            loadMore();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i];
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void skipSbWs() throws XMLStreamException, IOException {
        byte bNextByte;
        while (true) {
            int i = this._inputPtr;
            if (i < this._inputLen) {
                byte[] bArr = this._inputBuffer;
                this._inputPtr = i + 1;
                bNextByte = bArr[i];
            } else {
                bNextByte = nextByte();
            }
            if ((bNextByte & UnsignedBytes.MAX_VALUE) > 32) {
                this._inputPtr--;
                return;
            } else if (bNextByte == 13 || bNextByte == 10) {
                skipSbLF(bNextByte);
            } else if (bNextByte == 0) {
                reportNull();
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void skipSbLF(byte b) throws XMLStreamException, IOException {
        byte bNextByte;
        if (b == 13) {
            int i = this._inputPtr;
            if (i < this._inputLen) {
                byte[] bArr = this._inputBuffer;
                this._inputPtr = i + 1;
                bNextByte = bArr[i];
            } else {
                bNextByte = nextByte();
            }
            if (bNextByte != 10) {
                this._inputPtr--;
            }
        }
        this._inputRow++;
        this._inputRowStart = this._inputPtr;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private int checkSbKeyword(String str) throws XMLStreamException, IOException {
        byte bNextByte;
        int length = str.length();
        for (int i = 1; i < length; i++) {
            int i2 = this._inputPtr;
            if (i2 < this._inputLen) {
                byte[] bArr = this._inputBuffer;
                this._inputPtr = i2 + 1;
                bNextByte = bArr[i2];
            } else {
                bNextByte = nextByte();
            }
            if (bNextByte == 0) {
                reportNull();
            }
            int i3 = bNextByte & UnsignedBytes.MAX_VALUE;
            if (i3 != str.charAt(i)) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:30:0x0088  */
    private int nextMultiByte() throws XMLStreamException, IOException {
        byte bNextByte;
        byte bNextByte2;
        byte bNextByte3;
        byte bNextByte4;
        int i;
        int i2;
        int i3;
        int i4 = this._inputPtr;
        if (i4 < this._inputLen) {
            byte[] bArr = this._inputBuffer;
            this._inputPtr = i4 + 1;
            bNextByte = bArr[i4];
        } else {
            bNextByte = nextByte();
        }
        int i5 = this._inputPtr;
        if (i5 < this._inputLen) {
            byte[] bArr2 = this._inputBuffer;
            this._inputPtr = i5 + 1;
            bNextByte2 = bArr2[i5];
        } else {
            bNextByte2 = nextByte();
        }
        if (this.mBytesPerChar == 2) {
            if (this.mBigEndian) {
                i2 = (bNextByte & UnsignedBytes.MAX_VALUE) << 8;
                i3 = bNextByte2 & UnsignedBytes.MAX_VALUE;
            } else {
                i2 = bNextByte & UnsignedBytes.MAX_VALUE;
                i3 = (bNextByte2 & UnsignedBytes.MAX_VALUE) << 8;
            }
        } else {
            int i6 = this._inputPtr;
            if (i6 < this._inputLen) {
                byte[] bArr3 = this._inputBuffer;
                this._inputPtr = i6 + 1;
                bNextByte3 = bArr3[i6];
            } else {
                bNextByte3 = nextByte();
            }
            int i7 = this._inputPtr;
            if (i7 < this._inputLen) {
                byte[] bArr4 = this._inputBuffer;
                this._inputPtr = i7 + 1;
                bNextByte4 = bArr4[i7];
            } else {
                bNextByte4 = nextByte();
            }
            if (this.mBigEndian) {
                i2 = (bNextByte << 24) | ((bNextByte2 & UnsignedBytes.MAX_VALUE) << 16) | ((bNextByte3 & UnsignedBytes.MAX_VALUE) << 8);
                i3 = bNextByte4 & UnsignedBytes.MAX_VALUE;
            } else {
                int i8 = (bNextByte3 & UnsignedBytes.MAX_VALUE) << 16;
                int i9 = (bNextByte2 & UnsignedBytes.MAX_VALUE) << 8;
                i = (bNextByte & UnsignedBytes.MAX_VALUE) | i9 | i8 | (bNextByte4 << 24);
            }
            if (i == 0) {
                reportNull();
            }
            return i;
        }
        i = i2 | i3;
        if (i == 0) {
            reportNull();
        }
        return i;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void skipMbWs() throws XMLStreamException, IOException {
        while (true) {
            int iNextMultiByte = nextMultiByte();
            if (iNextMultiByte > 32) {
                this._inputPtr -= this.mBytesPerChar;
                return;
            } else if (iNextMultiByte == 13 || iNextMultiByte == 10) {
                skipMbLF(iNextMultiByte);
            } else if (iNextMultiByte == 0) {
                reportNull();
            }
        }
    }

    private void skipMbLF(int i) throws XMLStreamException, IOException {
        if (i == 13 && nextMultiByte() != 10) {
            this._inputPtr -= this.mBytesPerChar;
        }
        this._inputRow++;
        this._inputRowStart = this._inputPtr;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private int checkMbKeyword(String str) throws XMLStreamException, IOException {
        int length = str.length();
        for (int i = 1; i < length; i++) {
            int iNextMultiByte = nextMultiByte();
            if (iNextMultiByte == 0) {
                reportNull();
            }
            if (iNextMultiByte != str.charAt(i)) {
                return iNextMultiByte;
            }
        }
        return 0;
    }

    private void verifyEncoding(String str, int i) throws XMLStreamException {
        if (!this.mByteSizeFound || i == this.mBytesPerChar) {
            return;
        }
        reportXmlProblem("Declared encoding '" + str + "' uses " + i + " bytes per character; but physical encoding appeared to use " + this.mBytesPerChar + "; cannot decode");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void verifyEncoding(String str, int i, boolean z) throws XMLStreamException {
        if (this.mByteSizeFound) {
            verifyEncoding(str, i);
            if (z != this.mBigEndian) {
                reportXmlProblem("Declared encoding '" + str + "' has different endianness (" + (z ? "big" : "little") + " endian) than what physical ordering appeared to be; cannot decode");
            }
        }
    }

    private void reportWeirdUCS4(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    private void reportEBCDIC() throws IOException {
        throw new CharConversionException("Unsupported encoding (EBCDIC)");
    }
}
