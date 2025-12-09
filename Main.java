import java.util.*;

public class Main
{
	public static void main(String args[]) {
		Hashtable<Integer, String> table = new Hashtable<>(20);

		table.put(2, "A");
		table.put(4, "B");
		table.put(12, "C");
		table.put(3, "D");
		table.put(2, "E");
		table.put(15, "F");
		table.put(8, "G");
		table.put(7, "H");
		table.put(6, "I");
		table.put(10, "J");
		table.put(12, "K");
		table.put(11, "L");
		table.put(5, "M");
		table.put(7, "N");
		table.put(16, "O");
		table.put(1, "P");

		for (Integer key : table.keySet()) {
			System.out.println(key + "\t" + table.get(key));
		}
	}
}
