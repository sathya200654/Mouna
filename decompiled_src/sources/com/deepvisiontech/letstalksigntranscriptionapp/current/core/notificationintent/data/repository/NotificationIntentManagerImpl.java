package com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: NotificationIntentManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/notificationintent/data/repository/NotificationIntentManagerImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/notificationintent/domain/repository/NotificationIntentManager;", "<init>", "()V", "_notificationIdToOpen", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "notificationIdToOpen", "Lkotlinx/coroutines/flow/StateFlow;", "getNotificationIdToOpen", "()Lkotlinx/coroutines/flow/StateFlow;", "onNewNotificationIntent", "", "id", "consumeNotificationIntent", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationIntentManagerImpl implements NotificationIntentManager {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _notificationIdToOpen;
    private final StateFlow<String> notificationIdToOpen;

    @Inject
    public NotificationIntentManagerImpl() {
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this._notificationIdToOpen = MutableStateFlow;
        this.notificationIdToOpen = FlowKt.asStateFlow(MutableStateFlow);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager
    public StateFlow<String> getNotificationIdToOpen() {
        return this.notificationIdToOpen;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager
    public void onNewNotificationIntent(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this._notificationIdToOpen.setValue(id);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager
    public void consumeNotificationIntent() {
        this._notificationIdToOpen.setValue((Object) null);
    }
}
