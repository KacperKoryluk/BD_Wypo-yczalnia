import java.sql.*;
import java.util.*;



//TODO sprawdziæ dzia³anie zapytañ

public class DBFunctions {
	private Connection con;
	
	public DBFunctions()
	{
		try {
			con = DBOperations.connect("system", "admin");
			con.setAutoCommit(true);
		}
		catch (Exception e) {
			// TODO: handle exception
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
			rows = stmt.executeUpdate("insert into Klienci (ID_KLIENTA, IMIE, NAZWISKO, PESEL, E_MAIL, NUMER_TELEFONU) values ("+ ID + ", '" + firstName +"', '"+lastName+"', "+PESEL + ", '"+eMail+"', "+phoneNumber+")");
			stmt.close();
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
			rows = stmt.executeUpdate("insert into Rezerwacje (ID_REZERWACJI, ID_KLIENTA, DATA_WYGASNIECIA, STATUS) values ("+ ID + ", " + clientID +", "+"TO_DATE('" + expirationDate+"','YYYY-MM-DD HH24:MI:SS'), 'NIEOPLACONA')");
			stmt.close();
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
			stmt.close();
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
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Throwable e) {
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
			rows = stmt.executeUpdate("update SPRZET set ID_REZERWACJI = " + bookingID +", STATUS = '"+status+"', KATEGORIA = '"+category + "', OPIS_SPRZETU = '"+description+"' where ID_SPRZETU = " + ID);
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int freeEquipment(String ID) {
		Statement stmt = null;
		int rows = -1;
		
		try {
			stmt = con.createStatement();
			rows = stmt.executeUpdate("update SPRZET set ID_REZERWACJI = NULL, STATUS = 'DOSTEPNY' where ID_REZERWACJI = " + ID);
			
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rows;
	}
	
	public int updateBooking(String ID, String clientID, String booDate, String status, String expDate) {
		
		Statement statement = null;
		int rows = -1;
		try {
			statement = con.createStatement();
			rows = statement.executeUpdate("update REZERWACJE set ID_KLIENTA = " + clientID + 
											", DATA_REZERWACJI = TO_DATE('" + booDate + "' , 'YYYY-MM-DD HH24:MI:SS'), STATUS = '" + status + "', DATA_WYGASNIECIA = TO_DATE('" + expDate + "','YYYY-MM-DD HH24:MI:SS')"
													+ " where ID_REZERWACJI = " + ID);
			

			statement.close();
		} catch (Throwable e) {
			// TODO: handle exception
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
			stmt.close();
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
			stmt.close();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int deleteClient(String ID)
	{
		Statement stmt = null;
		int rows = -1;
		try 
		{
			stmt = con.createStatement();
			rows = stmt.executeUpdate("delete from KLIENCI where (ID_KLIENTA = " + ID + ")");
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rows;
	}
	
	
	
	public ArrayList<String> getBookingsByStatus(String status)
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
	
	
	public ArrayList<String> getBookingUsingClientID( String ID)
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
	public ArrayList<String> getEqByCategory()
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
	
	public ArrayList<String> getEqByOrder(String booID){
		ArrayList<String> result = null;
		
		try {
			result = DBOperations.executeQuery(con, "select ID_SPRZETU, KATEGORIA , OPIS_SPRZETU from SPRZET where ID_REZERWACJI = " + booID + " and STATUS = 'DOSTEPNY' order by KATEGORIA ASC");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<String> getEqByOrderNull(){
		ArrayList<String> result = null;
		
		try {
			result = DBOperations.executeQuery(con, "select ID_SPRZETU, KATEGORIA, OPIS_SPRZETU from SPRZET where ID_REZERWACJI IS NULL and STATUS = 'DOSTEPNY' order by KATEGORIA ASC");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @returns How many items every status has
	 */
	public ArrayList<String> getEqByStatus()
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
	
	public ArrayList<String> getBookingsByStatus()
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
	
	
	public ArrayList<String> getClientByID(String ID){
		ArrayList<String> result = null;
		
		try {
			result = DBOperations.executeQuery(con, "select * from KLIENCI where ID_KLIENTA = " + ID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public ArrayList<String> getEqByID(String ID){
		ArrayList<String> result = null;
		
		try {
			result = DBOperations.executeQuery(con, "select * from SPRZET where ID_SPRZETU = " + ID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public ArrayList<String> getBooByID(String ID){
		ArrayList<String> result = null;
		
		try {
			result = DBOperations.executeQuery(con, "select * from REZERWACJE where ID_REZERWACJI = " + ID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public ArrayList<String> getEqByCategory(String category){
		ArrayList<String> result = null;
		
		try {
			result = DBOperations.executeQuery(con, "select * from SPRZET where KATEGORIA = '" + category + "'");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
}