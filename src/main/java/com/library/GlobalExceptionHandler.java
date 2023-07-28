package com.library;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.exception.AdminAlreadyExistException;
import com.library.exception.AdminIdNotFoundException;
import com.library.exception.BookAlreadyExistsException;
import com.library.exception.ErrorInformation;
import com.library.exception.NoAdminFoundException;
import com.library.exception.NoBookFoundException;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(BookAlreadyExistsException.class)
    
	public @ResponseBody ErrorInformation BookAlreadyExistsExceptionInfo(BookAlreadyExistsException e,HttpServletRequest req) {
		 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}
	
@ExceptionHandler(NoBookFoundException.class)
    
	public @ResponseBody ErrorInformation NoBookFoundExceptionInfo(NoBookFoundException e,HttpServletRequest req) {
		 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		 return erinfo;
	}

@ExceptionHandler(AdminAlreadyExistException.class)

public @ResponseBody ErrorInformation AdminAlreadyExistExceptionInfo(AdminAlreadyExistException e,HttpServletRequest req) {
	 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	 return erinfo;
}

@ExceptionHandler(AdminIdNotFoundException.class)

public @ResponseBody ErrorInformation AdminIdNotFoundExceptionInfo(AdminIdNotFoundException e,HttpServletRequest req) {
	 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	 return erinfo;
}

@ExceptionHandler(NoAdminFoundException.class)

public @ResponseBody ErrorInformation Info(NoAdminFoundException e,HttpServletRequest req) {
	 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	 return erinfo;
}
@ExceptionHandler(com.library.exception.ResourceDBException.class)
public @ResponseBody ErrorInformation ResourceDBException(com.library.exception.ResourceDBException e,HttpServletRequest req) {
	 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	 return erinfo;
}

	
}
    
	
