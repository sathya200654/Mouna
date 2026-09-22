package com.azure.xml.implementation.aalto.in;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ElementScope {
    PName mName;
    ElementScope mParent;

    public ElementScope(PName pName, ElementScope elementScope) {
        this.mParent = elementScope;
        this.mName = pName;
    }

    public PName getName() {
        return this.mName;
    }

    public ElementScope getParent() {
        return this.mParent;
    }

    public String toString() {
        if (this.mParent == null) {
            return this.mName.toString();
        }
        return this.mParent + RemoteSettings.FORWARD_SLASH_STRING + this.mName;
    }
}
