package com.whiteboard.whiteboard.config.random;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Setter
@Component
public class GenerateRandom {

    public int randomId() {
        Random random = new Random();
        int randNum = random.nextInt(99097) + 1000;
        return randNum;
    }
    public int[] randomList(int amount) {
        int[] idList = new int[amount];

        for (int i = 0; i < idList.length; i++) {
            idList[i] = randomId();
        }
        return idList;
    }

}
