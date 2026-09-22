package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.ExtractTextFromImageUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DocumentScannerViewModel_Factory implements Factory<DocumentScannerViewModel> {
    private final Provider<ExtractTextFromImageUseCase> extractTextFromImageUseCaseProvider;

    private DocumentScannerViewModel_Factory(Provider<ExtractTextFromImageUseCase> extractTextFromImageUseCaseProvider) {
        this.extractTextFromImageUseCaseProvider = extractTextFromImageUseCaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DocumentScannerViewModel m1664get() {
        return newInstance((ExtractTextFromImageUseCase) this.extractTextFromImageUseCaseProvider.get());
    }

    public static DocumentScannerViewModel_Factory create(Provider<ExtractTextFromImageUseCase> extractTextFromImageUseCaseProvider) {
        return new DocumentScannerViewModel_Factory(extractTextFromImageUseCaseProvider);
    }

    public static DocumentScannerViewModel newInstance(ExtractTextFromImageUseCase extractTextFromImageUseCase) {
        return new DocumentScannerViewModel(extractTextFromImageUseCase);
    }
}
