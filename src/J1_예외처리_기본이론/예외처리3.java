package J1_����ó��_�⺻�̷�;

public class ����ó��3 {
	public static void main(String[] args) {

		int arr[] = new int[3];
		try {
			arr[100] = 100;
		} catch (Exception e) {
			e.printStackTrace();
		}

		int a = 10;
		try {
			int b = a / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		String str = "aaa";
		try {
			int num = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
