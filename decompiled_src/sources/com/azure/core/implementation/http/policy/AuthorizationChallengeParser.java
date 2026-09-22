package com.azure.core.implementation.http.policy;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.CoreUtils;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AuthorizationChallengeParser {
    private AuthorizationChallengeParser() {
    }

    public static boolean isCaeClaimsChallenge(HttpResponse httpResponse) {
        String challengeParametersForScheme = getChallengeParametersForScheme(httpResponse.getHeaderValue(HttpHeaderName.WWW_AUTHENTICATE), "Bearer");
        return !CoreUtils.isNullOrEmpty(getChallengeParameterValue(challengeParametersForScheme, "claims")) && "insufficient_claims".equals(getChallengeParameterValue(challengeParametersForScheme, "error"));
    }

    public static String getChallengeParameterFromResponse(HttpResponse httpResponse, String str, String str2) {
        return getChallengeParameterValue(getChallengeParametersForScheme(httpResponse.getHeaderValue(HttpHeaderName.WWW_AUTHENTICATE), str), str2);
    }

    private static String getChallengeParametersForScheme(String str, String str2) {
        int i;
        if (CoreUtils.isNullOrEmpty(str)) {
            return null;
        }
        int length = str.length();
        int length2 = str2.length();
        int i2 = 0;
        while (true) {
            if (i2 > (length - length2) - 1) {
                i2 = -1;
                break;
            }
            if (str.startsWith(str2, i2) && (i = i2 + length2) < length && str.charAt(i) == ' ') {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            return null;
        }
        int length3 = i2 + str2.length();
        int length4 = str.length();
        while (length3 < length4 && Character.isWhitespace(str.charAt(length3))) {
            length3++;
        }
        while (length4 > length3 && Character.isWhitespace(str.charAt(length4 - 1))) {
            length4--;
        }
        if (length3 < length4) {
            return str.substring(length3, length4);
        }
        return null;
    }

    private static String getChallengeParameterValue(String str, String str2) {
        if (CoreUtils.isNullOrEmpty(str)) {
            return null;
        }
        for (String str3 : str.split(",", -1)) {
            int iIndexOf = str3.indexOf(61);
            if (iIndexOf != -1 && str3.substring(0, iIndexOf).trim().equals(str2)) {
                return str3.substring(iIndexOf + 1).replace("\"", "").trim();
            }
        }
        return null;
    }
}
