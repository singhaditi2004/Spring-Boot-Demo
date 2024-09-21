package com.springboot.first.springboot_demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.first.springboot_demo.entity.ErrorMessage;

@ControllerAdvice 
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(DepartmentNotFoundException.class )
   public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exce,WebRequest request) {
	   ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exce.getMessage());
	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
   }
}
