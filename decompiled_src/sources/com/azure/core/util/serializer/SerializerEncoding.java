package com.azure.core.util.serializer;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public enum SerializerEncoding {
    JSON,
    XML,
    TEXT;

    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SerializerEncoding.class);

    public static SerializerEncoding fromHeaders(HttpHeaders httpHeaders) {
        final String value = httpHeaders.getValue(HttpHeaderName.CONTENT_TYPE);
        if (CoreUtils.isNullOrEmpty(value)) {
            LOGGER.verbose("'Content-Type' not found. Returning default encoding: JSON");
            return JSON;
        }
        int iIndexOf = value.indexOf(59);
        if (iIndexOf != -1) {
            value = value.substring(0, iIndexOf);
        }
        SerializerEncoding serializerEncodingCheckForKnownEncoding = checkForKnownEncoding(value);
        if (serializerEncodingCheckForKnownEncoding != null) {
            return serializerEncodingCheckForKnownEncoding;
        }
        int iIndexOf2 = value.indexOf(47);
        if (iIndexOf2 == -1) {
            LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.util.serializer.SerializerEncoding$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return SerializerEncoding.lambda$fromHeaders$0(value);
                }
            });
            return JSON;
        }
        String strSubstring = value.substring(iIndexOf2 + 1);
        int iLastIndexOf = strSubstring.lastIndexOf(43);
        if (iLastIndexOf == -1) {
            return JSON;
        }
        final String strSubstring2 = strSubstring.substring(iLastIndexOf + 1);
        if ("xml".equalsIgnoreCase(strSubstring2)) {
            return XML;
        }
        if ("json".equalsIgnoreCase(strSubstring2)) {
            return JSON;
        }
        LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.util.serializer.SerializerEncoding$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return SerializerEncoding.lambda$fromHeaders$1(strSubstring2);
            }
        });
        return JSON;
    }

    static /* synthetic */ String lambda$fromHeaders$0(String str) {
        return "Content-Type '" + str + "' does not match mime-type formatting 'type'/'subtype'. Returning default: JSON";
    }

    static /* synthetic */ String lambda$fromHeaders$1(String str) {
        return "Content-Type '" + str + "' does not match any supported one. Returning default: JSON";
    }

    private static SerializerEncoding checkForKnownEncoding(String str) {
        int length = str.length();
        if (length != 8 && length != 9 && length != 10 && length != 15 && length != 16) {
            return null;
        }
        if ("text/".regionMatches(true, 0, str, 0, 5)) {
            if (length == 8) {
                if ("xml".regionMatches(true, 0, str, 5, 3)) {
                    return XML;
                }
                if ("csv".regionMatches(true, 0, str, 5, 3)) {
                    return TEXT;
                }
                if ("css".regionMatches(true, 0, str, 5, 3)) {
                    return TEXT;
                }
            } else {
                if (length == 9 && "html".regionMatches(true, 0, str, 5, 4)) {
                    return TEXT;
                }
                if (length == 10 && "plain".regionMatches(true, 0, str, 5, 5)) {
                    return TEXT;
                }
                if (length == 15 && "javascript".regionMatches(true, 0, str, 5, 10)) {
                    return TEXT;
                }
            }
        } else if ("application/".regionMatches(true, 0, str, 0, 12)) {
            if (length == 16 && "json".regionMatches(true, 0, str, 12, 4)) {
                return JSON;
            }
            if (length == 15 && "xml".regionMatches(true, 0, str, 12, 3)) {
                return XML;
            }
        }
        return null;
    }
}
