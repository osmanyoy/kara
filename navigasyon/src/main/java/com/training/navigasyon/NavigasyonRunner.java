package com.training.navigasyon;

import java.util.List;
import java.util.Scanner;

import com.training.navigasyon.arac.Araba;
import com.training.navigasyon.arac.Bisiklet;
import com.training.navigasyon.arac.IArac;
import com.training.navigasyon.arac.Yaya;
import com.training.navigasyon.model.Rota;

public class NavigasyonRunner {
	public static void main(final String[] args) {
		Navigasyon navigasyon = new Navigasyon();
		navigasyon.init();

		Scanner scanner = new Scanner(System.in);
		List<String> allRotas = navigasyon.getManager()
		                                  .getAllRotas();
		int index = 1;
		for (String rotaName : allRotas) {
			System.out.println("" + index + "-" + rotaName);
			index++;
		}
		System.out.println("Seçiminiz : ");
		int nextInt = scanner.nextInt();
		String rotaSelected = allRotas.get(nextInt - 1);

		Rota rota = navigasyon.getManager()
		                      .getRota(rotaSelected);

		IArac araba = new Araba();
		IArac bisiklet = new Bisiklet();
		IArac yaya = new Yaya();

		System.out.println("Rotada geçen zaman (Araba) : " + rota.rotayiTakipEt(araba));
		System.out.println("Rotada geçen zaman (Bisiklet) : " + rota.rotayiTakipEt(bisiklet));
		System.out.println("Rotada geçen zaman (Yaya) : " + rota.rotayiTakipEt(yaya));
	}

}
