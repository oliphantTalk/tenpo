package com.tenpo.tenpo.business.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionControllerAdvice
        extends ResponseEntityExceptionHandler {

    /*@ExceptionHandler({InvalidUsernameException.class, InvalidTokenException.class})
    public ResponseEntity<ApiResponse> handleInvalidUsernameAndTokenException(Exception ex) {
        ApiResponse apiResponseError = new ApiResponse(UNAUTHORIZED.value(), ex.getMessage());
        return new ResponseEntity<>(apiResponseError, UNAUTHORIZED);
    }

    @ExceptionHandler({UsernameNotAvailableException.class})
    public ResponseEntity<ApiResponse> handleUsernameNotAvailableException(Exception ex) {
        ApiResponse apiResponseError = new ApiResponse(BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(apiResponseError, BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponse> handleArgumentNotValidException(MethodArgumentNotValidException manve) {
        ApiResponse apiResponseError = new ApiResponse(BAD_REQUEST.value(), manve.getGlobalError().getDefaultMessage());
        return new ResponseEntity<>(apiResponseError, BAD_REQUEST);
    }

    @ExceptionHandler({MathStrategySelectionErrorException.class})
    public ResponseEntity<ApiResponse> handleMathStrategySelectionErrorException(MathStrategySelectionErrorException mssee) {
        ApiResponse apiResponseError = new ApiResponse(INTERNAL_SERVER_ERROR.value(), mssee.getMessage());
        return new ResponseEntity<>(apiResponseError, INTERNAL_SERVER_ERROR);
    }*/


/*
    @ExceptionHandler(SecurityInterceptorException.class)
    public ResponseEntity<ApiError> handlerSecurityException(HttpServletRequest request, SecurityInterceptorException ex) {
        ApiError apiError = new ApiError(ErrorCode.INVALID_CREDENTIALS);
        return this.handle(request, ex, HttpStatus.FORBIDDEN, apiError);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ApiError> handlerSignatureException(HttpServletRequest request, SignatureException ex) {
        ApiError apiError = new ApiError(ErrorCode.SIGNATURE_NOT_MATCH);
        return this.handle(request, ex, HttpStatus.BAD_REQUEST, apiError);
    }

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ApiError> handlerInvalidParamException(HttpServletRequest request, InvalidParamException ex) {
        ApiError apiError = new ApiError(ErrorCode.INVALID_PARAMETER, ex.getParam());
        return this.handle(request, ex, HttpStatus.BAD_REQUEST, apiError);
    }

    @ExceptionHandler(MissingParamException.class)
    public ResponseEntity<ApiError> handlerMissingParamException(HttpServletRequest request, MissingParamException ex) {
        ApiError apiError = new ApiError(ErrorCode.MISSING_PARAMETER, ex.getParam());
        return this.handle(request, ex, HttpStatus.BAD_REQUEST, apiError);
    }

    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<ApiError> handlerTokenNotFoundException(HttpServletRequest request, TokenNotFoundException ex) {
        ApiError apiError = new ApiError(ErrorCode.TOKEN_NOT_FOUND);
        return this.handle(request, ex, HttpStatus.BAD_REQUEST, apiError);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handlerApiException(HttpServletRequest request, ApiException ex) {
        return this.handle(request, ex, HttpStatus.BAD_REQUEST, ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handlerInvalidParamException(HttpServletRequest request, Exception ex) {
        ApiError apiError = new ApiError(ErrorCode.INTERNAL_ERROR);
        return this.handle(request, ex, HttpStatus.INTERNAL_SERVER_ERROR, apiError);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, RequestAttributes.SCOPE_REQUEST);
        }

        ApiError apiError;

        String message = ex.getMessage() != null ? ex.getMessage() : ex.toString();
        if (status.is4xxClientError()) {
            apiError = new ApiError(ErrorCode.INVALID_REQUEST);
            this.logger.warn(message, ex);
        } else {
            apiError = new ApiError(ErrorCode.INTERNAL_ERROR);
            this.logger.error(message, ex);
        }

        return new ResponseEntity<>(apiError, headers, status);
    }

    protected ResponseEntity<ApiError> handle(HttpServletRequest request, Exception ex, HttpStatus status, ApiError apiError) {

        if (status.is5xxServerError()) {
            this.logger.error(ex.getMessage(), ex);
        } else {
            this.logger.warn(ex.getMessage(), ex);
        }

        return new ResponseEntity<ApiError>(apiError, status);
    }

    protected ResponseEntity<ApiError> handle(HttpServletRequest request, Exception ex, HttpStatus status, int code, String message) {

        ApiError apiError = new ApiError(code, message);
        return this.handle(request, ex, status, apiError);
    }*/
}
