package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId
    private Long userID;
    private String userName;
    private String userEmail;
    private int userAge;
    private int userPrivilege;
    private String userIntroduction;
    private String userIconImage;

    public User() {
    }

    public User(long userID, String userName, int userAge, String userIntroduction) {
        this.userID = userID;
        this.userName = userName;
        this.userAge = userAge;
        this.userIntroduction = userIntroduction;
    }

    public User(long userID, String userName, int userAge, String userIntroduction,String userIconImage) {
        this.userID = userID;
        this.userName = userName;
        this.userAge = userAge;
        this.userIntroduction = userIntroduction;
        this.userIconImage = userIconImage;
    }

    public User(String userName, String userIconImage) {
        this.userName = userName;
        this.userIconImage = userIconImage;
    }
}
