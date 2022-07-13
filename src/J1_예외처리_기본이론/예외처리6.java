package J1_예외처리_기본이론;

class Test {

	void sample1() {
		try {
			int a = 10 / 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	void sample2() throws Exception {
		int a = 10 / 0;
	}
}

public class 예외처리6 {
	public static void main(String[] args) {
		// 예외처리하는 2가지방법
		// (1) try {} 안에 식을 적는다.

		// (2) 메서드 이름 옆에 throws Exception 을 적는다.
		// 조건) 대신, 메서드 호출할때 try{}로 감싸줘야한다.

		// 2번의 방법이 메서드 호출시점부터 예외처리를 알수있어서 더좋다.

		Test t = new Test();
		t.sample1();

		System.out.println("------");

		try {
			t.sample2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
