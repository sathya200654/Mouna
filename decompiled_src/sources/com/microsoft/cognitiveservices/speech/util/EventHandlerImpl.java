package com.microsoft.cognitiveservices.speech.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class EventHandlerImpl<T> {
    private Runnable notifyConnectedOnce;
    private AtomicInteger runCounter;
    private ArrayList<EventHandler<T>> eventHandlerClients = new ArrayList<>();
    private boolean notifyConnectedOnceFired = false;

    public EventHandlerImpl(AtomicInteger atomicInteger) {
        this.runCounter = atomicInteger;
    }

    public void addEventListener(EventHandler<T> eventHandler) {
        synchronized (this) {
            if (!this.notifyConnectedOnceFired) {
                this.notifyConnectedOnceFired = true;
                Runnable runnable = this.notifyConnectedOnce;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
        this.eventHandlerClients.add(eventHandler);
    }

    public void fireEvent(Object obj, T t) {
        for (EventHandler<T> eventHandler : this.eventHandlerClients) {
            AtomicInteger atomicInteger = this.runCounter;
            if (atomicInteger != null) {
                atomicInteger.incrementAndGet();
            }
            eventHandler.onEvent(obj, t);
            AtomicInteger atomicInteger2 = this.runCounter;
            if (atomicInteger2 != null) {
                atomicInteger2.decrementAndGet();
            }
        }
    }

    public boolean isUpdateNotificationOnConnectedFired() {
        return this.notifyConnectedOnceFired;
    }

    public void removeEventListener(EventHandler<T> eventHandler) {
        this.eventHandlerClients.remove(eventHandler);
    }

    public void updateNotificationOnConnected(Runnable runnable) {
        synchronized (this) {
            if (this.notifyConnectedOnceFired) {
                runnable.run();
            }
            this.notifyConnectedOnce = runnable;
        }
    }
}
