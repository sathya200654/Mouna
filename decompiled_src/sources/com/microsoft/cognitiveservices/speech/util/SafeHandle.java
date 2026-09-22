package com.microsoft.cognitiveservices.speech.util;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class SafeHandle implements AutoCloseable {
    private SafeHandleType handleType;
    private long value;

    public SafeHandle(long j, SafeHandleType safeHandleType) {
        this.value = 0L;
        SafeHandleType safeHandleType2 = SafeHandleType.UnInitialized;
        this.value = j;
        this.handleType = safeHandleType;
    }

    private final native long releaseActivityReceivedEventHandle(long j);

    private final native long releaseAudioConfigHandle(long j);

    private final native long releaseAudioDataStreamHandle(long j);

    private final native long releaseAudioInputStreamHandle(long j);

    private final native long releaseAudioOutputStreamHandle(long j);

    private final native long releaseAudioProcessingOptionsHandle(long j);

    private final native long releaseAudioStreamFormatHandle(long j);

    private final native long releaseAutoDetectSourceLanguageConfigHandle(long j);

    private final native long releaseConnectionHandle(long j);

    private final native long releaseConnectionMessageEventHandle(long j);

    private final native long releaseConnectionMessageHandle(long j);

    private final native long releaseConversationHandle(long j);

    private final native long releaseConversationTranslatorHandle(long j);

    private final native long releaseDialogServiceConnectorHandle(long j);

    private final native long releaseEventHandle(long j);

    private final native long releaseEventLoggerCallbackHandle(long j);

    private final native long releaseGrammarHandle(long j);

    private final native long releaseJsonBuilderHandle(long j);

    private final native long releaseJsonValueHandle(long j);

    private final native long releaseKeywordModelHandle(long j);

    private final native long releaseKeywordRecognizerHandle(long j);

    private final native long releaseMeetingHandle(long j);

    private final native long releaseParticipantHandle(long j);

    private final native long releasePronunciationAssessmentConfig(long j);

    private final native long releasePropertyHandle(long j);

    private final native long releaseRecognizerHandle(long j);

    private final native long releaseRecognizerResultHandle(long j);

    private final native long releaseSourceLanguageConfigHandle(long j);

    private final native long releaseSpeechConfigHandle(long j);

    private final native long releaseSpeechRecognitionModelHandle(long j);

    private final native long releaseSpeechTranslationModelHandle(long j);

    private final native long releaseSynthesisEventHandle(long j);

    private final native long releaseSynthesisRequestHandle(long j);

    private final native long releaseSynthesisResultHandle(long j);

    private final native long releaseSynthesizerHandle(long j);

    private final native long releaseTranslationSynthesisHandle(long j);

    private final native long releaseTurnStatusReceivedEventHandle(long j);

    private final native long releaseUserHandle(long j);

    private final native long releaseVoiceInfoHandle(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.value != 0) {
            if (this.handleType == SafeHandleType.Event) {
                releaseEventHandle(this.value);
            } else if (this.handleType == SafeHandleType.Recognizer) {
                releaseRecognizerHandle(this.value);
            } else if (this.handleType == SafeHandleType.SpeechConfig) {
                releaseSpeechConfigHandle(this.value);
            } else if (this.handleType == SafeHandleType.PropertyCollection) {
                releasePropertyHandle(this.value);
            } else if (this.handleType == SafeHandleType.RecognitionResult) {
                releaseRecognizerResultHandle(this.value);
            } else if (this.handleType == SafeHandleType.AudioConfig) {
                releaseAudioConfigHandle(this.value);
            } else if (this.handleType == SafeHandleType.Connection) {
                releaseConnectionHandle(this.value);
            } else if (this.handleType == SafeHandleType.ConnectionMessage) {
                releaseConnectionMessageHandle(this.value);
            } else if (this.handleType == SafeHandleType.ConnectionMessageEvent) {
                releaseConnectionMessageEventHandle(this.value);
            } else if (this.handleType == SafeHandleType.AudioInputStream) {
                releaseAudioInputStreamHandle(this.value);
            } else if (this.handleType == SafeHandleType.AudioStreamFormat) {
                releaseAudioStreamFormatHandle(this.value);
            } else if (this.handleType == SafeHandleType.KeywordModel) {
                releaseKeywordModelHandle(this.value);
            } else if (this.handleType == SafeHandleType.User) {
                releaseUserHandle(this.value);
            } else if (this.handleType == SafeHandleType.Participant) {
                releaseParticipantHandle(this.value);
            } else if (this.handleType == SafeHandleType.Conversation) {
                releaseConversationHandle(this.value);
            } else if (this.handleType == SafeHandleType.Meeting) {
                releaseMeetingHandle(this.value);
            } else if (this.handleType == SafeHandleType.DialogServiceConnector) {
                releaseDialogServiceConnectorHandle(this.value);
            } else if (this.handleType == SafeHandleType.TurnStatusReceivedEvent) {
                releaseTurnStatusReceivedEventHandle(this.value);
            } else if (this.handleType == SafeHandleType.ActivityReceivedEvent) {
                releaseActivityReceivedEventHandle(this.value);
            } else if (this.handleType == SafeHandleType.AudioOutputStream) {
                releaseAudioOutputStreamHandle(this.value);
            } else if (this.handleType == SafeHandleType.AutoDetectSourceLanguageConfig) {
                releaseAutoDetectSourceLanguageConfigHandle(this.value);
            } else if (this.handleType == SafeHandleType.SourceLanguageConfig) {
                releaseSourceLanguageConfigHandle(this.value);
            } else if (this.handleType == SafeHandleType.SynthesisEvent) {
                releaseSynthesisEventHandle(this.value);
            } else if (this.handleType == SafeHandleType.SynthesisRequest) {
                releaseSynthesisRequestHandle(this.value);
            } else if (this.handleType == SafeHandleType.SynthesisResult) {
                releaseSynthesisResultHandle(this.value);
            } else if (this.handleType == SafeHandleType.VoiceInfo) {
                releaseVoiceInfoHandle(this.value);
            } else if (this.handleType == SafeHandleType.AudioDataStream) {
                releaseAudioDataStreamHandle(this.value);
            } else if (this.handleType == SafeHandleType.Synthesizer) {
                releaseSynthesizerHandle(this.value);
            } else if (this.handleType == SafeHandleType.Grammar) {
                releaseGrammarHandle(this.value);
            } else if (this.handleType == SafeHandleType.TranslationSynthesis) {
                releaseTranslationSynthesisHandle(this.value);
            } else if (this.handleType == SafeHandleType.ConversationTranslator) {
                releaseConversationTranslatorHandle(this.value);
            } else if (this.handleType == SafeHandleType.KeywordRecognizer) {
                releaseKeywordRecognizerHandle(this.value);
            } else if (this.handleType == SafeHandleType.PronunciationAssessmentConfig) {
                releasePronunciationAssessmentConfig(this.value);
            } else if (this.handleType == SafeHandleType.AudioProcessingOptions) {
                releaseAudioProcessingOptionsHandle(this.value);
            } else if (this.handleType == SafeHandleType.SpeechRecognitionModel) {
                releaseSpeechRecognitionModelHandle(this.value);
            } else if (this.handleType == SafeHandleType.SpeechTranslationModel) {
                releaseSpeechTranslationModelHandle(this.value);
            } else if (this.handleType == SafeHandleType.JSONVALUE) {
                releaseJsonValueHandle(this.value);
            } else if (this.handleType == SafeHandleType.JSONBUILDER) {
                releaseJsonBuilderHandle(this.value);
            } else if (this.handleType == SafeHandleType.EventLoggerCallback) {
                releaseEventLoggerCallbackHandle(this.value);
            } else {
                System.out.println("Java SafeHandle close, invalid handle value: " + String.valueOf(this.value));
            }
            this.value = 0L;
            this.handleType = SafeHandleType.UnInitialized;
        }
    }

    protected void finalize() throws Throwable {
        close();
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }
}
