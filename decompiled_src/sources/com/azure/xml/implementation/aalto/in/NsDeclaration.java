package com.azure.xml.implementation.aalto.in;

import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NsDeclaration {
    private final NsBinding mBinding;
    private final int mLevel;
    private final NsDeclaration mPrevDeclaration;
    private final String mPreviousURI;

    public NsDeclaration(NsBinding nsBinding, String str, NsDeclaration nsDeclaration, int i) {
        this.mBinding = nsBinding;
        this.mPrevDeclaration = nsDeclaration;
        this.mLevel = i;
        this.mPreviousURI = nsBinding.mURI;
        nsBinding.mURI = str;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public NsDeclaration getPrev() {
        return this.mPrevDeclaration;
    }

    public NsBinding getBinding() {
        return this.mBinding;
    }

    public String getPrefix() {
        return this.mBinding.mPrefix;
    }

    public String getCurrNsURI() {
        return this.mBinding.mURI;
    }

    public boolean hasPrefix(String str) {
        return str.equals(this.mBinding.mPrefix);
    }

    public boolean hasNsURI(String str) {
        return str.equals(this.mBinding.mURI);
    }

    public NsDeclaration unbind() {
        this.mBinding.mURI = this.mPreviousURI;
        return this.mPrevDeclaration;
    }

    public boolean alreadyDeclared(String str, int i) {
        if (this.mLevel < i) {
            return false;
        }
        if (Objects.equals(str, this.mBinding.mPrefix)) {
            return true;
        }
        for (NsDeclaration nsDeclaration = this.mPrevDeclaration; nsDeclaration != null && nsDeclaration.mLevel >= i; nsDeclaration = nsDeclaration.mPrevDeclaration) {
            if (Objects.equals(str, nsDeclaration.mBinding.mPrefix)) {
                return true;
            }
        }
        return false;
    }

    public int countDeclsOnLevel(int i) {
        if (this.mLevel != i) {
            return 0;
        }
        int i2 = 1;
        for (NsDeclaration nsDeclaration = this.mPrevDeclaration; nsDeclaration != null && nsDeclaration.mLevel == i; nsDeclaration = nsDeclaration.mPrevDeclaration) {
            i2++;
        }
        return i2;
    }

    public String toString() {
        return "[NS-DECL, prefix = <" + this.mBinding.mPrefix + ">, current URI <" + this.mBinding.mURI + ">, level " + this.mLevel + ", prev URI <" + this.mPreviousURI + ">]";
    }
}
