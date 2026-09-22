package com.google.firebase.inappmessaging.model;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class CampaignMetadata {
    private final String campaignId;
    private final String campaignName;
    private final boolean isTestMessage;

    public CampaignMetadata(String str, String str2, boolean z) {
        this.campaignId = str;
        this.campaignName = str2;
        this.isTestMessage = z;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getCampaignName() {
        return this.campaignName;
    }

    public boolean getIsTestMessage() {
        return this.isTestMessage;
    }
}
