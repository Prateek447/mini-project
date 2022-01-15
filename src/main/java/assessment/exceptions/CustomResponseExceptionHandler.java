package assessment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler{
       
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<Object> hadleUserAlreadyExistException(Exception exp, WebRequest req){
		return new ResponseEntity<Object>("Employee Already Exist in the database",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> hadleUserNotFoundException(Exception exp, WebRequest req){
		return new ResponseEntity<Object>("User Not Found !",HttpStatus.NOT_FOUND);
	}
}
