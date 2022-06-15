package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Tag {
    @TableId
    private long tagID;
    private String tagName;

    public Tag() {
    }
}
