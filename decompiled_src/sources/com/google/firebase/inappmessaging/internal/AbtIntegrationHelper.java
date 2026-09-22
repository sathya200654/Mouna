package com.google.firebase.inappmessaging.internal;

import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.AbtExperimentInfo;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.inappmessaging.ExperimentPayloadProto;
import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class AbtIntegrationHelper {
    private final FirebaseABTesting abTesting;
    Executor executor;

    @Inject
    public AbtIntegrationHelper(FirebaseABTesting firebaseABTesting, Executor executor) {
        this.abTesting = firebaseABTesting;
        this.executor = executor;
    }

    void updateRunningExperiments(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        final ArrayList arrayList = new ArrayList();
        for (CampaignProto.ThickContent thickContent : fetchEligibleCampaignsResponse.getMessagesList()) {
            if (!thickContent.getIsTestCampaign() && thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
                ExperimentPayloadProto.ExperimentPayload experimentPayload = thickContent.getExperimentalPayload().getExperimentPayload();
                arrayList.add(new AbtExperimentInfo(experimentPayload.getExperimentId(), experimentPayload.getVariantId(), experimentPayload.getTriggerEvent(), new Date(experimentPayload.getExperimentStartTimeMillis()), experimentPayload.getTriggerTimeoutMillis(), experimentPayload.getTimeToLiveMillis()));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.executor.execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.AbtIntegrationHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1991x72d842b3(arrayList);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateRunningExperiments$0$com-google-firebase-inappmessaging-internal-AbtIntegrationHelper, reason: not valid java name */
    /* synthetic */ void m1991x72d842b3(ArrayList arrayList) {
        try {
            Logging.logd("Updating running experiments with: " + arrayList.size() + " experiments");
            this.abTesting.validateRunningExperiments(arrayList);
        } catch (AbtException e) {
            Logging.loge("Unable to register experiments with ABT, missing analytics?\n" + e.getMessage());
        }
    }

    void setExperimentActive(final ExperimentPayloadProto.ExperimentPayload experimentPayload) {
        this.executor.execute(new Runnable() { // from class: com.google.firebase.inappmessaging.internal.AbtIntegrationHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1990x4a991527(experimentPayload);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setExperimentActive$1$com-google-firebase-inappmessaging-internal-AbtIntegrationHelper, reason: not valid java name */
    /* synthetic */ void m1990x4a991527(ExperimentPayloadProto.ExperimentPayload experimentPayload) {
        try {
            Logging.logd("Updating active experiment: " + experimentPayload.toString());
            this.abTesting.reportActiveExperiment(new AbtExperimentInfo(experimentPayload.getExperimentId(), experimentPayload.getVariantId(), experimentPayload.getTriggerEvent(), new Date(experimentPayload.getExperimentStartTimeMillis()), experimentPayload.getTriggerTimeoutMillis(), experimentPayload.getTimeToLiveMillis()));
        } catch (AbtException e) {
            Logging.loge("Unable to set experiment as active with ABT, missing analytics?\n" + e.getMessage());
        }
    }
}
