package J2_파일입출력_기본이론;

import java.io.File;
import java.io.FileReader;

public class 파일입출력_기본이론2_불러오기2_경로확인 {
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
			System.out.println("불러오기 실패");
		}
	}
}
