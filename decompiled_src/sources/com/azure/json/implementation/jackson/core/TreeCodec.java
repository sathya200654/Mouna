package com.azure.json.implementation.jackson.core;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class TreeCodec {
    public abstract void writeTree(JsonGenerator jsonGenerator, TreeNode treeNode) throws IOException;
}
