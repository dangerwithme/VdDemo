package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class pictureComment {
    @TableId
    private Long commentID;
    private Long commentUserID;
    private User commentUser;
    private String content;
    private Long pictureID;
    private Long parentID;
    private List<pictureComment> children;

    public pictureComment() {
    }

    public pictureComment(Long commentUserID, Long pictureID, Long parentID, String content) {
        this.commentUserID = commentUserID;
        this.pictureID = pictureID;
        this.parentID = parentID;
        this.content = content;
    }
}
