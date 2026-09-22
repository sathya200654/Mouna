package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen;

import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.PopUpToBuilder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel;
import com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation.NetworkUnavailableGraph;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$AppScreen$1$1", f = "AppScreen.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class AppScreenKt$AppScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppViewModel $appViewModel;
    final /* synthetic */ NavHostController $navController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppScreenKt$AppScreen$1$1(AppViewModel appViewModel, NavHostController navHostController, Continuation<? super AppScreenKt$AppScreen$1$1> continuation) {
        super(2, continuation);
        this.$appViewModel = appViewModel;
        this.$navController = navHostController;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppScreenKt$AppScreen$1$1(this.$appViewModel, this.$navController, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$AppScreen$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ NavHostController $navController;

        AnonymousClass1(NavHostController navHostController) {
            this.$navController = navHostController;
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((AppEvent) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final Object emit(AppEvent appEvent, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
            if (!Intrinsics.areEqual(appEvent, AppEvent.NavigateToNoNetworkScreen.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            this.$navController.navigate(NetworkUnavailableGraph.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$AppScreen$1$1$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return AppScreenKt$AppScreen$1$1.AnonymousClass1.emit$lambda$1((NavOptionsBuilder) obj);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit emit$lambda$1(NavOptionsBuilder navOptionsBuilder) {
            Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
            navOptionsBuilder.popUpTo(0, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$AppScreen$1$1$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return AppScreenKt$AppScreen$1$1.AnonymousClass1.emit$lambda$1$lambda$0((PopUpToBuilder) obj);
                }
            });
            navOptionsBuilder.setLaunchSingleTop(true);
            navOptionsBuilder.setRestoreState(true);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit emit$lambda$1$lambda$0(PopUpToBuilder popUpToBuilder) {
            Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$popUpTo");
            popUpToBuilder.setSaveState(true);
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$appViewModel.getEvents().collect(new AnonymousClass1(this.$navController), (Continuation) this) == coroutine_suspended) {
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
