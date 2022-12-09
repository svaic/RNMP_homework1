package ukim.mk.finki.datamining.accumulator;

import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import ukim.mk.finki.datamining.dto.SensorStatisticOutput;
import ukim.mk.finki.datamining.pojo.Sensor;

import java.util.LongSummaryStatistics;
import java.util.stream.StreamSupport;

public class SensorStatisticsWindowFunction implements WindowFunction<Sensor, SensorStatisticOutput, String, TimeWindow> {

    @Override
    public void apply(String s, TimeWindow window, Iterable<Sensor> input, Collector<SensorStatisticOutput> out) {

        SensorStatisticOutput record = new SensorStatisticOutput();
        record.setKey(s);
        record.setWindowStart(window.getStart());
        record.setWindowEnd(window.getEnd());

        LongSummaryStatistics statistics = StreamSupport
                .stream(input.spliterator(), false)
                .mapToLong(x->x.value).summaryStatistics();

        record.setMinValue(statistics.getMin());
        record.setMaxValue(statistics.getMax());
        record.setCount(statistics.getCount());
        record.setAverage(statistics.getAverage());

        out.collect(record);
    }
}
