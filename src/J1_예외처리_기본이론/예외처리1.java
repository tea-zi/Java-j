package J1_예외처리_기본이론;

public class 예외처리1 {
	public static void main(String[] args) {

		int num = 10;
		// System.out.println(num / 0); //어떤숫자를 0으로 나누면 에러발생

		// try catch
		// 자바는 일반적으로 에러가 발생하면 프로그램이 즉시종료한다.
		// try catch 는 에러가 발생해도 프로그램이 종료되지않고
		// 에러난 부분만 동작하지않고 프로그램이 계속 진행되도록 만들어준다.(아주좋음)

		// 1) try {} ==> 중괄호 안에 코드를 작성하면 에러발생해도 무시한다.
		// 2) catch(Exception e){} ==> 에러가 발생하면 한번작동된다.

		try {
			System.out.println(num / 0);
		} catch (Exception e) {
			System.out.println("0으로 나눌 수 없습니다."); // 직접 출력해도되고 아래처럼
			e.printStackTrace(); // 자바에서 제공하는 출력문 (어떤에러인지알려준다.)
		}
		System.out.println("프로그램 종료");

	}

}