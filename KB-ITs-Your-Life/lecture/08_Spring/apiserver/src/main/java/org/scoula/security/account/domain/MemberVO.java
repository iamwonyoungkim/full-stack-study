package org.scoula.security.account.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String username;
    private String password;
    private String email;
    private Date regDate;
    private Date updateDate;

    // user는 무조건 Auth를 가지고 있어야 한다.
    private List<AuthVO> authList; // 권한 목록, join 처리 필요
}
