package com.growdane.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author growdane@gmail.com
 * @date 2019-12-23 19:53
 */

@Data
@ToString
@AllArgsConstructor
public class User {
    private String ID;
    private String userName;
    private String userPassword;
    private String userMobile;
    private String userAddress;
    private String userBirthday;

    public User(String userName, String userPassword, String userMobile, String userAddress, String userBirthday) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMobile = userMobile;
        this.userAddress = userAddress;
        this.userBirthday = userBirthday;
    }
}
