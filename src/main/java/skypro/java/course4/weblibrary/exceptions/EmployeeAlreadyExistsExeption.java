package skypro.java.course4.weblibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

public class EmployeeAlreadyExistsExeption extends RuntimeException{
    @ExceptionHandler(EmployeeNotFoudExeption.class)
    public ResponseEntity<?> notFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalJsonFileExeption.class)
    public ResponseEntity<?> badRequest() {
        return ResponseEntity.badRequest().build();
    }
}
