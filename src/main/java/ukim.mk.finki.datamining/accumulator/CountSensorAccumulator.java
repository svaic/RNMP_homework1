package ukim.mk.finki.datamining.accumulator;

import org.apache.flink.api.common.functions.AggregateFunction;
import ukim.mk.finki.datamining.dto.CountAggregate;
import ukim.mk.finki.datamining.pojo.Sensor;

public class CountSensorAccumulator implements AggregateFunction<Sensor, CountAggregate, CountAggregate> {

    @Override
    public CountAggregate createAccumulator() {
        return new CountAggregate();
    }

    @Override
    public CountAggregate add(Sensor sensor, CountAggregate accumulator) {
        accumulator.key = sensor.key;
        accumulator.count++;
        return accumulator;
    }

    @Override
    public CountAggregate getResult(CountAggregate accumulator) {
        return accumulator;
    }

    @Override
    public CountAggregate merge(CountAggregate a, CountAggregate b) {
        a.count += b.count;
        return a;
    }
}
