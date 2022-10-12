/*
 * Copyright © 2021 M-iTrust (cto@m-itrust.com). Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */
package issue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class TestMiTrustExceptionMvcControllerAdvice {
	final MockEnvironment env = new MockEnvironment();

	final ThrowingController controller = new ThrowingController();

	private MockMvc mockMvc;

	@Before
	public void setup() {
		SomeExceptionMvcControllerAdvice someExceptionController = new SomeExceptionMvcControllerAdvice();

		this.mockMvc = MockMvcBuilders.standaloneSetup(someExceptionController, controller).build();
	}

	@Test
	public void checkRuntimeWrappingRestClientResponseException() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/fail"))
				.andExpect(MockMvcResultMatchers.status().is5xxServerError())
				.andExpect(MockMvcResultMatchers.content().string("someJson"));
	}
}
