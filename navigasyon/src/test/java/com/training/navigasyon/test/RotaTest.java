package com.training.navigasyon.test;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.training.navigasyon.arac.Araba;
import com.training.navigasyon.arac.IArac;
import com.training.navigasyon.model.EYolTipi;
import com.training.navigasyon.model.Rota;
import com.training.navigasyon.model.Yol;

public class RotaTest {

	@Rule
	public ExpectedException exp = ExpectedException.none();
	private Rota rota;
	private Yol yol1;
	private Yol yol2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.rota = new Rota();
		this.yol1 = new Yol();
		this.yol1.setMesafe(100);
		this.yol1.setYolTipi(EYolTipi.ASFALT);
		this.yol1.setAci(90);
		this.rota.addYol(this.yol1);

		this.yol2 = new Yol();
		this.yol2.setMesafe(150);
		this.yol2.setYolTipi(EYolTipi.TOPRAK);
		this.yol2.setAci(100);
		this.rota.addYol(this.yol2);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddYol() {

		List<Yol> yolListesi = this.rota.getYolListesi();

		Assert.assertThat(yolListesi.size(),
		                  Matchers.is(2));

		Assert.assertThat(yolListesi.get(0),
		                  Matchers.is(this.yol1));

		Assert.assertThat(yolListesi.get(1),
		                  Matchers.is(this.yol2));
	}

	@Test
	public void testRotayiTakipEt() {
		IArac arac = new Araba();
		double rotayiTakipEt = this.rota.rotayiTakipEt(arac);
		System.out.println("ro : " + rotayiTakipEt);
		Assert.assertThat(rotayiTakipEt,
		                  Matchers.equalTo(21.95D));

	}

	@Test
	public void testRotayiTakipEtNullCheck() {
		Rota rota = new Rota();
		this.exp.expect(IllegalArgumentException.class);
		this.exp.expectMessage(Matchers.is("Arac null olamaz"));
		rota.rotayiTakipEt(null);

	}

}
