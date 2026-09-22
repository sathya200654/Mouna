package androidx.room.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KClassUtil.jvmAndroid.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"findAndInstantiateDatabaseImpl", "T", "C", "klass", "Ljava/lang/Class;", "suffix", "", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "room-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KClassUtil {
    public static /* synthetic */ Object findAndInstantiateDatabaseImpl$default(Class cls, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "_Impl";
        }
        return findAndInstantiateDatabaseImpl(cls, str);
    }

    public static final <T, C> T findAndInstantiateDatabaseImpl(Class<C> cls, String str) {
        String name;
        Intrinsics.checkNotNullParameter(cls, "klass");
        Intrinsics.checkNotNullParameter(str, "suffix");
        Package r0 = cls.getPackage();
        if (r0 == null || (name = r0.getName()) == null) {
            name = "";
        }
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNull(canonicalName);
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            Intrinsics.checkNotNullExpressionValue(canonicalName, "substring(...)");
        }
        String str2 = StringsKt.replace$default(canonicalName, '.', '_', false, 4, (Object) null) + str;
        try {
            Class<?> cls2 = Class.forName(name.length() == 0 ? str2 : name + '.' + str2, true, cls.getClassLoader());
            Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.util.KClassUtil.findAndInstantiateDatabaseImpl>");
            return (T) cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str2 + " does not exist. Is Room annotation processor correctly configured?", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName(), e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName(), e3);
        }
    }
}
