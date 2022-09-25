package org.comment.app.dto;

import lombok.Data;
import org.comment.app.docs.Comment;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentDTO {
    List<Comment> comments=new ArrayList<>();

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public String getCommentString(){
        List<String> cmts=new ArrayList<>();

        for(Comment cmt:this.comments){
            StringBuilder stb=new StringBuilder();
            stb.append("author:").append(cmt.getAuthor()).append("\n");
            stb.append("comment_time:").append(cmt.getCommentTime()).append("\n");
            stb.append("from:").append(cmt.getRange().getFrom()).append("  to:").append(cmt.getRange().getTo()).append("\n");
            stb.append("comment:").append(cmt.getComment()).append("\n");
            cmts.add(stb.toString());
        }
       return String.join("\n",cmts);
    }
}
