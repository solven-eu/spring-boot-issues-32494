package issue;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThrowingController {

	@GetMapping("/fail")
	public Map<?, ?> book() {
		throw new IllegalArgumentException("ouch");
	}

}