package com.vdweb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Override
    public PageInfo<pictureComment> getManagePageComment(Integer pageNum) {
        PageHelper.startPage(pageNum,7);
        List<pictureComment> pictureComments = pictureCommentMapper.selectManageComment();
        System.out.println(pictureComments);
        PageInfo<pictureComment> pictureCommentPageInfo = new PageInfo<>(pictureComments);
        return pictureCommentPageInfo;
    }

    @Override
    public boolean delComment(long CommentID, long parentID) {
        if(parentID==0)
            return pictureCommentMapper.deleteById(CommentID)>0
                &&pictureCommentMapper.delete(new QueryWrapper<pictureComment>().eq("parentID",CommentID))>0;
        return pictureCommentMapper.deleteById(CommentID)>0;
    }
}
