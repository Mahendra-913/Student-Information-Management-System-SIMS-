import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegisDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();	
		
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?useSSL=false","root","root");
		    Statement st=con.createStatement();
			String s11="insert into login values('"+s1+"','"+s2+"')";
			st.executeUpdate(s11);
			response.sendRedirect("login.html");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.close();
	}
}
