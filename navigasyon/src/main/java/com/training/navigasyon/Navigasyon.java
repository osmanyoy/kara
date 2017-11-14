package com.training.navigasyon;

import com.training.navigasyon.arac.Araba;
import com.training.navigasyon.arac.Bisiklet;
import com.training.navigasyon.arac.IArac;
import com.training.navigasyon.arac.Yaya;
import com.training.navigasyon.model.EYolTipi;
import com.training.navigasyon.model.Rota;
import com.training.navigasyon.model.Yol;

public class Navigasyon {
	public static void main(final String[] args) {

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
