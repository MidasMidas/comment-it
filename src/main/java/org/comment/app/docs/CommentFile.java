package org.comment.app.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CommentFile {

    @JsonProperty("version")
    private String version;
    @JsonProperty("create_time")
    private String createTime;

    @JsonProperty("last_update_time")
    private String lastUpdateTime;

    @JsonProperty("comment_list")
    private List<Comment> commentList;

}
