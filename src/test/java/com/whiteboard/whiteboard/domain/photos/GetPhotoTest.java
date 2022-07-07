package com.whiteboard.whiteboard.domain.photos;

import com.whiteboard.whiteboard.WhiteboardApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WhiteboardApplication.class})
public class GetPhotoTest {
    @Autowired
    private GetPhoto getPhoto;

    @Test
    public void apiKeyTest() {
        String key = this.getPhoto.api_key;
        System.out.println(key);
        System.out.println("================================");
    }
}
