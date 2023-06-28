package com.example.restapi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userinfoController {
    @PostMapping ("/userinfo")
    public ResponseEntity<String> createUser(@RequestBody information information) {
        // You can access the values received from the request in the 'user' object
        String nickname = information.getNickname();
        String major = information.getMajor();
        String mbti = information.getMbti();
        String hobbies = information.getHobbies();

        // Output the received values
        System.out.println("Nickname: " + nickname);
        System.out.println("Major: " + major);
        System.out.println("MBTI: " + mbti);
        System.out.println("Hobbies: " + hobbies);

        // Return a success response
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
    }
}
