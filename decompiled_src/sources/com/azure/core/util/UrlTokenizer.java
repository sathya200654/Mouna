package com.azure.core.util;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class UrlTokenizer {
    private int currentIndex;
    private UrlToken currentToken;
    private UrlTokenizerState state;
    private final String text;
    private final int textLength;

    UrlTokenizer(String str) {
        this(str, UrlTokenizerState.SCHEME_OR_HOST);
    }

    UrlTokenizer(String str, UrlTokenizerState urlTokenizerState) {
        this.text = str;
        this.textLength = str == null ? 0 : str.length();
        this.state = urlTokenizerState;
        this.currentIndex = 0;
        this.currentToken = null;
    }

    private boolean hasCurrentCharacter() {
        return this.currentIndex < this.textLength;
    }

    private char currentCharacter() {
        return this.text.charAt(this.currentIndex);
    }

    private void nextCharacter() {
        if (hasCurrentCharacter()) {
            this.currentIndex++;
        }
    }

    private boolean peekMatchesSchemeSeparator(boolean z) {
        if (!"://".regionMatches(0, this.text, this.currentIndex, 3)) {
            return false;
        }
        if (!z) {
            return true;
        }
        this.currentIndex += 3;
        return true;
    }

    UrlToken current() {
        return this.currentToken;
    }

    boolean next() {
        String strSubstring;
        if (!hasCurrentCharacter()) {
            this.currentToken = null;
        } else {
            switch (AnonymousClass1.$SwitchMap$com$azure$core$util$UrlTokenizerState[this.state.ordinal()]) {
                case 1:
                    this.currentToken = UrlToken.scheme(readUntilNotLetterOrDigit());
                    if (!hasCurrentCharacter()) {
                        this.state = UrlTokenizerState.DONE;
                    } else {
                        this.state = UrlTokenizerState.HOST;
                    }
                    break;
                case 2:
                    String until = readUntil(true);
                    if (!hasCurrentCharacter()) {
                        this.currentToken = UrlToken.host(until);
                        this.state = UrlTokenizerState.DONE;
                    } else {
                        char cCurrentCharacter = currentCharacter();
                        if (cCurrentCharacter != ':') {
                            if (cCurrentCharacter == '/') {
                                this.currentToken = UrlToken.host(until);
                                this.state = UrlTokenizerState.PATH;
                            } else if (cCurrentCharacter == '?') {
                                this.currentToken = UrlToken.host(until);
                                this.state = UrlTokenizerState.QUERY;
                            }
                        } else if (peekMatchesSchemeSeparator(false)) {
                            this.currentToken = UrlToken.scheme(until);
                            this.state = UrlTokenizerState.HOST;
                        } else {
                            this.currentToken = UrlToken.host(until);
                            this.state = UrlTokenizerState.PORT;
                        }
                    }
                    break;
                case 3:
                    peekMatchesSchemeSeparator(true);
                    this.currentToken = UrlToken.host(readUntil(true));
                    if (!hasCurrentCharacter()) {
                        this.state = UrlTokenizerState.DONE;
                    } else {
                        char cCurrentCharacter2 = currentCharacter();
                        if (cCurrentCharacter2 == ':') {
                            this.state = UrlTokenizerState.PORT;
                        } else if (cCurrentCharacter2 == '/') {
                            this.state = UrlTokenizerState.PATH;
                        } else {
                            this.state = UrlTokenizerState.QUERY;
                        }
                    }
                    break;
                case 4:
                    if (currentCharacter() == ':') {
                        nextCharacter();
                    }
                    this.currentToken = UrlToken.port(readUntil(false));
                    if (!hasCurrentCharacter()) {
                        this.state = UrlTokenizerState.DONE;
                    } else if (currentCharacter() == '/') {
                        this.state = UrlTokenizerState.PATH;
                    } else {
                        this.state = UrlTokenizerState.QUERY;
                    }
                    break;
                case 5:
                    int iIndexOf = this.text.indexOf(63, this.currentIndex);
                    if (iIndexOf == -1) {
                        strSubstring = this.text.substring(this.currentIndex);
                        this.currentIndex = this.textLength;
                    } else {
                        String strSubstring2 = this.text.substring(this.currentIndex, iIndexOf);
                        this.currentIndex = iIndexOf;
                        strSubstring = strSubstring2;
                    }
                    this.currentToken = UrlToken.path(strSubstring);
                    if (!hasCurrentCharacter()) {
                        this.state = UrlTokenizerState.DONE;
                    } else {
                        this.state = UrlTokenizerState.QUERY;
                    }
                    break;
                case 6:
                    if (currentCharacter() == '?') {
                        nextCharacter();
                    }
                    this.currentToken = UrlToken.query(readRemaining());
                    this.state = UrlTokenizerState.DONE;
                    break;
            }
        }
        return this.currentToken != null;
    }

    /* JADX INFO: renamed from: com.azure.core.util.UrlTokenizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$azure$core$util$UrlTokenizerState;

        static {
            int[] iArr = new int[UrlTokenizerState.values().length];
            $SwitchMap$com$azure$core$util$UrlTokenizerState = iArr;
            try {
                iArr[UrlTokenizerState.SCHEME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenizerState[UrlTokenizerState.SCHEME_OR_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenizerState[UrlTokenizerState.HOST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenizerState[UrlTokenizerState.PORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenizerState[UrlTokenizerState.PATH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$azure$core$util$UrlTokenizerState[UrlTokenizerState.QUERY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private String readUntilNotLetterOrDigit() {
        if (!hasCurrentCharacter()) {
            return "";
        }
        int i = this.currentIndex;
        while (hasCurrentCharacter()) {
            if (!Character.isLetterOrDigit(currentCharacter())) {
                return this.text.substring(i, this.currentIndex);
            }
            nextCharacter();
        }
        return this.text.substring(i);
    }

    private String readUntil(boolean z) {
        if (!hasCurrentCharacter()) {
            return "";
        }
        int i = this.currentIndex;
        while (hasCurrentCharacter()) {
            char cCurrentCharacter = currentCharacter();
            if ((z && cCurrentCharacter == ':') || cCurrentCharacter == '/' || cCurrentCharacter == '?') {
                return this.text.substring(i, this.currentIndex);
            }
            nextCharacter();
        }
        return this.text.substring(i);
    }

    private String readRemaining() {
        int i = this.currentIndex;
        int i2 = this.textLength;
        if (i < i2) {
            String strSubstring = this.text.substring(i, i2);
            this.currentIndex = this.textLength;
            return strSubstring;
        }
        return "";
    }
}
