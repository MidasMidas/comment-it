package org.comment.app.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class Block {
    @JsonProperty("start_index")
    private Indicator startIndex;
    @JsonProperty("end_index")
    private Indicator endIndex;

    public boolean isContain(Indicator target){
        return target.isAfter(startIndex)&&endIndex.isAfter(target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(startIndex, block.startIndex) && Objects.equals(endIndex, block.endIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startIndex, endIndex);
    }
}
