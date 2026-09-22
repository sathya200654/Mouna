package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AppDataStore.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\"%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005\"%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005\"%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005\"%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0012\u0010\u0005\"%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0015\u0010\u0005\"%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001a"}, d2 = {"engagementDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getEngagementDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "engagementDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "appUsageDataStore", "getAppUsageDataStore", "appUsageDataStore$delegate", "personaDataStore", "getPersonaDataStore", "personaDataStore$delegate", "sessionDataStore", "getSessionDataStore", "sessionDataStore$delegate", "settingsDataStore", "getSettingsDataStore", "settingsDataStore$delegate", "conversationDataStore", "getConversationDataStore", "conversationDataStore$delegate", "conversationUsageDataStore", "getConversationUsageDataStore", "conversationUsageDataStore$delegate", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppDataStoreKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AppDataStoreKt.class, "engagementDataStore", "getEngagementDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1)), Reflection.property1(new PropertyReference1Impl(AppDataStoreKt.class, "appUsageDataStore", "getAppUsageDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1)), Reflection.property1(new PropertyReference1Impl(AppDataStoreKt.class, "personaDataStore", "getPersonaDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1)), Reflection.property1(new PropertyReference1Impl(AppDataStoreKt.class, "sessionDataStore", "getSessionDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1)), Reflection.property1(new PropertyReference1Impl(AppDataStoreKt.class, "settingsDataStore", "getSettingsDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1)), Reflection.property1(new PropertyReference1Impl(AppDataStoreKt.class, "conversationDataStore", "getConversationDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1)), Reflection.property1(new PropertyReference1Impl(AppDataStoreKt.class, "conversationUsageDataStore", "getConversationUsageDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    private static final ReadOnlyProperty engagementDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("engagement", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    private static final ReadOnlyProperty appUsageDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("usage", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    private static final ReadOnlyProperty personaDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("persona", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    private static final ReadOnlyProperty sessionDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("session", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    private static final ReadOnlyProperty settingsDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("settings", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    private static final ReadOnlyProperty conversationDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("conversation", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);
    private static final ReadOnlyProperty conversationUsageDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("conversationUsage", (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);

    public static final DataStore<Preferences> getEngagementDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (DataStore) engagementDataStore$delegate.getValue(context, $$delegatedProperties[0]);
    }

    public static final DataStore<Preferences> getAppUsageDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (DataStore) appUsageDataStore$delegate.getValue(context, $$delegatedProperties[1]);
    }

    public static final DataStore<Preferences> getPersonaDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (DataStore) personaDataStore$delegate.getValue(context, $$delegatedProperties[2]);
    }

    public static final DataStore<Preferences> getSessionDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (DataStore) sessionDataStore$delegate.getValue(context, $$delegatedProperties[3]);
    }

    public static final DataStore<Preferences> getSettingsDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (DataStore) settingsDataStore$delegate.getValue(context, $$delegatedProperties[4]);
    }

    public static final DataStore<Preferences> getConversationDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (DataStore) conversationDataStore$delegate.getValue(context, $$delegatedProperties[5]);
    }

    public static final DataStore<Preferences> getConversationUsageDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (DataStore) conversationUsageDataStore$delegate.getValue(context, $$delegatedProperties[6]);
    }
}
