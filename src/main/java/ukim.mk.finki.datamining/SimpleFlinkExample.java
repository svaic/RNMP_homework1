package ukim.mk.finki.datamining;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import ukim.mk.finki.datamining.accumulator.CountSensorAccumulator;
import ukim.mk.finki.datamining.accumulator.SensorStatisticsWindowFunction;
import ukim.mk.finki.datamining.pojo.Sensor;
import ukim.mk.finki.datamining.sink.KafkaSinks;
import ukim.mk.finki.datamining.watermark.SensorWaterMark;

public class SimpleFlinkExample {
    public static void main(String[] args) throws Exception {

        KafkaSinks sinks = new KafkaSinks("localhost:9092");

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Sensor> stream = env.fromSource(sinks.sensors, WatermarkStrategy.noWatermarks(), "Kafka Source");

        var timeWindow = stream.assignTimestampsAndWatermarks(new SensorWaterMark())
                .keyBy(x->x.key)
                .window(SlidingEventTimeWindows.of(Time.seconds(15), Time.seconds(5)));

        timeWindow
                .aggregate(new CountSensorAccumulator())
                .sinkTo(sinks.result1);

        timeWindow
                .apply(new SensorStatisticsWindowFunction())
                .sinkTo(sinks.result2);

        env.execute("homework1");
    }
}
