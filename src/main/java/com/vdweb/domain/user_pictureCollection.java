package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class user_pictureCollection {
    @TableId
    private  Long collectionID;
    private Long pictureID;
    private Long userID;

    public user_pictureCollection(long pictureID, long userID) {
        this.pictureID = pictureID;
        this.userID = userID;
    }
}
