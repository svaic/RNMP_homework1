package ukim.mk.finki.datamining.accumulator;

import org.apache.flink.api.common.functions.AggregateFunction;
import ukim.mk.finki.datamining.dto.SensorStatisticOutput;
import ukim.mk.finki.datamining.dto.StatisticsAccumulator;
import ukim.mk.finki.datamining.pojo.Sensor;

public class SensorStatisticsAccumulator implements AggregateFunction<Sensor, StatisticsAccumulator, SensorStatisticOutput> {

    @Override
    public StatisticsAccumulator createAccumulator() {
        return new StatisticsAccumulator();
    }

    @Override
    public StatisticsAccumulator add(Sensor sensor, StatisticsAccumulator accumulator) {
        accumulator.setKey(sensor.key);
        accumulator.addCount();
        accumulator.addToSumValues(sensor.value);
        accumulator.setMinValue(sensor.value);
        accumulator.setMaxValue(sensor.value);
        accumulator.setWindowStart(sensor.timestamp.getTime());
        accumulator.setWindowEnd(sensor.timestamp.getTime());
        return accumulator;
    }

    @Override
    public SensorStatisticOutput getResult(StatisticsAccumulator accumulator) {
        SensorStatisticOutput sensorOutput = new SensorStatisticOutput();

        sensorOutput.setKey(accumulator.key);

        sensorOutput.setCount(accumulator.getCount());

        sensorOutput.setMaxValue(accumulator.getMaxValue());
        sensorOutput.setMinValue(accumulator.getMinValue());

        sensorOutput.setAverage((double) accumulator.getSumValues() / accumulator.getCount());

        sensorOutput.setWindowStart(accumulator.getWindowStart());
        sensorOutput.setWindowEnd(accumulator.getWindowEnd());

        return sensorOutput;
    }

    @Override
    public StatisticsAccumulator merge(StatisticsAccumulator a, StatisticsAccumulator b) {
        a.setCount(a.getCount() + b.getCount());
        a.setMaxValue(b.getMaxValue());
        a.setMinValue(b.getMinValue());
        a.setSumValues(a.getSumValues() + b.getSumValues());
        a.setWindowStart(b.getWindowStart());
        a.setWindowEnd(b.getWindowEnd());
        return a;
    }
}
