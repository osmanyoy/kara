package com.training.navigasyon.model;

import java.util.ArrayList;
import java.util.List;

import com.training.navigasyon.arac.IArac;

public class Rota {
	private List<Yol> yolListesi = new ArrayList<>();

	public void addYol(final Yol yol) {
		this.yolListesi.add(yol);
	}

	public List<Yol> getYolListesi() {
		return new ArrayList<>(this.yolListesi);
	}

	public double rotayiTakipEt(final IArac arac) {
		if (arac == null) {
			throw new IllegalArgumentException("Arac null olamaz");
		}
		double toplamGecenSure = 0D;
		for (Yol yol : this.yolListesi) {
			toplamGecenSure += arac.ileriGit(yol) + arac.don(yol);
		}
		return toplamGecenSure;
	}
}
