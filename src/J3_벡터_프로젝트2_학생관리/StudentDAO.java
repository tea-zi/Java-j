package J3_벡터_프로젝트2_학생관리;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class StudentDAO {
	int num;
	Student[] studentList;
	int studentCount;
	Scanner scan;
	String fileName = "src/J3_벡터_프로젝트2_학생관리/studentDAO.txt";

	void init() {
		scan = new Scanner(System.in);
		num = 1000;
		studentCount = 0;
		studentList = null;
	}

	Student checkId(String id) {
		for (int i = 0; i < studentCount; i++) {
			if (studentList[i].studentId.equals(id)) {
				return studentList[i];
			}
		}
		return null;
	}

	int getNextNum() {
		num += 1;
		return num;
	}

	void addStudent(Student student) {

		if (studentCount == 0) {
			studentList = new Student[1];
			studentList[0] = student;

		} else {
			Student[] temp = studentList;
			studentList = new Student[studentCount + 1];
			for (int i = 0; i < studentCount; i++) {
				studentList[i] = temp[i];
			}
			studentList[studentCount] = student;
			temp = null;
		}
		studentCount += 1;
	}

	void printStudentList() {
		for (int i = 0; i < studentCount; i++) {
			studentList[i].printStudent();
		}
	}

	void join() {
		System.out.println("[학생추가] 아이디 입력 : ");
		String id = scan.next();
		Student student = checkId(id);
		if (student == null) {
			student = new Student();
			student.studentId = id;
			student.studentNum = getNextNum();
			addStudent(student);
			printStudentList();
			System.out.println("회원가입 성공.");

		} else {
			System.out.println("중복아이디입니다. ");
		}
	}

	void printList(SubjectDAO subjectDAO) {

		if (studentCount == 0) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		for (int i = 0; i < studentCount; i++) {
			Student student = studentList[i];
			student.printStudent();
			Subject[] subjectList = subjectDAO.getOneStudentSubjectList(student.studentNum);
			if (subjectList == null) {
				System.out.println("과목이 없습니다.");
				continue;
			}
			subjectDAO.printSubjectList(subjectList);
		}
	}

	void delete(SubjectDAO subjectDAO) {
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		Student student = checkId(id);
		if (student != null) {
			subjectDAO.deleteSubject(student.studentNum, "All");
			deleteStudent(student);
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}

	void deleteStudent(Student student) {
		if (studentCount == 1) {
			studentList = null;
			studentCount--;
		} else if (studentCount > 1) {
			Student[] temp = studentList;
			studentList = new Student[studentCount - 1];
			int j = 0;
			for (int i = 0; i < studentCount; i++) {
				if (temp[i] != student) {
					studentList[j] = new Student();
					studentList[j] = temp[i];
					j++;
				}
			}
			studentCount--;
		}
	}

	void studentSave() {
		String data = "";
		for (int i = 0; i < studentCount; i++) {
			data += studentList[i].studentId;
			data += ",";
			data += studentList[i].studentNum;
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

	void studentLoad() {
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
		studentCount = token.length;
		studentList = new Student[studentCount];
		for (int i = 0; i < studentCount; i++) {
			String[] token2 = token[i].split(",");
			studentList[i] = new Student();
			studentList[i].studentId = token2[0];
			studentList[i].studentNum = Integer.parseInt(token2[1]);
		}
	}
}
