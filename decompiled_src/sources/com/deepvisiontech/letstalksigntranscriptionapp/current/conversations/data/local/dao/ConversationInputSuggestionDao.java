package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationInputSuggestionDao.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0097@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationInputSuggestionDao;", "", "getAllSuggestionsWithCategories", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/SuggestionWithCategoryTuple;", "getCategoryById", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionCategoryEntity;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCategory", "category", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionCategoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSuggestion", "suggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSuggestionWithCategory", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionCategoryEntity;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCategory", "", "updateSuggestion", "deleteCategory", "deleteSuggestion", "deleteSuggestionById", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationInputSuggestionDao {

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao$insertSuggestionWithCategory$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationInputSuggestionDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao", f = "ConversationInputSuggestionDao.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {58, 63}, m = "insertSuggestionWithCategory$suspendImpl", n = {"$this", "category", "suggestion", "$this", "category", "suggestion", "categoryId"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConversationInputSuggestionDao.insertSuggestionWithCategory$suspendImpl(ConversationInputSuggestionDao.this, null, null, (Continuation) this);
        }
    }

    Object deleteCategory(ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, Continuation<? super Unit> continuation);

    Object deleteSuggestion(ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Unit> continuation);

    Object deleteSuggestionById(long j, Continuation<? super Unit> continuation);

    Flow<List<SuggestionWithCategoryTuple>> getAllSuggestionsWithCategories();

    Object getCategoryById(long j, Continuation<? super ConversationInputSuggestionCategoryEntity> continuation);

    Object insertCategory(ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, Continuation<? super Long> continuation);

    Object insertSuggestion(ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Long> continuation);

    default Object insertSuggestionWithCategory(ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Long> continuation) {
        return insertSuggestionWithCategory$suspendImpl(this, conversationInputSuggestionCategoryEntity, conversationInputSuggestionSentenceEntity, continuation);
    }

    Object updateCategory(ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, Continuation<? super Unit> continuation);

    Object updateSuggestion(ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: ConversationInputSuggestionDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object insertSuggestionWithCategory(ConversationInputSuggestionDao conversationInputSuggestionDao, ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, Continuation<? super Long> continuation) {
            return ConversationInputSuggestionDao.super.insertSuggestionWithCategory(conversationInputSuggestionCategoryEntity, conversationInputSuggestionSentenceEntity, continuation);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007c, code lost:
    
        if (r6 == r3) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object insertSuggestionWithCategory$suspendImpl(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao r16, com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity r17, com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity r18, kotlin.coroutines.Continuation<? super java.lang.Long> r19) {
        /*
            r0 = r16
            r1 = r19
            boolean r2 = r1 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r1
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao$insertSuggestionWithCategory$1 r2 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao$insertSuggestionWithCategory$1 r2 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao$insertSuggestionWithCategory$1
            r2.<init>(r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L5b
            if (r4 == r6) goto L47
            if (r4 != r5) goto L3f
            long r3 = r2.J$0
            java.lang.Object r0 = r2.L$2
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity) r0
            java.lang.Object r0 = r2.L$1
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity) r0
            java.lang.Object r0 = r2.L$0
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao) r0
            kotlin.ResultKt.throwOnFailure(r1)
            return r1
        L3f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L47:
            java.lang.Object r0 = r2.L$2
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity) r0
            java.lang.Object r4 = r2.L$1
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity) r4
            java.lang.Object r6 = r2.L$0
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r15 = r1
            r1 = r0
            r0 = r6
            r6 = r15
            goto L7f
        L5b:
            kotlin.ResultKt.throwOnFailure(r1)
            long r7 = r17.getId()
            r9 = 0
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L86
            r2.L$0 = r0
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)
            r2.L$1 = r1
            r1 = r18
            r2.L$2 = r1
            r2.label = r6
            r4 = r17
            java.lang.Object r6 = r0.insertCategory(r4, r2)
            if (r6 != r3) goto L7f
            goto Lb7
        L7f:
            java.lang.Number r6 = (java.lang.Number) r6
            long r6 = r6.longValue()
            goto L8e
        L86:
            r4 = r17
            r1 = r18
            long r6 = r4.getId()
        L8e:
            r10 = r6
            r6 = r1
            r13 = 11
            r14 = 0
            r7 = 0
            r9 = 0
            r12 = 0
            com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity.copy$default(r6, r7, r9, r10, r12, r13, r14)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r2.L$0 = r7
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r2.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r2.L$2 = r4
            r2.J$0 = r10
            r2.label = r5
            java.lang.Object r0 = r0.insertSuggestion(r1, r2)
            if (r0 != r3) goto Lb8
        Lb7:
            return r3
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao.insertSuggestionWithCategory$suspendImpl(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao, com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionCategoryEntity, com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
