package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SetInterpretationModeUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsettings/SetInterpretationModeUseCase;", "", "settingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "mode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetInterpretationModeUseCase {
    public static final int $stable = 8;
    private final AnalyticsManager analyticsManager;
    private final SettingsRepository settingsRepository;

    @Inject
    public SetInterpretationModeUseCase(SettingsRepository settingsRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.settingsRepository = settingsRepository;
        this.analyticsManager = analyticsManager;
    }

    public final Object invoke(InterpretationMode interpretationMode, Continuation<? super ResponseResource<Unit>> continuation) {
        this.analyticsManager.logEvent(new AnalyticsEvent.InterpretationModeChange(interpretationMode.name()));
        return this.settingsRepository.setInterpretationMode(interpretationMode, continuation);
    }
}
