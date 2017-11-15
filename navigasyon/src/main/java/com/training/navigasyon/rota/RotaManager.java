package com.training.navigasyon.rota;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.training.navigasyon.model.EYolTipi;
import com.training.navigasyon.model.Rota;
import com.training.navigasyon.model.Yol;

public class RotaManager {
	private DataSource dataSource;

	public RotaManager(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<String> getAllRotas() {
		List<String> names = new ArrayList<>();
		try (Connection connection = this.dataSource.getConnection();
		        Statement stat = connection.createStatement();
		        ResultSet rs = stat.executeQuery("select distinct name from rota")) {
			while (rs.next()) {
				names.add(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return names;
	}

	public Rota getRota(final String name) {
		Rota rota = new Rota();
		EYolTipi[] values = EYolTipi.values();
		try (Connection connection = this.dataSource.getConnection();
		        Statement stat = connection.createStatement();
		        ResultSet rs = stat.executeQuery("select * from rota where name='" + name + "'")) {
			while (rs.next()) {
				Yol yol = new Yol();
				yol.setMesafe(rs.getInt(3));
				yol.setYolTipi(values[rs.getInt(4)]);
				yol.setAci(rs.getInt(5));
				rota.addYol(yol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rota;
	}

}
