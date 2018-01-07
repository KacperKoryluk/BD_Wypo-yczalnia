
public class GUIMethods {

	public static int hashIDClients(String var1, String var2, int maxValue) {
		int hash = 0, sum = 0;
		boolean freeID = false;
		
		for (int i = 0; i < var1.length(); i++)
			sum += (int) var1.charAt(i);
		for (int i = 0; i < var2.length(); i++)
			sum += (int) var2.charAt(i);
		int j = 1;
		hash = sum % maxValue;

		while (!freeID) {
			if (hash == 0) hash++;
			if (Application.functions.getClientByID(Integer.toString(hash)).size() == 0) freeID = true;
			else hash =  ((int) (hash - Math.pow(j - 1, 2) + Math.pow(j, 2))) % maxValue;
		}		
		
		return hash;
	}
	
	public static int hashIDEq(String var1, String var2, int maxValue) {
		int hash = 0, sum = 0;
		boolean freeID = false;
		
		for (int i = 0; i < var1.length(); i++)
			sum += (int) var1.charAt(i);
		for (int i = 0; i < var2.length(); i++)
			sum += (int) var2.charAt(i);
		int j = 1;
		hash = sum % maxValue;

		while (!freeID) {
			if (hash == 0) hash++;
			if (Application.functions.getEqByID(Integer.toString(hash)).size() == 0 ) 
				freeID = true;
			else hash =  ((int) (hash - Math.pow(j - 1, 2) + Math.pow(j, 2))) % maxValue;
		}		
		
		return hash;
	}
	
	public static int hashIDBoo(long var, int maxValue) {
		int hash = 0;
		boolean freeID = false;
		
		int j = 1;
		hash = (int) (var % maxValue);

		while (!freeID) {
			if (hash == 0) hash++;
			if (Application.functions.getBooByID(Integer.toString(hash)).size() == 0) freeID = true;
			else hash =  ((int) (hash - Math.pow(j - 1, 2) + Math.pow(j, 2))) % maxValue;
		}		
		
		return hash;
	}
}
