package J4_링크드리스트_기본이론1;

class Node {
	int data;
	Node next;
}

public class J4_링크드리스트_기본이론1 {
	public static void main(String[] args) {
		// 리스트 처음부터
		// 자료구조 총 3개
		// 1) 배열 ==> 유한배열

		int arr[] = new int[3];

		// 2) 벡터 ==> 가변배열 , 단점 : 복사가필요하다.
		int vec[] = new int[1000];
		int temp[] = vec;
		vec = new int[1001];
		for (int i = 0; i < 1000; i++) {
			vec[i] = temp[i];
		}
		// 3) 리스트 ==>
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		node1.data = 10;
		node2.data = 20;
		node3.data = 30;
		node1.next = node2;
		node2.next = node3;

		System.out.println(node1.data);
		System.out.println(node1.next.data);
		System.out.println(node1.next.next.data);

	}
}