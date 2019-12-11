package com.od.network;

/**
 * Created by lvkang on 2019-12-06
 */
public class LoginInfo {

    /**
     * token : eyJ1aWQiOjkwOCwidGltZXN0YW1wIjoxNTc1NjQwNTMxLCJzaWduIjoiNzk5OTgwNmRmMTZiOTE3YzUxYmRkYjEzODdmNzdhMTMifQ==
     * nickname : 5pyo5a2Q5ZCV55qE5bCP5bCP5Y+3
     * mobile : 17681896992
     * uid : 908
     */

    private String token;
    private String nickname;
    private String mobile;
    private int uid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
