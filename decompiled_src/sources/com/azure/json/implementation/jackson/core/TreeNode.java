package com.azure.json.implementation.jackson.core;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface TreeNode {
    TreeNode get(int i);

    TreeNode get(String str);

    boolean isArray();

    boolean isObject();

    int size();
}
