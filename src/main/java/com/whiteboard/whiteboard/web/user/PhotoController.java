package com.whiteboard.whiteboard.web.user;

import com.whiteboard.whiteboard.config.random.GenerateRandom;
import com.whiteboard.whiteboard.config.random.json.JsonTransducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PhotoController {

    private final GenerateRandom generateRandom;

    @GetMapping("/photo/{number_of_photos}")
    @ResponseBody
    public Object photo(@PathVariable("number_of_photos") int number_of_photos) {
        JsonTransducer jsonTransducer = new JsonTransducer();

        if (number_of_photos >= 10000) {
            jsonTransducer.status_code = "400";
            jsonTransducer.message = "Too Many Photos Required";

            return jsonTransducer;
        }
        int[] randList = generateRandom.randomList(number_of_photos);
        String randStr = "";

        for (int i = 0; i < randList.length; i++) {
            if (i == 0)
                randStr = randStr + randList[0];

            else
                randStr = randStr + ", " + randList[i];
        }

        jsonTransducer.status_code = "200";
        jsonTransducer.message = "Success";
        jsonTransducer.photo_id = randStr;
        jsonTransducer.number_of_photos = Integer.toString(number_of_photos);
        return jsonTransducer;
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
