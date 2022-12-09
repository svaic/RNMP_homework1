package ukim.mk.finki.datamining.task;

import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import ukim.mk.finki.datamining.accumulator.CountSensorAccumulator;
import ukim.mk.finki.datamining.dto.CountAggregate;
import ukim.mk.finki.datamining.pojo.Sensor;

public class CountSensorData implements Task<Sensor, CountAggregate> {

    @Override
    public void execute(WindowedStream<Sensor, String, TimeWindow> window, KafkaSink<CountAggregate> output) {
        window.aggregate(new CountSensorAccumulator()).sinkTo(output);
    }
}
