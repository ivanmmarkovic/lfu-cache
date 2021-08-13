package cache;

public class FreqNode {

	int freq;
	FreqNode next;
	DoublyLinkedListNodes nodes;
	public FreqNode prev;

	public FreqNode(int freq) {
		// TODO Auto-generated constructor stub
		this.freq = freq;
		this.nodes = new DoublyLinkedListNodes();
	}

}
