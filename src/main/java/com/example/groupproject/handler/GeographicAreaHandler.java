package com.example.groupproject.handler;

import com.example.groupproject.util.DBUtil;
import com.example.groupproject.bean.GeographicArea;

import java.sql.*;

public class GeographicAreaHandler {

    private Connection dbConnection;

    public GeographicAreaHandler() throws ClassNotFoundException {
        dbConnection = DBUtil.getConnection();
    }
}
