package com.whiteboard.whiteboard.domain.user;

import com.whiteboard.whiteboard.WhiteboardApplication;
import com.whiteboard.whiteboard.domain.users.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WhiteboardApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    //테스트 후
    @After
    public void cleanup() {
        //데이터배이스 초기화
        userRepository.deleteAll();
    }

    //테스트
    @Test
    public void call_regist_user() {
        int id = 999;
        String name = "Test Name";
        String password = "Test Password";

    }


}
