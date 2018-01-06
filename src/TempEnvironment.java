import java.sql.*;
import java.util.*;
public class TempEnvironment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBFunctions fun = new DBFunctions();

		ArrayList<String> re = null;
//		re = fun.getTableContent("klienci");
//		for (String s : re)
//		{
//			System.out.println(s);
//		}
//		System.out.println("---------------------------------------------");
//		//System.out.println(fun.addClient("11", "11", "11", "11", "11", "11"));
//		System.out.println("---------------------------------------------");
////		fun.addBooking("1", "8", "22-12-18");
////		System.out.println(fun.deleteBooking("42"));
//		System.out.println(fun.findClient("11", "11"));
		re = fun.findBookingsByStatus("NIEOPLACONA");
		System.out.println("---------------------------------------------");
		for (String s : re)
		{
			System.out.println(s);
		}
		
//		System.out.println("---------------------------------------------");
//		System.out.println(fun.deleteClient("25", "11"));
//		System.out.println("---------------------------------------------");
//		re = fun.getTableContent("rezerwacje");
//		
//		String[] parts = null;
//		for (String s : re)
//		{
//
//			parts = s.split("\t");
//			for (int i = 0; i < parts.length; i++)
//			{
//				System.out.println(parts[i]);
//			}
//		}
	}

}
