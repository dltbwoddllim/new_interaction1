package com.example.restapi.controller;
import com.example.restapi.data.entity.UserInfoEntity;
import com.example.restapi.data.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
public class UserInfoController {

    private final UserInfoRepository infoRepository;

    @Autowired
    public UserInfoController(UserInfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @PostMapping ("/userinfo")
    public ResponseEntity<String> createUser(@RequestBody UserInfoEntity information) {
        // You can access the values received from the request in the 'user' object

        String nickname = information.getNickname();
        Integer major = information.getMajor();
        Integer mbti = information.getMbti();

        // Output the received values
        System.out.println("Nickname: " + nickname);
        System.out.println("Major: " + major);
        System.out.println("MBTI: " + mbti);
        //닉네임 같을 경우 에러 발생. - nickname은 unique.
        infoRepository.save(information);

        // Return a success response
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }

}
