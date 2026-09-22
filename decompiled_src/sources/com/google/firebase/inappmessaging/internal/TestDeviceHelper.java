package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Iterator;
import javax.inject.Inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class TestDeviceHelper {
    static final String FRESH_INSTALL_PREFERENCES = "fresh_install";
    static final int MAX_FETCH_COUNT = 5;
    static final String TEST_DEVICE_PREFERENCES = "test_device";
    private int fetchCount = 0;
    private boolean isFreshInstall = readFreshInstallStatusFromPreferences();
    private boolean isTestDevice = readTestDeviceStatusFromPreferences();
    private final SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public TestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    public boolean isDeviceInTestMode() {
        return this.isTestDevice;
    }

    public boolean isAppInstallFresh() {
        return this.isFreshInstall;
    }

    public void processCampaignFetch(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        if (this.isTestDevice) {
            return;
        }
        updateFreshInstallStatus();
        Iterator<CampaignProto.ThickContent> it = fetchEligibleCampaignsResponse.getMessagesList().iterator();
        while (it.hasNext()) {
            if (it.next().getIsTestCampaign()) {
                setTestDeviceStatus(true);
                Logging.logi("Setting this device as a test device");
                return;
            }
        }
    }

    private void updateFreshInstallStatus() {
        if (this.isFreshInstall) {
            int i = this.fetchCount + 1;
            this.fetchCount = i;
            if (i >= 5) {
                setFreshInstallStatus(false);
            }
        }
    }

    private void setTestDeviceStatus(boolean z) {
        this.isTestDevice = z;
        this.sharedPreferencesUtils.setBooleanPreference(TEST_DEVICE_PREFERENCES, z);
    }

    private void setFreshInstallStatus(boolean z) {
        this.isFreshInstall = z;
        this.sharedPreferencesUtils.setBooleanPreference(FRESH_INSTALL_PREFERENCES, z);
    }

    private boolean readTestDeviceStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference(TEST_DEVICE_PREFERENCES, false);
    }

    private boolean readFreshInstallStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference(FRESH_INSTALL_PREFERENCES, true);
    }
}
