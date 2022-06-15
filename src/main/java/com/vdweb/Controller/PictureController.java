package com.vdweb.Controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.*;
import com.vdweb.domain.*;
import com.vdweb.utils.savePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private ShowPictureMapper showPictureMapper;

    @Autowired
    private pictureTagMapper pictureTagMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @GetMapping("getHotPicture")
    public Result getHotPicture(){
        return new Result(true,showPictureMapper.getHotPicture());
    }

    @GetMapping("getPictureTag/{pictureID}")
    public Result getPictureTag(@PathVariable long pictureID){
        return new Result(true,showPictureMapper.selectPictureTag(pictureID));
    }

    @GetMapping("getProduction/{userID}")
    public Result getProduction(@PathVariable long userID){
        return new Result(true,showPictureMapper.getProduction(userID));
    }

    @GetMapping("getCollection/{userID}")
    public Result getCollection(@PathVariable long userID){
        return new Result(true,showPictureMapper.getCollection(userID));
    }

    @DeleteMapping("/UserManage")
    public Result UserSelfDel(@RequestParam("pictureID")long pictureID, @RequestParam("userID")long userID){
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

    @PostMapping
    public Result insertPicture(long userID,MultipartFile picture,String pictureTitle){
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

    @GetMapping("/search")
    public Result getSearchResult(@RequestParam("condition")String condition){
        return new Result(true,showPictureMapper.searchPicture(condition));
    }

}
