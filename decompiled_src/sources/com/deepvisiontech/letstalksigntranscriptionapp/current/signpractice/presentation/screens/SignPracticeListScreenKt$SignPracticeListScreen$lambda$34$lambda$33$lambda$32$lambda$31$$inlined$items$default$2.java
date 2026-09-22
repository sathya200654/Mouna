package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyDsl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeListScreenKt$SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$items$default$2 implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $key;

    public SignPracticeListScreenKt$SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$items$default$2(Function1 function1, List list) {
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
