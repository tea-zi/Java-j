package J3_벡터_기본이론;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class 벡터_기본이론2_학생관리 {
	public static void main(String[] args) {
		// 2차원배열 컨트롤러

		// 데이터 저장 방식 : 번호 + 점수3개
		// 예) 1001, 20, 30, 40
		// 예) 1002, 40, 60, 60
		// 예) 1003, 10, 20, 30

		Scanner scan = new Scanner(System.in);

		int[] numberList = null;
		int[][] scoreList = null;
		int count = 0;
		int num = 1001;
		String fileName = "src/J3_벡터_기본이론/file01.txt";
		while (true) {

			for (int i = 0; i < count; i++) {
				System.out.print(numberList[i] + " ");
				for (int j = 0; j < 3; j++) {
					System.out.print(scoreList[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[0]종료");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(학생번호)");
			System.out.println("[4]삽입");
			System.out.println("[5]저장");
			System.out.println("[6]로드");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) { // 추가
				if (count == 0) {
					numberList = new int[1];
					scoreList = new int[1][3];
				} else {
					int[] numTemp = numberList;
					int[][] scoreTemp = scoreList;

					numberList = new int[count + 1];
					scoreList = new int[count + 1][];
					scoreList[count] = new int[3];

					for (int i = 0; i < count; i++) {
						numberList[i] = numTemp[i];
						scoreList[i] = scoreTemp[i];
					}
				}

				numberList[count] = num;
				for (int i = 0; i < 3; i++) {
					System.out.println("과목" + (i + 1) + " 점수 : ");
					scoreList[count][i] = scan.nextInt();
				}
				num += 1;
				count += 1;

			} else if (sel == 2) { // 인덱스 삭제
				System.out.print("인덱스 입력 : ");
				int index = scan.nextInt();

				if (index < 0 || index > count) {
					System.out.println("해당위치에 정보가 없습니다.");
					continue;
				}

				if (count == 1) {
					numberList = null;
					scoreList = null;
				} else if (count > 1) {
					int[] numtemp = numberList;
					int[][] scoretemp = scoreList;

					numberList = new int[count - 1];
					scoreList = new int[count - 1][];

					int j = 0;
					for (int i = 0; i < count; i++) {
						if (index != i) {
							numberList[j] = numtemp[i];
							scoreList[j] = scoretemp[i];
							j++;
						}
					}
				}
				count--;
			} else if (sel == 3) { // 학생번호 삭제
				System.out.print("학생번호 입력 : ");
				int number = scan.nextInt();

				int index = -1;
				for (int i = 0; i < count; i++) {
					if (number == numberList[i]) {
						index = i;
					}
				}

				if (index == -1) {
					System.out.println("없는 학생번호 입니다.");
					continue;
				}
				if (count == 1) {
					numberList = null;
					scoreList = null;
				} else if (count > 1) {
					int numTemp[] = numberList;
					int scoreTemp[][] = scoreList;
					numberList = new int[count - 1];
					scoreList = new int[count - 1][];

					int j = 0;
					for (int i = 0; i < count; i++) {
						if (index != i) {
							numberList[j] = numTemp[i];
							scoreList[j] = scoreTemp[i];
							j++;
						}
					}

				}
				count--;
			} else if (sel == 4) { // 삽입
				System.out.print("인덱스 입력 : ");
				int index = scan.nextInt();

				if (index < 0 || index > count) {
					System.out.println("해당위치에 정보가 없습니다.");
					continue;
				}

				int score[] = new int[3];
				for (int i = 0; i < 3; i++) {
					System.out.printf("과목 %d 점수 입력 : ", i + 1);
					score[i] = scan.nextInt();
				}

				if (count == 0) {
					numberList = new int[1];
					scoreList = new int[1][3];
				} else if (count > 0) {
					int[] numTemp = numberList;
					int[][] scoreTemp = scoreList;
					numberList = new int[count + 1];
					scoreList = new int[count + 1][];

					int j = 0;
					for (int i = 0; i < count + 1; i++) {
						if (index != i) {
							numberList[i] = numTemp[j];
							scoreList[i] = scoreTemp[j];
							j++;
						}
					}
				}
				numberList[index] = num;
				scoreList[index] = score;
				num++;
				count++;
			} else if (sel == 5) { // 저장
				String data = "";

				try {
					FileWriter fw = new FileWriter(fileName);

					for (int i = 0; i < count; i++) {
						data += numberList[i];
						for (int j = 0; j < 3; j++) {
							data += ",";
							data += scoreList[i][j];

						}
						data += "\n";

					}
					System.out.println(data);
					fw.write(data);
					fw.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else if (sel == 6) { // 로드
				String data = "";

				try {
					FileReader fr = new FileReader(fileName);

					while (true) {
						int read = fr.read();
						if (read == -1) {
							break;
						} else {
							data += (char) read;
						}
					}
					fr.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				String[] token = data.split("\n");
				count = token.length;
				numberList = new int[count];
				scoreList = new int[count][];

				for (int i = 0; i < count; i++) {
					String[] token2 = token[i].split(",");
					numberList[i] = Integer.parseInt(token2[0]);
					scoreList[i] = new int[3];
					for (int j = 1; j < 4; j++) {
						System.out.print(j + " " + token2[j]);
						scoreList[i][j - 1] = Integer.parseInt(token2[j]);
						System.out.println(scoreList[i][j - 1]);
					}

				}
			}

		}

	}
}
