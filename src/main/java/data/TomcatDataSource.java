/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 *
 * @author youatik
 */
public class TomcatDataSource {
    private static DataSource dataSource;

    public static void init() throws ServletException {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/Test_Projet");
        } catch (NamingException e) {
            throw new ServletException("Error initializing data source", e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
