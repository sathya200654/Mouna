package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ConnectionPoolImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bJ@\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u0006\u0010(\u001a\u00020\u00192\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0,\u0012\u0006\u0012\u0004\u0018\u00010-0*H\u0096@¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0011H\u0002J\u0010\u00102\u001a\u0002032\u0006\u0010(\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u000203H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010%¨\u00065"}, d2 = {"Landroidx/room/coroutines/ConnectionPoolImpl;", "Landroidx/room/coroutines/ConnectionPool;", "driver", "Landroidx/sqlite/SQLiteDriver;", "fileName", "", "<init>", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;)V", "maxNumOfReaders", "", "maxNumOfWriters", "(Landroidx/sqlite/SQLiteDriver;Ljava/lang/String;II)V", "readers", "Landroidx/room/coroutines/Pool;", "writers", "threadLocal", "Ljava/lang/ThreadLocal;", "Landroidx/room/coroutines/PooledConnectionImpl;", "Landroidx/room/concurrent/ThreadLocal;", "Ljava/lang/ThreadLocal;", "_isClosed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/room/concurrent/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "", "()Z", "timeout", "Lkotlin/time/Duration;", "getTimeout-UwyO8pc$room_runtime_release", "()J", "setTimeout-LRDsOJo$room_runtime_release", "(J)V", "J", "throwOnTimeout", "getThrowOnTimeout$room_runtime_release", "setThrowOnTimeout$room_runtime_release", "(Z)V", "useConnection", "R", "isReadOnly", "block", "Lkotlin/Function2;", "Landroidx/room/Transactor;", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConnectionContext", "Lkotlin/coroutines/CoroutineContext;", "connection", "onTimeout", "", "close", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final SQLiteDriver driver;
    private final Pool readers;
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
    private boolean throwOnTimeout;
    private long timeout;
    private final Pool writers;

    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", i = {2, 2, 2, 2, 2, 2, 3, 3}, l = {116, 120, 138, 143}, m = "useConnection", n = {"this", "block", "pool", "connection", "currentContext", "isReadOnly", "pool", "connection"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectionPoolImpl.this.useConnection(false, null, (Continuation) this);
        }
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    /* JADX INFO: renamed from: getTimeout-UwyO8pc$room_runtime_release, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    /* JADX INFO: renamed from: setTimeout-LRDsOJo$room_runtime_release, reason: not valid java name */
    public final void m17setTimeoutLRDsOJo$room_runtime_release(long j) {
        this.timeout = j;
    }

    /* JADX INFO: renamed from: getThrowOnTimeout$room_runtime_release, reason: from getter */
    public final boolean getThrowOnTimeout() {
        return this.throwOnTimeout;
    }

    public final void setThrowOnTimeout$room_runtime_release(boolean z) {
        this.throwOnTimeout = z;
    }

    public ConnectionPoolImpl(final SQLiteDriver sQLiteDriver, final String str) {
        Intrinsics.checkNotNullParameter(sQLiteDriver, "driver");
        Intrinsics.checkNotNullParameter(str, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.Companion;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        this.driver = sQLiteDriver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda2
            public final Object invoke() {
                return sQLiteDriver.open(str);
            }
        });
        this.readers = pool;
        this.writers = pool;
    }

    public ConnectionPoolImpl(final SQLiteDriver sQLiteDriver, final String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(sQLiteDriver, "driver");
        Intrinsics.checkNotNullParameter(str, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        Duration.Companion companion = Duration.Companion;
        this.timeout = DurationKt.toDuration(30, DurationUnit.SECONDS);
        if (i <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0".toString());
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("Maximum number of writers must be greater than 0".toString());
        }
        this.driver = sQLiteDriver;
        this.readers = new Pool(i, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda0
            public final Object invoke() {
                return ConnectionPoolImpl._init_$lambda$4(sQLiteDriver, str);
            }
        });
        this.writers = new Pool(i2, new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda1
            public final Object invoke() {
                return sQLiteDriver.open(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection sQLiteConnectionOpen = sQLiteDriver.open(str);
        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA query_only = 1");
        return sQLiteConnectionOpen;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    /* JADX WARN: Code duplicated, block: B:67:0x0127  */
    /* JADX WARN: Code duplicated, block: B:70:0x0133 A[Catch: all -> 0x017e, TRY_LEAVE, TryCatch #5 {all -> 0x017e, blocks: (B:63:0x0118, B:68:0x0128, B:70:0x0133, B:78:0x0172, B:79:0x017d, B:59:0x00f1), top: B:104:0x00f1 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0157  */
    /* JADX WARN: Code duplicated, block: B:76:0x0160 A[Catch: all -> 0x0171, TRY_LEAVE, TryCatch #0 {all -> 0x0171, blocks: (B:74:0x015a, B:76:0x0160), top: B:94:0x015a }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0172 A[Catch: all -> 0x017e, TRY_ENTER, TryCatch #5 {all -> 0x017e, blocks: (B:63:0x0118, B:68:0x0128, B:70:0x0133, B:78:0x0172, B:79:0x017d, B:59:0x00f1), top: B:104:0x00f1 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.room.coroutines.ConnectionPool
    public <R> Object useConnection(final boolean z, Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws KotlinNothingValueException {
        AnonymousClass1 anonymousClass1;
        Pool pool;
        Ref.ObjectRef objectRef;
        Pool pool2;
        Ref.ObjectRef objectRef2;
        Object objM18acquireWithTimeoutKLykuaI;
        Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function3;
        CoroutineContext coroutineContext;
        ConnectionPoolImpl connectionPoolImpl;
        Ref.ObjectRef objectRef3;
        Object objWithContext;
        PooledConnectionImpl pooledConnectionImpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z2 = true;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i == 3) {
                z = anonymousClass1.Z$0;
                objectRef3 = (Ref.ObjectRef) anonymousClass1.L$5;
                coroutineContext = (CoroutineContext) anonymousClass1.L$4;
                objectRef = (Ref.ObjectRef) anonymousClass1.L$3;
                Pool pool3 = (Pool) anonymousClass1.L$2;
                function3 = (Function2) anonymousClass1.L$1;
                connectionPoolImpl = (ConnectionPoolImpl) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    objM18acquireWithTimeoutKLykuaI = obj;
                    pool = pool3;
                    ConnectionWithLock connectionWithLockMarkAcquired = ((ConnectionWithLock) objM18acquireWithTimeoutKLykuaI).markAcquired(coroutineContext);
                    if (connectionPoolImpl.readers != connectionPoolImpl.writers || !z) {
                        z2 = false;
                    }
                    objectRef3.element = new PooledConnectionImpl(connectionWithLockMarkAcquired, z2);
                    if (objectRef.element != null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    CoroutineContext coroutineContextCreateConnectionContext = connectionPoolImpl.createConnectionContext((PooledConnectionImpl) objectRef.element);
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(function3, objectRef, null);
                    anonymousClass1.L$0 = pool;
                    anonymousClass1.L$1 = objectRef;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 4;
                    objWithContext = BuildersKt.withContext(coroutineContextCreateConnectionContext, anonymousClass4, anonymousClass1);
                    if (objWithContext != coroutine_suspended) {
                        pool2 = pool;
                        obj = objWithContext;
                        objectRef2 = objectRef;
                        pooledConnectionImpl = (PooledConnectionImpl) objectRef2.element;
                        if (pooledConnectionImpl != null) {
                            pooledConnectionImpl.markRecycled();
                            pooledConnectionImpl.getDelegate().markReleased();
                            pool2.recycle(pooledConnectionImpl.getDelegate());
                        }
                        return obj;
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    th = th;
                    objectRef2 = objectRef;
                    pool2 = pool3;
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef2 = (Ref.ObjectRef) anonymousClass1.L$1;
                pool2 = (Pool) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    try {
                        pooledConnectionImpl = (PooledConnectionImpl) objectRef2.element;
                        if (pooledConnectionImpl != null) {
                            pooledConnectionImpl.markRecycled();
                            pooledConnectionImpl.getDelegate().markReleased();
                            pool2.recycle(pooledConnectionImpl.getDelegate());
                        }
                    } catch (Throwable unused) {
                    }
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            try {
                throw th;
            } catch (Throwable th3) {
                try {
                    PooledConnectionImpl pooledConnectionImpl2 = (PooledConnectionImpl) objectRef2.element;
                    if (pooledConnectionImpl2 != null) {
                        pooledConnectionImpl2.markRecycled();
                        pooledConnectionImpl2.getDelegate().markReleased();
                        pool2.recycle(pooledConnectionImpl2.getDelegate());
                    }
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th, th4);
                }
                throw th3;
            }
        }
        ResultKt.throwOnFailure(obj);
        if (isClosed()) {
            SQLite.throwSQLiteException(21, "Connection pool is closed");
            throw new KotlinNothingValueException();
        }
        PooledConnectionImpl connectionWrapper = this.threadLocal.get();
        if (connectionWrapper == null) {
            ConnectionElement connectionElement = (ConnectionElement) anonymousClass1.getContext().get(ConnectionElement.INSTANCE);
            connectionWrapper = connectionElement != null ? connectionElement.getConnectionWrapper() : null;
        }
        if (connectionWrapper != null) {
            if (!z && connectionWrapper.getIsReadOnly()) {
                SQLite.throwSQLiteException(1, "Cannot upgrade connection from reader to writer");
                throw new KotlinNothingValueException();
            }
            if (anonymousClass1.getContext().get(ConnectionElement.INSTANCE) == null) {
                CoroutineContext coroutineContextCreateConnectionContext2 = createConnectionContext(connectionWrapper);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(function2, connectionWrapper, null);
                anonymousClass1.label = 1;
                Object objWithContext2 = BuildersKt.withContext(coroutineContextCreateConnectionContext2, anonymousClass2, anonymousClass1);
                if (objWithContext2 != coroutine_suspended) {
                    return objWithContext2;
                }
            } else {
                anonymousClass1.label = 2;
                Object objInvoke = function2.invoke(connectionWrapper, anonymousClass1);
                if (objInvoke != coroutine_suspended) {
                    return objInvoke;
                }
            }
        } else {
            if (z) {
                pool = this.readers;
            } else {
                pool = this.writers;
            }
            objectRef = new Ref.ObjectRef();
            try {
                CoroutineContext context = anonymousClass1.getContext();
                long j = this.timeout;
                Function0<Unit> function0 = new Function0() { // from class: androidx.room.coroutines.ConnectionPoolImpl$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        return ConnectionPoolImpl.useConnection$lambda$6(this.f$0, z);
                    }
                };
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = function2;
                anonymousClass1.L$2 = pool;
                anonymousClass1.L$3 = objectRef;
                anonymousClass1.L$4 = context;
                anonymousClass1.L$5 = objectRef;
                anonymousClass1.Z$0 = z;
                anonymousClass1.label = 3;
                objM18acquireWithTimeoutKLykuaI = pool.m18acquireWithTimeoutKLykuaI(j, function0, anonymousClass1);
                if (objM18acquireWithTimeoutKLykuaI != coroutine_suspended) {
                    function3 = function2;
                    coroutineContext = context;
                    connectionPoolImpl = this;
                    objectRef3 = objectRef;
                    ConnectionWithLock connectionWithLockMarkAcquired2 = ((ConnectionWithLock) objM18acquireWithTimeoutKLykuaI).markAcquired(coroutineContext);
                    if (connectionPoolImpl.readers != connectionPoolImpl.writers) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    objectRef3.element = new PooledConnectionImpl(connectionWithLockMarkAcquired2, z2);
                    if (objectRef.element != null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    CoroutineContext coroutineContextCreateConnectionContext3 = connectionPoolImpl.createConnectionContext((PooledConnectionImpl) objectRef.element);
                    AnonymousClass4 anonymousClass5 = new AnonymousClass4(function3, objectRef, null);
                    anonymousClass1.L$0 = pool;
                    anonymousClass1.L$1 = objectRef;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.L$3 = null;
                    anonymousClass1.L$4 = null;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 4;
                    objWithContext = BuildersKt.withContext(coroutineContextCreateConnectionContext3, anonymousClass5, anonymousClass1);
                    if (objWithContext != coroutine_suspended) {
                        pool2 = pool;
                        obj = objWithContext;
                        objectRef2 = objectRef;
                        pooledConnectionImpl = (PooledConnectionImpl) objectRef2.element;
                        if (pooledConnectionImpl != null) {
                            pooledConnectionImpl.markRecycled();
                            pooledConnectionImpl.getDelegate().markReleased();
                            pool2.recycle(pooledConnectionImpl.getDelegate());
                        }
                        return obj;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                pool2 = pool;
                objectRef2 = objectRef;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$2", f = "ConnectionPoolImpl.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
        final /* synthetic */ PooledConnectionImpl $confinedConnection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, PooledConnectionImpl pooledConnectionImpl, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$confinedConnection = pooledConnectionImpl;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2<>(this.$block, this.$confinedConnection, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function2<Transactor, Continuation<? super R>, Object> function2 = this.$block;
            PooledConnectionImpl pooledConnectionImpl = this.$confinedConnection;
            this.label = 1;
            Object objInvoke = function2.invoke(pooledConnectionImpl, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    public static final Unit useConnection$lambda$6(ConnectionPoolImpl connectionPoolImpl, boolean z) throws KotlinNothingValueException {
        connectionPoolImpl.onTimeout(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$4, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectionPoolImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", f = "ConnectionPoolImpl.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<Transactor, Continuation<? super R>, Object> $block;
        final /* synthetic */ Ref.ObjectRef<PooledConnectionImpl> $connection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(Function2<? super Transactor, ? super Continuation<? super R>, ? extends Object> function2, Ref.ObjectRef<PooledConnectionImpl> objectRef, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$block = function2;
            this.$connection = objectRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4<>(this.$block, this.$connection, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function2<Transactor, Continuation<? super R>, Object> function2 = this.$block;
            Object obj2 = this.$connection.element;
            this.label = 1;
            Object objInvoke = function2.invoke(obj2, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    private final CoroutineContext createConnectionContext(PooledConnectionImpl connection) {
        return new ConnectionElement(connection).plus((CoroutineContext) ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, connection));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    private final void onTimeout(boolean isReadOnly) throws KotlinNothingValueException {
        String str = isReadOnly ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.").append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:").append('\n');
        this.readers.dump(sb);
        try {
            SQLite.throwSQLiteException(5, sb.toString());
            throw new KotlinNothingValueException();
        } catch (SQLException e) {
            if (this.throwOnTimeout) {
                throw e;
            }
            e.printStackTrace();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }
}
