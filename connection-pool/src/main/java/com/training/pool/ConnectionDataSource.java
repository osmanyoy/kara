package com.training.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class ConnectionDataSource implements DataSource {

	private ConnectionPool connectionPool;

	public ConnectionDataSource(final ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	public void setLogWriter(final PrintWriter out) throws SQLException {

	}

	public void setLoginTimeout(final int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public <T> T unwrap(final Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(final Class<?> iface) throws SQLException {
		return false;
	}

	public Connection getConnection() throws SQLException {
		try {
			Connection connection = this.connectionPool.getConnection();
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Connection getConnection(final String username, final String password) throws SQLException {
		return null;
	}

}
