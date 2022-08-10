package com.vdweb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vdweb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * " +
            "from user where userName " +
            "REGEXP #{condition}")
    List<User> searchUser(@Param("condition")String condition);

    @Select("select userName,userIconImage from user where userID = #{userID}")
    User getCommentUser(@Param("userID")long userID);
}
