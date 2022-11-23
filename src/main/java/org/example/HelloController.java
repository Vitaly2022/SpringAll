package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String mymetod (@RequestParam(value = "userName", required = false) String gogy){
        System.out.println("Hello "+gogy);
        return "hello"; //имя jsp если стринг то это вью резолвер
    }

    @GetMapping("/path/{userName}") //путь контроллера склеивается с этим путем
    public String helloPath(@PathVariable("userName") String gogy) {
        System.out.println("Hello "+gogy);
        return "hello";
    }

    @GetMapping("/select") //путь контроллера склеивается с этим путем
    public String selectMySql (ModelMap bd) throws SQLException {


        final String URL = "jdbc:mysql://localhost:3306/dz4";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        preparedStatement = connection.prepareStatement("select * from autor");
        resultSet = preparedStatement.executeQuery();
        List <String> list = new ArrayList<>();
        while (resultSet.next() ) {
            list.add(resultSet.getString("name"));
        }
        bd.put("names",list);
        return "select";
    }






}
