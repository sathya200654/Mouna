package com.azure.xml.implementation.aalto.in;

import com.azure.xml.implementation.aalto.util.NameTable;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.firebase.perf.util.Constants;
import com.google.protobuf.Reader;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ByteBasedPNameTable extends NameTable {
    static final int INITIAL_COLLISION_LEN = 32;
    static final int LAST_VALID_BUCKET = 254;
    static final int MIN_HASH_SIZE = 16;
    private int mCollCount;
    private int mCollEnd;
    private Bucket[] mCollList;
    private boolean mCollListShared;
    private int mCount;
    private int[] mMainHash;
    private int mMainHashMask;
    private boolean mMainHashShared;
    private ByteBasedPName[] mMainNames;
    private boolean mMainNamesShared;
    private transient boolean mNeedRehash;

    public static int calcHash(int i) {
        int i2 = i * 31;
        int i3 = i2 ^ (i2 >>> 16);
        return i3 ^ (i3 >>> 8);
    }

    public static int calcHash(int i, int i2) {
        int i3 = (i * 31) + i2;
        int i4 = i3 ^ (i3 >>> 16);
        return i4 ^ (i4 >>> 8);
    }

    public ByteBasedPNameTable(int i) {
        int i2 = 16;
        if (i < 16) {
            i = i2;
        } else if (((i - 1) & i) != 0) {
            while (i2 < i) {
                i2 += i2;
            }
            i = i2;
        }
        this.mCount = 0;
        this.mMainHashShared = false;
        this.mMainNamesShared = false;
        this.mMainHashMask = i - 1;
        this.mMainHash = new int[i];
        this.mMainNames = new ByteBasedPName[i];
        this.mCollListShared = true;
        this.mCollList = null;
        this.mCollEnd = 0;
        this.mNeedRehash = false;
    }

    ByteBasedPNameTable(ByteBasedPNameTable byteBasedPNameTable) {
        this.mCount = byteBasedPNameTable.mCount;
        this.mMainHashMask = byteBasedPNameTable.mMainHashMask;
        this.mMainHash = byteBasedPNameTable.mMainHash;
        this.mMainNames = byteBasedPNameTable.mMainNames;
        this.mCollList = byteBasedPNameTable.mCollList;
        this.mCollCount = byteBasedPNameTable.mCollCount;
        this.mCollEnd = byteBasedPNameTable.mCollEnd;
        this.mNeedRehash = false;
        this.mMainHashShared = true;
        this.mMainNamesShared = true;
        this.mCollListShared = true;
    }

    public void mergeFromChild(ByteBasedPNameTable byteBasedPNameTable) {
        int i = byteBasedPNameTable.mCount;
        if (i <= this.mCount) {
            return;
        }
        this.mCount = i;
        this.mMainHashMask = byteBasedPNameTable.mMainHashMask;
        this.mMainHash = byteBasedPNameTable.mMainHash;
        this.mMainNames = byteBasedPNameTable.mMainNames;
        this.mCollList = byteBasedPNameTable.mCollList;
        this.mCollCount = byteBasedPNameTable.mCollCount;
        this.mCollEnd = byteBasedPNameTable.mCollEnd;
        byteBasedPNameTable.markAsShared();
    }

    public void markAsShared() {
        this.mMainHashShared = true;
        this.mMainNamesShared = true;
        this.mCollListShared = true;
    }

    @Override // com.azure.xml.implementation.aalto.util.NameTable
    public int size() {
        return this.mCount;
    }

    @Override // com.azure.xml.implementation.aalto.util.NameTable
    public boolean maybeDirty() {
        return !this.mMainHashShared;
    }

    public ByteBasedPName findSymbol(int i, int i2, int i3) {
        int i4 = this.mMainHashMask & i;
        int i5 = this.mMainHash[i4];
        if ((((i5 >> 8) ^ i) << 8) == 0) {
            ByteBasedPName byteBasedPName = this.mMainNames[i4];
            if (byteBasedPName == null) {
                return null;
            }
            if (byteBasedPName.equals(i2, i3)) {
                return byteBasedPName;
            }
        } else if (i5 == 0) {
            return null;
        }
        int i6 = i5 & Constants.MAX_HOST_LENGTH;
        if (i6 > 0) {
            Bucket bucket = this.mCollList[i6 - 1];
            if (bucket != null) {
                return bucket.find(i, i2, i3);
            }
        }
        return null;
    }

    public ByteBasedPName findSymbol(int i, int[] iArr, int i2) {
        if (i2 < 3) {
            return findSymbol(i, iArr[0], i2 >= 2 ? iArr[1] : 0);
        }
        int i3 = this.mMainHashMask & i;
        int i4 = this.mMainHash[i3];
        if ((((i4 >> 8) ^ i) << 8) == 0) {
            ByteBasedPName byteBasedPName = this.mMainNames[i3];
            if (byteBasedPName == null) {
                return null;
            }
            if (byteBasedPName.equals(iArr, i2)) {
                return byteBasedPName;
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = i4 & Constants.MAX_HOST_LENGTH;
        if (i5 > 0) {
            Bucket bucket = this.mCollList[i5 - 1];
            if (bucket != null) {
                return bucket.find(i, iArr, i2);
            }
        }
        return null;
    }

    public ByteBasedPName addSymbol(int i, String str, int i2, int[] iArr, int i3) {
        ByteBasedPName byteBasedPNameConstructPName = ByteBasedPNameFactory.getInstance().constructPName(i, str, i2, iArr, i3);
        doAddSymbol(i, byteBasedPNameConstructPName);
        return byteBasedPNameConstructPName;
    }

    public static int calcHash(int[] iArr, int i) {
        int i2 = iArr[0];
        for (int i3 = 1; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        int i4 = (i2 >>> 16) ^ i2;
        return i4 ^ (i4 >>> 8);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[PNameTable, size: ");
        sb.append(this.mCount);
        sb.append(JsonPointer.SEPARATOR);
        sb.append(this.mMainHash.length);
        sb.append(", ");
        sb.append(this.mCollCount);
        sb.append(" coll; avg length: ");
        int i = this.mCount;
        for (int i2 = 0; i2 < this.mCollEnd; i2++) {
            for (int i3 = 1; i3 <= this.mCollList[i2].length(); i3++) {
                i += i3;
            }
        }
        int i4 = this.mCount;
        sb.append(i4 == 0 ? 0.0d : ((double) i) / ((double) i4));
        sb.append(']');
        return sb.toString();
    }

    private void doAddSymbol(int i, ByteBasedPName byteBasedPName) {
        int iFindBestBucket;
        if (this.mMainHashShared) {
            unshareMain();
        }
        if (this.mNeedRehash) {
            rehash();
        }
        this.mCount++;
        int i2 = this.mMainHashMask & i;
        if (this.mMainNames[i2] == null) {
            this.mMainHash[i2] = i << 8;
            if (this.mMainNamesShared) {
                unshareNames();
            }
            this.mMainNames[i2] = byteBasedPName;
        } else {
            if (this.mCollListShared) {
                unshareCollision();
            }
            this.mCollCount++;
            int i3 = this.mMainHash[i2];
            int i4 = i3 & Constants.MAX_HOST_LENGTH;
            if (i4 == 0) {
                iFindBestBucket = this.mCollEnd;
                if (iFindBestBucket <= LAST_VALID_BUCKET) {
                    this.mCollEnd = iFindBestBucket + 1;
                    if (iFindBestBucket >= this.mCollList.length) {
                        expandCollision();
                    }
                } else {
                    iFindBestBucket = findBestBucket();
                }
                this.mMainHash[i2] = (i3 & (-256)) | (iFindBestBucket + 1);
            } else {
                iFindBestBucket = i4 - 1;
            }
            this.mCollList[iFindBestBucket] = new Bucket(byteBasedPName, this.mCollList[iFindBestBucket]);
        }
        int length = this.mMainHash.length;
        int i5 = this.mCount;
        if (i5 > (length >> 1)) {
            int i6 = length >> 2;
            if (i5 > length - i6) {
                this.mNeedRehash = true;
            } else if (this.mCollCount >= i6) {
                this.mNeedRehash = true;
            }
        }
    }

    private void rehash() {
        int iFindBestBucket;
        this.mNeedRehash = false;
        this.mMainNamesShared = false;
        int length = this.mMainHash.length;
        int i = length + length;
        this.mMainHash = new int[i];
        this.mMainHashMask = i - 1;
        ByteBasedPName[] byteBasedPNameArr = this.mMainNames;
        this.mMainNames = new ByteBasedPName[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            ByteBasedPName byteBasedPName = byteBasedPNameArr[i3];
            if (byteBasedPName != null) {
                i2++;
                int iHashCode = byteBasedPName.hashCode();
                int i4 = this.mMainHashMask & iHashCode;
                this.mMainNames[i4] = byteBasedPName;
                this.mMainHash[i4] = iHashCode << 8;
            }
        }
        int i5 = this.mCollEnd;
        if (i5 == 0) {
            return;
        }
        this.mCollCount = 0;
        this.mCollEnd = 0;
        this.mCollListShared = false;
        Bucket[] bucketArr = this.mCollList;
        this.mCollList = new Bucket[bucketArr.length];
        for (int i6 = 0; i6 < i5; i6++) {
            for (Bucket bucket = bucketArr[i6]; bucket != null; bucket = bucket.mNext) {
                i2++;
                ByteBasedPName byteBasedPName2 = bucket.mName;
                int iHashCode2 = byteBasedPName2.hashCode();
                int i7 = this.mMainHashMask & iHashCode2;
                int[] iArr = this.mMainHash;
                int i8 = iArr[i7];
                ByteBasedPName[] byteBasedPNameArr2 = this.mMainNames;
                if (byteBasedPNameArr2[i7] == null) {
                    iArr[i7] = iHashCode2 << 8;
                    byteBasedPNameArr2[i7] = byteBasedPName2;
                } else {
                    this.mCollCount++;
                    int i9 = i8 & Constants.MAX_HOST_LENGTH;
                    if (i9 == 0) {
                        iFindBestBucket = this.mCollEnd;
                        if (iFindBestBucket <= LAST_VALID_BUCKET) {
                            this.mCollEnd = iFindBestBucket + 1;
                            if (iFindBestBucket >= this.mCollList.length) {
                                expandCollision();
                            }
                        } else {
                            iFindBestBucket = findBestBucket();
                        }
                        this.mMainHash[i7] = (i8 & (-256)) | (iFindBestBucket + 1);
                    } else {
                        iFindBestBucket = i9 - 1;
                    }
                    this.mCollList[iFindBestBucket] = new Bucket(byteBasedPName2, this.mCollList[iFindBestBucket]);
                }
            }
        }
        if (i2 != this.mCount) {
            throw new Error("Internal error: count after rehash " + i2 + "; should be " + this.mCount);
        }
    }

    private int findBestBucket() {
        Bucket[] bucketArr = this.mCollList;
        int i = this.mCollEnd;
        int i2 = Reader.READ_DONE;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            int length = bucketArr[i4].length();
            if (length < i2) {
                if (length == 1) {
                    return i4;
                }
                i3 = i4;
                i2 = length;
            }
        }
        return i3;
    }

    private void unshareMain() {
        int[] iArr = this.mMainHash;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        this.mMainHash = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.mMainHashShared = false;
    }

    private void unshareCollision() {
        Bucket[] bucketArr = this.mCollList;
        if (bucketArr == null) {
            this.mCollList = new Bucket[32];
        } else {
            int length = bucketArr.length;
            Bucket[] bucketArr2 = new Bucket[length];
            this.mCollList = bucketArr2;
            System.arraycopy(bucketArr, 0, bucketArr2, 0, length);
        }
        this.mCollListShared = false;
    }

    private void unshareNames() {
        ByteBasedPName[] byteBasedPNameArr = this.mMainNames;
        int length = byteBasedPNameArr.length;
        ByteBasedPName[] byteBasedPNameArr2 = new ByteBasedPName[length];
        this.mMainNames = byteBasedPNameArr2;
        System.arraycopy(byteBasedPNameArr, 0, byteBasedPNameArr2, 0, length);
        this.mMainNamesShared = false;
    }

    private void expandCollision() {
        Bucket[] bucketArr = this.mCollList;
        int length = bucketArr.length;
        Bucket[] bucketArr2 = new Bucket[length + length];
        this.mCollList = bucketArr2;
        System.arraycopy(bucketArr, 0, bucketArr2, 0, length);
    }

    static final class Bucket {
        final ByteBasedPName mName;
        final Bucket mNext;

        Bucket(ByteBasedPName byteBasedPName, Bucket bucket) {
            this.mName = byteBasedPName;
            this.mNext = bucket;
        }

        public int length() {
            int i = 1;
            for (Bucket bucket = this.mNext; bucket != null; bucket = bucket.mNext) {
                i++;
            }
            return i;
        }

        public ByteBasedPName find(int i, int i2, int i3) {
            ByteBasedPName byteBasedPName;
            if (this.mName.hashEquals(i, i2, i3)) {
                return this.mName;
            }
            do {
                this = this.mNext;
                if (this == null) {
                    return null;
                }
                byteBasedPName = this.mName;
            } while (!byteBasedPName.hashEquals(i, i2, i3));
            return byteBasedPName;
        }

        public ByteBasedPName find(int i, int[] iArr, int i2) {
            ByteBasedPName byteBasedPName;
            if (this.mName.hashEquals(i, iArr, i2)) {
                return this.mName;
            }
            do {
                this = this.mNext;
                if (this == null) {
                    return null;
                }
                byteBasedPName = this.mName;
            } while (!byteBasedPName.hashEquals(i, iArr, i2));
            return byteBasedPName;
        }
    }
}
