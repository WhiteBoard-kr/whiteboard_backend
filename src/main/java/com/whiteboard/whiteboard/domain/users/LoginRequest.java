package com.whiteboard.whiteboard.domain.users;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {

    private String name;
    private String password;
}
