package org.springframework.samples.mvc.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// // 如果在controller内部有对应的@ExceptionHandler，则被处理的exception不会到这里不会到这里了！
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public @ResponseBody String handleBusinessException(BusinessException ex) {
		return "Handled BusinessException @GlobalExceptionHandler! ";
	}

	@ExceptionHandler
	public @ResponseBody String handleBusinessException(IllegalStateException ex) {
		// 如果在controller内部有对应的@ExceptionHandler，则不会到这里了！
		return "Handled IllegalStateException @GlobalExceptionHandler! ";
	}

	@ExceptionHandler
	public @ResponseBody String handleException(Exception ex) {
		
		return "Handled All other Exception @GlobalExceptionHandler! ";
	}
}
