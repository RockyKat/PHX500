package ngdemo.mysql.service;

import ngdemo.domain.SQL;

public class SQLService {

    public SQL getDefaultSQL() {
        SQL sql = new SQL();
        sql.setFirstName("My SQL Server");
        sql.setLastName("Demo Database Access.");
        sql.setBmp("mysql.png");
        return sql;
    }
}