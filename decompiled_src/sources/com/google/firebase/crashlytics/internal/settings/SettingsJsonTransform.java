package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
interface SettingsJsonTransform {
    Settings buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException;
}
