package com.azure.core.util;

import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.util.logging.ClientLogger;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SharedExecutorService implements ScheduledExecutorService {
    private static final AtomicLong AZURE_SDK_THREAD_COUNTER;
    private static final String AZURE_SDK_THREAD_NAME = "azure-sdk-global-thread-";
    private static final ReflectiveInvoker CREATE_VIRTUAL_THREAD_FACTORY;
    private static final AtomicReferenceFieldUpdater<SharedExecutorService, ScheduledExecutorService> EXECUTOR_UPDATER;
    private static final ReflectiveInvoker GET_VIRTUAL_THREAD_BUILDER;
    private static final SharedExecutorService INSTANCE;
    private static final ClientLogger LOGGER;
    private static final ReflectiveInvoker SET_VIRTUAL_THREAD_BUILDER_THREAD_NAME;
    private static final int THREAD_POOL_KEEP_ALIVE_MILLIS;
    private static final int THREAD_POOL_SIZE;
    private static final boolean THREAD_POOL_VIRTUAL;
    private static final boolean VIRTUAL_THREAD_SUPPORTED;
    volatile ScheduledExecutorService executor;

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    static {
        ReflectiveInvoker methodInvoker;
        ReflectiveInvoker methodInvoker2;
        ClientLogger clientLogger = new ClientLogger((Class<?>) SharedExecutorService.class);
        LOGGER = clientLogger;
        AZURE_SDK_THREAD_COUNTER = new AtomicLong();
        THREAD_POOL_SIZE = ((Integer) getConfig("azure.sdk.shared.threadpool.maxpoolsize", "AZURE_SDK_SHARED_THREADPOOL_MAXPOOLSIZE", new Function() { // from class: com.azure.core.util.SharedExecutorService$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(Integer.parseInt((String) obj));
            }
        }, Integer.valueOf(Runtime.getRuntime().availableProcessors() * 10))).intValue();
        THREAD_POOL_KEEP_ALIVE_MILLIS = ((Integer) getConfig("azure.sdk.shared.threadpool.keepalivemillis", "AZURE_SDK_SHARED_THREADPOOL_KEEPALIVEMILLIS", new Function() { // from class: com.azure.core.util.SharedExecutorService$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(Integer.parseInt((String) obj));
            }
        }, 60000)).intValue();
        boolean z = true;
        THREAD_POOL_VIRTUAL = ((Boolean) getConfig("azure.sdk.shared.threadpool.usevirtualthreads", "AZURE_SDK_SHARED_THREADPOOL_USEVIRTUALTHREADS", new Function() { // from class: com.azure.core.util.SharedExecutorService$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
        }, true)).booleanValue();
        INSTANCE = new SharedExecutorService();
        ReflectiveInvoker reflectiveInvoker = null;
        try {
            ReflectiveInvoker methodInvoker3 = ReflectionUtils.getMethodInvoker(null, Class.forName("java.lang.Thread").getDeclaredMethod("ofVirtual", new Class[0]));
            methodInvoker2 = ReflectionUtils.getMethodInvoker(null, Class.forName("java.lang.Thread$Builder").getDeclaredMethod("name", String.class, Long.TYPE));
            methodInvoker = ReflectionUtils.getMethodInvoker(null, Class.forName("java.lang.Thread$Builder").getDeclaredMethod("factory", new Class[0]));
            clientLogger.verbose("Virtual threads are supported in the current runtime.");
            reflectiveInvoker = methodInvoker3;
        } catch (Exception | LinkageError e) {
            LOGGER.atVerbose().addKeyValue("runtime", System.getProperty("java.version")).log("Virtual threads are not supported in the current runtime.", e);
            z = false;
            methodInvoker = null;
            methodInvoker2 = null;
        }
        VIRTUAL_THREAD_SUPPORTED = z;
        GET_VIRTUAL_THREAD_BUILDER = reflectiveInvoker;
        SET_VIRTUAL_THREAD_BUILDER_THREAD_NAME = methodInvoker2;
        CREATE_VIRTUAL_THREAD_FACTORY = methodInvoker;
        EXECUTOR_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SharedExecutorService.class, ScheduledExecutorService.class, "executor");
    }

    private static <T> T getConfig(String str, String str2, Function<String, T> function, T t) {
        String fromEnvironment = Configuration.getGlobalConfiguration().getFromEnvironment(str, str2, ConfigurationProperty.REDACT_VALUE_SANITIZER);
        if (fromEnvironment == null) {
            LOGGER.atVerbose().addKeyValue("systemProperty", str).addKeyValue("envVar", str2).addKeyValue("defaultValue", t).log("Configuration value not found, using default.");
            return t;
        }
        try {
            T tApply = function.apply(fromEnvironment);
            LOGGER.atVerbose().addKeyValue("systemProperty", str).addKeyValue("envVar", str2).addKeyValue("value", fromEnvironment).log("Found configuration value.");
            return tApply;
        } catch (RuntimeException unused) {
            LOGGER.atVerbose().addKeyValue("systemProperty", str).addKeyValue("envVar", str2).addKeyValue("value", fromEnvironment).addKeyValue("defaultValue", t).log("Failed to convert found configuration value, using default.");
            return t;
        }
    }

    private SharedExecutorService() {
    }

    public static SharedExecutorService getInstance() {
        return INSTANCE;
    }

    public ScheduledExecutorService getExecutorService() {
        return EXECUTOR_UPDATER.get(this);
    }

    public void setExecutorService(ScheduledExecutorService scheduledExecutorService) {
        Objects.requireNonNull(scheduledExecutorService, "'executorService' cannot be null.");
        if (scheduledExecutorService.isShutdown() || scheduledExecutorService.isTerminated()) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("The passed executor service is shutdown or terminated."));
        }
        ScheduledExecutorService andSet = EXECUTOR_UPDATER.getAndSet(this, scheduledExecutorService);
        if (andSet instanceof InternalExecutorService) {
            andSet.shutdown();
        }
    }

    public void reset() {
        ScheduledExecutorService andSet = EXECUTOR_UPDATER.getAndSet(this, null);
        if (andSet instanceof InternalExecutorService) {
            andSet.shutdown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw ((UnsupportedOperationException) LOGGER.logThrowableAsError(new UnsupportedOperationException("This executor service is shared and cannot be shut down.")));
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw ((UnsupportedOperationException) LOGGER.logThrowableAsError(new UnsupportedOperationException("This executor service is shared and cannot be shut down.")));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw ((UnsupportedOperationException) LOGGER.logThrowableAsError(new UnsupportedOperationException("This executor service is shared and cannot be terminated.")));
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ensureNotShutdown().execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return ensureNotShutdown().submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return ensureNotShutdown().submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return ensureNotShutdown().submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return ensureNotShutdown().invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return ensureNotShutdown().invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) ensureNotShutdown().invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) ensureNotShutdown().invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return ensureNotShutdown().schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return ensureNotShutdown().schedule(callable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return ensureNotShutdown().scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return ensureNotShutdown().scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    private ScheduledExecutorService ensureNotShutdown() {
        return EXECUTOR_UPDATER.updateAndGet(INSTANCE, new UnaryOperator() { // from class: com.azure.core.util.SharedExecutorService$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SharedExecutorService.lambda$ensureNotShutdown$0((ScheduledExecutorService) obj);
            }
        });
    }

    static /* synthetic */ ScheduledExecutorService lambda$ensureNotShutdown$0(ScheduledExecutorService scheduledExecutorService) {
        return (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || scheduledExecutorService.isTerminated()) ? createSharedExecutor() : scheduledExecutorService;
    }

    private static ScheduledExecutorService createSharedExecutor() {
        ThreadFactory threadFactoryCreateNonVirtualThreadFactory;
        if (VIRTUAL_THREAD_SUPPORTED && THREAD_POOL_VIRTUAL) {
            try {
                ClientLogger clientLogger = LOGGER;
                clientLogger.verbose("Attempting to create a virtual thread factory.");
                threadFactoryCreateNonVirtualThreadFactory = createVirtualThreadFactory();
                clientLogger.verbose("Successfully created a virtual thread factory.");
            } catch (Exception e) {
                LOGGER.info("Failed to create a virtual thread factory, falling back to non-virtual threads.", e);
                threadFactoryCreateNonVirtualThreadFactory = createNonVirtualThreadFactory();
            }
        } else {
            threadFactoryCreateNonVirtualThreadFactory = createNonVirtualThreadFactory();
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(THREAD_POOL_SIZE, threadFactoryCreateNonVirtualThreadFactory);
        scheduledThreadPoolExecutor.setKeepAliveTime(THREAD_POOL_KEEP_ALIVE_MILLIS, TimeUnit.MILLISECONDS);
        Thread threadCreateExecutorServiceShutdownThread = CoreUtils.createExecutorServiceShutdownThread(scheduledThreadPoolExecutor, Duration.ofSeconds(5L));
        CoreUtils.addShutdownHookSafely(threadCreateExecutorServiceShutdownThread);
        return new InternalExecutorService(scheduledThreadPoolExecutor, threadCreateExecutorServiceShutdownThread);
    }

    private static ThreadFactory createVirtualThreadFactory() throws Exception {
        Object objInvokeStatic = GET_VIRTUAL_THREAD_BUILDER.invokeStatic(new Object[0]);
        SET_VIRTUAL_THREAD_BUILDER_THREAD_NAME.invokeWithArguments(objInvokeStatic, AZURE_SDK_THREAD_NAME, Long.valueOf(AZURE_SDK_THREAD_COUNTER.get()));
        final ThreadFactory threadFactory = (ThreadFactory) CREATE_VIRTUAL_THREAD_FACTORY.invokeWithArguments(objInvokeStatic, new Object[0]);
        return new ThreadFactory() { // from class: com.azure.core.util.SharedExecutorService$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return SharedExecutorService.lambda$createVirtualThreadFactory$1(threadFactory, runnable);
            }
        };
    }

    static /* synthetic */ Thread lambda$createVirtualThreadFactory$1(ThreadFactory threadFactory, Runnable runnable) {
        AZURE_SDK_THREAD_COUNTER.incrementAndGet();
        return threadFactory.newThread(runnable);
    }

    private static ThreadFactory createNonVirtualThreadFactory() {
        return new ThreadFactory() { // from class: com.azure.core.util.SharedExecutorService$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return SharedExecutorService.lambda$createNonVirtualThreadFactory$2(runnable);
            }
        };
    }

    static /* synthetic */ Thread lambda$createNonVirtualThreadFactory$2(Runnable runnable) {
        Thread thread = new Thread(runnable, AZURE_SDK_THREAD_NAME + AZURE_SDK_THREAD_COUNTER.getAndIncrement());
        thread.setDaemon(true);
        return thread;
    }

    static final class InternalExecutorService implements ScheduledExecutorService {
        private final Thread shutdownThread;
        private final ScheduledExecutorService wrapped;

        private InternalExecutorService(ScheduledExecutorService scheduledExecutorService, Thread thread) {
            this.wrapped = scheduledExecutorService;
            this.shutdownThread = thread;
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (T) this.wrapped.invokeAny(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
            return (T) this.wrapped.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
            return this.wrapped.invokeAll(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.wrapped.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.wrapped.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.wrapped.submit(runnable, t);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.wrapped.submit(callable);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.wrapped.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.wrapped.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.wrapped.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.wrapped.shutdownNow();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.wrapped.shutdown();
            ImplUtils.removeShutdownHookSafely(this.shutdownThread);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.wrapped.execute(runnable);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.wrapped.schedule(runnable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            return this.wrapped.schedule(callable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.wrapped.scheduleAtFixedRate(runnable, j, j2, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.wrapped.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        }
    }
}
