package ex09;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		int a;
		
		while(true) {
			try {
				System.out.print("������ �Է����ּ��� : ");
				a = sc.nextInt();
				if(a==0) {
					break;
				}
				System.out.println("�Է��� ������ : " + a);
			}
			catch (Exception e){ // try�� �ϴ� ���������� catch���� �����϶� 
								 // Exception�� ����ó���� ���� Ŭ����(�ȿ� ��� ����ó�� ����� �������)
				System.out.println("���ڰ� �ƴմϴ�.");
				break;
			}
		}
	}
}
