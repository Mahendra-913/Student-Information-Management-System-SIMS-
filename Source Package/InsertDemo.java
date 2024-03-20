import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class InsertDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();	
		
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		String s3=request.getParameter("ue");
		String s4=request.getParameter("uc");
		String s5=request.getParameter("ur");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?useSSL=false","root","root");
		    Statement st=con.createStatement();
			String s11="insert into loginn values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
			st.executeUpdate(s11);
			response.sendRedirect("ShowAll");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.close();
	}
}
