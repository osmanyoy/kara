package com.training.navigasyon.test;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.training.navigasyon.arac.Araba;
import com.training.navigasyon.model.EYolTipi;
import com.training.navigasyon.model.Yol;

public class AracTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testArabaIleriGit() {
		Araba araba = new Araba();
		double ileriGitNull = araba.ileriGit(null);
		Assert.assertThat(ileriGitNull,
		                  Matchers.equalTo(0D));

		Yol yol = new Yol();
		yol.setMesafe(10);
		yol.setYolTipi(EYolTipi.ASFALT);
		double ileriGit = araba.ileriGit(yol);
		Assert.assertThat(ileriGit,
		                  Matchers.equalTo(0.1D));

		yol.setYolTipi(EYolTipi.TOPRAK);
		yol.setMesafe(100);
		ileriGit = araba.ileriGit(yol);
		Assert.assertThat(ileriGit,
		                  Matchers.equalTo(1.3D));

	}

	@Test
	public void testArabaDon() {
		Araba araba = new Araba();
		Yol yol = new Yol();
		yol.setMesafe(10);
		yol.setYolTipi(EYolTipi.ASFALT);
		yol.setAci(90);
		double donmeHizi = araba.don(yol);
		Assert.assertThat(donmeHizi,
		                  Matchers.equalTo(9D));

	}

}
