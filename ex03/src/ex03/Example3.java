package ex03;

import java.util.Scanner;

public class Example3 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ܰ��� ������ �����ϴ� �ý����Դϴ�.\n");
		System.out.println("********** ���� ��Ȳ **********");
		System.out.println("���α׷� ����� 0�� �Է����ּ���.");
		
		while(true) {
			System.out.print("�ܰ��� �Է��ϼ��� : ");
			int price = sc.nextInt();
			
			if (price == 0) {
				break;
			} 
			else {
				System.out.print("������ �Է��ϼ��� : ");
				int quantity = sc.nextInt();
				
				int money = price * quantity;
				System.out.println("�ݾ� : " + money);
				if (money >= 1000000) {
					System.out.println("�ֿ�� �Դϴ�!");
				}
				else if (money >= 500000) {
					System.out.println("��� �Դϴ�!");
				}
				else {
					System.out.println("�й��ؾ� �մϴ�!");
				}
			}
		}
		System.out.println("���α׷��� �����մϴ�!");
	}
}
