package ex11;

import java.util.Scanner;

import Sale.Example2;
import Student.Example1;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int menu;
		
		boolean run = true;
		
		while(run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.�л����� ���α׷�");
			System.out.println("2.������� ���α׷�");
			System.out.println("0.���α׷� ����");
			System.out.println("--------------------------------------------------");
			System.out.print("������ �۾��� �������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(menu) {
			case 1 :
				Example1.execute();
				break;
			case 2 :
				Example2.execute();
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
