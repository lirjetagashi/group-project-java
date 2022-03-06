package com.example.groupproject.web;

import com.example.groupproject.bean.GeographicArea;
import com.example.groupproject.handler.GeographicAreaClassficationListHandler;
import com.example.groupproject.handler.GeographicAreaHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static com.example.groupproject.handler.GeographicAreaHandler.geoAreaDetail;
import static com.example.groupproject.handler.GeographicAreaHandler.totalPopulation;

@WebServlet(name = "CanadaCensusController", value = "/CanadaCensusController")
public class CanadaCensusController extends HttpServlet {

    private GeographicAreaHandler geographicAreaHandler;
    private GeographicAreaClassficationListHandler geographicAreaClassficationListHandler;
    boolean result = false;

    //setting constants for forwarding the request/response
    final String Census_LOGIN = "/login.jsp";
    final String Census_HOME = "/home.jsp";
    final String Census_GEOGRAPHICAREACLASSIFICATIONLIST = "/GeographicAreaClassificationList.jsp";
    final String Census_INDIVIDUALGEOGRPHICAREADETAIL = "/IndividualGeographicAreaDetailsPage.jsp";

    public CanadaCensusController() throws ClassNotFoundException {
        super();
        //creating an instance of GeographicAreaHandler
        geographicAreaHandler = new GeographicAreaHandler();
        geographicAreaClassficationListHandler = new GeographicAreaClassficationListHandler();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //determining which jsp page the request is from
        String pageName = request.getParameter("pageName");
        String forward = "";
        String message = "";

        //if the request is from login page then check username and password to give access
        //username and password are the ones used for accessing database
        if (pageName.equals("login")){
            if ( request.getParameter("userName").equals("root") &&
                    request.getParameter("password").equals("Sara3142")){
                forward = Census_HOME;
            }
            else {
                message = "User does not exist";
                request.setAttribute("message", message);
                forward = Census_LOGIN;
            }
        }

        //if the request is from geographicAreaDetail then fetch the detail for geographic area and pass it to jsp page
        if (geographicAreaHandler != null) {
            if (pageName.equals("geographicAreaDetail")) {
                result = geographicAreaHandler.findGeographicAreaById(
                        Integer.parseInt(request.getParameter("geographicAreaID")));
                if (result == true) {
                    request.setAttribute("geoAreaObj", geoAreaDetail);
                    request.setAttribute("totalPopulation", totalPopulation);
                } else {
                    message = "This Geographic Area ID is not available.";
                    request.setAttribute("message", message);
                }
                forward = Census_INDIVIDUALGEOGRPHICAREADETAIL;
            }
        }

        //if the request is from geograpicAreaClassificationList then fetch the detail for geographic area and pass it to jsp page
        if (geographicAreaClassficationListHandler != null) {
            if (pageName.equals("GeographicAreaClassificationList")) {
                List<GeographicArea> geographicAreaList = geographicAreaClassficationListHandler.findGeographicAreaByLevel(
                                                          Integer.parseInt(request.getParameter("level")));

                request.setAttribute("geoAreaObjList", geographicAreaList);

                forward = Census_GEOGRAPHICAREACLASSIFICATIONLIST;
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
