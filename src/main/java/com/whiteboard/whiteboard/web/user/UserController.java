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

import java.util.*;
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
    public Map login(@RequestBody LoginRequest userRequest) {
        User member = userRepository.findByName(userRequest.getName())
                .orElseThrow(() -> new IllegalArgumentException("Account Not Found"));

        if (!passwordEncoder.matches(userRequest.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("Wrong Password");
        }

        Map result = new HashMap<String, String>();
        result.put("access_token", jwtTokenProvider.createToken(
                member.getId().toString(),
                member.getRoles().stream().map(roleType -> roleType.toString()).collect(Collectors.toList()))
        );
        result.put("refresh_token", jwtTokenProvider.createRefreshToken(
                member.getId().toString())
        );

        return result;
    }
}
