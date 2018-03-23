package com.training.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.training.spring.rest.MyRest;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Profile("test")
@AutoConfigureMockMvc
public class SpringbootApplicationTests {

	@Autowired
	private MyRest myRest;

	@Autowired
	private TestRestTemplate restTemplate;

	// @Autowired
	private MockMvc mockMvc;

	@Autowired
	private RestOperations ro;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void beforeTest() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test_MyRest_method1_senario1() {
		String method1 = myRest.method1();
		// Assert.assertEquals("veli", method1);
		assertThat(method1).isEqualTo("Impl2 test1");
	}

	@LocalServerPort
	private int port;
	
	@Test
	public void test_MyRest_method1_senario2() {

		String forObject = ro.getForObject("http://127.0.0.1:" + port + "/root/test/m",
		                                   String.class);
		assertThat(forObject).isEqualTo("Impl2 test1");
	}

	@Test
	public void test_MyRest_method1_senario3() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/test"))
		       .andDo(MockMvcResultHandlers.print())
		       .andExpect(MockMvcResultMatchers.status()
		                                       .isOk())
		       .andExpect(MockMvcResultMatchers.content()
		                                       .string(Matchers.containsString("OK")));
	}

}








