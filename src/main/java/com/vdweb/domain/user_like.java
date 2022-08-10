package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class user_like {
    @TableId
    private Long likeID;
    private Long userID;
    private Long pictureID;

    public user_like(long userID, long pictureID) {
        this.userID = userID;
        this.pictureID = pictureID;
    }
}
