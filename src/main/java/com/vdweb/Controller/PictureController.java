package com.vdweb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.*;
import com.vdweb.domain.Picture;
import com.vdweb.domain.Result;
import com.vdweb.domain.pictureTag;
import com.vdweb.domain.user_pictureCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private ShowPictureMapper showPictureMapper;

    @Autowired
    private TagMapper tagMapper;

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
        return new Result(true,tagMapper.selectPictureTag(pictureID));
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

}
