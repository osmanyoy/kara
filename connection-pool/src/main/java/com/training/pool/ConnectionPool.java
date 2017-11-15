package com.training.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.sql.DataSource;

public class ConnectionPool {
	private BlockingQueue<Connection> connections = new ArrayBlockingQueue<Connection>(1000);

	private String driverName;
	private String connectionString;
	private int connectionCount;

	public ConnectionPool(final String driverName, final String connectionString, final int connectionCount) {
		super();
		this.driverName = driverName;
		this.connectionString = connectionString;
		this.connectionCount = connectionCount;
	}

	public void init() throws Exception {
		Class.forName(this.driverName);
		for (int i = 0; i < this.connectionCount; i++) {
			Connection conn = DriverManager.getConnection(this.connectionString);
			ConnectionProxy connectionProxy = new ConnectionProxy(conn,
			                                                      this);
			this.connections.add(connectionProxy);
		}

	}

	public Connection getConnection() throws InterruptedException {
		return this.connections.take();
	}

	public DataSource getDataSource() {
		return new ConnectionDataSource(this);
	}

	void releaseConnection(final Connection connection) {
		this.connections.add(connection);
	}
}
