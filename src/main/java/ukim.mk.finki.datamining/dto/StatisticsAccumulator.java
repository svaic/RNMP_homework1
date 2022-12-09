package ukim.mk.finki.datamining.dto;

public class StatisticsAccumulator {
    public String key;
    public Long sumValues;
    public Long minValue;
    public Long maxValue;
    public Long count;
    public Long windowStart;
    public Long windowEnd;

    public StatisticsAccumulator() {
        sumValues = 0L;
        minValue = Long.MAX_VALUE;
        maxValue = Long.MIN_VALUE;
        count = 0L;
        windowStart = Long.MAX_VALUE;
        windowEnd = Long.MIN_VALUE;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getSumValues() {
        return sumValues;
    }

    public void setSumValues(Long sumValues) {
        this.sumValues = sumValues;
    }

    public void addToSumValues(Long sumValues) {
        this.sumValues += sumValues;
    }

    public Long getMinValue() {
        return minValue;
    }

    public void setMinValue(Long minValue) {
        if (this.minValue > minValue) {
            this.minValue = minValue;
        }
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        if (this.maxValue < maxValue) {
            this.maxValue = maxValue;
        }
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void addCount() {
        this.count++;
    }

    public Long getWindowStart() {
        return windowStart;
    }

    public void setWindowStart(Long windowStart) {
        if (this.windowStart > windowStart) {
            this.windowStart = windowStart;
        }
    }

    public Long getWindowEnd() {
        return windowEnd;
    }

    public void setWindowEnd(Long windowEnd) {
        if (this.windowEnd < windowEnd) {
            this.windowEnd = windowEnd;
        }
    }
}
