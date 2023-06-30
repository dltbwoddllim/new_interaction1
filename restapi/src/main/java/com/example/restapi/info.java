package com.example.restapi;

import jakarta.persistence.*;

@Entity
public class info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private Integer major;
    @Column(nullable = false)

    private Integer mbti;
    public info() {

    }

    public info(String nickname, Integer major, Integer mbti) {
        System.out.println("3333333");
        this.nickname = nickname;
        this.major = major;
        this.mbti = mbti;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getMbti() {
        return mbti;
    }

    public void setMbti(Integer mbti) {
        this.mbti = mbti;
    }

}
