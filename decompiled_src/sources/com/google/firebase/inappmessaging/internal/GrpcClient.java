package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class GrpcClient {
    private final InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub stub;

    @Inject
    GrpcClient(InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub inAppMessagingSdkServingBlockingStub) {
        this.stub = inAppMessagingSdkServingBlockingStub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchEligibleCampaignsResponse fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
        return ((InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub) this.stub.withDeadlineAfter(30000L, TimeUnit.MILLISECONDS)).fetchEligibleCampaigns(fetchEligibleCampaignsRequest);
    }
}
