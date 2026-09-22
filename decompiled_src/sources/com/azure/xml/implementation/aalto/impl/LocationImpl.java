package com.azure.xml.implementation.aalto.impl;

import com.google.protobuf.Reader;
import javax.xml.stream.Location;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class LocationImpl implements Location {
    protected final int _charOffset;
    protected final int _col;
    protected transient String _desc = null;
    protected final int _row;

    public String getPublicId() {
        return null;
    }

    public String getSystemId() {
        return null;
    }

    public LocationImpl(int i, int i2, int i3) {
        this._charOffset = i < 0 ? Reader.READ_DONE : i;
        this._col = i3;
        this._row = i2;
    }

    public static LocationImpl fromZeroBased(long j, int i, int i2) {
        return new LocationImpl((int) j, i + 1, i2 + 1);
    }

    public int getCharacterOffset() {
        return this._charOffset;
    }

    public int getColumnNumber() {
        return this._col;
    }

    public int getLineNumber() {
        return this._row;
    }

    public String toString() {
        if (this._desc == null) {
            this._desc = "[row,col {unknown-source}]: [" + this._row + ',' + this._col + ']';
        }
        return this._desc;
    }
}
