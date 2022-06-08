package com.vdweb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vdweb.domain.Picture;
import com.vdweb.domain.hotPicture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureMapper extends BaseMapper<Picture> {

}
