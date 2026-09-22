package com.azure.xml.implementation.aalto.in;

import com.azure.xml.implementation.aalto.impl.LocationImpl;
import com.azure.xml.implementation.aalto.util.DataUtil;
import com.azure.xml.implementation.aalto.util.XmlCharTypes;
import com.azure.xml.implementation.aalto.util.XmlChars;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.FastDoubleMath;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class ByteBasedScanner extends XmlScanner {
    protected static final byte BYTE_AMP = 38;
    protected static final byte BYTE_CR = 13;
    protected static final byte BYTE_D = 68;
    protected static final byte BYTE_EXCL = 33;
    protected static final byte BYTE_GT = 62;
    protected static final byte BYTE_HASH = 35;
    protected static final byte BYTE_HYPHEN = 45;
    protected static final byte BYTE_LBRACKET = 91;
    protected static final byte BYTE_LF = 10;
    protected static final byte BYTE_LT = 60;
    protected static final byte BYTE_P = 80;
    protected static final byte BYTE_QMARK = 63;
    protected static final byte BYTE_RBRACKET = 93;
    protected static final byte BYTE_S = 83;
    protected static final byte BYTE_SEMICOLON = 59;
    protected static final byte BYTE_SLASH = 47;
    protected static final byte BYTE_SPACE = 32;
    protected static final byte BYTE_TAB = 9;
    protected static final byte BYTE_a = 97;
    protected static final byte BYTE_g = 103;
    protected static final byte BYTE_l = 108;
    protected static final byte BYTE_m = 109;
    protected static final byte BYTE_o = 111;
    protected static final byte BYTE_p = 112;
    protected static final byte BYTE_q = 113;
    protected static final byte BYTE_s = 115;
    protected static final byte BYTE_t = 116;
    protected static final byte BYTE_u = 117;
    protected static final byte BYTE_x = 120;
    protected int _inputEnd;
    protected int _inputPtr;
    protected int _tmpChar;

    @Override // com.azure.xml.implementation.aalto.in.XmlScanner
    protected abstract void _closeSource() throws IOException;

    protected abstract int decodeCharForError(byte b) throws XMLStreamException;

    protected ByteBasedScanner(ReaderConfig readerConfig) {
        super(readerConfig);
        this._tmpChar = 0;
        this._pastBytesOrChars = 0L;
        this._rowStartOffset = 0;
    }

    @Override // com.azure.xml.implementation.aalto.in.XmlScanner
    public Location getCurrentLocation() {
        return LocationImpl.fromZeroBased(this._pastBytesOrChars + ((long) this._inputPtr), this._currRow, this._inputPtr - this._rowStartOffset);
    }

    protected final void markLF(int i) {
        this._rowStartOffset = i;
        this._currRow++;
    }

    protected final void markLF() {
        this._rowStartOffset = this._inputPtr;
        this._currRow++;
    }

    protected final void setStartLocation() {
        this._startRawOffset = this._pastBytesOrChars + ((long) this._inputPtr);
        this._startRow = this._currRow;
        this._startColumn = this._inputPtr - this._rowStartOffset;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:42:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:71:0x011a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0131  */
    /* JADX WARN: Code duplicated, block: B:77:0x013b  */
    /* JADX WARN: Code duplicated, block: B:79:0x014e  */
    /* JADX WARN: Code duplicated, block: B:82:0x0158  */
    /* JADX WARN: Code duplicated, block: B:84:0x016b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0176 A[PHI: r5 r12
  0x0176: PHI (r5v19 int) = (r5v18 int), (r5v25 int) binds: [B:76:0x0139, B:81:0x0156] A[DONT_GENERATE, DONT_INLINE]
  0x0176: PHI (r12v9 int) = (r12v8 int), (r12v14 int) binds: [B:76:0x0139, B:81:0x0156] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x017e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0183  */
    /* JADX WARN: Code duplicated, block: B:93:0x019a  */
    protected final PName addUTFPName(ByteBasedPNameTable byteBasedPNameTable, XmlCharTypes xmlCharTypes, int i, int[] iArr, int i2, int i3) throws XMLStreamException {
        int i4;
        int i5;
        int i6;
        boolean zIs10NameStartChar;
        int i7;
        int i8;
        boolean z;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = ((i2 << 2) - 4) + i3;
        if (i3 < 4) {
            int i18 = i2 - 1;
            i4 = iArr[i18];
            iArr[i18] = i4 << ((4 - i3) << 3);
        } else {
            i4 = 0;
        }
        int i19 = iArr[0] >>> 24;
        char[] cArr = this._nameBuffer;
        int[] iArr2 = xmlCharTypes.NAME_CHARS;
        int i20 = iArr2[i19];
        if (i20 == 0 || i20 == 1 || i20 == 2) {
            i5 = 3;
            i6 = 1;
            zIs10NameStartChar = false;
            i7 = 0;
        } else {
            if (i20 == 3) {
                i5 = 3;
                zIs10NameStartChar = true;
                i6 = 1;
            } else if (i20 != 4) {
                if ((i19 & 224) == 192) {
                    i15 = i19 & 31;
                    i16 = 1;
                } else if ((i19 & 240) == 224) {
                    i15 = i19 & 15;
                    i16 = 2;
                } else if ((i19 & 248) == 240) {
                    i15 = i19 & 7;
                    i16 = 3;
                } else {
                    reportInvalidInitial(i19);
                    i15 = 1;
                    i16 = 1;
                }
                i6 = 1 + i16;
                if (i6 > i17) {
                    reportEofInName();
                }
                int i21 = iArr[0];
                int i22 = i21 >> 16;
                int i23 = i22 & Constants.MAX_HOST_LENGTH;
                i5 = 3;
                if ((i22 & 192) != 128) {
                    reportInvalidOther(i23);
                }
                int i24 = (i15 << 6) | (i22 & 63);
                if (i16 > 1) {
                    int i25 = i21 >> 8;
                    int i26 = i25 & Constants.MAX_HOST_LENGTH;
                    if ((i25 & 192) != 128) {
                        reportInvalidOther(i26);
                    }
                    i24 = (i24 << 6) | (i25 & 63);
                    if (i16 > 2) {
                        if ((i21 & 192) != 128) {
                            reportInvalidOther(i21 & Constants.MAX_HOST_LENGTH);
                        }
                        i24 = (i24 << 6) | (i21 & 63);
                    }
                }
                i19 = i24;
                zIs10NameStartChar = XmlChars.is10NameStartChar(i19);
                if (i16 > 2) {
                    int i27 = i19 - ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    cArr[0] = (char) ((i27 >> 10) + 55296);
                    i19 = (i27 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | 56320;
                    i7 = 1;
                }
            } else {
                i5 = 3;
                i6 = 1;
                zIs10NameStartChar = false;
                i7 = 0;
            }
            i7 = 0;
        }
        if (!zIs10NameStartChar) {
            reportInvalidNameChar(i19, 0);
        }
        int i28 = i7 + 1;
        cArr[i7] = (char) i19;
        int i29 = -1;
        while (i6 < i17) {
            int i30 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
            int i31 = i30 & Constants.MAX_HOST_LENGTH;
            i6++;
            int i32 = iArr2[i31];
            if (i32 == 0) {
                i31 = i31;
                i6 = i6;
                i8 = i28;
                z = false;
            } else {
                if (i32 != 1) {
                    if (i32 != 2) {
                        int i33 = i5;
                        if (i32 == i33) {
                            i5 = i33;
                        } else if (i32 != 4) {
                            if ((i30 & 224) == 192) {
                                i9 = i30 & 31;
                                i10 = 1;
                            } else {
                                if ((i30 & 240) == 224) {
                                    i9 = i30 & 15;
                                    i10 = 2;
                                } else if ((i30 & 248) == 240) {
                                    i9 = i30 & 7;
                                    i10 = 3;
                                } else {
                                    reportInvalidInitial(i31);
                                    i9 = 1;
                                    i10 = 1;
                                }
                                if (i6 + i10 > i17) {
                                    reportEofInName();
                                }
                                i11 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                                i12 = i6 + 2;
                                if ((i11 & 192) != 128) {
                                    reportInvalidOther(i11);
                                }
                                i31 = (i9 << 6) | (i11 & 63);
                                if (i10 > 1) {
                                    i13 = iArr[i12 >> 2] >> ((3 - (i12 & 3)) << 3);
                                    i12 = i6 + 3;
                                    if ((i13 & 192) != 128) {
                                        reportInvalidOther(i13);
                                    }
                                    i31 = (i31 << 6) | (i13 & 63);
                                    if (i10 > 2) {
                                        i5 = 3;
                                        i14 = iArr[i12 >> 2] >> ((3 - (i12 & 3)) << 3);
                                        i12 = i6 + 4;
                                        if ((i14 & 192) != 128) {
                                            reportInvalidOther(i14 & Constants.MAX_HOST_LENGTH);
                                        }
                                        i31 = (i31 << 6) | (i14 & 63);
                                    } else {
                                        i5 = 3;
                                    }
                                } else {
                                    i5 = 3;
                                }
                                boolean zIs10NameChar = XmlChars.is10NameChar(i31);
                                if (i10 > 2) {
                                    int i34 = i31 - ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                                    if (i28 >= cArr.length) {
                                        char[] cArrGrowArrayBy = DataUtil.growArrayBy(cArr, cArr.length);
                                        this._nameBuffer = cArrGrowArrayBy;
                                        cArr = cArrGrowArrayBy;
                                    }
                                    i8 = i28 + 1;
                                    cArr[i28] = (char) ((i34 >> 10) + 55296);
                                    i31 = (i34 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | 56320;
                                } else {
                                    i8 = i28;
                                }
                                z = zIs10NameChar;
                                i6 = i12;
                            }
                            if (i6 + i10 > i17) {
                                reportEofInName();
                            }
                            i11 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                            i12 = i6 + 2;
                            if ((i11 & 192) != 128) {
                                reportInvalidOther(i11);
                            }
                            i31 = (i9 << 6) | (i11 & 63);
                            if (i10 > 1) {
                                i13 = iArr[i12 >> 2] >> ((3 - (i12 & 3)) << 3);
                                i12 = i6 + 3;
                                if ((i13 & 192) != 128) {
                                    reportInvalidOther(i13);
                                }
                                i31 = (i31 << 6) | (i13 & 63);
                                if (i10 > 2) {
                                    i5 = 3;
                                    i14 = iArr[i12 >> 2] >> ((3 - (i12 & 3)) << 3);
                                    i12 = i6 + 4;
                                    if ((i14 & 192) != 128) {
                                        reportInvalidOther(i14 & Constants.MAX_HOST_LENGTH);
                                    }
                                    i31 = (i31 << 6) | (i14 & 63);
                                } else {
                                    i5 = 3;
                                }
                            } else {
                                i5 = 3;
                            }
                            boolean zIs10NameChar2 = XmlChars.is10NameChar(i31);
                            if (i10 > 2) {
                                int i35 = i31 - ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                                if (i28 >= cArr.length) {
                                    char[] cArrGrowArrayBy2 = DataUtil.growArrayBy(cArr, cArr.length);
                                    this._nameBuffer = cArrGrowArrayBy2;
                                    cArr = cArrGrowArrayBy2;
                                }
                                i8 = i28 + 1;
                                cArr[i28] = (char) ((i35 >> 10) + 55296);
                                i31 = (i35 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | 56320;
                            } else {
                                i8 = i28;
                            }
                            z = zIs10NameChar2;
                            i6 = i12;
                        } else {
                            i5 = 3;
                            i31 = i31;
                            i6 = i6;
                            i8 = i28;
                            z = false;
                        }
                    }
                    i8 = i28;
                } else {
                    if (i29 >= 0) {
                        reportMultipleColonsInName();
                    }
                    i29 = i28;
                    i8 = i29;
                }
                z = true;
            }
            if (!z) {
                reportInvalidNameChar(i31, i8);
            }
            if (i8 >= cArr.length) {
                char[] cArrGrowArrayBy3 = DataUtil.growArrayBy(cArr, cArr.length);
                this._nameBuffer = cArrGrowArrayBy3;
                cArr = cArrGrowArrayBy3;
            }
            i28 = i8 + 1;
            cArr[i8] = (char) i31;
        }
        String str = new String(cArr, 0, i28);
        if (i3 < 4) {
            iArr[i2 - 1] = i4;
        }
        return byteBasedPNameTable.addSymbol(i, str, i29, iArr, i2);
    }

    protected void reportInvalidInitial(int i) throws XMLStreamException {
        reportInputProblem("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    protected void reportInvalidOther(int i) throws XMLStreamException {
        reportInputProblem("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }
}
