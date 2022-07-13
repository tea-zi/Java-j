package J2_파일입출력_기본이론;

import java.io.FileReader;

public class 파일입출력_기본이론2_불러오기1 {
	public static void main(String[] args) {
		// 1) FileReader fr = null; 변수선언
		// 1) fr = new FileReader(fileName); // 저장된 파일을 읽어온다.
		// 2) fr.read(); // 한글자씩 int 로 가져온다.
		// 3) 가져올 내용이 없으면 -1이 저장된다.
		// 3) fr.close(); // 사용후 반드시 닫아야된다.

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
