package J3_����_������Ʈ2_�л�����;

import java.util.Scanner;

public class StudentController {
	Scanner scan;
	StudentDAO studentDAO;
	SubjectDAO subjectDAO;

	void init() {
		scan = new Scanner(System.in);
		studentDAO = new StudentDAO();
		subjectDAO = new SubjectDAO();
		studentDAO.init();
		subjectDAO.init();
		mainMenu();
	}

	void mainMenu() {
		while (true) {
			System.out.println("1)�л��߰�");
			System.out.println("2)�л�����"); // ���� ���� ����
			System.out.println("3)�����߰�");
			System.out.println("4)�������");
			System.out.println("5)��ü���");
			System.out.println("6)����");
			System.out.println("7)�ε�");

			System.out.println("0)����");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) { // �л� �߰�
				studentDAO.join();
			} else if (sel == 2) { // �л� ����
				studentDAO.delete(subjectDAO);
			} else if (sel == 3) { // ���� �߰�
				subjectDAO.subjectInsert(studentDAO);
			} else if (sel == 4) { // ���� ����
				subjectDAO.Delete(studentDAO);
			} else if (sel == 5) { // ��ü���
				studentDAO.printList(subjectDAO);
			} else if (sel == 6) { // ����
				studentDAO.studentSave();
				subjectDAO.subjectSave();
			} else if (sel == 7) { // �ε�
				studentDAO.studentLoad();
				subjectDAO.subjectLoad();
			}
		}
	}

}
