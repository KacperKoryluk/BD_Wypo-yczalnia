import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBOperations {
	
	/**
	 * Connects to the DB server.
	 * @param username
	 * @param password
	 * @return Connection
	 * @throws SQLException
	 */
	//TODO przerobiæ adres na localhost
	public static Connection connect(String username, String password) throws SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", username,
				password);//open the connection
		return connection;
	}
	
	/**
	 * Checks if the ORACLE driver is available. If not, throws an exception
	 * @throws ClassNotFoundException
	 */
	public static void checkLibrary() throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	
	/**
	 * Executes a query using the established connection.
	 * @param connection
	 * @param query
	 * @return an ArrayList<String> that contains the output of the query.
	 * @throws Exception
	 */
	public static ArrayList<String> executeQuery(Connection connection,String query)throws Exception{
		ArrayList<String> outputResult=new ArrayList<String>();
		Statement statement = null;
		ResultSet resultSet=null;
		ResultSetMetaData rsmd=null;
		
		statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		
		rsmd = resultSet.getMetaData();
		
		
		int columnNumber = rsmd.getColumnCount();	
		StringBuilder tmp = null;
		while(resultSet.next())//Iteracja po wierszach
		{
			tmp = new StringBuilder();
			for(int i=1;i<=columnNumber;i++)//Iteracja po kolumnach
			{
				tmp.append(resultSet.getString(i));
				tmp.append("\t");
			}
			
			outputResult.add(tmp.toString());
		}
		
		return outputResult;
	}

}
