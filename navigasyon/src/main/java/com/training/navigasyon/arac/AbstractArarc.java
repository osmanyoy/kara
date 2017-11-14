package com.training.navigasyon.arac;

import com.training.navigasyon.model.EYolTipi;
import com.training.navigasyon.model.Yol;

public abstract class AbstractArarc implements IArac {

	private int ortalamaHiz;

	private int aciDonHiz;

	public AbstractArarc(final int ortalamaHiz, final int aciDonHiz) {
		if (ortalamaHiz < 1) {
			throw new IllegalArgumentException("ortalama hiz 0 veya negatif olamaz");
		}
		this.ortalamaHiz = ortalamaHiz;
		this.aciDonHiz = aciDonHiz;
	}

	@Override
	public double ileriGit(final Yol yol) {
		if (yol == null) {
			return 0;
		}
		EYolTipi yolTipi = yol.getYolTipi();
		return ((double) yol.getMesafe() / (double) this.ortalamaHiz) * yolTipi.getKatsayi();
	}

	@Override
	public double don(final Yol yol) {
		if (yol.getAci() == null) {
			return 0D;
		}
		return (double) yol.getAci() / this.aciDonHiz;
	}

}
