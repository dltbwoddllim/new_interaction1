package com.example.restapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class userinfoController {

    private final InfoRepository infoRepository;

    @Autowired
    public userinfoController(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @PostMapping ("/userinfo")
    public ResponseEntity<String> createUser(@RequestBody info information) {
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
