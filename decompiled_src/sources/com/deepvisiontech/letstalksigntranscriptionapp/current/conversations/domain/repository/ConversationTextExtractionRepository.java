package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: ConversationTextExtractionRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationTextExtractionRepository;", "", "extractTextFromImage", "", "image", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationTextExtractionRepository {
    default Object extractTextFromImage(byte[] bArr, Continuation<? super Unit> continuation) {
        return extractTextFromImage$suspendImpl(this, bArr, continuation);
    }

    /* JADX INFO: compiled from: ConversationTextExtractionRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object extractTextFromImage(ConversationTextExtractionRepository conversationTextExtractionRepository, byte[] bArr, Continuation<? super Unit> continuation) {
            Object objExtractTextFromImage = ConversationTextExtractionRepository.super.extractTextFromImage(bArr, continuation);
            return objExtractTextFromImage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExtractTextFromImage : Unit.INSTANCE;
        }
    }

    static /* synthetic */ Object extractTextFromImage$suspendImpl(ConversationTextExtractionRepository conversationTextExtractionRepository, byte[] bArr, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
