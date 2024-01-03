package com.blog.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String comment;

    private String id;
    private long commentId;
    public ResourceNotFoundException(String comment, String id, Long commentId) {
        super(String.format("%s not found with %s : '%s'", comment, id,
                commentId));
        this.comment=comment;
        this.id= id;
        this.commentId=commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getId() {
        return id;
    }

    public long getCommentId() {
        return commentId;
    }
}
