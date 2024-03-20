import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class UpdateDemo extends HttpServlet
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
			String s11="update loginn set up='"+s2+"',ue='"+s3+"',uc='"+s4+"',ur='"+s5+"' where un='"+s1+"'";
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
