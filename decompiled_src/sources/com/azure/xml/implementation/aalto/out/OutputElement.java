package com.azure.xml.implementation.aalto.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class OutputElement {
    private String _defaultNsURI;
    private WName _name;
    private NsBinder _nsBinder;
    private OutputElement _parent;
    private String _uri;

    private OutputElement() {
        this._parent = null;
        this._name = null;
        this._uri = null;
        this._nsBinder = null;
        this._defaultNsURI = "";
    }

    private OutputElement(OutputElement outputElement, WName wName, String str, NsBinder nsBinder) {
        this._parent = outputElement;
        this._name = wName;
        this._uri = str;
        this._nsBinder = nsBinder;
        this._defaultNsURI = outputElement._defaultNsURI;
    }

    static OutputElement createRoot() {
        return new OutputElement();
    }

    OutputElement createChild(WName wName) {
        return new OutputElement(this, wName, this._defaultNsURI, this._nsBinder);
    }

    OutputElement createChild(WName wName, String str) {
        return new OutputElement(this, wName, str, this._nsBinder);
    }

    OutputElement reuseAsChild(OutputElement outputElement, WName wName) {
        OutputElement outputElement2 = this._parent;
        relink(outputElement, wName, this._defaultNsURI);
        return outputElement2;
    }

    OutputElement reuseAsChild(OutputElement outputElement, WName wName, String str) {
        OutputElement outputElement2 = this._parent;
        relink(outputElement, wName, str);
        return outputElement2;
    }

    private void relink(OutputElement outputElement, WName wName, String str) {
        this._parent = outputElement;
        this._name = wName;
        this._uri = str;
        this._nsBinder = outputElement._nsBinder;
        this._defaultNsURI = outputElement._defaultNsURI;
    }

    void addToPool(OutputElement outputElement) {
        this._parent = outputElement;
    }

    public OutputElement getParent() {
        return this._parent;
    }

    public boolean isRoot() {
        return this._parent == null;
    }

    public WName getName() {
        return this._name;
    }

    public String getLocalName() {
        return this._name.getLocalName();
    }

    public QName getQName() {
        return new QName(this._uri, this._name.getLocalName(), this._name.getPrefix());
    }

    public void setDefaultNsURI(String str) {
        this._defaultNsURI = str;
    }

    public void addPrefix(String str, String str2) {
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder == null) {
            this._nsBinder = NsBinder.createEmpty();
        } else {
            OutputElement outputElement = this._parent;
            if (outputElement != null && outputElement._nsBinder == nsBinder) {
                this._nsBinder = nsBinder.createChild();
            }
        }
        this._nsBinder.addMapping(str, str2);
    }

    public String getNamespaceURI(String str) {
        if (str.isEmpty()) {
            return this._defaultNsURI;
        }
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder != null) {
            return nsBinder.findUriByPrefix(str);
        }
        return null;
    }

    public String getPrefix(String str) {
        if (this._defaultNsURI.equals(str)) {
            return "";
        }
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder != null) {
            return nsBinder.findPrefixByUri(str);
        }
        return null;
    }

    public Iterator<String> getPrefixes(String str, NamespaceContext namespaceContext) {
        List<String> arrayList;
        if (this._defaultNsURI.equals(str)) {
            arrayList = new ArrayList<>();
            arrayList.add("");
        } else {
            arrayList = null;
        }
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder != null) {
            arrayList = nsBinder.getPrefixesBoundToUri(str, arrayList);
        }
        if (namespaceContext != null) {
            Iterator prefixes = namespaceContext.getPrefixes(str);
            while (prefixes.hasNext()) {
                String str2 = (String) prefixes.next();
                if (!str2.isEmpty()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    } else if (arrayList.contains(str2)) {
                    }
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList == null) {
            return Collections.emptyIterator();
        }
        return arrayList.iterator();
    }

    public String getExplicitPrefix(String str, NamespaceContext namespaceContext) {
        String prefix;
        String strFindPrefixByUri;
        NsBinder nsBinder = this._nsBinder;
        if (nsBinder != null && (strFindPrefixByUri = nsBinder.findPrefixByUri(str)) != null) {
            return strFindPrefixByUri;
        }
        if (namespaceContext == null || (prefix = namespaceContext.getPrefix(str)) == null || prefix.isEmpty()) {
            return null;
        }
        return prefix;
    }

    public int hashCode() {
        return this._name.hashCode();
    }
}
