package issue;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonXmlController {

	@GetMapping("/book")
	public Map<?, ?> book() {
		Map<Object, Object> map = new LinkedHashMap<>();
		map.put("Intro to Spring Boot", "Spring team");
		return map;
	}

}