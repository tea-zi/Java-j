package J2_���������_�⺻�̷�;

import java.io.FileWriter;

public class ���������_�⺻�̷�1_����2_IOException {
	public static void main(String[] args) {

		String fileName = "file01.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write("��ö��,10\n�̿���,30\n�ڸ���,50");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
