package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.enums.TranscriptionLang;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/local/mappers/LanguageMapper;", "", "<init>", "()V", "toTranscriptionLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/legacy/ui/enums/TranscriptionLang;", "languageEnum", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "toLanguageEnum", "transcriptionLang", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LanguageMapper {
    public static final int $stable = 0;
    public static final LanguageMapper INSTANCE = new LanguageMapper();

    private LanguageMapper() {
    }

    public final TranscriptionLang toTranscriptionLang(LanguageEnum languageEnum) {
        Object next;
        Intrinsics.checkNotNullParameter(languageEnum, "languageEnum");
        Iterator it = TranscriptionLang.getEntries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((TranscriptionLang) next).getLang(), languageEnum.getLanguageCode()));
        TranscriptionLang transcriptionLang = (TranscriptionLang) next;
        if (transcriptionLang != null) {
            return transcriptionLang;
        }
        throw new IllegalStateException(("No TranscriptionLang for " + languageEnum.getLanguageCode()).toString());
    }

    public final LanguageEnum toLanguageEnum(TranscriptionLang transcriptionLang) {
        Object next;
        Intrinsics.checkNotNullParameter(transcriptionLang, "transcriptionLang");
        Iterator it = LanguageEnum.getEntries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((LanguageEnum) next).getLanguageCode(), transcriptionLang.getLang()));
        LanguageEnum languageEnum = (LanguageEnum) next;
        if (languageEnum != null) {
            return languageEnum;
        }
        throw new IllegalStateException(("No LanguageEnum for " + transcriptionLang.getLang()).toString());
    }
}
