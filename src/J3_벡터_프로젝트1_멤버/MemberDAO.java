package J3_벡터_프로젝트1_멤버;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.annotation.processing.Filer;

public class MemberDAO {
	int num;
	Member[] memberList;
	int memberCount;
	Scanner scan;
	String fileName = "src/J3_벡터_프로젝트1_멤버/memberDAO.txt";

	void init() {
		scan = new Scanner(System.in);
		num = 1000;
		memberList = null;
		memberCount = 0;
	}

	int checkId(String id) {
		for (int i = 0; i < memberCount; i++) {
			if (id.equals(memberList[i].id)) {
				return i;
			}
		}
		return -1;
	}

	int getNextNum() {
		num += 1;
		return num;
	}

	void addMember(Member member) {

		if (memberCount == 0) {
			memberList = new Member[1];
			memberList[0] = member;
			memberCount += 1;
		} else if (memberCount > 0) {
			Member[] temp = memberList;
			memberList = new Member[memberCount + 1];
			for (int i = 0; i < temp.length; i++) {
				memberList[i] = temp[i];
			}
			memberList[memberCount] = member;
			memberCount += 1;
			temp = null;
		}
	}

	void removeMember(int removeIndex) {
		if (memberCount == 1) {
			memberList = null;
			memberCount = 0;
		} else if (memberCount > 1) {
			Member[] temp = memberList;
			memberList = new Member[memberCount - 1];
			int index = 0;
			for (int i = 0; i < temp.length; i++) {
				if (i != removeIndex) {
					memberList[index] = temp[i];
					index += 1;
				}
			}
			memberCount -= 1;
			temp = null;
		}
	}

	void printMember() {
		for (int i = 0; i < memberCount; i++) {
			memberList[i].printMember();
		}
	}

	void join() {

		System.out.println("[추가] 아이디입력 : ");
		String id = scan.next();
		int checkId = checkId(id);
		if (checkId == -1) {
			Member member = new Member();
			member.id = id;
			member.num = getNextNum();
			addMember(member);
		} else {
			System.out.println("[메세지] 중복아이디 입니다.");
		}
	}

	void remove() {

		if (memberCount == 0) {
			System.out.println("[메세지] 삭제할데이터가없습니다.");
			return;
		}
		System.out.println("[삭제] 아이디입력 : ");
		String id = scan.next();
		int checkId = checkId(id);
		if (checkId == -1) {
			System.out.println("[메세지] 찾는아이디가 없습니다.");
		} else {
			removeMember(checkId);
		}
	}

	void save() {
		String data = getData();
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	String getData() {
		String data = "";
		for (int i = 0; i < memberCount; i++) {
			data += memberList[i].num;
			data += ",";
			data += memberList[i].id;
			data += "\n";
		}

		data = data.substring(0, data.length() - 1);
		return data;
	}

	void load() {
		String data = "";
		try {
			FileReader fr = new FileReader(fileName);

			while (true) {
				int read = fr.read();
				if (read != -1) {
					data += (char) read;
				} else {
					break;
				}
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		String[] token = data.split("\n");
		memberCount = token.length;
		memberList = new Member[memberCount];
		for (int i = 0; i < memberCount; i++) {
			memberList[i] = new Member();
			String[] token2 = token[i].split(",");
			memberList[i].num = Integer.parseInt(token2[0]);
			memberList[i].id = token2[1];
		}
	}
}
