package J3_벡터_알고리즘;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class 벡터_알고리즘_게시판_정답 {
	/*
	 * # 콘솔 게시판 1. [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다. 2. 현재 페이지 번호에 해당되는 게시글만 볼 수
	 * 있다. 3. 2차원 배열 board에 0열에는 제목을 1열에는 게시글의 내용을 저장한다. 4. 파일입출력을 통해 데이터가 저장된다. 5.
	 * 저장되어 있는 파일이 존재한다면, 파일을 불러오도록 설계한다.
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String fileName = "src/J3_벡터_알고리즘/board.txt";

		int[] numberList = null;
		String[] subjectList = null;
		String[] contentList = null;

		int count = 0; // 전체 게시글 수
		int pageSize = 5; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = 0; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호

		int number = 1;
		while (true) {

			pageCount = count / pageSize;
			if (count % pageSize > 0) {
				pageCount += 1;
			}

			startRow = (curPageNum - 1) * pageSize; // 0부터 시작
			endRow = startRow + pageSize; // 미만
			if (endRow > count) {
				endRow = count;
			}

			System.out.println("게시판 (" + count + ")개");
			System.out.println("현재 페이지 : " + curPageNum);
			for (int i = startRow; i < endRow; i++) {
				String print = "";
				print += numberList[i];
				print += ":";
				print += subjectList[i];
				System.out.println(print);

			}
			System.out.println();

			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");
			System.out.println("[6]저장");
			System.out.println("[7]로드");

			int choice = scan.nextInt();

			if (choice == 1) {
				if (curPageNum == 1) {
					continue;
				}
				curPageNum -= 1;
			} else if (choice == 2) {
				if (curPageNum >= pageCount) {
					continue;
				}
				curPageNum += 1;
			} else if (choice == 3) {
				if (count == 0) {
					numberList = new int[1];
					subjectList = new String[1];
					contentList = new String[1];

				} else if (count > 0) {
					int[] tempNum = numberList;
					String[] tempSub = subjectList;
					String[] tempCont = contentList;

					numberList = new int[count + 1];
					subjectList = new String[count + 1];
					contentList = new String[count + 1];
					for (int i = 0; i < count; i++) {
						numberList[i] = tempNum[i];
						subjectList[i] = tempSub[i];
						contentList[i] = tempCont[i];
					}

				}

				numberList[count] = number;
				System.out.print("게시글 제목을 입력하세요 : ");
				subjectList[count] = scan.next();

				System.out.print("게시글 내용을 입력하세요 : ");
				contentList[count] = scan.next();

				count += 1;

			} else if (choice == 4) {

			} else if (choice == 5) {
				System.out.print("게시글 번호를 입력하세요 : ");
				int num = scan.nextInt();
				num -= 1;

				if (startRow <= num && num < endRow) {
					System.out.println("내용 = " + contentList[num]);
				}
			} else if (choice == 6) {

			} else if (choice == 7) {

			} else if (choice == 0) {
				break;
			}
		}

		scan.close();
	}
}