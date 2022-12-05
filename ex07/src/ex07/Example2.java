package ex07;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		Area a = new Area();
		
		int x;
		int y;
		double z;
		int menu;
		
		boolean run = true;
		
		System.out.println("�ȳ��ϼ��� ������ ������ ���ϴ� �ý����Դϴ�. �Ʒ��� �׸� �� �������ּ���.");
		
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.���簢�� | 2.���簢�� | 3.�� | 0.����");
			System.out.println("---------------------------------------");
			System.out.print("�������ּ���. : ");
			menu = sc.nextInt();
			System.out.println("");
			
			switch(menu) {
			case 1 : 
				System.out.println("���簢���� ���̸� ���ϴ� ���Դϴ�.");
				System.out.print("�� ���� ���� �Է����ּ��� : ");
				x = sc.nextInt();
				System.out.printf("�Ѻ��� ���̰� %d�� ���簢���� ���̴� %d �Դϴ�.\n", x, a.area(x));
				System.out.println("");
				break;
			case 2 : 
				System.out.println("���簢���� ���̸� ���ϴ� ���Դϴ�.");
				System.out.print("������ ���̸� �Է����ּ���. : ");
				x = sc.nextInt();
				System.out.print("������ ���̸� �Է����ּ���. : ");
				y = sc.nextInt();
				System.out.printf("���� %d, ���� %d�� ���簢���� ���̴� %d �Դϴ�.\n", x, y, a.area(x, y));
				System.out.println("");
				break;
			case 3 :
				System.out.println("���� ���̸� ���ϴ� ���Դϴ�.");
				System.out.print("�������� �Է����ּ���. : ");
				z = sc.nextInt();
				System.out.printf("�������� %.0f�� ���� ���̴� %.2f �Դϴ�.\n", z, a.area(z));
				System.out.println("");
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default : 
				System.out.println("�޴��� �ٽ� �������ּ���.\n");
				break;
			}
		}
	}
}
