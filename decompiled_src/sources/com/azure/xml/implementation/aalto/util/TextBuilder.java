package com.azure.xml.implementation.aalto.util;

import com.azure.xml.implementation.aalto.in.ReaderConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class TextBuilder {
    static final int DEF_INITIAL_BUFFER_SIZE = 500;
    public static final int MAX_INDENT_SPACES = 32;
    public static final int MAX_INDENT_TABS = 8;
    static final int MAX_SEGMENT_LENGTH = 262144;
    private static final String sIndSpaces = "\n                                 ";
    private static final char[] sIndSpacesArray;
    private static final String[] sIndSpacesStrings;
    private static final String sIndTabs = "\n\t\t\t\t\t\t\t\t\t";
    private static final char[] sIndTabsArray;
    private static final String[] sIndTabsStrings;
    static final char[] sNoChars = new char[0];
    private final ReaderConfig _config;
    private char[] _currentSegment;
    private int _currentSize;
    private boolean _isIndentation = false;
    private char[] _resultArray;
    private int _resultLen;
    private String _resultString;
    private int _segmentSize;
    private ArrayList<char[]> _segments;

    static {
        char[] charArray = sIndSpaces.toCharArray();
        sIndSpacesArray = charArray;
        sIndSpacesStrings = new String[charArray.length];
        char[] charArray2 = sIndTabs.toCharArray();
        sIndTabsArray = charArray2;
        sIndTabsStrings = new String[charArray2.length];
    }

    private TextBuilder(ReaderConfig readerConfig) {
        this._config = readerConfig;
    }

    public static TextBuilder createRecyclableBuffer(ReaderConfig readerConfig) {
        return new TextBuilder(readerConfig);
    }

    public void recycle(boolean z) {
        if (this._config == null || this._currentSegment == null) {
            return;
        }
        if (z) {
            this._resultString = null;
            this._resultArray = null;
        } else if (this._segmentSize + this._currentSize > 0) {
            return;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && !arrayList.isEmpty()) {
            this._segments.clear();
            this._segmentSize = 0;
        }
        char[] cArr = this._currentSegment;
        this._currentSegment = null;
        this._config.freeMediumCBuffer(cArr);
    }

    public char[] resetWithEmpty() {
        this._resultString = null;
        this._resultArray = null;
        this._isIndentation = false;
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && !arrayList.isEmpty()) {
            this._segments.clear();
            this._segmentSize = 0;
        }
        this._currentSize = 0;
        if (this._currentSegment == null) {
            this._currentSegment = allocBuffer();
        }
        return this._currentSegment;
    }

    public void resetWithIndentation(int i, char c) {
        String strSubstring;
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null && !arrayList.isEmpty()) {
            this._segments.clear();
            this._segmentSize = 0;
        }
        this._currentSize = -1;
        this._isIndentation = true;
        int i2 = i + 1;
        this._resultLen = i2;
        if (c == '\t') {
            this._resultArray = sIndTabsArray;
            String[] strArr = sIndTabsStrings;
            strSubstring = strArr[i];
            if (strSubstring == null) {
                strSubstring = sIndTabs.substring(0, i2);
                strArr[i] = strSubstring;
            }
        } else {
            this._resultArray = sIndSpacesArray;
            String[] strArr2 = sIndSpacesStrings;
            strSubstring = strArr2[i];
            if (strSubstring == null) {
                strSubstring = sIndSpaces.substring(0, i2);
                strArr2[i] = strSubstring;
            }
        }
        this._resultString = strSubstring;
    }

    public char[] getBufferWithoutReset() {
        return this._currentSegment;
    }

    public int size() {
        int i = this._currentSize;
        if (i < 0) {
            return this._resultLen;
        }
        return i + this._segmentSize;
    }

    public char[] getTextBuffer() {
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList == null || arrayList.isEmpty()) {
            char[] cArr = this._resultArray;
            return cArr != null ? cArr : this._currentSegment;
        }
        return contentsAsArray();
    }

    public String contentsAsString() {
        if (this._resultString == null) {
            if (this._resultArray != null) {
                this._resultString = new String(this._resultArray);
            } else {
                int i = this._segmentSize;
                int i2 = this._currentSize;
                if (i == 0) {
                    String str = i2 == 0 ? "" : new String(this._currentSegment, 0, i2);
                    this._resultString = str;
                    return str;
                }
                StringBuilder sb = new StringBuilder(i + i2);
                ArrayList<char[]> arrayList = this._segments;
                if (arrayList != null) {
                    for (char[] cArr : arrayList) {
                        sb.append(cArr, 0, cArr.length);
                    }
                }
                sb.append(this._currentSegment, 0, i2);
                this._resultString = sb.toString();
            }
        }
        return this._resultString;
    }

    public char[] contentsAsArray() {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrBuildResultArray = buildResultArray();
        this._resultArray = cArrBuildResultArray;
        return cArrBuildResultArray;
    }

    public int contentsToArray(int i, char[] cArr, int i2, int i3) {
        ArrayList<char[]> arrayList = this._segments;
        int i4 = 0;
        if (arrayList != null) {
            int i5 = 0;
            for (char[] cArr2 : arrayList) {
                int length = cArr2.length;
                int i6 = length - i;
                if (i6 < 1) {
                    i -= length;
                } else {
                    if (i6 >= i3) {
                        System.arraycopy(cArr2, i, cArr, i2, i3);
                        return i5 + i3;
                    }
                    System.arraycopy(cArr2, i, cArr, i2, i6);
                    i5 += i6;
                    i2 += i6;
                    i3 -= i6;
                    i = 0;
                }
            }
            i4 = i5;
        }
        if (i3 <= 0) {
            return i4;
        }
        int i7 = this._currentSize - i;
        if (i3 > i7) {
            i3 = i7;
        }
        if (i3 <= 0) {
            return i4;
        }
        System.arraycopy(this._currentSegment, i, cArr, i2, i3);
        return i4 + i3;
    }

    public boolean isAllWhitespace() {
        if (this._isIndentation) {
            return true;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            for (char[] cArr : arrayList) {
                for (char c : cArr) {
                    if (c > ' ') {
                        return false;
                    }
                }
            }
        }
        char[] cArr2 = this._currentSegment;
        int i = this._currentSize;
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr2[i2] > ' ') {
                return false;
            }
        }
        return true;
    }

    public int getCurrentLength() {
        return this._currentSize;
    }

    public void setCurrentLength(int i) {
        this._currentSize = i;
    }

    public char[] finishCurrentSegment() {
        if (this._segments == null) {
            this._segments = new ArrayList<>();
        }
        this._segments.add(this._currentSegment);
        int length = this._currentSegment.length;
        this._segmentSize += length;
        char[] cArr = new char[calcNewSize(length)];
        this._currentSize = 0;
        this._currentSegment = cArr;
        return cArr;
    }

    private int calcNewSize(int i) {
        return Math.min(i + (i < 8000 ? i : i >> 1), MAX_SEGMENT_LENGTH);
    }

    public String toString() {
        this._resultString = null;
        this._resultArray = null;
        return contentsAsString();
    }

    private char[] allocBuffer() {
        int iMax = Math.max(500, 0);
        ReaderConfig readerConfig = this._config;
        if (readerConfig != null) {
            return readerConfig.allocMediumCBuffer(iMax);
        }
        return new char[iMax];
    }

    private char[] buildResultArray() {
        int i;
        String str = this._resultString;
        if (str != null) {
            return str.toCharArray();
        }
        int size = size();
        if (size < 1) {
            return sNoChars;
        }
        char[] cArr = new char[size];
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            i = 0;
            for (char[] cArr2 : arrayList) {
                int length = cArr2.length;
                System.arraycopy(cArr2, 0, cArr, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this._currentSegment, 0, cArr, i, this._currentSize);
        return cArr;
    }
}
