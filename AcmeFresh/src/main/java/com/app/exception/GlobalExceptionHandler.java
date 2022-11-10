package com.app.exception;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	static File file ;
	static PrintWriter pw ;
	
	static {
		try {
			file = new File("error.txt");
			file.createNewFile();
			pw =new PrintWriter(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> dataValidataionExceptionHandler(MethodArgumentNotValidException e,WebRequest req) throws IOException {
		
		pw.write(e.getMessage());
		pw.close();
		pw.flush();
		
		MyErrorDetails err = new MyErrorDetails() ;
		
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(req.getDescription(false));
		err.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails() ;
		
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(e.getMessage());
		err.setMessage(req.getDescription(false));

		pw.write(e.getMessage());
		pw.close();
		pw.flush();
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InstallationOrdersExeption.class)
	public ResponseEntity<MyErrorDetails> installationOrdersExceptionHandler(InstallationOrdersExeption e,WebRequest req) {
		
		pw.write(e.getMessage());
		pw.close();
		pw.flush();
		
		MyErrorDetails err = new MyErrorDetails() ;
		
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(e.getMessage());
		err.setMessage(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PlantException.class)
	public ResponseEntity<MyErrorDetails> plantExceptionHandler(PlantException e,WebRequest req) {
		
		pw.write(e.getMessage());
		pw.close();
		pw.flush();
		
		MyErrorDetails err = new MyErrorDetails() ;
		
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(e.getMessage());
		err.setMessage(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NFTException.class)
	public ResponseEntity<MyErrorDetails> nftExceptionHandler(NFTException e,WebRequest req) {
		
		pw.write(e.getMessage());
		pw.close();
		pw.flush();
		
		MyErrorDetails err = new MyErrorDetails() ;
		
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(e.getMessage());
		err.setMessage(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PolyHouseTypeException.class)
	public ResponseEntity<MyErrorDetails> polyHouseExceptionHandler(PolyHouseTypeException e,WebRequest req) {
		
		pw.write(e.getMessage());
		pw.close();
		pw.flush();
		
		MyErrorDetails err = new MyErrorDetails() ;
		
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(e.getMessage());
		err.setMessage(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	

	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception se, WebRequest req){
		
		pw.write(se.getMessage());
		pw.close();
		pw.flush();
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
