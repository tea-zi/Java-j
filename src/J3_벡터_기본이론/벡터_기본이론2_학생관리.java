package J3_����_�⺻�̷�;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ����_�⺻�̷�2_�л����� {
	public static void main(String[] args) {
		// 2�����迭 ��Ʈ�ѷ�

		// ������ ���� ��� : ��ȣ + ����3��
		// ��) 1001, 20, 30, 40
		// ��) 1002, 40, 60, 60
		// ��) 1003, 10, 20, 30

		Scanner scan = new Scanner(System.in);

		int[] numberList = null;
		int[][] scoreList = null;
		int count = 0;
		int num = 1001;
		String fileName = "src/J3_����_�⺻�̷�/file01.txt";
		while (true) {

			for (int i = 0; i < count; i++) {
				System.out.print(numberList[i] + " ");
				for (int j = 0; j < 3; j++) {
					System.out.print(scoreList[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println("[���� ��Ʈ�ѷ�]");
			System.out.println("[0]����");
			System.out.println("[1]�߰�");
			System.out.println("[2]����(�ε���)");
			System.out.println("[3]����(�л���ȣ)");
			System.out.println("[4]����");
			System.out.println("[5]����");
			System.out.println("[6]�ε�");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) { // �߰�
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
					System.out.println("����" + (i + 1) + " ���� : ");
					scoreList[count][i] = scan.nextInt();
				}
				num += 1;
				count += 1;

			} else if (sel == 2) { // �ε��� ����
				System.out.print("�ε��� �Է� : ");
				int index = scan.nextInt();

				if (index < 0 || index > count) {
					System.out.println("�ش���ġ�� ������ �����ϴ�.");
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
			} else if (sel == 3) { // �л���ȣ ����
				System.out.print("�л���ȣ �Է� : ");
				int number = scan.nextInt();

				int index = -1;
				for (int i = 0; i < count; i++) {
					if (number == numberList[i]) {
						index = i;
					}
				}

				if (index == -1) {
					System.out.println("���� �л���ȣ �Դϴ�.");
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
			} else if (sel == 4) { // ����
				System.out.print("�ε��� �Է� : ");
				int index = scan.nextInt();

				if (index < 0 || index > count) {
					System.out.println("�ش���ġ�� ������ �����ϴ�.");
					continue;
				}

				int score[] = new int[3];
				for (int i = 0; i < 3; i++) {
					System.out.printf("���� %d ���� �Է� : ", i + 1);
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
			} else if (sel == 5) { // ����
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
			} else if (sel == 6) { // �ε�
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
