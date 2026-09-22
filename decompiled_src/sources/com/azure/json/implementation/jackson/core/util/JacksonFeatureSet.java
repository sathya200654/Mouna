package com.azure.json.implementation.jackson.core.util;

import com.azure.json.implementation.jackson.core.util.JacksonFeature;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JacksonFeatureSet<F extends JacksonFeature> {
    private final int _enabled;

    private JacksonFeatureSet(int i) {
        this._enabled = i;
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> fromDefaults(F[] fArr) {
        if (fArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", fArr[0].getClass().getName(), Integer.valueOf(fArr.length)));
        }
        int mask = 0;
        for (F f : fArr) {
            if (f.enabledByDefault()) {
                mask |= f.getMask();
            }
        }
        return new JacksonFeatureSet<>(mask);
    }

    public JacksonFeatureSet<F> with(F f) {
        int mask = f.getMask() | this._enabled;
        return mask == this._enabled ? this : new JacksonFeatureSet<>(mask);
    }

    public JacksonFeatureSet<F> without(F f) {
        int i = (~f.getMask()) & this._enabled;
        return i == this._enabled ? this : new JacksonFeatureSet<>(i);
    }

    public boolean isEnabled(F f) {
        return (this._enabled & f.getMask()) != 0;
    }
}
