package ex05;

import java.util.Scanner;

public class Example4 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		String[] name = new String[100];
		String[] address = new String[100];
		String[] tel = new String[100];
		String search = "";
		
		int sel;
		int count = 0;
		
		
		boolean searchCheck = false;
		boolean run = true;
		
		System.out.println("�ȳ��ϼ��� �ּҷ� ���� �ý��� �Դϴ�.");
		while(run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.�ּҵ�� | 2.�ּҰ˻� | 3.�ּҸ�� | 0. ����");
			System.out.println("-----------------------------------------");
			System.out.print("������ �۾��� �������ּ��� : ");
			sel = sc.nextInt();
			System.out.println("");
			
			switch(sel) {
			case 1 :
				System.out.println("�ּ� ��� ���Դϴ�.");
				
				System.out.print("�̸��� �Է����ּ��� : ");
				name[count] = sc.next(); sc.nextLine();
				
				System.out.print("�ּҸ� �Է����ּ��� : ");
				address[count] = sc.nextLine();
				
				System.out.print("��ȭ��ȣ�� �Է����ּ��� : ");
				tel[count] = sc.next(); sc.nextLine();
				
				count++;
				
				System.out.println(count + "�� �Է� �Ϸ��߽��ϴ�.");
				break;
				
			case 2 :
				System.out.println("�ּ� �˻� ���Դϴ�.");
				System.out.print("�̸��� �Է����ּ��� : ");
				search = sc.next();
				
				for(int i = 0; i < count; i++) {
					if(search.equals(name[i])) {
						searchCheck = true;
						System.out.println("�̸� : " + name[i]);
						System.out.println("�ּ� : " + address[i]);
						System.out.println("��ȭ��ȣ : " + tel[i]);
					}
				}
				if (searchCheck == false) {
					System.out.println("��ϵ� ��ǰ�� �ƴմϴ�.");
				}
				System.out.println("");
				
				break;
				
			case 3 :
				System.out.println("�ּҸ�� ���Դϴ�.");
				System.out.println("�̸�\t�ּ�\t\t��ȭ��ȣ\t");
				
				for(int i = 0; i < count; i++) {
					System.out.println(name[i] + "\t" + address[i] + "\t" + tel[i]);
				}
				
				break;
				
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				break;
				
			default :
				System.out.println("�޴��� �ٽ� �������ּ���.");
				break;
			}
		}
	}
}
