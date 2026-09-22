package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.typeconverters;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommonTypeConverters.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/typeconverters/CommonTypeConverters;", "", "<init>", "()V", "toMessageTypeEnum", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageType;", "messageTypeString", "", "fromLanguageEnum", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommonTypeConverters {
    public static final int $stable = 0;

    public final MessageType toMessageTypeEnum(String messageTypeString) {
        Intrinsics.checkNotNullParameter(messageTypeString, "messageTypeString");
        return MessageType.valueOf(messageTypeString);
    }

    public final String fromLanguageEnum(LanguageEnum language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return language.name();
    }
}
