package J2_파일입출력_기본이론;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class 파일입출력_기본이론3_테스트 {
	public static void main(String[] args) {
//		  String nameData = "김철수,이만수,이영희"; 
//		  String ageData ="20,30,40";

		// 문제1) 김철수/20\n이만수/30\n이영희/40
		// 이렇게 만들고 파일저장

		// 문제2) 파일을 불러와서 아래 배열에 저장

		String nameData = "김철수,이만수,이영희,이근일";
		String ageData = "20,30,40,60";
		String fileName = "src/J2_파일입출력_기본이론/file03.txt";
		String data = "";

		String[] nameList = null;
		int[] ageList = null;
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("[0] 종료 [1] 저장 [2] 로드");
			int sel = scan.nextInt();

			if (sel == 1) {
				data = "";
				String namelist[] = nameData.split(",");
				String agelist[] = ageData.split(",");

				try {
					FileWriter fw = new FileWriter(fileName);

					for (int i = 0; i < namelist.length; i++) {
						data += namelist[i];
						data += "/";
						data += agelist[i];
						data += "\n";
					}
					fw.write(data);
					fw.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println(data);
			} else if (sel == 2) {
				data = "";

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

				String token[] = data.split("\n");
				int size = token.length;

				nameList = new String[size];
				ageList = new int[size];

				for (int i = 0; i < size; i++) {
					String token2[] = token[i].split("/");
					nameList[i] = token2[0];
					ageList[i] = Integer.parseInt(token2[1]);
				}

				System.out.println("----------");

				for (int i = 0; i < size; i++) {
					System.out.println(nameList[i] + " " + ageList[i]);
				}
			} else if (sel == 0) {
				break;
			}
		}
	}
}
