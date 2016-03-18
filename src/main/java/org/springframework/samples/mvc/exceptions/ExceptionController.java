package org.springframework.samples.mvc.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

	@RequestMapping("/exception")
	public @ResponseBody String exception() {
		throw new IllegalStateException("Sorry!");
	}

	@RequestMapping("/global-exception")
	public @ResponseBody String businessException() throws BusinessException {
		throw new BusinessException();
	}

	@RequestMapping("/other-exception")
	public @ResponseBody String OtherException() throws Exception {
		throw new Exception();
	}
	
	// !!!! 这里优先处理，完成结束，不会再到global exception handler。除非再抛出exception。
	// handle方法可以带参数，使用Exception类，标示所有的exception子类都能处理。但是到这里会被@ExceptionHandler annotation内声明的类限制。
	@ExceptionHandler({BusinessException.class,IllegalStateException.class})
	public @ResponseBody String handle(Exception e) {
		
		return "IllegalStateException handled! @Controller";
	}

}
