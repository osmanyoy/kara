package com.training.navigasyon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.training.pool.ConnectionPool;

public class NavigasyonDataCreator {
	public static void main(final String[] args) {
		ConnectionPool connectionPool = new ConnectionPool("org.h2.Driver",
		                                                   "jdbc:h2:~/test",
		                                                   5);
		DataSource dataSource = null;
		try {
			connectionPool.init();
			dataSource = connectionPool.getDataSource();
			try (Connection connection = dataSource.getConnection(); Statement stat = connection.createStatement()) {
				stat.execute("drop table rota");
				stat.execute("create table rota(id int primary key, name varchar(50),mesafe int, yoltipi int,aci int)");
				stat.execute("insert into rota values(1, 'rota1',100,0,90)");
				stat.execute("insert into rota values(2, 'rota1',120,0,90)");
				stat.execute("insert into rota values(3, 'rota1',110,0,80)");
				stat.execute("insert into rota values(4, 'rota1',10,0,90)");
				stat.execute("insert into rota values(5, 'rota1',10,1,10)");
				stat.execute("insert into rota values(6, 'rota1',20,0,20)");
				stat.execute("insert into rota values(7, 'rota1',10,0,30)");

				stat.execute("insert into rota values(8, 'rota2',10,0,90)");
				stat.execute("insert into rota values(9, 'rota2',20,0,80)");
				stat.execute("insert into rota values(10, 'rota2',10,0,70)");
				stat.execute("insert into rota values(11, 'rota2',100,0,90)");
				stat.execute("insert into rota values(12, 'rota2',50,1,110)");
				stat.execute("insert into rota values(13, 'rota2',60,0,20)");
				stat.execute("insert into rota values(14, 'rota2',10,0,30)");

				stat.execute("insert into rota values(15, 'rota3',100,0,70)");
				stat.execute("insert into rota values(16, 'rota3',50,1,90)");
				stat.execute("insert into rota values(17, 'rota3',50,1,110)");
				stat.execute("insert into rota values(18, 'rota3',90,1,200)");
				stat.execute("insert into rota values(19, 'rota3',40,0,300)");

				try (ResultSet rs = stat.executeQuery("select * from rota")) {
					while (rs.next()) {
						System.out.println(rs.getString("name"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
