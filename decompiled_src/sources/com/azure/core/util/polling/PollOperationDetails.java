package com.azure.core.util.polling;

import androidx.window.embedding.EmbeddingCompat;
import com.azure.core.models.ResponseError;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PollOperationDetails implements JsonSerializable<PollOperationDetails> {

    @JsonProperty("error")
    private ResponseError error;

    @JsonProperty(required = EmbeddingCompat.DEBUG, value = "id")
    private final String operationId;

    @JsonCreator
    private PollOperationDetails(@JsonProperty(required = EmbeddingCompat.DEBUG, value = "id") String str) {
        this.operationId = str;
    }

    public String getOperationId() {
        return this.operationId;
    }

    public ResponseError getError() {
        return this.error;
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeStartObject().writeStringField("id", this.operationId).writeJsonField("error", this.error).writeEndObject();
    }

    public static PollOperationDetails fromJson(JsonReader jsonReader) throws IOException {
        return (PollOperationDetails) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.util.polling.PollOperationDetails$$ExternalSyntheticLambda0
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return PollOperationDetails.lambda$fromJson$0((JsonReader) obj);
            }
        });
    }

    static /* synthetic */ PollOperationDetails lambda$fromJson$0(JsonReader jsonReader) throws IOException {
        boolean z = false;
        String string = null;
        ResponseError responseErrorFromJson = null;
        while (jsonReader.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader.getFieldName();
            jsonReader.nextToken();
            if ("id".equals(fieldName)) {
                string = jsonReader.getString();
                z = true;
            } else if ("error".equals(fieldName)) {
                responseErrorFromJson = ResponseError.fromJson(jsonReader);
            } else {
                jsonReader.skipChildren();
            }
        }
        if (z) {
            PollOperationDetails pollOperationDetails = new PollOperationDetails(string);
            pollOperationDetails.error = responseErrorFromJson;
            return pollOperationDetails;
        }
        throw new IllegalStateException("Missing required property: id");
    }
}
