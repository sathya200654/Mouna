package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: GetAllFilteredSignPracticeUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J?\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/GetAllFilteredSignPracticesUseCase;", "", "signPracticeRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "searchQuery", "", "sortOrder", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "dateFilterRange", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetAllFilteredSignPracticesUseCase {
    public static final int $stable = 8;
    private final SignPracticeRepository signPracticeRepository;

    @Inject
    public GetAllFilteredSignPracticesUseCase(SignPracticeRepository signPracticeRepository) {
        Intrinsics.checkNotNullParameter(signPracticeRepository, "signPracticeRepository");
        this.signPracticeRepository = signPracticeRepository;
    }

    public final Flow<List<SignPractice>> invoke(Flow<String> searchQuery, Flow<? extends ListSortOrder> sortOrder, Flow<DateFilterRange> dateFilterRange) {
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
        Intrinsics.checkNotNullParameter(dateFilterRange, "dateFilterRange");
        return FlowKt.combine(this.signPracticeRepository.getAllPractices(), searchQuery, sortOrder, dateFilterRange, new AnonymousClass1(null));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetAllFilteredSignPracticeUseCase.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n"}, d2 = {"<anonymous>", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "practices", "searchQuery", "", "sortOrder", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "dateFilterRange", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase$invoke$1", f = "GetAllFilteredSignPracticeUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function5<List<? extends SignPractice>, String, ListSortOrder, DateFilterRange, Continuation<? super List<? extends SignPractice>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ Object L$3;
        int label;

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase$invoke$1$WhenMappings */
        /* JADX INFO: compiled from: GetAllFilteredSignPracticeUseCase.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ListSortOrder.values().length];
                try {
                    iArr[ListSortOrder.BY_TIME_ASC.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ListSortOrder.BY_TIME_DESC.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ListSortOrder.BY_NAME_ASC.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ListSortOrder.BY_NAME_DESC.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(5, continuation);
        }

        public final Object invoke(List<SignPractice> list, String str, ListSortOrder listSortOrder, DateFilterRange dateFilterRange, Continuation<? super List<SignPractice>> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = list;
            anonymousClass1.L$1 = str;
            anonymousClass1.L$2 = listSortOrder;
            anonymousClass1.L$3 = dateFilterRange;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
            List list = (List) this.L$0;
            String str = (String) this.L$1;
            ListSortOrder listSortOrder = (ListSortOrder) this.L$2;
            DateFilterRange dateFilterRange = (DateFilterRange) this.L$3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (StringsKt.contains(((SignPractice) obj2).getPracticeName(), str, true)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (dateFilterRange.getStartDate() != null && dateFilterRange.getEndDate() != null) {
                Long startDate = dateFilterRange.getStartDate();
                Long endDate = dateFilterRange.getEndDate();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : arrayList2) {
                    long timeCreated = ((SignPractice) obj3).getTimeCreated();
                    if (startDate.longValue() <= timeCreated && timeCreated <= endDate.longValue()) {
                        arrayList3.add(obj3);
                    }
                }
                arrayList2 = arrayList3;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[listSortOrder.ordinal()];
            if (i == 1) {
                return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase$invoke$1$invokeSuspend$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((SignPractice) t).getTimeCreated()), Long.valueOf(((SignPractice) t2).getTimeCreated()));
                    }
                });
            }
            if (i == 2) {
                return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase$invoke$1$invokeSuspend$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((SignPractice) t2).getTimeCreated()), Long.valueOf(((SignPractice) t).getTimeCreated()));
                    }
                });
            }
            if (i == 3) {
                return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase$invoke$1$invokeSuspend$$inlined$sortedBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String lowerCase = ((SignPractice) t).getPracticeName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((SignPractice) t2).getPracticeName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase$invoke$1$invokeSuspend$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String lowerCase = ((SignPractice) t2).getPracticeName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = ((SignPractice) t).getPracticeName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            });
        }
    }
}
