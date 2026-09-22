package com.azure.core.implementation.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class DateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {
    private static final SimpleModule MODULE = new SimpleModule().addDeserializer(OffsetDateTime.class, new DateTimeDeserializer());

    DateTimeDeserializer() {
    }

    public static SimpleModule getModule() {
        return MODULE;
    }

    public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.currentToken() == JsonToken.VALUE_NUMBER_INT) {
            return OffsetDateTime.ofInstant(Instant.ofEpochSecond(jsonParser.getValueAsLong()), ZoneOffset.UTC);
        }
        TemporalAccessor best = DateTimeFormatter.ISO_DATE_TIME.parseBest(jsonParser.getValueAsString(), new TemporalQuery() { // from class: com.azure.core.implementation.jackson.DateTimeDeserializer$$ExternalSyntheticLambda0
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return OffsetDateTime.from(temporalAccessor);
            }
        }, new TemporalQuery() { // from class: com.azure.core.implementation.jackson.DateTimeDeserializer$$ExternalSyntheticLambda1
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return LocalDateTime.from(temporalAccessor);
            }
        });
        if (best.query(TemporalQueries.offset()) == null) {
            return LocalDateTime.from(best).atOffset(ZoneOffset.UTC);
        }
        return OffsetDateTime.from(best);
    }
}
