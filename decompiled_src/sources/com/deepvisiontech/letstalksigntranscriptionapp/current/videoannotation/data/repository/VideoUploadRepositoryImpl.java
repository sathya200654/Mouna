package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.api.VideoApiService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.dto.VideoUploadSuccessResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository.VideoUploadRepository;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: VideoUploadRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/repository/VideoUploadRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/repository/VideoUploadRepository;", "videoApiService", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/remote/api/VideoApiService;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/remote/api/VideoApiService;)V", "uploadVideo", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "context", "Landroid/content/Context;", "videoUri", "Landroid/net/Uri;", "signName", "", "gmailId", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileFromUri", "Ljava/io/File;", "uri", "getFileName", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoUploadRepositoryImpl implements VideoUploadRepository {
    public static final int $stable = 8;
    private final VideoApiService videoApiService;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository.VideoUploadRepositoryImpl$uploadVideo$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoUploadRepositoryImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository.VideoUploadRepositoryImpl", f = "VideoUploadRepositoryImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {47}, m = "uploadVideo", n = {"context", "videoUri", "signName", "gmailId", "tempFile", "videoRequestBody", "videoPart", "gmailIdRequestBody"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoUploadRepositoryImpl.this.uploadVideo(null, null, null, null, (Continuation) this);
        }
    }

    @Inject
    public VideoUploadRepositoryImpl(VideoApiService videoApiService) {
        Intrinsics.checkNotNullParameter(videoApiService, "videoApiService");
        this.videoApiService = videoApiService;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository.VideoUploadRepository
    public Object uploadVideo(Context context, Uri uri, String str, String str2, Continuation<? super ResponseResource<Unit>> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Throwable th;
        File file;
        Exception exc;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objApi$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) anonymousClass2.L$4;
            try {
                try {
                    ResultKt.throwOnFailure(objApi$default);
                    if (file != null) {
                        try {
                            Boxing.boxBoolean(file.delete());
                            return objApi$default;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return objApi$default;
                } catch (Exception e2) {
                    exc = e2;
                    exc.printStackTrace();
                    ResponseResource.Error error = new ResponseResource.Error(AppError.LocalStorageError.INSTANCE);
                    if (file != null) {
                        try {
                            Boxing.boxBoolean(file.delete());
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return error;
                }
            } catch (Throwable th2) {
                th = th2;
                if (file != null) {
                    throw th;
                }
                try {
                    Boxing.boxBoolean(file.delete());
                    throw th;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    throw th;
                }
            }
        }
        ResultKt.throwOnFailure(objApi$default);
        try {
            File fileFromUri = getFileFromUri(context, uri);
            try {
                RequestBody requestBodyCreate = RequestBody.Companion.create(fileFromUri, MediaType.Companion.parse("video/mp4"));
                MultipartBody.Part partCreateFormData = MultipartBody.Part.Companion.createFormData("video", str + ".mp4", requestBodyCreate);
                RequestBody requestBodyCreate2 = RequestBody.Companion.create(str2, MediaType.Companion.parse("text/plain"));
                SafeCall safeCall = SafeCall.INSTANCE;
                AnonymousClass2 anonymousClass3 = new AnonymousClass2(requestBodyCreate2, partCreateFormData, null);
                AnonymousClass3 anonymousClass4 = new AnonymousClass3(null);
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(context);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(uri);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass2.L$4 = fileFromUri;
                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(requestBodyCreate);
                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(partCreateFormData);
                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(requestBodyCreate2);
                anonymousClass2.label = 1;
                objApi$default = SafeCall.api$default(safeCall, "VideoUpload", null, anonymousClass3, anonymousClass4, anonymousClass2, 2, null);
                if (objApi$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                file = fileFromUri;
                if (file != null) {
                    Boxing.boxBoolean(file.delete());
                    return objApi$default;
                }
                return objApi$default;
            } catch (Exception e5) {
                exc = e5;
                file = fileFromUri;
                exc.printStackTrace();
                ResponseResource.Error error2 = new ResponseResource.Error(AppError.LocalStorageError.INSTANCE);
                if (file != null) {
                    Boxing.boxBoolean(file.delete());
                }
                return error2;
            } catch (Throwable th3) {
                th = th3;
                file = fileFromUri;
                if (file != null) {
                    throw th;
                }
                Boxing.boxBoolean(file.delete());
                throw th;
            }
        } catch (Exception e6) {
            exc = e6;
            file = null;
        } catch (Throwable th4) {
            th = th4;
            file = null;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository.VideoUploadRepositoryImpl$uploadVideo$2, reason: invalid class name */
    /* JADX INFO: compiled from: VideoUploadRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/remote/dto/VideoUploadSuccessResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository.VideoUploadRepositoryImpl$uploadVideo$2", f = "VideoUploadRepositoryImpl.kt", i = {}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super VideoUploadSuccessResponse>, Object> {
        final /* synthetic */ RequestBody $gmailIdRequestBody;
        final /* synthetic */ MultipartBody.Part $videoPart;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RequestBody requestBody, MultipartBody.Part part, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$gmailIdRequestBody = requestBody;
            this.$videoPart = part;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return VideoUploadRepositoryImpl.this.new AnonymousClass2(this.$gmailIdRequestBody, this.$videoPart, continuation);
        }

        public final Object invoke(Continuation<? super VideoUploadSuccessResponse> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objUploadVideo = VideoUploadRepositoryImpl.this.videoApiService.uploadVideo(this.$gmailIdRequestBody, this.$videoPart, (Continuation) this);
            return objUploadVideo == coroutine_suspended ? coroutine_suspended : objUploadVideo;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository.VideoUploadRepositoryImpl$uploadVideo$3, reason: invalid class name */
    /* JADX INFO: compiled from: VideoUploadRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "<unused var>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/remote/dto/VideoUploadSuccessResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository.VideoUploadRepositoryImpl$uploadVideo$3", f = "VideoUploadRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<VideoUploadSuccessResponse, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        public final Object invoke(VideoUploadSuccessResponse videoUploadSuccessResponse, Continuation<? super Unit> continuation) {
            return create(videoUploadSuccessResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    private final File getFileFromUri(Context context, Uri uri) throws IOException {
        ContentResolver contentResolver = context.getContentResolver();
        File file = new File(context.getCacheDir(), getFileName(context, uri));
        if (!file.exists()) {
            file.createNewFile();
        }
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
        if (inputStreamOpenInputStream != null) {
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                InputStream inputStream2 = inputStream;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, (Object) null);
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    return file;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStream, th3);
                    throw th4;
                }
            }
        }
        throw new IOException("Could not open input stream for URI");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x005d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0070  */
    /* JADX WARN: Code duplicated, block: B:35:0x008a A[RETURN] */
    private final String getFileName(Context context, Uri uri) {
        Uri uri2;
        String path;
        int iLastIndexOf$default;
        int columnIndex;
        String strSubstring = null;
        if (Intrinsics.areEqual(uri.getScheme(), "content")) {
            uri2 = uri;
            Cursor cursorQuery = context.getContentResolver().query(uri2, null, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    path = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("_display_name")) == -1) ? null : cursor2.getString(columnIndex);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, (Throwable) null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursor, th);
                        throw th2;
                    }
                }
            }
            if (path == null) {
                path = uri2.getPath();
                if (path != null) {
                    iLastIndexOf$default = StringsKt.lastIndexOf$default(path, JsonPointer.SEPARATOR, 0, false, 6, (Object) null);
                } else {
                    iLastIndexOf$default = -1;
                }
                if (iLastIndexOf$default != -1) {
                    if (path != null) {
                        strSubstring = path.substring(iLastIndexOf$default + 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    }
                    path = strSubstring;
                }
            }
            if (path == null) {
                return "temp_video_" + System.currentTimeMillis() + ".mp4";
            }
            return path;
        }
        uri2 = uri;
        path = null;
        if (path == null) {
            path = uri2.getPath();
            if (path != null) {
                iLastIndexOf$default = StringsKt.lastIndexOf$default(path, JsonPointer.SEPARATOR, 0, false, 6, (Object) null);
            } else {
                iLastIndexOf$default = -1;
            }
            if (iLastIndexOf$default != -1) {
                if (path != null) {
                    strSubstring = path.substring(iLastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                }
                path = strSubstring;
            }
        }
        if (path == null) {
            return "temp_video_" + System.currentTimeMillis() + ".mp4";
        }
        return path;
    }
}
