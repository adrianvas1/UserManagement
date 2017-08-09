//package com.users.exception;
//
//import org.hibernate.service.spi.ServiceException;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.NoHandlerFoundException;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//@EnableWebMvc
//@ControllerAdvice
//public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(Throwable.class)
//    @ResponseBody
//    String handleControllerException(HttpServletRequest req, Throwable ex) {
//        if (ex instanceof DataIntegrityViolationException) {
//            return "A user with this e-mail already exists. Please try another e-mail.";
//        } else {
//            return "";
//        }
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        Map<String, String> responseBody = new HashMap<>();
//        responseBody.put("path", request.getContextPath());
//        responseBody.put("message", "The URL you have reached is not in service at this time (404).");
//        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
//    }
//}