package com.example.groupproject.handler;

import com.example.groupproject.bean.Age;
import com.example.groupproject.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AgeHandler {

  private Connection dbConn;

  public static Age age = new Age();

  public AgeHandler() throws ClassNotFoundException {
    dbConn = DBUtil.getConnection();
  }

  //this method is used to find the sum of female and male population given the census year
  public boolean findMaleFemaleByCensusYear(int censusYear) {

    //trying to fetch data from database and throwing an exception in case of not being able to fetch
    try {
      // setting the query string to fetch male and female population with the given census year
      // from age table joining the census year
      PreparedStatement preparedStatement = dbConn
          .prepareStatement("SELECT c.censusYear, SUM(a.male), SUM(a.female)" +
              " FROM AGE a JOIN CENSUSYEAR c" +
              " ON a.censusYear = c.censusYearID" +
              " WHERE c.censusYear = ?");
      preparedStatement.setInt(1, censusYear);

      // executing the query
      ResultSet result = preparedStatement.executeQuery();

      //saving the result of the query
      if (result != null) {
        while (result.next()) {
          if (result.getInt(1) == censusYear) {
            age.setCensusYear(result.getInt(1));
            age.setMale(result.getInt(2));
            age.setFemale(result.getInt(3));
            return true;
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
