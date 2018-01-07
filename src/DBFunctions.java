
import java.sql.*;
import java.util.*;


//TODO sprawdziæ dzia³anie zapytañ

public class DBFunctions {
	private Connection con;
	
	public DBFunctions()
	{
		try {
			con = DBOperations.connect("system", "system");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param con
	 * @param ID
	 * @param firstName
	 * @param lastName
	 * @param PESEL
	 * @param eMail
	 * @param phoneNumber
	 * @returns amount of rows altered, if -1 statement was not executed, if 1, client was added 
	 */
	public int addClient(String ID, String firstName, String lastName, String PESEL, String eMail, String phoneNumber)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("insert into Klienci values ("+ ID + ", '" + firstName +"', '"+lastName+"', "+PESEL + ", '"+eMail+"', "+phoneNumber+")");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int updateClient(String ID, String firstName, String lastName, String PESEL, String eMail, String phoneNumber)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("update Klienci set IMIE = '" + firstName +"', NAZWISKO = '"+lastName+"', PESEL = "+PESEL + ", E_MAIL = '"+eMail+"', NUMER_TELEFONU = "+phoneNumber+" where ID_KLIENTA = " + ID);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int updateEquipment(String ID, String bookingID, String status, String category, String description)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("update SPRZET set ID_REZERWACJI = " + bookingID +", STATUS = '"+status+"', KATEGORIA = '"+category + "', OPIS_SPRZETU = '"+description+" where ID_SPRZETU = " + ID);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
																				
	/**
	 * 
	 * @param ID
	 * @param clientID
	 * @param expirationDate Format YY-MM-DD
	 * @returns amount of rows altered, if -1 statement was not executed, if 1, booking was added
	 */
	public int addBooking ( String ID, String clientID, String expirationDate)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();																											//Format YY-MM-DD
			rows = stmt.executeUpdate("insert into Rezerwacje (ID_REZERWACJI, ID_KLIENTA, DATA_WYGASNIECIA) values ("+ ID + ", " + clientID +", "+"TO_DATE('" + expirationDate+"'))");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	/**
	 * 
	 * @param ID
	 * @param bookingID
	 * @param status
	 * @param category
	 * @param description
	 * @returns amount of rows altered, if -1 statement was not executed, if 1, equipment was added
	 */
	public int addEquipment(String ID, String bookingID, String status, String category, String description)
	{
		
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("insert into Sprzet values ("+ ID + ", "+ bookingID + ", '" + status +"', '"+category+"', '"+description+"')");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	/**
	 * 
	 * @param ID
	 * @returns amount of rows altered, if -1 statement was not executed, if 1, equipment was removed
	 */
	public int deleteEquipment(String ID)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("delete from sprzet where ID_SPRZETU = " + ID);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	/**
	 * 
	 * @param ID
	 * @returns amount of rows altered, if -1 statement was not executed, if 1, booking was removed
	 */
	public int deleteBooking(String ID)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("delete from REZERWACJE where ID_REZERWACJI = " + ID);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int deleteClient(String ID, String PESEL)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("delete from KLIENCI where (ID_KLIENTA = " + ID + " and PESEL = " + PESEL+")");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	/**
	 * 
	 * @param ID
	 * @param PESEL
	 * @returns row with data of a specified client, if returned more than 1 row, you should worry.
	 */
	public ArrayList<String> findClient(String ID, String PESEL)
	{
		ArrayList<String> result = null;
		try 
		{
			result = DBOperations.executeQuery(con, "select * from KLIENCI where (ID_KLIENTA = " + ID + " and PESEL = " + PESEL+")");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param ID
	 * @returns row with data of a specified equipment, should return one row
	 */
	public ArrayList<String> findEquipment(String ID)
	{
		ArrayList<String> result = null;
		try 
		{
			result = DBOperations.executeQuery(con, "select * from SPRZET where (ID_SPRZETU = " + ID + ")");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param ID
	 * @returns row with data of a specified booking, ONE row, more than one means tragedy
	 */
	public ArrayList<String> findBooking( String ID)
	{
		ArrayList<String> result = null;
		try 
		{
			result = DBOperations.executeQuery(con, "select * from REZERWACJE where (ID_REZERWACJI = " + ID + ")");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<String> findBookingsByStatus(String status)
	{
		ArrayList<String> result = null;
		try 
		{
			result = DBOperations.executeQuery(con, "select * from REZERWACJE where STATUS like '" + status + "'");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public ArrayList<String> findBookingUsingClientID( String ID)
	{
		ArrayList<String> result = null;
		try 
		{
			result = DBOperations.executeQuery(con, "select * from REZERWACJE where (ID_KLIENTA = " + ID + ")");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @returns How many items every category has, more than one row is okay
	 */
	public ArrayList<String> groupByCategory()
	{
		ArrayList<String> result = null;
		
		try
		{
			result = DBOperations.executeQuery(con, "select eq.KATEGORIA, count(eq.KATEGORIA) from SPRZET eq GROUP BY eq.KATEGORIA ORDER BY eq.KATEGORIA ASC");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @returns How many items every status has
	 */
	public ArrayList<String> groupEqByStatus()
	{
ArrayList<String> result = null;
		
		try
		{
			result = DBOperations.executeQuery(con, "select eq.STATUS, count(eq.STATUS) from SPRZET eq GROUP BY eq.STATUS ORDER BY eq.STATUS ASC");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<String> groupBookingsByStatus()
	{
		ArrayList<String> result = null;
		
		try
		{
			result = DBOperations.executeQuery(con, "select eq.STATUS, count(eq.STATUS) from REZERWACJE eq GROUP BY eq.STATUS ORDER BY eq.STATUS ASC");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	/**
	 * 
	 * @param tableName
	 * @returns select * from a specified table
	 */
	public ArrayList<String> getTableContent(String tableName)
	{
		ArrayList<String> result = null;
		
		try
		{
			result = DBOperations.executeQuery(con, "select * from " + tableName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
