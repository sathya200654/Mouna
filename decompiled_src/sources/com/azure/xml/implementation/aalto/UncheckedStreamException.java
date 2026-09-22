package com.azure.xml.implementation.aalto;

import java.io.PrintStream;
import java.io.PrintWriter;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class UncheckedStreamException extends RuntimeException {
    private UncheckedStreamException(XMLStreamException xMLStreamException) {
        super((Throwable) xMLStreamException);
    }

    public static UncheckedStreamException createFrom(XMLStreamException xMLStreamException) {
        return new UncheckedStreamException(xMLStreamException);
    }

    @Override // java.lang.Throwable
    public StackTraceElement[] getStackTrace() {
        return getCause().getStackTrace();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getCause().getMessage();
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return getCause().getLocalizedMessage();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        getCause().printStackTrace();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        getCause().printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        getCause().printStackTrace(printWriter);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getCause().toString();
    }
}
