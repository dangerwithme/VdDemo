package com.vdweb.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vdweb.Mapper.pictureCommentMapper;
import com.vdweb.Service.pictureCommentService;
import com.vdweb.domain.pictureComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pictureCommentServiceImpl implements pictureCommentService {

    @Autowired
    private pictureCommentMapper pictureCommentMapper;

    @Override
    public PageInfo<pictureComment> getCurrentPictureComment(long pictureID,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<pictureComment> pictureComments = pictureCommentMapper.selectComment(pictureID);
        PageInfo<pictureComment> pictureCommentPageInfo = new PageInfo<>(pictureComments);
        return pictureCommentPageInfo;
    }

    @Override
    public int postComment(long userID,long pictureID,long parentID,String content){
        return pictureCommentMapper.insert(new pictureComment(userID,pictureID,parentID,content));
    }
}
