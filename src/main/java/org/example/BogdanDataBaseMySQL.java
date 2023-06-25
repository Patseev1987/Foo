package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BogdanDataBaseMySQL {
    private String url;
    private String dataBaseName;
    private String password;
    private String login;

    private final String SELECT = "SELECT";
    private final String UPDATE = "UPDATE";
    private final String CREATE = "CREATE";
    private final String INSERT = "INSERT";
    private final String ALERT = "ALERT";
    private final String FROM = "FROM";
    private final String INTO = "INSERT INTO `";
    private final String VALUES = "`) VALUES ('";
    private final String SEPARATOR_AFTER_COLUMN = "`, `";
    private final String BEFORE_COLUMN = "` (`";
    private final String END = "');";
    private final String NOT_NULL = "NOT NULL";
    private final String AUTO_INCREMENT = "AUTO_INCREMENT";
    private final String PRIMARY_KEY = "PRIMARY KEY";
    private final String UNIQUE_INDEX = "UNIQUE INDEX";
private final String TABLE = "TABLE `";
private final String COLUMN ="COLUMN `";
private final String SPACE = " ";
private final String SCHEMA = "SCHEMA `" ;
private final String FOREIGN_KEY = "FOREIGN KEY";
private final String REFERENCES = "REFERENCES";

    public BogdanDataBaseMySQL(String url, String dataBaseName, String password, String login) {
        this.url = url;
        this.dataBaseName = dataBaseName;
        this.password = password;
        this.login = login;

    }


    public List<Person> showDate(String tableName) throws SQLException {
       String sql =  getSQLStringForSelect(tableName);



        Connection connection = DriverManager.getConnection("jdbc:mysql://" + url +":3306"+ "/" + dataBaseName,
                 login,password );
        System.out.println("Соединение с базой данных установленно!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery( sql );
        List<Person> result = new ArrayList<>();
        int id;
        int level;
        String name;
        Date date;
        while (resultSet.next()){
            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            level = resultSet.getInt(3);
            date = resultSet.getDate(4);
            result.add(new Person(id,name,level,date));
        }
        statement.close();
        connection.close();
        return result;
    }

//    private String getStringSQLForInsertData(String tableName) {
//        String temp = "INSERT INTO `" + dataBaseName + "`.`" + tableName + "` (`name`, `levl`) VALUES ('Jhon', '2');";
//    }

    public String getSQLStringForSelect (String tableName){
//        SELECT * FROM myDataBase.users;
        String temp = SELECT+SPACE+"*"+SPACE+FROM+SPACE+dataBaseName+"."+tableName+";";
        return temp;
    }

}
