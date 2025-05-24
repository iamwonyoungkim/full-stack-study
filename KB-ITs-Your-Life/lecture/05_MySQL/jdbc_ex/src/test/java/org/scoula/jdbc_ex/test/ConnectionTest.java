package org.scoula.jdbc_ex.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

public class ConnectionTest {
  // 이 Methodrk JUnit 테스트임을 나타낸다.
  @Test
  // 테스트 이름을 출력할 때 사람이 읽기 좋게 표시한다.
  @DisplayName("jdbc_ex 데이터베이스에 접속한다.")
  // Test Method
  public void testConnection() throws SQLException, ClassNotFoundException {
    // MySQL JDBC 드라이버를 JVM 메모리에 로드한다.
    // 최신 JDBC는 생략해도 동작하나, 명시적으로 쓰는 것이 학습이나 구버전 환경에선 안전하다.
    Class.forName("com.mysql.cj.jdbc.Driver");
    // DB 연결 시도
    String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
    String id = "scoula";
    String password = "1234";
    // 위 정보로 DB 연결 시도. 성공하면 conn 객체가 생성된다.
    Connection conn = DriverManager.getConnection(url, id, password);
    // 연결 성공 메시지
    System.out.println("DB 연결 성공");
    // 연결 종료
    // DB 리소스를 반드시 닫아야 한다. 안 닫으면 메모리 누수, 연결 과다로 인해 에러 발생 가능.
    conn.close();
  }

  @Test
  @DisplayName("jdbc_ex에 접속한다.(자동 닫기)")
  public void testConnection2() throws SQLException {
    try(Connection conn = JDBCUtil.getConnection()) {
      System.out.println("DB 연결 성공");
    }
  }

}