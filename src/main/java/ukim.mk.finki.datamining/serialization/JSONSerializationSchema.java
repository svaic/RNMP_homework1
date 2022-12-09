package ukim.mk.finki.datamining.serialization;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONSerializationSchema<D> implements SerializationSchema<D>, DeserializationSchema<D> {

    static ObjectMapper objectMapper = new ObjectMapper();
    private final Class<D> type;

    public JSONSerializationSchema(Class<D> type) {
        this.type = type;
    }

    @Override
    public byte[] serialize(D element) {
        try {
            System.out.println(element);
            return objectMapper.writeValueAsBytes(element);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public D deserialize(byte[] message) throws IOException {
        return objectMapper.readValue(message, type);
    }

    @Override
    public boolean isEndOfStream(D nextElement) {
        return false;
    }

    @Override
    public TypeInformation<D> getProducedType() {
        return TypeInformation.of(type);
    }
}
