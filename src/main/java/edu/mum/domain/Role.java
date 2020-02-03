package edu.mum.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role  implements GrantedAuthority {
    ADMIN,
    OWNER,
    RENTER;

    @Override
    public String getAuthority() {
        return name();
    }
}
