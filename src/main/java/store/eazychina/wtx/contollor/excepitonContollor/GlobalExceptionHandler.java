package store.eazychina.wtx.contollor.excepitonContollor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import store.eazychina.wtx.exception.SSMException;

//@ControllerAdvice
 public class GlobalExceptionHandler {

//	public static final String DEFAULT_ERROR_VIEW = "/error";
//	 
//	@ExceptionHandler(value = SSMException.class)
//	public ModelAndView defaultErrorHandler(HttpServletRequest req, SSMException e) throws Exception {
//		System.out.println("捕获异常");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", e);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName(DEFAULT_ERROR_VIEW);
//		return mav;
//	}

}
