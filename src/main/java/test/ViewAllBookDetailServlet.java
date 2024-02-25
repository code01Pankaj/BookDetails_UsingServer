package test;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllBookDetailServlet extends GenericServlet{
	@Override
	public void init() {
		//nocode
	}
	@Override
	public void service(ServletRequest req,ServletResponse res)throws
	ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ArrayList<BookBean> al =new ViewAllBookDetailDAO().retrieve();
		if(al.size()==0) {
			pw.println("Books not Available...<br>");
		}else {
			pw.println("=====BookDetails=====<br>");
			Spliterator<BookBean> sp = al.spliterator();
			sp.forEachRemaining((k)->
			{
				BookBean bb = (BookBean)k;
				pw.println(bb.getbCode()+"&nbsp&nbsp"
						+bb.getbName()+"&nbsp&nbsp"
						+bb.getbAuthor()+"&nbsp&nbsp"
						+bb.getbPrice()+"<br>");
			});
		}
		pw.println("<a href='home.html'>Home</a>"); 
	}//end of loop
	@Override
	public void destroy() {
		//nocode
	}
	
	

}
