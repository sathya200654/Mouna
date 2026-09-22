package androidx.test.internal.platform.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ReflectiveMethod<T> {
    private final String className;
    private boolean initialized = false;
    private Method method;
    private final String methodName;
    private final Class<?>[] paramTypes;

    public ReflectiveMethod(String className, String methodName, Class<?>... paramTypes) {
        this.className = className;
        this.paramTypes = paramTypes;
        this.methodName = methodName;
    }

    public T invoke(Object obj, Object... objArr) throws ReflectionException {
        try {
            initIfNecessary();
            return (T) this.method.invoke(obj, objArr);
        } catch (ClassNotFoundException e) {
            throw new ReflectionException(e);
        } catch (IllegalAccessException e2) {
            throw new ReflectionException(e2);
        } catch (NoSuchMethodException e3) {
            throw new ReflectionException(e3);
        } catch (InvocationTargetException e4) {
            throw new ReflectionException(e4);
        }
    }

    public T invokeStatic(Object... paramValues) throws ReflectionException {
        return invoke(null, paramValues);
    }

    private synchronized void initIfNecessary() throws NoSuchMethodException, ClassNotFoundException {
        if (this.initialized) {
            return;
        }
        Method declaredMethod = Class.forName(this.className).getDeclaredMethod(this.methodName, this.paramTypes);
        this.method = declaredMethod;
        declaredMethod.setAccessible(true);
        this.initialized = true;
    }
}
