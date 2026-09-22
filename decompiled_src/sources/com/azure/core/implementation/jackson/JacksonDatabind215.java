package com.azure.core.implementation.jackson;

import com.azure.core.implementation.ReflectionUtils;
import com.azure.core.implementation.ReflectiveInvoker;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.tracing.Tracer;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class JacksonDatabind215 {
    private static final ReflectiveInvoker BUILD_STREAM_READ_CONSTRAINTS;
    private static final ReflectiveInvoker CREATE_STREAM_READ_CONSTRAINTS_BUILDER;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) JacksonDatabind215.class);
    private static final ReflectiveInvoker SET_MAX_STRING_LENGTH;
    private static final ReflectiveInvoker SET_STREAM_READ_CONSTRAINTS;
    private static final String STREAM_READ_CONSTRAINTS = "com.fasterxml.jackson.core.StreamReadConstraints";
    private static final String STREAM_READ_CONSTRAINTS_BUILDER = "com.fasterxml.jackson.core.StreamReadConstraints$Builder";
    private static final boolean USE_JACKSON_215;

    static {
        ReflectiveInvoker methodInvoker;
        ReflectiveInvoker methodInvoker2;
        ReflectiveInvoker methodInvoker3;
        ClassLoader classLoader = JacksonDatabind215.class.getClassLoader();
        ReflectiveInvoker methodInvoker4 = null;
        boolean z = false;
        try {
            Class<?> cls = Class.forName(STREAM_READ_CONSTRAINTS, true, classLoader);
            Class<?> cls2 = Class.forName(STREAM_READ_CONSTRAINTS_BUILDER, true, classLoader);
            methodInvoker2 = ReflectionUtils.getMethodInvoker(cls, cls.getDeclaredMethod(Tracer.SPAN_BUILDER_KEY, new Class[0]), false);
            try {
                methodInvoker3 = ReflectionUtils.getMethodInvoker(cls2, cls2.getDeclaredMethod("maxStringLength", Integer.TYPE), false);
                try {
                    methodInvoker = ReflectionUtils.getMethodInvoker(cls2, cls2.getDeclaredMethod("build", new Class[0]), false);
                    try {
                        methodInvoker4 = ReflectionUtils.getMethodInvoker(JsonFactory.class, JsonFactory.class.getDeclaredMethod("setStreamReadConstraints", cls), false);
                        z = true;
                    } catch (Throwable th) {
                        th = th;
                        if (th instanceof LinkageError) {
                            LOGGER.info("Attempted to create invoker for Jackson 2.15 features but failed. It's possible that your application will run without error even with this failure. The Azure SDKs only set updated StreamReadConstraints to allow for larger payloads to be handled.");
                        } else {
                            if (th instanceof Error) {
                                throw th;
                            }
                            throw LOGGER.logExceptionAsError(new IllegalStateException(th));
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    methodInvoker = null;
                }
            } catch (Throwable th3) {
                th = th3;
                methodInvoker = null;
                methodInvoker3 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            methodInvoker = null;
            methodInvoker2 = null;
            methodInvoker3 = null;
        }
        CREATE_STREAM_READ_CONSTRAINTS_BUILDER = methodInvoker2;
        SET_MAX_STRING_LENGTH = methodInvoker3;
        BUILD_STREAM_READ_CONSTRAINTS = methodInvoker;
        SET_STREAM_READ_CONSTRAINTS = methodInvoker4;
        USE_JACKSON_215 = z;
    }

    static ObjectMapper mutateStreamReadConstraints(ObjectMapper objectMapper) {
        if (!USE_JACKSON_215) {
            return objectMapper;
        }
        try {
            Object objInvokeStatic = CREATE_STREAM_READ_CONSTRAINTS_BUILDER.invokeStatic(new Object[0]);
            SET_MAX_STRING_LENGTH.invokeWithArguments(objInvokeStatic, 52428800);
            SET_STREAM_READ_CONSTRAINTS.invokeWithArguments(objectMapper.tokenStreamFactory(), BUILD_STREAM_READ_CONSTRAINTS.invokeWithArguments(objInvokeStatic, new Object[0]));
            return objectMapper;
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw LOGGER.logExceptionAsError((RuntimeException) e);
            }
            throw LOGGER.logExceptionAsError(new IllegalStateException(e));
        }
    }

    private JacksonDatabind215() {
    }
}
