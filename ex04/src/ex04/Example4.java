package ex04;

import java.util.Scanner;

public class Example4 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		int sel;
		int money = 1000;
		int deposit = 0;
		int withdraw = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("�ȳ��ϼ��� OO���� ATM�� �Դϴ�. �Ʒ��� �۾��� �� ���Ͻô� �۾��� �������ּ���");
			System.out.println("---------------------------------");
			System.out.println("1.�ܾ�Ȯ�� | 2.�Ա� | 3.��� | 0.����");
			System.out.println("---------------------------------");
			
			System.out.print("������ �۾� : ");
			sel = sc.nextInt();
			
			switch(sel) {
			case 1 :
				System.out.println("������ ���¿� �����ϴ� �ݾ��� " + money + " �� �Դϴ�.\n");
				break;
			case 2 :
				System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�?");
				System.out.print("�ݾ� : ");
				deposit = sc.nextInt();
				
				System.out.println(deposit +"���� �Ա��Ͽ����ϴ�.");
				money = money + deposit;
				System.out.println("���� �ܾ��� " + money + "�� �Դϴ�.\n");
				break;
			case 3 :
				System.out.println("�󸶸� ����Ͻðڽ��ϱ�?");
				System.out.print("�ݾ� : ");
				withdraw = sc.nextInt();
				if(money < withdraw)
				{
					System.out.println("�ܾ��� �����Ͽ� ����� �� �����ϴ�.\n");
				}
				else {
					System.out.println(withdraw +"���� ����Ͽ����ϴ�.");
					money = money - withdraw;
					System.out.println("���� �ܾ��� " + money + "�� �Դϴ�.\n");
				}
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���.\n");
			}
		}
		
	}
}
