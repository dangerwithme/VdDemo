package com.vdweb;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vdweb.Mapper.PictureMapper;
import com.vdweb.domain.Picture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private PictureMapper pictureMapper;

    @Test
    void contextLoads() {
        System.out.println(pictureMapper.selectList(null));
    }

    @Test
    void test1(){
    }

}
