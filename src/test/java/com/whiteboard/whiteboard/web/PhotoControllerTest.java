package com.whiteboard.whiteboard.web;

import com.whiteboard.whiteboard.web.user.PhotoController;
import org.junit.Test;
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

    @Test
}
