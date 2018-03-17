package com.training.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
// @WebAppConfiguration
// @ContextConfiguration(initializers= {AppContextInit.class})
public class SpringtestApplicationTests {

	@Autowired
	private TestBean tb;

	@LocalServerPort
	private int localPort;

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockMvc mmvc;

	@Autowired
	private PersonService personService;

	@Autowired
	private TestRestTemplate restTemp;

	@Before
	public void before() {
		System.out.println("Before test : " + localPort + " tb : " + tb);
		// mmvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@After
	public void after() {
		System.out.println("After test");
	}

	@Test
	public void contextLoads() {
		String testMe = personService.testMe(10);
		assertNotEquals("ccc", testMe);

		try {

			String forObject = restTemp.getForObject("http://localhost:" + localPort + "/test/t1?age=10", String.class);
			assertThat(forObject).isEqualTo("hello");
			assertNotEquals("hello", forObject);

		} catch (Exception e) {
			fail("Olmadı" + e.getMessage());
		}

	}

	@Test
	public void test2() throws Exception{

			this.mmvc.perform(MockMvcRequestBuilders.get("/test/t1?age=10")).andDo(MockMvcResultHandlers.print())
			        .andExpect(MockMvcResultMatchers.status().isOk())
			        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("hello")));
			System.out.println("Bitti");
			// mmvc.perform(MockMvcRequestBuilders.get("/test/t1")).andExpect(MockMvcResultMatchers.status().is(400));

	}

}
