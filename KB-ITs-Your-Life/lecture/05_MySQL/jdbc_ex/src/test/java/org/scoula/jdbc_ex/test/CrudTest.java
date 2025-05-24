package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user를 등록한다.")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "INSERT INTO users(id, password, name, role) VALUES(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("user 목록을 추출한다.")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "SELECT * FROM users";
        // 파라미터 없는 단순 고정 쿼리이므로 PreparedStatement가 아닌 Statement 사용
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ) {
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("특정 user 검색한다.")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userid = "scoula";
        String sql = "SELECT * FROM users WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) { // 여기서 이미 SQL 전달
            pstmt.setString(1, userid);
            try (ResultSet rs = pstmt.executeQuery()) { // 여기서는 SQL 안 넣음 -> 이미 준비된 쿼리를 실행.
                if(rs.next()) {
                    System.out.println(rs.getString("name"));
                } else {
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("특정 user 수정한다.")
    @Order(4)
    public void updateUser() throws SQLException {
        String userid = "scoula";
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "스콜라 수정");
            pstmt.setString(2, userid);
            int count = pstmt.executeUpdate(); // executeUpdate()는 수정된 행의 수를 반환한다.
            // 테스트가 제대로 되었는지 검증
            // JUnit에서 제공하는 단정문(Assertion) 중 하나로,
            // 기대한 값과 실제 값이 같은지를 비교한다.
            // Assertions.assertEquals(에상값, 실제값);
            // 두 값이 다르면 테스트는 실패(Fail) 처리된다.
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("지정한 사용자를 삭제한다.")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql = "DELETE FROM users WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
}
