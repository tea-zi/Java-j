package J4_링크드리스트_기본이론3;

import java.util.LinkedList;

class Node {
	int data;
	Node next;
}

class MyList {
	int size;
	Node head = new Node();

	void insert(int value) {
		Node node = new Node();
		node.data = value;
		Node pre = head;
		for (int i = 0; i < size; i++) {
			pre = pre.next;
		}
		pre.next = node;
		size += 1;
	}

	void print() {
		Node cur = head.next;
		for (int i = 0; i < size; i++) {
			System.out.println(cur.data);
			cur = cur.next;
		}
		System.out.println("------------------------");
	}

	void delete(int index) {
		Node pre = head;
		for (int i = 0; i < index; i++) {
			pre = pre.next;
		}
		Node del = pre.next;
		pre.next = del.next;
		size -= 1;
	}

	void set(int index, int value) {
		Node node = new Node();
		node.data = value;
		Node pre = head;
		for (int i = 0; i < index; i++) {
			pre = pre.next;
		}
		node.next = pre.next;
		pre.next = node;
		size += 1;
	}
}

public class J4_링크드리스트_기본이론3 {
	public static void main(String[] args) {
		MyList myList = new MyList();
		myList.insert(10);
		myList.insert(20);
		myList.insert(30);
		myList.print();
		myList.delete(2);
		myList.print();
		myList.set(1, 50);
		myList.print();

	}
}