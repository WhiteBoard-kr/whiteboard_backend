package com.whiteboard.whiteboard.web.user;

import com.whiteboard.whiteboard.config.random.GenerateRandom;
import com.whiteboard.whiteboard.config.random.json.JsonStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class PhotoController {

    private final GenerateRandom generateRandom;
    @GetMapping("/photo/{number_of_photos}")
    public Object photo(@PathVariable("number_of_photos") int number_of_photos) {
        JsonStatus jsonStatus = new JsonStatus();

        //맵을 두 개 둬서 하나는 인트 배열
        //이따 해봐 준혁 화이팅!
        if (number_of_photos >= 10000) {
            jsonStatus.status_code = "400";
            jsonStatus.message = "Too Many Photos Required";

            return jsonStatus;
        }
        int[] randList = generateRandom.randomList(number_of_photos);
        String randStr = "";
        for (int i = 0; i < number_of_photos; i++) {
            if (i == 0) {
                randStr += randList[0];
            }
            else
                randStr = randStr + ", " + randList[i];
        }

        jsonStatus.status_code = "200";
        jsonStatus.message = "Success";
        return jsonStatus;
    }

    @GetMapping("/photo/liked")
    public String liked_photo() {
        return "LIKED PHOTO";
    }

    @PostMapping("/photo/like")
    public String like_photo() {
        return "LIKE PHOTO";
    }

}
