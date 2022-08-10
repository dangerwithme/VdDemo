package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Picture {
    @TableId
    private Long PictureID;
    private String PicturePath;
    private long UserID;
    private String PictureTitle;
    private int PictureView;
    private int PictureLike;

    public Picture() {
    }

    public Picture(String picturePath, long userID, String pictureTitle) {
        PicturePath = picturePath;
        UserID = userID;
        PictureTitle = pictureTitle;
    }
}
