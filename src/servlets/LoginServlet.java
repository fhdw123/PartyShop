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
@WebServlet("/ServletLogin")
public class LoginServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        
        String act = request.getParameter("act");
        if (act == null) {
            //no button has been selected
        } else if(act.equals("login")) {
        	
        	try{
        		
        		SqlConnection sql = new SqlConnection();
        		Connection connection = sql.getJDBCConnection();
                        
                        
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery("Select user.mail, user.passwort, user.rolle, user.gesperrt from user");
                        
                        
                        while(rs.next())
                        {
                         if(rs.getString("mail").equals(mail))
                         {
                          if(rs.getString("passwort").equals(pass))
                          {
                           
                          }
                         }
                        }
                        
                        
                        
        		
        	int i=1;	
        	}
        	catch(Exception ex)
        	{
        		
        	}
        	
        }
        
        
            
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
