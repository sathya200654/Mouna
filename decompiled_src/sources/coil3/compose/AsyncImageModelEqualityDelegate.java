package coil3.compose;

import androidx.webkit.Profile;
import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalAsyncImageModelEqualityDelegate.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcoil3/compose/AsyncImageModelEqualityDelegate;", "", "equals", "", "self", "other", "hashCode", "", "Companion", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AsyncImageModelEqualityDelegate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final AsyncImageModelEqualityDelegate Default = new AsyncImageModelEqualityDelegate() { // from class: coil3.compose.AsyncImageModelEqualityDelegate$Companion$Default$1
        @Override // coil3.compose.AsyncImageModelEqualityDelegate
        public boolean equals(Object self, Object other) {
            if (this == other) {
                return true;
            }
            if (!(self instanceof ImageRequest) || !(other instanceof ImageRequest)) {
                return Intrinsics.areEqual(self, other);
            }
            ImageRequest imageRequest = (ImageRequest) self;
            ImageRequest imageRequest2 = (ImageRequest) other;
            return Intrinsics.areEqual(imageRequest.getContext(), imageRequest2.getContext()) && Intrinsics.areEqual(imageRequest.getData(), imageRequest2.getData()) && Intrinsics.areEqual(imageRequest.getMemoryCacheKey(), imageRequest2.getMemoryCacheKey()) && Intrinsics.areEqual(imageRequest.getMemoryCacheKeyExtras(), imageRequest2.getMemoryCacheKeyExtras()) && Intrinsics.areEqual(imageRequest.getDiskCacheKey(), imageRequest2.getDiskCacheKey()) && Intrinsics.areEqual(imageRequest.getSizeResolver(), imageRequest2.getSizeResolver()) && imageRequest.getScale() == imageRequest2.getScale() && imageRequest.getPrecision() == imageRequest2.getPrecision();
        }

        @Override // coil3.compose.AsyncImageModelEqualityDelegate
        public int hashCode(Object self) {
            if (!(self instanceof ImageRequest)) {
                if (self != null) {
                    return self.hashCode();
                }
                return 0;
            }
            ImageRequest imageRequest = (ImageRequest) self;
            int iHashCode = ((imageRequest.getContext().hashCode() * 31) + imageRequest.getData().hashCode()) * 31;
            String memoryCacheKey = imageRequest.getMemoryCacheKey();
            int iHashCode2 = (((iHashCode + (memoryCacheKey != null ? memoryCacheKey.hashCode() : 0)) * 31) + imageRequest.getMemoryCacheKeyExtras().hashCode()) * 31;
            String diskCacheKey = imageRequest.getDiskCacheKey();
            return ((((((iHashCode2 + (diskCacheKey != null ? diskCacheKey.hashCode() : 0)) * 31) + imageRequest.getSizeResolver().hashCode()) * 31) + imageRequest.getScale().hashCode()) * 31) + imageRequest.getPrecision().hashCode();
        }

        public String toString() {
            return "AsyncImageModelEqualityDelegate.Default";
        }
    };
    public static final AsyncImageModelEqualityDelegate AllProperties = new AsyncImageModelEqualityDelegate() { // from class: coil3.compose.AsyncImageModelEqualityDelegate$Companion$AllProperties$1
        @Override // coil3.compose.AsyncImageModelEqualityDelegate
        public boolean equals(Object self, Object other) {
            return Intrinsics.areEqual(self, other);
        }

        @Override // coil3.compose.AsyncImageModelEqualityDelegate
        public int hashCode(Object self) {
            if (self != null) {
                return self.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "AsyncImageModelEqualityDelegate.AllProperties";
        }
    };

    boolean equals(Object self, Object other);

    int hashCode(Object self);

    /* JADX INFO: compiled from: LocalAsyncImageModelEqualityDelegate.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lcoil3/compose/AsyncImageModelEqualityDelegate$Companion;", "", "<init>", "()V", Profile.DEFAULT_PROFILE_NAME, "Lcoil3/compose/AsyncImageModelEqualityDelegate;", "AllProperties", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
