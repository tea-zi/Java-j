package J1_����ó��_�⺻�̷�;

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

public class ����ó��6 {
	public static void main(String[] args) {
		// ����ó���ϴ� 2�������
		// (1) try {} �ȿ� ���� ���´�.

		// (2) �޼��� �̸� ���� throws Exception �� ���´�.
		// ����) ���, �޼��� ȣ���Ҷ� try{}�� ��������Ѵ�.

		// 2���� ����� �޼��� ȣ��������� ����ó���� �˼��־ ������.

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
