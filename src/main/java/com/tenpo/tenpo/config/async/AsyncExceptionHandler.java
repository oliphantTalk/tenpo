package com.tenpo.tenpo.config.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * https://www.baeldung.com/spring-async
 * When a method return type is a Future, exception handling is easy. Future.get() method will throw the exception.
 *
 * But if the return type is void, exceptions will not be propagated to the calling thread. So, we need to add extra configurations to handle exceptions.
 *
 * We'll create a custom async exception handler by implementing AsyncUncaughtExceptionHandler interface. The handleUncaughtException() method is invoked when there are any uncaught asynchronous exceptions:
 */
@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {

        log.error("Exception message - " + throwable.getMessage());
        log.error("Method name - " + method.getName());
        for (Object param : obj) {
            log.error("Parameter value - " + param);
        }
    }

}
