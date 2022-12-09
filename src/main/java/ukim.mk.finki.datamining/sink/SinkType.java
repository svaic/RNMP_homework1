package ukim.mk.finki.datamining.sink;

public enum SinkType {
    SENSORS("sensors"),
    RESULT1("result1"),
    RESULT2("result2");

    private final String sinkType;

    SinkType(String sinkType) {
        this.sinkType = sinkType;
    }

    public String getSinkType() {
        return sinkType;
    }
}
