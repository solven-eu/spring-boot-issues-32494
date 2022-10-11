package issue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = JsonXmlController.class)
@ContextConfiguration(classes = { JsonXmlController.class
// , DisableJacksonXmlAutoConfiguration.class
})
public class TestJacksonXmlController {

	final JsonXmlController controller = new JsonXmlController();

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testJsonAsDefault() throws Exception {
		String expected = "{'Intro to Spring Boot': 'Spring team'}";

		mockMvc.perform(MockMvcRequestBuilders.get("/book"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(expected.replace('\'', '"')));
	}
}
