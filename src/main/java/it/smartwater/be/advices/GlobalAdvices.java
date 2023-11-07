package it.smartwater.be.advices;

import it.smartwater.be.exceptions.globals.BadRequestException;
import it.smartwater.be.exceptions.globals.NoContentException;
import it.smartwater.be.exceptions.globals.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalAdvices {

    @ResponseBody
    @ExceptionHandler(NoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    String noContentExceptionHandler(NoContentException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundExceptionHandler(NotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String badRequestExceptionHandler(BadRequestException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String serverErrorExceptionHandler(Exception exception) {
        return exception.getMessage();
    }

}
