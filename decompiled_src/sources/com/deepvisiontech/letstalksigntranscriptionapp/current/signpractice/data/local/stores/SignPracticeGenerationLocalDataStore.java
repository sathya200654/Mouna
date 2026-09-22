package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.stores;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeDomain;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: SignPracticeGenerationLocalDataStore.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/stores/SignPracticeGenerationLocalDataStore;", "", "<init>", "()V", "getGenerationDomains", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeDomain;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeGenerationLocalDataStore {
    public static final int $stable = 0;
    public static final SignPracticeGenerationLocalDataStore INSTANCE = new SignPracticeGenerationLocalDataStore();

    private SignPracticeGenerationLocalDataStore() {
    }

    public final List<SignPracticeDomain> getGenerationDomains() {
        return CollectionsKt.listOf(new SignPracticeDomain[]{new SignPracticeDomain("bus", "Business", false, 4, null), new SignPracticeDomain("edu", "Education", false, 4, null), new SignPracticeDomain("spr", "Sports", false, 4, null), new SignPracticeDomain("tec", "Technology", false, 4, null), new SignPracticeDomain("hea", "Health", false, 4, null), new SignPracticeDomain("sci", "Science", false, 4, null), new SignPracticeDomain("ent", "Entertainment", false, 4, null), new SignPracticeDomain("wor", "World", false, 4, null), new SignPracticeDomain("pol", "Politics", false, 4, null), new SignPracticeDomain("lif", "Lifestyle", false, 4, null)});
    }
}
