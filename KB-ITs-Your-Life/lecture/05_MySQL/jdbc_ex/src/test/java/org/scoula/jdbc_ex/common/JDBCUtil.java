package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // static Connection 객체
    // Connection은 DB 연결을 나타내는 객체
    static Connection conn = null;

    // static 초기화 블록. 클래스가 처음 로딩될 때 단 한 번 실행된다.
    static {
        try {
            // DB 연결 정보를 파일에서 불러오는 블록
            // Properties는 .properties 파일에서 설정을 읽어오는 데 사용된다.
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            // properties 파일에서 각각의 설정 값을 가져온다.
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");

            // JDBC 드라이버 클래스를 JVM에 로드한다.
            Class.forName(driver);
            // DriverManager.getConnection(...)은 실제 DB와의 연결을 생성한다.
            conn = DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DB 연결 제공 메소드
    // 다른 클래스에서 JDBCUtil.getConnection()으로 이 연결을 사용할 수 있게 제공한다.
    public static Connection getConnection() {
        return conn;
    }

    // 연결 종료 메소드
    // 연결이 열려 있으면 닫고, conn을 null로 초기화한다.
    public static void close() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
