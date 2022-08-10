package com.vdweb.Service;

public interface FollowService {
    boolean FollowSomeOne(long followID, long followedID);
    boolean IsItFollowing(long followID,long followedID);
    boolean UnFollowSomeOne(long followID, long followedID);
}
