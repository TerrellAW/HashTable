import java.util.*;

public class Main
{
	public static void main(String args[]) {
		final int size = 20;
		int readCount = 0;
		int numElements = 0;
		double packingDensity = 0;
		Hashtable<Integer, String> table = new Hashtable<>(size);

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

		System.out.println("\nSingle Pass Loading");
		System.out.println("HSH  |  KEY  |  VAL");
		for (Integer key : table.keySet()) {
			// Read and increment count
			String value = table.get(key);
			readCount++;
			
			// Packing density
			numElements++;
			packingDensity = (double) numElements / size;

			System.out.println(key.hashCode() % size + "\t" + key + "\t" + table.get(key));
		}

		System.out.println("Single Pass Stats");
		System.out.println("Total successful reads: " + readCount);
		System.out.println("Packing density: " + packingDensity);
		readCount = 0;
		numElements = 0;

		System.out.println("\nDouble Pass Loading");
		System.out.println("HSH  |  KEY  |  VAL");
		for (Integer key : table.keySet()) {
			// Read and increment count
			String value = table.get(key);
			readCount++;

			// Packing density
			numElements++;
			packingDensity = (double) numElements / (size * 2);

			System.out.println(key.hashCode() % (size * 2) + "\t" + key + "\t" + table.get(key));
		}

		System.out.println("Double Pass Stats");
		System.out.println("Total successful reads: " + readCount);
		System.out.println("Packing density: " + packingDensity);
	}
}
