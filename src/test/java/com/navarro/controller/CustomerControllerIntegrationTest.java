package com.navarro.controller;

import static org.hamcrest.Matchers.containsString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @since 2019-06-08
 * @author Francisco Navarro
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCustomerController_getCustomers() throws Exception {
		this.mockMvc.perform(get("/customers")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("name")))
				.andExpect(content().string(containsString("phone")))
				.andExpect(content().string(containsString("phoneCountryCode")))
				.andExpect(content().string(containsString("state")))
				.andExpect(content().string(containsString("country")))
				.andExpect(content().string(containsString("id")));
	}

	@Test
	public void testCustomerController_getCustomerByQuery() throws Exception {
		this.mockMvc.perform(get("/customers/search?country=258")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("name")))
				.andExpect(content().string(containsString("phone")))
				.andExpect(content().string(containsString("phoneCountryCode")))
				.andExpect(content().string(containsString("state")))
				.andExpect(content().string(containsString("country")))
				.andExpect(content().string(containsString("id")));
	}
}
