package ex06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			
		String name;
			
		int menu;
				
		boolean run = true;
				
		while(run) {
			System.out.println("�ȳ��ϼ��� �����ε� ���� �ý����Դϴ�.");
			System.out.println("�Ʒ��� �׸� �� �����Ͽ� �ּ���.");
			System.out.println("-----------------------");
			System.out.println("1.������ �����ε� ����");
			System.out.println("2.�ڵ��� ���� �ý���");
			System.out.println("3.�������� �ý���");
			System.out.println("4.��ǰ���� �ý���");
			System.out.println("-----------------------");				
			System.out.print("������ �ּ���. : ");
			menu = sc.nextInt();
			
			System.out.println("");
				
				switch(menu) {
				case 1 :
					Example1.execute();
					break;
				case 2 :
					Example2.execute();
					break;
				case 3 :
					Example3.execute();
					break;
				case 4 : 
					Example4.execute();
					break;
				case 0 :
					run = false;
					System.out.println("���α׷��� ���� �մϴ�.");
					break;
					
			}
		}
	}

}
