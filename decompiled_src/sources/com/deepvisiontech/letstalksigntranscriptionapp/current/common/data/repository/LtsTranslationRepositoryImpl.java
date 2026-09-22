package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.api.LtsTranslationApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatebhashini.TranslateBhashiniRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatebhashini.TranslateBhashiniResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatefromenglish.TranslateFromEnglishRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatetoenglish.TranslateToEnglishRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatetoenglish.TranslateToEnglishResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LtsTranslationRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JD\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010JD\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010JL\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/repository/LtsTranslationRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/LtsTranslationRepository;", "ltsTranslationApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/api/LtsTranslationApi;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/api/LtsTranslationApi;)V", "translateToEnglish", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "customerId", "deviceId", "gmailId", "token", "text", "inputLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translateFromEnglish", "targetLang", "translateBhashini", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LtsTranslationRepositoryImpl implements LtsTranslationRepository {
    private static final String TAG = "LtsRepositoryImpl";
    private final LtsTranslationApi ltsTranslationApi;
    public static final int $stable = 8;

    @Inject
    public LtsTranslationRepositoryImpl(LtsTranslationApi ltsTranslationApi) {
        Intrinsics.checkNotNullParameter(ltsTranslationApi, "ltsTranslationApi");
        this.ltsTranslationApi = ltsTranslationApi;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository
    public Object translateToEnglish(String str, String str2, String str3, String str4, String str5, LanguageEnum languageEnum, Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C01922(str, str4, str2, str3, str5, languageEnum, null), new C01933(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateToEnglish$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LtsTranslationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatetoenglish/TranslateToEnglishResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateToEnglish$2", f = "LtsTranslationRepositoryImpl.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    static final class C01922 extends SuspendLambda implements Function1<Continuation<? super TranslateToEnglishResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ LanguageEnum $inputLang;
        final /* synthetic */ String $text;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01922(String str, String str2, String str3, String str4, String str5, LanguageEnum languageEnum, Continuation<? super C01922> continuation) {
            super(1, continuation);
            this.$customerId = str;
            this.$token = str2;
            this.$deviceId = str3;
            this.$gmailId = str4;
            this.$text = str5;
            this.$inputLang = languageEnum;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LtsTranslationRepositoryImpl.this.new C01922(this.$customerId, this.$token, this.$deviceId, this.$gmailId, this.$text, this.$inputLang, continuation);
        }

        public final Object invoke(Continuation<? super TranslateToEnglishResponse> continuation) {
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
            Object objTranslateToEnglish = LtsTranslationRepositoryImpl.this.ltsTranslationApi.translateToEnglish(new TranslateToEnglishRequest(this.$customerId, this.$token, this.$deviceId, this.$gmailId, this.$text, StringsKt.substringBefore$default(this.$inputLang.getLanguageCode(), "-", (String) null, 2, (Object) null)), (Continuation) this);
            return objTranslateToEnglish == coroutine_suspended ? coroutine_suspended : objTranslateToEnglish;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateToEnglish$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LtsTranslationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatetoenglish/TranslateToEnglishResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateToEnglish$3", f = "LtsTranslationRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01933 extends SuspendLambda implements Function2<TranslateToEnglishResponse, Continuation<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C01933(Continuation<? super C01933> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01933 = new C01933(continuation);
            c01933.L$0 = obj;
            return c01933;
        }

        public final Object invoke(TranslateToEnglishResponse translateToEnglishResponse, Continuation<? super String> continuation) {
            return create(translateToEnglishResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            TranslateToEnglishResponse translateToEnglishResponse = (TranslateToEnglishResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return translateToEnglishResponse.getData();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository
    public Object translateFromEnglish(String str, String str2, String str3, String str4, String str5, LanguageEnum languageEnum, Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C01902(str, str4, str2, str3, str5, languageEnum, null), new C01913(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateFromEnglish$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LtsTranslationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatetoenglish/TranslateToEnglishResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateFromEnglish$2", f = "LtsTranslationRepositoryImpl.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    static final class C01902 extends SuspendLambda implements Function1<Continuation<? super TranslateToEnglishResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ LanguageEnum $targetLang;
        final /* synthetic */ String $text;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01902(String str, String str2, String str3, String str4, String str5, LanguageEnum languageEnum, Continuation<? super C01902> continuation) {
            super(1, continuation);
            this.$customerId = str;
            this.$token = str2;
            this.$deviceId = str3;
            this.$gmailId = str4;
            this.$text = str5;
            this.$targetLang = languageEnum;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LtsTranslationRepositoryImpl.this.new C01902(this.$customerId, this.$token, this.$deviceId, this.$gmailId, this.$text, this.$targetLang, continuation);
        }

        public final Object invoke(Continuation<? super TranslateToEnglishResponse> continuation) {
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
            Object objTranslateFromEnglish = LtsTranslationRepositoryImpl.this.ltsTranslationApi.translateFromEnglish(new TranslateFromEnglishRequest(this.$customerId, this.$token, this.$deviceId, this.$gmailId, this.$text, StringsKt.substringBefore$default(this.$targetLang.getLanguageCode(), "-", (String) null, 2, (Object) null)), (Continuation) this);
            return objTranslateFromEnglish == coroutine_suspended ? coroutine_suspended : objTranslateFromEnglish;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateFromEnglish$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LtsTranslationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatetoenglish/TranslateToEnglishResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateFromEnglish$3", f = "LtsTranslationRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01913 extends SuspendLambda implements Function2<TranslateToEnglishResponse, Continuation<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C01913(Continuation<? super C01913> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01913 = new C01913(continuation);
            c01913.L$0 = obj;
            return c01913;
        }

        public final Object invoke(TranslateToEnglishResponse translateToEnglishResponse, Continuation<? super String> continuation) {
            return create(translateToEnglishResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            TranslateToEnglishResponse translateToEnglishResponse = (TranslateToEnglishResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return translateToEnglishResponse.getData();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository
    public Object translateBhashini(String str, String str2, String str3, String str4, String str5, LanguageEnum languageEnum, LanguageEnum languageEnum2, Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(str, str4, str2, str3, str5, languageEnum, languageEnum2, null), new AnonymousClass3(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateBhashini$2, reason: invalid class name */
    /* JADX INFO: compiled from: LtsTranslationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatebhashini/TranslateBhashiniResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateBhashini$2", f = "LtsTranslationRepositoryImpl.kt", i = {}, l = {SignPracticeCreationViewModel.TOPIC_MAX_CHAR_LIMIT}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super TranslateBhashiniResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ LanguageEnum $inputLang;
        final /* synthetic */ LanguageEnum $targetLang;
        final /* synthetic */ String $text;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, String str3, String str4, String str5, LanguageEnum languageEnum, LanguageEnum languageEnum2, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$customerId = str;
            this.$token = str2;
            this.$deviceId = str3;
            this.$gmailId = str4;
            this.$text = str5;
            this.$inputLang = languageEnum;
            this.$targetLang = languageEnum2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LtsTranslationRepositoryImpl.this.new AnonymousClass2(this.$customerId, this.$token, this.$deviceId, this.$gmailId, this.$text, this.$inputLang, this.$targetLang, continuation);
        }

        public final Object invoke(Continuation<? super TranslateBhashiniResponse> continuation) {
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
            Object objTranslateBhashini = LtsTranslationRepositoryImpl.this.ltsTranslationApi.translateBhashini(new TranslateBhashiniRequest(this.$customerId, this.$token, this.$deviceId, this.$gmailId, this.$text, StringsKt.substringBefore$default(this.$inputLang.getLanguageCode(), "-", (String) null, 2, (Object) null), StringsKt.substringBefore$default(this.$targetLang.getLanguageCode(), "-", (String) null, 2, (Object) null)), (Continuation) this);
            return objTranslateBhashini == coroutine_suspended ? coroutine_suspended : objTranslateBhashini;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateBhashini$3, reason: invalid class name */
    /* JADX INFO: compiled from: LtsTranslationRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatebhashini/TranslateBhashiniResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository.LtsTranslationRepositoryImpl$translateBhashini$3", f = "LtsTranslationRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<TranslateBhashiniResponse, Continuation<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(TranslateBhashiniResponse translateBhashiniResponse, Continuation<? super String> continuation) {
            return create(translateBhashiniResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            TranslateBhashiniResponse translateBhashiniResponse = (TranslateBhashiniResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return translateBhashiniResponse.getData();
        }
    }
}
