package ex04;

import java.util.Scanner;

public class Example3 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		int sel;
		boolean run = true;
		
		System.out.println("�ȳ��ϼ���. �հ踦 ���ϴ� �ý��� �Դϴ�.");
	
		while(run) {
			
			int sum = 0;
			int num = 0;
			
			System.out.println("���� �׸��߿� �������ּ���.");
			System.out.println("1.�հ� 2.¦���հ� 3.Ȧ���հ� 0.����");
			System.out.print("���� : ");
			sel = sc.nextInt(); 
			
			if(sel >= 1 && sel <= 3) {
				System.out.print("1 ~ n���� n���� �������ּ���. : ");
				num = sc.nextInt();
			}
				
			switch(sel)	{
			case 1 :
				for(int i = 1; i <= num; i++) {
					sum += i;	
				}
				System.out.println("1 ~ " + num + " ������ ���� : " + sum + " �Դϴ�.\n");
				break;
			case 2 :
				for(int i = 2; i <= num; i = i+2) {
					sum += i;
				}
				System.out.println("2 ~  " + num + " ������ ¦���� ���� : " + sum + " �Դϴ�.\n");
				break;
			case 3 :
				for(int i = 1; i <= num; i = i+2) {
					sum += i;
				}
				System.out.println("1 ~ " + num + " ������ Ȧ���� ���� : " + sum + " �Դϴ�.\n");
				break;
			case 0 :
				System.out.println("���α׷��� �����մϴ�."); 
				run = false;
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���.\n");
			}
		}
	}
}
