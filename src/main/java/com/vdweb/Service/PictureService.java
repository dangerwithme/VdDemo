package com.vdweb.Service;

import com.github.pagehelper.PageInfo;
import com.vdweb.domain.Picture;
import com.vdweb.domain.Result;
import com.vdweb.domain.hotPicture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {
    List<hotPicture> getHotPictureInfo();
    List<hotPicture> getPersonalWorks(long userID);
    List<hotPicture> getCollectionWorks(long userID);
    Result delPersonalWorks(long pictureID, long userID);
    Result PostPicture(long userID, MultipartFile picture, String pictureTitle);
    List<hotPicture> EasySearch(String condition);
    boolean addPictureView(long pictureID);
    List<hotPicture> userTagIDSearchPicture(long tagID);
    PageInfo<Picture> getAllPictureByMange(Integer pageNum);
    boolean deletePicture(long pictureID);
}
