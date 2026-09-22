package com.google.firebase.remoteconfig.internal.rollouts;

import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class RolloutsStateSubscriptionsHandler {
    private ConfigCacheClient activatedConfigsCache;
    private Executor executor;
    private RolloutsStateFactory rolloutsStateFactory;
    private Set<RolloutsStateSubscriber> subscribers = Collections.newSetFromMap(new ConcurrentHashMap());

    public RolloutsStateSubscriptionsHandler(ConfigCacheClient configCacheClient, RolloutsStateFactory rolloutsStateFactory, Executor executor) {
        this.activatedConfigsCache = configCacheClient;
        this.rolloutsStateFactory = rolloutsStateFactory;
        this.executor = executor;
    }

    public void registerRolloutsStateSubscriber(final RolloutsStateSubscriber rolloutsStateSubscriber) {
        this.subscribers.add(rolloutsStateSubscriber);
        final Task<ConfigContainer> task = this.activatedConfigsCache.get();
        task.addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler$$ExternalSyntheticLambda0
            /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.firebase.FirebaseException */
            public final void onSuccess(Object obj) throws FirebaseException {
                this.f$0.m2170x4e3578e1(task, rolloutsStateSubscriber, (ConfigContainer) obj);
            }
        });
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.firebase.FirebaseException */
    /* JADX INFO: renamed from: lambda$registerRolloutsStateSubscriber$1$com-google-firebase-remoteconfig-internal-rollouts-RolloutsStateSubscriptionsHandler, reason: not valid java name */
    /* synthetic */ void m2170x4e3578e1(Task task, final RolloutsStateSubscriber rolloutsStateSubscriber, ConfigContainer configContainer) throws FirebaseException {
        try {
            ConfigContainer configContainer2 = (ConfigContainer) task.getResult();
            if (configContainer2 != null) {
                final RolloutsState activeRolloutsState = this.rolloutsStateFactory.getActiveRolloutsState(configContainer2);
                this.executor.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        rolloutsStateSubscriber.onRolloutsStateChanged(activeRolloutsState);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e) {
            Log.w(FirebaseRemoteConfig.TAG, "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.firebase.FirebaseException */
    public void publishActiveRolloutsState(ConfigContainer configContainer) throws FirebaseException {
        try {
            final RolloutsState activeRolloutsState = this.rolloutsStateFactory.getActiveRolloutsState(configContainer);
            for (final RolloutsStateSubscriber rolloutsStateSubscriber : this.subscribers) {
                this.executor.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        rolloutsStateSubscriber.onRolloutsStateChanged(activeRolloutsState);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e) {
            Log.w(FirebaseRemoteConfig.TAG, "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e);
        }
    }
}
