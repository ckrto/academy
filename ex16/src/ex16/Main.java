package ex16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("-------------------------");
			System.out.println("1.�а�����");
			System.out.println("2.����Ÿ�԰���");
			System.out.println("3.�л�����");
			System.out.println("4.��������");
			System.out.println("0.���α׷� ����");
			System.out.println("-------------------------");
			
			int menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("\n");
			
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
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���\n");
				break;
			}
			
		}
	}
}
