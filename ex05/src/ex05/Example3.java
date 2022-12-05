package ex05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		DecimalFormat df = new DecimalFormat("#,###,###");
		Scanner sc = new Scanner(System.in);
		
		String[] name = new String[100];
		String search = "";
		
		int[] price = new int[100];
		int[] qnt = new int[100];
		int sel;
		int count = 0;
		int sum = 0;
		
		boolean find = false;
		boolean run = true;
		
		System.out.println("�ȳ��ϼ��� ������Ȳ �˸� �ý����Դϴ�.");
		
		while(run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.��ǰ��� | 2.��ǰ�˻� | 3.������Ȳ | 0. ����");
			System.out.println("-----------------------------------------");
			System.out.print("������ �۾��� �������ּ��� : ");
			sel = sc.nextInt();
			System.out.println("");
			
			switch(sel) {
			case 1 : 
				System.out.println("��ǰ ��� ���Դϴ�.");
				System.out.print("�Է��� ��ǰ�� ������ �Է����ּ���. : ");
				count = sc.nextInt();
				System.out.println("");
				
				for(int i = 0; i < count; i++) {
					System.out.print("��ǰ���� �����ּ���. : ");
					name[i] = sc.next();
					
					System.out.print(name[i] + "�� �ܰ��� �����ּ��� : ");
					price[i] = sc.nextInt();
					
					System.out.print(name[i] + "�� �Ǹ� ������ �����ּ��� : ");
					qnt[i] = sc.nextInt();
					
					System.out.println("");
				}
				System.out.println(count +"���� ��ǰ�� ��ϵǾ����ϴ�.");
				break;
				
			case 2 :
				System.out.println("��ǰ �˻� ���Դϴ�.");
				System.out.print("�˻��Ͻ� ��ǰ�� ��ǰ���� �Է����ּ���. : ");
				search = sc.next();
				
				for(int i = 0; i < count; i++) {
					sum = price[i] * qnt[i];
					
					if(search.equals(name[i])) {
						find = true;
						System.out.println(name[i] + "�� �ܰ��� " + df.format(price[i]) + "�� �Դϴ�.");
						System.out.println(name[i] + "�� ���� ������ " + df.format(qnt[i]) + "�� �Դϴ�.");
					}
				}
				if (find == false) {
					System.out.println("��ϵ� ��ǰ�� �ƴմϴ�.");
				}
				System.out.println("");
				break;
				
			case 3 :
				System.out.println("���� ��Ȳ ���Դϴ�.");
				System.out.print("�˻��Ͻ� ��ǰ�� ��ǰ���� �Է����ּ���. : ");
				search = sc.next();
				
				for(int i = 0; i < count; i++) {
					if(search.equals(name[i])) {
						System.out.println("�˻��Ͻ� "+ name[i] + "�� �ܰ��� " + df.format(price[i]) + "�� ��ϵ� ������ " + df.format(qnt[i]) + "�� �ݾ��� " + df.format(sum) + "�� �Դϴ�.");
					}
				}
				System.out.println("");
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}
}
