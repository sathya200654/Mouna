package com.azure.json.implementation.jackson.core.sym;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class Name {
    protected final int _hashCode;
    protected final String _name;

    public abstract boolean equals(int i);

    public abstract boolean equals(int i, int i2);

    public abstract boolean equals(int i, int i2, int i3);

    public boolean equals(Object obj) {
        return obj == this;
    }

    public abstract boolean equals(int[] iArr, int i);

    protected Name(String str, int i) {
        this._name = str;
        this._hashCode = i;
    }

    public String getName() {
        return this._name;
    }

    public String toString() {
        return this._name;
    }

    public final int hashCode() {
        return this._hashCode;
    }
}
