package com.google.firebase.events;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Subscriber {
    <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler);

    <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler);

    <T> void unsubscribe(Class<T> cls, EventHandler<? super T> eventHandler);
}
