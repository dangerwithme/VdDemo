package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class user_pictureCollection {
    @TableId
    private  long collectionID;
    private long pictureID;
    private long userID;

    public user_pictureCollection(long pictureID, long userID) {
        this.pictureID = pictureID;
        this.userID = userID;
    }
}
