package com.vdweb.Controller;

import com.vdweb.Service.PictureTagService;
import com.vdweb.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PictureTags")
public class PictureTagController {

    @Autowired
    private PictureTagService pictureTagService;

    @PostMapping
    public Result insertTag(@RequestParam("pictureID")long pictureID, @RequestParam("tagID")long tagID){
        return new Result(true,pictureTagService.insertPictureTag(pictureID,tagID));
    }

}
