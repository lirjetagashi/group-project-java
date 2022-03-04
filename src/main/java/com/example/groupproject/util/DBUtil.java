package com.example.groupproject.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

  public static Connection getConnection() throws ClassNotFoundException {

    MysqlDataSource mysqlDataSource = new MysqlDataSource();

    mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/CanadaCensusDB");
    mysqlDataSource.setUser("root");
    mysqlDataSource.setPassword("denlir9899");

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection connection = null;
    try {
      connection = mysqlDataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
}