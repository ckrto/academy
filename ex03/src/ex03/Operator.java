package ex03;

public class Operator {
	public static void execute() {
		System.out.println("---------- ������ ----------\n");
		
		System.out.println("1.���������");
		int a = 11;
		int b = 4;
		int c = a + b;
		int d = a - b;
		int e = a * b;
		double f = (double)a / b;
		int g = a % b;
		
		System.out.println(a + " + " + b + " = " + c);
		System.out.println(a + " - " + b + " = " + d);
		System.out.println(a + " x " + b + " = " + e);
		System.out.println(a + " / " + b + " = " + f);
		System.out.println(a + " / " + b + "�� ������ = " + g);
		
		System.out.println("2.�񱳿�����");
		boolean result = (a >= b);
		System.out.println(a + " >= " + b + " = " + result);
		result = (a != b);
		System.out.println(a + " == " + b + " = " + result);
		
		System.out.println("3.��������");
		result = (a > 5) && (b > 5);
		System.out.println("��� : " + result);
		result = (a > 5) || (b > 5);
		System.out.println("��� : " + result);
		result = (a >= 10) && (b <= 5);
		System.out.println("��� : " + result);
		result = (a <= 10) || (b >= 5);
		System.out.println("��� : " + result);
		
		String gender = "����";
		int age = 22;
		
		// ������ �����̰� ���̰� 20�� �̻��Դϱ�?
		result = (gender == "����") && (age >= 20);
		System.out.println("��� : " + result);
		
		// ������ �����̰ų� ���̰� 50�� �̻��Դϱ�?
		result = (gender == "����") || (age >= 50);
		System.out.println("��� : " + result);
		
	}
}
