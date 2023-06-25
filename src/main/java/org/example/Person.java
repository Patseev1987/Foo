package org.example;

import java.sql.Date;
import java.sql.SQLData;

public class Person {
    int id;
    String name;
    int level;
    Date date;


    public Person(int id, String name, int level, Date date) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.date = date;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", date=" + date;
    }
}
