package com.example.groupproject.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

  public static Connection getConnection() throws ClassNotFoundException {

    //creating an instance of data source
    MysqlDataSource mysqlDataSource = new MysqlDataSource();

    //setting the data source instance properties
    mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/canadacensusdb");
    mysqlDataSource.setUser("root");
    mysqlDataSource.setPassword("Sara3142");

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection connection = null;

    //connecting the data source to database and throwing an exception in case of any error
    try {
      connection = mysqlDataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
}