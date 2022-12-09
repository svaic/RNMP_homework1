package ukim.mk.finki.datamining.sink;

import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import ukim.mk.finki.datamining.serialization.JSONSerializationSchema;

public class KafkaIOFactory <K> {

    private final Class<K> classType;

    public KafkaIOFactory(Class<K> classType) {
        this.classType = classType;
    }

    public KafkaSource<K> createKafkaSource(SinkType sinkType, String bootstrapServer) {
        return KafkaSource.<K>builder()
                .setBootstrapServers(bootstrapServer)
                .setTopics(sinkType.getSinkType())
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setValueOnlyDeserializer(new JSONSerializationSchema<>(classType))
                .build();
    }

    public KafkaSink<K> createKafkaSink(SinkType sinkType, String bootstrapServer) {
        return KafkaSink.<K>builder()
                .setBootstrapServers(bootstrapServer)
                .setRecordSerializer(KafkaRecordSerializationSchema.builder()
                        .setTopic(sinkType.getSinkType())
                        .setValueSerializationSchema(new JSONSerializationSchema<>(classType))
                        .build()
                )
                .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
                .build();
    }
}
