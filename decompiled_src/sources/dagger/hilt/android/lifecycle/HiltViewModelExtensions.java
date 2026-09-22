package dagger.hilt.android.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiltViewModelExtensions.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u001a$\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00072\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\b"}, d2 = {"withCreationCallback", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VMF", "callback", "Lkotlin/Function1;", "Landroidx/lifecycle/ViewModel;", "addCreationCallback", "Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "hilt-android_main_java_dagger_hilt_android_lifecycle-hilt_view_model_extensions_internal_kt"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HiltViewModelExtensions {
    public static final <VMF> CreationExtras withCreationCallback(CreationExtras creationExtras, Function1<? super VMF, ? extends ViewModel> function1) {
        Intrinsics.checkNotNullParameter(creationExtras, "<this>");
        Intrinsics.checkNotNullParameter(function1, "callback");
        return addCreationCallback(new MutableCreationExtras(creationExtras), function1);
    }

    public static final <VMF> CreationExtras addCreationCallback(MutableCreationExtras mutableCreationExtras, final Function1<? super VMF, ? extends ViewModel> function1) {
        Intrinsics.checkNotNullParameter(mutableCreationExtras, "<this>");
        Intrinsics.checkNotNullParameter(function1, "callback");
        CreationExtras.Key<Function1<Object, ViewModel>> key = HiltViewModelFactory.CREATION_CALLBACK_KEY;
        Intrinsics.checkNotNullExpressionValue(key, "CREATION_CALLBACK_KEY");
        mutableCreationExtras.set(key, new Function1<Object, ViewModel>() { // from class: dagger.hilt.android.lifecycle.HiltViewModelExtensions$addCreationCallback$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewModel m2269invoke(Object obj) {
                return (ViewModel) function1.invoke(obj);
            }
        });
        return (CreationExtras) mutableCreationExtras;
    }
}
