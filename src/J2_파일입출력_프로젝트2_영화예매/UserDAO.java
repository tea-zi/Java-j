package J2_파일입출력_프로젝트2_영화예매;

import java.util.Scanner;

public class UserDAO {
	Scanner scan = new Scanner(System.in);
	User userList[] = new User[100];
	int userCount = 0;

	boolean login() {

		boolean log = false;

		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		int pw = scan.nextInt();
		log = logincheck(id, pw);

		return log;

	}

	boolean logincheck(String id, int pw) {
		boolean check = false;
		for (int i = 0; i < userCount; i++) {
			if (id.equals(userList[i].id) && pw == userList[i].pw) {
				check = true;
			}
		}
		return check;
	}

	void join() {
		System.out.print("아이디 입력 : ");
		String id = scan.nextLine();
		if (idcheck(id)) {
			System.out.println("비밀번호 입력 : ");
			int pw = scan.nextInt();
			userList[userCount].id = id;
			userList[userCount].pw = pw;
			userCount++;
		} else {
			System.out.println("중복된 아이디 입니다.");
		}
	}

	boolean idcheck(String id) {
		boolean check = false;

		for (int i = 0; i < userList.length; i++) {
			if (id.equals(userList[i].id)) {
				check = true;
			}
		}

		return check;
	}
}
