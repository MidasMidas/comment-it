package org.comment.app.docs;

import java.util.HashMap;
import java.util.Map;

public class CommentFile {
    private String version;
    private String createTime;
    private String lastUpdateTime;

    private Map<Block,Comment> commentMap=new HashMap<>();

}
