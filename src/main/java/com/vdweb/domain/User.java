package com.vdweb.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId
    private long userID;
    private String userName;
    private String userEmail;
    private int userAge;
    private String userIntroduction;
    private String userIconImage;
}
