package ex04;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		String name; // ��ǰ��
		String grade = ""; // ���
		int price = 0; // �ܰ�
		int quantity = 0; // ����
		int money; // �Ǹ� �ݾ�
		int sel;
		boolean run = true;
		
		System.out.println("��ǰ�� ���� ��Ȳ ���� �ý��� �Դϴ�.");
		System.out.println("********** ��ǰ ���� ��Ȳ **********");
		
		while(run) {
			
			System.out.print("����� 0, ����Ͻ÷��� 1�� �Է����ּ���. : "); 
			sel = sc.nextInt(); 
			
			if(sel == 0) { 
				System.out.println("���α׷��� �����մϴ�."); 
				run = false; 
			}
			else { 
				
				System.out.print("��ǰ���� �Է����ּ��� : ");
				name = sc.next();
				
				System.out.print("�ܰ��� �Է����ּ��� : ");
				price = sc.nextInt();
				
				System.out.print("������ �Է����ּ��� : ");
				quantity = sc.nextInt();
				
				System.out.println("--------------------------------");
				
				money = price * quantity;
				System.out.println("�Ǹ� �ݾ��� " + money + " �Դϴ�.");
				
				if(money >= 5000) {
					grade = "�ֿ�� �Դϴ�.";
				}
				else if(money >= 3000) {
					grade = "��� �Դϴ�.";
				}
				else {
					grade = "���� �Դϴ�.";
				}
				System.out.println("����� "+ grade);
			}
		}
	}
}
