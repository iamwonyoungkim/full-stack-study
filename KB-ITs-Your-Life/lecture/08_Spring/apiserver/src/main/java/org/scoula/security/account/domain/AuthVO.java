package org.scoula.security.account.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
// GrantedAuthority: Spring Security에서 정의하는 권한 관련 인터페이스
public class AuthVO implements GrantedAuthority {
    private String username;
    private String auth;

    @Override
    public String getAuthority() {
        return auth;
    }
}
