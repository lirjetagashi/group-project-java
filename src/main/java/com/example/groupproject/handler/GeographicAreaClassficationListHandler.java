package com.example.groupproject.handler;

import com.example.groupproject.bean.GeographicArea;
import com.example.groupproject.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeographicAreaClassficationListHandler {
    private Connection dbConnection;

    public GeographicAreaClassficationListHandler() throws ClassNotFoundException{
        dbConnection = DBUtil.getConnection();
    }
    public List<GeographicArea> findGeographicAreaByLevel (int level) {

        List<GeographicArea> geographicAreaList = new ArrayList<GeographicArea>();
        //trying to fetch data from database and throwing an exception in case of not being able to fetch
        try {
            // setting the query string to fetch geographic area record with the given level
            PreparedStatement preparedStatement = dbConnection
                    .prepareStatement("SELECT geographicAreaID, code, level, name, alternativeCode " +
                                          " FROM geographicarea" +
                                          " WHERE level = ?");
            preparedStatement.setInt(1, level);

            // executing the query
            ResultSet result = preparedStatement.executeQuery();

            //saving the result of the query
            if (result != null) {
                while (result.next()) {
                    if (result.getInt(3) == level){
                        GeographicArea geoAreaDetail = new GeographicArea();

                        geoAreaDetail.setCode(result.getInt(2));
                        geoAreaDetail.setLevel(result.getInt(3));
                        geoAreaDetail.setName(result.getString(4));
                        geoAreaDetail.setAlternativeCode(result.getInt(5));
                        geographicAreaList.add(geoAreaDetail);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geographicAreaList;
    }

}
