package com.example.restapi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//info 부분이 테이블 명.
public interface InfoRepository extends CrudRepository<info, Integer> {
    List<info> findAllById(Integer id);
    List<info> findByMajorAndMbti(Integer major, Integer mbti);
}