package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface FetchEligibleCampaignsResponseOrBuilder extends MessageLiteOrBuilder {
    long getExpirationEpochTimestampMillis();

    CampaignProto.ThickContent getMessages(int i);

    int getMessagesCount();

    List<CampaignProto.ThickContent> getMessagesList();
}
