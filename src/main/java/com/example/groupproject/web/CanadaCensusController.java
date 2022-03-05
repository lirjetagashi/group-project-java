package com.example.groupproject.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CanadaCensusController", value = "/CanadaCensusController")
public class CanadaCensusController extends HttpServlet {

    //setting constants for forwarding the request/response
    final String Census_LOGIN = "/login.jsp";
    final String Census_HOME = "/home.jsp";
    final String Census_INDIVIDUALGEOGRPHICAREADETAIL = "/IndividualGeographicAreaDetailsPage.jsp";



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //determining which jsp page the request is from
        String pageName = request.getParameter("pageName");
        String forward = "";

        //checking username and password
        if (pageName.equals("login")){
            if ( request.getParameter("userName").equals("root") &&
                    request.getParameter("password").equals("Sara3142")){
                forward = Census_HOME;
            }
            else {
                String message = "User does not exist";
                request.setAttribute("message", message);
                forward = Census_LOGIN;
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
