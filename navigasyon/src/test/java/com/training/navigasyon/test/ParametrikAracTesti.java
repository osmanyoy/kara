package com.training.navigasyon.test;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.training.navigasyon.arac.Araba;
import com.training.navigasyon.model.EYolTipi;
import com.training.navigasyon.model.Yol;

@RunWith(Parameterized.class)
public class ParametrikAracTesti {

	@Parameter(value = 0)
	public Yol yol;

	@Parameter(value = 1)
	public Double result;

	@Parameters(name = "{index} test : {0} r:{1} ")
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { new Yol(10,
		                                                EYolTipi.ASFALT,
		                                                null),
		                                        0.1D },
		                                      { new Yol(100,
		                                                EYolTipi.TOPRAK,
		                                                null),
		                                        1.3D }

		});
	}

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
		double ileriGit = araba.ileriGit(this.yol);
		Assert.assertThat(ileriGit,
		                  Matchers.equalTo(this.result));

	}

}
