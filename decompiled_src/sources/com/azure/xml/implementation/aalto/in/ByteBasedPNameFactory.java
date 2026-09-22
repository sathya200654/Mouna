package com.azure.xml.implementation.aalto.in;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ByteBasedPNameFactory {
    private static final boolean DO_INTERN = true;
    private static final ByteBasedPNameFactory sInstance = new ByteBasedPNameFactory();

    private ByteBasedPNameFactory() {
    }

    public static ByteBasedPNameFactory getInstance() {
        return sInstance;
    }

    public ByteBasedPName constructPName(int i, String str, int i2, int[] iArr, int i3) {
        if (i3 >= 4) {
            int[] iArr2 = new int[i3];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            if (i2 < 0) {
                String strIntern = str.intern();
                return new PNameN(strIntern, null, strIntern, i, iArr2, i3);
            }
            String strSubstring = str.substring(0, i2);
            return new PNameN(str, strSubstring.intern(), str.substring(i2 + 1).intern(), i, iArr2, i3);
        }
        if (i2 < 0) {
            String strIntern2 = str.intern();
            if (i3 == 3) {
                return new PName3(strIntern2, null, strIntern2, i, iArr);
            }
            if (i3 == 2) {
                return new PName2(strIntern2, null, strIntern2, i, iArr[0], iArr[1]);
            }
            return new PName1(strIntern2, null, strIntern2, i, iArr[0]);
        }
        String strSubstring2 = str.substring(0, i2);
        String strIntern3 = str.substring(i2 + 1).intern();
        String strIntern4 = strSubstring2.intern();
        if (i3 == 3) {
            return new PName3(str, strIntern4, strIntern3, i, iArr);
        }
        if (i3 == 2) {
            return new PName2(str, strIntern4, strIntern3, i, iArr[0], iArr[1]);
        }
        return new PName1(str, strIntern4, strIntern3, i, iArr[0]);
    }
}
