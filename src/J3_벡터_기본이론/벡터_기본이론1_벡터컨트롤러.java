package J3_����_�⺻�̷�;

import java.util.Scanner;

public class ����_�⺻�̷�1_������Ʈ�ѷ� {
//	 # �迭 ��Ʈ�ѷ�(���ѹ迭) : ����(Vector)
//	 1. �߰�
//	  . ���� �Է¹޾� ���������� �߰�
//	 2. ����(�ε���)
//	  . �ε����� �Է¹޾� �ش� ��ġ�� �� ����
//	 3. ����(��)
//	  . ���� �Է¹޾� ����
//	  . ���� �� �Է� �� ����ó��
//	 4. ����
//	  . �ε����� ���� �Է¹޾� ����
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] score = null;
		int count = 0;

		while (true) {

			for (int i = 0; i < count; i++) {
				System.out.print(score[i] + " ");
			}
			System.out.println();

			System.out.println("[���� ��Ʈ�ѷ�]");
			System.out.println("[1]�߰�");
			System.out.println("[2]����(�ε���)");
			System.out.println("[3]����(��)");
			System.out.println("[4]����");
			System.out.println("[0]����");

			System.out.println("�޴� ���� : ");
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

				System.out.println("���� �Է� : ");
				int data = scan.nextInt();

				score[count] = data;
				count++;
			} else if (sel == 2) {
				System.out.print("�ε��� �Է� : ");
				int index = scan.nextInt();

				if (count - 1 < index || index < 0) {
					System.out.println("�ش���ġ�� ������ �� �����ϴ�.");
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
				System.out.print("�� �Է� : ");
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
					System.out.println("�Է��Ͻ� ���� �������� �ʽ��ϴ�.");
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
					System.out.println("�ߺ��� ���� �ֽ��ϴ�.");
				}
			} else if (sel == 4) {
				System.out.print("�ε��� �Է� : ");
				int index = scan.nextInt();

				if (index > count || index < 0) {
					System.out.println("�ش� ��ġ�� ������ �� �����ϴ�.");
					continue;
				}

				System.out.print("�� �Է� : ");
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
