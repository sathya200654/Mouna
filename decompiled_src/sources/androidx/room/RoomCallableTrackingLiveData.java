package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoomTrackingLiveData.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0096@¢\u0006\u0002\u0010\u0011R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/RoomCallableTrackingLiveData;", "T", "Landroidx/room/RoomTrackingLiveData;", "database", "Landroidx/room/RoomDatabase;", "container", "Landroidx/room/InvalidationLiveDataContainer;", "inTransaction", "", "tableNames", "", "", "callableFunction", "Ljava/util/concurrent/Callable;", "<init>", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)V", "compute", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RoomCallableTrackingLiveData<T> extends RoomTrackingLiveData<T> {
    private final Callable<T> callableFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomCallableTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, String[] strArr, Callable<T> callable) {
        super(roomDatabase, invalidationLiveDataContainer, z, strArr, null);
        Intrinsics.checkNotNullParameter(roomDatabase, "database");
        Intrinsics.checkNotNullParameter(invalidationLiveDataContainer, "container");
        Intrinsics.checkNotNullParameter(strArr, "tableNames");
        Intrinsics.checkNotNullParameter(callable, "callableFunction");
        this.callableFunction = callable;
    }

    @Override // androidx.room.RoomTrackingLiveData
    public Object compute(Continuation<? super T> continuation) {
        return this.callableFunction.call();
    }
}
