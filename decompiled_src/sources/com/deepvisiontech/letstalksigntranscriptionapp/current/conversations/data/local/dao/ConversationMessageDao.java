package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationMessageEntity;
import com.google.flatbuffers.FlexBuffers;
import com.google.protobuf.DescriptorProtos;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationMessageDao.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@¢\u0006\u0002\u0010\u0006J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0003H'J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H§@¢\u0006\u0002\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationMessageDao;", "", "insertMessage", "", ResponseKeys.KEY_MESSAGE, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationMessageEntity;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationMessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastSequenceId", "", "conversationId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWithNextSequenceId", "getAllMessagesOfConversation", "Lkotlinx/coroutines/flow/Flow;", "", "id", "updateMessage", "", "deleteMessages", "messages", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationMessageDao {

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao$insertWithNextSequenceId$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationMessageDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationMessageDao", f = "ConversationMessageDao.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {FlexBuffers.FBT_VECTOR_FLOAT4, DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER}, m = "insertWithNextSequenceId$suspendImpl", n = {"$this", ResponseKeys.KEY_MESSAGE, "$this", ResponseKeys.KEY_MESSAGE, "messageWithSequence", "lastId", "nextSequenceId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return ConversationMessageDao.insertWithNextSequenceId$suspendImpl(ConversationMessageDao.this, null, (Continuation) this);
        }
    }

    Object deleteMessages(Set<ConversationMessageEntity> set, Continuation<? super Unit> continuation);

    Flow<List<ConversationMessageEntity>> getAllMessagesOfConversation(long id);

    Object getLastSequenceId(long j, Continuation<? super Integer> continuation);

    Object insertMessage(ConversationMessageEntity conversationMessageEntity, Continuation<? super Long> continuation);

    default Object insertWithNextSequenceId(ConversationMessageEntity conversationMessageEntity, Continuation<? super ConversationMessageEntity> continuation) {
        return insertWithNextSequenceId$suspendImpl(this, conversationMessageEntity, continuation);
    }

    Object updateMessage(ConversationMessageEntity conversationMessageEntity, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: ConversationMessageDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object insertWithNextSequenceId(ConversationMessageDao conversationMessageDao, ConversationMessageEntity conversationMessageEntity, Continuation<? super ConversationMessageEntity> continuation) {
            return ConversationMessageDao.super.insertWithNextSequenceId(conversationMessageEntity, continuation);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object insertWithNextSequenceId$suspendImpl(ConversationMessageDao conversationMessageDao, ConversationMessageEntity conversationMessageEntity, Continuation<? super ConversationMessageEntity> continuation) {
        AnonymousClass1 anonymousClass1;
        ConversationMessageEntity conversationMessageEntity2;
        ConversationMessageEntity conversationMessageEntity3;
        ConversationMessageDao conversationMessageDao2 = conversationMessageDao;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = conversationMessageDao2.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = conversationMessageDao2.new AnonymousClass1(continuation);
        }
        Object objInsertMessage = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInsertMessage);
            long conversationIdFk = conversationMessageEntity.getConversationIdFk();
            anonymousClass1.L$0 = conversationMessageDao2;
            anonymousClass1.L$1 = conversationMessageEntity;
            anonymousClass1.label = 1;
            Object lastSequenceId = conversationMessageDao2.getLastSequenceId(conversationIdFk, anonymousClass1);
            if (lastSequenceId != coroutine_suspended) {
                conversationMessageEntity2 = conversationMessageEntity;
                objInsertMessage = lastSequenceId;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ConversationMessageEntity conversationMessageEntity4 = (ConversationMessageEntity) anonymousClass1.L$1;
            ConversationMessageDao conversationMessageDao3 = (ConversationMessageDao) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objInsertMessage);
            conversationMessageEntity2 = conversationMessageEntity4;
            conversationMessageDao2 = conversationMessageDao3;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$1;
            int i3 = anonymousClass1.I$0;
            ConversationMessageEntity conversationMessageEntity5 = (ConversationMessageEntity) anonymousClass1.L$2;
            ResultKt.throwOnFailure(objInsertMessage);
            conversationMessageEntity3 = conversationMessageEntity5;
        }
        return ConversationMessageEntity.copy$default(conversationMessageEntity3, ((Number) objInsertMessage).longValue(), 0L, null, null, null, null, null, null, 0, null, null, false, 0L, 8190, null);
        Integer num = (Integer) objInsertMessage;
        int iIntValue = num != null ? num.intValue() : 0;
        int i4 = iIntValue + 1;
        ConversationMessageEntity conversationMessageEntityCopy$default = ConversationMessageEntity.copy$default(conversationMessageEntity2, 0L, 0L, null, null, null, null, null, null, i4, null, null, false, 0L, 7935, null);
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(conversationMessageDao2);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(conversationMessageEntity2);
        anonymousClass1.L$2 = conversationMessageEntityCopy$default;
        anonymousClass1.I$0 = iIntValue;
        anonymousClass1.I$1 = i4;
        anonymousClass1.label = 2;
        objInsertMessage = conversationMessageDao2.insertMessage(conversationMessageEntityCopy$default, anonymousClass1);
        if (objInsertMessage != coroutine_suspended) {
            conversationMessageEntity3 = conversationMessageEntityCopy$default;
            return ConversationMessageEntity.copy$default(conversationMessageEntity3, ((Number) objInsertMessage).longValue(), 0L, null, null, null, null, null, null, 0, null, null, false, 0L, 8190, null);
        }
        return coroutine_suspended;
    }
}
