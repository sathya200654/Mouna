package androidx.webkit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Navigation {
    boolean didCommit();

    boolean didCommitErrorPage();

    Page getPage();

    int getStatusCode();

    boolean isBack();

    boolean isForward();

    boolean isHistory();

    boolean isReload();

    boolean isRestore();

    boolean isSameDocument();

    boolean wasInitiatedByPage();
}
