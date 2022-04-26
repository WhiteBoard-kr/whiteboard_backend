package com.whiteboard.whiteboard.web.user;

import com.whiteboard.whiteboard.domain.users.*;
import com.whiteboard.whiteboard.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;


    @PostMapping("/user/join")
    @ResponseStatus(HttpStatus.CREATED)
    public Long join(@RequestBody JoinRequest user) {
        return userRepository.save(User.builder()
                .name(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(Collections.singletonList(RoleType.USER))
                .build()).getId();
    }

    @PostMapping("/user/login")
    public ArrayList<String> login(@RequestBody LoginRequest userRequest) {
        User member = userRepository.findByName(userRequest.getName())
                .orElseThrow(() -> new IllegalArgumentException("Account Not Found"));

        if (!passwordEncoder.matches(userRequest.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("Wrong Password");
        }

        return new ArrayList<>(
                Arrays.asList(
                        jwtTokenProvider.createToken(
                                member.getId().toString(),
                                member.getRoles().stream().map(roleType -> roleType.toString()).collect(Collectors.toList())),
                        jwtTokenProvider.createRefreshToken(member.getId().toString())
                )
        );
    }
}
