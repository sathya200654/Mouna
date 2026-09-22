package com.azure.json.implementation.jackson.core;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class StreamReadConstraints implements Serializable {
    public static final int DEFAULT_MAX_DEPTH = 1000;
    public static final long DEFAULT_MAX_DOC_LEN = -1;
    public static final int DEFAULT_MAX_NAME_LEN = 50000;
    public static final int DEFAULT_MAX_NUM_LEN = 1000;
    public static final int DEFAULT_MAX_STRING_LEN = 20000000;
    private static final long serialVersionUID = 1;
    protected final long _maxDocLen;
    protected final int _maxNameLen;
    protected final int _maxNestingDepth;
    protected final int _maxNumLen;
    protected final int _maxStringLen;

    public static final class Builder {
        private final long maxDocLen;
        private final int maxNameLen;
        private final int maxNestingDepth;
        private final int maxNumLen;
        private final int maxStringLen;

        Builder() {
            this(1000, -1L, 1000, 20000000, 50000);
        }

        Builder(int i, long j, int i2, int i3, int i4) {
            this.maxNestingDepth = i;
            this.maxDocLen = j;
            this.maxNumLen = i2;
            this.maxStringLen = i3;
            this.maxNameLen = i4;
        }

        public StreamReadConstraints build() {
            return new StreamReadConstraints(this.maxNestingDepth, this.maxDocLen, this.maxNumLen, this.maxStringLen, this.maxNameLen);
        }
    }

    @Deprecated
    protected StreamReadConstraints(int i, long j, int i2, int i3) {
        this(i, -1L, i2, i3, 50000);
    }

    protected StreamReadConstraints(int i, long j, int i2, int i3, int i4) {
        this._maxNestingDepth = i;
        this._maxDocLen = j;
        this._maxNumLen = i2;
        this._maxStringLen = i3;
        this._maxNameLen = i4;
    }

    public static Builder builder() {
        return new Builder();
    }
}
