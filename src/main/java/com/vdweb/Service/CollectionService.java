package com.vdweb.Service;

public interface CollectionService {
    int delCollection(long pictureID, long userID);
    int insertCollection(long pictureID, long userID);
    boolean IsItCollection(long pictureID,long userID);
}
