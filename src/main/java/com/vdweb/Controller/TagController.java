package com.vdweb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.TagMapper;
import com.vdweb.domain.Result;
import com.vdweb.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagMapper tagMapper;

    @GetMapping
    public Result getTag(){
        return new Result(true,tagMapper.selectList(null));
    }

}
