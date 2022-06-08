package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class user_pictureCollection {
    @TableId
    private  long collectionID;
    private long pictureID;
    private long userID;
}
