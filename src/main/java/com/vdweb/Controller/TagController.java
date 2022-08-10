package com.vdweb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.TagMapper;
import com.vdweb.Service.TagService;
import com.vdweb.domain.Result;
import com.vdweb.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public Result getTag(){
        return new Result(true,tagService.postPictureGetTag());
    }

    @GetMapping("getPictureTag/{pictureID}")
    public Result getPictureTag(@PathVariable long pictureID){
        return new Result(true,tagService.getCurrentPictureTag(pictureID));
    }

    @PutMapping
    public Result addTag(@RequestParam String tagName,@RequestParam long pictureID){
        return new Result(true,tagService.addTagAndAddPictureTag(pictureID,tagName));
    }

}
