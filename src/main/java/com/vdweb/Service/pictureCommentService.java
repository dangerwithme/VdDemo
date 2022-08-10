package com.vdweb.Service;

import com.github.pagehelper.PageInfo;
import com.vdweb.domain.pictureComment;


public interface pictureCommentService {
    PageInfo<pictureComment> getCurrentPictureComment(long pictureID,Integer pageNum,Integer pageSize);
    int postComment(long userID, long pictureID, long parentID,String content);
}
