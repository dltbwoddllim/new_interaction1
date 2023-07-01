package com.example.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class PartnerController {

    private final InfoRepository infoRepository;

    @Autowired
    public PartnerController(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @GetMapping("/partner")
    public ResponseEntity<java.lang.String> searchUser(@RequestParam Integer major, @RequestParam Integer mbti) {

        // Output the received values
        List<info> result = infoRepository.findByMajorAndMbti(major, mbti);
        for (info info : result) {
            System.out.println(info.getNickname().toString());
            System.out.println(info.getMajor().toString());
            System.out.println(info.getMbti().toString());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse;
        try {
            jsonResponse = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            // Handle the exception if serialization fails
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during serialization.");
        }
        // Return a success response
        return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
    }
}