package com.whiteboard.whiteboard.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PhotoController {

    @GetMapping("/photo")
    public String photo() {
        return "PHOTO";
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
