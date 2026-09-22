package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseResource.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "T", "", "<init>", "()V", "Success", "Error", "Loading", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource$Loading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource$Success;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ResponseResource<T> {
    public static final int $stable = 0;

    public /* synthetic */ ResponseResource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ResponseResource.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource$Success;", "T", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success<T> extends ResponseResource<T> {
        public static final int $stable = 0;
        private final T data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.data;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T data) {
            return new Success<>(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.data, ((Success) other).data);
        }

        public int hashCode() {
            T t = this.data;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ")";
        }

        public Success(T t) {
            super(null);
            this.data = t;
        }

        public final T getData() {
            return this.data;
        }
    }

    private ResponseResource() {
    }

    /* JADX INFO: compiled from: ResponseResource.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;)V", "getError", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends ResponseResource {
        public static final int $stable = 8;
        private final AppError error;

        public static /* synthetic */ Error copy$default(Error error, AppError appError, int i, Object obj) {
            if ((i & 1) != 0) {
                appError = error.error;
            }
            return error.copy(appError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AppError getError() {
            return this.error;
        }

        public final Error copy(AppError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(AppError appError) {
            super(null);
            Intrinsics.checkNotNullParameter(appError, "error");
            this.error = appError;
        }

        public final AppError getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: ResponseResource.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource$Loading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Loading extends ResponseResource {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2058128222;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
            super(null);
        }
    }
}
