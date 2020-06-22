package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	private static Connection conn = null;

	public static Connection GetConnection() {
		// se for nulo tem que escrever um c�digo para conectar com o banco
		if (conn == null) {
			try {
				// pegamos as propriedades do banco com o c�digo de loadProperties
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				// Para conectar com o banco
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	//SQLException te obriga a tratar a excess�o, te obrigando a colocar try e catch,
	//ent�o para contornar isso usamos a nossa excess�o que � do time runtimeException, s� quando for necess�rio
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	// abre arquivo, l� os dados e gravalo no tipo properties
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs); // o load faz a leitura do arquivo props apontado pelo inputstream fs e vai
							// guardar dentro do props
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}

	}
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	public static void closetResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
