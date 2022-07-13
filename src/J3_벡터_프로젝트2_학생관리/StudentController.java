package J3_벡터_프로젝트2_학생관리;

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
			System.out.println("1)학생추가");
			System.out.println("2)학생삭제"); // 과목 같이 삭제
			System.out.println("3)과목추가");
			System.out.println("4)과목삭제");
			System.out.println("5)전체출력");
			System.out.println("6)저장");
			System.out.println("7)로드");

			System.out.println("0)종료");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) { // 학생 추가
				studentDAO.join();
			} else if (sel == 2) { // 학생 삭제
				studentDAO.delete(subjectDAO);
			} else if (sel == 3) { // 과목 추가
				subjectDAO.subjectInsert(studentDAO);
			} else if (sel == 4) { // 과목 삭제
				subjectDAO.Delete(studentDAO);
			} else if (sel == 5) { // 전체출력
				studentDAO.printList(subjectDAO);
			} else if (sel == 6) { // 저장
				studentDAO.studentSave();
				subjectDAO.subjectSave();
			} else if (sel == 7) { // 로드
				studentDAO.studentLoad();
				subjectDAO.subjectLoad();
			}
		}
	}

}
