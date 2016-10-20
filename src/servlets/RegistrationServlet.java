package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Adresse;
import classes.SqlConnection;
import classes.User;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

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
        String vname = request.getParameter("vn");
        String nname = request.getParameter("nn");
        String pass1 = request.getParameter("pw");
        String pass2 = request.getParameter("pw2");
        String rolle = "kunde";
        String strasse = request.getParameter("str");;
        String hausnummer = request.getParameter("hn");;
        String plz = request.getParameter("plz");
        String ort = request.getParameter("ort");;

        String act = request.getParameter("act");
        if (act == null) {
            //no button has been selected
        } else if (act.equals("registrieren")) {
        	
        	if(pass1.equals(pass2))
        	{

             try {
            
            User user = new User(0, mail, vname, nname, pass1, rolle, 0, strasse, hausnummer, plz ,ort);
            user.createUserInDB();
            
            String nextJSP = "/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);

             } catch (Exception ex) {
            	ex.printStackTrace();
             }
        	}
        	else
        	{
        		
        	}

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("statusLabel", request.getParameter("hallo"));
    }

}
