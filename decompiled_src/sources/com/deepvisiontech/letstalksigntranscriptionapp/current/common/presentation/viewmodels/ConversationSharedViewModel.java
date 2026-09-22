package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSharedViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/presentation/viewmodels/ConversationSharedViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_scannedText", "", "setScannedText", "", "text", "consumeScannedText", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationSharedViewModel extends ViewModel {
    public static final int $stable = 8;
    private String _scannedText;

    @Inject
    public ConversationSharedViewModel() {
    }

    public final void setScannedText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this._scannedText = text;
    }

    public final String consumeScannedText() {
        String str = this._scannedText;
        this._scannedText = null;
        return str;
    }
}
