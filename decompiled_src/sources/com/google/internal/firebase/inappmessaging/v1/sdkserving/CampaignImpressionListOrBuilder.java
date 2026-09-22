package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface CampaignImpressionListOrBuilder extends MessageLiteOrBuilder {
    CampaignImpression getAlreadySeenCampaigns(int i);

    int getAlreadySeenCampaignsCount();

    List<CampaignImpression> getAlreadySeenCampaignsList();
}
