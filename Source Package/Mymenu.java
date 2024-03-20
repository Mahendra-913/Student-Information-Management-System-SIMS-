import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Mymenu extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            
                Cookie ck[]=request.getCookies();
                if(ck!=null)
                {
		out.print("<html>");
		out.print("<head>");
		out.print("<link rel='stylesheet'href='abc.css' />");
		out.print("</head>");
		out.print("<body>");
		out.print("<div id='mymenu'>");
		out.print("<ul>");
		out.print("<li><a href='ram.html'>Home</a></li> <li><a href='insert.html'>Insert</a></li> <li><a href='search.html'>Search</a></li> <li><a href='ShowAll'>ShowAll</a></li> <li><a href='update.html'>Update</a></li> <li><a href='delete.html'>Delete</a></li> <li><a href='LogoutDemo'>Logout</a></li> <li>About</li> <li>Contact</li></ul></div>");
		out.print("<div id='mydata'>");
		out.print("<center>");
		out.print("<h1>WelCome "+ck[0].getValue()+"</h1>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
                }
                else
                {
                    response.sendRedirect("login.html");
                }
    }
}