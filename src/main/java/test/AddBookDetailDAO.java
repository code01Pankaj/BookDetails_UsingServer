package test;
import java.sql.*;
public class AddBookDetailDAO {
	public int k = 0;
	public int insert(BookBean bb) {
		try {
			Connection con = DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement("insert into BookDetail54 values(?,?,?,?)");
			ps.setString(1, bb.getbCode());
			ps.setString(2, bb.getbName());
			ps.setString(3, bb.getbAuthor());
			ps.setFloat(4, bb.getbPrice());
			k = ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
