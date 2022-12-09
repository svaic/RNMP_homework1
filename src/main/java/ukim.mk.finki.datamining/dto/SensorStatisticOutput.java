package ukim.mk.finki.datamining.dto;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

public class SensorStatisticOutput {

    @JsonProperty("key")
    private String key;
    @JsonProperty("window_start")
    private Long windowStart;
    @JsonProperty("window_end")
    private Long windowEnd;
    @JsonProperty("min_value")
    private Long minValue;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("average")
    private Double average;
    @JsonProperty("max_value")
    private Long maxValue;

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("window_start")
    public Long getWindowStart() {
        return windowStart;
    }

    @JsonProperty("window_start")
    public void setWindowStart(Long windowStart) {
        this.windowStart = windowStart;
    }

    @JsonProperty("window_end")
    public Long getWindowEnd() {
        return windowEnd;
    }

    @JsonProperty("window_end")
    public void setWindowEnd(Long windowEnd) {
        this.windowEnd = windowEnd;
    }

    @JsonProperty("min_value")
    public Long getMinValue() {
        return minValue;
    }

    @JsonProperty("min_value")
    public void setMinValue(Long minValue) {
        this.minValue = minValue;
    }

    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    @JsonProperty("average")
    public Double getAverage() {
        return average;
    }

    @JsonProperty("average")
    public void setAverage(Double average) {
        this.average = average;
    }

    @JsonProperty("max_value")
    public Long getMaxValue() {
        return maxValue;
    }

    @JsonProperty("max_value")
    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "{" +
                "key='" + key + '\'' +
                ", windowStart=" + windowStart +
                ", windowEnd=" + windowEnd +
                ", minValue=" + minValue +
                ", count=" + count +
                ", average=" + average +
                ", maxValue=" + maxValue +
                '}';
    }

}
