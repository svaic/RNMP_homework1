package ukim.mk.finki.datamining.task;

import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;

public interface Task<T,M> {
    void execute(WindowedStream<T, String, TimeWindow> window, KafkaSink<M> output);
}
