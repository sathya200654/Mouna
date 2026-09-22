package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import android.content.Context;
import android.view.View;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material3.SnackbarHostState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: ConversationScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$4$1", f = "ConversationScreen.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
final class ConversationScreenKt$ConversationScreen$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $microphonePermissionLauncher;
    final /* synthetic */ Function0<Unit> $navigateToDocumentScanner;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ SharedFlow<ConversationUiEvent> $uiEvent;
    final /* synthetic */ View $view;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ConversationScreenKt$ConversationScreen$4$1(SharedFlow<? extends ConversationUiEvent> sharedFlow, SnackbarHostState snackbarHostState, Context context, View view, ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, Function0<Unit> function0, Continuation<? super ConversationScreenKt$ConversationScreen$4$1> continuation) {
        super(2, continuation);
        this.$uiEvent = sharedFlow;
        this.$snackbarHostState = snackbarHostState;
        this.$context = context;
        this.$view = view;
        this.$microphonePermissionLauncher = managedActivityResultLauncher;
        this.$navigateToDocumentScanner = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenKt$ConversationScreen$4$1(this.$uiEvent, this.$snackbarHostState, this.$context, this.$view, this.$microphonePermissionLauncher, this.$navigateToDocumentScanner, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$4$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ Context $context;
        final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $microphonePermissionLauncher;
        final /* synthetic */ Function0<Unit> $navigateToDocumentScanner;
        final /* synthetic */ SnackbarHostState $snackbarHostState;
        final /* synthetic */ View $view;

        AnonymousClass1(SnackbarHostState snackbarHostState, Context context, View view, ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, Function0<Unit> function0) {
            this.$snackbarHostState = snackbarHostState;
            this.$context = context;
            this.$view = view;
            this.$microphonePermissionLauncher = managedActivityResultLauncher;
            this.$navigateToDocumentScanner = function0;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
        
            if (androidx.compose.material3.SnackbarHostState.showSnackbar$default(r1, r2, (java.lang.String) null, false, (androidx.compose.material3.SnackbarDuration) null, r6, 14, (java.lang.Object) null) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00b9, code lost:
        
            if (androidx.compose.material3.SnackbarHostState.showSnackbar$default(r1, r3, (java.lang.String) null, true, (androidx.compose.material3.SnackbarDuration) null, r6, 10, (java.lang.Object) null) == r0) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 261
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$4$1.AnonymousClass1.emit(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((ConversationUiEvent) obj, (Continuation<? super Unit>) continuation);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    public final Object invokeSuspend(Object obj) throws KotlinNothingValueException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$uiEvent.collect(new AnonymousClass1(this.$snackbarHostState, this.$context, this.$view, this.$microphonePermissionLauncher, this.$navigateToDocumentScanner), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
