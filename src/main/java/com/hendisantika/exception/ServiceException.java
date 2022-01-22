package com.hendisantika.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/22
 * Time: 20.12
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

}
