package com.vdweb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.PictureMapper;
import com.vdweb.Mapper.UserLikeMapper;
import com.vdweb.Service.UserLikeService;
import com.vdweb.domain.user_like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLikeServiceImpl implements UserLikeService {

    @Autowired
    private UserLikeMapper userLikeMapper;

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public boolean delLike(long pictureID, long userID) {
        return userLikeMapper.delete(new QueryWrapper<user_like>().eq("pictureID",pictureID).eq("userID",userID))==1&&pictureMapper.minusPictureLike(pictureID);
    }

    @Override
    public boolean insertLike(long pictureID, long userID) {
        user_like userLike = new user_like(userID,pictureID);
        return userLikeMapper.insert(userLike)==1&&pictureMapper.addPictureLike(pictureID);
    }

    @Override
    public boolean IsItLike(long pictureID, long userID) {
        return userLikeMapper.selectOne(new QueryWrapper<user_like>().eq("pictureID",pictureID).eq("userID",userID))!=null;
    }
}
