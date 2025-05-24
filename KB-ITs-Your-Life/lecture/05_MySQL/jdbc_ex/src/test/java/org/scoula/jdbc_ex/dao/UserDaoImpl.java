package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    Connection conn = JDBCUtil.getConnection();

    // USERS 테이블 관련 SQL 명령어
    private String USER_LIST = "SELECT * FROM users";
    private String USER_GET = "SELECT * FROM users WHERE id = ?";
    private String USER_INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
    private String USER_UPDATE = "UPDATE users SET name = ?, role = ? WHERE id = ?";
    private String USER_DELETE = "DELETE FROM users WHERE id = ?";

    // 회원 등록
    @Override
    public int create(UserVO user) throws SQLException {
        try(PreparedStatement pstmt = conn.prepareStatement(USER_INSERT)) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getRole());
            return pstmt.executeUpdate();
        }
    }

    // ResultSet -> UserVO 객체 하나로 바꾸는 변환기
    // SELECT로 가져온 ResultSet은 테이블 형식 데이터다.
    // 이걸 Java에서 쓰기 쉽게, UserVO 객체로 변환하는 함수가 map()이다.
    private UserVO map(ResultSet rs) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setRole(rs.getString("role"));
        return user;
    }

    // 회원 목록 조회
    @Override
    public List<UserVO> getList() throws SQLException {
        List<UserVO> userList = new ArrayList<UserVO>();
        Connection conn = JDBCUtil.getConnection();
        try(PreparedStatement pstmt = conn.prepareStatement(USER_LIST);
        ResultSet rs = pstmt.executeQuery()) {
            while(rs.next()) {
                UserVO user = map(rs);
                userList.add(user);
            }
        }
        return userList;
    }

    // 회원 정보 조회
    @Override
    // Optional을 사용해서 값이 없을 때 NullPointerException이 터지지 않도록 한다.
    public Optional<UserVO> get(String id) throws SQLException {
        try(PreparedStatement pstmt = conn.prepareStatement(USER_GET)) {
            pstmt.setString(1, id);
            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    // 회원 수정
    @Override
    public int update(UserVO user) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try(PreparedStatement pstmt = conn.prepareStatement(USER_UPDATE)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getRole());
            pstmt.setString(3, user.getId());
            return pstmt.executeUpdate();
        }
    }

    // USERS 테이블 관련 CRUD 메서드
    // 회원 삭제
    @Override
    public int delete(String id) throws SQLException {
        try(PreparedStatement pstmt = conn.prepareStatement(USER_DELETE)) {
            pstmt.setString(1, id);
            return pstmt.executeUpdate();
        }
    }
}
