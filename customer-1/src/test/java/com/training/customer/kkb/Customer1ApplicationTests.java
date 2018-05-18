package com.training.customer.kkb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment=WebEnvironment.MOCK)
//@DataJpaTest
@WebMvcTest(MyTestRest.class)
public class Customer1ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private MyService mservice;

	@Test
	public void contextLoads() throws Exception {
		MyObject myObject = new MyObject();

		myObject.setName("os");
		myObject.setSurname("mos");

		BDDMockito.given(mservice.getMyObject(1))
		          .willReturn(myObject);
		MockHttpServletResponse response = mvc.perform(get("/t/hello/1").accept(MediaType.APPLICATION_JSON_VALUE))
		                                      .andReturn()
		                                      .getResponse();
		Assertions.assertThat(response.getStatus()).isEqualTo(200);
		Assertions.assertThat(response.getContentAsString()).isEqualTo("hello os");
		
	}

}
