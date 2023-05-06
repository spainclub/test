package com.example.miniproject.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final ApiException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(e.getError().getCode())
                        .errorMessage(e.getError().getMessage())
                        .build());
    }
//
//    @ExceptionHandler({IllegalArgumentException.class})
//    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final RuntimeException e) {
//        e.printStackTrace();
//        return ResponseEntity
//                .status(ExceptionEnum.RUNTIME_EXCEPTION.getStatus())
//                .body(ApiExceptionEntity.builder()
//                        .errorCode(ExceptionEnum.RUNTIME_EXCEPTION.getCode())
//                        .errorMessage(e.getMessage())
//                        .build());
//    }
//
//    @ExceptionHandler({AccessDeniedException.class})
//    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final AccessDeniedException e) {
//        e.printStackTrace();
//        return ResponseEntity
//                .status(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getStatus())
//                .body(ApiExceptionEntity.builder()
//                        .errorCode(ExceptionEnum.ACCESS_DENIED_EXCEPTION.getCode())
//                        .errorMessage(e.getMessage())
//                        .build());
//    }
//
//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final Exception e) {
//        e.printStackTrace();
//        return ResponseEntity
//                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
//                .body(ApiExceptionEntity.builder()
//                        .errorCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
//                        .errorMessage(e.getMessage())
//                        .build());
//    }
}
