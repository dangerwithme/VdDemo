package com.vdweb;

import com.vdweb.Service.PictureService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
@RequiredArgsConstructor
class DemoApplicationTests {

    @Autowired
    PictureService pictureService;

    @Test
    void test1(){
        System.out.println(pictureService.EasySearch("acx?雪沙"));;
    }

}
