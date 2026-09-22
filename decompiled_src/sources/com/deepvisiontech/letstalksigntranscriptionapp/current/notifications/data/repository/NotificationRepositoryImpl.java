package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository;

import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao.NotificationDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.entity.NotificationEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.mappers.NotificationMapperKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.api.NotificationApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.dto.NotificationActionData;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.dto.NotificationActionRequestPayload;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.dto.NotificationActionResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00140\u0013H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J4\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J:\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014H\u0096@¢\u0006\u0002\u0010&J$\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b¨\u0006*"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/repository/NotificationRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/repository/NotificationRepository;", "notificationDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao;", "notificationApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/api/NotificationApi;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/api/NotificationApi;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getIoDispatcher$annotations", "()V", "insertNotifications", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "notification", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getNotificationFlow", "id", "", "deleteNotification", "notifications", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotification", "submitAction", "notificationId", "pageId", "", "gmail", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "(Ljava/lang/String;JLjava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitListAction", "selectedOptions", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markNotificationPageAsResponded", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationRepositoryImpl implements NotificationRepository {
    private static final String TAG = "NotificationRepositoryImpl";
    private final CoroutineDispatcher ioDispatcher;
    private final NotificationApi notificationApi;
    private final NotificationDao notificationDao;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private static /* synthetic */ void getIoDispatcher$annotations() {
    }

    @Inject
    public NotificationRepositoryImpl(NotificationDao notificationDao, NotificationApi notificationApi, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(notificationDao, "notificationDao");
        Intrinsics.checkNotNullParameter(notificationApi, "notificationApi");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.notificationDao = notificationDao;
        this.notificationApi = notificationApi;
        this.ioDispatcher = coroutineDispatcher;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$insertNotifications$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$insertNotifications$2", f = "NotificationRepositoryImpl.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    static final class C02842 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Notification $notification;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02842(Notification notification, Continuation<? super C02842> continuation) {
            super(1, continuation);
            this.$notification = notification;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotificationRepositoryImpl.this.new C02842(this.$notification, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NotificationRepositoryImpl.this.notificationDao.insertNotification(NotificationMapperKt.toEntity(this.$notification), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository
    public Object insertNotifications(Notification notification, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02842(notification, null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository
    public Flow<List<Notification>> getAllNotifications() {
        final Flow<List<NotificationEntity>> allNotifications = this.notificationDao.getAllNotifications();
        return FlowKt.flowOn(new Flow<List<? extends Notification>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$getAllNotifications$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$getAllNotifications$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$getAllNotifications$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$getAllNotifications$$inlined$map$1$2", f = "NotificationRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List list = (List) obj;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(NotificationMapperKt.toNotification((NotificationEntity) it.next()));
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = allNotifications.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, this.ioDispatcher);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository
    public Flow<Notification> getNotificationFlow(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        final Flow<NotificationEntity> notificationFlow = this.notificationDao.getNotificationFlow(id);
        return FlowKt.flowOn(new Flow<Notification>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$getNotificationFlow$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$getNotificationFlow$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$getNotificationFlow$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$getNotificationFlow$$inlined$map$1$2", f = "NotificationRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Notification notification = NotificationMapperKt.toNotification((NotificationEntity) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(notification, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = notificationFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, this.ioDispatcher);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$deleteNotification$2, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$deleteNotification$2", f = "NotificationRepositoryImpl.kt", i = {0}, l = {48}, m = "invokeSuspend", n = {"notificationEntities"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Notification> $notifications;
        Object L$0;
        int label;
        final /* synthetic */ NotificationRepositoryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<Notification> list, NotificationRepositoryImpl notificationRepositoryImpl, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$notifications = list;
            this.this$0 = notificationRepositoryImpl;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$notifications, this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<Notification> list = this.$notifications;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(NotificationMapperKt.toEntity((Notification) it.next()));
                }
                ArrayList arrayList2 = arrayList;
                this.L$0 = SpillingKt.nullOutSpilledVariable(arrayList2);
                this.label = 1;
                if (this.this$0.notificationDao.deleteNotification(arrayList2, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository
    public Object deleteNotification(List<Notification> list, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(list, this, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$updateNotification$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$updateNotification$2", f = "NotificationRepositoryImpl.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    static final class C02892 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Notification $notification;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02892(Notification notification, Continuation<? super C02892> continuation) {
            super(1, continuation);
            this.$notification = notification;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotificationRepositoryImpl.this.new C02892(this.$notification, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (NotificationRepositoryImpl.this.notificationDao.updateNotification(NotificationMapperKt.toEntity(this.$notification), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository
    public Object updateNotification(Notification notification, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02892(notification, null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository
    public Object submitAction(String str, long j, String str2, NotificationResponseType notificationResponseType, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C02862(notificationResponseType, str2, str, j, this, null), new AnonymousClass3(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$submitAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$submitAction$2", f = "NotificationRepositoryImpl.kt", i = {0, 0}, l = {72}, m = "invokeSuspend", n = {"responseData", "payload"}, s = {"L$0", "L$1"})
    static final class C02862 extends SuspendLambda implements Function1<Continuation<? super NotificationActionResponse>, Object> {
        final /* synthetic */ NotificationResponseType $action;
        final /* synthetic */ String $gmail;
        final /* synthetic */ String $notificationId;
        final /* synthetic */ long $pageId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ NotificationRepositoryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02862(NotificationResponseType notificationResponseType, String str, String str2, long j, NotificationRepositoryImpl notificationRepositoryImpl, Continuation<? super C02862> continuation) {
            super(1, continuation);
            this.$action = notificationResponseType;
            this.$gmail = str;
            this.$notificationId = str2;
            this.$pageId = j;
            this.this$0 = notificationRepositoryImpl;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02862(this.$action, this.$gmail, this.$notificationId, this.$pageId, this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super NotificationActionResponse> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            NotificationActionData notificationActionData = new NotificationActionData(this.$action.name(), null, this.$gmail, 2, null);
            NotificationActionRequestPayload notificationActionRequestPayload = new NotificationActionRequestPayload(this.$notificationId, this.$pageId, notificationActionData);
            this.L$0 = SpillingKt.nullOutSpilledVariable(notificationActionData);
            this.L$1 = SpillingKt.nullOutSpilledVariable(notificationActionRequestPayload);
            this.label = 1;
            Object objSubmitNotificationResponse = this.this$0.notificationApi.submitNotificationResponse(notificationActionRequestPayload, (Continuation) this);
            return objSubmitNotificationResponse == coroutine_suspended ? coroutine_suspended : objSubmitNotificationResponse;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$submitAction$3, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$submitAction$3", f = "NotificationRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<NotificationActionResponse, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        public final Object invoke(NotificationActionResponse notificationActionResponse, Continuation<? super Unit> continuation) {
            return create(notificationActionResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository
    public Object submitListAction(String str, long j, String str2, List<String> list, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C02872(list, str2, str, j, this, null), new C02883(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$submitListAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$submitListAction$2", f = "NotificationRepositoryImpl.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"responseData", "payload"}, s = {"L$0", "L$1"})
    static final class C02872 extends SuspendLambda implements Function1<Continuation<? super NotificationActionResponse>, Object> {
        final /* synthetic */ String $gmail;
        final /* synthetic */ String $notificationId;
        final /* synthetic */ long $pageId;
        final /* synthetic */ List<String> $selectedOptions;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ NotificationRepositoryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02872(List<String> list, String str, String str2, long j, NotificationRepositoryImpl notificationRepositoryImpl, Continuation<? super C02872> continuation) {
            super(1, continuation);
            this.$selectedOptions = list;
            this.$gmail = str;
            this.$notificationId = str2;
            this.$pageId = j;
            this.this$0 = notificationRepositoryImpl;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02872(this.$selectedOptions, this.$gmail, this.$notificationId, this.$pageId, this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super NotificationActionResponse> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            NotificationActionData notificationActionData = new NotificationActionData("SUBMIT_LIST", this.$selectedOptions, this.$gmail);
            NotificationActionRequestPayload notificationActionRequestPayload = new NotificationActionRequestPayload(this.$notificationId, this.$pageId, notificationActionData);
            this.L$0 = SpillingKt.nullOutSpilledVariable(notificationActionData);
            this.L$1 = SpillingKt.nullOutSpilledVariable(notificationActionRequestPayload);
            this.label = 1;
            Object objSubmitNotificationResponse = this.this$0.notificationApi.submitNotificationResponse(notificationActionRequestPayload, (Continuation) this);
            return objSubmitNotificationResponse == coroutine_suspended ? coroutine_suspended : objSubmitNotificationResponse;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$submitListAction$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$submitListAction$3", f = "NotificationRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02883 extends SuspendLambda implements Function2<NotificationActionResponse, Continuation<? super Unit>, Object> {
        int label;

        C02883(Continuation<? super C02883> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02883(continuation);
        }

        public final Object invoke(NotificationActionResponse notificationActionResponse, Continuation<? super Unit> continuation) {
            return create(notificationActionResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$markNotificationPageAsResponded$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl$markNotificationPageAsResponded$2", f = "NotificationRepositoryImpl.kt", i = {1, 1, 1}, l = {104, 116}, m = "invokeSuspend", n = {"notification", "updatedDataList", "updatedEntity"}, s = {"L$0", "L$1", "L$2"})
    static final class C02852 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $notificationId;
        final /* synthetic */ long $pageId;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02852(String str, long j, Continuation<? super C02852> continuation) {
            super(1, continuation);
            this.$notificationId = str;
            this.$pageId = j;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotificationRepositoryImpl.this.new C02852(this.$notificationId, this.$pageId, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x00c9, code lost:
        
            if (r23.this$0.notificationDao.updateNotification(r2, (kotlin.coroutines.Continuation) r23) == r1) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 207
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.repository.NotificationRepositoryImpl.C02852.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository
    public Object markNotificationPageAsResponded(String str, long j, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C02852(str, j, null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: NotificationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/repository/NotificationRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
