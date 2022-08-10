package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class pictureTag {
    @TableId
    private Long pictureTagID;
    private Long pictureID;
    private Long tagID;

    public pictureTag() {
    }

    public pictureTag(long pictureID, long tagID) {
        this.pictureID = pictureID;
        this.tagID = tagID;
    }
}
