package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface SettingsProvider {
    Task<Settings> getSettingsAsync();

    Settings getSettingsSync();
}
