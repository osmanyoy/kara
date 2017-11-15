package com.training.navigasyon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import com.training.navigasyon.arac.Araba;
import com.training.navigasyon.arac.Bisiklet;
import com.training.navigasyon.arac.IArac;
import com.training.navigasyon.arac.Yaya;
import com.training.navigasyon.model.EYolTipi;
import com.training.navigasyon.model.Rota;
import com.training.navigasyon.model.Yol;
import com.training.navigasyon.rota.RotaManager;
import com.training.pool.ConnectionPool;

public class Navigasyon {
	public static void main(final String[] args) {
		ConnectionPool connectionPool = new ConnectionPool("org.h2.Driver",
		                                                   "jdbc:h2:~/test",
		                                                   5);
		DataSource dataSource = null;
		try {
			connectionPool.init();
			dataSource = connectionPool.getDataSource();
			try (Connection connection = dataSource.getConnection(); Statement stat = connection.createStatement()) {
				stat.execute("create table rota(id int primary key, name varchar(50),mesafe int, yoltipi int,aci int)");
				stat.execute("insert into rota values(1, 'rota1',100,0,90)");
				stat.execute("insert into rota values(2, 'rota1',120,0,90)");
				stat.execute("insert into rota values(3, 'rota1',110,0,80)");
				stat.execute("insert into rota values(4, 'rota1',10,0,90)");
				stat.execute("insert into rota values(5, 'rota1',10,1,10)");
				stat.execute("insert into rota values(6, 'rota1',20,0,20)");
				stat.execute("insert into rota values(7, 'rota1',10,0,30)");
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

		RotaManager manager = new RotaManager(dataSource);
		List<String> allRotas = manager.getAllRotas();
		System.out.println(allRotas);

		Rota rota2 = manager.getRota(allRotas.get(0));

		Rota rota = new Rota();
		Yol yol1 = new Yol();
		yol1.setMesafe(100);
		yol1.setYolTipi(EYolTipi.ASFALT);
		yol1.setAci(90);
		rota.addYol(yol1);

		Yol yol2 = new Yol();
		yol2.setMesafe(150);
		yol2.setYolTipi(EYolTipi.TOPRAK);
		rota.addYol(yol2);
		IArac araba = new Araba();
		IArac bisiklet = new Bisiklet();
		IArac yaya = new Yaya();

		System.out.println("Rotada geçen zaman (Araba) : " + rota.rotayiTakipEt(araba));
		System.out.println("Rotada geçen zaman (Bisiklet) : " + rota.rotayiTakipEt(bisiklet));
		System.out.println("Rotada geçen zaman (Yaya) : " + rota.rotayiTakipEt(yaya));
	}
}
