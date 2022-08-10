package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Tag {
    @TableId
    private Long tagID;
    private String tagName;
    private Long tagHot;

    public Tag() {
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }
}
