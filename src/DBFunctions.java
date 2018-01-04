
import java.sql.*;
import java.util.*;


//TODO sprawdziæ dzia³anie zapytañ
//Metody dodaj¹ce rekordy przyjmuj¹ za ma³o wartoœci, 
//zrobiæ procedury dodaj¹ce klientów z okreœlonymi triggerami i wywo³ywaæ je z poziomu aplikacji
public class DBFunctions {
	
	public int addClient(Connection con, String ID, String firstName, String lastName, String PESEL, String eMail, String phoneNumber)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("insert into Klienci values ("+ ID + ", " + firstName +", "+lastName+", "+PESEL + ", "+eMail+", "+phoneNumber+")");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
																				//Format YY-MM-DD
	public int addBooking (Connection con, String ID, String clientID, String expirationDate)
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
	public int addEquipment(Connection con, String ID, String bookingID, String status, String category, String description)
	{
		
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("insert into Sprzet values ("+ ID + ", "+ bookingID + ", " + status +", "+category+", "+description+")");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	public int deleteEquipment(Connection con, String ID)
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
	
	public int deleteBooking(Connection con, String ID)
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
	
	public int deleteClient(Connection con, String ID, String PESEL)
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
	
	public ArrayList<String> findClient(Connection con, String ID, String PESEL)
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
	
	public ArrayList<String> findEquipment(Connection con, String ID)
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
	
	public ArrayList<String> groupByCategory(Connection con)
	{
		ArrayList<String> result = null;
		
		try
		{
			result = DBOperations.executeQuery(con, "select eq.NAZWA, count(eq.NAZWA) from SPRZET eq GROUP BY eq.NAZWA ORDER BY eq.NAZWA ASC");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<String> groupByStatus(Connection con)
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
	
	public ArrayList<String> getTableContent(Connection con, String tableName)
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
