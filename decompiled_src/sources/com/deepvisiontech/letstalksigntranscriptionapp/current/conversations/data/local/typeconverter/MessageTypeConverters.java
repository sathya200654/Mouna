package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.typeconverter;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageInputType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageTypeConverters.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/typeconverter/MessageTypeConverters;", "", "<init>", "()V", "fromMessageInputTypeEnum", "", "inputType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "toMessageInputTypeEnum", "inputTypeString", "fromMessageTypeEnum", "messageType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageType;", "toLanguageEnum", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "language", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageTypeConverters {
    public static final int $stable = 0;

    public final String fromMessageInputTypeEnum(MessageInputType inputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        return inputType.name();
    }

    public final MessageInputType toMessageInputTypeEnum(String inputTypeString) {
        Intrinsics.checkNotNullParameter(inputTypeString, "inputTypeString");
        return MessageInputType.valueOf(inputTypeString);
    }

    public final String fromMessageTypeEnum(MessageType messageType) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        return messageType.name();
    }

    public final LanguageEnum toLanguageEnum(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return LanguageEnum.valueOf(language);
    }
}
