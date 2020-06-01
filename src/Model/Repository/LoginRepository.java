package Model.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {

	public String valid(String user) {
		String query = "SELECT * from login WHERE login.user = '" + user + "'";
		try {
			ResultSet result = DBManager.getInstance().readFromDB(query);
			if (result.next())
				return result.getString(2);
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
		return null;
	}
}
