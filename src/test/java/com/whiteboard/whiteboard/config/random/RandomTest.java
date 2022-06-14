package com.whiteboard.whiteboard.config.random;

import com.whiteboard.whiteboard.WhiteboardApplication;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        System.out.println("- - - - RANDOM - ID - - - -");
        int rand = generateRandom.randomId();
        System.out.println(generateRandom.randomId());
        assertTrue(rand >= 1000 && rand <= 100097);
    }

    @Test
    public void randomListTest() {
        System.out.println("- - - - RANDOM - LIST - - - -");
        int photo_amount = 10;
        int[] randList = generateRandom.randomList(photo_amount);
        for (int i = 0; i < randList.length; i++) {
            System.out.println(randList[i]);
        }
        assertTrue(photo_amount == randList.length);

    }

    @AfterEach
    public void afterTest() {
        System.out.println("----AFTER TEST----");
    }

}
