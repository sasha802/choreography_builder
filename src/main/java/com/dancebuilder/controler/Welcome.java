package com.dancebuilder.controler;

import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
        urlPatterns = {"/welcome"}
)

public class Welcome extends HttpServlet {

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) {

        response.setContentType("text/html;charset=UTF-8");

    }
}
