package ukim.mk.finki.datamining.dto;

public class CountAggregate {
    public String key;
    public long count;

    @Override
    public String toString() {
        return "CountAccumulator{" +
                "category='" + key + '\'' +
                ", count=" + count +
                '}';
    }
}
