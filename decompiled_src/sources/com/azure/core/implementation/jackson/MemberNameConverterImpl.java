package com.azure.core.implementation.jackson;

import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.serializer.MemberNameConverter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedClassResolver;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.util.BeanUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class MemberNameConverterImpl implements MemberNameConverter {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) MemberNameConverterImpl.class);
    private boolean jackson212IsSafe = true;
    private final ObjectMapper mapper;
    final boolean useJackson212;

    MemberNameConverterImpl(ObjectMapper objectMapper) {
        this.mapper = objectMapper;
        this.useJackson212 = PackageVersion.VERSION.getMinorVersion() >= 12;
    }

    @Override // com.azure.core.util.serializer.MemberNameConverter
    public String convertMemberName(Member member) {
        if (Modifier.isTransient(member.getModifiers())) {
            return null;
        }
        VisibilityChecker visibilityChecker = this.mapper.getVisibilityChecker();
        if (member instanceof Field) {
            Field field = (Field) member;
            if (field.isAnnotationPresent(JsonIgnore.class) || !visibilityChecker.isFieldVisible(field)) {
                if (field.isAnnotationPresent(JsonProperty.class)) {
                    LOGGER.atInfo().addKeyValue("field", field.getName()).log("Field is annotated with JsonProperty but isn't accessible to JacksonJsonSerializer.");
                }
                return null;
            }
            if (field.isAnnotationPresent(JsonProperty.class)) {
                String strValue = field.getDeclaredAnnotation(JsonProperty.class).value();
                return CoreUtils.isNullOrEmpty(strValue) ? field.getName() : strValue;
            }
            return field.getName();
        }
        if (member instanceof Method) {
            Method method = (Method) member;
            if (!verifyGetter(method) || method.isAnnotationPresent(JsonIgnore.class) || !visibilityChecker.isGetterVisible(method)) {
                if (method.isAnnotationPresent(JsonGetter.class) || method.isAnnotationPresent(JsonProperty.class)) {
                    LOGGER.atInfo().addKeyValue(LoggingKeys.HTTP_METHOD_KEY, method.getName()).log("Method is annotated with either JsonGetter or JsonProperty but isn't accessible to JacksonJsonSerializer.");
                }
            } else {
                String strRemovePrefix = removePrefix(method);
                if (method.isAnnotationPresent(JsonGetter.class)) {
                    String strValue2 = method.getDeclaredAnnotation(JsonGetter.class).value();
                    if (!CoreUtils.isNullOrEmpty(strValue2)) {
                        return strValue2;
                    }
                } else if (method.isAnnotationPresent(JsonProperty.class)) {
                    String strValue3 = method.getDeclaredAnnotation(JsonProperty.class).value();
                    if (!CoreUtils.isNullOrEmpty(strValue3)) {
                        return strValue3;
                    }
                }
                return strRemovePrefix;
            }
        }
        return null;
    }

    private static boolean verifyGetter(Method method) {
        Class<?> returnType = method.getReturnType();
        return (method.getParameterCount() != 0 || returnType == Void.TYPE || returnType == Void.class) ? false : true;
    }

    private String removePrefix(Method method) {
        SerializationConfig serializationConfig = this.mapper.getSerializationConfig();
        String strRemovePrefix = null;
        AnnotatedClass annotatedClassResolve = AnnotatedClassResolver.resolve(serializationConfig, this.mapper.constructType(method.getDeclaringClass()), (ClassIntrospector.MixInResolver) null);
        AnnotatedMethod annotatedMethodFindMethod = annotatedClassResolve.findMethod(method.getName(), method.getParameterTypes());
        String name = annotatedMethodFindMethod.getName();
        if (this.useJackson212 && this.jackson212IsSafe) {
            try {
                strRemovePrefix = JacksonDatabind212.removePrefix(serializationConfig, annotatedClassResolve, annotatedMethodFindMethod, name);
            } catch (Throwable th) {
                if (th instanceof LinkageError) {
                    this.jackson212IsSafe = false;
                    LOGGER.log(LogLevel.VERBOSE, new MemberNameConverterImpl$$ExternalSyntheticLambda0(), th);
                }
                throw th;
            }
        }
        return strRemovePrefix == null ? removePrefixWithBeanUtils(annotatedMethodFindMethod) : strRemovePrefix;
    }

    private static String removePrefixWithBeanUtils(AnnotatedMethod annotatedMethod) {
        return BeanUtil.okNameForGetter(annotatedMethod, false);
    }
}
