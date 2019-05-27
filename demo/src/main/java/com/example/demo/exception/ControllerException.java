package com.example.demo.exception;

import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<?> noSuchElementException() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
	}

	@ExceptionHandler({DataIntegrityViolationException.class,TransactionSystemException.class,ConstraintViolationException.class,NullPointerException.class})
	public final ResponseEntity<?> dataIntegrityViolationException() {
		return ResponseEntity.badRequest().body(" Os parametros digitados são inválidos");
	}

}