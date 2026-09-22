package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.mappers;

import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.entity.SignPracticeEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPracticeMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toPractice", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/entity/SignPracticeEntity;", "toEntity", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeMapperKt {
    public static final SignPractice toPractice(SignPracticeEntity signPracticeEntity) {
        Intrinsics.checkNotNullParameter(signPracticeEntity, "<this>");
        return new SignPractice(signPracticeEntity.getId(), signPracticeEntity.getPracticeName(), signPracticeEntity.getDomain(), signPracticeEntity.getTopic(), signPracticeEntity.getContent(), signPracticeEntity.getComplexity(), signPracticeEntity.getLanguage(), signPracticeEntity.getType(), Uri.parse(signPracticeEntity.getUri()), signPracticeEntity.getOpens(), signPracticeEntity.getTimeCreated(), false, RecyclerView.ItemAnimator.FLAG_MOVED, null);
    }

    public static final SignPracticeEntity toEntity(SignPractice signPractice) {
        Intrinsics.checkNotNullParameter(signPractice, "<this>");
        int id = signPractice.getId();
        String practiceName = signPractice.getPracticeName();
        String domain = signPractice.getDomain();
        String topic = signPractice.getTopic();
        String content = signPractice.getContent();
        SignPracticeComplexity complexity = signPractice.getComplexity();
        LanguageEnum language = signPractice.getLanguage();
        SignPracticeType type = signPractice.getType();
        String string = signPractice.getUri().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new SignPracticeEntity(id, practiceName, domain, content, topic, complexity, language, type, string, signPractice.getOpens(), signPractice.getTimeCreated());
    }
}
