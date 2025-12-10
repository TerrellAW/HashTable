package app;

public class AppDriver 
{
	public static void main(String[] args) {
		System.out.println("\n=== Single Pass Chaining ===\n");
		
		HashTable singleChain = new HashTable();
		singleChain.singlePassChainingInsert(2, 'A');
		singleChain.singlePassChainingInsert(4, 'B');
		singleChain.singlePassChainingInsert(12, 'C');
		singleChain.singlePassChainingInsert(3, 'D');
		singleChain.singlePassChainingInsert(2, 'E');
		singleChain.singlePassChainingInsert(15, 'F');
		singleChain.singlePassChainingInsert(8, 'G');
		singleChain.singlePassChainingInsert(7, 'H');
		singleChain.singlePassChainingInsert(6, 'I');
		singleChain.singlePassChainingInsert(10, 'J');
		singleChain.singlePassChainingInsert(12, 'K');
		singleChain.singlePassChainingInsert(11, 'L');
		singleChain.singlePassChainingInsert(5, 'M');
		singleChain.singlePassChainingInsert(7, 'N');
		singleChain.singlePassChainingInsert(16, 'O');
		singleChain.singlePassChainingInsert(1, 'P');

		System.out.println("Total Reads: 		" + singleChain.getReads());
		System.out.println("Average Reads: 		" + singleChain.getAvgReads());
		System.out.println("Packing Density: 	" + singleChain.getDensity());
		System.out.println("Hashing Efficiency: " + singleChain.getEfficiency());

		System.out.println("\n=== Single Pass Linear ===\n");

		HashTable singleLinear = new HashTable();
		singleLinear.singlePassLinearInsert(2, 'A');
		singleLinear.singlePassLinearInsert(4, 'B');
		singleLinear.singlePassLinearInsert(12, 'C');
		singleLinear.singlePassLinearInsert(3, 'D');
		singleLinear.singlePassLinearInsert(2, 'E');
		singleLinear.singlePassLinearInsert(15, 'F');
		singleLinear.singlePassLinearInsert(8, 'G');
		singleLinear.singlePassLinearInsert(7, 'H');
		singleLinear.singlePassLinearInsert(6, 'I');
		singleLinear.singlePassLinearInsert(10, 'J');
		singleLinear.singlePassLinearInsert(12, 'K');
		singleLinear.singlePassLinearInsert(11, 'L');
		singleLinear.singlePassLinearInsert(5, 'M');
		singleLinear.singlePassLinearInsert(7, 'N');
		singleLinear.singlePassLinearInsert(16, 'O');
		singleLinear.singlePassLinearInsert(1, 'P');

		System.out.println("Total Reads: 		" + singleLinear.getReads());
		System.out.println("Average Reads: 		" + singleLinear.getAvgReads());
		System.out.println("Packing Density: 	" + singleLinear.getDensity());
		System.out.println("Hashing Efficiency: " + singleLinear.getEfficiency());

		System.out.println("\n=== Double Pass Linear ===\n");

		HashTable doubleLinear = new HashTable();
		doubleLinear.firstPassInsert(2, 'A');
		doubleLinear.firstPassInsert(4, 'B');
		doubleLinear.firstPassInsert(12, 'C');
		doubleLinear.firstPassInsert(3, 'D');
		doubleLinear.firstPassInsert(2, 'E');
		doubleLinear.firstPassInsert(15, 'F');
		doubleLinear.firstPassInsert(8, 'G');
		doubleLinear.firstPassInsert(7, 'H');
		doubleLinear.firstPassInsert(6, 'I');
		doubleLinear.firstPassInsert(10, 'J');
		doubleLinear.firstPassInsert(12, 'K');
		doubleLinear.firstPassInsert(11, 'L');
		doubleLinear.firstPassInsert(5, 'M');
		doubleLinear.firstPassInsert(7, 'N');
		doubleLinear.firstPassInsert(16, 'O');
		doubleLinear.firstPassInsert(1, 'P');

		// second pass
		doubleLinear.secondPassInsert();

		System.out.println("Total Reads: 		" + doubleLinear.getReads());
		System.out.println("Average Reads: 		" + doubleLinear.getAvgReads());
		System.out.println("Packing Density: 	" + doubleLinear.getDensity());
		System.out.println("Hashing Efficiency: " + doubleLinear.getEfficiency());
	}
}
