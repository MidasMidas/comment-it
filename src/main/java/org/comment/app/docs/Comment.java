package org.comment.app.docs;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private String author;
    private String commentTime;
    private String comment;
}
