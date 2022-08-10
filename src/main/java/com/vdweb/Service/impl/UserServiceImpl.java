package com.vdweb.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.vdweb.Mapper.UserMapper;
import com.vdweb.Service.UserService;
import com.vdweb.domain.Result;
import com.vdweb.domain.User;
import com.vdweb.utils.ConditionToRegularExpressionForSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public Result login(String userName, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Object o = userMapper.selectOne(wrapper.eq("userEmail",userName).eq("userpassword",password));
        if (o!=null) {
            return new Result(true, o);
        }else{
            return new Result(false,false);
        }
    }

    @Override
    public boolean EmailIsUsing(String userEmail) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("userEmail",userEmail))!=null;
    }

    @Override
    public int updateEmail(String newEmail, String oldEmail) {
        return userMapper.update(null,new UpdateWrapper<User>().set("userEmail",newEmail).eq("userEmail",oldEmail));
    }

    @Override
    public int updatePassword(String password, long userID) {
        return userMapper.update(null,new UpdateWrapper<User>().set("userpassword",password).eq("userID",userID));
    }

    @Override
    public Result Register(String userName, String password, String userEmail) {
        User user = new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        if (userMapper.selectOne(new QueryWrapper<User>().eq("userEmail",userEmail))==null) {
            userMapper.insert(user);
            return new Result(true, userMapper.update(null, new UpdateWrapper<User>().set("userpassword", password).eq("userEmail", userEmail)));
        }else{
            return new Result(true,false);
        }
    }

    @Override
    public int updateUserinfo(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteUser(long userID) {
        return userMapper.deleteById(userID);
    }

    @Override
    public List<User> EasySearch(String condition) {
        condition = new ConditionToRegularExpressionForSearch().action(condition);
        System.out.println(condition);
        return userMapper.searchUser(condition);
    }
}
