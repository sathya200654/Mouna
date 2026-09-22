package com.azure.xml.implementation.aalto.in;

import java.util.Objects;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class PName {
    protected final String _localName;
    protected NsBinding _namespaceBinding = null;
    protected final String _prefix;
    protected final String _prefixedName;

    public abstract PName createBoundName(NsBinding nsBinding);

    public abstract int getQuad(int i);

    public abstract int sizeInQuads();

    protected PName(String str, String str2, String str3) {
        this._prefixedName = str;
        this._prefix = str2;
        this._localName = str3;
    }

    public final String getPrefixedName() {
        return this._prefixedName;
    }

    public final String getPrefix() {
        return this._prefix;
    }

    public final String getLocalName() {
        return this._localName;
    }

    public final String getNsUri() {
        NsBinding nsBinding = this._namespaceBinding;
        if (nsBinding == null) {
            return null;
        }
        return nsBinding.mURI;
    }

    public final QName constructQName() {
        String str = this._prefix;
        NsBinding nsBinding = this._namespaceBinding;
        String str2 = nsBinding == null ? null : nsBinding.mURI;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this._localName;
        if (str == null) {
            str = "";
        }
        return new QName(str2, str3, str);
    }

    public final QName constructQName(NsBinding nsBinding) {
        String str;
        String str2 = this._prefix;
        if (str2 == null) {
            str2 = "";
        }
        NsBinding nsBinding2 = this._namespaceBinding;
        if (nsBinding2 != null && (str = nsBinding2.mURI) != null) {
            return new QName(str, this._localName, str2);
        }
        String str3 = nsBinding.mURI;
        return new QName(str3 != null ? str3 : "", this._localName, str2);
    }

    public final boolean isBound() {
        NsBinding nsBinding = this._namespaceBinding;
        return nsBinding == null || nsBinding.mURI != null;
    }

    public final boolean boundEquals(PName pName) {
        if (pName == null || !Objects.equals(pName._localName, this._localName)) {
            return false;
        }
        return Objects.equals(pName.getNsUri(), getNsUri());
    }

    public final boolean unboundEquals(PName pName) {
        return Objects.equals(pName._prefixedName, this._prefixedName);
    }

    public final boolean boundEquals(String str, String str2) {
        if (!this._localName.equals(str2)) {
            return false;
        }
        String nsUri = getNsUri();
        if (str == null || str.isEmpty()) {
            return nsUri == null;
        }
        return str.equals(nsUri);
    }

    public final int unboundHashCode() {
        return this._prefixedName.hashCode();
    }

    public final int boundHashCode() {
        return this._localName.hashCode();
    }

    public static int boundHashCode(String str) {
        return str.hashCode();
    }

    public final String toString() {
        return this._prefixedName;
    }

    public int hashCode() {
        return this._prefixedName.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PName)) {
            return false;
        }
        PName pName = (PName) obj;
        return Objects.equals(pName._prefix, this._prefix) && Objects.equals(pName._localName, this._localName);
    }
}
