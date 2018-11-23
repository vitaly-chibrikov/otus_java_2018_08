package ru.otus.h2;

import org.h2.tools.Server;

import java.sql.SQLException;

/**
 * http://localhost:8082
 *
 * CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));
 * insert into test (id, name) values (1, 'sally');
 * select * from test;
 */

public class Main {
    public static void main(String[] args) throws SQLException {
        Server.createWebServer("-web","-webAllowOthers","-webPort","8082").start();
        ConnectionHelper.example();
    }
}
