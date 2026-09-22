package com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppNavigator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/utils/navigation/NavigationCommand;", "", "<init>", "()V", "To", "Back", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/utils/navigation/NavigationCommand$Back;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/utils/navigation/NavigationCommand$To;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class NavigationCommand {
    public static final int $stable = 0;

    public /* synthetic */ NavigationCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: AppNavigator.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/utils/navigation/NavigationCommand$To;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/utils/navigation/NavigationCommand;", "deepLink", "", "<init>", "(Ljava/lang/String;)V", "getDeepLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class To extends NavigationCommand {
        public static final int $stable = 0;
        private final String deepLink;

        public static /* synthetic */ To copy$default(To to, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = to.deepLink;
            }
            return to.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeepLink() {
            return this.deepLink;
        }

        public final To copy(String deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            return new To(deepLink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof To) && Intrinsics.areEqual(this.deepLink, ((To) other).deepLink);
        }

        public int hashCode() {
            return this.deepLink.hashCode();
        }

        public String toString() {
            return "To(deepLink=" + this.deepLink + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public To(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "deepLink");
            this.deepLink = str;
        }

        public final String getDeepLink() {
            return this.deepLink;
        }
    }

    private NavigationCommand() {
    }

    /* JADX INFO: compiled from: AppNavigator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/utils/navigation/NavigationCommand$Back;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/utils/navigation/NavigationCommand;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Back extends NavigationCommand {
        public static final int $stable = 0;
        public static final Back INSTANCE = new Back();

        private Back() {
            super(null);
        }
    }
}
