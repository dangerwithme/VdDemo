package com.vdweb.Controller;

import com.vdweb.Mapper.pictureTagMapper;
import com.vdweb.domain.Result;
import com.vdweb.domain.pictureTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PictureTags")
public class PictureTagController {

    @Autowired
    private pictureTagMapper pictureTagMapper;

    @PostMapping
    public Result insertTag(@RequestParam("pictureID")long pictureID, @RequestParam("tagID")long tagID){
        return new Result(true,pictureTagMapper.insert(new pictureTag(pictureID,tagID)));
    }
}
