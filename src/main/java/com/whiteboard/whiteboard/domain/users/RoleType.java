package com.whiteboard.whiteboard.domain.users;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@RequiredArgsConstructor
public enum RoleType implements GrantedAuthority {
    USER(ROLES.USER),
    ADMIN(ROLES.ADMIN);

    public static class ROLES {
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
    }

    private final String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
