package com.whiteboard.whiteboard.config.random;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Setter
@Component
public class GenerateRandom {
    static int rand;

    public int randomId() {
        Random random = new Random();
        int randNum = random.nextInt(99097) + 1000;
        return randNum;
    }

}
