package ex03;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ȳ��ϼ��� ���� ���α׷��Դϴ�.");
		
		System.out.println("���ڸ� �Է����ּ���");
		int num1 = sc.nextInt();
		
		System.out.println("���ڸ� �Է����ּ���");
		int num2 = sc.nextInt();
		
		int add = num1 + num2;
		int sub = num1 - num2;
		double mul = num1 * num2;
		double div = num1 / num2;
		
		System.out.println("����ϰ� ���� �����ڸ� �����ϼ���");
		System.out.println("1.���� 2.���� 3.���� 4.������");
		
		int result = sc.nextInt();
		
		switch(result) {
		case 1 : 
			System.out.println("������� : " + num1 + " + " + num2 + " = " + add);
			break;
		case 2 : 
			System.out.println("������� : " + num1 + " - " + num2 + " = " + sub);
			break;
		case 3 : 
			System.out.println("������� : " + num1 + " x " + num2 + " = " + mul);
			break;
		case 4 : 
			System.out.println("������� : " + num1 + " / " + num2 + " = " + div);
			break;
		default :
			System.out.println("�߸��Է��ϼ̽��ϴ�!");
			break;
		}
	}
}
