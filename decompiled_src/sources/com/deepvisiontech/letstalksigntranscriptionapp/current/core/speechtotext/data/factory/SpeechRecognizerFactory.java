package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.factory;

import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.local.SpeechRecogMicrophoneStream;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechTranslationManagerImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.repository.SpeechToTextRepository;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpeechRecognizerFactory.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/factory/SpeechRecognizerFactory;", "", "streamProvider", "Ljavax/inject/Provider;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/local/SpeechRecogMicrophoneStream;", "speechToTextRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Ljavax/inject/Provider;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "createSpeechRecognizer", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/manager/SpeechRecognitionManager;", "recognizerType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerType;", "userLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerLang", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpeechRecognizerFactory {
    private static final String TAG = "SpeechRecognizerFactory";
    private final SessionRepository sessionRepository;
    private final SpeechToTextRepository speechToTextRepository;
    private final Provider<SpeechRecogMicrophoneStream> streamProvider;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SpeechRecognizerFactory.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpeechRecognizerType.values().length];
            try {
                iArr[SpeechRecognizerType.SPEECH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpeechRecognizerType.TRANSLATION_TO_TARGET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpeechRecognizerType.TRANSLATION_TO_ENGLISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SpeechRecognizerType.CONVERSATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public SpeechRecognizerFactory(Provider<SpeechRecogMicrophoneStream> provider, SpeechToTextRepository speechToTextRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(provider, "streamProvider");
        Intrinsics.checkNotNullParameter(speechToTextRepository, "speechToTextRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.streamProvider = provider;
        this.speechToTextRepository = speechToTextRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final SpeechRecognitionManager createSpeechRecognizer(SpeechRecognizerType recognizerType, LanguageEnum userLang, LanguageEnum speakerLang) throws Exception {
        Intrinsics.checkNotNullParameter(recognizerType, "recognizerType");
        Intrinsics.checkNotNullParameter(userLang, "userLang");
        Intrinsics.checkNotNullParameter(speakerLang, "speakerLang");
        try {
            SpeechRecogMicrophoneStream speechRecogMicrophoneStream = (SpeechRecogMicrophoneStream) this.streamProvider.get();
            int i = WhenMappings.$EnumSwitchMapping$0[recognizerType.ordinal()];
            if (i == 1) {
                Intrinsics.checkNotNull(speechRecogMicrophoneStream);
                return new SpeechRecognitionManagerImpl(speechRecogMicrophoneStream, this.speechToTextRepository, this.sessionRepository);
            }
            if (i == 2) {
                Intrinsics.checkNotNull(speechRecogMicrophoneStream);
                return new SpeechTranslationManagerImpl(speechRecogMicrophoneStream, this.speechToTextRepository, this.sessionRepository, speakerLang, userLang);
            }
            if (i == 3) {
                Intrinsics.checkNotNull(speechRecogMicrophoneStream);
                return new SpeechTranslationManagerImpl(speechRecogMicrophoneStream, this.speechToTextRepository, this.sessionRepository, userLang, userLang);
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNull(speechRecogMicrophoneStream);
            return new ConversationRecognizerManagerImpl(speechRecogMicrophoneStream, this.speechToTextRepository, this.sessionRepository);
        } catch (Exception e) {
            Log.e(TAG, "Error creating recognizer.", e);
            throw e;
        }
    }
}
