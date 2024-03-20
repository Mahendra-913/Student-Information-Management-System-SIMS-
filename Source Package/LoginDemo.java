import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LoginDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();	
		
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///abhidb?useSSL=false","root","root");
			String s11="select * from login where UNAME='"+s1+"' AND UPASS='"+s2+"'";
			
		    Statement st=con.createStatement(); 
			
			ResultSet rs=st.executeQuery(s11);
			
			if(rs.next())
			{
                             Cookie ck=new Cookie("un",s1);
                ck.setMaxAge(60*60);
                response.addCookie(ck); 
				response.sendRedirect("Mymenu");
                            
                            
                        }
			else
			{
				out.println("invalid user name and  password");
		}
			con.close();
		}		
catch(Exception e)
{
	out.println(e);
}
out.close();
}}
