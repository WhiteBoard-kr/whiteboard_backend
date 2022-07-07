package com.whiteboard.whiteboard.web;

import com.whiteboard.whiteboard.web.photo.PhotoController;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhotoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PhotoController photoController;

    @BeforeEach
    public void beforeEach() {
        System.out.println("- - - - BEFORE - TEST - - - -");
    }

    @Test
    public void getRandomPhoto() {
        int numberOfPhotos = 10;
        String url = "http://127.0.0.1:" + port + "/photo" + numberOfPhotos;

    }
}
