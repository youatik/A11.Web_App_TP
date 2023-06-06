/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import data.TomcatDataSource;

/**
 *
 * @author youatik
 */
public class ApplicationInitializer extends HttpServlet {
    @Override
    public void init() throws ServletException {
        TomcatDataSource.init();
    }
}
