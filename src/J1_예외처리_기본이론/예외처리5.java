package J1_예외처리_기본이론;

import java.util.Scanner;

public class 예외처리5 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// [1] Thread.sleep(밀리세컨즈)
		// [2] () 안에 넣은 값만큼 일시정지된다.
		// [3] 밀리세컨즈이기때문에 1000 이 1초이다.
		// [4] 이걸활용해서 동적프로그램을 만들수있다. (GUI 에서 활용)

		System.out.println("시작");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("종료");

	}

}