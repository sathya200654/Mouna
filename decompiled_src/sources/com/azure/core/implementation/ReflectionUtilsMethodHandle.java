package com.azure.core.implementation;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class ReflectionUtilsMethodHandle implements ReflectionUtilsApi {
    private static final MethodHandle CLASS_GET_MODULE_METHOD_HANDLE;
    private static final Object CORE_MODULE;
    private static final MethodHandle JDK_INTERNAL_PRIVATE_LOOKUP_IN_CONSTRUCTOR;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ReflectionUtilsMethodHandle.class);
    private static final MethodHandles.Lookup LOOKUP;
    private static final MethodHandle METHOD_HANDLES_PRIVATE_LOOKUP_IN_METHOD_HANDLE;
    private static final MethodHandle MODULE_ADD_READS_METHOD_HANDLE;
    private static final boolean MODULE_BASED;
    private static final MethodHandle MODULE_IS_NAMED_METHOD_HANDLE;
    private static final MethodHandle MODULE_IS_OPEN_TO_OTHER_MODULE_METHOD_HANDLE;
    private static final MethodHandle MODULE_IS_OPEN_UNCONDITIONALLY_METHOD_HANDLE;

    ReflectionUtilsMethodHandle() {
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c3 A[Catch: ReflectiveOperationException -> 0x00cb, TryCatch #5 {ReflectiveOperationException -> 0x00cb, blocks: (B:33:0x00b1, B:35:0x00c3, B:36:0x00c6), top: B:55:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        MethodHandle methodHandleUnreflect;
        MethodHandle methodHandleUnreflect2;
        MethodHandle methodHandleUnreflect3;
        MethodHandle methodHandleUnreflect4;
        MethodHandle methodHandleFindStatic;
        MethodHandle methodHandleUnreflect5;
        boolean z;
        Object objInvokeWithArguments;
        Constructor<?> declaredConstructor;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandleUnreflectConstructor = null;
        try {
            Class<?> cls = Class.forName("java.lang.Module");
            methodHandleUnreflect2 = lookup.unreflect(Class.class.getDeclaredMethod("getModule", new Class[0]));
            try {
                methodHandleUnreflect3 = lookup.unreflect(cls.getDeclaredMethod("isNamed", new Class[0]));
                try {
                    methodHandleUnreflect4 = lookup.unreflect(cls.getDeclaredMethod("addReads", cls));
                    try {
                        methodHandleFindStatic = lookup.findStatic(MethodHandles.class, "privateLookupIn", MethodType.methodType(MethodHandles.Lookup.class, Class.class, MethodHandles.Lookup.class));
                        try {
                            methodHandleUnreflect5 = lookup.unreflect(cls.getDeclaredMethod("isOpen", String.class));
                            try {
                                methodHandleUnreflect = lookup.unreflect(cls.getDeclaredMethod("isOpen", String.class, cls));
                                try {
                                    objInvokeWithArguments = methodHandleUnreflect2.invokeWithArguments(ReflectionUtils.class);
                                    z = true;
                                } catch (Throwable th) {
                                    th = th;
                                    if (!(th instanceof Error)) {
                                        throw th;
                                    }
                                    LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.implementation.ReflectionUtilsMethodHandle$$ExternalSyntheticLambda0
                                        @Override // java.util.function.Supplier
                                        public final Object get() {
                                            return ReflectionUtilsMethodHandle.lambda$static$0();
                                        }
                                    }, th);
                                    z = false;
                                    objInvokeWithArguments = null;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                methodHandleUnreflect = null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            methodHandleUnreflect = null;
                            methodHandleUnreflect5 = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        methodHandleUnreflect = null;
                        methodHandleFindStatic = null;
                        methodHandleUnreflect5 = methodHandleFindStatic;
                        if (!(th instanceof Error)) {
                            throw th;
                        }
                        LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.implementation.ReflectionUtilsMethodHandle$$ExternalSyntheticLambda0
                            @Override // java.util.function.Supplier
                            public final Object get() {
                                return ReflectionUtilsMethodHandle.lambda$static$0();
                            }
                        }, th);
                        z = false;
                        objInvokeWithArguments = null;
                        if (!z) {
                            try {
                                declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class);
                                if (!declaredConstructor.isAccessible()) {
                                    declaredConstructor.setAccessible(true);
                                }
                                methodHandleUnreflectConstructor = lookup.unreflectConstructor(declaredConstructor);
                            } catch (ReflectiveOperationException e) {
                                throw LOGGER.logExceptionAsError(new RuntimeException("Unable to use package-private MethodHandles.Lookup constructor.", e));
                            }
                        }
                        MODULE_BASED = z;
                        CLASS_GET_MODULE_METHOD_HANDLE = methodHandleUnreflect2;
                        MODULE_IS_NAMED_METHOD_HANDLE = methodHandleUnreflect3;
                        MODULE_ADD_READS_METHOD_HANDLE = methodHandleUnreflect4;
                        METHOD_HANDLES_PRIVATE_LOOKUP_IN_METHOD_HANDLE = methodHandleFindStatic;
                        MODULE_IS_OPEN_UNCONDITIONALLY_METHOD_HANDLE = methodHandleUnreflect5;
                        MODULE_IS_OPEN_TO_OTHER_MODULE_METHOD_HANDLE = methodHandleUnreflect;
                        LOOKUP = lookup;
                        CORE_MODULE = objInvokeWithArguments;
                        JDK_INTERNAL_PRIVATE_LOOKUP_IN_CONSTRUCTOR = methodHandleUnreflectConstructor;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    methodHandleUnreflect = null;
                    methodHandleUnreflect4 = null;
                    methodHandleFindStatic = methodHandleUnreflect4;
                    methodHandleUnreflect5 = methodHandleFindStatic;
                    if (!(th instanceof Error)) {
                        throw th;
                    }
                    LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.implementation.ReflectionUtilsMethodHandle$$ExternalSyntheticLambda0
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return ReflectionUtilsMethodHandle.lambda$static$0();
                        }
                    }, th);
                    z = false;
                    objInvokeWithArguments = null;
                    if (!z) {
                        declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class);
                        if (!declaredConstructor.isAccessible()) {
                            declaredConstructor.setAccessible(true);
                        }
                        methodHandleUnreflectConstructor = lookup.unreflectConstructor(declaredConstructor);
                    }
                    MODULE_BASED = z;
                    CLASS_GET_MODULE_METHOD_HANDLE = methodHandleUnreflect2;
                    MODULE_IS_NAMED_METHOD_HANDLE = methodHandleUnreflect3;
                    MODULE_ADD_READS_METHOD_HANDLE = methodHandleUnreflect4;
                    METHOD_HANDLES_PRIVATE_LOOKUP_IN_METHOD_HANDLE = methodHandleFindStatic;
                    MODULE_IS_OPEN_UNCONDITIONALLY_METHOD_HANDLE = methodHandleUnreflect5;
                    MODULE_IS_OPEN_TO_OTHER_MODULE_METHOD_HANDLE = methodHandleUnreflect;
                    LOOKUP = lookup;
                    CORE_MODULE = objInvokeWithArguments;
                    JDK_INTERNAL_PRIVATE_LOOKUP_IN_CONSTRUCTOR = methodHandleUnreflectConstructor;
                }
            } catch (Throwable th6) {
                th = th6;
                methodHandleUnreflect = null;
                methodHandleUnreflect3 = null;
                methodHandleUnreflect4 = methodHandleUnreflect3;
                methodHandleFindStatic = methodHandleUnreflect4;
                methodHandleUnreflect5 = methodHandleFindStatic;
                if (!(th instanceof Error)) {
                    throw th;
                }
                LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.implementation.ReflectionUtilsMethodHandle$$ExternalSyntheticLambda0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return ReflectionUtilsMethodHandle.lambda$static$0();
                    }
                }, th);
                z = false;
                objInvokeWithArguments = null;
                if (!z) {
                    declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class);
                    if (!declaredConstructor.isAccessible()) {
                        declaredConstructor.setAccessible(true);
                    }
                    methodHandleUnreflectConstructor = lookup.unreflectConstructor(declaredConstructor);
                }
                MODULE_BASED = z;
                CLASS_GET_MODULE_METHOD_HANDLE = methodHandleUnreflect2;
                MODULE_IS_NAMED_METHOD_HANDLE = methodHandleUnreflect3;
                MODULE_ADD_READS_METHOD_HANDLE = methodHandleUnreflect4;
                METHOD_HANDLES_PRIVATE_LOOKUP_IN_METHOD_HANDLE = methodHandleFindStatic;
                MODULE_IS_OPEN_UNCONDITIONALLY_METHOD_HANDLE = methodHandleUnreflect5;
                MODULE_IS_OPEN_TO_OTHER_MODULE_METHOD_HANDLE = methodHandleUnreflect;
                LOOKUP = lookup;
                CORE_MODULE = objInvokeWithArguments;
                JDK_INTERNAL_PRIVATE_LOOKUP_IN_CONSTRUCTOR = methodHandleUnreflectConstructor;
            }
        } catch (Throwable th7) {
            th = th7;
            methodHandleUnreflect = null;
            methodHandleUnreflect2 = null;
            methodHandleUnreflect3 = null;
        }
        if (!z) {
            declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            methodHandleUnreflectConstructor = lookup.unreflectConstructor(declaredConstructor);
        }
        MODULE_BASED = z;
        CLASS_GET_MODULE_METHOD_HANDLE = methodHandleUnreflect2;
        MODULE_IS_NAMED_METHOD_HANDLE = methodHandleUnreflect3;
        MODULE_ADD_READS_METHOD_HANDLE = methodHandleUnreflect4;
        METHOD_HANDLES_PRIVATE_LOOKUP_IN_METHOD_HANDLE = methodHandleFindStatic;
        MODULE_IS_OPEN_UNCONDITIONALLY_METHOD_HANDLE = methodHandleUnreflect5;
        MODULE_IS_OPEN_TO_OTHER_MODULE_METHOD_HANDLE = methodHandleUnreflect;
        LOOKUP = lookup;
        CORE_MODULE = objInvokeWithArguments;
        JDK_INTERNAL_PRIVATE_LOOKUP_IN_CONSTRUCTOR = methodHandleUnreflectConstructor;
    }

    static /* synthetic */ String lambda$static$0() {
        return "Unable to create MethodHandles to use Java 9+ MethodHandles.privateLookupIn. Will attempt to fallback to using the package-private constructor.";
    }

    @Override // com.azure.core.implementation.ReflectionUtilsApi
    public ReflectiveInvoker getMethodInvoker(Class<?> cls, Method method, boolean z) throws Exception {
        return new MethodHandleReflectiveInvoker(getLookupToUse(cls, z).unreflect(method));
    }

    @Override // com.azure.core.implementation.ReflectionUtilsApi
    public ReflectiveInvoker getConstructorInvoker(Class<?> cls, Constructor<?> constructor, boolean z) throws Exception {
        return new MethodHandleReflectiveInvoker(getLookupToUse(cls, z).unreflectConstructor(constructor));
    }

    @Override // com.azure.core.implementation.ReflectionUtilsApi
    public boolean isModuleBased() {
        return MODULE_BASED;
    }

    private static MethodHandles.Lookup getLookupToUse(Class<?> cls, boolean z) throws Exception {
        try {
            if (!MODULE_BASED) {
                return (MethodHandles.Lookup) JDK_INTERNAL_PRIVATE_LOOKUP_IN_CONSTRUCTOR.invoke(cls);
            }
            if (!z) {
                return MethodHandles.publicLookup();
            }
            Object objInvoke = (Object) CLASS_GET_MODULE_METHOD_HANDLE.invoke(cls);
            if (!(boolean) MODULE_IS_NAMED_METHOD_HANDLE.invoke(objInvoke)) {
                MODULE_ADD_READS_METHOD_HANDLE.invokeWithArguments(CORE_MODULE, objInvoke);
                return performSafePrivateLookupIn(cls);
            }
            Object obj = CORE_MODULE;
            if (objInvoke == obj) {
                return LOOKUP;
            }
            String name = cls.getPackage().getName();
            if (!((Boolean) MODULE_IS_OPEN_UNCONDITIONALLY_METHOD_HANDLE.invokeWithArguments(objInvoke, name)).booleanValue() && !((Boolean) MODULE_IS_OPEN_TO_OTHER_MODULE_METHOD_HANDLE.invokeWithArguments(objInvoke, name, obj)).booleanValue()) {
                return MethodHandles.publicLookup();
            }
            MODULE_ADD_READS_METHOD_HANDLE.invokeWithArguments(obj, objInvoke);
            return performSafePrivateLookupIn(cls);
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw ((Exception) th);
        }
    }

    private static MethodHandles.Lookup performSafePrivateLookupIn(final Class<?> cls) throws Throwable {
        if (System.getSecurityManager() == null) {
            return (MethodHandles.Lookup) METHOD_HANDLES_PRIVATE_LOOKUP_IN_METHOD_HANDLE.invokeExact(cls, LOOKUP);
        }
        return (MethodHandles.Lookup) AccessControllerUtils.doPrivilegedException(new Callable() { // from class: com.azure.core.implementation.ReflectionUtilsMethodHandle$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReflectionUtilsMethodHandle.lambda$performSafePrivateLookupIn$1(cls);
            }
        });
    }

    static /* synthetic */ MethodHandles.Lookup lambda$performSafePrivateLookupIn$1(Class cls) throws Exception {
        try {
            return (MethodHandles.Lookup) METHOD_HANDLES_PRIVATE_LOOKUP_IN_METHOD_HANDLE.invokeExact(cls, LOOKUP);
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw ((Exception) th);
        }
    }
}
