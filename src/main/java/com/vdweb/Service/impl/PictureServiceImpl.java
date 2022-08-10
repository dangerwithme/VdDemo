package com.vdweb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.CollectionMapper;
import com.vdweb.Mapper.PictureMapper;
import com.vdweb.Mapper.ShowPictureMapper;
import com.vdweb.Mapper.pictureTagMapper;
import com.vdweb.Service.PictureService;
import com.vdweb.domain.*;
import com.vdweb.utils.ConditionToRegularExpressionForSearch;
import com.vdweb.utils.savePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private ShowPictureMapper showPictureMapper;

    @Autowired
    private pictureTagMapper pictureTagMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<hotPicture> getHotPictureInfo() {
        return showPictureMapper.getHotPicture();
    }

    @Override
    public List<hotPicture> getPersonalWorks(long userID) {
        return showPictureMapper.getWorks(userID);
    }

    @Override
    public List<hotPicture> getCollectionWorks(long userID) {
        return showPictureMapper.getCollection(userID);
    }

    @Override
    public Result delPersonalWorks(long pictureID, long userID) {
        int date = 0;
        boolean flag = false;
        Picture p = pictureMapper.selectOne(new QueryWrapper<Picture>().eq("pictureID", pictureID));
        File f = new File("D:\\graduationproject\\vddemp\\public\\picture\\picture\\" + p.getPicturePath());
        if (f.exists())
            flag = f.delete();
        if(flag) {
            date = pictureMapper.delete(new QueryWrapper<Picture>().eq("pictureID", pictureID).eq("userID", userID));
            pictureTagMapper.delete(new QueryWrapper<pictureTag>().eq("pictureID", pictureID));
            collectionMapper.delete(new QueryWrapper<user_pictureCollection>().eq("pictureID", pictureID));
        }
        return new Result(true,date);
    }

    @Override
    public Result PostPicture(long userID, MultipartFile picture, String pictureTitle) {
        String fileName = String.valueOf(userID+ System.currentTimeMillis());
        String flag = new savePicture().upLoadFile(picture,fileName);
        if(flag!=null){
            Picture p = new Picture(flag,userID,pictureTitle);
            pictureMapper.insert(p);
            long pictureID = pictureMapper.selectOne(new QueryWrapper<Picture>().eq("PicturePath",flag).eq("UserID",userID).eq("PictureTitle",pictureTitle)).getPictureID();
            System.out.println(pictureID);
            return new Result(true,pictureID);
        }else{
            return new Result(false,"请重新尝试");
        }
    }

    @Override
    public List<hotPicture> EasySearch(String condition) {
        condition = new ConditionToRegularExpressionForSearch().action(condition);
        System.out.println(condition);
        return showPictureMapper.searchPicture(condition);
    }

    @Override
    public boolean addPictureView(long pictureID) {
        return pictureMapper.addPictureView(pictureID);
    }

    @Override
    public List<hotPicture> userTagIDSearchPicture(long tagID) {
        return showPictureMapper.useTagSearchPicture(tagID);
    }

}
