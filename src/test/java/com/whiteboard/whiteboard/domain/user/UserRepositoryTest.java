package com.whiteboard.whiteboard.domain.user;

import com.whiteboard.whiteboard.WhiteboardApplication;
import com.whiteboard.whiteboard.domain.users.User;
import com.whiteboard.whiteboard.domain.users.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WhiteboardApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    //테스트 후
    @AfterEach
    public void cleanup() {
        //데이터배이스 초기화
        userRepository.deleteAll();
    }

    //테스트
    @Test
    public void register_user() {

        String name = "Test Name";
        String password = "Test Password";

        userRepository.save(User.builder()
                .name(name)
                .password(password)
                .build());

        Optional<User> resultUser = userRepository.findByName(name);
        assertTrue(resultUser.isPresent());

        User user = resultUser.get();
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

}
