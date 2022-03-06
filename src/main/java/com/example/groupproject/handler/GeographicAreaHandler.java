package com.example.groupproject.handler;

import com.example.groupproject.util.DBUtil;
import com.example.groupproject.bean.GeographicArea;

import java.sql.*;


public class GeographicAreaHandler {

    private Connection dbConnection;

    //defining static variables to hold the result of the sql query and be used in other classes
    public static GeographicArea geoAreaDetail = new GeographicArea();
    public static int totalPopulation = 0;

    public GeographicAreaHandler() throws ClassNotFoundException {
        dbConnection = DBUtil.getConnection();
    }

    //this method is used to find and existing geographic Area by a given id
    public boolean findGeographicAreaById (int id) {

        //trying to fetch data from database and throwing an exception in case of not being able to fetch
        try {
            // setting the query string to fetch geographic area record with the given id
            // from geographicarea table and the total population from
            // age table for year 2016
            PreparedStatement preparedStatement = dbConnection
                    .prepareStatement("SELECT g.geographicAreaID, g.code, g.level, g.name, g.alternativeCode, " +
                                          "SUM(a.combined)" +
                                          " FROM geographicarea g JOIN age a on g.geographicAreaID = a.geographicArea" +
                                          " WHERE geographicAreaID = ? AND a.censusYear = 1");
            preparedStatement.setInt(1, id);

            // executing the query
            ResultSet result = preparedStatement.executeQuery();

            //saving the result of the query
            if (result != null) {
                while (result.next()) {
                    if (result.getInt(1) == id){
                        geoAreaDetail.setCode(result.getInt(2));
                        geoAreaDetail.setLevel(result.getInt(3));
                        geoAreaDetail.setName(result.getString(4));
                        geoAreaDetail.setAlternativeCode(result.getInt(5));
                        totalPopulation = result.getInt(6);
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

