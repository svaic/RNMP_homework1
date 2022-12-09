package ukim.mk.finki.datamining.task;

import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import ukim.mk.finki.datamining.accumulator.SensorStatisticsWindowFunction;
import ukim.mk.finki.datamining.dto.SensorStatisticOutput;
import ukim.mk.finki.datamining.pojo.Sensor;

public class AggregateSensorData implements Task<Sensor, SensorStatisticOutput> {

    @Override
    public void execute(WindowedStream<Sensor, String, TimeWindow> window, KafkaSink<SensorStatisticOutput> output) {
        window.apply(new SensorStatisticsWindowFunction()).sinkTo(output);
    }
}
