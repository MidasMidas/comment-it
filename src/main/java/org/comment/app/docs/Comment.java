package org.comment.app.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Comment {

    @JsonProperty("id")
    private int id;
    @JsonProperty("block")
    private Block block;
    @JsonProperty("author")
    private String author;
    @JsonProperty("comment_time")
    private String commentTime;
    @JsonProperty("comment")
    private String comment;
}
