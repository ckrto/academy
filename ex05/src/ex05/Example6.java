package ex05;

import java.util.Scanner;

public class Example6 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			Calculator c1 = new Calculator();
			System.out.println("����Ͻð� ���� ���ڸ� �Է����ּ���.");
			System.out.println("����� 0�� �Է����ּ���.");
			
			System.out.print("����1 : ");
			c1.num1 = sc.nextInt();
			if(c1.num1 == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			System.out.print("����2 : ");
			c1.num2 = sc.nextInt();
			
			c1.execute();
			c1.print();
		}
	}
}
