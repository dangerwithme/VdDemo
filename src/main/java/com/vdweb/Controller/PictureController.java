package com.vdweb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.PictureMapper;
import com.vdweb.Mapper.TagMapper;
import com.vdweb.Mapper.ShowPictureMapper;
import com.vdweb.domain.Picture;
import com.vdweb.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pictures")
public class PictureController {

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private ShowPictureMapper showPictureMapper;

    @Autowired
    private TagMapper tagMapper;

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

}
