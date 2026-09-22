package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.LtsRoomDatabase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.api.NotificationApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: NotificationModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006\u0014"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/di/NotificationModule;", "", "<init>", "()V", "provideApplicationScope", "Lkotlinx/coroutines/CoroutineScope;", "provideNotificationDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao;", "db", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/LtsRoomDatabase;", "provideNotificationApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/api/NotificationApi;", "retrofit", "Lretrofit2/Retrofit;", "provideNotificationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/repository/NotificationRepository;", "dao", "api", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class NotificationModule {
    public static final int $stable = 0;
    public static final NotificationModule INSTANCE = new NotificationModule();

    private NotificationModule() {
    }

    @Provides
    @Singleton
    @ApplicationScope
    public final CoroutineScope provideApplicationScope() {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    }

    @Provides
    @Singleton
    public final NotificationDao provideNotificationDao(LtsRoomDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        return db.notificationDao();
    }

    @Provides
    @Singleton
    public final NotificationApi provideNotificationApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(NotificationApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (NotificationApi) objCreate;
    }

    @Provides
    @Singleton
    public final NotificationRepository provideNotificationRepository(NotificationDao dao, NotificationApi api, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        return new NotificationRepositoryImpl(dao, api, ioDispatcher);
    }
}
