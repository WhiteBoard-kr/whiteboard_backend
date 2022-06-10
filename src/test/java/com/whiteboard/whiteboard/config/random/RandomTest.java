package com.whiteboard.whiteboard.config.random;

import com.whiteboard.whiteboard.WhiteboardApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WhiteboardApplication.class})
public class RandomTest {

    @Autowired
    private GenerateRandom generateRandom;

    @BeforeEach
    public void beforeTest() {
        System.out.println("----BEFORE TEST----");
    }

    @Test
    public void randomTest() {
        System.out.println("- - - - - - - - - - - - - - -");
        int rand = generateRandom.randomId();
        System.out.println(generateRandom.randomId());
        assertTrue(rand >= 1000 && rand <= 100097);
    }

    @AfterEach
    public void afterTest() {
        System.out.println("----AFTER TEST----");
    }

}
