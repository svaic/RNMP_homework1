package ukim.mk.finki.datamining.pojo;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;

@JsonSerialize
public class Sensor {
    public String key;
    public Long value;
    public Timestamp timestamp;

    @Override
    public String toString() {
        return "ukim.mk.finki.datamining.pojo.Sensor{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
