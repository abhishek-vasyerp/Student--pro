package com.example.crud.advice;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.crud.dto.ApiResponse;
import com.example.crud.exception.ProjectAlreadyAssignmentException;
import com.example.crud.exception.StudentNotFoundException;

@RestControllerAdvice
public class allExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ApiResponse studentNotFoundExceptionHandling(StudentNotFoundException ex)
	{
		return new ApiResponse(404, "Not Found",ex.getMessage());
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ApiResponse nullPointerException(NullPointerException ex)
	{
		return new ApiResponse(500,"error",ex.getMessage());
	}
	
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ApiResponse ioException(IOException ex)
	{
		return new ApiResponse(500,"error",ex.getMessage());
	}
	
	
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ApiResponse bookIsAlreadyAssignedException(ProjectAlreadyAssignmentException ex)
	{
		return new ApiResponse(510,"error",ex.getMessage());
	}
	
	
	
}
