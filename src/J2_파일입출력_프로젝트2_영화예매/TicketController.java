package J2_파일입출력_프로젝트2_영화예매;

import java.util.Scanner;

public class TicketController {
	UserDAO ud = new UserDAO();
	SeatDAO sd = new SeatDAO();

	void run() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("[1.로그인][2.회원가입][0.종료]");
			int sel = scan.nextInt();
			if (sel == 1) {
				if (ud.login()) {
					menu();
				}
			} else if (sel == 2) {

			} else if (sel == 0) {
				break;
			}
		}
	}

	void menu() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("[1.예매][2.취소][3.예매확인][0.로그아웃]");
			int sel = scan.nextInt();

			if (sel == 1) {

			} else if (sel == 2) {

			} else if (sel == 3) {

			} else if (sel == 0) {
				break;
			}
		}
	}
}
