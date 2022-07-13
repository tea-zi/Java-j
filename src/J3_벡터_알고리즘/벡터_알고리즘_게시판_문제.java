package J3_����_�˰���;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ����_�˰���_�Խ���_���� {
//	  # �ܼ� �Խ��� - [����] �Ǵ� [����] ��ư�� ������ ������ ��ȣ�� ����ȴ�. 
//	  - ����ȭ�鿡�� [��ȣ][����] �� ǥ�õǰ� �ش��ȣ�� ���°��� [����]�� �����ִ�. 
//	  - ���� ������ ��ȣ�� �ش�Ǵ� �Խñ۸� �� �� �ִ�. 
//	  - numberList ==> ��ȣ , subjectList ==> ���� , contentList ==> ���� 
//	  - ����������� ���� �����Ͱ� ����ȴ�. 
//	  - ����Ǿ� �ִ� ������ �����Ѵٸ�, ������ �ҷ������� �����Ѵ�.

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String fileName = "src/J3_����_�˰���/board.txt";

		int[] numberList = null; // ��ȣ
		String[] subjectList = null; // ����
		String[] contentList = null; // ����

		int count = 0; // ��ü �Խñ� ��
		int pageSize = 5; // �� �������� ������ �Խñ� ��
		int curPageNum = 1; // ���� ������ ��ȣ
		int pageCount = 0; // ��ü ������ ����
		int startRow = count; // ���� �������� �Խñ� ���� ��ȣ
		int endRow = 0; // ���� �������� �Խñ� ������ ��ȣ

		while (true) {
			pageCount = count / pageSize;
			if (count % pageSize > 0) {
				pageCount += 1;
			}
			System.out.println("���������������������������");
			if (count == 0) {
				System.out.println("�Խù��� �����ϴ�.");
			} else if (count > 0) {
				startRow = (curPageNum - 1) * pageSize; // 0���� ����
				endRow = startRow + pageSize; // �̸�
				if (endRow > count) {
					endRow = count;
				}
//				System.out.println(count);
//				System.out.println(startRow + " " + endRow);
				for (int i = startRow; i < endRow; i++) {
					System.out.printf("%3d | %-20s\n", numberList[i], subjectList[i]);
				}
			}
			System.out.println("���������������������������");
			System.out.print("[1 . ����]");
			System.out.print("[���� ������ : " + curPageNum + "]");
			System.out.println("[2 . ����]");
			System.out.print("[3]�߰��ϱ�");
			System.out.print("[4]�����ϱ�");
			System.out.println("[5]����Ȯ��");
			System.out.print("[6]����");
			System.out.println("[7]�ε�");

			int choice = scan.nextInt();
			scan.nextLine();

			if (choice == 1) { // ����
				if (curPageNum == 1) {
					System.out.println("ù��° ������ �Դϴ�.");
					continue;
				}
				curPageNum--;
			} else if (choice == 2) { // ����
				if (curPageNum == pageCount) {
					System.out.println("������ ������ �Դϴ�.");
					continue;
				}
				curPageNum++;
			} else if (choice == 3) { // �߰��ϱ�

				System.out.print("���� : ");
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

				System.out.print("���� �Է� : ");
				String content = scan.nextLine();
				contentList[count] = content;

				count++;
			} else if (choice == 4) { // �����ϱ�
				if (count == 0) {
					System.out.println("������ �Խù��� �����ϴ�.");
					continue;
				}
				System.out.print("��ȣ �Է� : ");
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
			} else if (choice == 5) { // ����Ȯ��
				System.out.print("��ȣ �Է� : ");
				int num = scan.nextInt();
				if (startRow <= num && endRow > num) {
					System.out.println("����-------------------------------");
					System.out.println(contentList[num]);
				}
			} else if (choice == 6) { // ����
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
			} else if (choice == 7) { // �ε�
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