package com.deepvisiontech.letstalksigntranscriptionapp.current;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class Hilt_MainActivity extends ComponentActivity implements GeneratedComponentManagerHolder {
    private volatile ActivityComponentManager componentManager;
    private final Object componentManagerLock;
    private boolean injected;
    private SavedStateHandleHolder savedStateHandleHolder;

    Hilt_MainActivity(int contentLayoutId) {
        super(contentLayoutId);
        this.componentManagerLock = new Object();
        this.injected = false;
        _initHiltInternal();
    }

    Hilt_MainActivity() {
        this.componentManagerLock = new Object();
        this.injected = false;
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.Hilt_MainActivity.1
            public void onContextAvailable(Context context) {
                Hilt_MainActivity.this.inject();
            }
        });
    }

    private void initSavedStateHandleHolder() {
        if (getApplication() instanceof GeneratedComponentManager) {
            SavedStateHandleHolder savedStateHandleHolder = componentManager().getSavedStateHandleHolder();
            this.savedStateHandleHolder = savedStateHandleHolder;
            if (savedStateHandleHolder.isInvalid()) {
                this.savedStateHandleHolder.setExtras(getDefaultViewModelCreationExtras());
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSavedStateHandleHolder();
    }

    protected void onDestroy() {
        super.onDestroy();
        SavedStateHandleHolder savedStateHandleHolder = this.savedStateHandleHolder;
        if (savedStateHandleHolder != null) {
            savedStateHandleHolder.clear();
        }
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ActivityComponentManager createComponentManager() {
        return new ActivityComponentManager(this);
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final ActivityComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                if (this.componentManager == null) {
                    this.componentManager = createComponentManager();
                }
            }
        }
        return this.componentManager;
    }

    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((MainActivity_GeneratedInjector) generatedComponent()).injectMainActivity((MainActivity) UnsafeCasts.unsafeCast(this));
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DefaultViewModelFactories.getActivityFactory(this, super.getDefaultViewModelProviderFactory());
    }
}
