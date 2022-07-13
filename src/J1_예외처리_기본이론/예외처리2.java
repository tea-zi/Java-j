package J1_예외처리_기본이론;

public class 예외처리2 {
	public static void main(String[] args) {

		// 에러의 종류 (참고사이트)
		// https://butter-shower.tistory.com/87

		// 주석처리 해보면서 하나씩 실행해보자
		int arr[] = new int[3];
		try {
			arr[100] = 100;

		} catch (ArrayIndexOutOfBoundsException e) {

			e.printStackTrace();
		}

		// -----------------------------------

		int a = 10;
		try {
			int b = a / 0;

		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		// -----------------------------------

		String str = "aaa";
		try {
			int num = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

}