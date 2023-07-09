package com.example.restapi.data.repository;
import com.example.restapi.data.entity.UserInfoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//info 부분이 테이블 명.
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Integer> {
    List<UserInfoEntity> findAllById(Integer id);
    List<UserInfoEntity> findByMajorAndMbti(Integer major, Integer mbti);
}