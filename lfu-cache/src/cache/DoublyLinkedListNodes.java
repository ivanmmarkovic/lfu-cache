package cache;

class DoublyLinkedListNodes {

	Node head, tail;

	public void removeNode(Node node) {
		if (node == this.head) {
			if (this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
			node.prev = null;
			node.next = null;
		} else if (node == this.tail)
			this.deleteFromTail();
		else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void addToHead(Node node) {
		node.next = null;
		node.prev = null;
		if (this.isEmpty()) {
			this.head = this.tail = node;
		} else {
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
		}
	}

	public Node deleteFromTail() {
		if (this.isEmpty())
			return null;
		else {
			Node retNode = this.tail;
			if (this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			retNode.next = null;
			retNode.prev = null;
			return retNode;
		}
	}

}