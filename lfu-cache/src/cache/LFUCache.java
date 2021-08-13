package cache;

import java.util.HashMap;

public class LFUCache {
    
    
	
	int count, capacity;
	HashMap<Integer, Node> nodesMap;
	HashMap<Integer, FreqNode> freqNodesMap;
	DoublyLinkedListFreqNode freqNodesList;
	public LFUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		this.nodesMap = new HashMap<>();
		this.freqNodesMap = new HashMap<>();
		this.freqNodesList = new DoublyLinkedListFreqNode();
    }
    
    public int get(int key) {
		if(this.nodesMap.containsKey(key)) {
			Node node = this.nodesMap.get(key);
			this.updateNodeInFreqNodesList(node);
			return node.value;
		}
		else {
			return -1;
		}
		
    }

	public void put(int key, int value) {
    	Node newNode;
        if(this.nodesMap.containsKey(key)) {
        	newNode = this.nodesMap.get(key);
        	newNode.value = value;
        	this.updateNodeInFreqNodesList(newNode);
        }
        else {
            if(this.capacity == 0)
        		return;
        	if(this.count == this.capacity) {
        		FreqNode headFreqNode = this.freqNodesList.head;
        		Node oldNode = headFreqNode.nodes.deleteFromTail();
        		this.nodesMap.remove(oldNode.key);
        		if(headFreqNode.nodes.isEmpty()) {
        			this.freqNodesMap.remove(headFreqNode.freq);
        			this.freqNodesList.deleteFromHead();
        		}
        		this.count--;
        	}
        	newNode = new Node(key, value);
        	this.nodesMap.put(key, newNode);
        	FreqNode freqNode;
        	if(this.freqNodesMap.containsKey(1)) {
        		freqNode = this.freqNodesMap.get(1);
        		freqNode.nodes.addToHead(newNode);
        	}
        	else {
        		freqNode = new FreqNode(1);
        		freqNode.nodes.addToHead(newNode);
        		this.freqNodesMap.put(1, freqNode);
        		this.freqNodesList.addToHead(freqNode);
        	}
        	
        	
        	this.count++;
        }
    }
	
	private void updateNodeInFreqNodesList(Node node) {
		int oldFreq = node.freq;
		FreqNode oldFreqNode = this.freqNodesMap.get(oldFreq);
		oldFreqNode.nodes.removeNode(node);
		
		node.freq++;
		int newFreq = node.freq;
		FreqNode newFreqNode;
		if(this.freqNodesMap.containsKey(newFreq)) {
			newFreqNode = this.freqNodesMap.get(node.freq);
			newFreqNode.nodes.addToHead(node);
		}
		else {
			newFreqNode = new FreqNode(node.freq);
			newFreqNode.nodes.addToHead(node);
			this.freqNodesMap.put(node.freq, newFreqNode);
			this.freqNodesList.insertAfter(oldFreqNode, newFreqNode);
		}
		
		if(oldFreqNode.nodes.isEmpty()) {
			this.freqNodesList.removeFreqNode(oldFreqNode);
			this.freqNodesMap.remove(oldFreq);
		}
		
	}
}
