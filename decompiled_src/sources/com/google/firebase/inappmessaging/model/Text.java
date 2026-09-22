package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class Text {
    private final String hexColor;
    private final String text;

    public int hashCode() {
        String str = this.text;
        return str != null ? str.hashCode() + this.hexColor.hashCode() : this.hexColor.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Text)) {
            return false;
        }
        Text text = (Text) obj;
        if (hashCode() != text.hashCode()) {
            return false;
        }
        String str = this.text;
        return (str != null || text.text == null) && (str == null || str.equals(text.text)) && this.hexColor.equals(text.hexColor);
    }

    private Text(String str, String str2) {
        this.text = str;
        this.hexColor = str2;
    }

    public String getText() {
        return this.text;
    }

    public String getHexColor() {
        return this.hexColor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String hexColor;
        private String text;

        public Builder setText(String str) {
            this.text = str;
            return this;
        }

        public Builder setText(MessagesProto.Text text) {
            setText(text.getText());
            setHexColor(text.getHexColor());
            return this;
        }

        public Builder setHexColor(String str) {
            this.hexColor = str;
            return this;
        }

        public Text build() {
            if (TextUtils.isEmpty(this.hexColor)) {
                throw new IllegalArgumentException("Text model must have a color");
            }
            return new Text(this.text, this.hexColor);
        }
    }
}
