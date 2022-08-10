package com.vdweb.Service;

import com.vdweb.domain.Result;
import com.vdweb.domain.User;

import java.util.List;

public interface UserService {
    User getUserInfo(Integer id);
    Result login(String userName,String password);
    boolean EmailIsUsing(String userEmail);
    int updateEmail(String newEmail,String oldEmail);
    int updatePassword(String password,long userID);
    Result Register(String userName,String password,String userEmail);
    int updateUserinfo(User user);
    int deleteUser(long userID);
    List<User> EasySearch(String condition);
}
