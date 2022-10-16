package org.comment.app.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.comment.app.util.AppUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    private List<Comment> commentList =new ArrayList<>();


    public void addComment(int start, int end, String comment) {
        int maxId = 0;
        for (Comment cmt : commentList) {
            if (maxId < cmt.getId()) {
                maxId = cmt.getId();
            }
        }
        String updateTime = AppUtil.getCurrentTimeString();
        Comment newCMT = new Comment();
        newCMT.setId(maxId + 1);
        newCMT.setRange(new Range());
        newCMT.getRange().setFrom(start);
        newCMT.getRange().setTo(end);
        newCMT.setComment(comment);
        newCMT.setAuthor(AppUtil.getUser());
        newCMT.setCommentTime(updateTime);
        commentList.add(newCMT);
        this.lastUpdateTime = updateTime;
    }

    public void saveComment(String cmtFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(cmtFilePath), this);
    }
}
