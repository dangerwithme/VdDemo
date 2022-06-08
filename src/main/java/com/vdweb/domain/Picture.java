package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Picture {
    private long PictureID;
    private String PicturePath;
    private long UserID;
    private String PictureTitle;
    private int PictureView;
    private int PictureLike;
}
