package J2_���������_�⺻�̷�;

import java.io.File;
import java.io.FileReader;

public class ���������_�⺻�̷�2_�ҷ�����2_���Ȯ�� {
	public static void main(String[] args) {

		String fileName = "file01.txt";
		String data = "";

		File file = new File(fileName);
		if (file.exists()) {
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
				System.out.println(data);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			System.out.println("�ҷ����� ����");
		}
	}
}
