package org.scoula.member.mapper;

import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;

public interface MemberMapper {
    MemberVO get(String username); // join해서 전체 정보 추출. 권한 정보 체크.

    MemberVO findByUsername(String username); // id 중복 체크 시 사용. 권한 정보 체크 X.

    int insert(MemberVO member); // 회원 정보 추가

    int insertAuth(AuthVO auth); // 회원 권한 정보 추가
}
