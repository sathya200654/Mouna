package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.firebase.FirebaseApp;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class SharedPreferencesUtils {
    static final String PREFERENCES_PACKAGE_NAME = "com.google.firebase.inappmessaging";
    private final FirebaseApp firebaseApp;

    @Inject
    public SharedPreferencesUtils(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public void setBooleanPreference(String str, boolean z) {
        SharedPreferences.Editor editorEdit = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public void clearPreference(String str) {
        SharedPreferences.Editor editorEdit = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public boolean getAndSetBooleanPreference(String str, boolean z) {
        SharedPreferences sharedPreferences = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, z);
        }
        setBooleanPreference(str, z);
        return z;
    }

    public boolean getBooleanPreference(String str, boolean z) {
        SharedPreferences sharedPreferences = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getBoolean(str, z) : z;
    }

    public boolean isPreferenceSet(String str) {
        return ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).contains(str);
    }

    public boolean isManifestSet(String str) {
        ApplicationInfo applicationInfo;
        Application application = (Application) this.firebaseApp.getApplicationContext();
        try {
            PackageManager packageManager = application.getPackageManager();
            return (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str)) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public boolean getBooleanManifestValue(String str, boolean z) {
        ApplicationInfo applicationInfo;
        Application application = (Application) this.firebaseApp.getApplicationContext();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(str)) {
                return applicationInfo.metaData.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return z;
    }
}
