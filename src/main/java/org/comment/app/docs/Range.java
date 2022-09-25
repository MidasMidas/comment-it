package org.comment.app.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Range {

    @JsonProperty("from")
    private int from;
    @JsonProperty("to")
    private int to;

    @Override
    public String toString() {
        return "Range{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
