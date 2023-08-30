package jp.co.netboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

public class ExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * SQLExceptionの例外処理
     *
     * @param e
     * @throws Exception
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(SQLException.class)
    private void sqlExceptionHandler(Exception e) {
        System.out.println("SQLException Handler");
        // ここでthrow e;してもexceptionHandlerにはいかない
    }

    /**
     * Runtime系の例外処理
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    private void runtimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * その他のException例外処理
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    private void exceptionHandler(Exception e) {
        System.out.println("Exception Handler");
    }
}