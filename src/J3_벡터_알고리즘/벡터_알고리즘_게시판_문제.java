package J3_벡터_알고리즘;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class 벡터_알고리즘_게시판_문제 {
//	  # 콘솔 게시판 - [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다. 
//	  - 메인화면에는 [번호][제목] 만 표시되고 해당번호를 선태갛면 [내용]을 볼수있다. 
//	  - 현재 페이지 번호에 해당되는 게시글만 볼 수 있다. 
//	  - numberList ==> 번호 , subjectList ==> 제목 , contentList ==> 내용 
//	  - 파일입출력을 통해 데이터가 저장된다. 
//	  - 저장되어 있는 파일이 존재한다면, 파일을 불러오도록 설계한다.

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String fileName = "src/J3_벡터_알고리즘/board.txt";

		int[] numberList = null; // 번호
		String[] subjectList = null; // 제목
		String[] contentList = null; // 내용

		int count = 0; // 전체 게시글 수
		int pageSize = 5; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = count; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호

		while (true) {
			pageCount = count / pageSize;
			if (count % pageSize > 0) {
				pageCount += 1;
			}
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			if (count == 0) {
				System.out.println("게시물이 없습니다.");
			} else if (count > 0) {
				startRow = (curPageNum - 1) * pageSize; // 0부터 시작
				endRow = startRow + pageSize; // 미만
				if (endRow > count) {
					endRow = count;
				}
//				System.out.println(count);
//				System.out.println(startRow + " " + endRow);
				for (int i = startRow; i < endRow; i++) {
					System.out.printf("%3d | %-20s\n", numberList[i], subjectList[i]);
				}
			}
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("[1 . 이전]");
			System.out.print("[현재 페이지 : " + curPageNum + "]");
			System.out.println("[2 . 이후]");
			System.out.print("[3]추가하기");
			System.out.print("[4]삭제하기");
			System.out.println("[5]내용확인");
			System.out.print("[6]저장");
			System.out.println("[7]로드");

			int choice = scan.nextInt();
			scan.nextLine();

			if (choice == 1) { // 이전
				if (curPageNum == 1) {
					System.out.println("첫번째 페이지 입니다.");
					continue;
				}
				curPageNum--;
			} else if (choice == 2) { // 이후
				if (curPageNum == pageCount) {
					System.out.println("마지막 페이지 입니다.");
					continue;
				}
				curPageNum++;
			} else if (choice == 3) { // 추가하기

				System.out.print("제목 : ");
				String ti = scan.nextLine();

				int numTemp[] = numberList;
				String[] subjectTemp = subjectList;
				String[] contentTemp = contentList;

				numberList = new int[count + 1];
				subjectList = new String[count + 1];
				contentList = new String[count + 1];

				for (int i = 0; i < count; i++) {
					numberList[i] = numTemp[i];
					subjectList[i] = subjectTemp[i];
					contentList[i] = contentTemp[i];
				}

				numberList[count] = count;
				subjectList[count] = ti;

				System.out.print("내용 입력 : ");
				String content = scan.nextLine();
				contentList[count] = content;

				count++;
			} else if (choice == 4) { // 삭제하기
				if (count == 0) {
					System.out.println("삭제할 게시물이 없습니다.");
					continue;
				}
				System.out.print("번호 입력 : ");
				int num = scan.nextInt();
				if (startRow <= num && endRow >= num) {
					int numTemp[] = numberList;
					String subjectTemp[] = subjectList;
					String contentTemp[] = contentList;

					numberList = new int[count - 1];
					subjectList = new String[count - 1];
					contentList = new String[count - 1];

					for (int i = 0; i < count - 1; i++) {
						numberList[i] = numTemp[i];
					}
					int j = 0;
					for (int i = 0; i < count; i++) {
						if (num != i) {
							subjectList[j] = subjectTemp[i];
							contentList[j] = contentTemp[i];
							j++;
						}
					}
				}
			} else if (choice == 5) { // 내용확인
				System.out.print("번호 입력 : ");
				int num = scan.nextInt();
				if (startRow <= num && endRow > num) {
					System.out.println("내용-------------------------------");
					System.out.println(contentList[num]);
				}
			} else if (choice == 6) { // 저장
				String data = "";

				try {
					FileWriter fw = new FileWriter(fileName);

					for (int i = 0; i < count; i++) {
						data += numberList[i];
						data += ",";
						data += subjectList[i];
						data += ",";
						data += contentList[i];
						data += "\n";
					}
					fw.write(data);
					fw.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else if (choice == 7) { // 로드
				String data = "";

				try {
					FileReader fr = new FileReader(fileName);

					while (true) {
						int read = fr.read();
						if (read == -1) {
							break;
						}
						data += (char) read;
					}
					fr.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				String[] token = data.split("\n");
				count = token.length;
				numberList = new int[count];
				subjectList = new String[count];
				contentList = new String[count];

				for (int i = 0; i < count; i++) {
					String[] token2 = token[i].split(",");
					numberList[i] = Integer.parseInt(token2[0]);
					subjectList[i] = token2[1];
					contentList[i] = token2[2];

				}
			} else if (choice == 0) {
				break;
			}
		}

	}
}