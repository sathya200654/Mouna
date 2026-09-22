package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationServiceState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManagerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ServiceState;", "", "speech", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "web", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "tts", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerState;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerState;)V", "getSpeech", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "getWeb", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "getTts", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerState;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ServiceState {
    public static final int $stable = TextToSpeechManagerState.$stable;
    private final ConversationServiceState speech;
    private final TextToSpeechManagerState tts;
    private final WebViewState web;

    public static /* synthetic */ ServiceState copy$default(ServiceState serviceState, ConversationServiceState conversationServiceState, WebViewState webViewState, TextToSpeechManagerState textToSpeechManagerState, int i, Object obj) {
        if ((i & 1) != 0) {
            conversationServiceState = serviceState.speech;
        }
        if ((i & 2) != 0) {
            webViewState = serviceState.web;
        }
        if ((i & 4) != 0) {
            textToSpeechManagerState = serviceState.tts;
        }
        return serviceState.copy(conversationServiceState, webViewState, textToSpeechManagerState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConversationServiceState getSpeech() {
        return this.speech;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WebViewState getWeb() {
        return this.web;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TextToSpeechManagerState getTts() {
        return this.tts;
    }

    public final ServiceState copy(ConversationServiceState speech, WebViewState web, TextToSpeechManagerState tts) {
        Intrinsics.checkNotNullParameter(speech, "speech");
        Intrinsics.checkNotNullParameter(web, "web");
        Intrinsics.checkNotNullParameter(tts, "tts");
        return new ServiceState(speech, web, tts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceState)) {
            return false;
        }
        ServiceState serviceState = (ServiceState) other;
        return Intrinsics.areEqual(this.speech, serviceState.speech) && Intrinsics.areEqual(this.web, serviceState.web) && Intrinsics.areEqual(this.tts, serviceState.tts);
    }

    public int hashCode() {
        return (((this.speech.hashCode() * 31) + this.web.hashCode()) * 31) + this.tts.hashCode();
    }

    public String toString() {
        return "ServiceState(speech=" + this.speech + ", web=" + this.web + ", tts=" + this.tts + ")";
    }

    public ServiceState(ConversationServiceState conversationServiceState, WebViewState webViewState, TextToSpeechManagerState textToSpeechManagerState) {
        Intrinsics.checkNotNullParameter(conversationServiceState, "speech");
        Intrinsics.checkNotNullParameter(webViewState, "web");
        Intrinsics.checkNotNullParameter(textToSpeechManagerState, "tts");
        this.speech = conversationServiceState;
        this.web = webViewState;
        this.tts = textToSpeechManagerState;
    }

    public final ConversationServiceState getSpeech() {
        return this.speech;
    }

    public final WebViewState getWeb() {
        return this.web;
    }

    public final TextToSpeechManagerState getTts() {
        return this.tts;
    }
}
