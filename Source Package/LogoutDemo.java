import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LogoutDemo extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException       
          {
                Cookie ck=new Cookie("un","");
                ck.setMaxAge(0);
                response.addCookie(ck);
		response.sendRedirect("login.html");
                }
}