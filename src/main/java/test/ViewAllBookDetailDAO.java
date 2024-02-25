package test;
import java.sql.*;
import java.util.*;
public class ViewAllBookDetailDAO {
	public ArrayList<BookBean> al = new ArrayList<BookBean>();
	public ArrayList<BookBean> retrieve(){
		try {
			Connection con = DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement("select * from BookDetail54");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			   BookBean bb = new BookBean();
			   bb.setbCode(rs.getString(1));
			   bb.setbName(rs.getString(2));
			   bb.setbAuthor(rs.getString(3));
			   bb.setbPrice(rs.getFloat(4));
			   
			   al.add(bb);
			   //Bean-Object added to ArrayList
			}
			
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}

}