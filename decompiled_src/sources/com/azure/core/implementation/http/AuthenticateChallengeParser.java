package com.azure.core.implementation.http;

import com.azure.core.util.AuthenticateChallenge;
import com.azure.core.util.logging.ClientLogger;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AuthenticateChallengeParser {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) AuthenticateChallengeParser.class);
    private static final boolean[] VALID_TOKEN68_CHARS;
    private static final boolean[] VALID_TOKEN_CHARS;
    private final String challenge;
    private final int challengeLength;
    private AuthenticateChallengeToken token;
    private State state = State.BEGINNING;
    private int currentIndex = 0;

    private enum State {
        BEGINNING,
        CHALLENGE_SEPARATOR,
        SCHEME
    }

    static {
        boolean[] zArr = new boolean[128];
        VALID_TOKEN_CHARS = zArr;
        boolean[] zArr2 = new boolean[128];
        VALID_TOKEN68_CHARS = zArr2;
        Arrays.fill(zArr2, 48, 58, true);
        Arrays.fill(zArr2, 65, 91, true);
        Arrays.fill(zArr2, 97, 123, true);
        zArr2[45] = true;
        zArr2[46] = true;
        zArr2[95] = true;
        zArr2[126] = true;
        zArr2[43] = true;
        System.arraycopy(zArr2, 0, zArr, 0, 128);
        zArr[33] = true;
        zArr[35] = true;
        zArr[36] = true;
        zArr[37] = true;
        zArr[38] = true;
        zArr[39] = true;
        zArr[42] = true;
        zArr[94] = true;
        zArr[96] = true;
        zArr[124] = true;
        zArr2[47] = true;
    }

    public AuthenticateChallengeParser(String str) {
        this.challenge = (String) Objects.requireNonNull(str, "challenge cannot be null.");
        this.challengeLength = str.length();
        while (true) {
            int i = this.currentIndex;
            if (i >= this.challengeLength) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt != ',' && cCharAt != ' ' && cCharAt != '\t') {
                return;
            } else {
                this.currentIndex++;
            }
        }
    }

    public List<AuthenticateChallenge> parse() {
        ArrayList arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        LinkedHashMap linkedHashMap = null;
        while (next()) {
            if (this.token.scheme != null) {
                if (str != null) {
                    arrayList.add(createChallenge(str, str2, linkedHashMap));
                    str2 = null;
                    linkedHashMap = null;
                }
                str = this.token.scheme;
            } else if (this.token.token68 != null) {
                if (str == null) {
                    throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Challenge had token68 before scheme."));
                }
                if (str2 != null) {
                    throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Challenge had multiple token68s."));
                }
                str2 = this.token.token68;
            } else if (this.token.authParam == null) {
                continue;
            } else {
                if (str == null) {
                    throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Challenge had auth-param before scheme."));
                }
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                if (linkedHashMap.put(this.token.authParam.getKey(), this.token.authParam.getValue()) != null) {
                    throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Challenge had duplicate auth-param."));
                }
            }
        }
        if (str != null) {
            arrayList.add(createChallenge(str, str2, linkedHashMap));
        }
        return arrayList;
    }

    private AuthenticateChallenge createChallenge(String str, String str2, Map<String, String> map) {
        if (str2 == null && map == null) {
            return new AuthenticateChallenge(str);
        }
        if (str2 == null) {
            return new AuthenticateChallenge(str, map);
        }
        if (map == null) {
            return new AuthenticateChallenge(str, str2);
        }
        throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Challenge had both token68 and auth-params."));
    }

    boolean next() {
        if (this.currentIndex >= this.challengeLength) {
            return false;
        }
        if (this.state == State.BEGINNING) {
            handleBeginning();
            return true;
        }
        if (this.state == State.SCHEME) {
            handleScheme();
            return true;
        }
        if (this.state != State.CHALLENGE_SEPARATOR) {
            return true;
        }
        handleChallenge();
        return true;
    }

    private char iterateUntil(Predicate<Character> predicate) {
        while (true) {
            int i = this.currentIndex;
            if (i >= this.challengeLength) {
                return (char) 0;
            }
            char cCharAt = this.challenge.charAt(i);
            if (predicate.test(Character.valueOf(cCharAt))) {
                return cCharAt;
            }
            this.currentIndex++;
        }
    }

    private char iterateUntilNextNonSpace() {
        this.currentIndex++;
        return iterateUntil(new Predicate() { // from class: com.azure.core.implementation.http.AuthenticateChallengeParser$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AuthenticateChallengeParser.lambda$iterateUntilNextNonSpace$0((Character) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$iterateUntilNextNonSpace$0(Character ch) {
        return (ch.charValue() == ' ' || ch.charValue() == '\t') ? false : true;
    }

    private char iterateUntilEqualsSpaceOrComma() {
        return iterateUntil(new Predicate() { // from class: com.azure.core.implementation.http.AuthenticateChallengeParser$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AuthenticateChallengeParser.lambda$iterateUntilEqualsSpaceOrComma$1((Character) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$iterateUntilEqualsSpaceOrComma$1(Character ch) {
        return ch.charValue() == '=' || ch.charValue() == ' ' || ch.charValue() == ',';
    }

    private void handleBeginning() {
        this.token = handleSchemeToken(this.currentIndex, this.currentIndex, iterateUntil(new Predicate() { // from class: com.azure.core.implementation.http.AuthenticateChallengeParser$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AuthenticateChallengeParser.lambda$handleBeginning$2((Character) obj);
            }
        }), false);
    }

    static /* synthetic */ boolean lambda$handleBeginning$2(Character ch) {
        return ch.charValue() == ' ' || ch.charValue() == '\t' || ch.charValue() == ',';
    }

    private AuthenticateChallengeToken handleSchemeToken(int i, int i2, char c, boolean z) {
        String strSubstring = this.challenge.substring(i, i2);
        if (!isValidToken(strSubstring)) {
            throw LOGGER.atError().addKeyValue("challenge", this.challenge).addKeyValue("scheme", strSubstring).log((RuntimeException) new IllegalArgumentException("Scheme contained an invalid character."));
        }
        if (!z && c != ',') {
            c = iterateUntilNextNonSpace();
        }
        if (this.currentIndex < this.challengeLength && c == ',') {
            this.state = State.CHALLENGE_SEPARATOR;
            iterateUntilNextNonSpace();
        } else {
            this.state = State.SCHEME;
        }
        return new AuthenticateChallengeToken(strSubstring, null, null);
    }

    private void handleScheme() {
        int i;
        int i2;
        char cIterateUntil;
        int i3 = this.currentIndex;
        char cIterateUntilEqualsSpaceOrComma = iterateUntilEqualsSpaceOrComma();
        if (cIterateUntilEqualsSpaceOrComma == ',' || (i = this.currentIndex) == (i2 = this.challengeLength)) {
            this.token = new AuthenticateChallengeToken(null, validateToken68(this.challenge, i3, this.currentIndex), null);
        } else if (cIterateUntilEqualsSpaceOrComma == ' ') {
            char cIterateUntilNextNonSpace = iterateUntilNextNonSpace();
            if (cIterateUntilNextNonSpace != '=' && cIterateUntilNextNonSpace != ',' && this.currentIndex < this.challengeLength) {
                throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Challenge had more than one token68 or auth-param in the same comma separator."));
            }
            if (cIterateUntilNextNonSpace == ',' || this.currentIndex == this.challengeLength) {
                this.token = new AuthenticateChallengeToken(null, validateToken68(this.challenge, i3, this.currentIndex), null);
            } else {
                createAuthParamToken(i3, i, iterateUntilNextNonSpace());
            }
        } else {
            if (i + 1 == i2 || this.challenge.charAt(i + 1) == '=') {
                cIterateUntil = iterateUntil(new Predicate() { // from class: com.azure.core.implementation.http.AuthenticateChallengeParser$$ExternalSyntheticLambda5
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return AuthenticateChallengeParser.lambda$handleScheme$3((Character) obj);
                    }
                });
                this.token = new AuthenticateChallengeToken(null, validateToken68(this.challenge, i3, this.currentIndex), null);
            } else {
                cIterateUntil = iterateUntilNextNonSpace();
                if (cIterateUntil == ',' || this.currentIndex == this.challengeLength) {
                    this.token = new AuthenticateChallengeToken(null, validateToken68(this.challenge, i3, i + 1), null);
                } else {
                    cIterateUntil = createAuthParamToken(i3, i, cIterateUntil);
                }
            }
            if (cIterateUntil != ',' && this.currentIndex != this.challengeLength) {
                cIterateUntil = iterateUntilNextNonSpace();
            }
            if (this.currentIndex < this.challengeLength && cIterateUntil != ',') {
                throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Challenge had more than one token68 or auth-param in the same comma separator."));
            }
        }
        this.state = State.CHALLENGE_SEPARATOR;
        iterateUntilNextNonSpace();
    }

    static /* synthetic */ boolean lambda$handleScheme$3(Character ch) {
        return ch.charValue() != '=';
    }

    private char createAuthParamToken(int i, int i2, char c) {
        char cIterateUntil;
        String strSubstring;
        String strSubstring2 = this.challenge.substring(i, i2);
        if (!isValidToken(strSubstring2)) {
            throw LOGGER.atError().addKeyValue("challenge", this.challenge).addKeyValue("authParamKey", strSubstring2).log((RuntimeException) new IllegalArgumentException("Auth-param key contained an invalid character."));
        }
        int i3 = this.currentIndex;
        if (c == '\"') {
            this.currentIndex = i3 + 1;
            int i4 = i3 + 1;
            cIterateUntil = iterateUntil(new Predicate() { // from class: com.azure.core.implementation.http.AuthenticateChallengeParser$$ExternalSyntheticLambda3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f$0.m1162x995a61e6((Character) obj);
                }
            });
            if (cIterateUntil != '\"') {
                throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Quoted-string was not terminated with a double quote."));
            }
            strSubstring = this.challenge.substring(i4, this.currentIndex).replace("\\\\", "");
        } else {
            cIterateUntil = iterateUntil(new Predicate() { // from class: com.azure.core.implementation.http.AuthenticateChallengeParser$$ExternalSyntheticLambda4
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return AuthenticateChallengeParser.lambda$createAuthParamToken$5((Character) obj);
                }
            });
            strSubstring = this.challenge.substring(i3, this.currentIndex);
            if (!isValidToken(strSubstring)) {
                throw LOGGER.atError().addKeyValue("challenge", this.challenge).addKeyValue("authParamValue", strSubstring).log((RuntimeException) new IllegalArgumentException("Auth-param value contained an invalid character."));
            }
        }
        if (cIterateUntil != ',') {
            cIterateUntil = iterateUntilNextNonSpace();
        }
        if (this.currentIndex < this.challengeLength && cIterateUntil != ',') {
            throw LOGGER.atError().addKeyValue("challenge", this.challenge).log((RuntimeException) new IllegalArgumentException("Challenge had more than one token68 or auth-param in the same comma separator."));
        }
        this.token = new AuthenticateChallengeToken(null, null, new AbstractMap.SimpleEntry(strSubstring2, strSubstring));
        return cIterateUntil;
    }

    /* JADX INFO: renamed from: lambda$createAuthParamToken$4$com-azure-core-implementation-http-AuthenticateChallengeParser, reason: not valid java name */
    /* synthetic */ boolean m1162x995a61e6(Character ch) {
        return ch.charValue() == '\"' && this.challenge.charAt(this.currentIndex - 1) != '\\';
    }

    static /* synthetic */ boolean lambda$createAuthParamToken$5(Character ch) {
        return ch.charValue() == ' ' || ch.charValue() == '\t' || ch.charValue() == ',';
    }

    private void handleChallenge() {
        int i;
        int i2 = this.currentIndex;
        char cIterateUntil = iterateUntil(new Predicate() { // from class: com.azure.core.implementation.http.AuthenticateChallengeParser$$ExternalSyntheticLambda6
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AuthenticateChallengeParser.lambda$handleChallenge$6((Character) obj);
            }
        });
        if (cIterateUntil == ',' || (i = this.currentIndex) == this.challengeLength) {
            this.token = handleSchemeToken(i2, this.currentIndex, cIterateUntil, true);
            return;
        }
        if (cIterateUntil == '=') {
            createAuthParamToken(i2, i, iterateUntilNextNonSpace());
            this.state = State.CHALLENGE_SEPARATOR;
            iterateUntilNextNonSpace();
            return;
        }
        char cIterateUntilNextNonSpace = iterateUntilNextNonSpace();
        if (cIterateUntilNextNonSpace == '=') {
            createAuthParamToken(i2, i, iterateUntilNextNonSpace());
            this.state = State.CHALLENGE_SEPARATOR;
            iterateUntilNextNonSpace();
            return;
        }
        this.token = handleSchemeToken(i2, i, cIterateUntilNextNonSpace, true);
    }

    static /* synthetic */ boolean lambda$handleChallenge$6(Character ch) {
        return ch.charValue() == ' ' || ch.charValue() == '\t' || ch.charValue() == ',' || ch.charValue() == '=';
    }

    private static boolean isValidTokenCharacter(char c) {
        return c < 128 && VALID_TOKEN_CHARS[c];
    }

    private static boolean isValidToken(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isValidTokenCharacter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidToken68Character(char c) {
        return c < 128 && VALID_TOKEN68_CHARS[c];
    }

    private static String validateToken68(String str, int i, int i2) {
        int i3 = i;
        while (i3 < i2) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '=') {
                while (true) {
                    i3++;
                    if (i3 >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 != '=') {
                        throw LOGGER.atError().addKeyValue("challenge", str).addKeyValue("token68", str.substring(i, i2)).addKeyValue("character", cCharAt2).log((RuntimeException) new IllegalArgumentException("Token68 contained invalid character."));
                    }
                }
            } else if (!isValidToken68Character(cCharAt)) {
                throw LOGGER.atError().addKeyValue("challenge", str).addKeyValue("token68", str.substring(i, i2)).addKeyValue("character", cCharAt).log((RuntimeException) new IllegalArgumentException("Token68 contained invalid character."));
            }
            i3++;
        }
        return str.substring(i, i2);
    }

    private static class AuthenticateChallengeToken {
        final Map.Entry<String, String> authParam;
        final String scheme;
        final String token68;

        AuthenticateChallengeToken(String str, String str2, Map.Entry<String, String> entry) {
            this.scheme = str;
            this.token68 = str2;
            this.authParam = entry;
        }
    }
}
