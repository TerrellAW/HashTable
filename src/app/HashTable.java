package app;

import java.util.ArrayDeque;
import java.util.Queue;

public class HashTable 
{
	private Entry[] table;  				// Array of key value pairs which contain LinkedLists
	private int reads; 						// Count total reads
	private int count; 						// Count total records in LinkedLists in entries
	private final int size = 20;			// size of hash table
	private Queue<Entry> collisionQueue;	// queue that contains collisions

	// Return amount of reads
	public int getReads() {
		return reads;
	}

	// Return amount of records
	public int getCount() {
		return count;
	}

	// Return size of table
	public int getSize() {
		return size;
	}

	// Calc and return packing density
	public float getDensity() {
		return (float) count / size;
	}

	// Calc and return amount of reads per record
	public float getAvgReads() {
		if (count == 0) return 0;
		return (float) reads / count;
	}

	// Calc and return hashing efficiency
	public float getEfficiency() {
		if (getAvgReads() == 0) return 0;
		return (float) getDensity() / getAvgReads();
	}

	// Get index with modulo for bounds checking
	private int getIndex(int key) {
		return key % size;
	}

	// Initialize Hashing Table
	public HashTable() {
		this.table = new Entry[size];
		this.reads = 0;
		this.count = 0;
		this.collisionQueue = new ArrayDeque<>();
	}

	public void singlePassChainingInsert(int key, char value) {
		int index = getIndex(key);
		Entry entry = new Entry(key, value);
		this.count++;

		if (table[index] == null) {
			table[index] = entry;
			this.reads++;
		} else {
			Entry current = table[index];
			// traverse chain
			while (current.next != null) {
				current = current.next;
				this.reads++;
			}
			current.next = entry; // append to end of chain
		}
	}

	public void singlePassLinearInsert(int key, char value) {
		int i = 0;
		int index = getIndex(key);
		int newIndex = index;

		while (table[newIndex] != null) {
			this.reads++;
			i++;
			newIndex = (index + i) % size;
			if (i >= size) throw new RuntimeException("Table full during linear insert");
		}

		this.count++;
		this.reads++;
		table[newIndex] = new Entry(key, value);
	}

	public void firstPassInsert(int key, char value) {
		int index = getIndex(key);
		this.reads++;
		this.count++;

		if (table[index] == null) {
			table[index] = new Entry(key, value);
		} else {
			collisionQueue.add(new Entry(key, value));
		}
	}

	public void secondPassInsert() {
		while (!collisionQueue.isEmpty()) {
			Entry entry = collisionQueue.poll();
			this.reads++;
			int index = getIndex(entry.key);
			int newIndex = index;
			int i = 0;

			while (table[newIndex] != null) {
				this.reads++;
				i++;
				newIndex = (index + i) % size;
				if (i >= size) throw new RuntimeException("Table full during second pass");
			}

			this.reads++;
			table[newIndex] = entry;
		}
	}
}
