package cache;

public class Node {

	int key;
	int value;
	int freq;
	public Node next;
	public Node prev;

	public Node(int key, int value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
		this.freq = 1;
	}

}
