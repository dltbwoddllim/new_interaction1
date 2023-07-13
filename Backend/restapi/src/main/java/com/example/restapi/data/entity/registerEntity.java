package com.example.restapi.data.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class registerEntity {

    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)

    private String email;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private Integer major;
    @Column(nullable = false)
    private Integer mbti;

    public registerEntity(String id, String password, String nickname, Integer major, Integer mbti) {
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

    public String getEmail() { return email; }

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
}
