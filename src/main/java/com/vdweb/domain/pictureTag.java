package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class pictureTag {
    @TableId
    private long pictureTagID;
    private long pictureID;
    private long tagID;

    public pictureTag() {
    }

    public pictureTag(long pictureID, long tagID) {
        this.pictureID = pictureID;
        this.tagID = tagID;
    }
}
