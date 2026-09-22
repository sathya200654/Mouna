package com.azure.core.implementation.jackson;

import com.azure.core.implementation.SemanticVersion;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.fasterxml.jackson.core.json.PackageVersion;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JacksonVersion {
    private static final String AZURE_CORE_PROPERTIES_VERSION_KEY = "version";
    private static final String CORE_PACKAGE_NAME = "jackson-core";
    private static final String DATABIND_PACKAGE_NAME = "jackson-databind";
    private static final String HELP_STRING;
    private static final String JSR310_PACKAGE_NAME = "jackson-datatype-jsr310";
    private static final int MAX_SUPPORTED_MAJOR_VERSION = 2;
    private static final String TROUBLESHOOTING_DOCS_LINK = "https://aka.ms/azsdk/java/dependency/troubleshoot";
    private static final String XML_PACKAGE_NAME = "jackson-dataformat-xml";
    private static final SemanticVersion MIN_SUPPORTED_VERSION = SemanticVersion.parse("2.10.0");
    private static final String AZURE_CORE_PROPERTIES_NAME = "azure-core.properties";
    private static final String AZURE_CORE_VERSION = CoreUtils.getProperties(AZURE_CORE_PROPERTIES_NAME).getOrDefault("version", SemanticVersion.UNKNOWN_VERSION);
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) JacksonVersion.class);

    static {
        SemanticVersion semanticVersionCreateInvalid;
        SemanticVersion semanticVersion = SemanticVersion.parse(PackageVersion.VERSION.toString());
        SemanticVersion semanticVersion2 = SemanticVersion.parse(com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION.toString());
        SemanticVersion semanticVersion3 = SemanticVersion.parse(com.fasterxml.jackson.datatype.jsr310.PackageVersion.VERSION.toString());
        try {
            semanticVersionCreateInvalid = SemanticVersion.parse(Class.forName("com.fasterxml.jackson.dataformat.xml.PackageVersion").getDeclaredField("VERSION").get(null).toString());
        } catch (ReflectiveOperationException unused) {
            semanticVersionCreateInvalid = SemanticVersion.createInvalid();
        }
        checkVersion(semanticVersion, CORE_PACKAGE_NAME);
        checkVersion(semanticVersion2, DATABIND_PACKAGE_NAME);
        checkVersion(semanticVersionCreateInvalid, XML_PACKAGE_NAME);
        checkVersion(semanticVersion3, JSR310_PACKAGE_NAME);
        String str = "Package versions: jackson-core=" + semanticVersion.getVersionString() + ", jackson-databind=" + semanticVersion2.getVersionString() + ", jackson-dataformat-xml=" + semanticVersionCreateInvalid.getVersionString() + ", jackson-datatype-jsr310=" + semanticVersion3.getVersionString() + ", azure-core=" + AZURE_CORE_VERSION + ", Troubleshooting version conflicts: https://aka.ms/azsdk/java/dependency/troubleshoot";
        HELP_STRING = str;
        LOGGER.info(str);
    }

    private JacksonVersion() {
    }

    public static String getHelpInfo() {
        return HELP_STRING;
    }

    private static void checkVersion(final SemanticVersion semanticVersion, final String str) {
        if (!semanticVersion.isValid()) {
            LOGGER.log(LogLevel.VERBOSE, new Supplier() { // from class: com.azure.core.implementation.jackson.JacksonVersion$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return JacksonVersion.lambda$checkVersion$0(str);
                }
            });
            return;
        }
        if (semanticVersion.compareTo(MIN_SUPPORTED_VERSION) < 0) {
            LOGGER.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.implementation.jackson.JacksonVersion$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return JacksonVersion.lambda$checkVersion$1(semanticVersion, str);
                }
            });
        }
        if (semanticVersion.getMajorVersion() > 2) {
            LOGGER.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.implementation.jackson.JacksonVersion$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return JacksonVersion.lambda$checkVersion$2(semanticVersion, str);
                }
            });
        }
    }

    static /* synthetic */ String lambda$checkVersion$0(String str) {
        return "Could not find version of '" + str + "'.";
    }

    static /* synthetic */ String lambda$checkVersion$1(SemanticVersion semanticVersion, String str) {
        return "Version '" + semanticVersion + "' of package '" + str + "' is not supported (older than earliest supported version - '" + MIN_SUPPORTED_VERSION + "'). It may result in runtime exceptions during serialization. Please consider updating Jackson to one of the supported versions https://aka.ms/azsdk/java/dependency/troubleshoot";
    }

    static /* synthetic */ String lambda$checkVersion$2(SemanticVersion semanticVersion, String str) {
        return "Major version '" + semanticVersion + "' of package '" + str + "' is newer than latest supported version - '2'. It may result in runtime exceptions during serialization.";
    }
}
