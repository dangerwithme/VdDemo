package com.vdweb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vdweb.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}
