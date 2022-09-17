package org.comment.app.docs;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Indicator {
    @JsonProperty("line")
    private int line;
    @JsonProperty("letter")
    private int letter;

    public boolean isAfter(Indicator indicator){
        if(this.line>indicator.line){
            return true;
        }
        if(this.line==indicator.line){
            return this.letter>indicator.letter;
        }
        return false;
    }


}
