package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class CrashlyticsWorker implements Executor {
    private final ExecutorService executor;
    private final Object tailLock = new Object();
    private Task<?> tail = Tasks.forResult((Object) null);

    static /* synthetic */ void lambda$await$6() {
    }

    CrashlyticsWorker(ExecutorService executorService) {
        this.executor = executorService;
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public <T> Task<T> submit(final Callable<T> callable) {
        Task task;
        synchronized (this.tailLock) {
            task = (Task<T>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker$$ExternalSyntheticLambda1
                public final Object then(Task task2) {
                    return Tasks.forResult(callable.call());
                }
            });
            this.tail = task;
        }
        return task;
    }

    public Task<Void> submit(final Runnable runnable) {
        Task<Void> taskContinueWithTask;
        synchronized (this.tailLock) {
            taskContinueWithTask = this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker$$ExternalSyntheticLambda0
                public final Object then(Task task) {
                    return CrashlyticsWorker.lambda$submit$1(runnable, task);
                }
            });
            this.tail = taskContinueWithTask;
        }
        return taskContinueWithTask;
    }

    static /* synthetic */ Task lambda$submit$1(Runnable runnable, Task task) throws Exception {
        runnable.run();
        return Tasks.forResult((Object) null);
    }

    public <T> Task<T> submitTask(final Callable<Task<T>> callable) {
        Task task;
        synchronized (this.tailLock) {
            task = (Task<T>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker$$ExternalSyntheticLambda3
                public final Object then(Task task2) {
                    return CrashlyticsWorker.lambda$submitTask$2(callable, task2);
                }
            });
            this.tail = task;
        }
        return task;
    }

    static /* synthetic */ Task lambda$submitTask$2(Callable callable, Task task) throws Exception {
        return (Task) callable.call();
    }

    public <T, R> Task<R> submitTask(final Callable<Task<T>> callable, Continuation<T, Task<R>> continuation) {
        Task task;
        synchronized (this.tailLock) {
            task = (Task<R>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker$$ExternalSyntheticLambda4
                public final Object then(Task task2) {
                    return CrashlyticsWorker.lambda$submitTask$3(callable, task2);
                }
            }).continueWithTask(this.executor, continuation);
            this.tail = task;
        }
        return task;
    }

    static /* synthetic */ Task lambda$submitTask$3(Callable callable, Task task) throws Exception {
        return (Task) callable.call();
    }

    public <T, R> Task<R> submitTaskOnSuccess(final Callable<Task<T>> callable, final SuccessContinuation<T, R> successContinuation) {
        Task task;
        synchronized (this.tailLock) {
            task = (Task<R>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker$$ExternalSyntheticLambda5
                public final Object then(Task task2) {
                    return CrashlyticsWorker.lambda$submitTaskOnSuccess$4(callable, task2);
                }
            }).continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker$$ExternalSyntheticLambda6
                public final Object then(Task task2) {
                    return CrashlyticsWorker.lambda$submitTaskOnSuccess$5(successContinuation, task2);
                }
            });
            this.tail = task;
        }
        return task;
    }

    static /* synthetic */ Task lambda$submitTaskOnSuccess$4(Callable callable, Task task) throws Exception {
        return (Task) callable.call();
    }

    static /* synthetic */ Task lambda$submitTaskOnSuccess$5(SuccessContinuation successContinuation, Task task) throws Exception {
        if (task.isSuccessful()) {
            return successContinuation.then(task.getResult());
        }
        if (task.getException() != null) {
            return Tasks.forException(task.getException());
        }
        return Tasks.forCanceled();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public void await() throws ExecutionException, InterruptedException, TimeoutException {
        Tasks.await(submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsWorker.lambda$await$6();
            }
        }), 30L, TimeUnit.SECONDS);
        Thread.sleep(1L);
    }
}
