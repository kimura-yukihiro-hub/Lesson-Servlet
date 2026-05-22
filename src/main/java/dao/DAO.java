package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	public Connection getConnection() throws Exception {
		// 1. MySQLのJDBCドライバークラスをロード
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. データベースURL、ユーザー名、パスワードを指定して直接接続を取得
		String url = "jdbc:mysql://localhost:3306/book";
		String username = "root";
		String password = "21424Aisiteru";
		
		return DriverManager.getConnection(url, username, password);
	}
}
