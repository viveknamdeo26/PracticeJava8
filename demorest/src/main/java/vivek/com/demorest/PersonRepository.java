package vivek.com.demorest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

	Connection con;
	String url = "jdbc:mysql://localhost:3306/mysqldatabase";
	String user = "root";
	String password = "vkn@12345";

	public PersonRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public List<Person> getPersons() {
		List<Person> list = new ArrayList<>();
		String sql = "select * from persons";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Person p = new Person();
				p.setPersonID(rs.getInt(1));
				p.setFirstName(rs.getString(2));
				p.setLastName(rs.getString(3));
				p.setAddress(rs.getString(4));
				p.setCity(rs.getString(5));
				list.add(p);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
}
