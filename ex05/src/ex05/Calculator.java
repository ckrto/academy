package ex05;

public class Calculator {
	//�ʵ�(�Ӽ�)
	int num1 = 0;
	int num2 = 0;
	int sum;
	int sub;
	int mul;
	double div;
	
	//������
	
	//�޼ҵ�
	public void execute() {
		sum = num1 + num2;
		sub = num1 + num2;
		mul = num1 * num2;
		div = num1 / (double) num2;
		
	}
	
	public void print() {
		System.out.println(num1 + " + " + num2 + " = " + sum);
		System.out.println(num1 + " - " + num2 + " = " + sub);
		System.out.println(num1 + " X " + num2 + " = " + mul);
		System.out.println(num1 + " / " + num2 + " = " + div);
		System.out.println("");
	}
} // Ŭ���� (��ü�� �����ϴ� Ʋ)
