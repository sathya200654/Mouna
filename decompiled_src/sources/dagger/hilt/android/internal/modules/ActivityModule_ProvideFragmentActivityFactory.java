package dagger.hilt.android.internal.modules;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ActivityModule_ProvideFragmentActivityFactory implements Factory<FragmentActivity> {
    private final Provider<Activity> activityProvider;

    private ActivityModule_ProvideFragmentActivityFactory(Provider<Activity> activityProvider) {
        this.activityProvider = activityProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FragmentActivity m2266get() {
        return provideFragmentActivity((Activity) this.activityProvider.get());
    }

    public static ActivityModule_ProvideFragmentActivityFactory create(Provider<Activity> activityProvider) {
        return new ActivityModule_ProvideFragmentActivityFactory(activityProvider);
    }

    public static FragmentActivity provideFragmentActivity(Activity activity) {
        return (FragmentActivity) Preconditions.checkNotNullFromProvides(ActivityModule.provideFragmentActivity(activity));
    }
}
