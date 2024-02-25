package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/book")
public class AddBookDetailServlet extends GenericServlet{
	@Override
	 public void init()throws ServletException{
	 //NoCode
	 }
	@Override
	public void service(ServletRequest req,ServletResponse res)throws
	ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String bC = req.getParameter("bCode");
		String bN = req.getParameter("bName");
		String bA = req.getParameter("bAuthor");
		float bP = Float.parseFloat(req.getParameter("bPrice"));
		
		BookBean bb = new BookBean();
		bb.setbCode(bC);
		bb.setbName(bN);
		bb.setbAuthor(bA);
		bb.setbPrice(bP);
		
		int k = new AddBookDetailDAO().insert(bb);
		if(k>0) {
			pw.println("BookDetail Added Successfully....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("home.html");
			 rd.include(req, res);
		}
		
	}
	@Override
	public void destroy() {
		//nocode
	}
	

}
