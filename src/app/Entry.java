package app;

import java.util.LinkedList;

public class Entry {
	public int key;
	public char value;
	Entry next; // Pointer to next entry in chain

	public Entry(int key, char value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
