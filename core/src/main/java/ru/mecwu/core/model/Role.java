package ru.mecwu.core.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Cafe, USER;

    @Override
    public String getAuthority() {
        return null;
    }
}
