package ukim.mk.finki.datamining.watermark;

import org.apache.flink.api.common.eventtime.*;
import ukim.mk.finki.datamining.pojo.Sensor;

public class SensorWaterMark implements WatermarkStrategy<Sensor> {
    @Override
    public WatermarkGenerator<Sensor> createWatermarkGenerator(WatermarkGeneratorSupplier.Context context) {
        return new WatermarkGenerator<>() {
            @Override
            public void onEvent(Sensor event, long eventTimestamp, WatermarkOutput output) {
                output.emitWatermark(new Watermark(event.timestamp.getTime()));
            }

            @Override
            public void onPeriodicEmit(WatermarkOutput output) {
                output.emitWatermark(new Watermark(System.currentTimeMillis()));
            }
        };
    }

    @Override
    public TimestampAssigner<Sensor> createTimestampAssigner(TimestampAssignerSupplier.Context context) {
        return ((element, recordTimestamp) -> element.timestamp.getTime());
    }
}
