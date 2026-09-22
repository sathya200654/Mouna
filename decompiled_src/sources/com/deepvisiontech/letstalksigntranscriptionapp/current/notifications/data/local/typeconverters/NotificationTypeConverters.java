package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.typeconverters;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationTypeConverters.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007J\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/typeconverters/NotificationTypeConverters;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "fromNotificationDataListToJson", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "fromJsonToNotificationDataList", "json", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationTypeConverters {
    public static final int $stable = 8;
    private final Gson gson = new Gson();

    public final String fromNotificationDataListToJson(List<NotificationData> data) {
        if (data != null) {
            return this.gson.toJson(data);
        }
        return null;
    }

    public final List<NotificationData> fromJsonToNotificationDataList(String json) {
        if (json == null) {
            return null;
        }
        return (List) this.gson.fromJson(json, new TypeToken<List<? extends NotificationData>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.typeconverters.NotificationTypeConverters$fromJsonToNotificationDataList$listType$1
        }.getType());
    }
}
