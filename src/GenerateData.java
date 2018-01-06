import java.util.ArrayList;

public class GenerateData {
	
	
	public static ArrayList<String> gibClientDataPls()throws Exception{
		ArrayList<String> outputResult=new ArrayList<String>();
		
		outputResult.add("1\tSzymon\tWiœniewski\tszymon.w@gmail.com\t96112208137\t11111111");
		outputResult.add("2\tKarol\tDuda\tkarol.d@gmail.com\t78032702612\t22222222");
		outputResult.add("3\tJakub\tMadej\tjakub.m@o2.pl\t58032000712\t33333333");

		return outputResult;
	}
	public static ArrayList<String> gibEqDataPls()throws Exception{
		ArrayList<String> outputResult=new ArrayList<String>();
		
		outputResult.add("1\tnull\tDOSTEPNY\tGRANAT\tbum hehe");
		outputResult.add("2\tnull\tDOSTEPNY\tGRANAT\tbum hehe");
		outputResult.add("3\tnull\tUSZKODZONY\tGRANAT\tnie bum :(");
		outputResult.add("4\tnull\tDOSTEPNY\tCZOLG\tpancerny");
		outputResult.add("5\tnull\tKONSERWACJA\tCZOLG\tdziurawy");
		outputResult.add("6\tnull\tDOSTEPNY\tROWER\tdwa kola");
		outputResult.add("7\tnull\tNIEDOSTEPNY\tROWER\tsmieszne");

		return outputResult;
	}
	
	public static ArrayList<String> gibBooDataPls()throws Exception{
		ArrayList<String> outputResult=new ArrayList<String>();
		
		outputResult.add("1\t2\t2018-01-05 00:00:00.0\tNIEOPLACONA\t2018-12-13 00:00:00.0");
		outputResult.add("2\t1\t2017-09-01 00:00:00.0\tARCHIWUM\t2017-09-17 00:00:00.0");


		return outputResult;
	}

	//-------------------------------------------
	//Nowe rzeczy, wytnij sobie co potrzebujesz
	
	public static ArrayList<String> generateBookingStuffPls()
	{
		ArrayList<String> outputResult=new ArrayList<String>();
		//ID KLIENTA/IMIE/NAZWISKO/ID REZERWACJI/ID SPRZETU/DATA REZERWACJI/DATA WYGASNIECIA
		outputResult.add("1\tSzymon\tWiœniewski\t2\t3\t17-09-01 00:00:00.0\t17-09-17 00:00:00.0");
		outputResult.add("1\tSzymon\tWiœniewski\t2\t5\t17-09-01 00:00:00.0\t17-09-17 00:00:00.0");
		outputResult.add("2\tKarol\tDuda\t1\t7\t18-01-05 00:00:00.0\t18-12-13 00:00:00.0");
		
		
		return outputResult;
	}
	
	public static ArrayList<String> simulateGroupBookingsByStatus()
	{
		ArrayList<String> outputResult=new ArrayList<String>();
		outputResult.add("ARCHIWUM\t1");
		outputResult.add("NIEOPLACONA\t1");
		
		return outputResult;
	}
	
	public static ArrayList<String> simulateGroupEqByStatus()
	{
		ArrayList<String> outputResult=new ArrayList<String>();
		outputResult.add("DOSTEPNY\t4");
		outputResult.add("KONSERWACJA\t1");
		outputResult.add("NIEDOSTEPNY\t1");
		outputResult.add("USZKODZONY\t1");
		
		return outputResult;
	}
	
	public static ArrayList<String> simulateGroupEqByCategory()
	{
		ArrayList<String> outputResult=new ArrayList<String>();
		outputResult.add("CZOLG\t2");
		outputResult.add("GRANAT\t3");
		outputResult.add("ROWER\t2");
		
		
		return outputResult;
	}
	
	//-------------------------------------0----
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<String> Bookings = gibBooDataPls();
			ArrayList<String> Clients = gibClientDataPls();
			ArrayList<String> Eq = gibEqDataPls();
			
			
			ArrayList<String> re = Eq;
			String[] parts = null;
			for (String s : re)
			{
				System.out.println(s);
				parts = s.split("\t");
				for (int i = 0; i < parts.length; i++)
				{
					System.out.println(parts[i]);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
