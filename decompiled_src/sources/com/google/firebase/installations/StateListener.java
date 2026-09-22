package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
interface StateListener {
    boolean onException(Exception exc);

    boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry);
}
