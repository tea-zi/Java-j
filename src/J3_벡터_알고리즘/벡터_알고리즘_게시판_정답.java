package J3_����_�˰���;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ����_�˰���_�Խ���_���� {
	/*
	 * # �ܼ� �Խ��� 1. [����] �Ǵ� [����] ��ư�� ������ ������ ��ȣ�� ����ȴ�. 2. ���� ������ ��ȣ�� �ش�Ǵ� �Խñ۸� �� ��
	 * �ִ�. 3. 2���� �迭 board�� 0������ ������ 1������ �Խñ��� ������ �����Ѵ�. 4. ����������� ���� �����Ͱ� ����ȴ�. 5.
	 * ����Ǿ� �ִ� ������ �����Ѵٸ�, ������ �ҷ������� �����Ѵ�.
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String fileName = "src/J3_����_�˰���/board.txt";

		int[] numberList = null;
		String[] subjectList = null;
		String[] contentList = null;

		int count = 0; // ��ü �Խñ� ��
		int pageSize = 5; // �� �������� ������ �Խñ� ��
		int curPageNum = 1; // ���� ������ ��ȣ
		int pageCount = 0; // ��ü ������ ����
		int startRow = 0; // ���� �������� �Խñ� ���� ��ȣ
		int endRow = 0; // ���� �������� �Խñ� ������ ��ȣ

		int number = 1;
		while (true) {

			pageCount = count / pageSize;
			if (count % pageSize > 0) {
				pageCount += 1;
			}

			startRow = (curPageNum - 1) * pageSize; // 0���� ����
			endRow = startRow + pageSize; // �̸�
			if (endRow > count) {
				endRow = count;
			}

			System.out.println("�Խ��� (" + count + ")��");
			System.out.println("���� ������ : " + curPageNum);
			for (int i = startRow; i < endRow; i++) {
				String print = "";
				print += numberList[i];
				print += ":";
				print += subjectList[i];
				System.out.println(print);

			}
			System.out.println();

			System.out.println("[1]����");
			System.out.println("[2]����");
			System.out.println("[3]�߰��ϱ�");
			System.out.println("[4]�����ϱ�");
			System.out.println("[5]����Ȯ��");
			System.out.println("[6]����");
			System.out.println("[7]�ε�");

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
				System.out.print("�Խñ� ������ �Է��ϼ��� : ");
				subjectList[count] = scan.next();

				System.out.print("�Խñ� ������ �Է��ϼ��� : ");
				contentList[count] = scan.next();

				count += 1;

			} else if (choice == 4) {

			} else if (choice == 5) {
				System.out.print("�Խñ� ��ȣ�� �Է��ϼ��� : ");
				int num = scan.nextInt();
				num -= 1;

				if (startRow <= num && num < endRow) {
					System.out.println("���� = " + contentList[num]);
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