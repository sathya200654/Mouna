package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDismissListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class DeveloperListenerManager {
    private final Executor backgroundExecutor;
    private Map<FirebaseInAppMessagingClickListener, ClicksExecutorAndListener> registeredClickListeners = new HashMap();
    private Map<FirebaseInAppMessagingDismissListener, DismissExecutorAndListener> registeredDismissListeners = new HashMap();
    private Map<FirebaseInAppMessagingDisplayErrorListener, ErrorsExecutorAndListener> registeredErrorListeners = new HashMap();
    private Map<FirebaseInAppMessagingImpressionListener, ImpressionExecutorAndListener> registeredImpressionListeners = new HashMap();

    public DeveloperListenerManager(Executor executor) {
        this.backgroundExecutor = executor;
    }

    public void impressionDetected(final InAppMessage inAppMessage) {
        for (final ImpressionExecutorAndListener impressionExecutorAndListener : this.registeredImpressionListeners.values()) {
            impressionExecutorAndListener.withExecutor(this.backgroundExecutor).execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.DeveloperListenerManager$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    impressionExecutorAndListener.getListener().impressionDetected(inAppMessage);
                }
            });
        }
    }

    public void displayErrorEncountered(final InAppMessage inAppMessage, final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        for (final ErrorsExecutorAndListener errorsExecutorAndListener : this.registeredErrorListeners.values()) {
            errorsExecutorAndListener.withExecutor(this.backgroundExecutor).execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.DeveloperListenerManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    errorsExecutorAndListener.getListener().displayErrorEncountered(inAppMessage, inAppMessagingErrorReason);
                }
            });
        }
    }

    public void messageClicked(final InAppMessage inAppMessage, final Action action) {
        for (final ClicksExecutorAndListener clicksExecutorAndListener : this.registeredClickListeners.values()) {
            clicksExecutorAndListener.withExecutor(this.backgroundExecutor).execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.DeveloperListenerManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    clicksExecutorAndListener.getListener().messageClicked(inAppMessage, action);
                }
            });
        }
    }

    public void messageDismissed(final InAppMessage inAppMessage) {
        for (final DismissExecutorAndListener dismissExecutorAndListener : this.registeredDismissListeners.values()) {
            dismissExecutorAndListener.withExecutor(this.backgroundExecutor).execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.DeveloperListenerManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    dismissExecutorAndListener.getListener().messageDismissed(inAppMessage);
                }
            });
        }
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(firebaseInAppMessagingImpressionListener));
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, new ClicksExecutorAndListener(firebaseInAppMessagingClickListener));
    }

    public void addDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.registeredDismissListeners.put(firebaseInAppMessagingDismissListener, new DismissExecutorAndListener(firebaseInAppMessagingDismissListener));
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(firebaseInAppMessagingDisplayErrorListener));
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor) {
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(firebaseInAppMessagingImpressionListener, executor));
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor) {
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, new ClicksExecutorAndListener(firebaseInAppMessagingClickListener, executor));
    }

    public void addDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor) {
        this.registeredDismissListeners.put(firebaseInAppMessagingDismissListener, new DismissExecutorAndListener(firebaseInAppMessagingDismissListener, executor));
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor) {
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(firebaseInAppMessagingDisplayErrorListener, executor));
    }

    public void removeImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.remove(firebaseInAppMessagingImpressionListener);
    }

    public void removeClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.remove(firebaseInAppMessagingClickListener);
    }

    public void removeDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.remove(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.registeredDismissListeners.remove(firebaseInAppMessagingDismissListener);
    }

    public void removeAllListeners() {
        this.registeredClickListeners.clear();
        this.registeredImpressionListeners.clear();
        this.registeredErrorListeners.clear();
        this.registeredDismissListeners.clear();
    }

    public Map getAllListeners() {
        HashMap map = new HashMap();
        map.putAll(this.registeredClickListeners);
        map.putAll(this.registeredImpressionListeners);
        map.putAll(this.registeredErrorListeners);
        map.putAll(this.registeredDismissListeners);
        return map;
    }

    private static abstract class ExecutorAndListener<T> {
        private final Executor executor;

        public abstract T getListener();

        public Executor withExecutor(Executor executor) {
            Executor executor2 = this.executor;
            return executor2 == null ? executor : executor2;
        }

        public ExecutorAndListener(Executor executor) {
            this.executor = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ImpressionExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingImpressionListener> {
        FirebaseInAppMessagingImpressionListener listener;

        public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingImpressionListener;
        }

        public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
            super(null);
            this.listener = firebaseInAppMessagingImpressionListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingImpressionListener getListener() {
            return this.listener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ClicksExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingClickListener> {
        FirebaseInAppMessagingClickListener listener;

        public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingClickListener;
        }

        public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
            super(null);
            this.listener = firebaseInAppMessagingClickListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingClickListener getListener() {
            return this.listener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class DismissExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingDismissListener> {
        FirebaseInAppMessagingDismissListener listener;

        public DismissExecutorAndListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingDismissListener;
        }

        public DismissExecutorAndListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
            super(null);
            this.listener = firebaseInAppMessagingDismissListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingDismissListener getListener() {
            return this.listener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ErrorsExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingDisplayErrorListener> {
        FirebaseInAppMessagingDisplayErrorListener listener;

        public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingDisplayErrorListener;
        }

        public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
            super(null);
            this.listener = firebaseInAppMessagingDisplayErrorListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingDisplayErrorListener getListener() {
            return this.listener;
        }
    }
}
