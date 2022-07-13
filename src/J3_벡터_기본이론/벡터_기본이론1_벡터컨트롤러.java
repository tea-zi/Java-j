package J3_벡터_기본이론;

import java.util.Scanner;

public class 벡터_기본이론1_벡터컨트롤러 {
//	 # 배열 컨트롤러(무한배열) : 벡터(Vector)
//	 1. 추가
//	  . 값을 입력받아 순차적으로 추가
//	 2. 삭제(인덱스)
//	  . 인덱스를 입력받아 해당 위치의 값 삭제
//	 3. 삭제(값)
//	  . 값을 입력받아 삭제
//	  . 없는 값 입력 시 예외처리
//	 4. 삽입
//	  . 인덱스와 값을 입력받아 삽입
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] score = null;
		int count = 0;

		while (true) {

			for (int i = 0; i < count; i++) {
				System.out.print(score[i] + " ");
			}
			System.out.println();

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");

			System.out.println("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (count == 0) {
					score = new int[count + 1];
				} else if (count > 0) {
					int temp[] = score;
					score = new int[count + 1];

					for (int i = 0; i < count; i++) {
						score[i] = temp[i];
					}
					temp = null;
				}

				System.out.println("성적 입력 : ");
				int data = scan.nextInt();

				score[count] = data;
				count++;
			} else if (sel == 2) {
				System.out.print("인덱스 입력 : ");
				int index = scan.nextInt();

				if (count - 1 < index || index < 0) {
					System.out.println("해당위치는 삭제할 수 없습니다.");
					continue;
				}

				if (count == 1) {
					score = null;
				} else if (count > 1) {
					int[] temp = score;
					score = new int[count - 1];

					for (int i = 0; i < index; i++) {
						score[i] = temp[i + 1];
					}
					for (int i = index; i < count - 1; i++) {
						score[i] = temp[i + 1];
					}
					temp = null;
				}
				count--;
			} else if (sel == 3) {
				System.out.print("값 입력 : ");
				int data = scan.nextInt();

				int index = -1;
				int cnt = 0;
				for (int i = 0; i < count; i++) {
					if (data == score[i]) {
						index = i;
						cnt++;
					}
				}

				if (index == -1) {
					System.out.println("입력하신 값은 존재하지 않습니다.");
					continue;
				}

				if (index == 1 && cnt == 1) {
					score = null;
				} else if (index > 1 && cnt == 1) {
					int temp[] = score;
					score = new int[count - 1];

					int j = 0;
					for (int i = 0; i < count; i++) {
						if (i != index) {
							score[j] = temp[i];
							j++;
						}
					}
					temp = null;
				}
				count--;

				if (cnt > 1) {
					System.out.println("중복된 값이 있습니다.");
				}
			} else if (sel == 4) {
				System.out.print("인덱스 입력 : ");
				int index = scan.nextInt();

				if (index > count || index < 0) {
					System.out.println("해당 위치는 삽입할 수 없습니다.");
					continue;
				}

				System.out.print("값 입력 : ");
				int data = scan.nextInt();

				if (count == 0) {
					score = new int[count + 1];
				} else if (count > 0) {
					int temp[] = score;
					score = new int[count + 1];

					int j = 0;
					for (int i = 0; i < count + 1; i++) {
						if (i != index) {
							score[i] = temp[j];
							j++;
						}
					}
					temp = null;
				}
				score[index] = data;
				count++;
			} else if (sel == 0) {
				break;
			}
		}
	}
}
