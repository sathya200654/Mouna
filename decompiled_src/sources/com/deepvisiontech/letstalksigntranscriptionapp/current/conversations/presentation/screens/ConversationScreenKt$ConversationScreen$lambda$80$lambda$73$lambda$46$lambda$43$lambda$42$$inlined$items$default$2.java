package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyDsl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ConversationScreenKt$ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$$inlined$items$default$2 implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $key;

    public ConversationScreenKt$ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$$inlined$items$default$2(Function1 function1, List list) {
        this.$key = function1;
        this.$items = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Object invoke(int i) {
        return this.$key.invoke(this.$items.get(i));
    }
}
