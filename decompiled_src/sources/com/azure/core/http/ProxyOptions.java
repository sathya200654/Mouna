package com.azure.core.http;

import androidx.webkit.ProxyConfig;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.util.Configuration;
import com.azure.core.util.ConfigurationProperty;
import com.azure.core.util.ConfigurationPropertyBuilder;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ProxyOptions {
    private static final int DEFAULT_HTTPS_PORT = 443;
    private static final int DEFAULT_HTTP_PORT = 80;
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static final String INVALID_AZURE_PROXY_URL = "URL is invalid and is being ignored.";
    private static final String JAVA_NON_PROXY_HOSTS = "http.nonProxyHosts";
    private static final String JAVA_PROXY_HOST = "proxyHost";
    private static final String JAVA_PROXY_PASSWORD = "proxyPassword";
    private static final String JAVA_PROXY_PORT = "proxyPort";
    private static final String JAVA_PROXY_USER = "proxyUser";
    private static final String JAVA_SYSTEM_PROXY_PREREQUISITE = "java.net.useSystemProxies";
    private final InetSocketAddress address;
    private String nonProxyHosts;
    private String password;
    private final Type type;
    private String username;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ProxyOptions.class);
    private static final Pattern HTTP_NON_PROXY_HOSTS_SPLIT = Pattern.compile("(?<!\\\\)\\|");
    private static final Pattern NO_PROXY_SPLIT = Pattern.compile("(?<!\\\\),");
    private static final Pattern UNESCAPED_PERIOD = Pattern.compile("(?<!\\\\)\\.");
    private static final Pattern ANY = Pattern.compile("\\*");
    private static final ConfigurationProperty<String> NON_PROXY_PROPERTY = ConfigurationPropertyBuilder.ofString(ConfigurationProperties.HTTP_PROXY_NON_PROXY_HOSTS).shared(true).logValue(true).build();
    private static final ConfigurationProperty<String> HOST_PROPERTY = ConfigurationPropertyBuilder.ofString(ConfigurationProperties.HTTP_PROXY_HOST).shared(true).logValue(true).build();
    private static final ConfigurationProperty<Integer> PORT_PROPERTY = ConfigurationPropertyBuilder.ofInteger(ConfigurationProperties.HTTP_PROXY_PORT).shared(true).defaultValue(443).build();
    private static final ConfigurationProperty<String> USER_PROPERTY = ConfigurationPropertyBuilder.ofString(ConfigurationProperties.HTTP_PROXY_USER).shared(true).logValue(true).build();
    private static final ConfigurationProperty<String> PASSWORD_PROPERTY = ConfigurationPropertyBuilder.ofString(ConfigurationProperties.HTTP_PROXY_PASSWORD).shared(true).build();

    public ProxyOptions(Type type, InetSocketAddress inetSocketAddress) {
        this.type = type;
        this.address = inetSocketAddress;
    }

    public ProxyOptions setCredentials(String str, String str2) {
        this.username = (String) Objects.requireNonNull(str, "'username' cannot be null.");
        this.password = (String) Objects.requireNonNull(str2, "'password' cannot be null.");
        return this;
    }

    public ProxyOptions setNonProxyHosts(String str) {
        this.nonProxyHosts = sanitizeJavaHttpNonProxyHosts(str);
        return this;
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    public Type getType() {
        return this.type;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNonProxyHosts() {
        return this.nonProxyHosts;
    }

    public static ProxyOptions fromConfiguration(Configuration configuration) {
        return fromConfiguration(configuration, false);
    }

    public static ProxyOptions fromConfiguration(Configuration configuration, boolean z) {
        if (configuration == null) {
            configuration = Configuration.getGlobalConfiguration();
        }
        return attemptToLoadProxy(configuration, z);
    }

    private static ProxyOptions attemptToLoadProxy(Configuration configuration, boolean z) {
        if (configuration == Configuration.NONE) {
            return null;
        }
        if (Boolean.parseBoolean(configuration.get(JAVA_SYSTEM_PROXY_PREREQUISITE))) {
            ProxyOptions proxyOptionsAttemptToLoadSystemProxy = attemptToLoadSystemProxy(configuration, z, Configuration.PROPERTY_HTTPS_PROXY);
            if (proxyOptionsAttemptToLoadSystemProxy != null) {
                LOGGER.verbose("Using proxy created from HTTPS_PROXY environment variable.");
                return proxyOptionsAttemptToLoadSystemProxy;
            }
            ProxyOptions proxyOptionsAttemptToLoadSystemProxy2 = attemptToLoadSystemProxy(configuration, z, Configuration.PROPERTY_HTTP_PROXY);
            if (proxyOptionsAttemptToLoadSystemProxy2 != null) {
                LOGGER.verbose("Using proxy created from HTTP_PROXY environment variable.");
                return proxyOptionsAttemptToLoadSystemProxy2;
            }
        }
        ProxyOptions proxyOptionsAttemptToLoadAzureSdkProxy = attemptToLoadAzureSdkProxy(configuration, z);
        if (proxyOptionsAttemptToLoadAzureSdkProxy != null) {
            return proxyOptionsAttemptToLoadAzureSdkProxy;
        }
        ProxyOptions proxyOptionsAttemptToLoadJavaProxy = attemptToLoadJavaProxy(configuration, z, "https");
        if (proxyOptionsAttemptToLoadJavaProxy != null) {
            LOGGER.verbose("Using proxy created from JVM HTTPS system properties.");
            return proxyOptionsAttemptToLoadJavaProxy;
        }
        ProxyOptions proxyOptionsAttemptToLoadJavaProxy2 = attemptToLoadJavaProxy(configuration, z, "http");
        if (proxyOptionsAttemptToLoadJavaProxy2 == null) {
            return null;
        }
        LOGGER.verbose("Using proxy created from JVM HTTP system properties.");
        return proxyOptionsAttemptToLoadJavaProxy2;
    }

    private static ProxyOptions attemptToLoadSystemProxy(Configuration configuration, boolean z, String str) {
        InetSocketAddress inetSocketAddress;
        String str2 = configuration.get(str);
        if (CoreUtils.isNullOrEmpty(str2)) {
            return null;
        }
        try {
            URL urlCreateUrl = ImplUtils.createUrl(str2);
            int defaultPort = urlCreateUrl.getPort() == -1 ? urlCreateUrl.getDefaultPort() : urlCreateUrl.getPort();
            if (z) {
                inetSocketAddress = InetSocketAddress.createUnresolved(urlCreateUrl.getHost(), defaultPort);
            } else {
                inetSocketAddress = new InetSocketAddress(urlCreateUrl.getHost(), defaultPort);
            }
            ProxyOptions proxyOptions = new ProxyOptions(Type.HTTP, inetSocketAddress);
            String str3 = configuration.get(Configuration.PROPERTY_NO_PROXY);
            if (!CoreUtils.isNullOrEmpty(str3)) {
                proxyOptions.nonProxyHosts = sanitizeNoProxy(str3);
                LOGGER.atVerbose().addKeyValue("regex", proxyOptions.nonProxyHosts).log("Using non-proxy hosts");
            }
            String userInfo = urlCreateUrl.getUserInfo();
            if (userInfo != null) {
                String[] strArrSplit = userInfo.split(":", 2);
                if (strArrSplit.length == 2) {
                    try {
                        proxyOptions.setCredentials(URLDecoder.decode(strArrSplit[0], StandardCharsets.UTF_8.toString()), URLDecoder.decode(strArrSplit[1], StandardCharsets.UTF_8.toString()));
                        return proxyOptions;
                    } catch (UnsupportedEncodingException unused) {
                        return null;
                    }
                }
            }
            return proxyOptions;
        } catch (MalformedURLException unused2) {
            LOGGER.atWarning().addKeyValue(LoggingKeys.URL_KEY, str).log(INVALID_AZURE_PROXY_URL);
            return null;
        }
    }

    static String sanitizeNoProxy(String str) {
        return sanitizeNonProxyHosts(NO_PROXY_SPLIT.split(str));
    }

    private static ProxyOptions attemptToLoadJavaProxy(Configuration configuration, boolean z, String str) {
        int i;
        String str2 = configuration.get(str + ".proxyHost");
        if (CoreUtils.isNullOrEmpty(str2)) {
            return null;
        }
        try {
            i = Integer.parseInt(configuration.get(str + ".proxyPort"));
        } catch (NumberFormatException unused) {
            i = "https".equals(str) ? 443 : 80;
        }
        return createOptions(str2, i, configuration.get(JAVA_NON_PROXY_HOSTS), configuration.get(str + ".proxyUser"), configuration.get(str + ".proxyPassword"), z);
    }

    private static ProxyOptions attemptToLoadAzureSdkProxy(Configuration configuration, boolean z) {
        String str = (String) configuration.get(HOST_PROPERTY);
        if (CoreUtils.isNullOrEmpty(str)) {
            return null;
        }
        return createOptions(str, ((Integer) configuration.get(PORT_PROPERTY)).intValue(), (String) configuration.get(NON_PROXY_PROPERTY), (String) configuration.get(USER_PROPERTY), (String) configuration.get(PASSWORD_PROPERTY), z);
    }

    private static ProxyOptions createOptions(String str, int i, String str2, String str3, String str4, boolean z) {
        ProxyOptions proxyOptions = new ProxyOptions(Type.HTTP, z ? InetSocketAddress.createUnresolved(str, i) : new InetSocketAddress(str, i));
        if (!CoreUtils.isNullOrEmpty(str2)) {
            proxyOptions.nonProxyHosts = sanitizeJavaHttpNonProxyHosts(str2);
            LOGGER.atVerbose().addKeyValue("regex", proxyOptions.nonProxyHosts).log("Using non-proxy host regex");
        }
        if (str3 != null && str4 != null) {
            proxyOptions.setCredentials(str3, str4);
        }
        return proxyOptions;
    }

    static String sanitizeJavaHttpNonProxyHosts(String str) {
        return sanitizeNonProxyHosts(HTTP_NON_PROXY_HOSTS_SPLIT.split(str));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0079  */
    /* JADX WARN: Code duplicated, block: B:39:0x009f  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00af  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c0  */
    private static String sanitizeNonProxyHosts(String[] strArr) {
        String str;
        String strQuote;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append("|");
            }
            String strSubstring = strArr[i];
            String str2 = "";
            try {
                if (strSubstring.startsWith(".")) {
                    strSubstring = strSubstring.substring(1);
                } else if (strSubstring.startsWith(".?") || strSubstring.startsWith("*?")) {
                    strSubstring = strSubstring.substring(2);
                } else if (strSubstring.startsWith(ProxyConfig.MATCH_ALL_SCHEMES)) {
                    strSubstring = strSubstring.substring(1);
                } else if (strSubstring.startsWith(".*?")) {
                    strSubstring = strSubstring.substring(3);
                } else {
                    if (strSubstring.startsWith(".*")) {
                        strSubstring = strSubstring.substring(2);
                    } else {
                        str = "";
                    }
                    if (strSubstring.endsWith(".")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                    } else if (!strSubstring.endsWith(".?") || strSubstring.endsWith("*?")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 3);
                    } else if (strSubstring.endsWith(ProxyConfig.MATCH_ALL_SCHEMES)) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                    } else if (strSubstring.endsWith(".*?")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 4);
                    } else {
                        if (strSubstring.endsWith(".*")) {
                            strSubstring = strSubstring.substring(0, strSubstring.length() - 3);
                        }
                        strQuote = Pattern.compile(ANY.matcher(UNESCAPED_PERIOD.matcher(strSubstring).replaceAll("\\\\.")).replaceAll("\\.*?")).pattern();
                        sb.append("(").append(str).append(strQuote).append(str2).append(")");
                    }
                    str2 = ".*?";
                    strQuote = Pattern.compile(ANY.matcher(UNESCAPED_PERIOD.matcher(strSubstring).replaceAll("\\\\.")).replaceAll("\\.*?")).pattern();
                    sb.append("(").append(str).append(strQuote).append(str2).append(")");
                }
                if (strSubstring.endsWith(".")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                } else if (!strSubstring.endsWith(".?")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 3);
                } else if (strSubstring.endsWith(ProxyConfig.MATCH_ALL_SCHEMES)) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                } else if (strSubstring.endsWith(".*?")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 4);
                } else {
                    if (strSubstring.endsWith(".*")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 3);
                    }
                    strQuote = Pattern.compile(ANY.matcher(UNESCAPED_PERIOD.matcher(strSubstring).replaceAll("\\\\.")).replaceAll("\\.*?")).pattern();
                    sb.append("(").append(str).append(strQuote).append(str2).append(")");
                }
                strQuote = Pattern.compile(ANY.matcher(UNESCAPED_PERIOD.matcher(strSubstring).replaceAll("\\\\.")).replaceAll("\\.*?")).pattern();
            } catch (PatternSyntaxException unused) {
                strQuote = Pattern.quote(strSubstring);
            }
            str = ".*?";
            str2 = ".*?";
            sb.append("(").append(str).append(strQuote).append(str2).append(")");
        }
        return sb.toString();
    }

    public enum Type {
        HTTP(Proxy.Type.HTTP),
        SOCKS4(Proxy.Type.SOCKS),
        SOCKS5(Proxy.Type.SOCKS);

        private final Proxy.Type proxyType;

        Type(Proxy.Type type) {
            this.proxyType = type;
        }

        public Proxy.Type toProxyType() {
            return this.proxyType;
        }
    }

    private static class ConfigurationProperties {
        public static final String HTTP_PROXY_HOST = "http.proxy.hostname";
        public static final String HTTP_PROXY_NON_PROXY_HOSTS = "http.proxy.non-proxy-hosts";
        public static final String HTTP_PROXY_PASSWORD = "http.proxy.password";
        public static final String HTTP_PROXY_PORT = "http.proxy.port";
        public static final String HTTP_PROXY_USER = "http.proxy.username";

        private ConfigurationProperties() {
        }
    }
}
