package J2_파일입출력_기본이론;

import java.io.FileWriter;

public class 파일입출력_기본이론1_저장2_IOException {
	public static void main(String[] args) {

		String fileName = "file01.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write("김철수,10\n이영희,30\n박만수,50");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
