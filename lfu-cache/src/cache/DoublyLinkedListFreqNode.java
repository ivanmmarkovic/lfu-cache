package cache;

public class DoublyLinkedListFreqNode {
	
	FreqNode head, tail;

	public void removeFreqNode(FreqNode oldFreqNode) {
		if(this.isEmpty())
			return;
		else if(this.head == oldFreqNode) {
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
		}
		else if(this.tail == oldFreqNode) {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		else {
			oldFreqNode.prev.next = oldFreqNode.next;
			oldFreqNode.next.prev = oldFreqNode.prev;
		}
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head == null;
	}

	public void insertAfter(FreqNode oldFreqNode, FreqNode newFreqNode) {
		newFreqNode.next = null;
		newFreqNode.prev = null;
		if(this.tail == oldFreqNode) {
			newFreqNode.prev = this.tail;
			this.tail.next = newFreqNode;
			this.tail = newFreqNode;
		}
		else {
			newFreqNode.prev = oldFreqNode;
			newFreqNode.next = oldFreqNode.next;
			oldFreqNode.next = newFreqNode;
			newFreqNode.next.prev = newFreqNode;
		}
	}

	public void addToHead(FreqNode freqNode) {
		freqNode.next = null;
		freqNode.prev = null;
		if(this.isEmpty())
			this.head = this.tail = freqNode;
		else {
			freqNode.next = this.head;
			this.head.prev = freqNode;
			this.head = freqNode;
		}
	}

	public void deleteFromHead() {
		if(this.isEmpty())
			return;
		else {
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
		}
		
	}

}


