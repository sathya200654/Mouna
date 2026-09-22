package com.azure.core.models;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.window.embedding.EmbeddingCompat;
import com.azure.core.util.BinaryData;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonProviders;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.json.ReadValueCallback;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CloudEvent implements JsonSerializable<CloudEvent> {
    private static final String ILLEGAL_ATTRIBUTE_NAME_MESSAGE;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) CloudEvent.class);
    private static final Set<String> RESERVED_ATTRIBUTE_NAMES;
    private static final String SPEC_VERSION = "1.0";

    @JsonIgnore
    private BinaryData binaryData;

    @JsonProperty(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
    @JsonDeserialize(using = AnyToStringDeserializer.class)
    @JsonRawValue
    private String data;

    @JsonProperty("data_base64")
    private String dataBase64;

    @JsonProperty("datacontenttype")
    private String dataContentType;

    @JsonProperty("dataschema")
    private String dataSchema;

    @JsonIgnore
    private Map<String, Object> extensionAttributes;

    @JsonProperty(required = EmbeddingCompat.DEBUG, value = "id")
    private String id;

    @JsonProperty(required = EmbeddingCompat.DEBUG, value = Constants.ScionAnalytics.PARAM_SOURCE)
    private String source;

    @JsonProperty(required = EmbeddingCompat.DEBUG, value = "specversion")
    private String specVersion;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("time")
    private OffsetDateTime time;

    @JsonProperty(required = EmbeddingCompat.DEBUG, value = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)
    private String type;

    static {
        HashSet hashSet = new HashSet(Arrays.asList("specversion", "id", Constants.ScionAnalytics.PARAM_SOURCE, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "datacontenttype", "dataschema", "subject", "time", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "data_base64"));
        RESERVED_ATTRIBUTE_NAMES = hashSet;
        ILLEGAL_ATTRIBUTE_NAME_MESSAGE = "Extension attribute 'name' must have only lower-case alphanumeric characters and not be one of the CloudEvent reserved attribute names: " + String.join(", ", hashSet);
    }

    public CloudEvent(String str, String str2, BinaryData binaryData, CloudEventDataFormat cloudEventDataFormat, String str3) {
        this.source = (String) Objects.requireNonNull(str, "'source' cannot be null.");
        this.type = (String) Objects.requireNonNull(str2, "'type' cannot be null.");
        if (binaryData != null) {
            Objects.requireNonNull(cloudEventDataFormat, "'format' cannot be null when 'data' isn't null.");
            if (CloudEventDataFormat.BYTES == cloudEventDataFormat) {
                this.dataBase64 = Base64.getEncoder().encodeToString(binaryData.toBytes());
            } else {
                try {
                    JsonReader jsonReaderCreateReader = JsonProviders.createReader(binaryData.toBytes());
                    try {
                        JsonToken jsonTokenNextToken = jsonReaderCreateReader.nextToken();
                        if (jsonTokenNextToken == JsonToken.START_OBJECT || jsonTokenNextToken == JsonToken.START_ARRAY) {
                            this.data = jsonReaderCreateReader.readChildren();
                        } else if (jsonTokenNextToken == JsonToken.STRING) {
                            this.data = "\"" + jsonReaderCreateReader.getString() + "\"";
                        } else {
                            this.data = jsonReaderCreateReader.getString();
                        }
                        if (jsonReaderCreateReader != null) {
                            jsonReaderCreateReader.close();
                        }
                    } catch (Throwable th) {
                        if (jsonReaderCreateReader != null) {
                            try {
                                jsonReaderCreateReader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    throw LOGGER.logExceptionAsError(new IllegalArgumentException("'data' isn't in valid Json format", e));
                }
            }
        }
        this.dataContentType = str3;
        this.id = CoreUtils.randomUuid().toString();
        this.specVersion = "1.0";
        this.binaryData = binaryData;
        this.time = OffsetDateTime.now(ZoneOffset.UTC);
    }

    private CloudEvent() {
    }

    public static List<CloudEvent> fromString(String str) {
        return fromString(str, false);
    }

    public static List<CloudEvent> fromString(String str, boolean z) {
        List<CloudEvent> array;
        Objects.requireNonNull(str, "'cloudEventsJson' cannot be null");
        try {
            JsonReader jsonReaderCreateReader = JsonProviders.createReader(str);
            try {
                JsonToken jsonTokenNextToken = jsonReaderCreateReader.nextToken();
                if (jsonTokenNextToken == JsonToken.START_OBJECT) {
                    array = new ArrayList<>(1);
                    array.add((CloudEvent) jsonReaderCreateReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.CloudEvent$$ExternalSyntheticLambda0
                        @Override // com.azure.json.ReadValueCallback
                        public final Object read(Object obj) {
                            return CloudEvent.fromJson((JsonReader) obj);
                        }
                    }));
                } else if (jsonTokenNextToken == JsonToken.START_ARRAY) {
                    array = jsonReaderCreateReader.readArray(new ReadValueCallback() { // from class: com.azure.core.models.CloudEvent$$ExternalSyntheticLambda0
                        @Override // com.azure.json.ReadValueCallback
                        public final Object read(Object obj) {
                            return CloudEvent.fromJson((JsonReader) obj);
                        }
                    });
                } else {
                    if (jsonTokenNextToken != JsonToken.NULL) {
                        throw LOGGER.logExceptionAsError(new IllegalArgumentException("JSON string started at an invalid state for reading a single instance or an array of CloudEvents. Starting token was: " + jsonTokenNextToken));
                    }
                    if (jsonReaderCreateReader != null) {
                        jsonReaderCreateReader.close();
                    }
                    return null;
                }
                if (jsonReaderCreateReader != null) {
                    jsonReaderCreateReader.close();
                }
                if (!z && array != null) {
                    for (int i = 0; i < array.size(); i++) {
                        CloudEvent cloudEvent = array.get(i);
                        if (cloudEvent.getId() == null || cloudEvent.getSource() == null || cloudEvent.getType() == null) {
                            ArrayList arrayList = new ArrayList();
                            if (cloudEvent.getId() == null) {
                                arrayList.add("'id'");
                            }
                            if (cloudEvent.getSource() == null) {
                                arrayList.add("'source'");
                            }
                            if (cloudEvent.getType() == null) {
                                arrayList.add("'type'");
                            }
                            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'id', 'source' and 'type' are mandatory attributes for a CloudEvent according to the spec. This JSON string doesn't have " + CoreUtils.stringJoin(", ", arrayList) + " for the object at index " + i + ". Please make sure the input Json string has the required attributes or use CloudEvent.fromString(cloudEventsJson, true) to skip the null check."));
                        }
                    }
                }
                return array;
            } catch (Throwable th) {
                if (jsonReaderCreateReader != null) {
                    try {
                        jsonReaderCreateReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(e));
        }
    }

    public String getId() {
        return this.id;
    }

    public CloudEvent setId(String str) {
        Objects.requireNonNull(str, "'id' cannot be null");
        if (str.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'id' cannot be empty"));
        }
        this.id = str;
        return this;
    }

    public String getSource() {
        return this.source;
    }

    public BinaryData getData() {
        if (this.binaryData == null) {
            String str = this.data;
            if (str != null) {
                this.binaryData = BinaryData.fromString(str);
            } else if (this.dataBase64 != null) {
                this.binaryData = BinaryData.fromBytes(Base64.getDecoder().decode(this.dataBase64));
            }
        }
        return this.binaryData;
    }

    public String getType() {
        return this.type;
    }

    public OffsetDateTime getTime() {
        return this.time;
    }

    public CloudEvent setTime(OffsetDateTime offsetDateTime) {
        this.time = offsetDateTime;
        return this;
    }

    public String getDataContentType() {
        return this.dataContentType;
    }

    public String getDataSchema() {
        return this.dataSchema;
    }

    public CloudEvent setDataSchema(String str) {
        this.dataSchema = str;
        return this;
    }

    public String getSubject() {
        return this.subject;
    }

    public CloudEvent setSubject(String str) {
        this.subject = str;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getExtensionAttributes() {
        Map<String, Object> map = this.extensionAttributes;
        if (map == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(map);
    }

    @JsonAnySetter
    public CloudEvent addExtensionAttribute(String str, Object obj) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        Objects.requireNonNull(obj, "'value' cannot be null.");
        if (!validateAttributeName(str)) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(ILLEGAL_ATTRIBUTE_NAME_MESSAGE));
        }
        if (this.extensionAttributes == null) {
            this.extensionAttributes = new HashMap();
        }
        this.extensionAttributes.put(str, obj);
        return this;
    }

    String getSpecVersion() {
        return this.specVersion;
    }

    CloudEvent setSpecVersion(String str) {
        this.specVersion = str;
        return this;
    }

    private static boolean validateAttributeName(String str) {
        if (RESERVED_ATTRIBUTE_NAMES.contains(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < '0' || cCharAt > '9')) {
                return false;
            }
        }
        return true;
    }

    @Override // com.azure.json.JsonSerializable
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject().writeStringField("id", this.id).writeStringField(Constants.ScionAnalytics.PARAM_SOURCE, this.source);
        String str = this.dataBase64;
        if (str != null) {
            jsonWriter.writeStringField("data_base64", str);
        } else {
            String str2 = this.data;
            if (str2 != null) {
                jsonWriter.writeRawField(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, str2);
            } else {
                jsonWriter.writeNullField(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
            }
        }
        jsonWriter.writeStringField(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, this.type);
        OffsetDateTime offsetDateTime = this.time;
        if (offsetDateTime != null) {
            jsonWriter.writeStringField("time", offsetDateTime.toString());
        }
        jsonWriter.writeStringField("specversion", this.specVersion).writeStringField("dataschema", this.dataSchema).writeStringField("datacontenttype", this.dataContentType).writeStringField("subject", this.subject);
        if (!CoreUtils.isNullOrEmpty(this.extensionAttributes)) {
            for (Map.Entry<String, Object> entry : this.extensionAttributes.entrySet()) {
                jsonWriter.writeUntypedField(String.valueOf(entry.getKey()), entry.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    public static CloudEvent fromJson(final JsonReader jsonReader) throws IOException {
        return (CloudEvent) jsonReader.readObject(new ReadValueCallback() { // from class: com.azure.core.models.CloudEvent$$ExternalSyntheticLambda2
            @Override // com.azure.json.ReadValueCallback
            public final Object read(Object obj) {
                return CloudEvent.lambda$fromJson$1(jsonReader, (JsonReader) obj);
            }
        });
    }

    static /* synthetic */ CloudEvent lambda$fromJson$1(JsonReader jsonReader, JsonReader jsonReader2) throws IOException {
        CloudEvent cloudEvent = new CloudEvent();
        while (jsonReader2.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonReader2.getFieldName();
            JsonToken jsonTokenNextToken = jsonReader2.nextToken();
            if ("id".equals(fieldName)) {
                cloudEvent.id = jsonReader2.getString();
            } else if (Constants.ScionAnalytics.PARAM_SOURCE.equals(fieldName)) {
                cloudEvent.source = jsonReader2.getString();
            } else if (Constants.ScionAnalytics.MessageType.DATA_MESSAGE.equals(fieldName)) {
                if (jsonTokenNextToken == JsonToken.START_OBJECT || jsonTokenNextToken == JsonToken.START_ARRAY) {
                    cloudEvent.data = jsonReader.readChildren();
                } else if (jsonTokenNextToken == JsonToken.STRING) {
                    cloudEvent.data = "\"" + jsonReader.getRawText() + "\"";
                } else {
                    cloudEvent.data = jsonReader.getString();
                }
            } else if ("data_base64".equals(fieldName)) {
                cloudEvent.dataBase64 = jsonReader2.getString();
            } else if (ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY.equals(fieldName)) {
                cloudEvent.type = jsonReader2.getString();
            } else if ("time".equals(fieldName)) {
                cloudEvent.time = (OffsetDateTime) jsonReader2.getNullable(new ReadValueCallback() { // from class: com.azure.core.models.CloudEvent$$ExternalSyntheticLambda1
                    @Override // com.azure.json.ReadValueCallback
                    public final Object read(Object obj) {
                        return OffsetDateTime.parse(((JsonReader) obj).getString());
                    }
                });
            } else if ("specversion".equals(fieldName)) {
                cloudEvent.specVersion = jsonReader2.getString();
            } else if ("dataschema".equals(fieldName)) {
                cloudEvent.dataSchema = jsonReader2.getString();
            } else if ("datacontenttype".equals(fieldName)) {
                cloudEvent.dataContentType = jsonReader2.getString();
            } else if ("subject".equals(fieldName)) {
                cloudEvent.subject = jsonReader2.getString();
            } else {
                if (cloudEvent.extensionAttributes == null) {
                    cloudEvent.extensionAttributes = new LinkedHashMap();
                }
                cloudEvent.extensionAttributes.put(fieldName, jsonReader2.readUntyped());
            }
        }
        return cloudEvent;
    }

    private static final class AnyToStringDeserializer extends JsonDeserializer<String> {
        private AnyToStringDeserializer() {
        }

        public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return jsonParser.readValueAsTree().toString();
        }
    }
}
