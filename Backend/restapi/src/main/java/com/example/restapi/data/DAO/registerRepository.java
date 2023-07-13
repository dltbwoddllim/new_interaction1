package com.example.restapi.data.DAO;

import com.example.restapi.data.DTO.registerDto;
import org.springframework.data.repository.CrudRepository;

public interface registerRepository extends CrudRepository<registerDto, Integer> {
}
