import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SearchDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("u1");
		
		out.print("<html>");
		out.print("<head>");
		out.print("<link rel='stylesheet'href='abc.css' />");
		out.print("</head>");
		out.print("<body>");
		out.print("<div id='mymenu'>");
		out.print("<ul  >");
		out.print("<li> <a href=' ram.html'>Home</a></li> <li><a href='insert.html'>Insert</a></li> <li><a href='search.html'>Search</a></li> <li><a href='ShowAll'>ShowAll</a></li> <li><a href='update.html'>Update</a></li> <li><a href='delete.html'>Delete</a></li> <li><a href='logoutDemo'>Logout</a></li> <li>About</li> <li>Contact</li></ul></div>");
		out.print("<div id='mydata'>");
		out.print("<center>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?useSSL=false","root","root");
			Statement st=con.createStatement();
			String s11="select * from loginn where un='"+s1+"'";
			ResultSet rs=st.executeQuery(s11);
			if(rs.next())
			{
     		    out.print("<table cellpadding='12'style=color:white;>");
     		    
				out.print("<th colspan='2' style=color:black;> Information </th>");
				
				out.print("<tr>");
				out.println("<td>Roll No.</td>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.print("</tr>");
			
				out.print("<tr>");
				out.println("<td>Name</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.print("</tr>");
			
				out.print("<tr>");
				out.println("<td>Physics</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.print("</tr>");
			
				out.print("<tr>");
				out.println("<td>Chemistry</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.print("</tr>");
			
				out.print("<tr>");
				out.println("<td>Maths</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.print("</tr>");
    
            	out.print("</table>");
			}
			else
			{
				out.print("Invalid Roll No.");
			}
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