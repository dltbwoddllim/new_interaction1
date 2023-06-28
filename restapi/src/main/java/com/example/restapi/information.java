package com.example.restapi;

public class information {
    private String nickname;
    private String major;
    private String mbti;
    private String hobbies;

    public information() {
        // Default constructor
    }

    public information(String nickname, String major, String mbti, String hobbies) {
        this.nickname = nickname;
        this.major = major;
        this.mbti = mbti;
        this.hobbies = hobbies;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
