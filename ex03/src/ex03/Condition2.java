package ex03;

import java.util.Scanner;

public class Condition2 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		
		switch(time) {
		case 6 : 
			System.out.println("�Ͼ����!");
			break;
		case 7 : 
			System.out.println("ȸ��� ����ϼ���!");
			break;
		case 13 : 
			System.out.println("���ɽĻ��ϼ���!");
			break;
		case 18 : 
			System.out.println("����ϼ���!");
			break;
		}
	}
}
