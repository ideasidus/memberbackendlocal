package edu.ssafy.etc;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// 싱글톤으로 만들고 Connection Pool 사용하기 => 완료
// 내가 이걸 아무것도 없는 zero에서 만들어 낼 수 있을까?
// 2025-03-25 기준 아직은 힘들다고 생각 -> 몇번 직접 짜보면 되지 않을까? 인출훈련 인출훈련
// 다 보면 알지만 인출하지 못한다.
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/memberdb?serverTimezone=UTC";
	private static final String USER = "ssafy";
	private static final String PASSWORD = "ssafy";
	private static final String driverClassName = "com.mysql.cj.jdbc.Driver";
	private HikariDataSource ds;
	private static DBUtil util = new DBUtil();

	private DBUtil() {
		HikariConfig config = new HikariConfig();
		config.setUsername(USER);
		config.setJdbcUrl(URL);
		config.setPassword(PASSWORD);
		config.setDriverClassName(driverClassName);
		config.addDataSourceProperty("profileSQL", "true"); // 쿼리 프로파일링 활성화

		config.setMaximumPoolSize(5);
		config.setMinimumIdle(1);
		config.setConnectionTimeout(1000 * 60 * 10); // DB사용을 위해 기다릴 시간
		config.setIdleTimeout(1000 * 60 * 3); // DB 사용이 종료된 후 커넥션이 닫히지 않고 기다릴시간 (MininumIdle 개 이상인 경우)

		ds = new HikariDataSource(config);
		// 싱글싱글톤이기 때문에 그냥 된다.
	}

	public static DBUtil getUtil() {
		return util;
	}

	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public void close(AutoCloseable... closeables) {
		for (AutoCloseable res : closeables) {
			try {
				res.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
