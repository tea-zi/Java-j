package J2_���������_�⺻�̷�;

import java.io.FileReader;

public class ���������_�⺻�̷�2_�ҷ�����1 {
	public static void main(String[] args) {
		// 1) FileReader fr = null; ��������
		// 1) fr = new FileReader(fileName); // ����� ������ �о�´�.
		// 2) fr.read(); // �ѱ��ھ� int �� �����´�.
		// 3) ������ ������ ������ -1�� ����ȴ�.
		// 3) fr.close(); // ����� �ݵ�� �ݾƾߵȴ�.

		String fileName = "file01.txt";
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
		System.out.println(data);
	}

}
