package com.vdweb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.CollectionMapper;
import com.vdweb.Service.CollectionService;
import com.vdweb.domain.user_pictureCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public int delCollection(long pictureID, long userID) {
        return collectionMapper.delete(new QueryWrapper<user_pictureCollection>().eq("pictureID",pictureID).eq("userID",userID));
    }

    @Override
    public int insertCollection(long pictureID, long userID) {
        user_pictureCollection collection = new user_pictureCollection(pictureID,userID);
        return collectionMapper.insert(collection);
    }

    @Override
    public boolean IsItCollection(long pictureID, long userID) {
        return collectionMapper.selectOne(new QueryWrapper<user_pictureCollection>().eq("pictureID",pictureID).eq("userID",userID))!=null;
    }
}
