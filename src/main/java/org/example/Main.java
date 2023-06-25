package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
    TestBD test = new TestBD("localhost","myDataBase","Root1234","root");

 // String asd= "jdbc:mysql://" + "localhost" +":3306"+ "/" + "myDataBase" +"      "+"\"" + "root" + "\""+"    "+ "\"" + "Root1234" + "\"";
 //       System.out.println(asd);
        List <Person> people = test.showDate("users");

        for (Person person: people) {
            System.out.println(person);
        }
    }
}