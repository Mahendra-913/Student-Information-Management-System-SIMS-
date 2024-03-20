import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ShowAll extends HttpServlet
{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<link rel='stylesheet'href='abc.css' />");
		out.print("</head>");
		out.print("<body>");
		out.print("<div id='mymenu'>");
		out.print("<ul>");
		out.print("<li> <a href=' ram.html'>Home</a></li> <li><a href=' insert.html'>Insert</a></li> <li><a href=' search.html'>Search</a></li> <li><a href='ShowAll'>ShowAll</a></li> <li><a href='update.html'>Update</a></li> <li><a href='delete.html'>Delete</a></li> <li><a href='LogoutDemo'>Logout</a></li> <li>About</li> <li>Contact</li></ul></div>");
		out.print("<div id='mydata'>");
		out.print("<center>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?useSSL=false","root","root");
			Statement st=con.createStatement();
			String s11="select * from loginn";
			ResultSet rs=st.executeQuery(s11);
     		out.print("<table cellpadding='12' style=color:white; >");
                    out.print("<caption style=color:Black;><i><u><b>Student Data</b></u></i></caption>");
                    
			out.print("<th style=color:Black;>Roll Number</th>");
                        out.print("<th style=color:Black;>Student Name</th>");
			out.print("<th style=color:Black;>Physics marks</th>");
			out.print("<th style=color:Black;>Chemistry marks</th>");
			out.print("<th style=color:Black;>Maths marks</th>");
                        while(rs.next())
			{    	
                        out.print("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.close();
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
	}
}