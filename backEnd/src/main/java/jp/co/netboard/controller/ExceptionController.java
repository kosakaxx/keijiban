package jp.co.netboard.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public void exception() throws Exception {

        throw new Exception();
    }

    /**
     * SQLExceptionの例外処理
     *
     * @param e
     * @throws Exception
     */
    @ExceptionHandler(SQLException.class)
    private void sqlExceptionHandler(Exception e) {
        System.out.println("SQLException Handler");
        // ここでthrow e;してもexceptionHandlerにはいかない
    }

    /**
     * Runtime系の例外処理
     */
    @ExceptionHandler(RuntimeException.class)
    private void runtimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * その他のException例外処理
     */
    @ExceptionHandler(Exception.class)
    private void exceptionHandler(Exception e) {
        System.out.println("Exception Handler");
    }
}