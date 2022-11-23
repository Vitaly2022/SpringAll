package org.example;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice //класс обрабатывающий глобальные исключения, которых нет в try catch
public class MyExp {

//    @ExceptionHandler(SQLException.class)
//    public void mySQLExeption () {
//        System.out.println("Error BD");//просто в терминал вывести сообщение о ошибке
//    }

    @ExceptionHandler(SQLException.class)
    public String mySQLExeption (HttpServletRequest request, Exception ex) {
    return "error";
    }

}
