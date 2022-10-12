/*
 * Copyright © 2021 M-iTrust (cto@m-itrust.com). Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 */
package issue;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SomeExceptionMvcControllerAdvice {

	// https://stackoverflow.com/questions/40361298/reactive-spring-does-not-support-httpservletrequest-as-parameter-in-rest-endpoin
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> handleThrowable(HttpServletRequest request, Throwable t) {
		Map<Object, Object> map = new LinkedHashMap<>();
		map.put("Intro to Spring Boot", "Spring team");
		return ResponseEntity.internalServerError().body(map);
	}
}
