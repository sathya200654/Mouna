package com.azure.core.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AuthorizationChallengeHandler {
    private static final String ALGORITHM = "algorithm";
    private static final String AUTH = "auth";
    public static final String AUTHENTICATION_INFO = "Authentication-Info";
    public static final String AUTHORIZATION = "Authorization";
    private static final String AUTH_INT = "auth-int";
    private static final String BASIC = "Basic ";
    private static final String DIGEST = "Digest ";
    private static final String NEXT_NONCE = "nextnonce";
    private static final String NONCE = "nonce";
    private static final String OPAQUE = "opaque";
    public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
    public static final String PROXY_AUTHENTICATION_INFO = "Proxy-Authentication-Info";
    public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
    private static final String QOP = "qop";
    private static final String REALM = "realm";
    private static final String SESS = "-SESS";
    private static final String USERHASH = "userhash";
    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    private final String password;
    private final String username;
    private static final String SHA_512_256 = "SHA-512-256";
    private static final String SHA_512_256_SESS = "SHA-512-256-SESS";
    private static final String SHA_256 = "SHA-256";
    private static final String SHA_256_SESS = "SHA-256-SESS";
    private static final String MD5 = "MD5";
    private static final String MD5_SESS = "MD5-SESS";
    private static final String[] ALGORITHM_PREFERENCE_ORDER = {SHA_512_256, SHA_512_256_SESS, SHA_256, SHA_256_SESS, MD5, MD5_SESS};
    private final Map<String, AtomicInteger> nonceTracker = new ConcurrentHashMap();
    private final AtomicReference<String> authorizationPipeliningType = new AtomicReference<>();
    private final AtomicReference<ConcurrentHashMap<String, String>> lastChallenge = new AtomicReference<>();
    private final SecureRandom nonceGenerator = new SecureRandom();

    public AuthorizationChallengeHandler(String str, String str2) {
        this.username = (String) Objects.requireNonNull(str, "'username' cannot be null.");
        this.password = (String) Objects.requireNonNull(str2, "'password' cannot be null.");
    }

    public final String handleBasic() {
        this.authorizationPipeliningType.set(BASIC);
        return BASIC + Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes(StandardCharsets.UTF_8));
    }

    public final String handleDigest(String str, String str2, List<Map<String, String>> list, Supplier<byte[]> supplier) {
        Function<byte[], byte[]> digestFunction;
        this.authorizationPipeliningType.set(DIGEST);
        Map<String, List<Map<String, String>>> mapPartitionByChallengeType = partitionByChallengeType(list);
        for (String str3 : ALGORITHM_PREFERENCE_ORDER) {
            if (mapPartitionByChallengeType.containsKey(str3) && (digestFunction = getDigestFunction(str3)) != null) {
                ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(mapPartitionByChallengeType.get(str3).get(0));
                this.lastChallenge.set(concurrentHashMap);
                return createDigestAuthorizationHeader(str, str2, concurrentHashMap, str3, supplier, digestFunction);
            }
        }
        return null;
    }

    public final String attemptToPipelineAuthorization(String str, String str2, Supplier<byte[]> supplier) {
        String str3 = this.authorizationPipeliningType.get();
        if (DIGEST.equals(str3)) {
            HashMap map = new HashMap(this.lastChallenge.get());
            String str4 = map.get(ALGORITHM);
            if (str4 == null) {
                str4 = MD5;
            }
            String str5 = str4;
            return createDigestAuthorizationHeader(str, str2, map, str5, supplier, getDigestFunction(str5));
        }
        if (BASIC.equals(str3)) {
            return handleBasic();
        }
        return null;
    }

    public final void consumeAuthenticationInfoHeader(Map<String, String> map) {
        if (!CoreUtils.isNullOrEmpty(map) && map.containsKey(NEXT_NONCE)) {
            this.lastChallenge.get().put(NONCE, map.get(NEXT_NONCE));
        }
    }

    public static Map<String, String> parseAuthenticationOrAuthorizationHeader(String str) {
        if (CoreUtils.isNullOrEmpty(str)) {
            return Collections.emptyMap();
        }
        if (str.startsWith(BASIC) || str.startsWith(DIGEST)) {
            str = str.split(" ", 2)[1];
        }
        return (Map) Stream.of((Object[]) str.split(",")).map(new Function() { // from class: com.azure.core.util.AuthorizationChallengeHandler$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).trim();
            }
        }).map(new Function() { // from class: com.azure.core.util.AuthorizationChallengeHandler$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).split("=", 2);
            }
        }).collect(Collectors.toMap(new Function() { // from class: com.azure.core.util.AuthorizationChallengeHandler$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String[]) obj)[0].toLowerCase(Locale.ROOT);
            }
        }, new Function() { // from class: com.azure.core.util.AuthorizationChallengeHandler$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String[]) obj)[1].replace("\"", "");
            }
        }));
    }

    private String createDigestAuthorizationHeader(String str, String str2, Map<String, String> map, String str3, Supplier<byte[]> supplier, Function<byte[], byte[]> function) {
        int nc;
        String strGenerateNonce;
        Function<byte[], byte[]> function2;
        String strCalculateHa1NoSess;
        String strCalculateHa2AuthQopOrEmpty;
        String str4;
        int i;
        String strCalculateResponseKnownQop;
        String str5;
        String str6 = map.get(REALM);
        String str7 = map.get(NONCE);
        String qop = getQop(map.get(QOP));
        String str8 = map.get(OPAQUE);
        boolean z = Boolean.parseBoolean(map.get(USERHASH));
        if (AUTH.equals(qop) || AUTH_INT.equals(qop)) {
            String strGenerateNonce2 = generateNonce();
            nc = getNc(map);
            strGenerateNonce = strGenerateNonce2;
        } else {
            strGenerateNonce = str3.endsWith(SESS) ? generateNonce() : null;
            nc = 0;
        }
        if (str3.endsWith(SESS)) {
            function2 = function;
            strCalculateHa1NoSess = calculateHa1Sess(function2, this.username, str6, this.password, str7, strGenerateNonce);
        } else {
            function2 = function;
            strCalculateHa1NoSess = calculateHa1NoSess(function2, this.username, str6, this.password);
        }
        if (AUTH_INT.equals(qop)) {
            strCalculateHa2AuthQopOrEmpty = calculateHa2AuthIntQop(function2, str, str2, supplier.get());
        } else {
            strCalculateHa2AuthQopOrEmpty = calculateHa2AuthQopOrEmpty(function2, str, str2);
        }
        if (AUTH.equals(qop) || AUTH_INT.equals(qop)) {
            String str9 = strGenerateNonce;
            str4 = qop;
            i = nc;
            strCalculateResponseKnownQop = calculateResponseKnownQop(function2, strCalculateHa1NoSess, str7, i, str9, str4, strCalculateHa2AuthQopOrEmpty);
            str5 = str9;
            str7 = str7;
        } else {
            String strCalculateResponseUnknownQop = calculateResponseUnknownQop(function2, strCalculateHa1NoSess, str7, strCalculateHa2AuthQopOrEmpty);
            i = nc;
            str5 = strGenerateNonce;
            str4 = qop;
            strCalculateResponseKnownQop = strCalculateResponseUnknownQop;
        }
        String strCalculateUserhash = this.username;
        if (z) {
            strCalculateUserhash = calculateUserhash(function2, strCalculateUserhash, str6);
        }
        return buildAuthorizationHeader(strCalculateUserhash, str6, str2, str3, str7, i, str5, str4, strCalculateResponseKnownQop, str8, z);
    }

    private int getNc(Map<String, String> map) {
        return this.nonceTracker.compute(map.get(NONCE), new BiFunction() { // from class: com.azure.core.util.AuthorizationChallengeHandler$$ExternalSyntheticLambda3
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return AuthorizationChallengeHandler.lambda$getNc$3((String) obj, (AtomicInteger) obj2);
            }
        }).get();
    }

    static /* synthetic */ AtomicInteger lambda$getNc$3(String str, AtomicInteger atomicInteger) {
        if (atomicInteger == null) {
            return new AtomicInteger(1);
        }
        atomicInteger.incrementAndGet();
        return atomicInteger;
    }

    private String getQop(String str) {
        if (CoreUtils.isNullOrEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(AUTH)) {
            return AUTH;
        }
        if (str.equalsIgnoreCase(AUTH_INT)) {
            return AUTH_INT;
        }
        return null;
    }

    private static String calculateHa1NoSess(Function<byte[], byte[]> function, String str, String str2, String str3) {
        return CoreUtils.bytesToHexString(function.apply((str + ":" + str2 + ":" + str3).getBytes(StandardCharsets.UTF_8)));
    }

    private static String calculateHa1Sess(Function<byte[], byte[]> function, String str, String str2, String str3, String str4, String str5) {
        return CoreUtils.bytesToHexString(function.apply((calculateHa1NoSess(function, str, str2, str3) + ":" + str4 + ":" + str5).getBytes(StandardCharsets.UTF_8)));
    }

    private static String calculateHa2AuthQopOrEmpty(Function<byte[], byte[]> function, String str, String str2) {
        return CoreUtils.bytesToHexString(function.apply((str + ":" + str2).getBytes(StandardCharsets.UTF_8)));
    }

    private static String calculateHa2AuthIntQop(Function<byte[], byte[]> function, String str, String str2, byte[] bArr) {
        return CoreUtils.bytesToHexString(function.apply((str + ":" + str2 + ":" + CoreUtils.bytesToHexString(function.apply(bArr))).getBytes(StandardCharsets.UTF_8)));
    }

    private static String calculateResponseUnknownQop(Function<byte[], byte[]> function, String str, String str2, String str3) {
        return CoreUtils.bytesToHexString(function.apply((str + ":" + str2 + ":" + str3).getBytes(StandardCharsets.UTF_8)));
    }

    private static String calculateResponseKnownQop(Function<byte[], byte[]> function, String str, String str2, int i, String str3, String str4, String str5) {
        return CoreUtils.bytesToHexString(function.apply((str + ":" + str2 + ":" + String.format("%08X", Integer.valueOf(i)) + ":" + str3 + ":" + str4 + ":" + str5).getBytes(StandardCharsets.UTF_8)));
    }

    private static String calculateUserhash(Function<byte[], byte[]> function, String str, String str2) {
        return CoreUtils.bytesToHexString(function.apply((str + ":" + str2).getBytes(StandardCharsets.UTF_8)));
    }

    private static Function<byte[], byte[]> getDigestFunction(String str) {
        if (str.endsWith(SESS)) {
            str = str.substring(0, str.length() - SESS.length());
        }
        try {
            if (SHA_512_256.equals(str)) {
                final MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
                return new Function() { // from class: com.azure.core.util.AuthorizationChallengeHandler$$ExternalSyntheticLambda0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Arrays.copyOf(messageDigest.digest((byte[]) obj), 32);
                    }
                };
            }
            final MessageDigest messageDigest2 = MessageDigest.getInstance(str);
            Objects.requireNonNull(messageDigest2);
            return new Function() { // from class: com.azure.core.util.AuthorizationChallengeHandler$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return messageDigest2.digest((byte[]) obj);
                }
            };
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static Map<String, List<Map<String, String>>> partitionByChallengeType(List<Map<String, String>> list) {
        return (Map) list.stream().collect(Collectors.groupingBy(new Function() { // from class: com.azure.core.util.AuthorizationChallengeHandler$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return AuthorizationChallengeHandler.lambda$partitionByChallengeType$5((Map) obj);
            }
        }));
    }

    static /* synthetic */ String lambda$partitionByChallengeType$5(Map map) {
        String str = (String) map.get(ALGORITHM);
        return str == null ? MD5 : str.toUpperCase(Locale.ROOT);
    }

    String generateNonce() {
        byte[] bArr = new byte[16];
        this.nonceGenerator.nextBytes(bArr);
        return CoreUtils.bytesToHexString(bArr);
    }

    private static String buildAuthorizationHeader(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        sb.append("Digest username=\"").append(str).append("\", realm=\"").append(str2).append("\", nonce=\"").append(str5).append("\", uri=\"").append(str3).append("\", response=\"").append(str8).append("\"");
        if (!CoreUtils.isNullOrEmpty(str4)) {
            sb.append(", algorithm=").append(str4);
        }
        if (!CoreUtils.isNullOrEmpty(str6)) {
            sb.append(", cnonce=\"").append(str6).append("\"");
        }
        if (!CoreUtils.isNullOrEmpty(str9)) {
            sb.append(", opaque=\"").append(str9).append("\"");
        }
        if (!CoreUtils.isNullOrEmpty(str7)) {
            sb.append(", qop=").append(str7);
            sb.append(", nc=").append(String.format("%08X", Integer.valueOf(i)));
        }
        if (z) {
            sb.append(", userhash=true");
        }
        return sb.toString();
    }
}
