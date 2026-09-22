package com.azure.core.implementation.util;

import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.util.ReferenceManager;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import java.lang.ref.ReferenceQueue;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ReferenceManagerImpl implements ReferenceManager {
    private static final String BASE_THREAD_NAME = "azure-sdk-referencemanager";
    private static final Object CLEANER;
    private static final ReflectiveInvoker CLEANER_REGISTER;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ReferenceManagerImpl.class);
    private final CleanableReference<?> cleanableReferenceList;
    private final ReferenceQueue<Object> queue;

    static {
        Object objInvoke;
        ReflectiveInvoker methodInvoker = null;
        try {
            Class<?> cls = Class.forName("java.lang.ref.Cleaner");
            objInvoke = cls.getDeclaredMethod("create", ThreadFactory.class).invoke(null, new ThreadFactory() { // from class: com.azure.core.implementation.util.ReferenceManagerImpl$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return ReferenceManagerImpl.lambda$static$0(runnable);
                }
            });
            try {
                methodInvoker = ReflectionUtils.getMethodInvoker(cls, cls.getDeclaredMethod("register", Object.class, Runnable.class), false);
            } catch (Exception e) {
                e = e;
                LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.implementation.util.ReferenceManagerImpl$$ExternalSyntheticLambda2
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return ReferenceManagerImpl.lambda$static$1();
                    }
                }, e);
            }
        } catch (Exception e2) {
            e = e2;
            objInvoke = null;
        }
        CLEANER = objInvoke;
        CLEANER_REGISTER = methodInvoker;
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        return new Thread(runnable, BASE_THREAD_NAME);
    }

    static /* synthetic */ String lambda$static$1() {
        return "Unable to use java.lang.ref.Cleaner to manage references.";
    }

    public ReferenceManagerImpl() {
        if (CLEANER == null) {
            this.queue = new ReferenceQueue<>();
            this.cleanableReferenceList = new CleanableReference<>();
            final Thread thread = new Thread(new Runnable() { // from class: com.azure.core.implementation.util.ReferenceManagerImpl$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.clearReferenceQueue();
                }
            }, BASE_THREAD_NAME);
            new CleanableReference(this, new Runnable() { // from class: com.azure.core.implementation.util.ReferenceManagerImpl$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    ReferenceManagerImpl.lambda$new$3(thread);
                }
            }, this);
            thread.setDaemon(true);
            thread.start();
            return;
        }
        this.queue = null;
        this.cleanableReferenceList = null;
    }

    static /* synthetic */ void lambda$new$3(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            LOGGER.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.implementation.util.ReferenceManagerImpl$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ReferenceManagerImpl.lambda$new$2();
                }
            }, e);
        }
    }

    static /* synthetic */ String lambda$new$2() {
        return "Failed to shutdown ReferenceManager thread.";
    }

    @Override // com.azure.core.util.ReferenceManager
    public void register(Object obj, Runnable runnable) {
        Objects.requireNonNull(obj, "'object' cannot be null.");
        Objects.requireNonNull(runnable, "'cleanupAction' cannot be null.");
        Object obj2 = CLEANER;
        if (obj2 == null) {
            new CleanableReference(obj, runnable, this);
            return;
        }
        try {
            CLEANER_REGISTER.invokeWithArguments(obj2, obj, runnable);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw LOGGER.logExceptionAsError((RuntimeException) e);
            }
            throw LOGGER.logExceptionAsError(new RuntimeException(e));
        }
    }

    void clearReferenceQueue() {
        CleanableReference cleanableReference;
        while (this.cleanableReferenceList.hasRemaining()) {
            try {
                cleanableReference = (CleanableReference) this.queue.remove(30000L);
            } catch (InterruptedException e) {
                LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.implementation.util.ReferenceManagerImpl$$ExternalSyntheticLambda3
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return ReferenceManagerImpl.lambda$clearReferenceQueue$4();
                    }
                }, e);
                cleanableReference = null;
            }
            if (cleanableReference != null) {
                try {
                    cleanableReference.clean();
                } catch (Exception e2) {
                    LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.implementation.util.ReferenceManagerImpl$$ExternalSyntheticLambda4
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return ReferenceManagerImpl.lambda$clearReferenceQueue$5();
                        }
                    }, e2);
                }
            }
        }
    }

    static /* synthetic */ String lambda$clearReferenceQueue$4() {
        return "ReferenceManager Thread interrupted while waiting for a reference to clean.";
    }

    static /* synthetic */ String lambda$clearReferenceQueue$5() {
        return "Cleaning a reference threw an exception.";
    }

    static boolean isCleanerUsed() {
        return CLEANER != null;
    }

    ReferenceQueue<Object> getQueue() {
        return this.queue;
    }

    CleanableReference<?> getCleanableReferenceList() {
        return this.cleanableReferenceList;
    }
}
