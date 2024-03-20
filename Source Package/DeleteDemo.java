import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class DeleteDemo extends HttpServlet
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
		out.print("<ul>");
		out.print("<li> <a href=' ram.html'>Home</a></li> <li><a href='insert.html'>Insert</a></li> <li><a href='search.html'>Search</a></li> <li><a href='ShowAll'>ShowAll</a></li> <li><a href='update.html'>Update</a></li> <li><a href='delete.html'>Delete</a></li> <li><a href='logoutDemo'>Logout</a></li> <li>About</li> <li>Contact</li></ul></div>");
		out.print("<div id='mydata'>");
		out.print("<center>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?useSSL=false","root","root");
			Statement st=con.createStatement();
			String s11="delete from loginn where un='"+s1+"'";
			st.executeUpdate(s11);

					response.sendRedirect("ShowAll");

//                        
//			ResultSet rs=st.executeQuery(Query);
//                        
//                        if(rs.next())
//			{
//                        out.println("invalid roll no.");
//                        
//                        }
//			else
//			{
	
//			}
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