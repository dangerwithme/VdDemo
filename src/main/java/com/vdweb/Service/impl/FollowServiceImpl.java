package com.vdweb.Service.impl;

import com.vdweb.Mapper.followMapper;
import com.vdweb.Service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private followMapper followMapper;

    @Override
    public boolean FollowSomeOne(long followID, long followedID) {
        return followMapper.insert(followID,followedID);
    }

    @Override
    public boolean IsItFollowing(long followID, long followedID) {
        return followMapper.selectOne(followID,followedID)!=null;
    }

    @Override
    public boolean UnFollowSomeOne(long followID, long followedID) {
        return followMapper.deleteOne(followID,followedID);
    }
}
