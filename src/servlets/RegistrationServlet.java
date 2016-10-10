package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.SqlConnection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ServletRegistration")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mail = request.getParameter("mail").toLowerCase();
        String vname = request.getParameter("vname");
        String nname = request.getParameter("nname");
        String adr = request.getParameter("adr");
        String pass1 = request.getParameter("pw1");
        String pass2 = request.getParameter("pw2");
        String rolle = "kunde";

        String act = request.getParameter("act");
        if (act == null) {
            //no button has been selected
        } else if (act.equals("registrieren")) {

            try {
                boolean mailFrei = true;

                SqlConnection sql = new SqlConnection();
                Connection connection = sql.getJDBCConnection();

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("Select user.mail, user.passwort from user");

                while (rs.next()) {
                    if (rs.getString("mail").equals(mail)) {
                     mailFrei=false;
                    }
                }
                
                if(mailFrei && pass1.equals(pass2))
                {
             
                    stmt.executeUpdate("INSERT INTO user " + "VALUES (0, '"+mail+"', '"+vname+"', '"+nname+"', '"+pass1+"', '"+rolle+"')");
                }

            } catch (Exception ex) {
ex.printStackTrace();
            }

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
