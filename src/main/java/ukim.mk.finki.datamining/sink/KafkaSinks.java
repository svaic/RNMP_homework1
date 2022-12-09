package ukim.mk.finki.datamining.sink;

import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import ukim.mk.finki.datamining.dto.CountAggregate;
import ukim.mk.finki.datamining.dto.SensorStatisticOutput;
import ukim.mk.finki.datamining.pojo.Sensor;

public class KafkaSinks {

    String bootstrapServer;
    public KafkaSource<Sensor> sensors;
    public KafkaSink<CountAggregate> result1;
    public KafkaSink<SensorStatisticOutput> result2;

    public KafkaSinks(String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
        sensors = new KafkaIOFactory<>(Sensor.class).createKafkaSource(SinkType.SENSORS, bootstrapServer);
        result1 = new KafkaIOFactory<>(CountAggregate.class).createKafkaSink(SinkType.RESULT1, bootstrapServer);
        result2 = new KafkaIOFactory<>(SensorStatisticOutput.class).createKafkaSink(SinkType.RESULT2, bootstrapServer);
    }
}
