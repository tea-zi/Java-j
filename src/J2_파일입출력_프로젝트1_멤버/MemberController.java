package J2_파일입출력_프로젝트1_멤버;

import java.util.Scanner;

public class MemberController {
	MemberDAO memberDAO;
	Scanner scan = new Scanner(System.in);

	void init() {
		memberDAO = new MemberDAO();
		memberDAO.init("src/J1_파일입출력1_프로젝트_멤버/memberList.txt" , 100);
		mainMenu();
	}

	
	void mainMenu() {
		while (true) {
			System.out.println("[0]종료 [1]추가 [2]삭제 [3]수정 [4]출력 "
					+ "[5]저장 [6]로드 ");
			int sel = scan.nextInt();
			if(sel == 0) {
				break;
			}else if (sel == 1) {
				memberDAO.join();
			} else if (sel == 2) {
				memberDAO.delete();
			} else if (sel == 3) {
				memberDAO.update();
			} else if (sel == 4) {
				memberDAO.printMemberList();
			} else if (sel == 5) {
				memberDAO.save();
			} else if (sel == 6) {
				memberDAO.load();
			}
		}
	}
}
