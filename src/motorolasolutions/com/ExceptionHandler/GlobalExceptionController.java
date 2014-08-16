package motorolasolutions.com.ExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
		return "Error";
	}
}
