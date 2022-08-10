package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class hotPicture {
    @TableId
    private Long PictureID;
    private String PicturePath;
    private String PictureTitle;
    private long authorId;
    private String IconImage;
    private String userName;
    private int PictureView;
    private int PictureLike;
}
