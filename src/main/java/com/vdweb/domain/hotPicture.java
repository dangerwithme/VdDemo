package com.vdweb.domain;

import lombok.Data;

@Data
public class hotPicture {
    private long PictureID;
    private String PicturePath;
    private String PictureTitle;
    private long authorId;
    private String IconImage;
    private String userName;
}
