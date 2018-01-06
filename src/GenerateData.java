import java.util.ArrayList;

public class GenerateData {
	
	private static ArrayList<String> Clients, Eq, Boo;
	
	public static void generateClients() {
		Clients = new ArrayList<String>();
		Clients.add("1\tSzymon\tWiœniewski\tszymon.w@gmail.com\t96112208137\t11111111");
		Clients.add("2\tKarol\tDuda\tkarol.d@gmail.com\t78032702612\t22222222");
		Clients.add("3\tJakub\tMadej\tjakub.m@o2.pl\t58032000712\t33333333");
		
	}
	
	public static void generateEq() {
		Eq = new ArrayList<String>();
		Eq.add("1\tnull\tDOSTEPNY\tGRANAT\tbum hehe");
		Eq.add("2\tnull\tDOSTEPNY\tGRANAT\tbum hehe");
		Eq.add("3\tnull\tUSZKODZONY\tGRANAT\tnie bum :(");
		Eq.add("4\tnull\tDOSTEPNY\tCZOLG\tpancerny");
		Eq.add("5\tnull\tKONSERWACJA\tCZOLG\tdziurawy");
		Eq.add("6\tnull\tDOSTEPNY\tROWER\tdwa kola");
		Eq.add("7\tnull\tNIEDOSTEPNY\tROWER\tsmieszne");
	}
	
	public static void generateBoo() {
		Boo = new ArrayList<String>();
		Boo.add("1\t2\t2018-01-05 00:00:00.0\tNIEOPLACONA\t2018-12-13 00:00:00.0");
		Boo.add("2\t1\t2017-09-01 00:00:00.0\tARCHIWUM\t2017-09-17 00:00:00.0");

	}
	
	public static void deleteRowClients(String ID) {
		ArrayList<String> buf = new ArrayList<String>();
		for (int i = 0; i < Clients.size(); i++) 
			if (Clients.get(i).split("\t")[0].compareTo(ID) != 0)
				buf.add(Clients.get(i));

		Clients = buf;
	}
	
	public static void deleteRowBoo(String ID) {
		ArrayList<String> buf = new ArrayList<String>();
		for (int i = 0; i < Boo.size(); i++) 
			if (Boo.get(i).split("\t")[0].compareTo(ID) != 0)
				buf.add(Boo.get(i));

		Boo = buf;
	}
	
	public static void deleteRowEq(String ID) {
		ArrayList<String> buf = new ArrayList<String>();
		for (int i = 0; i < Eq.size(); i++) 
			if (Eq.get(i).split("\t")[0].compareTo(ID) != 0)
				buf.add(Eq.get(i));

		Eq = buf;
	}
	
	public static String getIdClient(String ID) {
		for (int i = 0; i < Clients.size(); i++)
			if (Clients.get(i).split("\t")[0].compareTo(ID) == 0)
				return Clients.get(i);
		
		return null;
	}
	
	public static void addRowClient(String ID, String Name, String Surname, 
									String email, String PESEL, String phone) {
		Clients.add(ID + "\t" + Name + "\t" + Surname + "\t" + email + "\t" + PESEL + "\t" + phone);
	}
	
	public static void addRowBoo(String ID, String IDEq, String BookDate, 
								 String Status, String BookEnd) {
		Boo.add(ID + "\t" + IDEq + "\t" + BookDate + "\t" + Status + "\t" + BookEnd);
	}
	
	public static void addRowEq(String ID, String IDBoo, String Status, 
								String Cat, String Descr) {
		Eq.add(ID + "\t" + IDBoo + "\t" + Status + "\t" + Cat + "\t" + Descr);
	}
	
	public static void updateClient(String ID, String Name, String Surname, 
			String email, String PESEL, String phone) {
		for (int i = 0; i < Clients.size(); i++) 
			if (Clients.get(i).split("\t")[0].compareTo(ID) == 0) {
				GenerateData.deleteRowClients(ID);
				GenerateData.addRowClient(ID, Name, Surname, email, PESEL, phone);
			}
	}
	
	public static void updateEq(String ID, String IDBoo, String Status, 
								String Cat, String Descr) {
		for (int i = 0; i < Clients.size(); i++) 
			if (Eq.get(i).split("\t")[0].compareTo(ID) == 0) {
				GenerateData.deleteRowEq(ID);
				GenerateData.addRowEq(ID, IDBoo, Status, Cat, Descr);
			}
	}
	
	public static void updateBoo(String ID, String IDEq, String BookDate, 
			 String Status, String BookEnd) {
		for (int i = 0; i < Clients.size(); i++) 
			if (Boo.get(i).split("\t")[0].compareTo(ID) == 0) {
				GenerateData.deleteRowBoo(ID);
				GenerateData.addRowBoo(ID, IDEq, BookDate, Status, BookEnd);
			}
	}
	
	public static ArrayList<String> gibClientDataPls()throws Exception{
		return Clients;
	}public GenerateData() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<String> gibEqDataPls()throws Exception{
		return Eq;
	}
	
	public static ArrayList<String> gibBooDataPls()throws Exception{
		return Boo;
	}

}
