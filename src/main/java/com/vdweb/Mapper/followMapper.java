package com.vdweb.Mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface followMapper {

    @Insert("insert into user_follow VALUES(default,#{followID},#{followedID})")
    boolean insert(@Param("followID")long followID,@Param("followedID")long followedID);

    @Select("select * from user_follow where userID_follower=#{followID} and userID_following=#{followedID}")
    Object selectOne(@Param("followID")long followID,@Param("followedID")long followedID);

    @Delete("delete from user_follow where userID_follower=#{followID} and userID_following=#{followedID}")
    boolean deleteOne(@Param("followID")long followID,@Param("followedID")long followedID);
}
