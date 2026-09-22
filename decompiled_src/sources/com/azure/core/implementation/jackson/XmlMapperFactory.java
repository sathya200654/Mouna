package com.azure.core.implementation.jackson;

import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.tracing.Tracer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.databind.cfg.PackageVersion;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class XmlMapperFactory {
    private static final String FROM_XML_PARSER = "com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser$Feature";
    private static final String TO_XML_GENERATOR = "com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator$Feature";
    private static final String XML_MAPPER = "com.fasterxml.jackson.dataformat.xml.XmlMapper";
    private static final String XML_MAPPER_BUILDER = "com.fasterxml.jackson.dataformat.xml.XmlMapper$Builder";
    private final ReflectiveInvoker configureEmptyElementAsNull;
    private final ReflectiveInvoker configureWriteXmlDeclaration;
    private final ReflectiveInvoker createXmlMapperBuilder;
    private final ReflectiveInvoker defaultUseWrapper;
    private final Object emptyElementAsNull;
    private boolean jackson212IsSafe = true;
    final boolean useJackson212;
    private final Object writeXmlDeclaration;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) XmlMapperFactory.class);
    public static final XmlMapperFactory INSTANCE = new XmlMapperFactory();

    private XmlMapperFactory() {
        ClassLoader classLoader = XmlMapperFactory.class.getClassLoader();
        try {
            Class<?> cls = Class.forName(XML_MAPPER, true, classLoader);
            Class<?> cls2 = Class.forName(XML_MAPPER_BUILDER, true, classLoader);
            Class<?> cls3 = Class.forName(FROM_XML_PARSER, true, classLoader);
            Class<?> cls4 = Class.forName(TO_XML_GENERATOR, true, classLoader);
            ReflectiveInvoker methodInvoker = ReflectionUtils.getMethodInvoker(cls, cls.getDeclaredMethod(Tracer.SPAN_BUILDER_KEY, new Class[0]), false);
            ReflectiveInvoker methodInvoker2 = ReflectionUtils.getMethodInvoker(cls2, cls2.getDeclaredMethod("defaultUseWrapper", Boolean.TYPE), false);
            ReflectiveInvoker methodInvoker3 = ReflectionUtils.getMethodInvoker(cls2, cls2.getDeclaredMethod("configure", cls4, Boolean.TYPE), false);
            Object obj = cls4.getDeclaredField("WRITE_XML_DECLARATION").get(null);
            ReflectiveInvoker methodInvoker4 = ReflectionUtils.getMethodInvoker(cls2, cls2.getDeclaredMethod("configure", cls3, Boolean.TYPE), false);
            Object obj2 = cls3.getDeclaredField("EMPTY_ELEMENT_AS_NULL").get(null);
            this.createXmlMapperBuilder = methodInvoker;
            this.defaultUseWrapper = methodInvoker2;
            this.configureWriteXmlDeclaration = methodInvoker3;
            this.writeXmlDeclaration = obj;
            this.configureEmptyElementAsNull = methodInvoker4;
            this.emptyElementAsNull = obj2;
            this.useJackson212 = PackageVersion.VERSION.getMinorVersion() >= 12;
        } catch (Throwable th) {
            if ((th instanceof Error) && !(th instanceof LinkageError)) {
                throw ((Error) LOGGER.logThrowableAsError(th));
            }
            throw LOGGER.logExceptionAsError(new IllegalStateException("Failed to retrieve invoker used to create XmlMapper. XML serialization won't be supported until 'com.fasterxml.jackson.dataformat:jackson-dataformat-xml' is added to the classpath or updated to a supported version. " + JacksonVersion.getHelpInfo(), th));
        }
    }

    public ObjectMapper createXmlMapper() {
        try {
            MapperBuilder mapperBuilderInitializeMapperBuilder = ObjectMapperFactory.initializeMapperBuilder((MapperBuilder) this.createXmlMapperBuilder.invokeStatic(new Object[0]));
            this.defaultUseWrapper.invokeWithArguments(mapperBuilderInitializeMapperBuilder, false);
            this.configureWriteXmlDeclaration.invokeWithArguments(mapperBuilderInitializeMapperBuilder, this.writeXmlDeclaration, true);
            this.configureEmptyElementAsNull.invokeWithArguments(mapperBuilderInitializeMapperBuilder, this.emptyElementAsNull, true);
            ObjectMapper objectMapperBuild = mapperBuilderInitializeMapperBuilder.build();
            if (!this.useJackson212 || !this.jackson212IsSafe) {
                return objectMapperBuild;
            }
            try {
                return JacksonDatabind212.mutateXmlCoercions(objectMapperBuild);
            } catch (Throwable th) {
                if (th instanceof LinkageError) {
                    this.jackson212IsSafe = false;
                    LOGGER.log(LogLevel.VERBOSE, new MemberNameConverterImpl$$ExternalSyntheticLambda0(), th);
                }
                throw th;
            }
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw LOGGER.logExceptionAsError((RuntimeException) e);
            }
            throw LOGGER.logExceptionAsError(new IllegalStateException("Unable to create XmlMapper instance.", e));
        }
    }
}
