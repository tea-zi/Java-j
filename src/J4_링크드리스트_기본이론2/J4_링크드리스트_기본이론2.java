package J4_��ũ�帮��Ʈ_�⺻�̷�2;

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
		Node pre = head; // �����Ұ��� �ٷ������ã��
		for (int i = 0; i < size; i++) { // �����Ұ��� �ٷ������ã��
			pre = pre.next;
		}
		// node.next = pre.next;
		pre.next = node;
		size += 1;

	}
}

public class J4_��ũ�帮��Ʈ_�⺻�̷�2 {
	public static void main(String[] args) {
		// 3) ����Ʈ ==>
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		node1.data = 10;
		node2.data = 20;
		node3.data = 30;
		node1.next = node2;
		node2.next = node3;
//		System.out.println(node1.data);
//		System.out.println(node1.next.data);
//		System.out.println(node1.next.next.data);		
//		Node cur = node1;
//		for(int i =0; i < 3; i++) {
//			System.out.println(cur.data);
//			cur = cur.next;
//		}
		MyList list = new MyList();
//		list.head.next = node1;
//		list.head.next.next = node2;
//		list.head.next.next.next = node3;
//		Node cur = list.head.next; // ù��° ������
//		
//		for(int i = 0; i < 3; i++) {
//			System.out.println(cur.data);
//			cur = cur.next;
//		}	
		list.insert(10);
		list.insert(20);
		list.insert(30);
		Node cur = list.head.next; // ù��° ������

		for (int i = 0; i < list.size; i++) {
			System.out.println(cur.data);
			cur = cur.next;
		}
	}
}