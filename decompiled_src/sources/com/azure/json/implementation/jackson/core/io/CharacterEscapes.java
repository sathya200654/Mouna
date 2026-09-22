package com.azure.json.implementation.jackson.core.io;

import com.azure.json.implementation.jackson.core.SerializableString;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class CharacterEscapes implements Serializable {
    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_STANDARD = -1;

    public abstract int[] getEscapeCodesForAscii();

    public abstract SerializableString getEscapeSequence(int i);
}
