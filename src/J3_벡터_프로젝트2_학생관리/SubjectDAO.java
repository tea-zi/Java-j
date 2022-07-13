package J3_����_������Ʈ2_�л�����;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class SubjectDAO {
	Subject[] subjectList;
	int subjectCount;
	Scanner scan;
	String fileName = "src/J3_����_������Ʈ2_�л�����/subjectDAO.txt";

	void init() {
		scan = new Scanner(System.in);
		subjectCount = 0;
		subjectList = null;
	}

	boolean checkSubject(int studentNum, String subject) {
		for (int i = 0; i < subjectCount; i++) {
			Subject sub = subjectList[i];
			if (sub.studentNum == studentNum && sub.subject.equals(subject)) {
				return true;
			}
		}
		return false;
	}

	void addSubject(Subject subject) {
		if (subjectCount == 0) {
			subjectList = new Subject[1];
			subjectList[0] = subject;
		} else {
			Subject[] temp = subjectList;
			subjectList = new Subject[subjectCount + 1];
			for (int i = 0; i < subjectCount; i++) {
				subjectList[i] = temp[i];
			}
			subjectList[subjectCount] = subject;
			temp = null;
		}
		subjectCount += 1;
	}

	Subject[] getOneStudentSubjectList(int studentNum) {
		int count = 0;
		for (int i = 0; i < subjectCount; i++) {
			Subject sub = subjectList[i];
			if (sub.studentNum == studentNum) {
				count += 1;
			}
		}
		if (count == 0) {
			return null;
		}

		Subject[] oneStudentSubjectList = new Subject[count];
		int index = 0;
		for (int i = 0; i < subjectCount; i++) {
			Subject sub = subjectList[i];
			if (sub.studentNum == studentNum) {
				oneStudentSubjectList[index] = sub;
				index += 1;
			}
		}
		return oneStudentSubjectList;
	}

	void printSubjectList(Subject[] subjectList) {
		for (int i = 0; i < subjectList.length; i++) {
			subjectList[i].printSubject();
		}
	}

	void subjectInsert(StudentDAO studentDAO) {
		System.out.println("[�����߰�] �л� ���̵� �Է� : ");
		String id = scan.next();
		Student student = studentDAO.checkId(id);
		if (student == null) {
			System.out.println("ã�� �л��� �����ϴ�. ");
		} else {
			System.out.println("[�����߰�] ���� �̸� �Է� : ");
			String subjectName = scan.next();
			boolean check = checkSubject(student.studentNum, subjectName);
			if (check == true) {
				System.out.println("[�޼���] �ߺ� �����Դϴ�.");
			} else {
				Subject subject = new Subject();
				System.out.println("[�����߰�] ���� �Է� : ");
				int score = scan.nextInt();
				subject.score = score;
				subject.studentNum = student.studentNum;
				subject.subject = subjectName;
				addSubject(subject);
				System.out.println("�����߰� ����.");
			}
		}
	}

	void Delete(StudentDAO studentDAO) {
		System.out.println("[�������]���̵� �Է� : ");
		String id = scan.next();
		Student student = studentDAO.checkId(id);
		if (student != null) {
			System.out.println("[�����߰�] ���� �̸� �Է� : ");
			String subjectName = scan.next();
			deleteSubject(student.studentNum, subjectName);
		} else {
			System.out.println("�л������� �������� �ʽ��ϴ�.");
		}
	}

	void deleteSubject(int number, String subjectName) {
		if (subjectName.equals("All")) {
			for (int i = 0; i < subjectCount;) {
				if (number == subjectList[i].studentNum) {
					for (int j = 0; j < subjectCount - 1; j++) {
						subjectList[j] = subjectList[j + 1];
					}
					subjectCount--;
				} else {
					i++;
				}
			}
			printSubjectList(subjectList);
			Subject temp[] = subjectList;
			subjectList = new Subject[subjectCount];
			for (int i = 0; i < subjectCount; i++) {
				subjectList[i] = new Subject();
				subjectList[i] = temp[i];
			}
		} else {
			int idx = 0;
			for (int i = 0; i < subjectCount; i++) {
				if (number == subjectList[i].studentNum && subjectName.equals(subjectList[i].subject)) {
					idx = i;
				}
			}

			Subject temp[] = subjectList;
			subjectList = new Subject[subjectCount - 1];
			int j = 0;
			for (int i = 0; i < subjectCount; i++) {
				if (idx != i) {
					subjectList[j] = new Subject();
					subjectList[j] = temp[i];
					j++;
				}
			}
			subjectCount--;
		}

	}

	void subjectSave() {
		String data = "";
		for (int i = 0; i < subjectCount; i++) {
			data += subjectList[i].studentNum;
			data += ",";
			data += subjectList[i].subject;
			data += ",";
			data += subjectList[i].score;
			data += "\n";
		}
		System.out.println(data);
		data = data.substring(0, data.length() - 1);
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	void subjectLoad() {
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
			e.printStackTrace();
		}

		String[] token = data.split("\n");
		subjectCount = token.length;
		subjectList = new Subject[subjectCount];
		for (int i = 0; i < subjectCount; i++) {
			String[] token2 = token[i].split(",");
			subjectList[i] = new Subject();
			subjectList[i].studentNum = Integer.parseInt(token2[0]);
			subjectList[i].subject = token2[1];
			subjectList[i].score = Integer.parseInt(token2[2]);
		}
	}
}
