package com.vdweb.Service;

public interface UserLikeService {
    boolean delLike(long pictureID, long userID);
    boolean insertLike(long pictureID, long userID);
    boolean IsItLike(long pictureID,long userID);
}
