package com.training.navigasyon;

import javax.sql.DataSource;

import com.training.navigasyon.rota.RotaManager;
import com.training.pool.ConnectionPool;

public class Navigasyon {
	private ConnectionPool connectionPool = null;
	private RotaManager manager = null;

	public void init() {
		this.connectionPool = new ConnectionPool("org.h2.Driver",
		                                         "jdbc:h2:~/test",
		                                         5);
		DataSource dataSource = null;
		try {
			this.connectionPool.init();
			dataSource = this.connectionPool.getDataSource();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(2);
		}

		this.manager = new RotaManager(dataSource);

	}

	public ConnectionPool getConnectionPool() {
		return this.connectionPool;
	}

	public RotaManager getManager() {
		return this.manager;
	}

}
