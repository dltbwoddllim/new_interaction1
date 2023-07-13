package com.example.restapi.data.DTO;

public class registerDto {
    //회원가입 dto 코드 추가
    private String id;
    private String password;
    private String email;
    private String nickname;
    private Integer major;
    private Integer mbti;

    public registerDto(String id, String password, String nickname, Integer major, Integer mbti) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.major = major;
        this.mbti = mbti;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getMajor() {
        return major;
    }

    public Integer getMbti() {
        return mbti;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public void setMbti(Integer mbti) {
        this.mbti = mbti;
    }

    @Override
    public String toString() {
        return "registerDto{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", major=" + major +
                ", mbti=" + mbti +
                '}';
    }

}
