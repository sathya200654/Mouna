package com.azure.json.implementation.jackson.core.json;

import com.azure.json.implementation.jackson.core.JsonLocation;
import com.azure.json.implementation.jackson.core.JsonParseException;
import com.azure.json.implementation.jackson.core.JsonParser;
import com.azure.json.implementation.jackson.core.JsonProcessingException;
import com.azure.json.implementation.jackson.core.JsonStreamContext;
import com.azure.json.implementation.jackson.core.io.ContentReference;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class JsonReadContext extends JsonStreamContext {
    private JsonReadContext _child;
    private int _columnNr;
    private String _currentName;
    private Object _currentValue;
    private DupDetector _dups;
    private int _lineNr;
    private final JsonReadContext _parent;

    public JsonReadContext(JsonReadContext jsonReadContext, DupDetector dupDetector, int i, int i2, int i3) {
        this._parent = jsonReadContext;
        this._dups = dupDetector;
        this._type = i;
        this._lineNr = i2;
        this._columnNr = i3;
        this._index = -1;
    }

    public void reset(int i, int i2, int i3) {
        this._type = i;
        this._index = -1;
        this._lineNr = i2;
        this._columnNr = i3;
        this._currentName = null;
        this._currentValue = null;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            dupDetector.reset();
        }
    }

    public JsonReadContext withDupDetector(DupDetector dupDetector) {
        this._dups = dupDetector;
        return this;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return this._currentValue;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    public static JsonReadContext createRootContext(DupDetector dupDetector) {
        return new JsonReadContext(null, dupDetector, 0, 1, 0);
    }

    public JsonReadContext createChildArrayContext(int i, int i2) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext == null) {
            DupDetector dupDetector = this._dups;
            JsonReadContext jsonReadContext2 = new JsonReadContext(this, dupDetector == null ? null : dupDetector.child(), 1, i, i2);
            this._child = jsonReadContext2;
            return jsonReadContext2;
        }
        jsonReadContext.reset(1, i, i2);
        return jsonReadContext;
    }

    public JsonReadContext createChildObjectContext(int i, int i2) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext == null) {
            DupDetector dupDetector = this._dups;
            JsonReadContext jsonReadContext2 = new JsonReadContext(this, dupDetector == null ? null : dupDetector.child(), 2, i, i2);
            this._child = jsonReadContext2;
            return jsonReadContext2;
        }
        jsonReadContext.reset(2, i, i2);
        return jsonReadContext;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonStreamContext
    public String getCurrentName() {
        return this._currentName;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonStreamContext
    public JsonReadContext getParent() {
        return this._parent;
    }

    @Override // com.azure.json.implementation.jackson.core.JsonStreamContext
    public JsonLocation startLocation(ContentReference contentReference) {
        return new JsonLocation(contentReference, -1L, this._lineNr, this._columnNr);
    }

    @Override // com.azure.json.implementation.jackson.core.JsonStreamContext
    @Deprecated
    public JsonLocation getStartLocation(Object obj) {
        return startLocation(ContentReference.rawReference(obj));
    }

    public JsonReadContext clearAndGetParent() {
        this._currentValue = null;
        return this._parent;
    }

    public DupDetector getDupDetector() {
        return this._dups;
    }

    public boolean expectComma() {
        int i = this._index + 1;
        this._index = i;
        return this._type != 0 && i > 0;
    }

    public void setCurrentName(String str) throws JsonProcessingException {
        this._currentName = str;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            _checkDup(dupDetector, str);
        }
    }

    private void _checkDup(DupDetector dupDetector, String str) throws JsonProcessingException {
        if (dupDetector.isDup(str)) {
            Object source = dupDetector.getSource();
            throw new JsonParseException(source instanceof JsonParser ? (JsonParser) source : null, "Duplicate field '" + str + "'");
        }
    }
}
