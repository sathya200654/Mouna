package dagger.hilt.android.lifecycle;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface RetainedLifecycle {

    public interface OnClearedListener {
        void onCleared();
    }

    void addOnClearedListener(OnClearedListener listener);

    void removeOnClearedListener(OnClearedListener listener);
}
