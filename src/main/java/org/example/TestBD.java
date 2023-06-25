package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestBD extends BogdanDataBaseMySQL{
    public TestBD(String url, String dataBaseName, String password, String login) throws SQLException {
        super(url, dataBaseName, password, login);
    }

    @Override
    public List<Person> showDate(String sqlQuery) throws SQLException {
        List<Person> result = new ArrayList<>();
        Connection connection = getConnectionWithMySQL();
        return null;
    }


}
